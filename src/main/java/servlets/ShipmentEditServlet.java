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

public class ShipmentEditServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    //para
        String email = req.getParameter("email");
        shipment shipment = null;
        
    //connection
         MongoDBConnector connector = new MongoDBConnector();
         MongoClient client = connector.openConnection();
         
    //using dao
         ShipmentDao smd = new ShipmentDao(client);
         HttpSession session = req.getSession();
         
         //return arraylist
        shipment = smd.searchShipment(email);
         session.setAttribute("shipment", shipment);
         req.getRequestDispatcher("shipmentEdit.jsp").include(req, resp);
         
       
  
       
    }
      
      
      
      
             
    }

  

    
