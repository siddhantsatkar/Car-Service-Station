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
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
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
		//System.out.println("servlet called");
        try  {
            
           //System.out.println("registration  controller");
           //System.out.println("email id is"+reques2t.getParameter("Email"));
           //PrintWriter out = response.getWriter();
           RequestDispatcher rd = null;
           
          
           String empId=request.getParameter("empid");
           String empname = request.getParameter("empName");
           String servicename = request.getParameter("empservicename");
           //String name=request.getParameter("name");
           //String password=request.getParameter("Password");
           //String contact=request.getParameter("Contact");
           employeeBean emp = new employeeBean(empId, empname, servicename);
           
                 AdminDao admin = new AdminDao();               
                 int flag = admin.addEmployee(emp);
                 if (flag == 0)
                 {
                	 String str = "Employee added successfully";
                	 request.setAttribute("msg", str);
                	
	                 rd=request.getRequestDispatcher("/EmployeeRegistration.jsp");
	                 rd.include(request, response); 
          
                 }
                
                   if (flag == 1)
	                 { 
                	 String str = "Registration failed";
                	 System.out.println(str);
	                 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
	                 rd=request.getRequestDispatcher("/EmployeeRegistration.jsp");  
	                 rd.include(request, response);  
                 }
                 
                           
    }  catch (Exception ex) {
    	System.out.println("Exception in employee registration controller");
    	ex.printStackTrace();
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
