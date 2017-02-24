package com.charlotte.carservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.charlotte.carservice.Beans.*;



public class LoadProfileDao {
	public UserBean LoadProfileData(String emailid){
	UserBean cout=null;
    try {  
    	System.out.println("inside load profile dao");
    	Connection connection = null;
   	 PreparedStatement stmt = null;
   	 ProductionConnectionData connectionData=new ProductionConnectionData();
   	  connection = connectionData.getConnection();
    	   	           
          String query = "select lname,fname,Address,contact,password from customers where email_id = ?;";
        
        stmt = connection.prepareStatement(query);
        stmt.setString(1,emailid );
        ResultSet rs = stmt.executeQuery();
        while (rs.next())
        {   System.out.println("fetching the customer details for emailid"+emailid);
        	String  lastname = rs.getString(1);
        	String firstname = rs.getString(2);
        	String address= rs.getString(3);
        	String contact = rs.getString(4);
        	String password = rs.getString(5);
        	
        	System.out.println("customer password is "+password);
           cout = new UserBean(firstname, lastname,  emailid, address,
        		   password, contact);
           return cout;
        }
        
              
    } catch (SQLException ex) {
        
        System.out.println("in exception- load profile dao");
             
        return cout;
    }
    return cout;
	}

}
