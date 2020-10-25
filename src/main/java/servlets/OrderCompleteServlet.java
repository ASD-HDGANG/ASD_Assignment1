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
import com.mongodb.client.model.Filters;
import dao.MongoDBConnector;
import dao.OrderDao;
import entity.Order;
import entity.SmartCard;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.bson.conversions.Bson;

/**
 *
 * @author yike8
 */

public class OrderCompleteServlet extends HttpServlet {

     @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String orderId = req.getParameter("orderId");
      String fromLocation=req.getParameter("fromLocation");
      String smartCardNumber=req.getParameter("smartCardNumber");
      HttpSession session = req.getSession();
      session.setAttribute("orderId", orderId);
      session.setAttribute("fromLocation", fromLocation);
      session.setAttribute("smartCardNumber", smartCardNumber);
      req.getRequestDispatcher("orderComplete.jsp").forward(req, resp);
    }
    
     @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId"); 
        String fromLocation=req.getParameter("fromLocation"); 
        String toLocation=req.getParameter("toLocation");
        String smartCardNumber=req.getParameter("smartCardNumber");
        String securityCode = req.getParameter("securityCode"); 
        
        double fromDistance = 0.0;
        double toDistance = 0.0;
        if (fromLocation.equals("Central")) {
          fromDistance = 1;
        }
        else if (fromLocation.equals("Broadway")) {
          fromDistance = 2.1;
        }
        else if (fromLocation.equals("Newtown")) {
          fromDistance = 3.2;
        }
        
        if (toLocation.equals("Central")) {
          toDistance = 1;
        }
        else if (toLocation.equals("Broadway")) {
          toDistance = 2.1;
        }
        else if (toLocation.equals("Newtown")) {
          toDistance = 3.2;
        }
        
         String orderAmount = String.valueOf(Math.abs(fromDistance-toDistance));
        
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("Order");
        MongoCollection<Document> collection2 = database.getCollection("SmartCard");
        
         for (Document doc : collection.find()) {
	       if (((String) doc.get("orderId")).equals(orderId)) {
                   for(Document doc2 : collection2.find()) {
                       if (((String) doc2.get("securityCode")).equals(securityCode) && ((String) doc2.get("smartCardNumber")).equals(smartCardNumber)) {
                           Order o = new Order(orderId,null,null,null,null,toLocation,"complete",orderAmount);
                           o.setCardNumber((String)doc.get("smartCardNumber"));
                           o.setOrderType((String)doc.get("orderType"));
                           o.setOrderDate((String)doc.get("orderDate"));
                           o.setFromLocation((String)doc.get("fromLocation"));
              
            Bson update =  new Document("$set", new Document()
                                 .append("orderId",o.getOrderId())
                                 .append("smartCardNumber",o.getCardNumber())
                                 .append("fromLocation",o.getFromLocation())
                                 .append("toLocation",o.getToLoaction())
                                 .append("orderType",o.getOrderType())
                                 .append("orderDate",o.getOrderDate())
                                 .append("orderStatus",o.getOrderStatus())
                                 .append("orderAmount",o.getOrderAmount()));
                         Bson filter = Filters.eq("orderId", orderId);     
                                 collection.updateOne(filter,update);

                                 SmartCard sc = new SmartCard(smartCardNumber,securityCode,null,null,null,null);
                                 sc.setUserId((String)doc2.get("userId"));
                                 sc.setCardType((String)doc2.get("smartCardType"));
                                 double balance = Double.valueOf((String)doc2.get("smartCardBalance"));
                                 balance -= Double.valueOf(orderAmount);
                                 sc.setCardBalance(String.valueOf(balance));
                                 sc.setCardStatus((String)doc2.get("smartCardStatus"));
                                 
                                 Bson update2 =  new Document("$set", new Document()
                                 .append("smartCardNumber",sc.getCardNumber())
                                 .append("securityCode",sc.getSecurityCode())
                                 .append("userId",sc.getUserId())
                                 .append("smartCardType",sc.getCardType())
                                 .append("smartCardBalance",sc.getCardBalance())
                                 .append("smartCardStatus",sc.getCardStatus()));
                               Bson filter2 = Filters.eq("smartCardNumber", smartCardNumber);     
                                 collection2.updateOne(filter2,update2);
                                 
                         MongoDBConnector connector = new MongoDBConnector();
                        MongoClient client = connector.openConnection();
                        OrderDao db = new OrderDao(client);
                        HttpSession session = req.getSession();
                         List<Order> orderList = db.listOrder(smartCardNumber);
                        session.setAttribute("smartCardNumber", smartCardNumber);
                        session.setAttribute("orderList", orderList);
                        req.getRequestDispatcher("orderList.jsp").forward(req, resp);
                        break;
                       }                    
                   }     
                }
             }
  }
    
}