package com.smartcard.controller.admin.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartcard.dao.MongoUtils;
import com.smartcard.service.SmartCardService;

@WebServlet("/admin/list_cards")
public class ListCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListCardServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

		MongoUtils.getMongoDB();

		String cardList = "card_list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(cardList);
		rd.forward(request, response);

//		SmartCardService smartService = new SmartCardService(request, response);
//		smartService.listCard();
	}

}
