/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mongodb.MongoClient;
import dao.BillingDao;
import dao.MongoDBConnector;
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
public class AddNotificationServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //connect to server 
        MongoDBConnector connector = new MongoDBConnector();
        MongoClient client = connector.openConnection();
        
        //Retrieve Dao and session
        BillingDao BDao = new BillingDao(client);
        HttpSession session = request.getSession();
       
        }
    }


