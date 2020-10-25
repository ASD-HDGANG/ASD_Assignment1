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
import javax.servlet.http.HttpSession;
import org.bson.conversions.Bson;

/**
 *
 * @author yike8
 */
public class SmartCardBlockServlet extends HttpServlet {

     @Override
      public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       String smartCardNumber = req.getParameter("smartCardNumber");
           
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("SmartCard");       
        
             for (Document doc : collection.find()) {
	       if (((String) doc.get("smartCardNumber")).equals(smartCardNumber)) {
                                SmartCard sc = new SmartCard(smartCardNumber,null,null,null,null,null);
                                
				sc.setCardNumber((String)doc.get("smartCardNumber"));
				sc.setSecurityCode((String)doc.get("securityCode"));
                                sc.setUserId((String)doc.get("userId"));
                                sc.setCardType((String)doc.get("smartCardType"));
				sc.setCardBalance((String)doc.get("smartCardBalance"));
                                if (((String)doc.get("smartCardStatus")).equals("active")) 
                                {
                                   sc.setCardStatus("blocked");  
                                }
                                else if (((String)doc.get("smartCardStatus")).equals("blocked")) 
                                {
                                   sc.setCardStatus("active");  
                                }
              
                                Bson update =  new Document("$set", new Document()
                                .append("smartCardNumber",sc.getCardNumber())
                                .append("securityCode",sc.getSecurityCode())
                                .append("userId",sc.getUserId())
                                .append("smartCardType",sc.getCardType())
                                .append("smartCardBalance",sc.getCardBalance())
                                .append("smartCardStatus",sc.getCardStatus()));
              
                                Bson filter = Filters.eq("smartCardNumber", smartCardNumber);     
            
                                collection.updateOne(filter,update);
                  }
		}  
           MongoDBConnector connector = new MongoDBConnector();
           MongoClient client = connector.openConnection();
           SmartCardDao db = new SmartCardDao(client);
           HttpSession session = req.getSession();
           String userId = req.getParameter("userId");
           List<SmartCard> smartCardList = db.listLinkedSmartCard(userId);
           session.setAttribute("userId", userId);
           session.setAttribute("smartCardList", smartCardList);
           req.getRequestDispatcher("smartCardList.jsp").forward(req, resp);
    }  
}