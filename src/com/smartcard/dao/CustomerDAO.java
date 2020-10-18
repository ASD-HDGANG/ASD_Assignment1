package com.smartcard.dao;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.smartcard.entity.Customer;

public class CustomerDAO implements IGenericDAO<Customer> {

	MongoDatabase database = MongoUtils.getMongoDB();
	MongoCollection<Customer> customerTbl = database.getCollection("Customer", Customer.class);

	public CustomerDAO() {
		super();
	}

	@Override
	public Customer create(Customer customer) {

		customer.setRegisterDate(new Date());

		try {

			MongoCollection<Customer> customerTbl = database.getCollection("Customer", Customer.class);
			assert database != null;

			Customer newCustomer = new Customer();

			newCustomer.setEmail(customer.getEmail());
			newCustomer.setFullName(customer.getFullName());
			newCustomer.setPassword(customer.getPassword());
			newCustomer.setState(customer.getState());
			newCustomer.setPhone(customer.getPhone());
			newCustomer.setPostCode(customer.getPostCode());
			newCustomer.setRegisterDate(new Date());

//			Document customerDoc = new Document("Email", customer.getEmail()).append("Password", customer.getPassword())
//					.append("First Name", customer.getFullName()).append("Register Date", customer.getRegisterDate())
//					.append("Register Date", new Date());
//
//			Document addressDoc = new Document("Address", customer.getAddress())
//					.append("Postcode", customer.getPostCode()).append("State", customer.getState());
//
//			System.out.println("Customer Name = " + customer.getFullName() + ", Email = " + customer.getEmail()
//					+ ", Password = " + customer.getPassword() + ", Phone = " + customer.getPhone() + ", Address = "
//					+ customer.getAddress() + ", Register Date? = " + customer.getRegisterDate());
//
//			customerDoc.put("Address", addressDoc);
//
			customerTbl.insertOne(newCustomer);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return customer;

	}

	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer get(Object customerId) {

		FindIterable<Customer> customerTbl = database.getCollection("Customer", Customer.class).find();
		for (Customer doc : customerTbl) {

			String id = doc.getCustomerId().toString();
			System.out.println("_id = " + id);

			if (id.equals(customerId)) {
				return doc;
			}
		}

		return null;
	}

	public Customer findByEmail(String email) {

		// findbyEmail
		Customer customerTbl = database.getCollection("Customer", Customer.class).find(eq("email", email)).first();

		return customerTbl;
	}

	@Override
	public void delete(Object customerId) {

		MongoCollection<Document> coll = database.getCollection("Customer");

		coll.deleteOne(eq("_id", customerId));

		System.out.println("Customer Id " + customerId + " deleted!");

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
