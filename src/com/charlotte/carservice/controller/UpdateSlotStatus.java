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
import com.charlotte.carservice.model.Admin;

/**
 * Servlet implementation class UpdateSlotStatus
 */
@WebServlet("/UpdateSlotStatus")
public class UpdateSlotStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSlotStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String str="Kindly chnage the status and then click on update!!";
		System.out.println("---Test--"+request.getParameter("refNo1")+":::"+request.getParameter("timeSlot1")+";;;;"+request.getParameter("status"));
		ServiceSlotBean serviceslot=new ServiceSlotBean();
		serviceslot.setBooking_ref_no(Integer.parseInt(request.getParameter("refNo1")));
		serviceslot.setStatus(request.getParameter("status"));
		serviceslot.setTime_slot(Float.parseFloat(request.getParameter("timeSlot1")));
		HttpSession session=request.getSession();
		@SuppressWarnings("unchecked")
		List<ServiceSlotBean> pendingServicings=(ArrayList<ServiceSlotBean>) session.getAttribute("pendingServicings");
		
		int slot=pendingServicings.indexOf(serviceslot);
		System.out.println("Dummy----Session---"+pendingServicings.indexOf(serviceslot));
		ServiceSlotBean oldServiceSlot=pendingServicings.get(slot);
		if(!(oldServiceSlot.getStatus().equals(request.getParameter("status"))))
		{
			Admin admin=new Admin();
			if(admin.isStatusUpdated(serviceslot))
			{
				pendingServicings.remove(slot);
				if(serviceslot.getStatus().equals("Picked Up"))
				{
					List<ServiceSlotBean> finishedServicings=(ArrayList<ServiceSlotBean>) session.getAttribute("finishedServicings");
					finishedServicings.add(serviceslot);
				}
				else
					pendingServicings.add(slot, serviceslot);
				session.setAttribute("pendingServicings", pendingServicings);
				str="Status updated for Booking reference number - "+request.getParameter("refNo1");
			}
			else
				str="There was some error while updating status for -"+request.getParameter("refNo1")+". Kindly Try After some time.";
		}
		request.setAttribute("statusUpdated", str);
		RequestDispatcher rd = null;
		rd=request.getRequestDispatcher("/adminHome");
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
