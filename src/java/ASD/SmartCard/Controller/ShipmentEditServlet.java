
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
import ASD.SmartCard.Model.shipment;
//import ISD.Assignment.Model.Dao.ShipmentManager;


public class ShipmentEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        String date = request.getParameter("date");
     //   ShipmentManager manager = (ShipmentManager) session.getAttribute("manager");

        shipment shipment = null;

        //add more
        request.getRequestDispatcher("shipmentEdit.jsp").include(request, response);

    }
    }



