package com.smartcard.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartcard.entity.User;
import com.smartcard.service.UserService;


@WebServlet(description = "register a user", urlPatterns = { "/admin_register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService = new UserService();


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
		HttpSession session = request.getSession();

		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
//		String firstName = (String) request.getParameter("firstname");

		session.setAttribute("email", email);
		session.setAttribute("password", password);

		// Store input to db, but how to use session for below?
		newUser.setFirstName(request.getParameter("firstname"));
		newUser.setEmail(request.getParameter("email"));
		newUser.setPassword(request.getParameter("password"));

		try {

			userService.create(newUser);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Send email notification
//        EmailService sendMail = new EmailService();
//        //call the send email method
//        boolean test = sendMail.sendMail(newUser);

		request.getRequestDispatcher("/welcome.jsp").forward(request, response);
	}
}

// For login controller on index login/out icon?
//HttpSession session=request.getSession(false);
//String myName=(String)session.getAttribute("uname");
//String myPass=(String)session.getAttribute("upass");