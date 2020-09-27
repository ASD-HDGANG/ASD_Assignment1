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
import dao.ShipmentDao;
import java.io.IOException;
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

public class NewShipmentServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1 接受参数
        HttpSession session = req.getSession();
        String  name=req.getParameter("name");
        String  email=req.getParameter("email");
        String  phone=req.getParameter("phone");
        String  address=req.getParameter("address");
        String  city=req.getParameter("city");
        String  territory=req.getParameter("territory");
        String  post_code=req.getParameter("post_code");
        String  date=req.getParameter("date");
        String  shipmentMethod=req.getParameter("shipmentMethod");
        String currentStatus = "Processing";
        ShipmentDao smd = (ShipmentDao) session.getAttribute("smd");
     

           
          // 2 连接数据库  
           MongoDatabase database = Util.getConnect();

        MongoCollection<Document> collection = database.getCollection("Shipment");
       
        
        //3.insert into database
         Document document = new Document();
            
            document.put("name",name);
            document.put("email",email);
            document.put("phone_number",phone);
            document.put("address",address);
            document.put("city",city);
            document.put("territory",territory);
            document.put("post_code",post_code);
            document.put("arriveDate",date);
            document.put("shipmentMethod",shipmentMethod);
            document.put("currentStatus",currentStatus);
            
            collection.insertOne(document);
            
            
            req.getRequestDispatcher("shipmentNew.jsp").include(req, resp);
        
     
  
       
    }
      
      
      
      
             
    }

  

    
