/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASD.SmartCard.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ASD.SmartCard.Model.admin;
//import ISD.Assignment.Model.Dao.ShipmentManager;

/**
 *
 * @author admin
 */
public class NewAdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        String userID = request.getParameter("userID");
        String email = request.getParameter("email");
     //   ShipmentManager manager = (ShipmentManager) session.getAttribute("manager");
        
        
        //add more
         request.getRequestDispatcher("main.jsp").include(request, response);
        
}
}

