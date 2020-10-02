package smartcardDemo.dao;

import java.util.concurrent.TimeUnit;

import org.bson.Document;

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

		try {
			ConnectionString connectiontring = new ConnectionString(
					"mongodb://hugh:hugh990104@ds011288.mlab.com:11288/heroku_lcjwqk0m");
			MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectiontring)
					.applicationName("smartcard")
					.applyToConnectionPoolSettings(builder -> builder.maxWaitTime(10000, TimeUnit.MILLISECONDS))
					.retryWrites(false).build();
			MongoClient mongoClient = MongoClients.create(clientSettings);
//
//        MongoIterable<String> databaseName = mongoClient.listDatabaseNames();
//        databaseName.forEach(name -> System.out.println(name));		

			MongoDatabase database = mongoClient.getDatabase("heroku_lcjwqk0m");

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
