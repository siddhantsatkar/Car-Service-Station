package com.charlotte.carservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.charlotte.carservice.Beans.*;


public class UpdateStkDao {
	public int updateStock(StockBean sout) { 
    { 
              try { 
            	  System.out.println("inside stock update dao");
            	  Connection connection = null;
            	   	 PreparedStatement stmt = null;
            	   	 ProductionConnectionData connectionData=new ProductionConnectionData();
            	   	  connection = connectionData.getConnection();
        	
        	String query = "update stock set price=?,quantity=? where name = ?";
                 
            stmt = connection.prepareStatement(query);
            stmt.setFloat(1, sout.getPrice());
            stmt.setFloat(2, sout.getQuantity());
            stmt.setString(3, sout.getName());
            
            stmt.executeUpdate();
            System.out.println("updated the Stock");
               return 0;	
                  
        } catch (SQLException ex) {
            
            System.out.println("in update stock exception dao");
            return 1;
        }
       
    }
    
   }
 }

	
    

