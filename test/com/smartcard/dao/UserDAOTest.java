package com.smartcard.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.smartcard.entity.User;

public class UserDAOTest {

	@Test
	public void testCreate() {
		User user1 = new User();
		
		user1.setEmail("lucy@uts.com");
		user1.setFirstName("Lucy");
		user1.setPassword("welcome123");
		
		UserDAO userDAO = new UserDAO();
		user1 = userDAO.create(user1);
		
		//assertTrue(user1.getId() > 0);
	}

}
