/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Utils.IdGenerator;
import Utils.Util;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.BillingDao;
import dao.MongoDBConnector;
import entity.Billing;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bson.Document;
/**

/**
 *
 * @author Martin
 */
public class BillingServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Create the connection
        MongoDBConnector connector = new MongoDBConnector();
        MongoClient client = connector.openConnection();
        
        //Get the Dao and the session
        BillingDao BDao = new BillingDao(client);
        HttpSession session = req.getSession();
        

        //Retrieve all of the billing entries
        ArrayList<Billing> billings = BDao.readAll();
        
        //Set Billing entries into session
        session.setAttribute("billings", billings);
        req.getRequestDispatcher("billing.jsp").include(req, resp);
       
    
       
    }
}
