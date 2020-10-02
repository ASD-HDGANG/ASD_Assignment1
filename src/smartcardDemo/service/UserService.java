package smartcardDemo.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import smartcardDemo.dao.UserDAO;
import smartcardDemo.dao.dBUtils;
import smartcardDemo.entity.User;

import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

public class UserService {

	private UserDAO userDAO;
	//private List<Document> users = new ArrayList<Document>();

	public UserService() {
	}

	public UserService(UserDAO userDAO, HttpServletRequest request, HttpServletResponse response) {
		userDAO = new UserDAO();
	}

	public void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// need to test
		userDAO.getAll();

	}

	public void create(User user) throws UnknownServiceException, ServletException, IOException {

		// this what I want to see. user is saved to db here
		try {
			MongoDatabase mdb = dBUtils.getMongoDB();
			assert mdb != null;

			// create or get collection
			MongoCollection<Document> users = mdb.getCollection("Users");

			// User newUser = new User(email, password, firstname);
			// userDAO.create(newUser);

//			users.add(new Document("id", user.getId()).append("Email", user.getEmail())
//					.append("Password", user.getPassword()).append("First Name", user.getFirstName())
//					.append("Address", asList(user.getAddressLine1(), user.getAddressLine2())));
//			userlist.insertMany(users);

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

	public void update(User user) {

		// Should be in Edit user field...
//                Document Address = new Document()
//                        .append("Address1", user.getAddressLine1())
//                        .append("City", user.getCity())
//                        .append("State", user.getState())
//                        .append("postcode", user.getZipcode());
		// mdb.getCollection("Users").updateOne(eq("firstName",
		// "Lucy"),Updates.addToSet("Address", Address));
	}
}
