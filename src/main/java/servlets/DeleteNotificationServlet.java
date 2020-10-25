/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mongodb.MongoClient;
import dao.MongoDBConnector;
import dao.NotificationDao;
import entity.Notification;
import java.io.IOException;
import java.io.PrintWriter;
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
public class DeleteNotificationServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //connect to server 
        MongoDBConnector connector = new MongoDBConnector();
        MongoClient client = connector.openConnection();
        
        //Retrieve Dao and session
        NotificationDao nd = new NotificationDao(client);
        int notificationID = Integer.parseInt(request.getParameter("notificationID"));
        
        //Find the document
        Notification notification = nd.get(notificationID);
        Document document = new Document();
	document.put("notificationID",notification.getNotificationID());
        document.put("customerID",notification.getCustomerID());
        document.put("createdDate",notification.getCreatedDate());
        document.put("notificationDate",notification.getNotificationDate());
        document.put("priority",notification.getPriority());
        document.put("message",notification.getMessage());
        
        //Delete the document
        nd.delete(notificationID);
        
        request.getRequestDispatcher("notifications.jsp").include(request, response);
    }
    
}
