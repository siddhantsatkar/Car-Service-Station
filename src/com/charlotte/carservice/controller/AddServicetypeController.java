package com.charlotte.carservice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.charlotte.carservice.Beans.*;
import com.charlotte.carservice.dao.*;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/AddServicetypeController")
public class AddServicetypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServicetypeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		RequestDispatcher rd = null;
        try  {
            
           //System.out.println("registration  controller");
           //System.out.println("email id is"+reques2t.getParameter("Email"));
           //PrintWriter out = response.getWriter();
           
           
          
           String servicename=request.getParameter("service_name");
           float Estimatedtime = Float.parseFloat(request.getParameter("estimatedtime"));
           float EstimatedPrice = Float.parseFloat(request.getParameter("estimatedprice"));
           int maxlimit = Integer.parseInt(request.getParameter("maxlimit"));
           //String name=request.getParameter("name");
           //String password=request.getParameter("Password");
           //String contact=request.getParameter("Contact");
           servicing_typeBean service = new servicing_typeBean(servicename, Estimatedtime, EstimatedPrice, maxlimit);
                      
                 AdminDao admin = new AdminDao();               
                 int flag = admin.addServiceType(service);
                 if (flag == 0)
                 {
                	 String str = "Service type added successfully";
                	 request.setAttribute("msg", str);
                	
	                 rd=request.getRequestDispatcher("/addservice.jsp");
	                 rd.include(request, response); 
          
                 }
                
                   if (flag == 1)
	                 { 
                	 String str = "Adding Service type failed";
                	 System.out.println(str);
	                 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
	                 rd=request.getRequestDispatcher("/addservice.jsp");  
	                 rd.include(request, response);  
                 }
                 
                           
    }  catch (Exception ex) {
    	System.out.println("Exception in add service type controller");
    	ex.printStackTrace();
    	String str = "Adding Service type failed";
   	 System.out.println(str);
        request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
        rd=request.getRequestDispatcher("/addservice.jsp");  
        rd.include(request, response);  
       }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }



}
