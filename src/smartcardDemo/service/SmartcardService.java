package smartcardDemo.service;

import java.io.IOException;
import java.net.UnknownServiceException;

import javax.servlet.ServletException;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import smartcardDemo.dao.SmartCardDAO;
import smartcardDemo.dao.dBUtils;
import smartcardDemo.entity.SmartCard;

public class SmartcardService {

	public SmartcardService() {
	}
	
	SmartCardDAO smartCardDAO = new SmartCardDAO();

	public void create(SmartCard smartcard) throws UnknownServiceException, ServletException, IOException {

		// this what I want to see. user is saved to db here
		try {
			MongoDatabase mdb = dBUtils.getMongoDB();
			assert mdb != null;

			// create or get collection
			MongoCollection<Document> users = mdb.getCollection("Users");

			// User newUser = new User(email, password, firstname);
			// userDAO.create(newUser);

//				users.add(new Document("id", user.getId()).append("Email", user.getEmail())
//						.append("Password", user.getPassword()).append("First Name", user.getFirstName())
//						.append("Address", asList(user.getAddressLine1(), user.getAddressLine2())));
//				userlist.insertMany(users);

			Document userDoc = new Document("Email", user.getEmail()).append("Password", user.getPassword())
					.append("First Name", user.getFirstName());

			Document addressDoc = new Document("Address1", user.getAddressLine1())
					.append("Address2", user.getAddressLine2()).append("Postcode", user.getPostcode())
					.append("State", user.getState());

			userDoc.put("Address", addressDoc);

			users.insertOne(userDoc);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//		public List<SmartCard> listLinkedSmartCard(String userId) {
//			 List<SmartCard> list = new ArrayList<>();
//	               for (Document doc : collection.find()) {
//		       if (((String) doc.get("userId")).equals(userId)) {
//				       SmartCard smartCard = new SmartCard(null,null,userId,null,null,null);
//					smartCard.setCardNumber((String)doc.get("smartCardNumber"));
//					smartCard.setSecurityCode((String)doc.get("securityCode"));
//	                                smartCard.setCardType((String)doc.get("smartCardType"));
//	                                smartCard.setCardBalance((String)doc.get("smartCardBalance"));
//	                                smartCard.setCardStatus((String)doc.get("smartCardStatus"));
//					list.add(smartCard); 
//				}
//			}  
//			return list;
//		}
//		
}
