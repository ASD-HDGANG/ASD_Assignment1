package uts.asd.model.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import uts.asd.model.User;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;

// User service, a Helper Class to do the nasty jobs for data Model
public class UserDaoImpl implements UserDao {

//    private List<Document> users = new ArrayList();
//    private String owner = "heroku_lcjwqk0m";
//    private String password = "rl8a576pdf1dbb7e3armg0vfjt";
//    private String connectionStringPostfix = "@ds011288.mlab.com:11288/heroku_lcjwqk0m";
//
//
    private List<Document> users = new ArrayList();

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void save(User user) {

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

    @Override
    public void updateUser(User user) {

        // Should be in Edit user field...
//                Document Address = new Document()
//                        .append("Address1", user.getAddressLine1())
//                        .append("City", user.getCity())
//                        .append("State", user.getState())
//                        .append("postcode", user.getZipcode());
        //mdb.getCollection("Users").updateOne(eq("firstName", "Lucy"),Updates.addToSet("Address", Address));
    }

    @Override
    public void deleteUser(User user) {

    }
}

