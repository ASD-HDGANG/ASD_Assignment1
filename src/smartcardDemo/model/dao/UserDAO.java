package smartcardDemo.model.dao;

import com.mongodb.BasicDBObject;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import smartcardDemo.model.User;

import org.bson.Document;

public class UserDAO implements IGenericDAO<User> {

	public UserDAO() {

	}

	MongoDatabase mdb = dBUtils.getMongoDB();

	@Override
	public User create(User user) {
		return user;
	}

	@Override
	public User update(User user) {
		return user;

	}

	@Override
	public User get(Object userId) {
		return null;
	}

	public void findByEmail(String email) {

		// findbyEmail

		MongoCollection<Document> table = mdb.getCollection("Users");
		BasicDBObject emailQuery = new BasicDBObject();
		emailQuery.put("email", table);
		// DBCursor result = table.find(searchQuery);

	}

	@Override
	public void delete(Object id) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public List<User> listAll() {

//                SmartCard sc = new SmartCard(smartCardNumber,null,null,null,null,null);
//             for (Document doc : collection.find()) {
//	       if (((String) doc.get("smartCardNumber")).equals(smartCardNumber)) {
//				sc.setCardNumber((String)doc.get("smartCardNumber"));
//				sc.setSecurityCode((String)doc.get("securityCode"));
//                                sc.setUserId("empty");
//                                sc.setCardType((String)doc.get("smartCardType"));
//				sc.setCardBalance((String)doc.get("smartCardBalance"));
//                                sc.setCardStatus((String)doc.get("smartCardStatus"));    
//                  }
//		}  
//        
		return null;
	}

	@Override
	public Long count() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

}
