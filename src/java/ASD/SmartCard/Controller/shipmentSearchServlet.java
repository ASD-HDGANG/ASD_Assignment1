/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASD.SmartCard.Controller;

import ASD.SmartCard.Model.shipment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import ISD.Assignment.Model.Dao.ShipmentManager;


public class shipmentSearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException{
        HttpSession session = request.getSession();
        String ID =  request.getParameter("shipmentID");
        String date = request.getParameter("shipmentDate");
       // ShipmentManager manager = (ShipmentManager) session.getAttribute("manager");
        shipment shipment = null;
        
        
        //add more
        request.getRequestDispatcher("shipmentSearchResult.jsp").include(request, response);
    }
}
