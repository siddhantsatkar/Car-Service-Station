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

import com.charlotte.carservice.Beans.servicing_typeBean;
import com.charlotte.carservice.Beans.vehiclesBean;
import com.charlotte.carservice.model.UserCars;
import com.mysql.fabric.xmlrpc.base.Array;

/**
 * Servlet implementation class ServicingDetails
 */
@WebServlet("/ServicingDetails")
public class ServicingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicingDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		servicing_typeBean servicingType=null;
		RequestDispatcher rd = null;
		System.out.println("Tada----"+request.getParameter("SlotDate"));
		if(request.getParameter("SlotDate")=="")
		{
			request.setAttribute("bookingError", "Please select Date first.");
		}
		else
		{
			
			UserCars userCars=new UserCars();
			System.out.println("Selected VIN is - "+request.getParameter("servicingType"));
			
			servicingType= new servicing_typeBean();
			servicingType.setService_name(request.getParameter("servicingType"));
			@SuppressWarnings("unchecked")
			List<servicing_typeBean> serviceTypes=(List<servicing_typeBean>) session.getAttribute("ServicingTypes");
			int index=serviceTypes.indexOf(servicingType);
			
			List<Float> timeSlots=new ArrayList<Float>();
			servicingType=serviceTypes.get(index);
			int totalSlots=servicingType.getMax_limit_per_day();
			float duration=servicingType.getEstimated_time();
			float slot=(float) 11.00;
			timeSlots.add(slot);
			for(int i=0;i<totalSlots-1;i++)
			{
				timeSlots.add(slot+duration);
				slot+=duration;
			}
			session.setAttribute("timeSlots", timeSlots);
			session.setAttribute("slotDate", request.getParameter("SlotDate"));
		}
		session.setAttribute("selectedType", servicingType);
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
