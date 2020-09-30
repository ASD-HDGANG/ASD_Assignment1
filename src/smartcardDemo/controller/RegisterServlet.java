package smartcardDemo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import smartcardDemo.model.User;
import smartcardDemo.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "register a user", urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService = new UserService();

	@Override
	public void init() {
		userService = new UserService();
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

		User newUser = new User();

		UserService userService = new UserService();

		// How to use session for below?
		newUser.setFirstName(request.getParameter("firstname"));
		newUser.setEmail(request.getParameter("email"));
		newUser.setPassword(request.getParameter("password"));

		try {
			userService.create(newUser);
		} catch (Exception e) {
			e.printStackTrace();
		}

//        EmailService sendMail = new EmailService();
//        //call the send email method
//        boolean test = sendMail.sendMail(newUser);

		// response.sendRedirect("");
		request.getRequestDispatcher("/welcome.jsp").forward(request, response);
	}
}
