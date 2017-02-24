package com.charlotte.carservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.charlotte.carservice.Beans.FeedbackBean;
import com.charlotte.carservice.Beans.InvoiceDetails;
import com.charlotte.carservice.Beans.ServiceSlotBean;
import com.charlotte.carservice.dao.ServicingDao;
import com.charlotte.carservice.dao.UserDao;

/**
 * Servlet implementation class BookingDetails
 */
@WebServlet("/BookingDetails")
public class BookingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str="";
		System.out.println("---Test--"+request.getParameter("refNo1"));
		UserDao userDao=new UserDao();
		
		ServiceSlotBean serviceslot=userDao.getBookingDetails(request.getParameter("refNo1"));
		//serviceslot.setBooking_ref_no(request.getParameter("refNo1"));
		/*serviceslot.setStatus(request.getParameter("status"));
		serviceslot.setTime_slot(Float.parseFloat(request.getParameter("timeSlot1")));*/
		HttpSession session=request.getSession();
		String invoice=request.getParameter("invoice1");
		//@SuppressWarnings("unchecked")
		/*List<ServiceSlotBean> myBookings=(ArrayList<ServiceSlotBean>) session.getAttribute("bookings");
		int slot=myBookings.indexOf(serviceslot);
		System.out.println("Dummy----Session---"+myBookings.indexOf(serviceslot));
		ServiceSlotBean oldServiceSlot=myBookings.get(slot);*/
		
		
				session.setAttribute("booking", serviceslot);
				/*str="Booking cancelled for the booking reference number - "+request.getParameter("refNo1");
			
			
				str="There was some error while deleting booking ref no. -"+request.getParameter("refNo1")+". Kindly Try After some time.";
		
		request.setAttribute("errorBookingDetails",str);*/
				ServicingDao sDao=new ServicingDao();
				FeedbackBean feedback = sDao.getFeedback(request.getParameter("refNo1"));
				if(!invoice.equals("0"))
				{
					List<InvoiceDetails> invoiceDetails=sDao.getInvoiceDetails(Integer.parseInt(invoice));
					session.setAttribute("invoiceDetails", invoiceDetails);
				}
				
				System.out.println("Feedback is - "+feedback);
				request.setAttribute("Feedback", feedback);
				request.setAttribute("invoice", request.getParameter("invoice1"));
				System.out.println("Invoice is - "+request.getParameter("invoice1"));
		RequestDispatcher rd = null;
		rd=request.getRequestDispatcher("/Booking_details.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
