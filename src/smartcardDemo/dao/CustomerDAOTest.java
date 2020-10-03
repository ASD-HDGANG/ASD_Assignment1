package smartcardDemo.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import smartcardDemo.entity.Customer;

public class CustomerDAOTest {

	@Test
	public void testCreate() {
		// fail("Not yet implemented");

		Customer customer1 = new Customer();
		customer1.setEmail("abc@gmail.com");
		customer1.setFirstname("Lucy");
		customer1.setPassword("testing");

		CustomerDAO customerDAO = new CustomerDAO();
		customer1 = customerDAO.create(customer1);
		
		assertTrue(customer1.getEmail() == "abc@gmail.com");

	}

}
