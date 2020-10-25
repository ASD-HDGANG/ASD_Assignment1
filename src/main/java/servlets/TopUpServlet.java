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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
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

public class TopUpServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String  smartCardNumber=req.getParameter("smartCardNumber");
        String  securityCode=req.getParameter("securityCode");
        String  topUpAmount=req.getParameter("topUpAmount");
        int result = 0;
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
	       if (((String) doc.get("smartCardNumber")).equals(smartCardNumber) && ((String) doc.get("securityCode")).equals(securityCode)) {
                               SmartCard sc = new SmartCard(smartCardNumber,securityCode,null,null,null,null);
                               
                                Double doubleTopUpAmount = new Double(topUpAmount);
                                Double doubleSmartCardBalance = new Double((String)doc.get("smartCardBalance"));
                                Double sum = doubleTopUpAmount + doubleSmartCardBalance;
                                String updatedBalance = "" + sum;
                                
				sc.setCardNumber((String)doc.get("smartCardNumber"));
				sc.setSecurityCode((String)doc.get("securityCode"));
                                sc.setUserId((String)doc.get("userId"));
                                sc.setCardType((String)doc.get("smartCardType"));
				sc.setCardBalance(updatedBalance);
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
                                 
                                 MongoCollection<Document> collection2 = database.getCollection("Order");
        
                                 Document document = new Document();
   
                                  document.append("orderId",orderId);
                                  document.append("smartCardNumber",smartCardNumber);
                                  document.append("fromLocation","-");
                                  document.append("toLocation","-");
                                  document.append("orderType","Top Up");
                                  document.append("orderDate",orderDate);
                                  document.append("orderStatus",orderStatus);
                                 document.append("orderAmount",topUpAmount);
    
                                 collection2.insertOne(document);
                                 result = 0;
                                 break;
			}
                    else
                     {
                              result = 1;
                      }
		}  
             
             if (result == 0)
                     {        
                        req.setAttribute("topup", "success");
                        req.getRequestDispatcher("/smartCardManagement.jsp").forward(req, resp); 
                     }
             else if (result == 1)
             {
                 req.setAttribute("topup", "error");
                 req.getRequestDispatcher("topUp.jsp").forward(req, resp);
             }
             else
             {
                req.setAttribute("topup", "bug");
                req.getRequestDispatcher("topup.jsp").forward(req, resp); 
             }
             
    }  
             
 }

