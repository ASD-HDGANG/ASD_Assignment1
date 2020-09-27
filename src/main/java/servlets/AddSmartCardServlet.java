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
import java.util.Scanner;
/**
 *
 * @author yike8
 */

public class AddSmartCardServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String  smartCardType=req.getParameter("smartCardType");
        
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < 16; i++) {
             rs.append(r.nextInt(9));
         }
         String smartCardNumber = rs.toString();
        
         Random rr = new Random();
        StringBuilder rrs = new StringBuilder();
        for (int i = 0; i < 4; i++) {
             rrs.append(rr.nextInt(9));
         }
         String securityCode = rrs.toString();
         
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("SmartCard");
        
        Document document = new Document();
   
            document.append("smartCardNumber",smartCardNumber);
            document.append("securityCode",securityCode);
            document.append("userId","empty");
            document.append("smartCardType",smartCardType);
            document.append("smartCardBalance","0.00");
            document.append("smartCardStatus","active");
    
         collection.insertOne(document);	
             
     req.setAttribute("smartCardNumber", smartCardNumber);
     req.setAttribute("securityCode", securityCode);
     req.setAttribute("smartCardType", smartCardType);

     req.getRequestDispatcher("/smartCardDetail.jsp").forward(req, resp);
     
    }  
             
 }

