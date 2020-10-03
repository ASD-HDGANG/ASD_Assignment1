package smartcardDemo.service;

import java.io.File;
import java.io.IOException;
import java.net.UnknownServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

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

			assert mdb != null;

			// customerTbl.createIndex(Indexes.ascending("CustomerId"), {CustomerId: 1},
			// {unique:true});

			Document customerDoc = new Document("CustomerId", customer.getCustomerId())
					.append("Email", customer.getEmail()).append("Password", customer.getPassword())
					.append("First Name", customer.getFirstname());

			Document addressDoc = new Document("Address1", customer.getAddressLine1())
					.append("Address2", customer.getAddressLine2()).append("Postcode", customer.getPostcode())
					.append("State", customer.getState());

			//saveImg(mdb);

			customerDoc.put("Address", addressDoc);

			customerTbl.insertOne(customerDoc);

		} catch (Exception e) {
			e.printStackTrace();
		}
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
