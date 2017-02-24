package com.charlotte.carservice.controller;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;


import sun.util.logging.PlatformLogger.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.charlotte.carservice.Beans.*;
import com.charlotte.carservice.dao.LoadEmpProfileDao;
import com.charlotte.carservice.dao.LoadProfileDao;
import com.charlotte.carservice.dao.LoadServicetypeDetailsDao;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoadServiceDetailServlet")
public class LoadServicetypeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadServicetypeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }
    
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  processRequest(request, response);
	}
	
	   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	       
	        try  {
	        	HttpSession session=request.getSession();  
		            
		              String username=(String)session.getAttribute("user"); 
		              String servicetype = request.getParameter("service_name");
		              	System.out.println("in load service type details servlet");            
		              LoadServicetypeDetailsDao loadservice = new LoadServicetypeDetailsDao();	
	         servicing_typeBean sdetails  = loadservice.LoadServicetypedetails(servicetype);
	         //System.out.println("in servlet limit is "+sdetails.getMax_limit_per_day());
	         System.out.println("received the servicingtype details back in servlet");
	                 request.setAttribute("servicedet", sdetails);
	                 RequestDispatcher rd1=request.getRequestDispatcher("/updateService.jsp");
	                   rd1.include(request, response);	           
	   
} catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

}
