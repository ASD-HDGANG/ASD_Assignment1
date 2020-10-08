package com.smartcard.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.smartcard.dao.UserDAO;
import com.smartcard.dao.dBUtils;
import com.smartcard.entity.User;

public class UserService {

	private UserDAO userDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	MongoDatabase db = dBUtils.getMongoDB();

	public UserService(HttpServletRequest request, HttpServletResponse response) {
		super();
		userDAO = new UserDAO();
		this.request = request;
		this.response = response;
	}

	public void createUser() throws ServletException, IOException {

		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");

		User newUser = new User(email, fullName, password);
		userDAO.create(newUser);

	}

//	public void listUser()
//			throws ServletException, IOException {
//		listUser(null);
//	}

	public void listUser() throws ServletException, IOException {

		List<User> userList = userDAO.listAll();

		request.setAttribute("userList", userList); // for jsp to get Attribute
		
		String list_user_page = "user_list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(list_user_page);
		rd.forward(request, response);

	}

	public void update(User user) {

		// Should be in Edit user field...
//                Document Address = new Document()
//                        .append("Address1", user.getAddressLine1())
//                        .append("City", user.getCity())
//                        .append("State", user.getState())
//                        .append("postcode", user.getZipcode());
		// mdb.getCollection("Users").updateOne(eq("firstName",
		// "Lucy"),Updates.addToSet("Address", Address));
	}

}
