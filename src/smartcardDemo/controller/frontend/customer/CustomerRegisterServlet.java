package smartcardDemo.controller.frontend.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import smartcardDemo.entity.Customer;
import smartcardDemo.entity.User;
import smartcardDemo.service.CustomerService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "register a user", urlPatterns = { "/register" })
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CustomerService customerService = new CustomerService();

	@Override
	public void init() {
		customerService = new CustomerService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/registration.jsp").forward(request, response);

//        RequestDispatcher  dispatcher = request.getRequestDispatcher("/registration.jsp");
//        dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		Customer newCustomer = new Customer();
		CustomerService customerService = new CustomerService();
		HttpSession session = request.getSession();

		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
//		String firstName = (String) request.getParameter("firstname");

		session.setAttribute("email", email);
		session.setAttribute("password", password);

		// Store input to db, but how to use session for below?
		newCustomer.setFirstname(request.getParameter("firstname"));
		newCustomer.setEmail(request.getParameter("email"));
		newCustomer.setPassword(request.getParameter("password"));

		try {

			customerService.create(newCustomer);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Send email notification - uncomment it to add your email to test
//        EmailService sendMail = new EmailService();
//        //call the send email method
//        boolean test = sendMail.sendMail(newCustomer);

		request.getRequestDispatcher("/welcome.jsp").forward(request, response);
	}
}
