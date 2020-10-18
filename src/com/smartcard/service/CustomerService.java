package com.smartcard.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import com.mongodb.client.MongoDatabase;
import com.smartcard.dao.CustomerDAO;
import com.smartcard.dao.MongoUtils;
import com.smartcard.entity.Customer;

public class CustomerService {

	private CustomerDAO customerDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	MongoDatabase mdb = MongoUtils.getMongoDB();

	public CustomerService(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.customerDAO = new CustomerDAO();
	}

	public List<Customer> listCustomers(String message) throws ServletException, IOException {

		List<Customer> listCustomer = customerDAO.listAll();

		if (message != null) {
			request.setAttribute("message", message);
		}

		request.setAttribute("listCustomer", listCustomer);

		String listPage = ("customer_list.jsp");
		RequestDispatcher rd = request.getRequestDispatcher(listPage);
		rd.forward(request, response);

		return listCustomer;
	}

	public void listCustomers() throws ServletException, IOException {
		listCustomers(null);
	}

	public void createCustomer() throws ServletException, IOException {

		String email = request.getParameter("email");

		Customer existCustomer = customerDAO.findByEmail(email);

		if (existCustomer != null) {
			String message = "customer email " + email + " already registered!";

			listCustomers(message);

			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
			rd.forward(request, response);

		} else {

			Customer newCustomer = new Customer();

			String fullName = request.getParameter("fullName");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String postCode = request.getParameter("postCode");

			newCustomer.setEmail(email);
			newCustomer.setFullName(fullName);
			newCustomer.setPassword(password);
			newCustomer.setPhone(phone);
			newCustomer.setAddress(address);
			newCustomer.setCity(city);
			newCustomer.setState(state);
			newCustomer.setPostCode(postCode);

			customerDAO.create(newCustomer);

		}

		// Send email notification
//      EmailService sendMail = new EmailService();
//      //call the send email method
//      boolean test = sendMail.sendMail(newCustomer);

	}

	public void deleteCustomer() throws ServletException, IOException {

		String idStr = (String) request.getParameter("id");
		ObjectId objId = new ObjectId(idStr);

		customerDAO.delete(objId);

		String msg = "Customer deleted!";

		listCustomers(msg);
	}

//	public void saveImg(MongoDatabase mdb2) throws IOException {
//		String newFileName = "adult";
//		File imagePath = new File("D:/Users/Patty/eclipse-workspace/smartcardDemo/WebContent/img/adult.jpg");
//		GridFS gfsImg = new GridFS(mdb2, "image");
//		try {
//			GridFSInputFile gfsFile = gfsImg.createFile(imagePath);
//			gfsFile.setFilename(newFileName);
//			gfsFile.save();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}

}
