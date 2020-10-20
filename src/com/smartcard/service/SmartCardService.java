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
	
	public void listCard() {
		// TODO call listAll() from the DAO
		
	}





}
