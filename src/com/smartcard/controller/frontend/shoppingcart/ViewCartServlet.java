package com.smartcard.controller.frontend.shoppingcart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartcard.entity.SmartCard;

@WebServlet("/view_cart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		// card in cart store in the session
		Object cartObj = request.getSession().getAttribute("cart");

		// put cart to session
		if (cartObj == null) {
			ShoppingCart shoppingCart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
		}

		SmartCard sc = new SmartCard();
		sc.setActive(true);
		sc.setCardType("Adult smart card");
		sc.setCardBalance(sc.getCardBalance() * 10);

		ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("cart");
		shoppingCart.addItem(sc);

		String viewCart = "frontend/shopping_cart.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewCart);
		rd.forward(request, response);

	}

}
