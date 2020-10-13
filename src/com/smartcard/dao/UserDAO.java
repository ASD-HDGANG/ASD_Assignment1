package com.smartcard.dao;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.include;

import java.util.ArrayList;
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

		userTbl.updateOne(Filters.eq("email", user.getEmail()), Updates.set("email", user.getEmail()));

		return user;
	}

	@Override
	public User get(Object userId) {


		FindIterable<User> userTbl = database.getCollection("User", User.class).find();
		for (User doc : userTbl) {

			String id = doc.getId().toHexString();
			System.out.println("_id = " + id);

			if (id.equals(userId)) {
				return doc;
			}
		}

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
		// MongoCollection<User> coll = database.getCollection("User", User.class);

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

	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	Block<User> printBlock = new Block<User>() {
		@Override
		public void apply(final User user) {
			System.out.println(user.toString());
		}
	};

}
