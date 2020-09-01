/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASD.Email.Contoller;

import ASD.Email.Model.UserEmail;
import ASD.SmartCard.Model.User;
import ASD.Email.Model.User1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserVerification extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //feth form value
            //int id = Integer.parseInt("id");
            String fName = request.getParameter("firstName");
            //String lName = request.getParameter("lastName");
            String email = request.getParameter("email");
            //String password = request.getParameter("password");
            //String address = request.getParameter("address");

            //create instance object of the SendEmail Class
            SendEmail sm = new SendEmail();
            //get the 6-digit code
            String code = sm.getRandom();

            //craete new user using all information
            //UserEmail user = new UserEmail (name, email, code); 
            //User user = new User(id, fName, lName, email, password, address, code);
            User1 user = new User1(fName, email, code);

            //call the send email method
            boolean test = sm.sendEmail(user);

            //check if the email send successfully
            if (test) {
                HttpSession session = request.getSession();
                session.setAttribute("authcode", user);
                response.sendRedirect("verifyCode.jsp");
            } else {
                out.println("Failed to send verification email");
            }

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
