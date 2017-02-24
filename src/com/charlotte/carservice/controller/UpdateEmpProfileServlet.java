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
import com.charlotte.carservice.dao.LoadProfileDao;
import com.charlotte.carservice.dao.UpdateEmpProfileDao;
import com.charlotte.carservice.dao.UpdateProfileDao;

@WebServlet("/UpdateEmpProfileServlet")
public class UpdateEmpProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpProfileServlet() {
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
	        	String empname = request.getParameter("empname");
		           String empservname = request.getParameter("empservicename");
		           
		          System.out.println("the new service name is "+empservname);
		          employeeBean eout = new employeeBean(empid, empname, empservname);
		          UpdateEmpProfileDao empupdatedao = new UpdateEmpProfileDao();
		              
		                 int flag = empupdatedao.updateEmployee(eout);
		                 RequestDispatcher rd = null;
		                 if (flag != 0)
		                 {
		                	 String str = "Employee Profile  not updated Successfully";
			                 request.setAttribute("msg", str);
		                 rd=request.getRequestDispatcher("/PickEmployee.jsp");  
		                 rd.include(request, response); 
	              
		                 }
		                 if (flag == 0)
		                 {  String str = "Employee Profile updated  Successfully";
		                 request.setAttribute("msg", str);
		                 rd=request.getRequestDispatcher("/PickEmployee.jsp");
		                 rd.include(request, response);  
		                 }
		                 
		                
		                 
		            
		           
		    }  catch (Exception ex) {
		    	ex.printStackTrace();
		       }
		    }
		


	    }
	


