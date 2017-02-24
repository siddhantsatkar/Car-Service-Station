package com.charlotte.carservice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.charlotte.carservice.Beans.UserBean;
import com.charlotte.carservice.model.LoginUser;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserBean userBean=new UserBean();
		userBean.setEmailId(username);
		userBean.setPassword(password);
		LoginUser loginUser=new LoginUser();
		RequestDispatcher rd = null;
		if(loginUser.isValidAdmin(userBean))
		{
			System.out.println("Valid");
			rd=request.getRequestDispatcher("/adminHome");  
            rd.include(request, response); 
		}else
		{
			System.out.println("Error");
			request.setAttribute("loginError", "Invalid Credentials!! Please enter valid username or password.");
			rd=request.getRequestDispatcher("/AdminLogin.jsp");  
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
