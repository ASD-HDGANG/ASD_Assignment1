package com.smartcard.controller.admin.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartcard.dao.MongoUtils;
import com.smartcard.entity.Customer;
import com.smartcard.service.CustomerService;
import com.smartcard.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */

public class OldCustRegoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	CustomerService customerService = new CustomerService();
//
//	@Override
//	public void init() {
//		customerService = new CustomerService();
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.getRequestDispatcher("frontend/registration.jsp").forward(request,
		// response);

//        RequestDispatcher  dispatcher = request.getRequestDispatcher("/registration.jsp");
//        dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

//		dBUtils.getMongoDB();
//
//		CustomerService customerService = new CustomerService(request, response);
//		customerService.createCustomer();

		// Send email notification
//        EmailService sendMail = new EmailService();
//        //call the send email method
//        boolean test = sendMail.sendMail(newCustomer);

//		request.getRequestDispatcher("frontend/welcome.jsp").forward(request, response);
	}
}