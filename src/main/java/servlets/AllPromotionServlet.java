
package servlets;

import Utils.IdGenerator;
import Utils.Util;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.MongoDBConnector;
import dao.PromotionDAO;
import entity.Promotion;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bson.Document;


public class AllPromotionServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //connection
         MongoDBConnector connector = new MongoDBConnector();
         MongoClient client = connector.openConnection();
         
    //using dao
         PromotionDAO promo = new PromotionDAO(client);
         HttpSession session = req.getSession();
         
    //return arraylist
        ArrayList<Promotion> promotions = promo.allPromotion();
         session.setAttribute("promotions", promotions);
         req.getRequestDispatcher("promotion.jsp").include(req, resp);
         

       
    }
      
     
             
    }