package com.charlotte.carservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.charlotte.carservice.Beans.vehiclesBean;

public class CustAddCarDao {
 public int addCar(vehiclesBean v )
 {
	 try {
		 System.out.println("customer email id is "+v.getEmail_id());
			Connection connection = null;
	    	 PreparedStatement stmt = null;
	    	 ProductionConnectionData connectionData=new ProductionConnectionData();
	    	  connection = connectionData.getConnection();
	    	 String query = null;
	          query = "insert into vehicles values(?,?,?,?,?,?)";
	           System.out.println("123");   
	        stmt = connection.prepareStatement(query);
	          
	        stmt.setString(1, v.getVin_no());
	        System.out.println("vin number is "+v.getVin_no());
	        stmt.setString(2, v.getCar_no());
	        System.out.println("car no"+v.getCar_no()+"      "+v.getCar_type()+""+v.getBrand_name()+" "+v.getCar_model()+" "+v.getEmail_id());
	        stmt.setString(3, v.getCar_type());
	        stmt.setString(4, v.getBrand_name());
	        stmt.setString(5, v.getCar_model());
	        stmt.setString(6, v.getEmail_id());
	        stmt.executeUpdate();
	        System.out.println("inserted the car details");
	        return 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception in add car method");
			e.printStackTrace();
			return 1;
		}
		
			 }

public int validatevinno(String vinno) {
	// TODO Auto-generated method stub
	
	try {
		 System.out.println("vin no is "+vinno);
			Connection connection = null;
	    	 PreparedStatement stmt = null;
	    	 ProductionConnectionData connectionData=new ProductionConnectionData();
	    	  connection = connectionData.getConnection();
	    	 String query = null;
	          query = "select * from vehicles where vin_no=?";
	           System.out.println("123");   
	        stmt = connection.prepareStatement(query);
	         stmt.setString(1, vinno);
	        ResultSet rs=stmt.executeQuery();
	        while(rs.next())
	        {
	          return 2;	
	        }
	        
	        System.out.println("valid vinno");
	        return 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception in validate vinno method");
			e.printStackTrace();
			return 1;
		}
		

}

public int validatecarno(java.lang.String carnumber) {
	// TODO Auto-generated method stub
	try {
		 System.out.println("car no is "+carnumber);
			Connection connection = null;
	    	 PreparedStatement stmt = null;
	    	 ProductionConnectionData connectionData=new ProductionConnectionData();
	    	  connection = connectionData.getConnection();
	    	 String query = null;
	          query = "select * from vehicles where car_no=?";
	           System.out.println("123");   
	        stmt = connection.prepareStatement(query);
	         stmt.setString(1, carnumber);
	        ResultSet rs=stmt.executeQuery();
	        while(rs.next())
	        {
	          return 3;	
	        }
	        
	        System.out.println("valid car number");
	        return 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception in validate car number method");
			e.printStackTrace();
			return 1;
		}
}
}
