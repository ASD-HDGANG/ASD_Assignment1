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
import dao.MongoDBConnector;
import dao.NotificationDao;
import entity.Notification;
import java.net.UnknownHostException;
import java.util.Scanner;


import org.bson.Document;
/**
 *
 * @author daohuxia
 */
public class Test {
     public static void main(String[] args) throws UnknownHostException {

        MongoDatabase database = Util.getConnect();
        MongoDBConnector connector = new MongoDBConnector();
        MongoClient mongoClient = connector.openConnection();   
        Scanner scanner = new Scanner(System.in);

//        MongoCollection<Document> collection = database.getCollection("Reporting");
//
//
//        Document document = new Document();
//
//        document.put("description","this is a testing report description");
//
//        collection.insertOne(document);

        MongoCollection<Document> collection = database.getCollection("Notification");

        NotificationDao notificationDao = new NotificationDao(mongoClient);
        
        int x = scanner.nextInt();
        switch(x){
            case 1:
                Document document = new Document();
            
                document.put("notificationID",0);
                document.put("customerID","0");
                document.put("createdDate","12-12-2020");
                document.put("notificationDate","12-12-2020");
                document.put("priority","normal");
                document.put("message","hello there");

                collection.insertOne(document);
            case 2:
                Notification m = notificationDao.get(0);
                System.out.println(m.getMessage());
        }

    }
    
}
