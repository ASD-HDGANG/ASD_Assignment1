package com.smartcard.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
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

		try {

			// create or get collection (tbl)
//			MongoCollection<Document> userTbl = database.getCollection("User");
//			assert database != null;

			// put user input to user tbl
//			Document userDoc = new Document("Email", user.getEmail()).append("Password", user.getPassword())
//					.append("First Name", user.getFirstName());
//			userTbl.insertOne(userDoc);

			MongoCollection<User> userTbl = database.getCollection("User", User.class);
			assert database != null;

			User newUser = new User(user.getUserId(), user.getEmail(), user.getFullName(), user.getPassword());

			userTbl.insertOne(newUser);

		} catch (Exception e) {
			e.printStackTrace();
		}

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
		database.getCollection("Users", User.class).find().into(userList);
		
		for(User u : userList)
		{
			// show user list to browser???
		}

		return userList;
	}

	@Override
	public Long count() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

}
