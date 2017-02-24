package com.charlotte.carservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.charlotte.carservice.Beans.*;


public class UpdateServiceTypeDao {
	public int updateServicing(servicing_typeBean e) 
    { 
              try { 
            	  System.out.println("inside service type update profile dao");
            	  Connection connection = null;
            	   	 PreparedStatement stmt = null;
            	   	 ProductionConnectionData connectionData=new ProductionConnectionData();
            	   	  connection = connectionData.getConnection();
        	
        	String query = "update servicing_type set Estimated_time=?,Estimated_price=?,Max_limit_per_day=? where service_name = ?";
                 
            stmt = connection.prepareStatement(query);
            stmt.setFloat(1, e.getEstimated_time());
            stmt.setFloat(2, e.getEstimated_price());
            stmt.setInt(3, e.getMax_limit_per_day());
            stmt.setString(4, e.getService_name());
            
            stmt.executeUpdate();
            System.out.println("updated the service type file");
               return 0;	
                  
        } catch (SQLException ex) {
            
            System.out.println("in update servicetype exception dao");
            return 1;
        }
       
    }
    
}
