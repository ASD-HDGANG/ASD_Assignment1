package com.smartcard.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.DB;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSUploadStream;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import com.smartcard.entity.Customer;
import com.smartcard.entity.SmartCard;

public class SmartCardDAO implements IGenericDAO<SmartCard> {

	MongoDatabase database = MongoUtils.getMongoDB();
	MongoCollection<SmartCard> scTbl = database.getCollection("SmartCard", SmartCard.class);

	@Override
	public SmartCard create(SmartCard smartCard) {
		smartCard.setLastUpdateTime(new Date());

		try {

			MongoCollection<Document> scTbl = database.getCollection("SmartCard_Tbl");

			Customer customer = new Customer();

			Document scDoc = new Document("_id", new ObjectId()).append("securityCode", getSecurityCode())
					.append("customerId", customer).append("smartCardNumber", getCardNumber());

			scTbl.insertOne(scDoc);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return smartCard;
	}

	@Override
	public SmartCard update(SmartCard smartCard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SmartCard get(Object smartCardId) {
		// TODO get balance
		return null;
	}

	@Override
	public void delete(Object smartCardId) {
		// TODO Auto-generated method stub

	}

//	public void deposit(double amount) {
//		balance += amount;
//	}
//
//	public void transferTo(double amount, Trip transport) {
//		balance -= amount;
//		transport.balance += amount;
//	}

	@Override
	public List<SmartCard> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

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

	public String getCardNumber() {

		Random rand = new Random();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			sb.append(rand.nextInt(9));
		}

		String smartCardNumber = sb.toString();

		System.out.println("Card number: " + smartCardNumber);

		return String.format(smartCardNumber);
	}

	public String getSecurityCode() {

		Random rand = new Random();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb.append(rand.nextInt(9));
		}

		String securityCode = sb.toString();

		System.out.println("Card number: " + securityCode);

		return String.format(securityCode);
	}

	private String formatted(double balance) {
		return new DecimalFormat("###,##0.00").format(balance);
	}

	// FOR TEST PURPOSE
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoDatabase database = MongoUtils.getMongoDB();

		SmartCardDAO scDAO = new SmartCardDAO();

		// get a handle to the collection (table)
		MongoCollection<Document> scTbl = database.getCollection("SmartCard_Tbl");

		// Customer customer = new Customer();

		Document scDoc = new Document("_id", new ObjectId()).append("security code", scDAO.getSecurityCode())
				.append("smart card number", scDAO.getCardNumber())
				.append("card type", Arrays.asList("adult", "child/youth", "concession", "senior"))
				.append("card balance", 10).append("card status", "");

		scTbl.insertOne(scDoc);

		// File("D:/Users/Patty/eclipse-workspace/SmartCardWebsite/WebContent/resources/images/adult.jpg");

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
