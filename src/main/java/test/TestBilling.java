/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Utils.Util;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.BillingDao;
import dao.MongoDBConnector;
import dao.SmartCardDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.bson.Document;

/**
 *
 * @author Martin
 */
public class TestBilling {
    public static void main(String[] args){
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("Billing");
        
            
        //    for(Document doc: collection.find()){
                
         //       if(doc.get("orderID").equals(101)){
         //           System.out.println(doc.get("paymentMethod"));
         //       }
               
         //   }
           
        
               
        Document document = new Document();
        
        document.put("orderID", 102);
        
        collection.deleteMany(document);
        
        
        //Document document = new Document();
        
            document.put("orderID",102);
            document.put("customerID",101);
            document.put("paymentMethod","credit card");
            document.put("paymentDate","2002");
            document.put("billDateGenerated","2002");
            document.put("tax","%4.0");
            document.put("service","Top Up");
            document.put("amount",500);
        
            collection.insertOne(document);
        
     }
    
   
    
    
    public void testCreate(){
        
    }
        
    
}
