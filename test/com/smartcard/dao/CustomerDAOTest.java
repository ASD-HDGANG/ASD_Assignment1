package com.smartcard.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.smartcard.entity.Customer;

public class CustomerDAOTest {

	CustomerDAO customerDao = new CustomerDAO();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreate() {

		Customer customer = new Customer();

		
		customer.setFullName("Dada See");
		customer.setEmail("dada@gmail.com");
		customer.setPassword("secret!!!");

		Customer savedCustomer = customerDao.create(customer);

		assertTrue(savedCustomer != null);

//		String idStr = (String) request.getParameter("id");
//		ObjectId objUserId = new ObjectId(idStr);

	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
