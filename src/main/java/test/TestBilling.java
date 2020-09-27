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
import entity.Billing;
import java.io.IOException;
import java.util.ArrayList;
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
                //System.out.println(paymentDate);
                
                documents.add(new Billing(orderID,customerID,paymentMethod,paymentDate,billDateGenerated,tax,service,location,amount));
                
            }
                
          /*    
        Document document = new Document();
        
        document.put("orderID", 102);
        
        collection.deleteMany(document);
        
        
        for(int i = 0; i < 5; i++){
        Document document = new Document();
        
            document.put("orderID",100+i);
            document.put("customerID",100+i);
            document.put("paymentMethod","credit card");
            document.put("paymentDate","2002");
            document.put("billDateGenerated","2002");
            document.put("tax","%4.0");
            document.put("service","Top Up");
            document.put("location","sydney");
            document.put("amount","500");
        
            collection.insertOne(document);
        }
*/
     }
    
   
    
    
}
