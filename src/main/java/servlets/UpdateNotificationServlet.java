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

/**
 *
 * @author Martin
 */
public class UpdateNotificationServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get connection 
        MongoDBConnector connector = new MongoDBConnector();
        MongoClient client = connector.openConnection();
        
        int notificationID = Integer.parseInt(request.getParameter("notificationID"));
        HttpSession session = request.getSession();
        
        //get notification DAO
        NotificationDao nd = new NotificationDao(client);
        Notification notification = nd.get(notificationID);
        
        //set the notification into the session
        session.setAttribute("notification", notification);
        
        request.getRequestDispatcher("updateNotification.jsp").include(request, response);
        }
    }

