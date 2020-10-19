package com.smartcard.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.smartcard.dao.MongoUtils;
import com.smartcard.dao.SmartCardDAO;
import com.smartcard.entity.SmartCard;

public class SmartCardService {

	private SmartCardDAO smartCardDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	MongoDatabase database = MongoUtils.getMongoDB();

	public SmartCardService(HttpServletRequest request, HttpServletResponse response) {

		super();
		smartCardDAO = new SmartCardDAO();
		this.request = request;
		this.response = response;
	}

	public void create(SmartCard sc) {

//		String smartCardNumber = req.getParameter("smartCardNumber");

		// Create or get table
		MongoCollection<Document> scTbl = database.getCollection("SmartCard_tbl");

		// create document (field)
		Document scDoc = new Document("SmartCardNumber", "").append("SecurityCode", "").append("Type",
				Arrays.asList("child", "adult", "senior"));

		scTbl.insertOne(scDoc);

//           
//          Bson update =  new Document("$set", new Document()
//            .append("smartCardNumber",sc.getCardNumber())
//            .append("securityCode",sc.getSecurityCode())
//            .append("userId",sc.getUserId())
//            .append("smartCardType",sc.getCardType())
//            .append("smartCardBalance",sc.getCardBalance())
//            .append("smartCardStatus",sc.getCardStatus()));
//              
//            Bson filter = Filters.eq("smartCardNumber", smartCardNumber);     
//            
//            collection.updateOne(filter,update);
//
//            req.setAttribute("unlink", "success");
//
//           req.getRequestDispatcher("/smartCardManagement.jsp").forward(req, resp);

	}

	public void viewSmartCardDetail() throws ServletException, IOException {

//		public List<SmartCard> listLinkedSmartCard(String userId) {
//		 List<SmartCard> list = new ArrayList<>();
//              for (Document doc : collection.find()) {
//	       if (((String) doc.get("userId")).equals(userId)) {
//			       SmartCard smartCard = new SmartCard(null,null,userId,null,null,null);
//				smartCard.setCardNumber((String)doc.get("smartCardNumber"));
//				smartCard.setSecurityCode((String)doc.get("securityCode"));
//                               smartCard.setCardType((String)doc.get("smartCardType"));
//                               smartCard.setCardBalance((String)doc.get("smartCardBalance"));
//                               smartCard.setCardStatus((String)doc.get("smartCardStatus"));
//				list.add(smartCard); 
//			}
//		}  
//		return list;
//	}
//

	}

	public void getSmartCardNumber() {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			sb.append(rand.nextInt(9));
		}
		String cardNumber = sb.toString();
	}

	public void getSecurityCode() {
		Random rand = new Random();
		StringBuilder rrs = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			rrs.append(rand.nextInt(9));
		}
		String securityCode = rrs.toString();
	}

}
