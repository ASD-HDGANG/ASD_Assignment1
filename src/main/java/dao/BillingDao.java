/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import entity.Billing;
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
    
        public Document get(int orderID){
           for (Document doc : collection.find()){
               if ((doc.get("orderID")).equals(orderID)){
                   return doc;
               }
           }
           return null;
        }
        
        public void create(int orderID, int customerID, String paymentMethod, String paymentDate, String billDateGenerated, String tax, String service,String location, Double amount) {
        
            Document document = new Document();
        
            document.put("orderID",orderID);
            document.put("customerID",customerID);
            document.put("paymentMethod",paymentMethod);
            document.put("paymentDate",paymentDate);
            document.put("billDateGenerated",billDateGenerated);
            document.put("tax",tax);
            document.put("service",service);
            document.put("location", location);
            document.put("amount",amount);
        
            collection.insertOne(document);
        }
    
        public void delete(int orderID){
            Document document = new Document();
            document.put("orderID", orderID);
            collection.deleteMany(document);
        }
        
        public ArrayList<Billing> readAll(){
           ArrayList<Billing> documents = new ArrayList();
            
            for (Document doc : collection.find()){
                
                int orderID = Integer.parseInt(doc.get("orderID").toString());
                int customerID = Integer.parseInt(doc.get("customerID").toString());
                String paymentMethod=doc.get("paymentMethod").toString();
                String paymentDate=doc.get("paymentDate").toString();
                String billDateGenerated=doc.get("billDateGenerated").toString();
                String tax=doc.get("tax").toString();
                String service=doc.get("service").toString();
                String location = doc.get("location").toString();
                String amount= doc.get("amount").toString();
                System.out.println(orderID);
                
                documents.add(new Billing(1,1,"m","m","m","m","m","m","m"));
            }
            return documents;
        }
}
