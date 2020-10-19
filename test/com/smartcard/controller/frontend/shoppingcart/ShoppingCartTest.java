package com.smartcard.controller.frontend.shoppingcart;

import static org.junit.Assert.*;

import java.util.Map;

import org.bson.types.ObjectId;
import org.junit.BeforeClass;
import org.junit.Test;

import com.smartcard.entity.SmartCard;

public class ShoppingCartTest {

	private static ShoppingCart cart;

//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//
//		cart = new ShoppingCart();
//
//		SmartCard smartCard = new SmartCard(1);
//
//		smartCard.setQty(1);
//
//		cart.addItem(smartCard);
//		cart.addItem(smartCard);
//
//	}

	@Test
	public void testAddItem() {

		cart = new ShoppingCart();

		SmartCard smartCard = new SmartCard();

		smartCard.setCardBalance(10);

		cart.addItem(smartCard);
		cart.addItem(smartCard);

		Map<SmartCard, Integer> item = cart.getItems();
		int qty = item.get(smartCard);

		assertEquals(2, qty);
	}

	@Test
	public void testGetTotalAmount() {
		ShoppingCart cart = new ShoppingCart();

		assertEquals(10.0f, cart.getTotalAmount(), 10.0f);
	}

	@Test
	public void testClear() {
		cart.clear();
	}

//	@Test
//	public void testRemoveItem() {
//
//	}

}
