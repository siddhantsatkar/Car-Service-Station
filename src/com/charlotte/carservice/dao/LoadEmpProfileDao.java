package com.charlotte.carservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.charlotte.carservice.Beans.*;



public class LoadEmpProfileDao {
	public employeeBean LoadEmpProfileData(String empid){
		employeeBean eout=null;
    try {  
    	System.out.println("inside load employee profile dao");
    	Connection connection = null;
   	 PreparedStatement stmt = null;
   	 ProductionConnectionData connectionData=new ProductionConnectionData();
   	  connection = connectionData.getConnection();
    	   	           
          String query = "select service_name,name from employee where empid = ?;";
        
        stmt = connection.prepareStatement(query);
        stmt.setString(1,empid );
        ResultSet rs = stmt.executeQuery();
        while (rs.next())
        {   System.out.println("fetching the customer details for employee id"+empid);
        	String  servicename = rs.getString(1);
        	String empname = rs.getString(2);
        	eout = new employeeBean(empid, empname,  servicename);
        	System.out.println("got the data for employee");
           return eout;
        }
        
              
    } catch (SQLException ex) {
        
        System.out.println("in exception- load profile dao");
             
        return eout;
    }
    return eout;
	}

}
