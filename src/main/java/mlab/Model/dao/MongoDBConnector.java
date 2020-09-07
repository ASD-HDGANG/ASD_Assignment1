/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlab.Model.dao;

import ASD.SmartCard.Model.UserModel;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Patty
 */
public class MongoDBConnector {

//    public static MongoClient mongoClient;
//    public static DB database;
    private static DBCollection asd_smartcard_app_test;
    private List<Document> users = new ArrayList();
    private String owner;
    private String password;
    private String connectionStringPostfix = "@ds011288.mlab.com:11288/heroku_lcjwqk0m";

    public MongoDBConnector(String owner, String password) {
        this.owner = owner;
        this.password = password;
    }

    // connect to mLab
    public MongoDatabase getMongoDB() {
        MongoClientURI uri = new MongoClientURI("mongodb://" + this.owner + ":" + this.password + connectionStringPostfix);
        MongoDatabase db;

        try (MongoClient client = new MongoClient(uri)) {
            db = client.getDatabase(uri.getDatabase());
        }
        return db;
    }

    public void addUser(UserModel user) {
        MongoClientURI uri = new MongoClientURI("mongodb://" + this.owner + ":" + this.password + connectionStringPostfix); // instantiate the dB

        try (MongoClient client = new MongoClient(uri)) {
            MongoDatabase db = client.getDatabase(uri.getDatabase());

//            users.add(new Document("Username", user.getEmail()).append("Password", user.getPassword()).append("Name", user.getName()).append("Phone", user.getPhone()));
//            MongoCollection<Document> userlist = db.getCollection("ASD-Demo-app-users"); //Create a collection ASD-Demo-app-users on mLab
//            userlist.insertMany(users);
            // login
            users.add(new Document("Username", user.getEmail())
                    .append("Email", user.getEmail())
                    .append("Password", user.getPassword())
                    .append("fName", user.getFirstName())
                    .append("lName", user.getLastName())
                    .append("Address", user.getAddress()));
            MongoCollection<Document> userlist = db.getCollection("ASD-app-users"); //Create a collection ASD-Demo-app-users on mLab
            userlist.insertMany(users);
        }
    }

}


