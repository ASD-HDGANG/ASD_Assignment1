/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Utils.Util;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bson.Document;

/**
 *
 * @author Kyle Zeng
 */
public class NewPromotionServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String author = req.getParameter("author");
        String status = req.getParameter("status");
        String description = req.getParameter("description");
        

        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("Promotion");
       
        
        Document document = new Document();
            
            document.put("title",title);
            document.put("startDate",startDate);
            document.put("endDate",endDate);
            document.put("author",author);
            document.put("status",status);
            document.put("description",description);

            collection.insertOne(document);            
            req.getRequestDispatcher("promotions.jsp").include(req, resp);
        
    }
}

