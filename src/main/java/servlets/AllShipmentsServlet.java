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
import entity.shipment;
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

public class AllShipmentsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //1 parameter
    /*     HttpSession session = req.getSession();
        
     

           
          // 2 Connect to database  
        MongoDatabase database = Util.getConnect();

        MongoCollection<Document> collection = database.getCollection("Shipment");
       
        
        //3.getting all shipments
        ArrayList<shipment> shipments = new ArrayList();
            for(Document doc:collection.find()){
                String preferName = doc.get("name").toString();
                String email=doc.get("email").toString();
                String phone_number=doc.get("phone_number").toString();
                String address=doc.get("address").toString();
                String city=doc.get("city").toString();
                String territory=doc.get("territory").toString();
                String post_code=doc.get("post_code").toString();
                String arriveDate=doc.get("arriveDate").toString();
                String shipmentMethod=doc.get("shipmentMethod").toString();
                String currentStatus=doc.get("currentStatus").toString();
                shipments.add(new shipment(preferName,email,phone_number,address,city,territory,post_code,arriveDate,shipmentMethod,currentStatus));
            }
            
        
         session.setAttribute("shipments", shipments);
         req.getRequestDispatcher("shipments.jsp").include(req, resp);*/
    
    
         MongoDBConnector connector = new MongoDBConnector();
         MongoClient client = connector.openConnection();
         
         ShipmentDao smd = new ShipmentDao(client);
         HttpSession session = req.getSession();
         
         
        ArrayList<shipment> shipments = smd.allShipment();
         session.setAttribute("shipments", shipments);
         req.getRequestDispatcher("shipments.jsp").include(req, resp);
         
        
     
            
            
          
        
     
  
       
    }
      
      
      
      
             
    }

  

    
