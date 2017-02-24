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
import com.charlotte.carservice.Beans.StockBean;
import com.charlotte.carservice.Beans.UserBean;
import com.charlotte.carservice.Beans.employeeBean;
import com.charlotte.carservice.Beans.servicing_typeBean;
import com.mysql.jdbc.Statement;

/**
 * @author Pritam
 *
 */
public class AdminDao {

	public List<ServiceSlotBean> getPendingServicingSlots() {
		// TODO Auto-generated method stub
		 List<ServiceSlotBean> pendingServicingSlots=new ArrayList<ServiceSlotBean>();
		 Connection connection = null;
	   	 PreparedStatement stmt = null;
	   	 ProductionConnectionData connectionData=new ProductionConnectionData();
	   	 connection = connectionData.getConnection();
	   	 Date date = new Date();
	   	 java.sql.Date date1=new java.sql.Date(date.getTime());
	   	 String query = null;
	     query = "select Booking_ref_no, Time_slot,status from service_slot where Booking_date=? and status!='Picked up' order by booking_ref_no asc";
	     //     System.out.println("123");   
	     try {
			stmt = connection.prepareStatement(query);
			stmt.setDate(1, date1);
			//stmt.setString(2, "COMPLETED");
			ResultSet rs=stmt.executeQuery();
			int i=0;
			while(rs.next())
			{
				ServiceSlotBean serviceSlot=new ServiceSlotBean();
				serviceSlot.setBooking_ref_no(rs.getInt(1));
				serviceSlot.setStatus(rs.getString(3));
				serviceSlot.setTime_slot(rs.getFloat(2));
				pendingServicingSlots.add(serviceSlot);
				System.out.println("Srvice-"+i+" = "+pendingServicingSlots.get(i).getBooking_ref_no());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pendingServicingSlots;
	}

	public boolean isStatusUpdated(ServiceSlotBean serviceslot) {
		// TODO Auto-generated method stub
		Connection connection = null;
	   	 PreparedStatement stmt = null;
	   	 ProductionConnectionData connectionData=new ProductionConnectionData();
	   	 connection = connectionData.getConnection();
	   	 String query="UPDATE service_slot SET status=? where Booking_ref_no=?";
	   	try {
			stmt = connection.prepareStatement(query);
			stmt.setString(1, serviceslot.getStatus());
			stmt.setInt(2, serviceslot.getBooking_ref_no());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<ServiceSlotBean> getFinishedServicingSlots() {
		// TODO Auto-generated method stub
		List<ServiceSlotBean> finishedServicingSlots=new ArrayList<ServiceSlotBean>();
		 Connection connection = null;
	   	 PreparedStatement stmt = null;
	   	 ProductionConnectionData connectionData=new ProductionConnectionData();
	   	 connection = connectionData.getConnection();
	   	 Date date = new Date();
	   	 java.sql.Date date1=new java.sql.Date(date.getTime());
	   	 String query = null;
	     query = "select s.Booking_ref_no, s.Time_slot,s.status,s.service_name "
	     		+ "from service_slot s where s.Booking_date=? and s.status='Picked up' "
	     		+ "and s.booking_ref_no not in(select booking_ref_no from invoice) "
	     		+ "order by booking_ref_no asc";
	     //     System.out.println("123");   
	     try {
			stmt = connection.prepareStatement(query);
			stmt.setDate(1, date1);
			//stmt.setString(2, "COMPLETED");
			ResultSet rs=stmt.executeQuery();
			int i=0;
			while(rs.next())
			{
				ServiceSlotBean serviceSlot=new ServiceSlotBean();
				serviceSlot.setBooking_ref_no(rs.getInt(1));
				serviceSlot.setStatus(rs.getString(3));
				serviceSlot.setTime_slot(rs.getFloat(2));
				serviceSlot.setService_name(rs.getString(4));
				serviceSlot.setInvoiceNo(0);
				finishedServicingSlots.add(serviceSlot);
				System.out.println("Srvice-"+i+" = "+finishedServicingSlots.get(i).getBooking_ref_no());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return finishedServicingSlots;
	}
	
	public int addStock(StockBean s)
	{
		try {
			Connection connection = null;
	    	 PreparedStatement stmt = null;
	    	 ProductionConnectionData connectionData=new ProductionConnectionData();
	    	  connection = connectionData.getConnection();
	    	 String query = null;
	          query = "insert into Stock values(?,?,?,?)";
	           //System.out.println("123");   
	        stmt = connection.prepareStatement(query);
	        //System.out.println("456");   
	        stmt.setString(1, s.getStock_id());
	        stmt.setInt(2, s.getQuantity());
	        stmt.setFloat(3, s.getPrice());
	        stmt.setString(4, s.getName());
	        stmt.executeUpdate();
	        return 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception in insert stock method");
			return 1;
		}
		
		
	}
	public int addEmployee(employeeBean emp)
	{
		
		try {
			Connection connection = null;
	    	 PreparedStatement stmt = null;
	    	 ProductionConnectionData connectionData=new ProductionConnectionData();
	    	  connection = connectionData.getConnection();
	    	 String query = null;
	          query = "insert into employee values(?,?,?)";
	           //System.out.println("123");   
	        stmt = connection.prepareStatement(query);
	        System.out.println(emp.getEmpId()); 
	        System.out.println(emp.getName());
	        System.out.println(emp.getSevice_name());
	        stmt.setString(1, emp.getEmpId());
	        stmt.setString(2, emp.getName());
	        stmt.setString(3, emp.getSevice_name());
	        stmt.executeUpdate();
	        return 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception in add employee method");
			return 1;
		}
	}
	public int addServiceType(servicing_typeBean s)
	{
		try {
			Connection connection = null;
	    	 PreparedStatement stmt = null;
	    	 ProductionConnectionData connectionData=new ProductionConnectionData();
	    	  connection = connectionData.getConnection();
	    	 String query = null;
	          query = "insert into servicing_type values(?,?,?,?)";
	           //System.out.println("123");   
	        stmt = connection.prepareStatement(query);
	        //System.out.println("456");   
	        stmt.setString(1, s.getService_name());
	        stmt.setFloat(2, s.getEstimated_time());
	        stmt.setFloat(3, s.getEstimated_price());
	        stmt.setInt(4, s.getMax_limit_per_day());
	        stmt.executeUpdate();
	        return 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception in insert service type method");
			return 1;
		}
		
		
	}

	public boolean isValidAdmin(UserBean userBean) {
		// TODO Auto-generated method stub
		try { 
			System.out.println("inside addcustomer function");
	    	Connection connection = null;
	    	PreparedStatement stmt = null;
	    	ProductionConnectionData connectionData=new ProductionConnectionData();
	    	  connection = connectionData.getConnection();
	    	 String query = null;
	          query = "select * from Admin where email_id=? and password=?";
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

	public List<StockBean> getStocks(String serviceCode) {
		// TODO Auto-generated method stub
		List<StockBean> stocks=new ArrayList<StockBean>();
		Connection connection = null;
    	PreparedStatement stmt = null;
    	ProductionConnectionData connectionData=new ProductionConnectionData();
    	  connection = connectionData.getConnection();
    	 String query = null;
          query = "select * from stock where stock_id like ?";
           //System.out.println("123");   
        try {
			stmt = connection.prepareStatement(query);
			stmt.setString(1, serviceCode+"%");
	        //stmt.setString(2, userBean.getPassword());
	       
	        //System.out.println("abc");   
	        ResultSet rs=stmt.executeQuery();
	        while(rs.next())
	        {
	        	StockBean stock=new StockBean(rs.getString(1), rs.getInt(2), rs.getFloat(3), rs.getString(4));
	        	stocks.add(stock);
	        	//rs.get
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //System.out.println("456");   
        
		return stocks;
	}

	public int isInvoiceGenerated(List<StockBean> addedStocks, int booking_ref_no, String serviceName) {
		// TODO Auto-generated method stub
		Connection connection1 = null;
    	PreparedStatement stmt1 = null;
    	ProductionConnectionData connectionData=new ProductionConnectionData();
    	 connection1 = connectionData.getConnection();
    	 String query1 = null;
    	 int invoiceNumber=-1;
    	 float totalCost=getEstimatedPrice(booking_ref_no);
    	 System.out.println("-- Estimated is - "+totalCost);
    	 for(int i=0;i<addedStocks.size();i++)
    	 {
    		 totalCost+=addedStocks.get(i).getPrice()*addedStocks.get(i).getQuantity();
    	 }
    	 System.out.println("totalCost is - "+totalCost);
    	 invoiceNumber=insertIntoInvoice(booking_ref_no,totalCost,serviceName);
          query1 = "insert into invoice_details values (?,?,?)";
          System.out.println("Invoice Number is - "+invoiceNumber); 
        try {
			stmt1 = connection1.prepareStatement(query1);
			for(int i=0;i<addedStocks.size();i++)
	     	 {
	     		 stmt1.setString(1, addedStocks.get(i).getStock_id());
	     		 stmt1.setInt(2, invoiceNumber);
	     		 stmt1.setInt(3, addedStocks.get(i).getQuantity());
	     		 stmt1.addBatch();
	     	 }
			stmt1.executeBatch();
			stmt1.close();
			connection1.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return invoiceNumber;
	}

	private int insertIntoInvoice(int booking_ref_no, float totalCost, String serviceName) {
		// TODO Auto-generated method stub
		int invoiceNo=0;
		Connection connection = null;
    	PreparedStatement stmt = null;
    	ProductionConnectionData connectionData=new ProductionConnectionData();
    	  connection = connectionData.getConnection();
    	 String query = null;
    	 query = "Insert into invoice (service_types,Price_of_services,Booking_ref_no) values (?,?,?)";
    	 try {
			stmt=connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, serviceName);
			stmt.setFloat(2, totalCost);
			stmt.setInt(3, booking_ref_no);
			//stmt.executeUpdate();
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
			{
				
				System.out.println("-------Statement for Get Generated Keys-----------");
				invoiceNo= (int) rs.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		return invoiceNo;
	}

	private float getEstimatedPrice(int booking_ref_no) {
		// TODO Auto-generated method stub
		float price=0;
		Connection connection = null;
    	PreparedStatement stmt = null;
    	ProductionConnectionData connectionData=new ProductionConnectionData();
    	  connection = connectionData.getConnection();
    	 String query = null;
    	 query = "select Estimated_price from servicing_type natural join service_slot where booking_ref_no=?";
         
         try {
 			stmt = connection.prepareStatement(query);
 			stmt.setInt(1, booking_ref_no);
 			ResultSet rs=stmt.executeQuery();
	        if(rs.next())
	        {
	        	
	        	price= rs.getFloat(1);
	        }
	        rs.close();
	        stmt.close();
         }catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		return price;
	}
	public int validatestockid(String stockId) {
		// TODO Auto-generated method stub
		try {
			 System.out.println("Stock id is "+stockId);
				Connection connection = null;
		    	 PreparedStatement stmt = null;
		    	 ProductionConnectionData connectionData=new ProductionConnectionData();
		    	  connection = connectionData.getConnection();
		    	 String query = null;
		          query = "select * from stock where Stock_id=?";
		           System.out.println("123");   
		        stmt = connection.prepareStatement(query);
		         stmt.setString(1, stockId);
		        ResultSet rs=stmt.executeQuery();
		        while(rs.next())
		        {
		          return 3;	
		        }
		        
		        System.out.println("valid Stock id");
		        return 0;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("exception in validate stock id method");
				e.printStackTrace();
				return 1;
			}
	}
	public int validatestockname(String name) {
		// TODO Auto-generated method stub
		try {
			 System.out.println("Stock name is "+name);
				Connection connection = null;
		    	 PreparedStatement stmt = null;
		    	 ProductionConnectionData connectionData=new ProductionConnectionData();
		    	  connection = connectionData.getConnection();
		    	 String query = null;
		          query = "select * from stock where name=?";
		           System.out.println("123");   
		        stmt = connection.prepareStatement(query);
		         stmt.setString(1, name);
		        ResultSet rs=stmt.executeQuery();
		        while(rs.next())
		        {
		          return 3;	
		        }
		        
		        System.out.println("valid Stock name");
		        return 0;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("exception in validate stock name method");
				e.printStackTrace();
				return 1;
			}
		}
	
	

}
