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


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoadEmpProfileServlet")
public class LoadEmpProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadEmpProfileServlet() {
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
		              String empid = request.getParameter("empid");
		              	            
	        	LoadEmpProfileDao loadprofile = new LoadEmpProfileDao();	
	         employeeBean edetails  = loadprofile.LoadEmpProfileData(empid);
	         System.out.println("received the employee details back in servlet");
	                 request.setAttribute("empdet", edetails);
	                 RequestDispatcher rd1=request.getRequestDispatcher("/Employeeprofile.jsp");
	                   rd1.include(request, response);	           
	   
} catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

}
