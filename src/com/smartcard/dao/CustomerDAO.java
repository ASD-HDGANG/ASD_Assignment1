package com.smartcard.dao;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.smartcard.entity.Customer;
import com.smartcard.entity.User;

public class CustomerDAO implements IGenericDAO<Customer> {

	MongoDatabase database = dBUtils.getMongoDB();
	MongoCollection<Customer> customerTbl = database.getCollection("Customer", Customer.class);

	public CustomerDAO() {
		super();
	}

	@Override
	public Customer create(Customer customer) {

		try {

			MongoCollection<Document> customerTbl = database.getCollection("Customer");
			assert database != null;

//			Customer newCustomer = new Customer(customer.getEmail(), customer.getFullName(), customer.getPassword());
//

//
//			customerTbl.insertOne(newCustomer);

			Document customerDoc = new Document("Email", customer.getEmail()).append("Password", customer.getPassword())
					.append("First Name", customer.getFullName());

			Document addressDoc = new Document("Address", customer.getAddress())
					.append("Postcode", customer.getPostCode()).append("State", customer.getState());

			System.out.println("Customer Name = " + customer.getFullName() + ", Email = " + customer.getEmail()
					+ ", Password = " + customer.getPassword() + ", Phone = " + customer.getPhone() + ", Address = "
					+ customer.getAddress());

			customerDoc.put("Address", addressDoc);

			customerTbl.insertOne(customerDoc);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return customer;

//		Document customerDoc = new Document("Email", customer.getEmail()).append("Password", customer.getPassword())
//				.append("First Name", customer.getFullName());
//
//		Document addressDoc = new Document("Address1", customer.getAddressLine1())
//				.append("Address2", customer.getAddressLine2()).append("Postcode", customer.getPostcode())
//				.append("State", customer.getState());
//
//		customerDoc.put("Address", addressDoc);
//
//		customerTbl.insertOne(customerDoc);

	}

	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer findByEmail(String email) {

		// findbyEmail
		Customer customerTbl = database.getCollection("Customer", Customer.class).find(eq("email", email)).first();

		return customerTbl;
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Customer> listAll() {
		List<Customer> customerList = new ArrayList<Customer>();
		return database.getCollection("Customer", Customer.class).find().into(customerList);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
