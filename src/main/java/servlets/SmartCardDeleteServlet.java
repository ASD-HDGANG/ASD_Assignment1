/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Utils.IdGenerator;
import dao.SmartCardDao;
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
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import entity.SmartCard;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.HttpSession;
import org.bson.conversions.Bson;

/**
 *
 * @author yike8
 */
public class SmartCardDeleteServlet extends HttpServlet {
    
      @Override
     public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        MongoDBConnector connector = new MongoDBConnector();
        MongoClient client = connector.openConnection();
        SmartCardDao db = new SmartCardDao(client);
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        String smartCardNumber = req.getParameter("smartCardNumber");
        List<SmartCard> smartCardList = db.listLinkedSmartCard(userId);
        session.setAttribute("smartCardNumber", smartCardNumber);
        session.setAttribute("smartCardList", smartCardList);
        req.getRequestDispatcher("smartCardDelete.jsp").forward(req, resp);
    }     

    @Override
      public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       String smartCardNumber = req.getParameter("smartCardNumber");
       String deleteSmartCardNumber = req.getParameter("deleteSmartCardNumber");
       String sBalance = req.getParameter("balance");
       double balance = Double.valueOf(req.getParameter("balance"));
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String orderDate = formatter.format(date); 
        String  orderStatus="complete";
        Random r = new Random();
        int rr = r.nextInt(10000000);
        String orderId = "" + rr;   
       
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("SmartCard");       
        
             for (Document doc : collection.find()) {
	       if (((String) doc.get("smartCardNumber")).equals(smartCardNumber)) {
                                SmartCard sc = new SmartCard(smartCardNumber,null,null,null,null,null);
                                
                                double oldBalance = Double.valueOf((String)doc.get("smartCardBalance"));
                                balance += oldBalance;
                                
				sc.setCardNumber((String)doc.get("smartCardNumber"));
				sc.setSecurityCode((String)doc.get("securityCode"));
                                sc.setUserId((String)doc.get("userId"));
                                sc.setCardType((String)doc.get("smartCardType"));
				sc.setCardBalance(String.valueOf(balance));
                                sc.setCardStatus((String)doc.get("smartCardStatus"));
              
                                Bson update =  new Document("$set", new Document()
                                .append("smartCardNumber",sc.getCardNumber())
                                .append("securityCode",sc.getSecurityCode())
                                .append("userId",sc.getUserId())
                                .append("smartCardType",sc.getCardType())
                                .append("smartCardBalance",sc.getCardBalance())
                                .append("smartCardStatus",sc.getCardStatus()));
              
                                Bson filter = Filters.eq("smartCardNumber", smartCardNumber);     
                                collection.updateOne(filter,update);
                                
                                Document document = new Document();
                                document.put("smartCardNumber",deleteSmartCardNumber);
                                collection.deleteOne(document);
                                
                                MongoCollection<Document> collection2 = database.getCollection("Order");
        
                              Document document2 = new Document();
   
                              document2.append("orderId",orderId);
                              document2.append("smartCardNumber",smartCardNumber);
                              document2.append("fromLocation","-");
                              document2.append("toLocation","-");
                              document2.append("orderType","Transfer");
                              document2.append("orderDate",orderDate);
                              document2.append("orderStatus",orderStatus);
                              document2.append("orderAmount",sBalance);
    
                               collection2.insertOne(document2);
                                                               
                               req.setAttribute("delet", "success");
                              req.getRequestDispatcher("/smartCardManagement.jsp").forward(req, resp);
                  }               
	 }  
    }  
}