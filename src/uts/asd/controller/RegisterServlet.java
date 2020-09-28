/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;

import JavaMailUtil.EmailService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.asd.model.User;
import uts.asd.service.UserService;

@WebServlet("/register_success")
public class RegisterServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/registration.jsp").forward(request, response);

//        RequestDispatcher  dispatcher = request.getRequestDispatcher("/registration.jsp");
//        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        UserService userService = new UserService();

        user.setFirstName(request.getParameter("fname"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));

        try {
            userService.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        EmailService email = new EmailService();
        //call the send email method
        boolean test = email.sendMail(user);

        //response.sendRedirect("");
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


