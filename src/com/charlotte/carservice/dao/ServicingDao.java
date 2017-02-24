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

import com.charlotte.carservice.Beans.FeedbackBean;
import com.charlotte.carservice.Beans.InvoiceDetails;
import com.charlotte.carservice.Beans.ServiceSlotBean;
import com.charlotte.carservice.Beans.servicing_typeBean;
import com.mysql.jdbc.Statement;

/**
 * @author Pritam
 *
 */
public class ServicingDao {

	public List<servicing_typeBean> getServicingTypes() {
		// TODO Auto-generated method stub
		List<servicing_typeBean> servicingTypes=new ArrayList<servicing_typeBean>();
		 Connection connection = null;
	   	 PreparedStatement stmt = null;
	   	 ProductionConnectionData connectionData=new ProductionConnectionData();
	   	 connection = connectionData.getConnection();
	   	 
	   	 String query = null;
	     query = "select * from servicing_type";
	     //     System.out.println("123");   
	     try {
			stmt = connection.prepareStatement(query);
			//stmt.setDate(1, date1);
			//stmt.setString(2, "COMPLETED");
			ResultSet rs=stmt.executeQuery();
			//int i=0;
			while(rs.next())
			{
				servicing_typeBean serviceType=new servicing_typeBean(rs.getString(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4));
				servicingTypes.add(serviceType);
				//System.out.println("Srvice-"+i+" = "+servicingTypes.get(i).getBooking_ref_no());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return servicingTypes;
	}

	public ServiceSlotBean bookASlot(ServiceSlotBean slot) {
		// TODO Auto-generated method stub
		slot.setBooking_ref_no(0);
		Connection connection = null;
	    PreparedStatement stmt = null;
	    ProductionConnectionData connectionData=new ProductionConnectionData();
	    connection = connectionData.getConnection();	 
	    String query = null;
	    query="select empid from employee where service_name=? and empid not in(select empid from service_slot where Booking_date=? and time_slot=? and service_name=?)";
	    String empId=getEmpId(query,slot);
	    System.out.println("++"+empId);
	    if(empId==null)
	    {
	    	
	    }else
	    {
	    	query = "insert into service_slot(Time_slot,status,empid,service_name,Booking_date,Vin_no,email_id) values(?,?,?,?,?,?,?)";
			try {
				
				stmt=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				stmt.setFloat(1, slot.getTime_slot());
				stmt.setString(2, slot.getStatus());
				stmt.setString(3, empId);
				stmt.setString(4, slot.getService_name());
				stmt.setDate(5, slot.getBooking_date());
				stmt.setString(6, slot.getVin_no());
				stmt.setString(7, slot.getEmail());
				stmt.execute();
				ResultSet rs=stmt.getGeneratedKeys();
				if(rs.next())
					slot.setBooking_ref_no((int) rs.getLong(1));
					
				//return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    return slot;
	}

	private String getEmpId(String query, ServiceSlotBean slot) {
		// TODO Auto-generated method stub
		Connection connection = null;
	    PreparedStatement stmt = null;
	    ProductionConnectionData connectionData=new ProductionConnectionData();
	    connection = connectionData.getConnection();
	    try {
			stmt=connection.prepareStatement(query);
			stmt.setString(1, slot.getService_name());
			stmt.setDate(2, slot.getBooking_date());
			stmt.setFloat(3, slot.getTime_slot());
			stmt.setString(4,slot.getService_name());
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				System.out.println("Emp Id is" + rs.getString(1));
				String id=rs.getString(1);
				return id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean isFeedbackUpdated(FeedbackBean feedback) {
		// TODO Auto-generated method stub
		String query="insert into feedback_form values(?,?,?,?)";
		Connection connection = null;
	    PreparedStatement stmt = null;
	    System.out.println("Feedback Form Updating");
	    ProductionConnectionData connectionData=new ProductionConnectionData();
	    connection = connectionData.getConnection();
	    try {
			System.out.println("Before update--");
	    	stmt=connection.prepareStatement(query);
	    	System.out.println("After update--");
			stmt.setString(1, feedback.getName());
			stmt.setString(2, feedback.getComment());
			stmt.setInt(3, feedback.getRating());
			stmt.setInt(4, feedback.getInvoiceNumber()); 
			int count=stmt.executeUpdate();
			System.out.println("Count is updated to - "+count);
			if(count>0)
				return true;
	    }catch (SQLException e) {
			// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }	
		return false;
	}

	public FeedbackBean getFeedback(String parameter) {
		// TODO Auto-generated method stub
		FeedbackBean feedback = new FeedbackBean();
		String query="select feedback_form.Name, feedback_form.comment,feedback_form.rating,feedback_form.invoice_number"
				+ " from feedback_form natural join invoice natural join service_slot "
				+ "where service_slot.booking_ref_no=?";
		System.out.println("param is -"+parameter);
		Connection connection = null;
	    PreparedStatement stmt = null;
	    ProductionConnectionData connectionData=new ProductionConnectionData();
	    connection = connectionData.getConnection();
	    try {
			stmt=connection.prepareStatement(query);
			stmt.setInt(1, Integer.parseInt(parameter));
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next())
			{
				feedback.setName(rs.getString(1));
				feedback.setComment(rs.getString(2));
				feedback.setInvoiceNumber(rs.getInt(4));
				feedback.setRating(rs.getInt(3));
				System.out.println("Feedback Dao-- "+feedback);
				return feedback;
			}
	    }catch (SQLException e) {
			// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }	
		
		
		return null;
	}

	public List<InvoiceDetails> getInvoiceDetails(int invoiceNumber) {
		// TODO Auto-generated method stub
		String query="select i.stock_id,s.name,i.quantity,s.price,i.quantity*s.price "
				+ "from invoice_details i,stock s "
				+ "where i.invoice_number=? and i.stock_id=s.stock_id";
		List<InvoiceDetails> invoiceDetails=new ArrayList<InvoiceDetails>();
		invoiceDetails.add(getServicingDetails(invoiceNumber));
		Connection connection = null;
	    PreparedStatement stmt = null;
	    ProductionConnectionData connectionData=new ProductionConnectionData();
	    connection = connectionData.getConnection();
	    try {
			stmt=connection.prepareStatement(query);
			stmt.setInt(1, invoiceNumber);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next())
			{
				InvoiceDetails invoiceItem=new InvoiceDetails();
				invoiceItem.setItemId(rs.getString(1));
				invoiceItem.setItemName(rs.getString(2));
				invoiceItem.setQuantity(rs.getInt(3));
				
				invoiceItem.setUnitPrice(rs.getFloat(4));
				invoiceItem.setExtendedPrice(rs.getFloat(5));
				System.out.println("Feedback Dao-- "+invoiceItem);
				invoiceDetails.add(invoiceItem);
				//return feedback;
			}
	    }catch (SQLException e) {
			// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }	
		
		return invoiceDetails;
	}

	private InvoiceDetails getServicingDetails(int invoiceNumber) {
		// TODO Auto-generated method stub
		String str="select s.service_name,s.Estimated_price from servicing_type s  "
				+ "where s.service_name="
				+ "(select ss.service_name from service_slot ss, invoice i "
				+ "where ss.booking_ref_no=i.booking_ref_no and i.invoice_number=?)";
		Connection connection = null;
	    PreparedStatement stmt = null;
	    ProductionConnectionData connectionData=new ProductionConnectionData();
	    InvoiceDetails invoiceItem=new InvoiceDetails();
	    connection = connectionData.getConnection();
	    try {
			stmt=connection.prepareStatement(str);
			stmt.setInt(1, invoiceNumber);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next())
			{
				
				invoiceItem.setItemId(rs.getString(1));
				invoiceItem.setItemName(rs.getString(1));
				invoiceItem.setQuantity(1);
				
				invoiceItem.setUnitPrice(rs.getFloat(2));
				invoiceItem.setExtendedPrice(rs.getFloat(2));
				System.out.println("invoiceDao-- "+invoiceItem);
				//invoiceDetails.add(invoiceItem);
				//return feedback;
			}
	    }catch (SQLException e) {
			// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }	
		return invoiceItem;
	}
	    

}
