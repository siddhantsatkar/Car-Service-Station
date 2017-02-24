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

import com.charlotte.carservice.Beans.ServiceSlotBean;
import com.charlotte.carservice.dao.UserDao;
import com.charlotte.carservice.model.Admin;

/**
 * Servlet implementation class DeleteBooking
 */
@WebServlet("/DeleteBooking")
public class DeleteBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String str="";
		System.out.println("---Test--"+request.getParameter("refNo1"));
		ServiceSlotBean serviceslot=new ServiceSlotBean();
		serviceslot.setBooking_ref_no(Integer.parseInt(request.getParameter("refNo1")));
		/*serviceslot.setStatus(request.getParameter("status"));
		serviceslot.setTime_slot(Float.parseFloat(request.getParameter("timeSlot1")));*/
		HttpSession session=request.getSession();
		@SuppressWarnings("unchecked")
		List<ServiceSlotBean> myBookings=(ArrayList<ServiceSlotBean>) session.getAttribute("bookings");
		int slot=myBookings.indexOf(serviceslot);
		System.out.println("Dummy----Session---"+myBookings.indexOf(serviceslot));
		ServiceSlotBean oldServiceSlot=myBookings.get(slot);
		UserDao userDao=new UserDao();
		if(userDao.isDeleted(request.getParameter("refNo1")))
			{
				myBookings.remove(slot);
				//pendingServicings.add(slot, serviceslot);
				session.setAttribute("bookings", myBookings);
				str="Booking cancelled for the booking reference number - "+request.getParameter("refNo1");
			}
			else
				str="There was some error while deleting booking ref no. -"+request.getParameter("refNo1")+". Kindly Try After some time.";
		
		request.setAttribute("errorBookingDetails",str);
		RequestDispatcher rd = null;
		rd=request.getRequestDispatcher("/index.jsp");
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
