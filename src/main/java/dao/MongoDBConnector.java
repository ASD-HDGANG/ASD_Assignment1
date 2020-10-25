/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.net.UnknownHostException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.*;
import entity.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

/**
 *
 * @author yike8
 */
public class MongoDBConnector {
    MongoClient mongoClient;
    
    public MongoDBConnector() throws UnknownHostException {
		String dbUri = "mongodb://hugh:hugh990104@ds011288.mlab.com:11288/heroku_lcjwqk0m";
		mongoClient = new MongoClient(new MongoClientURI(dbUri));
                
	}

	public MongoClient openConnection() {
		return this.mongoClient;
	}

	public void closeConnection() {
		mongoClient.close();
	}
}
