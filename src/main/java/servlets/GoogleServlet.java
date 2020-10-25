package servlets;
import Utils.Util;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoogleServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 接受参数
        String departure = req.getParameter("departure");
        String destination = req.getParameter("destination");
        req.getServletContext().setAttribute("departure", departure);
        req.getServletContext().setAttribute("destination", destination);



        //3 判断逻辑
        if (departure == null || departure.isEmpty()||destination == null || destination.isEmpty()) {
            req.setAttribute("message", "Your input content is wrong or empty<br>");
            req.getRequestDispatcher("/tripPlanner.jsp").forward(req, resp);

        }



        if ((departure.equals("epping")||departure.equals("mq")||departure.equals("carlinford")||departure.equals("eastwood"))&&(destination.equals("epping")||destination.equals("mq")||destination.equals("carlinford")||destination.equals("eastwood"))){
            req.getRequestDispatcher("/google.jsp").forward(req, resp);
        }
        else{
            req.setAttribute("message", "Your input station is wrong, plz check again<br>");
            req.getRequestDispatcher("/tripPlanner.jsp").forward(req, resp);
        }

    }


}
