package com.smartcard.controller.frontend.shoppingcart;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.smartcard.entity.SmartCard;

public class ShoppingCartTest {

	@Test
	public void testAddItem() {
		ShoppingCart cart = new ShoppingCart();

		SmartCard smartCard = new SmartCard();

		smartCard.setCardBalance(10);

		cart.addItem(smartCard);
		cart.addItem(smartCard);

		Map<SmartCard, Integer> item = cart.getItems();
		int qty = item.get(smartCard);

		assertEquals(2, qty);

	}

}
