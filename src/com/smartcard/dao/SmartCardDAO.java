package com.smartcard.dao;

import java.util.Date;
import java.util.List;

import com.smartcard.entity.SmartCard;

public class SmartCardDAO implements IGenericDAO<SmartCard> {

	@Override
	public SmartCard create(SmartCard smartcard) {
		smartcard.setTimeCreated(new Date());
		return create(smartcard);
	}

	@Override
	public SmartCard update(SmartCard t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SmartCard get(Object id) {
		// TODO get balance
		return null;
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SmartCard> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

// In Order DAO
//	public List<Order> listOrder(String smartCardNumber) {
//		List<Order> list = new ArrayList<>();
//		for (Document doc : collection.find()) {
//			if (((String) doc.get("smartCardNumber")).equals(smartCardNumber)) {
//				Order order = new Order(null, smartCardNumber, null, null, null, null);
//				order.setOrderId((String) doc.get("orderId"));
//				order.setFromLocation((String) doc.get("fromLocation"));
//				order.setToLoaction((String) doc.get("toLocation"));
//				order.setOrderType((String) doc.get("orderType"));
//				order.setOrderDate((String) doc.get("orderDate"));
//				list.add(order);
//			}
//		}
//		return list;
//	}

	public SmartCard findByCardType(String cardType) {
		return null;
//		List<SmartCard> result = super.findWithNamedQuery("Book.findByTitle", "title", title);
//		
//		if (!result.isEmpty()) {
//			return result.get(0);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
