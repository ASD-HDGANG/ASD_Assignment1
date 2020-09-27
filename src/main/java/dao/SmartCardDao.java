/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.BasicDBObject;
import entity.SmartCard;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


public class SmartCardDao {
   
        MongoClient mongoClient;     
	MongoDatabase database;
	MongoCollection<Document> collection;

	public SmartCardDao(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
		database = mongoClient.getDatabase("heroku_lcjwqk0m");
		collection = database.getCollection("SmartCard");
	}
	public List<SmartCard> listLinkedSmartCard(String userId) {
		 List<SmartCard> list = new ArrayList<>();
               for (Document doc : collection.find()) {
	       if (((String) doc.get("userId")).equals(userId)) {
			       SmartCard smartCard = new SmartCard(null,null,userId,null,null,null);
				smartCard.setCardNumber((String)doc.get("smartCardNumber"));
				smartCard.setSecurityCode((String)doc.get("securityCode"));
                                smartCard.setCardType((String)doc.get("smartCardType"));
                                smartCard.setCardBalance((String)doc.get("smartCardBalance"));
                                smartCard.setCardStatus((String)doc.get("smartCardStatus"));
				list.add(smartCard); 
			}
		}  
		return list;
	}
}

