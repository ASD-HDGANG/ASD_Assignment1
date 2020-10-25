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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Martin
 */
public class AllNotificationServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //connection
        MongoDBConnector connector = new MongoDBConnector();
        MongoClient client = connector.openConnection();
         
        //using dao
        NotificationDao nd = new NotificationDao(client);
        HttpSession session = request.getSession(); 
        
        //return arraylist
        ArrayList<Notification> notifications = nd.readAll();
        session.setAttribute("notifications", notifications);
        request.getRequestDispatcher("readNotifications.jsp").include(request, response);
         
        }
    }

