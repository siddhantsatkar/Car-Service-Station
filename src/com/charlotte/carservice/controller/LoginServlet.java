package com.charlotte.carservice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;

import com.charlotte.carservice.Beans.ServiceSlotBean;
import com.charlotte.carservice.Beans.UserBean;
import com.charlotte.carservice.Beans.vehiclesBean;
import com.charlotte.carservice.model.LoginUser;
import com.charlotte.carservice.model.UserCars;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserBean userBean=new UserBean();
		userBean.setEmailId(username);
		userBean.setPassword(password);
		LoginUser loginUser=new LoginUser();
		RequestDispatcher rd = null;
		if(loginUser.isValidUser(userBean))
		{
			System.out.println("Valid");
			HttpSession session = request.getSession();
			session.setAttribute("user", userBean.getEmailId());
			UserCars user=new UserCars();
			List<vehiclesBean> vehicles=user.getVehicles(userBean.getEmailId());
			List<ServiceSlotBean> bookings=user.getBookings(userBean.getEmailId());
			session.setAttribute("bookings", bookings);
			session.setAttribute("vehicles", vehicles);
			rd=request.getRequestDispatcher("/index.jsp");  
            rd.include(request, response); 
		}else
		{
			System.out.println("Error");
			request.setAttribute("loginError", "Invalid Credentials!! Please enter valid username or password.");
			rd=request.getRequestDispatcher("/Login.jsp");  
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

}
