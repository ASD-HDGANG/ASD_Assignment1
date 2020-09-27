/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Utils.IdGenerator;
import Utils.Util;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import java.util.Random;
/**
 *
 * @author yike8
 */

public class AddOrderServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String  smartCardNumber=req.getParameter("smartCardNumber");
       String  fromLocation=req.getParameter("fromLocation");
        String  toLocation=req.getParameter("toLocation");
        String  orderType=req.getParameter("orderType");
        String  orderDate=req.getParameter("orderDate");
        Random r = new Random();
        int rr = r.nextInt(10000000);
        String orderId = "" + rr;
         
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("Order");
        
        Document document = new Document();
   
            document.append("orderId",orderId);
            document.append("smartCardNumber",smartCardNumber);
            document.append("fromLocation",fromLocation);
            document.append("toLocation",toLocation);
            document.append("orderType",orderType);
            document.append("orderDate",orderDate);
    
       collection.insertOne(document);	
        //collection.deleteOne(document);
        req.setAttribute("add", "success");
        
     req.getRequestDispatcher("/orderManagement.jsp").forward(req, resp);
    }  
             
 }

