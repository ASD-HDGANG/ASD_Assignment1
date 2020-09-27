/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.BasicDBObject;
import entity.Order;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


public class OrderDao {
   
        MongoClient mongoClient;     
	MongoDatabase database;
	MongoCollection<Document> collection;

	public OrderDao(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
		database = mongoClient.getDatabase("heroku_lcjwqk0m");
		collection = database.getCollection("Order");
	}
	public List<Order> listOrder(String smartCardNumber) {
		 List<Order> list = new ArrayList<>();
               for (Document doc : collection.find()) {
	       if (((String) doc.get("smartCardNumber")).equals(smartCardNumber)) {
			       Order order = new Order(null,smartCardNumber,null,null,null,null);
				order.setOrderId((String)doc.get("orderId"));
				order.setFromLocation((String)doc.get("fromLocation"));
                                order.setToLoaction((String)doc.get("toLocation"));
                                order.setOrderType((String)doc.get("orderType"));
                                order.setOrderDate((String)doc.get("orderDate"));
				list.add(order); 
			}
		}  
		return list;
	}
}

