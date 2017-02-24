package com.charlotte.carservice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.charlotte.carservice.Beans.FeedbackBean;
import com.charlotte.carservice.dao.ServicingDao;

/**
 * Servlet implementation class SubmitFeedback
 */
@WebServlet("/SubmitFeedback")
public class SubmitFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitFeedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str="";
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//HttpSession session= request.getSession();
		//select f.Name, f.comment from feedback_form f natural join invoice natural join service_slot where service_slot.booking_ref_no='21';
		FeedbackBean feedback= new FeedbackBean();
		feedback.setComment(request.getParameter("comment"));
		feedback.setName(request.getParameter("fName"));
		feedback.setRating(Integer.parseInt(request.getParameter("rating")));
		feedback.setInvoiceNumber(Integer.parseInt(request.getParameter("refNo1")));
		ServicingDao sDao = new ServicingDao();
		if(sDao.isFeedbackUpdated(feedback))
		{
			str="Thanks for your Feedback!!";
			request.setAttribute("Feedback", feedback);
		}
		request.setAttribute("successFeedback", str);
		RequestDispatcher rd = null;
		rd=request.getRequestDispatcher("/Booking_details.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
