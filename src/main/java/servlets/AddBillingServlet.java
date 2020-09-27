/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Utils.Util;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
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
    }
}
