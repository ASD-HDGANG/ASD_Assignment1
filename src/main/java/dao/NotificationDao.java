/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.Notification;
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
    
    public Notification get(int notificationID){
           for (Document doc : collection.find()){
               if ((doc.get("notificationID")).equals(notificationID)){
                   String customerID = doc.get("customerID").toString();
                   String createdDate = doc.get("createdDate").toString();
                   String notificationDate = doc.get("notificationDate").toString();
                   String priority = doc.get("priority").toString();
                   String message = doc.get("message").toString();
                           
                   return new Notification(notificationID, customerID, createdDate, notificationDate, priority, message);
               }
           }
           return null;
        }
    
    public void create(int notificationID, String customerID, String createdDate, String notificationDate, String priority, String message) {
        
            Document document = new Document();
            
            document.put("notificationID",notificationID);
            document.put("customerID",customerID);
            document.put("createdDate",createdDate);
            document.put("notificationDate",notificationDate);
            document.put("priority",priority);
            document.put("message",message);
        
            collection.insertOne(document);
        }
    
    public void update(Notification notification, String notificationDate, String priority, String message){
        
        //find document that you want to update from database
        Document document = new Document();
	document.put("notificationID",notification.getNotificationID());
        document.put("customerID",notification.getCustomerID());
        document.put("createdDate",notification.getCreatedDate());
        document.put("notificationDate",notification.getNotificationDate());
        document.put("priority",notification.getPriority());
        document.put("message",notification.getMessage());
        
        //updated document
	Document updateDocument = new Document();
	updateDocument.put("notificationID",notification.getNotificationID());
        updateDocument.put("customerID",notification.getCustomerID());
        updateDocument.put("createdDate",notification.getCreatedDate());
        updateDocument.put("notificationDate",notificationDate);
        updateDocument.put("priority",priority);
        updateDocument.put("message",message);
        
        //update 
	collection.updateOne(document, updateDocument);
    }
    
    public void delete(int notificationID){
            Document document = new Document();
            document.put("notificationID", notificationID);
            collection.deleteMany(document);
        }
    
     public ArrayList<Notification> readAll(){
           ArrayList<Notification> documents = new ArrayList();
            
            for (Document doc : collection.find()){
                
                int notificationID = Integer.parseInt(doc.get("notificationID").toString());
                String customerID = doc.get("customerID").toString();
                String createdDate=doc.get("createdDate").toString();
                String notificationDate=doc.get("notificationDate").toString();
                String priority=doc.get("priority").toString();
                String message=doc.get("message").toString();
                
                
                
                documents.add(new Notification(notificationID,customerID,createdDate,notificationDate,priority,message));
            }
            return documents;
     }
}
