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
@WebServlet("/AddStockServlet")
public class AddStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStockServlet() {
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
		RequestDispatcher rd = null;
		int x=0;
		int y=0;
        try  {
          
           String stockId=request.getParameter("stock_Id");
           int quantity=Integer.parseInt((request.getParameter("quantity")));
           float price= Float.parseFloat(request.getParameter("price"));
           String name=request.getParameter("name");
           
           StockBean sb = new StockBean(stockId, quantity, price, name);
           
                 AdminDao admin=new AdminDao();   
                 x= admin.validatestockid(stockId);
                 if (x==3){
                	 String str = "Duplicate Stock id. Please enter correct stock id";
                	 request.setAttribute("msg2", str);
                	
	                 rd=request.getRequestDispatcher("/add_stock.jsp");
	                 rd.include(request, response); 
                	 
                	 
                 }else if (x==0) {
					
				y=admin.validatestockname(name);
				if(y==3){
					String str = "Duplicate Stock name. Please enter correct stock name";
               	 request.setAttribute("msg2", str);
               	
	                 rd=request.getRequestDispatcher("/add_stock.jsp");
	                 rd.include(request, response);
				}
				else if (y==0) {
					
				
                 int flag = admin.addStock(sb);
                 if (flag == 0)
                 {
                	 String str = "Stock Updated successfully";
                	 request.setAttribute("msg2", str);
                	
	                 rd=request.getRequestDispatcher("/add_stock.jsp");
	                 rd.include(request, response); 
          
                 }
                
                   if (flag == 1)
	                 { 
                	 String str = "Update failed";
                	 System.out.println(str);
	                 request.setAttribute("msg2", str);//has to be deleted after adding this message in jsp page
	                 rd=request.getRequestDispatcher("/add_stock.jsp");  
	                 rd.include(request, response);  
                 }
                 }}
                           
    }  catch (Exception ex) {
    	String str = "Failed to update the stock";
    	System.out.println(str);
    	System.out.println("the value of x is "+x);
    	System.out.println("the value of y is "+y);
        request.setAttribute("msg2", str);//has to be deleted after adding this message in jsp page
        rd=request.getRequestDispatcher("/add_stock.jsp");  
        rd.include(request, response); 
    	System.out.println("Exception in add stock controller");
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
