/**
 * 
 */
package com.charlotte.carservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.charlotte.carservice.Beans.ServiceSlotBean;
import com.charlotte.carservice.Beans.UserBean;
import com.charlotte.carservice.Beans.vehiclesBean;
import com.charlotte.carservice.dao.ProductionConnectionData;

/**
 * @author Pritam
 *
 */
public class UserDao {
	//UserDao(ProductionConnectionData p) {
		//get the db connection here
	
public static  int addCustomer(UserBean u)
{
	try { 
		System.out.println("inside addcustomer function");
    	Connection connection = null;
    	 PreparedStatement stmt = null;
    	 ProductionConnectionData connectionData=new ProductionConnectionData();
    	  connection = connectionData.getConnection();
    	 String query = null;
          query = "insert into customers values(?,?,?,?,?,?)";
           System.out.println("123");   
        stmt = connection.prepareStatement(query);
        System.out.println("456");   
        stmt.setString(1, u.getEmailId());
        stmt.setString(2, u.getAddress());
        stmt.setString(3, u.getfName());
        stmt.setString(4, u.getlName());
        stmt.setString(5, u.getPassword());
        stmt.setString(6, u.getContact());
        System.out.println("abc");   
        stmt.executeUpdate();
        System.out.println("789");          
        return 0;	
              
    } catch (SQLException ex) {
        
        System.out.println("Exception in add customer method");
             
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        return 1;
    }
   

	//return 0;
	}

public boolean isValidUser(UserBean userBean) {
	// TODO Auto-generated method stub
	try { 
		System.out.println("inside isValidUser function");
    	Connection connection = null;
    	 PreparedStatement stmt = null;
    	 ProductionConnectionData connectionData=new ProductionConnectionData();
    	  connection = connectionData.getConnection();
    	 String query = null;
          query = "select * from customers where email_id=? and password=?";
           //System.out.println("123");   
        stmt = connection.prepareStatement(query);
        //System.out.println("456");   
        stmt.setString(1, userBean.getEmailId());
        stmt.setString(2, userBean.getPassword());
       
        //System.out.println("abc");   
        ResultSet rs=stmt.executeQuery();
        //System.out.println("789");
        if(rs.next())
        	return true;
        
              
    } catch (SQLException ex) {
        
        System.out.println("Exception in add customer method");
             
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
    }
	return false;
}

public List<vehiclesBean> getVehicles(String emailId) {
	// TODO Auto-generated method stub
	List<vehiclesBean> vehicles=new ArrayList<vehiclesBean>();
	try { 
		System.out.println("inside getVehicles function");
    	Connection connection = null;
    	 PreparedStatement stmt = null;
    	 ProductionConnectionData connectionData=new ProductionConnectionData();
    	  connection = connectionData.getConnection();
    	 String query = null;
          query = "select * from vehicles where email_id=? order by Vin_no asc";
           //System.out.println("123");   
        stmt = connection.prepareStatement(query);
        //System.out.println("456");   
        stmt.setString(1, emailId);
        //stmt.setString(2, userBean.getPassword());
       
        //System.out.println("abc");   
        ResultSet rs=stmt.executeQuery();
        //System.out.println("789");
        while(rs.next())
		{
			vehiclesBean vehicle=new vehiclesBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			vehicles.add(vehicle);
			//System.out.println("Srvice-"+i+" = "+finishedServicingSlots.get(i).getBooking_ref_no());
		}
        
              
    } catch (SQLException ex) {
        
        System.out.println("Exception in add customer method");
             
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
    }
	return vehicles;
}
public List<ServiceSlotBean> getBookings(String emailId) {
	// TODO Auto-generated method stub
	List<ServiceSlotBean> myBookings=new ArrayList<ServiceSlotBean>();
	 Connection connection = null;
  	 PreparedStatement stmt = null;
  	 ProductionConnectionData connectionData=new ProductionConnectionData();
  	 connection = connectionData.getConnection();
  	 //Date date = new Date();
  	 //java.sql.Date date1=new java.sql.Date(date.getTime());
  	 String query = null;
    query = "select s.Booking_ref_no, s.booking_date,s.Time_slot,s.status, i.Invoice_number"+
    		" from service_slot s left join invoice i on s.booking_ref_no=i.booking_ref_no" +
    		" where s.email_id=? order by s.booking_date desc";
    //     System.out.println("123");   
    try {
		stmt = connection.prepareStatement(query);
		stmt.setString(1, emailId);
		//stmt.setString(2, "COMPLETED");
		ResultSet rs=stmt.executeQuery();
		//int i=0;
		while(rs.next())
		{
			ServiceSlotBean serviceSlot=new ServiceSlotBean();
			serviceSlot.setBooking_ref_no(Integer.parseInt(rs.getString(1)));
			serviceSlot.setStatus(rs.getString(4));
			serviceSlot.setTime_slot(rs.getFloat(3));
			serviceSlot.setBooking_date(rs.getDate(2));
			if(rs.getString(5)==null)
			{
				serviceSlot.setInvoiceNo(0);
			}
			else
			{
				serviceSlot.setInvoiceNo(rs.getInt(5));
			}
			myBookings.add(serviceSlot);
			//System.out.println("Srvice-"+i+" = "+finishedServicingSlots.get(i).getBooking_ref_no());
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return myBookings;
}

public boolean isDeleted(String booking_ref) {
	// TODO Auto-generated method stub
	String query="delete from service_slot where booking_ref_no=?";
	Connection connection = null;
 	 PreparedStatement stmt = null;
 	 ProductionConnectionData connectionData=new ProductionConnectionData();
 	 connection = connectionData.getConnection();
 	 try {
 		stmt = connection.prepareStatement(query);
 		stmt.setInt(1, Integer.parseInt(booking_ref));
 		//stmt.setString(2, "COMPLETED");
 		int count=stmt.executeUpdate();
 		//int i=0;
 		if(count==1)
 		 return true;
 		
 	} catch (SQLException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}
	return false;
}

public ServiceSlotBean getBookingDetails(String booking_ref) {
	// TODO Auto-generated method stub
	String query="select s.Booking_ref_no, s.booking_date,s.Time_slot,s.status, e.name, v.brand_name,v.Car_model  "
			+ "from service_slot s,employee e,vehicles v "
			+ "where s.booking_ref_no=? and s.Vin_No=v.Vin_no and s.empid=e.empid";
	ServiceSlotBean slot=null;
	Connection connection = null;
	 PreparedStatement stmt = null;
	 ProductionConnectionData connectionData=new ProductionConnectionData();
	 connection = connectionData.getConnection();
	 try {
		stmt = connection.prepareStatement(query);
		stmt.setInt(1, Integer.parseInt(booking_ref));
		//stmt.setString(2, "COMPLETED");
		ResultSet rs = stmt.executeQuery();
		//int i=0;
		if(rs.next())
		 {
			slot=new ServiceSlotBean();
			slot.setBooking_ref_no(Integer.parseInt(rs.getString(1)));
			slot.setBooking_date(rs.getDate(2));
			slot.setTime_slot(rs.getFloat(3));
			slot.setStatus(rs.getString(4));
			slot.setEmployeeName(rs.getString(5));
			slot.setBrandName(rs.getString(6));
			slot.setCarName(rs.getString(7));
			
		 }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return slot;
}

}
