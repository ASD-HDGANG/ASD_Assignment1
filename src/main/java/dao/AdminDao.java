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
import entity.Admin;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author jiebin
 */
public class AdminDao {
        MongoClient mongoClient;     
	MongoDatabase database;
	MongoCollection<Document> collection;

	public AdminDao(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
		database = mongoClient.getDatabase("heroku_lcjwqk0m");
		collection = database.getCollection("Admin");                
           
	}
        
                
        public void deleteAdmin(String userID){
            Document document = new Document();
            document.put("userID", userID);
         
            
            collection.deleteOne(document);
        }
        
        
        public ArrayList<Admin> allAdmin(){
            ArrayList<Admin> temp = new ArrayList();
            for(Document doc:collection.find()){
                String userID = doc.get("userID").toString();
                temp.add(new Admin(userID));
            }
            return temp;
        }
        
 
      
        }
        
        

