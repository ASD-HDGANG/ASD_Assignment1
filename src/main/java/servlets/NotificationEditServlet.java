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
import dao.MongoDBConnector;
import dao.NotificationDao;
import entity.Notification;
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
public class NotificationEditServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //connect to server 
        MongoDBConnector connector = new MongoDBConnector();
        MongoClient client = connector.openConnection();
        
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("Notification");
        
        
        //Retrieve Dao and session
        NotificationDao nd = new NotificationDao(client);
        HttpSession session = request.getSession();
       
        //Retrieve details from the form
        Notification notification = (Notification)session.getAttribute("notification");
        String notificationDate = request.getParameter("notificationDate");
        String priority = request.getParameter("priority");
        String message = request.getParameter("message");
        
        
        //find document that you want to update from database
        Document document = new Document();
	document.put("notificationID",notification.getNotificationID());
        document.put("customerID",notification.getCustomerID());
        document.put("createdDate",notification.getCreatedDate());
        document.put("notificationDate",notification.getNotificationDate());
        document.put("priority",notification.getPriority());
        document.put("message",notification.getMessage());
        
        //updated document
	Document updateDocument = new Document();
	updateDocument.put("notificationID",notification.getNotificationID());
        updateDocument.put("customerID",notification.getCustomerID());
        updateDocument.put("createdDate",notification.getCreatedDate());
        updateDocument.put("notificationDate",notificationDate);
        updateDocument.put("priority",priority);
        updateDocument.put("message",message);
        
        //update 
	collection.findOneAndReplace(document, updateDocument);
        
        
        
        
        //Send back to notifications page
        request.getRequestDispatcher("notifications.jsp").include(request, response);
        }
    }

