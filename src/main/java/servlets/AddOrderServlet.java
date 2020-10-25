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

public class AddOrderServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String  smartCardNumber=req.getParameter("smartCardNumber");
       String  fromLocation=req.getParameter("fromLocation");  
        String  orderType=req.getParameter("orderType");
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String orderDate = formatter.format(date);
        
        String  orderStatus="processing";
        Random r = new Random();
        int rr = r.nextInt(10000000);
        String orderId = "" + rr;       
              
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("Order");
        
        Document document = new Document();
   
            document.append("orderId",orderId);
            document.append("smartCardNumber",smartCardNumber);
            document.append("fromLocation",fromLocation);
            document.append("toLocation","-");
            document.append("orderType",orderType);
            document.append("orderDate",orderDate);
            document.append("orderStatus",orderStatus);
            document.append("orderAmount","-");
    
       collection.insertOne(document);	

       MongoDBConnector connector = new MongoDBConnector();
        MongoClient client = connector.openConnection();
        OrderDao db = new OrderDao(client);
        HttpSession session = req.getSession();
        List<Order> orderList = db.listOrder(smartCardNumber);
        session.setAttribute("smartCardNumber", smartCardNumber);
        session.setAttribute("orderList", orderList);
        req.getRequestDispatcher("orderList.jsp").forward(req, resp);
    }  
             
 }

