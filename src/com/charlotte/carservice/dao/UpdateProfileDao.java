package com.charlotte.carservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.charlotte.carservice.Beans.*;


public class UpdateProfileDao {
	public int updateCustomer(UserBean c) 
    { 
              try { 
            	  System.out.println("inside update profile dao");
            	  Connection connection = null;
            	   	 PreparedStatement stmt = null;
            	   	 ProductionConnectionData connectionData=new ProductionConnectionData();
            	   	  connection = connectionData.getConnection();
        	
        	String query = "update customers set lname=?,fname=?,Address=?,password=?,contact=? where email_id = ?";
                 
            stmt = connection.prepareStatement(query);
            stmt.setString(1, c.getfName());
            stmt.setString(2, c.getlName());
            stmt.setString(3, c.getAddress());
            stmt.setString(4, c.getPassword());
            stmt.setString(5, c.getContact());
            stmt.setString(6, c.getEmailId());
            stmt.executeUpdate();
            System.out.println("updated the profile");
               return 0;	
                  
        } catch (SQLException ex) {
            
            System.out.println("in update profile exception dao");
            return 1;
        }
       
    }
    
}
