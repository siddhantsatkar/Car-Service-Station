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
import com.charlotte.carservice.dao.UpdateProfileDao;
import com.charlotte.carservice.dao.UpdateServiceTypeDao;

@WebServlet("/UpdateServicingServlet")
public class UpdateServicingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServicingServlet() {
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
	            System.out.println("inside update servicing servlet");
	              //String username=(String)session.getAttribute("user"); 
	        	String servicename = request.getParameter("servicename");
	        	System.out.println("service name is INSIDE UPDATE SERVICE SERVLET "+servicename);
		          float Estimatedtime = Float.parseFloat(request.getParameter("time"));
		          float Estimatedprice = Float.parseFloat(request.getParameter("price"));
		           int maxlimit = Integer.parseInt(request.getParameter("limit"));
		           
		           
		          System.out.println("the service modified is "+servicename);
		          servicing_typeBean servicingtype = new servicing_typeBean(servicename, Estimatedtime, Estimatedprice, maxlimit);
		          
		          UpdateServiceTypeDao updateserviceype = new UpdateServiceTypeDao();         
		                 int flag = updateserviceype.updateServicing(servicingtype);
		                 RequestDispatcher rd = null;
		                 if (flag != 0)
		                 {
		                	 String str = "Service type  not updated Successfully";
			                 request.setAttribute("msg1", str);
		                 rd=request.getRequestDispatcher("/pickService.jsp");  
		                 rd.include(request, response); 
	              
		                 }
		                 if (flag == 0)
		                 {  String str = "Service type updated  Successfully";
		                 request.setAttribute("msg1", str);
		                 rd=request.getRequestDispatcher("/pickService.jsp");
		                 rd.include(request, response);  
		                 }
		                 
		                
		                 
		            
		           
		    }  catch (Exception ex) {
		    	ex.printStackTrace();
		       }
		    }
		


	    }
	


