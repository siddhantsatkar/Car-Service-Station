package com.charlotte.carservice.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.charlotte.carservice.Beans.*;
import com.charlotte.carservice.dao.UserDao;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		System.out.println("servlet called");
        try  {
            
           System.out.println("registration  controller");
           System.out.println("email id is"+request.getParameter("Email"));
           //PrintWriter out = response.getWriter();
           RequestDispatcher rd = null;
           
           System.out.println("Valid");
           
			HttpSession session = request.getSession();
			session.setAttribute("user", request.getParameter("Email"));
			List<vehiclesBean> vehicles=new ArrayList<vehiclesBean>();
			session.setAttribute("vehicles", vehicles);
          
           String fName=request.getParameter("First Name");
           String lName=request.getParameter("Last Name");
           String add=request.getParameter("Address");
           String email=request.getParameter("Email");
           String password=request.getParameter("Password");
           String contact=request.getParameter("Contact");
           UserBean u = new UserBean(fName,lName,email,add,password,contact);
                                 
                 int flag = UserDao.addCustomer(u);
                 if (flag == 0)
                 {
                	 //String str = "Registration Successful";
                	 //request.setAttribute("msg", str);
                	
	                 rd=request.getRequestDispatcher("/index.jsp");
	                 rd.include(request, response); 
          
                 }
                
                   if (flag == 1)
	                 { 
                	 String str = "Registration failed";
                	 System.out.println(str);
	                 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
	                 rd=request.getRequestDispatcher("/Registration.jsp");  
	                 rd.include(request, response);  
                 }
                 
                           
    }  catch (Exception ex) {
    	System.out.println("Exception registration controller");
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
