/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Utils.Util;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.BillingDao;
import dao.MongoDBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bson.Document;

/**
 *
 * @author Martin
 */
public class AddNotificationServlet extends HttpServlet {

    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //connect to server 
//        MongoDBConnector connector = new MongoDBConnector();
//        MongoClient client = connector.openConnection();
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("Notification");
        
        //Retrieve Dao and session
//        BillingDao BDao = new BillingDao(client);
//        HttpSession session = request.getSession();
       
        //Retrieve details from the form
        String notificationDate = request.getParameter("notificationDate");
        String priority = request.getParameter("priority");
        String message = request.getParameter("message");
        
        //Generate notificationID
        Random r = new Random();
        int notificationID = r.nextInt(10000);
        
        //CustomerID from the session
        int customerID = 1;
        
        //Get current date
        SimpleDateFormat x = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
        Date date = new Date();
        
        
        //Insert into database
        Document document = new Document();
            document.put("notificationID",notificationID);
            document.put("customerID",customerID);
            document.put("createdDate",x.format(date));
            document.put("notificationDate",notificationDate);
            document.put("priority",priority);
            document.put("message",message);
            
            collection.insertOne(document);
            
        //Send back to notifications page
        request.getRequestDispatcher("notifications.jsp").include(request, response);
        }
    }


