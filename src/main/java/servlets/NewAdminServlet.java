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

public class NewAdminServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1 接受参数
        
        String  userID=req.getParameter("userID");
  
        
      //using .dao but it fails 
      // HttpSession session = req.getSession();
      //  ShipmentDao smd = (ShipmentDao) session.getAttribute("smd");
     

           
          // 2 连接数据库  
           MongoDatabase database = Util.getConnect();

        MongoCollection<Document> collection = database.getCollection("Admin");
       
        
        //3.insert into database
         Document document = new Document();
            
            document.put("userID",userID);

            
            collection.insertOne(document);
            
            
            req.getRequestDispatcher("admins.jsp").include(req, resp);
        
     
  
       
    }
      
      
      
      
             
    }

  

    
