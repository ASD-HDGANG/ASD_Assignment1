package smartcardDemo.controller.frontend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import smartcardDemo.entity.SmartCard;
import smartcardDemo.service.SmartcardService;

@WebServlet("/Order_SmartCard")
public class OrderSmartCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderSmartCardServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SmartCard newCard = new SmartCard();
		SmartcardService smartcardService = new SmartcardService();

//		String smartCardType = request.getParameter("smartCardType");
//
//		request.setAttribute("smartCardNumber", smartCardNumber);
//		request.setAttribute("securityCode", securityCode);
//		request.setAttribute("smartCardType", smartCardType);

		// Store input to db, but how to use session for below?
//		newCustomer.setFirstname(request.getParameter("firstname"));
//		newCustomer.setEmail(request.getParameter("email"));
//		newCustomer.setPassword(request.getParameter("password"));

		try {

			smartcardService.create(newCard);

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/smartCardDetail.jsp").forward(request, response);
	}

}
