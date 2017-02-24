package com.charlotte.carservice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.charlotte.carservice.Beans.ServiceSlotBean;
import com.charlotte.carservice.Beans.servicing_typeBean;
import com.charlotte.carservice.Beans.vehiclesBean;
import com.charlotte.carservice.dao.ServicingDao;
import com.charlotte.carservice.model.UserCars;

/**
 * Servlet implementation class SlotBookingServlet
 */
@WebServlet("/SlotBookingServlet")
public class SlotBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SlotBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("Date-"+request.getParameter("SlotDate")+"\nTime"+request.getParameter("timepicker1"));
		HttpSession session = request.getSession();
		String email=(String) session.getAttribute("user");
		UserCars user=new UserCars();
		List<vehiclesBean> vehicles=user.getVehicles(email);
		List<ServiceSlotBean> bookings=user.getBookings(email);
		session.setAttribute("bookings", bookings);
		session.setAttribute("vehicles", vehicles);
		RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
        rd.include(request, response); 
		//Time
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("Parse Int is -" + request.getParameter("servicingSlot"));
		HttpSession session=request.getSession();
		String bookingDate=(String) session.getAttribute("slotDate");
		java.util.Date date2=new java.util.Date(bookingDate);
		System.out.println("Java Date is = "+date2);
		System.out.println("Session Date is - " + bookingDate);
		vehiclesBean vehicle=(vehiclesBean) session.getAttribute("selectedCar");
		//String[] dateArray=bookingDate.split("/");
		//@SuppressWarnings("deprecation")
		
		Date date=new Date(date2.getTime());//new Date(Integer.parseInt(dateArray[2]),Integer.parseInt(dateArray[0]),Integer.parseInt(dateArray[1]));
		System.out.println("Dats is == "+date);
		ServiceSlotBean slot=new ServiceSlotBean();
		slot.setBooking_date(date);
		slot.setEmail(vehicle.getEmail_id());
		slot.setService_name(((servicing_typeBean) session.getAttribute("selectedType")).getService_name());
		slot.setStatus("New");
		slot.setTime_slot(Float.parseFloat(request.getParameter("servicingSlot")));
		slot.setVin_no(vehicle.getVin_no());
		ServicingDao servicingDao=new ServicingDao();
		RequestDispatcher rd=null;
		slot=servicingDao.bookASlot(slot);
		if(slot.getBooking_ref_no()>0)
		{
			@SuppressWarnings("unchecked")
			List<ServiceSlotBean> bookings=(List<ServiceSlotBean>) session.getAttribute("bookings");
			if(bookings==null)
			{
				bookings=new ArrayList<ServiceSlotBean>();
				bookings.add(slot);
			}
			else
				bookings.add(0, slot);
			request.setAttribute("bookingError", "Service Slot booked successfully!! Kindly check your bookings below!!");
			session.setAttribute("bookings", bookings);
			session.removeAttribute("selectedCar");
			session.removeAttribute("selectedType");
			session.removeAttribute("slotDate");
			session.removeAttribute("timeSlots");
			session.removeAttribute("bookingError");
			rd=request.getRequestDispatcher("/index.jsp");  
	        rd.include(request, response);
		}else
		{
			session.setAttribute("bookingError", "Error Booking slot!!");
			rd=request.getRequestDispatcher("/index.jsp");  
	        rd.include(request, response);
		}
	}

}
