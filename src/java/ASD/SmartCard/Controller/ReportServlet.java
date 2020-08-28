/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASD.SmartCard.Controller;

import ASD.SmartCard.Model.shipment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author daohuxia
 */
public class ReportServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
     throws ServletException,
            IOException {
		 HttpSession session = request.getSession();
       

      
        request.getRequestDispatcher("reportManage.jsp").include(request, response);
		}                 	
	
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException,
            IOException {
		doGet(request, response);               	
	}     

   
    

   

}
