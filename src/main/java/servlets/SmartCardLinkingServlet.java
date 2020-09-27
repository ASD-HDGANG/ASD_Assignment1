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
import com.mongodb.client.model.Filters;
import entity.SmartCard;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author yike8
 */

public class SmartCardLinkingServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String  smartCardNumber=req.getParameter("smartCardNumber");
        String  securityCode=req.getParameter("securityCode");
        String  userId=req.getParameter("userId");
         
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("SmartCard");       
        
           SmartCard sc = new SmartCard(smartCardNumber,securityCode,null,null,null,null);
             for (Document doc : collection.find()) {
	       if (((String) doc.get("smartCardNumber")).equals(smartCardNumber) && ((String) doc.get("securityCode")).equals(securityCode)) {
                          if(((String)doc.get("userId")).equals("empty"))
                         {
				sc.setCardNumber((String)doc.get("smartCardNumber"));
				sc.setSecurityCode((String)doc.get("securityCode"));
                                sc.setUserId(userId);
                                sc.setCardType((String)doc.get("smartCardType"));
				sc.setCardBalance((String)doc.get("smartCardBalance"));
                                sc.setCardStatus((String)doc.get("smartCardStatus"));     
			}
                         else
                          {
                              req.setAttribute("link", "linked");
                              req.getRequestDispatcher("smartCardLinking.jsp").forward(req, resp);
                          }
		}  
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
    
     req.setAttribute("link", "success");

     req.getRequestDispatcher("/smartCardManagement.jsp").forward(req, resp);
             
    }
}

