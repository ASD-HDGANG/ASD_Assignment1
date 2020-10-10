package com.smartcard.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
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

			MongoCollection<User> userTbl = database.getCollection("User", User.class);
			assert database != null;

			User newUser = new User(user.getId(), user.getEmail(), user.getFullName(), user.getPassword());

			System.out.println("Email: " + newUser.getEmail() + " Name: " + newUser.getFullName() + " "
					+ newUser.getPassword() + " id: " + newUser.getId());

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

	public User findByEmail(String email) {

		database.getCollection("User", User.class).find().equals(email);

		return null;
	}

	@Override
	public void delete(Object id) {
//        Document document = new Document();
//        document.put("orderID", orderID);
//        collection.deleteMany(document);
	}

	@Override
	public List<User> listAll() {
		List<User> userList = new ArrayList<User>();
		// 1st option
		database.getCollection("User", User.class).find().into(userList);

		return userList;

	}

	@Override
	public Long count() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	public FindIterable<Document> findDocumentById(String id) {
		BasicDBObject query = new BasicDBObject();

		query.put("_id", new ObjectId(id));
		FindIterable<Document> dbObj = userTbl.find(query);
		return dbObj;
	}

	// FOR TEST PURPOSE
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<User> users = new ArrayList<User>();

		MongoDatabase database = dBUtils.getMongoDB();

		database.getCollection("User", User.class).find().into(users);

		for (User u : users) {
			System.out.println(u.toString());
		}

	}

}
