package com.smartcard.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartcard.dao.UserDAO;
import com.smartcard.entity.User;
import com.smartcard.service.UserService;

@WebServlet("/admin/list_users")
public class ListUsersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ListUsersServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService userService = new UserService(request, response);
		
		userService.listUser();

		//List<User> userList = userService.listUser();
		//request.setAttribute("userList", userList); // for jsp to get Attribute

//		String list_user_page = "user_list.jsp";
//		RequestDispatcher rd = request.getRequestDispatcher(list_user_page);
//		rd.forward(request, response);
	}

}
