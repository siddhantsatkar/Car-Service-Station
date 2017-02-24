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
import com.charlotte.carservice.dao.UpdateStkDao;

@WebServlet("/UpdateStkServlet")
public class UpdateStkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStkServlet() {
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
	              String stkname = request.getParameter("stkname");
	              float price = Float.parseFloat(request.getParameter("stkprice"));
	        	int qty = Integer.parseInt(request.getParameter("stkqty"));
		           String stkid = request.getParameter("stkid");
		           
		          System.out.println("the new quantity is "+qty);
		          StockBean sout = new StockBean(stkid, qty, price, stkname);
		          UpdateStkDao updatestk = new UpdateStkDao();
		              
		                 int flag = updatestk.updateStock(sout);
		                 RequestDispatcher rd = null;
		                 if (flag != 0)
		                 {
		                	 String str = "Stock  not updated Successfully";
			                 request.setAttribute("msg", str);
		                 rd=request.getRequestDispatcher("/PickStock.jsp");  
		                 rd.include(request, response); 
	              
		                 }
		                 if (flag == 0)
		                 {  System.out.println("back in servlet");
		                	 String str = "Stock updated  Successfully";
		                 request.setAttribute("msg", str);
		                 System.out.println("123");
		                 rd=request.getRequestDispatcher("/PickStock.jsp");
		                 rd.include(request, response);  
		                 System.out.println("456");
		                 }
		                 
		                
		                 
		            
		           
		    }  catch (Exception ex) {
		    	ex.printStackTrace();
		       }
		    }
		


	    }
	


