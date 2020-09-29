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
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AddBillingServlet extends HttpServlet {
    
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //connect to server 
        MongoDBConnector connector = new MongoDBConnector();
        MongoClient client = connector.openConnection();
        
        //Retrieve Dao and session
        BillingDao BDao = new BillingDao(client);
        HttpSession session = req.getSession();
        
        //Generate OrderID
        Random r = new Random();
        int orderID = r.nextInt(10000);

        //Retrieve Details from form
        String customerID = req.getParameter("customerID");
        String paymentDate = req.getParameter("paymentDate");
        String service = req.getParameter("service");
        String location = req.getParameter("location");
        String amount = req.getParameter("amount");

        //Get Collection
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("Billing");
        
        //Create Bill and store into session
        Document document = new Document();
        
        document.put("orderID",orderID);
        document.put("customerID",103);
        document.put("paymentMethod","Credit Card");
        document.put("paymentDate",paymentDate);
        document.put("billDateGenerated","2020-09-29");
        document.put("tax","%5.0");
        document.put("service","Top up");
        document.put("location",location);
        document.put("amount",amount);

        collection.insertOne(document);
        
        req.getRequestDispatcher("home.jsp").include(req, resp);

    }
}
