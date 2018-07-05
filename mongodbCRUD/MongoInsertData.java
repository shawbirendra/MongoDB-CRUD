package com.birendra4java.mongodbCRUD;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoInsertData {
	public static void main(String[] args) {
		// to connect with mongodb
		MongoClient client = new MongoClient("localhost", 27017);
		// getting access to database.. if not available, it will create new one with this name 'test'
		MongoDatabase database = client.getDatabase("test");
		// getting Collections from database.if not available, it will create new one with this name 'Employee'
		MongoCollection<Document> collection = database.getCollection("Employee");
		//put data in map Collection
		/*
		    Map<String,Object> m=new HashMap<>();
			m.put("id", "500");
			m.put("name", "krishna");
			m.put("address", "mum");
			m.put("phone", "546325");
		*/
		/**
		 * Map Collection can not be used to store data. for mongo, we have to use document class of mongo
		 * To store multiple document at a time,add document in list collection and store.
		 * e.g.,
		 * 
		 */
		
		// Creating single documents to add in mongo collections
		/*
		Document document = new Document();
		document.append("id", "200");
		document.append("name", "radha");
		document.append("address", "pune");
		document.append("phone", "78564");
		*/
		/*//adding document to collection
		collection.insertOne(document);*/
		
		// Creating multiple documents to add in mongo collections
		/**
		 * Creating multiple documents instances
		 */
		Document document1 = new Document();
		document1.append("id", "300");
		document1.append("name", "rani");
		document1.append("address", "kol");
		document1.append("phone", "56975");
		
		Document document2 = new Document();
		document2.append("id", "301");
		document2.append("name", "sushma");
		document2.append("address", "shimla");
		document2.append("phone", "65987");
		
		Document document3 = new Document();
		document3.append("id", "302");
		document3.append("name", "mamta");
		document3.append("address", "delhi");
		document3.append("phone", "78564");
		
		/**
		 * Adding multiple document instances in list Collection
		 */
		List<Document> listOfDocuments=new ArrayList<>();
		listOfDocuments.add(document1);
		listOfDocuments.add(document2);
		listOfDocuments.add(document3);
		
		//----------Calling insertMany(-) to save multiple document instances placed in list
	
		collection.insertMany(listOfDocuments);
		
		System.out.println("documents inserted successfully");
		// closing connection
		client.close();

	}
}
