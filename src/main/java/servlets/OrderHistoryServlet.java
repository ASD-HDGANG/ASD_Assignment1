/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Utils.IdGenerator;
import dao.OrderDao;
import Utils.Util;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.MongoDBConnector;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.MongoClient;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import entity.Order;
import javax.servlet.http.HttpSession;
/**
 *
 * @author yike8
 */

public class OrderHistoryServlet extends HttpServlet {
  
     @Override
     public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        MongoDBConnector connector = new MongoDBConnector();
        MongoClient client = connector.openConnection();
        OrderDao db = new OrderDao(client);
        HttpSession session = req.getSession();
        String smartCardNumber = req.getParameter("smartCardNumber");
        List<Order> orderList = db.listOrder(smartCardNumber);
        session.setAttribute("smartCardNumber", smartCardNumber);
        session.setAttribute("orderList", orderList);
        req.getRequestDispatcher("orderList.jsp").forward(req, resp);
    }            
     
     @Override
      public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       String orderId=req.getParameter("orderId");
       String smartCardNumber = req.getParameter("smartCardNumber");
        
       MongoDatabase database = Util.getConnect();
       MongoCollection<Document> collection = database.getCollection("Order");  
       Document document = new Document();
       document.put("orderId",orderId);
       collection.deleteOne(document);

       doGet(req, resp);
    }  

}

  

    
