package com.birendra4java.mongodbCRUD;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongodbCreateCollection {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		// get access to database
		MongoDatabase database = mongoClient.getDatabase("local");
		// create Collection
		database.createCollection("Employee");
		System.out.println("Collection Successfully Created with name Employee");
		mongoClient.close();
	}
}
