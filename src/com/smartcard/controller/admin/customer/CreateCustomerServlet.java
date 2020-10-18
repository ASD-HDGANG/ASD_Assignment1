package com.smartcard.controller.admin.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartcard.dao.dBUtils;
import com.smartcard.service.CustomerService;

@WebServlet("/admin/create_customer")
public class CreateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateCustomerServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		dBUtils.getMongoDB();

		CustomerService customerService = new CustomerService(request, response);
		customerService.createCustomer();

		String message = "You are registered!";
		customerService.listCustomers(message);

	}

}
