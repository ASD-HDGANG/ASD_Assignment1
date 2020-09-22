/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASD.SmartCard.Dao;

import com.mongodb.ConnectionString;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;





/**
 *
 * @author daohuxia
 */

public class MongoDBUtils {
    public static MongoDatabase getConnect()
    {
    ConnectionString connString = new ConnectionString("mongodb://<dbuser>:<dbpassword>@ds011288.mlab.com:11288/heroku_lcjwqk0m");
    MongoClientSettings settings = MongoClientSettings.builder()
         .applyConnectionString(connString)
            .retryWrites(false)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase("heroku_lcjwqk0m");
    return database;
    
    
}}

