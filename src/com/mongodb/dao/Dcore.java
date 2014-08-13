package com.mongodb.dao;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

abstract class Dcore {
	public DBCollection collection;

	abstract public DBCursor query(DBObject ref);

	abstract public WriteResult deleteData(BasicDBObject dbo);

	abstract public WriteResult updateData(BasicDBObject dbo);

	abstract public WriteResult insertData(String data,String valuekey);

	abstract public WriteResult insetListData(ArrayList<DBObject> list);

	public long count() {
		return collection.count();
	}

	public DBObject queryfindOne() {
		return collection.findOne();
	}

	public DBCursor queryFind(int limit) {
		return collection.find().limit(limit);
	}
}
