package com.smartcard.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.smartcard.entity.User;

public class UserDAO implements IGenericDAO<User> {

	MongoDatabase database = dBUtils.getMongoDB();
	MongoCollection<Document> userTbl = database.getCollection("User");

	public UserDAO() {
		super();
	}

	@Override
	public User create(User user) {
		return user;

	}

	@Override
	public User update(User user) {

		userTbl.updateOne(Filters.eq("email", user.getEmail()), Updates.set("email", user.getEmail()));

		return user;

	}

	@Override
	public User get(Object userId) {
		return null;
	}

	public void findByEmail(String email) {

		// findbyEmail
		userTbl.find(new Document("email", email));
	}

	@Override
	public void delete(Object id) {

	}

	@Override
	public List<User> listAll() {

		List<User> userList = new ArrayList<User>();
		

		// 1. get the table dB
		MongoCollection<Document> userTbl = database.getCollection("User");

		// loop through the table to find, then add
		for (Document doc : userTbl.find()) {
			User user = new User((String) doc.get("fullname"), (String) doc.get("email"),
					(String) doc.getString("password"));

			userList.add(user);
		}
		
		return userList;

//		userList.find().forEach((Consumer<? super Document>) userDoc -> userDoc.toJson());
//		return List<User>;

//        for (Document doc : collection.find()){
//            
//            int orderID = Integer.parseInt(doc.get("orderID").toString());
//            int customerID = Integer.parseInt(doc.get("customerID").toString());
//            String paymentMethod=doc.get("paymentMethod").toString();
//            String paymentDate=doc.get("paymentDate").toString();
//            String billDateGenerated=doc.get("billDateGenerated").toString();
//            String tax=doc.get("tax").toString();
//            String service=doc.get("service").toString();
//            String location = doc.get("location").toString();
//            String amount= doc.get("amount").toString();
//            
//            documents.add(new Billing(orderID,customerID,paymentMethod,paymentDate,billDateGenerated,tax,service,location,amount));
//        }
//        return documents;

	}

	@Override
	public Long count() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

//	List<User> data = new ArrayList<User>();
//	FindIterable<Document> cursor = userTbl.find();
//	while (cursor.hasNext()) {
//		DBObject doc = cursor.next();
//		Person p = PersonConverter.toPerson(doc);
//		data.add(p);
//	}
//	return data;

}
