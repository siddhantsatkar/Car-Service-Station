package com.charlotte.carservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.charlotte.carservice.Beans.*;



public class LoadStkDetailsDao {
	public StockBean LoadStkDetails(String stkname){
		StockBean sout=null;
    try {  
    	System.out.println("inside load stock details dao");
    	Connection connection = null;
   	 PreparedStatement stmt = null;
   	 ProductionConnectionData connectionData=new ProductionConnectionData();
   	  connection = connectionData.getConnection();
    	   	           
          String query = "select name,price,quantity,Stock_id from stock where name = ?;";
        
        stmt = connection.prepareStatement(query);
        stmt.setString(1,stkname );
        ResultSet rs = stmt.executeQuery();
        while (rs.next())
        {   System.out.println("fetching the stock details for stock"+stkname);
        	String  stockname = rs.getString(1);
        	float stockprice = Float.parseFloat(rs.getString(2));
        	int stockquantity = Integer.parseInt(rs.getString(3));
        	String stockid = rs.getString(4);
        	
        	sout = new StockBean(stockid, stockquantity, stockprice, stockname);
        	System.out.println("got the stock details");
           return sout;
        }
        
              
    } catch (SQLException ex) {
        
        System.out.println("in exception- load profile dao");
             
        return sout;
    }
    return sout;
	}

}
