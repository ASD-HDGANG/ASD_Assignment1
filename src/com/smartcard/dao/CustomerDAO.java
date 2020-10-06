package com.smartcard.dao;

import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.smartcard.entity.Customer;

public class CustomerDAO implements IGenericDAO<Customer> {

	MongoDatabase database = dBUtils.getMongoDB();
	
	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer create(Customer customer) {
		customer.setRegisterDate(new Date());
		return customer;
	}

	@Override
	public Customer update(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void findByEmail(String email) {

		// findbyEmail
		MongoCollection<Document> customerTbl = database.getCollection("Customer");

		customerTbl.find(new Document("email", email));
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Customer> listAll() {
		// TODO Auto-generated method stub
		// collection.find(new Document("email", "youremail"))
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
