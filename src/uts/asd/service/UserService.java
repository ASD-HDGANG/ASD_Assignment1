/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import uts.asd.model.User;
import uts.asd.model.dao.UserDAO;
import uts.asd.model.dao.dBUtils;

/**
 *
 * @author Patty
 */
public class UserService {

    private UserDAO userDAO;
    private List<Document> users = new ArrayList();

    public void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Need to put a controller servlet later to list all user if required
        List<User> listUser = userDAO.listAll();

    }

    public void create(User user) {

// this what I want to see. user is saved to db here
        try {
            MongoDatabase mdb = dBUtils.getMongoDB();
            assert mdb != null;

            if (user == null) {
                System.out.println("not working!!!!!!!");
            } else {
                // create or get collection
                MongoCollection<Document> userlist = mdb.getCollection("Users");

                users.add(new Document("Email", user.getEmail()).
                        append("Password", user.getPassword())
                        .append("First Name", user.getFirstName())
                        .append("Address", asList(user.getAddressLine1(),
                                user.getAddressLine2())));

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
        //mdb.getCollection("Users").updateOne(eq("firstName", "Lucy"),Updates.addToSet("Address", Address));
    }
}

