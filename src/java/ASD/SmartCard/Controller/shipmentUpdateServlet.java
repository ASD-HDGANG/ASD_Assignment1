
package ASD.SmartCard.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ASD.SmartCard.Model.shipment;
//import ISD.Assignment.Model.Dao.ShipmentManager;


public class shipmentUpdateServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException{
        HttpSession session = request.getSession();
        /* need to add validation
        Integer shipmentID = Integer.parseInt(request.getParameter("shipmentID"));
        Integer userID = Integer.parseInt(request.getParameter("userID"));
        String preferName = request.getParameter("name");
        String email = request.getParameter("email");
        Integer phone_number = Integer.parseInt(request.getParameter("phone"));
        String address = request.getParameter("address");
        String city= request.getParameter("city");
        String territory = request.getParameter("territory");
        Integer post_code = Integer.parseInt(request.getParameter("post_code"));
        String startDate = request.getParameter("startDate");
        String shipmentMethod = request.getParameter("shipmentMethod");
        String currentStatus = request.getParameter("currentStatus");
        shipment shipment = new shipment(shipmentID, userID, preferName, email, phone_number, address, city, territory, post_code, startDate, shipmentMethod, currentStatus);
        ShipmentManager manager = (ShipmentManager) session.getAttribute("manager");*/
        
        //add more
        response.sendRedirect("shipmentEdit.jsp");
    }

}
