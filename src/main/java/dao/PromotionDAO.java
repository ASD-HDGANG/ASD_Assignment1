/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.Promotion;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Kyle Zeng
 */
public class PromotionDAO {
    MongoClient mongoClient;     
	MongoDatabase database;
	MongoCollection<Document> collection;

	public PromotionDAO(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
		database = mongoClient.getDatabase("heroku_lcjwqk0m");
		collection = database.getCollection("Promotion");                
           
	}
        
        public void addPromotion(String title, String startDate, String endDate, String author, String status, String description){
            Document document = new Document();
            
            document.put("title",title);
            document.put("startDate",startDate);
            document.put("endDate",endDate);
            document.put("author",author);
            document.put("status",status);
            document.put("description",description);
            
            collection.insertOne(document);
        }
                
        public void deletePromotion(String email){
            Document document = new Document();
            document.put("email", email);      
            
            collection.deleteOne(document);
        }
        
        public void updateShipment(String title, String startDate, String endDate, String author, String status, String description){
        //fix document
        Document document = new Document();
        
        //update element
	Document updateDocument = new Document();
     
	updateDocument.put("title",title);
        updateDocument.put("startDate",startDate);
        updateDocument.put("endDate",endDate);
        updateDocument.put("author",author);
        updateDocument.put("status",status);
        updateDocument.put("description",description);
        
        //update 
	Document setDocument = new Document();
	setDocument.put("$set",updateDocument);
	collection.updateMany(document,setDocument);
            
        }
        
        public ArrayList<Promotion> allPromotion(){
            ArrayList<Promotion> temp = new ArrayList();
            for(Document doc:collection.find()){
                String title = doc.get("title").toString();
                String startDate=doc.get("startDate").toString();
                String endDate=doc.get("endDate").toString();
                String author=doc.get("author").toString();
                String status=doc.get("status").toString();
                String description=doc.get("description").toString();

                temp.add(new Promotion(title, startDate, endDate, author, status, description));
            }
            return temp;
        }
}
