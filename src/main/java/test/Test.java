/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import Utils.Util;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import entity.shipment;

import org.bson.Document;
/**
 *
 * @author daohuxia
 */
public class Test {
     public static void main(String[] args) {

        MongoDatabase database = Util.getConnect();

        MongoCollection<Document> collection = database.getCollection("Shipment");

 /*       Document document = new Document();
        
        document.put("name", "try");
        document.put("shipmentMethod","123");
       
        
        collection.deleteOne(document);
        */
 
        //read
    /*    for(Document doc: collection.find()){
            if(doc.get("name").equals("jiebin")&&doc.get("city").equals("jiebin")){
                System.out.println(doc.get("name"));
            }
        }*/
    
        
    Document found = (Document) collection.find(new Document("email",1));
    
  
        

    }
    
}
