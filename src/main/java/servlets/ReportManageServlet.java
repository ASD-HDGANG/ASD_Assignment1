/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Utils.Util;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import static java.io.FileDescriptor.out;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.var;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author daohuxia
 */

public class ReportManageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      

        
		String todo = req.getParameter("todo");
if(todo.equals("deleteReport")){
			deleteReport(req, resp);
		}else if(todo.equals("updateReport")){
			updateReport(req, resp);
		}

       

   

        
          req.getRequestDispatcher("reportManage.jsp").forward(req,resp);

    }

    private void deleteReport(HttpServletRequest req, HttpServletResponse resp) {
       MongoDatabase database = Util.getConnect();

        MongoCollection<Document> collection = database.getCollection("Reporting");
        //String description = req.getParameter("description");  
Document document = new Document();
 req.getServletContext().getAttribute("description");
document.put("description",req.getServletContext().getAttribute("description"));

//collection.deleteMany(new Document());
        collection.deleteMany(document);
        
        //collection.deleteOne(document);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void updateReport(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
        
        
    }

 


