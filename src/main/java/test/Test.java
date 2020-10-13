/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import Utils.Util;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
/**
 *
 * @author daohuxia
 */
public class Test {
     public static void main(String[] args) {



        MongoDatabase database = Util.getConnect();

        MongoCollection<Document> collection = database.getCollection("Admin");
       
        
        //3.insert into database        
        Document document = new Document();
        document.put("userID", "321");
            
        collection.deleteOne(document);

    }
    
}
