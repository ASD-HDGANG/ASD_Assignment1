/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import uts.asd.model.User;
import uts.asd.model.dao.UserDao;
import uts.asd.model.dao.UserDaoImpl;
import uts.asd.model.dao.dBUtils;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        UserDaoImpl userDao = new UserDaoImpl();

        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));

        userDao.save(user);

        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }
}

//1 ????
//        String description = req.getParameter("description");
//        req.getServletContext().setAttribute("description", description);
//
//         2 ?????  
//        MongoDatabase database = Util.getConnect();
//
//        MongoCollection<Document> collection = database.getCollection("Reporting");
//
//        3 ????
//        if (description == null || description.isEmpty()) {
//            req.setAttribute("message", "EMPTY BUG REPORT DESCRIPTION<br>");
//            req.getRequestDispatcher("/reporting.jsp").forward(req, resp);
//
//        } else {
//        IdGenerator idGenerator = new IdGenerator();
//         long id = idGenerator.nextId();
//        String i= String.valueOf(id);
//
//            Document document = new Document();
//
//             document.put("id",i);
//            document.put("description", description);
//             BasicDBObject o= new BasicDBObject();
//              o.append("description", description);
//
//            collection.insertOne(document);
//
//            collection.deleteOne(document);
//            req.getRequestDispatcher("/reportManage.jsp").forward(req, resp);
//        }




