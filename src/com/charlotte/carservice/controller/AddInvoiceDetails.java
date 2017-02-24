package com.charlotte.carservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.charlotte.carservice.Beans.ServiceSlotBean;
import com.charlotte.carservice.Beans.StockBean;
import com.charlotte.carservice.dao.AdminDao;

/**
 * Servlet implementation class AddInvoiceDetails
 */
@WebServlet("/AddInvoiceDetails")
public class AddInvoiceDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInvoiceDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		List<StockBean> stocks=(List<StockBean>) session.getAttribute("stocks");
		
		List<StockBean> addedStocks=new ArrayList<StockBean>();
		String serviceName = (String) session.getAttribute("ServiceName");
		int booking_ref_no=Integer.parseInt((String) session.getAttribute("booking_ref"));
		for(int i=0;i<stocks.size();i++)
		{
			String quantity=request.getParameter(stocks.get(i).getStock_id());
			int selectedQuantity=0;
			if(quantity!="")
			{	
				selectedQuantity=Integer.parseInt(quantity);
				if(selectedQuantity!=0)
				{
					StockBean stk=new StockBean(stocks.get(i).getStock_id(), selectedQuantity, stocks.get(i).getPrice(), stocks.get(i).getName());
					addedStocks.add(stk);
				}
			}
		}
			AdminDao adminDao=new AdminDao();
			int invoiceNumber=adminDao.isInvoiceGenerated(addedStocks,booking_ref_no,serviceName);
			if(invoiceNumber!=-1)
			{
				ServiceSlotBean serviceslot=new ServiceSlotBean();
				serviceslot.setBooking_ref_no(booking_ref_no);
				List<ServiceSlotBean> finishedServicings=(ArrayList<ServiceSlotBean>) session.getAttribute("finishedServicings");
				System.out.println("Finished Services are - "+finishedServicings);
				int slot=finishedServicings.indexOf(serviceslot);
				System.out.println("Dummy----Session---"+finishedServicings.indexOf(serviceslot));
				ServiceSlotBean oldServiceSlot=finishedServicings.get(slot);
				finishedServicings.remove(slot);
				//pendingServicings.add(slot, serviceslot);
				session.setAttribute("finishedServicings", finishedServicings);
				request.setAttribute("invoiceGenerated", "Generated Invoice for booking ref - "+booking_ref_no+" and Invoice Number is - "+ invoiceNumber);
				RequestDispatcher rd = null;
				rd=request.getRequestDispatcher("/admin_home.jsp");
				rd.include(request, response);
			}
				
			//System.out.println(i+" Quantity is - "+request.getParameter(stocks.get(i).getStock_id()));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
