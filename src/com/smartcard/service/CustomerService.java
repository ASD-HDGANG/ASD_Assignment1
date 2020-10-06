package com.smartcard.service;

import java.io.IOException;
import java.net.UnknownServiceException;

import javax.servlet.ServletException;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.smartcard.dao.CustomerDAO;
import com.smartcard.dao.dBUtils;
import com.smartcard.entity.Customer;
import com.smartcard.entity.User;

public class CustomerService {

	CustomerDAO customerDAO = new CustomerDAO();
	MongoDatabase mdb = dBUtils.getMongoDB();

	public CustomerService() {

	}

	public void create(Customer customer) throws UnknownServiceException, ServletException, IOException {

		try {

			// User newUser = new User(email, password, firstname);
			// userDAO.create(newUser);

			// create or get collection
			MongoCollection<Document> customerTbl = mdb.getCollection("Customer");
			assert mdb != null;

			// customerTbl.createIndex(Indexes.ascending("CustomerId"), {CustomerId: 1},
			// {unique:true});

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
