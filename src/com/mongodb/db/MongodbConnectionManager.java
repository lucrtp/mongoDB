package com.mongodb.db;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

public class MongodbConnectionManager {
	private static MongoClient mongo;

	public static DB getDB(String dbName) {
		if (mongo == null) {
			initiazeMongo();
		}
		if (mongo != null) {
			DB db = mongo.getDB(dbName);
			return db;
		}
		return null;
	}

	private static boolean initiazeMongo() {
		MongodbConfigure mongodbConfigure = MongodbConfigure.getInstance();
		if (mongodbConfigure == null) {
			return false;
		}
		try {
			//MongoClientOptions option = new 
			mongo = new MongoClient(DBConst.mAddress, Integer.parseInt(DBConst.mPort));
		} catch (NumberFormatException | UnknownHostException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static DBCollection getDbCollection(String strCollection) {
		if (mongo == null) {
			initiazeMongo();
		}
		if (mongo != null) {
			DB db = mongo.getDB(DBConst.mDatabaseName);
			DBCollection collection = db.getCollection(strCollection);
			return collection;
		}
		return null;
	}

	public static DBCollection getDbCollection(String dbName,
			String strCollection) {
		if (mongo == null) {
			initiazeMongo();
		}
		if (mongo != null) {
			DB db = mongo.getDB(dbName);
			DBCollection collection = db.getCollection(strCollection);
			return collection;
		}
		return null;
	}

	public static DB getDefaultDB() {
		if (mongo == null) {
			initiazeMongo();
		}
		if (mongo != null) {
			DB db = mongo.getDB(DBConst.mDatabaseName);
			return db;
		}
		return null;
	}
}
