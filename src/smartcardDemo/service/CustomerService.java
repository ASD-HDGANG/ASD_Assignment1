package smartcardDemo.service;

import java.io.IOException;
import java.net.UnknownServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import smartcardDemo.dao.CustomerDAO;
import smartcardDemo.dao.dBUtils;
import smartcardDemo.entity.Customer;

public class CustomerService {

	CustomerDAO customerDAO = new CustomerDAO();

	MongoDatabase mdb = dBUtils.getMongoDB();
	// create or get collection
	MongoCollection<Document> customerTbl = mdb.getCollection("Customers");

	public CustomerService() {

	}

	public CustomerService(CustomerDAO customerDAO, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.customerDAO = customerDAO;
	}

	public void create(Customer customer) throws UnknownServiceException, ServletException, IOException {


		try {

			// User newUser = new User(email, password, firstname);
			// userDAO.create(newUser);

//			users.add(new Document("id", user.getId()).append("Email", user.getEmail())
//					.append("Password", user.getPassword()).append("First Name", user.getFirstName())
//					.append("Address", asList(user.getAddressLine1(), user.getAddressLine2())));
//			userlist.insertMany(users);

			assert mdb != null;
		

			Document customerDoc = new Document("Email", customer.getEmail()).append("Password", customer.getPassword())
					.append("First Name", customer.getFirstname());

			Document addressDoc = new Document("Address1", customer.getAddressLine1())
					.append("Address2", customer.getAddressLine2()).append("Postcode", customer.getPostcode())
					.append("State", customer.getState());

			customerDoc.put("Address", addressDoc);

			customerTbl.insertOne(customerDoc);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
