/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import Utils.Util;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bson.Document;

/**
 *
 * @author yike8
 */
public class LoginServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
          
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String userId = "";
        int result = 0;
        
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("Account"); 
        
        for (Document doc : collection.find()) {
	       if (((String) doc.get("userName")).equals(userName) && ((String) doc.get("password")).equals(password)) {
                userId = (String)doc.get("userId");
                
               HttpSession session = req.getSession();
               session.setAttribute("userName", userName);
               session.setAttribute("userId", userId);
               resp.sendRedirect(req.getContextPath()+"/home.jsp");
            }
               else {
                 req.setAttribute("login", "fail");
                 req.getRequestDispatcher("/login.jsp").forward(req, resp);  
               }          
         } 
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        Random r = new Random();
        int rr = r.nextInt(10000000);
        String userId = "" + rr;  
        
        MongoDatabase database = Util.getConnect();
        MongoCollection<Document> collection = database.getCollection("Account"); 
        
        Document document = new Document();
   
           document.append("userName",userName);
           document.append("password",password);
           document.append("userId",userId);
            
        collection.insertOne(document);
    }
}
