package com.smartcard.dao;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.smartcard.entity.User;

public class UserDAO implements IGenericDAO<User> {

	MongoDatabase database = MongoUtils.getMongoDB();
	MongoCollection<User> userTbl = database.getCollection("User", User.class);

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

		MongoCollection<User> userTbl = database.getCollection("User", User.class);

		userTbl.updateOne(eq("_id", user.getId()), set("email", user.getEmail()));

		return user;
	}

	// For edit user
	@Override
	public User get(Object userId) {

		FindIterable<User> userTbl = database.getCollection("User", User.class).find();
		for (User doc : userTbl) {

			String id = doc.getId().toString();
			System.out.println("_id = " + id);

			if (id.equals(userId)) {
				return doc;
			}
		}
		return null;
	}

	// not working >.<
//	private Document getUser(String id) {
//		MongoCollection<Document> userTbl = database.getCollection("User");		
//		System.out.println("_id = " + id);
//		return userTbl.find(eq("_id", new ObjectId(id))).first();
//	}

	public User findByEmail(String email) {

		// Document doc = (Document) mongoCollection.find(exists("otherInfo")).first();

		User userTbl = database.getCollection("User", User.class).find(eq("email", email)).first();
		return userTbl;
	}

	@Override
	public void delete(Object userId) {

		MongoCollection<Document> coll = database.getCollection("User");

		coll.deleteOne(eq("_id", userId));

		System.out.println("User Id " + userId + " deleted!");
	}

	@Override
	public List<User> listAll() {
		List<User> userList = new ArrayList<User>();
		return database.getCollection("User", User.class).find().into(userList);
	}

	@Override
	public Long count() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	// FOR TEST PURPOSE
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoDatabase database = MongoUtils.getMongoDB();

		// get a handle to the "user" collection
		MongoCollection<User> coll = database.getCollection("User", User.class);

		/*
		 * FindIterable<User> userTbl = database.getCollection("User",
		 * User.class).find();
		 * 
		 * for (User doc : userTbl) {
		 * 
		 * String oid = doc.getId().toString();
		 * 
		 * System.out.println("_id = " + oid);
		 * 
		 * }
		 */

	}

	Block<User> printBlock = new Block<User>() {
		@Override
		public void apply(final User user) {
			System.out.println(user.toString());
		}
	};
}
