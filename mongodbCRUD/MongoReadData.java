package com.birendra4java.mongodbCRUD;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoReadData {
	public static void main(String[] args) {
		MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("Employee");
		
		// read the available data...
		FindIterable<Document> iterDoc = collection.find();

		// Getting the iterator
		Iterator<Document> it = iterDoc.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		//closing connections
		client.close();
		//

	}
}
