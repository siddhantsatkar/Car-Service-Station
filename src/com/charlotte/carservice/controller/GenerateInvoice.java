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
import com.charlotte.carservice.Beans.StockBean;
import com.charlotte.carservice.dao.AdminDao;
import com.charlotte.carservice.model.Admin;

/**
 * Servlet implementation class GenerateInvoice
 */
@WebServlet("/GenerateInvoice")
public class GenerateInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateInvoice() {
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
		System.out.println("---Test--"+request.getParameter("refNo1")+":::"+request.getParameter("timeSlot1")+";;;;"+request.getParameter("status"));
		ServiceSlotBean serviceslot=new ServiceSlotBean();
		serviceslot.setBooking_ref_no(Integer.parseInt(request.getParameter("refNo1")));
		serviceslot.setService_name(request.getParameter("serviceType1"));
		serviceslot.setTime_slot(Float.parseFloat(request.getParameter("timeSlot1")));
		String code=request.getParameter("serviceType1").substring(0, 3).toUpperCase();
		System.out.println("Service Code is - "+ request.getParameter("serviceType1").substring(0, 3).toUpperCase());
		List<StockBean> stocks=new AdminDao().getStocks(code);
		
		HttpSession session=request.getSession();
		session.setAttribute("stocks", stocks);
		session.setAttribute("booking_ref", request.getParameter("refNo1"));
		session.setAttribute("ServiceName", request.getParameter("serviceType1"));
		System.out.println("Setting Finished Sevices -"+session.getAttribute("finishedServicings"));
		
		
		
		RequestDispatcher rd = null;
		rd=request.getRequestDispatcher("/generateInvoice.jsp");
		rd.include(request, response);
		
		/*request.setAttribute("invoiceGenerated", str);
		RequestDispatcher rd = null;
		rd=request.getRequestDispatcher("/admin_home.jsp");
		rd.include(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
