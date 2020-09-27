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
/**
 *
 * @author daohuxia
 */

public class AddReportServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1 接受参数
        String  description=req.getParameter("description");
        req.getServletContext().setAttribute("description",description);
     

            
          // 2 连接数据库  
           MongoDatabase database = Util.getConnect();

        MongoCollection<Document> collection = database.getCollection("Order");
       
 
	
        
     
      
      //3 判断逻辑
    if(description == null||description.isEmpty()){
       req.setAttribute("message", "EMPTY BUG REPORT DESCRIPTION<br>");
        req.getRequestDispatcher("/reporting.jsp").forward(req, resp);

    }else{
//        IdGenerator idGenerator = new IdGenerator();
//         long id = idGenerator.nextId();
//        String i= String.valueOf(id);
        
   Document document = new Document();
   
    // document.put("id",i);
                document.append("description",description);
                document.append("smartCardNumber","123123312");
        document.append("fromLocation","asd");
   // BasicDBObject o= new BasicDBObject();
          //  o.append("description", description);
           
            
        collection.insertOne(document);
        
		
        //collection.deleteOne(document);
     req.getRequestDispatcher("/reportManage.jsp").forward(req, resp);
    }
      
      
      
      
      
      
      
      
        
       
             
    }

  

    
}
