package com.smartcard.dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.smartcard.entity.SmartCard;

public class SmartCardDAOTest {

	private static SmartCardDAO smartCardDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreateCard() {

		SmartCard newSCard = new SmartCard();

//		private String cardNumber;
//		private String securityCode;
//		private String cardType; // TODO asList to specific card type
//		private float cardBalance;
//		// private String cardStatus;
//		private boolean isActive;
//		private Date lastUpdateTime;
//		private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
//		private byte[] image;
	}

}
