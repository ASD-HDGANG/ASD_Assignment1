package uts.asd.model.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import uts.asd.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    //    private List<Document> users = new ArrayList();
//    private String owner = "heroku_lcjwqk0m";
//    private String password = "rl8a576pdf1dbb7e3armg0vfjt";
//    private String connectionStringPostfix = "@ds011288.mlab.com:11288/heroku_lcjwqk0m";
//
//
    private UserDao userDao;
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

                users.add(new Document("Email", user.getEmail()).
                        append("Password", user.getPassword())
                        .append("Name", user.getName()));
                MongoCollection<Document> userlist = mdb.getCollection("Users"); //Create or get a collection "users" on mLab
                userlist.insertMany(users);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}

//
//    MongoClientURI uri = new MongoClientURI("mongodb://" + this.owner + ":" + this.password + connectionStringPostfix);
//        try (MongoClient client = new MongoClient(uri)) {
//                MongoDatabase db = client.getDatabase(uri.getDatabase());
//                users.add(new Document("Email", user.getEmail()).append("Password", user.getPassword()).append("Name", user.getName()));
//                MongoCollection<Document> userlist = db.getCollection("ASD-app-users"); //Create a collection ASD-Demo-app-users on mLab
//        userlist.insertMany(users);
//        }




