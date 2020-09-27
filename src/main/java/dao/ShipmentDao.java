/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Utils.Util;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.shipment;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author jiebin
 */
public class ShipmentDao {
        MongoClient mongoClient;     
	MongoDatabase database;
	MongoCollection<Document> collection;

	public ShipmentDao(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
		database = mongoClient.getDatabase("heroku_lcjwqk0m");
		collection = database.getCollection("Shipment");                
           
	}
        
        public void addShipment(String name, String email, String phone_number, String address, String city, String territory, String post_code, String arriveDate, String shipmentMethod,String currentStatus){
            Document document = new Document();
            
            document.put("name",name);
            document.put("email",email);
            document.put("phone_number",phone_number);
            document.put("address",address);
            document.put("city",city);
            document.put("territory",territory);
            document.put("post_code",post_code);
            document.put("arriveDate",arriveDate);
            document.put("shipmentMethod",shipmentMethod);
            document.put("currentStatus",currentStatus);
            
            collection.insertOne(document);
        }
                
        public void deleteShipment(String email){
            Document document = new Document();
            document.put("email", email);
         
            
            collection.deleteOne(document);
        }
        
        
        public ArrayList<shipment> allShipment(){
            ArrayList<shipment> temp = new ArrayList();
            for(Document doc:collection.find()){
                String preferName = doc.get("name").toString();
                String email=doc.get("email").toString();
                String phone_number=doc.get("phone_number").toString();
                String address=doc.get("address").toString();
                String city=doc.get("city").toString();
                String territory=doc.get("territory").toString();
                String post_code=doc.get("post_code").toString();
                String arriveDate=doc.get("arriveDate").toString();
                String shipmentMethod=doc.get("shipmentMethod").toString();
                String currentStatus=doc.get("currentStatus").toString();
                temp.add(new shipment(preferName,email,phone_number,address,city,territory,post_code,arriveDate,shipmentMethod,currentStatus));
            }
            return temp;
        }
        
        public shipment searchShipment(String email){
            for(Document doc: collection.find()){
            if(doc.get("email").equals(email)){
                String preferName = doc.get("name").toString();
                String phone_number=doc.get("phone_number").toString();
                String date = doc.get("arriveDate").toString();
                String address=doc.get("address").toString();
                String city=doc.get("city").toString();
                String territory=doc.get("territory").toString();
                String post_code=doc.get("post_code").toString();
                String shipmentMethod=doc.get("shipmentMethod").toString();
                String currentStatus=doc.get("currentStatus").toString();
                return new shipment(preferName,email,phone_number,address,city,territory,post_code,date,shipmentMethod,currentStatus);
            }
        }
            return null;
        }
        
        public void updateShipment(String name, String email, String phone_number, String address, String city, String territory, String post_code, String date, String shipmentMethod,String currentStatus){
        //fix document
        Document document = new Document();
	document.put("email",email);
    
        
        //update element
	Document updateDocument = new Document();
	updateDocument.put("name",name);
        updateDocument.put("phone_number",phone_number);
        updateDocument.put("address",address);
        updateDocument.put("city",city);
        updateDocument.put("territory",territory);
        updateDocument.put("post_code",post_code);
        updateDocument.put("shipmentMethod",shipmentMethod);
        updateDocument.put("currentStatus",currentStatus);
        updateDocument.put("arriveDate",date);
        
        //update 
	Document setDocument = new Document();
	setDocument.put("$set",updateDocument);
	collection.updateMany(document,setDocument);
            
        }
        }
        
        

