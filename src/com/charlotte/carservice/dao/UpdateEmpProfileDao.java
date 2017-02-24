package com.charlotte.carservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.charlotte.carservice.Beans.*;


public class UpdateEmpProfileDao {
	public int updateEmployee(employeeBean e) 
    { 
              try { 
            	  System.out.println("inside employee update profile dao");
            	  Connection connection = null;
            	   	 PreparedStatement stmt = null;
            	   	 ProductionConnectionData connectionData=new ProductionConnectionData();
            	   	  connection = connectionData.getConnection();
        	
        	String query = "update employee set name=?,service_name=? where empid = ?";
                 
            stmt = connection.prepareStatement(query);
            stmt.setString(1, e.getName());
            stmt.setString(2, e.getSevice_name());
            stmt.setString(3, e.getEmpId());
            
            stmt.executeUpdate();
            System.out.println("updated the profile");
               return 0;	
                  
        } catch (SQLException ex) {
            
            System.out.println("in update profile exception dao");
            return 1;
        }
       
    }
    
}
