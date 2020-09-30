package smartcardDemo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paypal.base.rest.PayPalRESTException;

import smartcardDemo.model.dao.OrderDAO;
import smartcardDemo.service.PaypalService;

/**
 * Servlet implementation class PaypalServlet
 */
@WebServlet("/Paypal")
public class PaypalServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String product = request.getParameter("product");
        String subtotal = request.getParameter("subtotal");
        String shipping = request.getParameter("shipping");
        String tax = request.getParameter("tax");
        String total = request.getParameter("total");

        OrderDAO orderDetail = new OrderDAO(product, subtotal, shipping, tax, total);

        try {
            PaypalService paymentServices = new PaypalService();
            String approvalLink = paymentServices.authorizePayment(orderDetail);

            response.sendRedirect(approvalLink);

        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("/errorPaypal.jsp").forward(request, response);
        }
    }
}

