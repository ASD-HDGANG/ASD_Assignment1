/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Utils.IdGenerator;
import Utils.Util;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.MongoDBConnector;
import dao.ShipmentDao;
import entity.Shipment;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bson.Document;
/**
 *
 * @author daohuxia
 */

public class ShipmentDeleteServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    
         //getting para
         String  email=req.getParameter("email");
         String arriveDate= req.getParameter("arriveDate");
         HttpSession session = req.getSession();
         
         //connecting to database
        MongoDatabase database = Util.getConnect();

        MongoCollection<Document> collection = database.getCollection("Shipment");
       
        
        //3.insert into database
        
        Document document = new Document();
        document.put("email", email);
            
        collection.deleteOne(document);
        
         req.getRequestDispatcher("shipments.jsp").include(req, resp);
         
         
        
     
            
            
          
        
     
  
       
    }
      
      
      
      
             
    }

  

    
