package com.charlotte.carservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.charlotte.carservice.Beans.*;



public class LoadServicetypeDetailsDao {
	public servicing_typeBean LoadServicetypedetails(String servicename){
		servicing_typeBean sout=null;
    try { 
    	System.out.println("service name is "+servicename);
    	System.out.println("inside load servicetype dao");
    	Connection connection = null;
   	 PreparedStatement stmt = null;
   	 ProductionConnectionData connectionData=new ProductionConnectionData();
   	  connection = connectionData.getConnection();
   	  System.out.println("service name is "+servicename);
    	   	           
          String query = "select estimated_time,estimated_price,max_limit_per_day from servicing_type where service_name = ?;";
        
        stmt = connection.prepareStatement(query);
        stmt.setString(1,servicename );
        ResultSet rs = stmt.executeQuery();
        while (rs.next())
        {   System.out.println("fetching the servicetype details for servicetype "+servicename);
        	float  time = Float.parseFloat(rs.getString(1));
        	float price = Float.parseFloat(rs.getString(2));
        	int limit= Integer.parseInt(rs.getString(3));
        	        	
        	System.out.println("servicing limit is "+limit);
           sout = new servicing_typeBean(servicename, time, price, limit);
           return sout;
        }
        
              
    } catch (SQLException ex) {
        
        System.out.println("in exception- load profile dao");
             
        return sout;
    }
    return sout;
	}

}
