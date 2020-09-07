package mlab.Model.dao;

import ASD.SmartCard.Model.UserModel;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import java.util.ArrayList;
import org.bson.Document;

public class MongoDB {

    //public static MongoClient mongoClient;
    public static DB database;
    public static DBCollection asd_smartcard_app_test;

    public ArrayList<Document> users = new ArrayList();
    private String owner = "heroku_lcjwqk0m";
    private String password = "rl8a576pdf1dbb7e3armg0vfjt";
    private String connectionStringPostfix = "@ds011288.mlab.com:11288/heroku_lcjwqk0m";

    public MongoDB(String owner, String password) {
        this.owner = owner;
        this.password = password;
    }

    public static void main(String args[]){
        // connect to server (no problem)
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        System.out.println("wai yue!!!!!!!!! server connection successfully done");

        // connect to mLab - mongodb://heroku_lcjwqk0m:rl8a576pdf1dbb7e3armg0vfjt@ds011288.mlab.com:11288/heroku_lcjwqk0m
        String client_url = "mongodb://heroku_lcjwqk0m:rl8a576pdf1dbb7e3armg0vfjt@ds011288.mlab.com:11288/heroku_lcjwqk0m";
        MongoClientURI uri = new MongoClientURI(client_url);
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        MongoIterable<String> mongoIterable = db.listCollectionNames();
        MongoCursor<String> iterator = mongoIterable.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        client.close();

    }

    // connect to mLab
//    public MongoDatabase getMongoDB() {
//        MongoClientURI uri = new MongoClientURI("mongodb://" + this.owner + ":" + this.password + connectionStringPostfix);
//        MongoDatabase db;
//
//        try (MongoClient client = new MongoClient(uri)) {
//            db = client.getDatabase(uri.getDatabase());
//            MongoIterable<String> mongoIterable = db.listCollectionNames();
//            MongoCursor<String> iterator = mongoIterable.iterator();
//
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }
//
//            client.close();
//        }
//
//        return db;
//    }
}


