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
    
    public Document get(int notificationID){
           for (Document doc : collection.find()){
               if ((doc.get("notificationID")).equals(notificationID)){
                   return doc;
               }
           }
           return null;
        }
    
    public void create(int notificationID, String customerID, String createdDate, String notificationDate, String type, String priority, String message) {
        
            Document document = new Document();
            
            document.put("notificationID",notificationID);
            document.put("customerID",customerID);
            document.put("createdDate",createdDate);
            document.put("notificationDate",notificationDate);
            document.put("type",type);
            document.put("priority",priority);
            document.put("message",message);
        
            collection.insertOne(document);
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
                String type=doc.get("type").toString();
                String priority=doc.get("priority").toString();
                String message=doc.get("message").toString();
                
                
                
                //documents.add(new Notification(notificationID,customerID,createdDate,notificationDate,type,priority,message));
            }
            return documents;
     }
}
