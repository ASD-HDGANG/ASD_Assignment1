package com.smartcard.dao;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.smartcard.entity.SmartCard;
import com.smartcard.entity.User;

public class SmartCardDAO implements IGenericDAO<SmartCard> {

	MongoDatabase database = dBUtils.getMongoDB();
	MongoCollection<SmartCard> scTbl = database.getCollection("SmartCard", SmartCard.class);

	@Override
	public SmartCard create(SmartCard smartcard) {
		smartcard.setLastUpdateTime(new Date());

		try {

			MongoCollection<SmartCard> scTbl = database.getCollection("SmartCard", SmartCard.class);

			Document scDoc = new Document("_id", new ObjectId());

			// scDoc.append("smartCardId", )

		} catch (Exception e) {
			e.printStackTrace();
		}

		return smartcard;
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

	public String getCardRandom() {

		Random rand = new Random();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			sb.append(rand.nextInt(9));
		}

		String smartCardNumber = sb.toString();

		System.out.println("Card number: " + smartCardNumber);

		return String.format("%16d", smartCardNumber);
	}

	public String getSecurityCode() {

		Random rand = new Random();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb.append(rand.nextInt(9));
		}

		String securityCode = sb.toString();

		System.out.println("Card number: " + securityCode);

		return String.format("%4d", securityCode);
	}

	// FOR TEST PURPOSE
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoDatabase database = dBUtils.getMongoDB();

		// get a handle to the collection (table)
		MongoCollection<User> coll = database.getCollection("User", User.class);

		Random rand = new Random();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			sb.append(rand.nextInt(9));
		}

		String smartCardNumber = sb.toString();

		System.out.println("Card number: " + smartCardNumber);

		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb1.append(rand.nextInt(9));
		}

		String securityCode = sb1.toString();

		System.out.println("Card number: " + securityCode);

	}

}
