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
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
         
        
        MongoDBConnector connector = new MongoDBConnector();
        MongoClient client = connector.openConnection();
        
        BillingDao BDao = new BillingDao(client);
        HttpSession session = req.getSession();
        
        //Random r = new Random();
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("Billing");
        
        Document document = new Document();
        
            document.put("orderID",103);
            document.put("customerID",103);
            document.put("paymentMethod","PayPal");
            document.put("paymentDate","2003");
            document.put("billDateGenerated","2003");
            document.put("tax","%5.0");
            document.put("service","Top up");
            document.put("location","Sydney");
            document.put("amount","500");
        
            collection.insertOne(document);
        //BDao.create(103, 103, "PayPal", "2003", "2003", "%5.0", "Top up", 0.0);
        BDao.get(101);
        req.getRequestDispatcher("billing.jsp").include(req, resp);
        
        /*
        //1 Get Parameter
        String orderID=req.getParameter("orderID");
        req.getServletContext().setAttribute("orderID",orderID);
        String customerID=req.getParameter("customerID");
        req.getServletContext().setAttribute("customerID",customerID);
        String paymentMethod=req.getParameter("paymentMethod");
        req.getServletContext().setAttribute("paymentMethod",paymentMethod);
        String paymentDate=req.getParameter("paymentDate");
        req.getServletContext().setAttribute("paymentDate",paymentDate);
        String billDateGenerated=req.getParameter("billDateGenerated");
        req.getServletContext().setAttribute("billDateGenerated",billDateGenerated);
        String tax=req.getParameter("tax");
        req.getServletContext().setAttribute("tax",tax);
        String service=req.getParameter("service");
        req.getServletContext().setAttribute("service",service);
        String amount=req.getParameter("amount");
        req.getServletContext().setAttribute("amount",amount);
        
         // 2 Connect to the database  
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("Billing");
        
        //3 Add new document

 

        Document document = new Document();
        
        document.put("orderID",orderID);
        document.put("customerID",customerID);
        document.put("paymentMethod",paymentMethod);
        document.put("paymentDate",paymentDate);
        document.put("billDateGenerated",billDateGenerated);
        document.put("tax",tax);
        document.put("service",service);
        document.put("amount",amount);
        
        collection.insertOne(document);
        
        
        req.getRequestDispatcher("/shipmentNew.jsp").forward(req, resp);
*/
    }
}
