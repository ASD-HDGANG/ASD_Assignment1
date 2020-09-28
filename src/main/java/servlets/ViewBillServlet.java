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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Billing;
import org.bson.Document;

/**
 *
 * @author Martin
 */
public class ViewBillServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //get the orderID
        int orderID = Integer.parseInt(req.getParameter("orderID"));
        Billing billing = null;
        //connection
        MongoDBConnector connector = new MongoDBConnector();
        MongoClient client = connector.openConnection();

        //get dao and session
        BillingDao BDao = new BillingDao(client);
        HttpSession session = req.getSession();
        
        billing = BDao.get(orderID);
        session.setAttribute("billing", billing);
        
        req.getRequestDispatcher("viewBill.jsp").include(req, resp);
    }

}
