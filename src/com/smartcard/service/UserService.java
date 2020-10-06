package com.smartcard.service;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.smartcard.dao.UserDAO;
import com.smartcard.dao.dBUtils;
import com.smartcard.entity.User;

public class UserService {

	private UserDAO userDAO;
	MongoDatabase mdb = dBUtils.getMongoDB();

//	private MongoCollection<Document> col;

//	public UserService() {
//
//		this.col =  mdb.getCollection("User");
//	}

	public List<User> listUser() {

		UserDAO userDAO = new UserDAO();
		
		List<User> listUsers = userDAO.listAll();	
		return listUsers;

//		List<User> userList = new ArrayList<User>();
//		FindIterable<Document> cursor = col.find();
//		while (cursor.hasNext()) {
//			DBObject doc = cursor.next();
//			User u = UserConverter.toUser(doc);
//			userList.add(u);
// 		}
//		return userList;
	}

	public void create(User user) {

		// this what I want to see. user is saved to db here
		try {
			MongoDatabase mdb = dBUtils.getMongoDB();
			assert mdb != null;

			// create or get collection
			MongoCollection<Document> userTbl = mdb.getCollection("User");

			// User newUser = new User(email, password, fullname);
			// userDAO.create(newUser);

			Document userDoc = new Document("Email", user.getEmail()).append("Password", user.getPassword())
					.append("Full Name", user.getFullName());

			userTbl.insertOne(userDoc);

		} catch (Exception e) {
			e.printStackTrace();
		}
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
