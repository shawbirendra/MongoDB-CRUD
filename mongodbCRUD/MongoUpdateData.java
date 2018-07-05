package com.birendra4java.mongodbCRUD;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;

public class MongoUpdateData {
	public static void main(String[] args) {
		MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("Employee");

		// updating the details...
		UpdateResult res = collection.updateOne(Filters.eq("id", "500"), Updates.set("name", "divya"));
		System.out.println("Result::" + res.getMatchedCount());
		if (res.getMatchedCount() > 0) {
			System.out.println("Updated Succesfully");
		} else {
			System.out.println("Updation Failed....Try with correct details");
		}
		FindIterable<Document> iterDoc = collection.find();

		// Getting the iterator
		Iterator<Document> it = iterDoc.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		client.close();

		//

	}
}
