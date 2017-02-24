package com.charlotte.carservice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.charlotte.carservice.Beans.*;
import com.charlotte.carservice.dao.*;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/CustAddVehicleServlet")
public class CustAddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustAddVehicleServlet() {
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
		
        try  {
            
        	HttpSession session=request.getSession();  
            System.out.println("inside add car servlet");
              String username=(String)session.getAttribute("user");
              System.out.println("email id is "+username);
           RequestDispatcher rd = null;
           
          
           String vinno=request.getParameter("vinno");
           String carnumber = request.getParameter("carno");
           String cartype=request.getParameter("cartype");
           String Brandname=request.getParameter("brandname");
           String carmodel=request.getParameter("carmodel");
           String email= username;//"abc1@test.com"; //set the email of the customer logged in using session
           vehiclesBean vehicle= new vehiclesBean(vinno, carnumber, cartype, Brandname, carmodel, email);
           CustAddCarDao addcar = new CustAddCarDao();                      
                              
           int x = addcar.validatevinno(vinno);
           if (x == 2)
           { 
    	   System.out.println("x is 2 and car is not added");
    	 String str = "Duplicate vinno. Please enter a correct VIN Number";
    	 System.out.println(str);
           request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
           rd=request.getRequestDispatcher("/addcar.jsp");  
           rd.include(request, response);  
     }
           else if (addcar.validatecarno(carnumber)==3) {
        	   System.out.println("x is 3 and car is not added");
          	 String str = "Duplicate car number. Please enter a correct car Number";
          	 System.out.println(str);
                 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
                 rd=request.getRequestDispatcher("/addcar.jsp");  
                 rd.include(request, response); 
		}
           else{
           
                 int flag = addcar.addCar(vehicle);
                 if (flag == 0)
                 {
                	 System.out.println("flag is 0");
                	 String str = "car added successfully";
                	 request.setAttribute("msg", str);
                	 List<vehiclesBean> vehicles=(List<vehiclesBean>) request.getSession().getAttribute("vehicles");
                	 vehicles.add(vehicle);
                	 request.getSession().setAttribute("vehicles", vehicles);
	                 rd=request.getRequestDispatcher("/addcar.jsp");
	                 rd.include(request, response); 
          
                 }
                
                   if (flag == 1)
	                 { 
                	   System.out.println("flag is 1 and car is not added");
                	 String str = "Adding car failed";
                	 System.out.println(str);
	                 request.setAttribute("msg", str);//has to be deleted after adding this message in jsp page
	                 rd=request.getRequestDispatcher("/addcar.jsp");  
	                 rd.include(request, response);  
                 }}
                   
                 
                           
    }  catch (Exception ex) {
    	System.out.println("Exception in add car controller");
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
