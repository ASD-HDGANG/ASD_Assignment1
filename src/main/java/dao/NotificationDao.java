/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.Billing;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Martin
 */
public class NotificationDao {
    MongoClient mongoClient;     
    MongoDatabase database;
    MongoCollection<Document> collection;
    
    public NotificationDao(MongoClient mongoClient){
        this.mongoClient = mongoClient;
        this.database = mongoClient.getDatabase("heroku_lcjwqk0m");
        this.collection = database.getCollection("Notification");
    }
    
    public Document get(int notificationID){
           for (Document doc : collection.find()){
               if ((doc.get("notificationID")).equals(notificationID)){
                   return doc;
               }
           }
           return null;
        }
    
    public void create() {
        
            Document document = new Document();
        
            
            collection.insertOne(document);
        }
    
    public void delete(int notificationID){
            Document document = new Document();
            document.put("notificationID", notificationID);
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
                
                documents.add(new Billing(orderID,customerID,paymentMethod,paymentDate,billDateGenerated,tax,service,location,amount));
            }
            return documents;
}
