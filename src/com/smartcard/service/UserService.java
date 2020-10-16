package com.smartcard.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;
import org.json.JSONObject;

import com.mongodb.client.MongoDatabase;
import com.smartcard.dao.UserDAO;
import com.smartcard.dao.dBUtils;
import com.smartcard.entity.User;

import lombok.var;

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

		// Check email exist condition
		User existUser = userDAO.findByEmail(email);
		if (existUser != null) {
			String message = "email " + email + " already registered!";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
			rd.forward(request, response);

		} else {
			User newUser = new User(email, fullName, password);
			userDAO.create(newUser);
		}

	}

	public void listUser() throws ServletException, IOException {
		listUser(null);
	}

	public List<User> listUser(String msg) throws ServletException, IOException {

		List<User> userList = userDAO.listAll();

		if (msg != null) {
			request.setAttribute("msg", msg);
		}

		request.setAttribute("userList", userList); // for jsp to get Attribute
		String list_user_page = "user_list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(list_user_page);
		rd.forward(request, response);

		return userList;

	}

	public void editUser() throws ServletException, IOException {

		String idStr = (String) request.getParameter("id");
		ObjectId objId = new ObjectId(idStr);

		// Object userId = (String) request.getParameter("id"); // get query string from
		// the jsp

		User user = userDAO.get(objId.toHexString());

		String editPage = "user_form.jsp";
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher(editPage);
		rd.forward(request, response);

		System.out.println("User full name is? " + user.getId());

	}

	public void updateUser() throws ServletException, IOException {

		String idStr = (String) request.getParameter("id");//
		ObjectId objId = new ObjectId(idStr.toString());

		// Object objId = (String) request.getParameter("id");

		String email = request.getParameter("email"); // attr is name = "email" from the input field
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");

		System.out.println("NEW ID  = " + objId + ", or NEW EMAIL = " + email + ", or NEW NAME = " + fullName
				+ ", NEW PASSWORD =  " + password);

		User user = new User(objId, email, fullName, password);
		userDAO.update(user).toString();

		String updateMsg = "User update done!";
		listUser(updateMsg);

	}

	public void deleteUser() throws ServletException, IOException {
		String idStr = (String) request.getParameter("id");
		ObjectId objId = new ObjectId(idStr.toString());

		userDAO.delete(objId);

		String msg = "User deleted!";

		listUser(msg);

	}

}
