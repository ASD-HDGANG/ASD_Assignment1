package smartcardDemo.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import smartcardDemo.model.User;
import smartcardDemo.model.dao.UserDAO;
import smartcardDemo.model.dao.dBUtils;

import java.io.IOException;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;


public class UserService {

	private UserDAO userDAO;
	private List<Document> users = new ArrayList<Document>();

	public UserService() {
	}

	public UserService(UserDAO userDAO, HttpServletRequest request, HttpServletResponse response) {
		userDAO = new UserDAO();
	}

	public void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		userDAO.listAll();

	}

	public void create(User user) throws ServletException, IOException {

		// this what I want to see. user is saved to db here
		try {
			MongoDatabase mdb = dBUtils.getMongoDB();
			assert mdb != null;

			if (user == null) {
				System.out.println("not working!!!!!!!");
			} else {
				// create or get collection
				MongoCollection<Document> userlist = mdb.getCollection("Users");

				users.add(new Document("Email", user.getEmail()).append("Password", user.getPassword())
						.append("First Name", user.getFirstName())
						.append("Address", asList(user.getAddressLine1(), user.getAddressLine2())));

				userlist.insertMany(users);

			}
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
