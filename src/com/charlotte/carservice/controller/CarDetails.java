package com.charlotte.carservice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.charlotte.carservice.Beans.vehiclesBean;
import com.charlotte.carservice.model.UserCars;

/**
 * Servlet implementation class CarDetails
 */
@WebServlet("/CarDetails")
public class CarDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarDetails() {
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
		UserCars userCars=new UserCars();
		System.out.println("Selected VIN is - "+request.getParameter("VIN"));
		HttpSession session=request.getSession();
		vehiclesBean vehicleDetails= new vehiclesBean();
		vehicleDetails.setVin_no(request.getParameter("VIN"));
		@SuppressWarnings("unchecked")
		List<vehiclesBean> vehicles=(List<vehiclesBean>) session.getAttribute("vehicles");
		int index=vehicles.indexOf(vehicleDetails);
		RequestDispatcher rd = null;
		session.setAttribute("selectedCar", vehicles.get(index));
		session.setAttribute("ServicingTypes", userCars.getServicingTypes());
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
