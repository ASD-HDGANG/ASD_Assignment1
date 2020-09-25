package uts.asd.model.dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class dBUtils {

    public static MongoDatabase getMongoDB() {

        try {
            ConnectionString connectiontring = new ConnectionString("mongodb://hugh:hugh990104@ds011288.mlab.com:11288/heroku_lcjwqk0m");
            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .applyConnectionString(connectiontring)
                    .applicationName("smartcard")
                    .applyToConnectionPoolSettings(builder -> builder.maxWaitTime(10000, TimeUnit.MILLISECONDS))
                    .retryWrites(false)
                    .build();
            MongoClient mongoClient = MongoClients.create(clientSettings);

//        MongoIterable<String> dbIterable = mongoClient.listDatabaseNames();
//
//        List<String> dbnames = new ArrayList<>();
//
//        for (String name : dbIterable) {
//            System.out.println(name);
//            dbnames.add(name);
//        }
//        Assert.assertNotNull(mongoClient);
            MongoDatabase database = mongoClient.getDatabase("heroku_lcjwqk0m");

            return database;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}





