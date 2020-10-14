package com.smartcard.dao;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.exists;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import com.smartcard.entity.User;

public class UserDAO implements IGenericDAO<User> {

	MongoDatabase database = dBUtils.getMongoDB();
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

//		userTbl.updateOne(eq("email", user.getEmail()), Updates.set("email", user.getEmail()));

		userTbl.updateOne(eq("email", user.getEmail()), combine(set("email", user.getEmail()),
				set("FullName", user.getFullName()), set("password", user.getPassword())));

		return user;
	}

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

	public User findByEmail(String email) {

		// Document doc = (Document) mongoCollection.find(exists("otherInfo")).first();

		User userTbl = database.getCollection("User", User.class).find(eq("email", email)).first();
		return userTbl;
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
		return database.getCollection("User", User.class).find().into(userList);
	}

	@Override
	public Long count() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	/*
	 * public FindIterable<User> findDocumentById(String id) { BasicDBObject query =
	 * new BasicDBObject();
	 * 
	 * query.put("_id", new ObjectId(id)); FindIterable<User> dbObj =
	 * userTbl.find(query); return dbObj; }
	 */

	// FOR TEST PURPOSE
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoDatabase database = dBUtils.getMongoDB();

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
