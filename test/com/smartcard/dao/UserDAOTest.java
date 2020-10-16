package com.smartcard.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.smartcard.entity.User;

public class UserDAOTest {

	@Test
	public void testCreate() {
		// fail("Not yet implemented");

		User user1 = new User();

		user1.setEmail("lucy@abc.com");
		user1.setFullName("Lucy Liu");
		user1.setPassword("lala");

		UserDAO userDAO = new UserDAO();
		user1 = userDAO.create(user1);

		assertTrue(user1.getEmail().equals("lucy@abc.com"));
		 //assertTrue(user1.getId() > 0 );
	}

	@Test
	public void testFindByEmail() {
		String email = "pepe@abc.com";

		UserDAO userDAO = new UserDAO();
		User user1 = userDAO.findByEmail(email);

		assertNotNull(user1);

	}

}
