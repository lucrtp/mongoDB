package com.mongodb.dao;

import java.awt.List;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mongodb.db.MongodbConnectionManager;
import com.mongodb.field.iCollection;
import com.mongodb.field.iField;

public class Dorder extends Dcore implements iCollection, iField {

	public Dorder() {
		collection = MongodbConnectionManager
				.getDbCollection(iCollection_Order);
	}

	@Override
	public WriteResult deleteData(BasicDBObject dbo) {
		return null;
	}

	@Override
	public WriteResult updateData(BasicDBObject dbo) {
		return null;
	}

	@Override
	public WriteResult insertData(String data,String valuekey) {
		return null;
	}

	@Override
	public DBCursor query(DBObject ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WriteResult insetListData(ArrayList<DBObject> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
