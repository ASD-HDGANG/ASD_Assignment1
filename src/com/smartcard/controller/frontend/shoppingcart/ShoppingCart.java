package com.smartcard.controller.frontend.shoppingcart;

import java.util.HashMap;
import java.util.Iterator;
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

//	public int getTotalQuantity() {
//		int total = 0;
//		
//		Iterator<SmartCard> iterator = cart.keySet().iterator();
//		
//		while (iterator.hasNext()) {
//			Book nextCard = iterator.next();
//			Integer quantity = cart.get(nextCard);
//			total += quantity;
//		}
//		
//		return total;
//	}

	public void removeItem(SmartCard smartCard) {

		cart.remove(smartCard);
	}

	public double getTotalAmount() {
		double total = 0.0f;

		Iterator<SmartCard> iterator = cart.keySet().iterator();

		while (iterator.hasNext()) {
			SmartCard sc = iterator.next();
			double balance = cart.get(sc);
			double subTotal = balance * sc.getCardBalance();

			total += subTotal;

		}

		return total;
	}

	public void clear() {
		cart.clear();
	}

	public Map<SmartCard, Integer> getItems() {
		return this.cart;
	}

	public static void main(String[] args) {
	}

}
