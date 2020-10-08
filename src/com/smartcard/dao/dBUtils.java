package com.smartcard.dao;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.concurrent.TimeUnit;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public class dBUtils {

	private MongoCollection<Document> collection;

	public static MongoDatabase getMongoDB() {

		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));

		try {
			ConnectionString connectiontring = new ConnectionString(
					"mongodb://hugh:hugh990104@ds011288.mlab.com:11288/heroku_lcjwqk0m");
			MongoClientSettings clientSettings = MongoClientSettings.builder().codecRegistry(pojoCodecRegistry)
					.applicationName("smartcard")
					.applyToConnectionPoolSettings(builder -> builder.maxWaitTime(20000, TimeUnit.MILLISECONDS))
					.applyConnectionString(connectiontring).retryWrites(false).build();

			MongoClient mongoClient = MongoClients.create(clientSettings);

			MongoDatabase database = mongoClient.getDatabase("heroku_lcjwqk0m").withCodecRegistry(pojoCodecRegistry);

			//mongoClient.close(); // this causing the state should open error

			return database;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void showCollection() {
		MongoCursor<Document> cursor = this.collection.find().iterator();
		while (cursor.hasNext()) {
			PrettyJson.printJSON(cursor.next());
		}
	}

}
