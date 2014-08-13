package com.mongodb.dao;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mongodb.bo.Customer;
import com.mongodb.db.MongodbConnectionManager;
import com.mongodb.field.iCollection;
import com.mongodb.field.iField;

public class Dcutomer extends Dcore implements iCollection, iField {

	public Dcutomer() {
		collection = MongodbConnectionManager
				.getDbCollection(iCollection_Customer);
	}

	@Override
	public WriteResult deleteData(BasicDBObject dbo) {
		return null;
	}

	public WriteResult updateDataEmail(String data, String id) {
		ObjectId _id = new ObjectId(id);
		BasicDBObject query = new BasicDBObject(iCustomer_id, _id);
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.append("$push", new BasicDBObject(iCustomer_email, data));
		return collection.update(query, updateObject);
	}

	public WriteResult updateValueInArray(String strIDKey, BasicDBObject data,
			String action) {
		if (!action.isEmpty()) {
			if ('$' == action.charAt(0)) {
				ObjectId _id = new ObjectId(strIDKey);
				BasicDBObject query = new BasicDBObject(iCustomer_id, _id);
				BasicDBObject updateObject = new BasicDBObject(action, data);
				return collection.update(query, updateObject);
			}
		}

		return null;
	}

	@Override
	public WriteResult updateData(BasicDBObject dbo) {
		return null;
	}

	@Override
	public WriteResult insertData(String data, String valuekey) {
		BasicDBObject data2 = new BasicDBObject();
		BasicDBObject where = new BasicDBObject(iCustomer_id, valuekey);
		data2.append("$set", new BasicDBObject(iCustomer_email, data));

		return collection.insert(data2);
	}

	@Override
	public DBCursor query(DBObject ref) {
		// TODO Auto-generated method stub
		return collection.find();
	}

	@Override
	public WriteResult insetListData(ArrayList<DBObject> list) {
		return collection.insert(list);
	}

	public Customer findOne() {
		Customer customer = new Customer();
		DBObject cObject = collection.findOne();
		customer.set_id((ObjectId) cObject.get(iCustomer_id));
		customer.setAddress((String) cObject.get(iCustomer_address));
		customer.setEmail((ArrayList) cObject.get(iCustomer_email));
		customer.setPhone((ArrayList) cObject.get(iCustomer_phone));
		customer.setName((String) cObject.get(iCustomer_name));
		return customer;
	}

}
