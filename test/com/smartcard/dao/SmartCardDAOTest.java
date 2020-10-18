package com.smartcard.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.smartcard.entity.SmartCard;

public class SmartCardDAOTest {

	private static SmartCardDAO smartcardDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreate() {
		
		SmartCard newSCard = new SmartCard();
		
		//newSCard.setCardNumber(cardNumber);
	}

}
