/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASD.SmartCard.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ASD.SmartCard.Model.Order;

/**
 *
 * @author yike8
 */
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ValidatorOrder v = new ValidatorOrder();
        String orderTime = request.getParameter("orderTime");
        String orderDate= request.getParameter("orderDate");
        String totalAmount= request.getParameter("totalAmount");
        String patmentId = request.getParameter("paymentId");
        String rererenceNumber = request.getParameter("refNo");
        String status = "saved";
        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String userId = request.getParameter("userId");
       
        request.getRequestDispatcher("add_order.jsp").include(request, response);     
       
}
}
