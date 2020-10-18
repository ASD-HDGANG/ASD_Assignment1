package com.smartcard.controller.frontend.shoppingcart;

import java.util.HashMap;
import java.util.Map;

import com.smartcard.entity.SmartCard;

public class ShoppingCart {

	private Map<SmartCard, Integer> cart = new HashMap<>();

	public void addItem(SmartCard smartCard) {

		if (cart.containsKey(smartCard)) {
			Integer qty = cart.get(smartCard) + 1;
			cart.put(smartCard, qty);
		} else {
			cart.put(smartCard, 1);
		}
	}

	public Map<SmartCard, Integer> getItems() {
		return this.cart;
	}

	public static void main(String[] args) {
	}

}
