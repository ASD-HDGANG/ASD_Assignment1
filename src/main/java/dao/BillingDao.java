/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.BasicDBObject;
import entity.Billing;
import entity.Billing;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
/**
 *
 * @author Martin
 */
public class BillingDao {
    MongoClient mongoClient;     
    MongoDatabase database;
    MongoCollection<Document> collection;
    
    public BillingDao(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
		this.database = mongoClient.getDatabase("heroku_lcjwqk0m");
		this.collection = database.getCollection("Billing");
	}
    
        public Billing get(orderID){
        
        }
    
}
