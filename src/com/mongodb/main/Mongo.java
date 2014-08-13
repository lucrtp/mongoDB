package com.mongodb.main;

import com.mongodb.BasicDBObject;
import com.mongodb.WriteResult;
import com.mongodb.dao.Dcutomer;
import com.mongodb.field.iField;

public class Mongo implements iField {

	public static void main(String[] args) {
		Dcutomer dcutomer = new Dcutomer();
		System.out.println(dcutomer.count());

//		DBCursor cusor = dcutomer.queryFind(2);
//		DBObject dbo;
//		while (cusor.hasNext()) {
//			dbo = cusor.next();
//		   	dbo.get(iCustomer_address);
//		}
//		WriteResult wr=dcutomer.updateDataEmail("luctrph@gmail.com", "53eb1b074e11251b8cde3a5c");
		BasicDBObject dbObject = new BasicDBObject(iCustomer_email, "luctrph@gmail.com");
		WriteResult wr= dcutomer.updateValueInArray("53eb1b074e11251b8cde3a5c",dbObject , "$pull");
		System.out.println(wr);
	}
}
