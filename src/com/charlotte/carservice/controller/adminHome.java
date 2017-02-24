package com.charlotte.carservice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.charlotte.carservice.model.Admin;

/**
 * Servlet implementation class adminHome
 */
@WebServlet("/adminHome")
public class adminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		Admin admin=new Admin();
		admin.pendingServicings();
		request.setAttribute("pendingServicings", admin.getPendingServicingSlots());
		request.setAttribute("finishedServicings", admin.getFinishedServicingSlots());
		session.setAttribute("pendingServicings", admin.getPendingServicingSlots());
		session.setAttribute("finishedServicings", admin.getFinishedServicingSlots());
		//System.out.println("Data is "+admin.getPendingServicingSlots().get(1).getBooking_ref_no());
		RequestDispatcher rd = null;
		rd=request.getRequestDispatcher("/admin_home.jsp");
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
