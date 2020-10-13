//package com.smartcard.controller.paypal;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.transaction.Transaction;
//
//import com.paypal.api.payments.PayerInfo;
//import com.paypal.api.payments.Payment;
//import com.paypal.api.payments.ShippingAddress;
//import com.smartcard.service.PaypalService;
//
///**
// * Servlet implementation class ReviewPaypalServlet
// */
//@WebServlet("/ReviewPayment")
//public class ReviewPaypalServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String paymentId = request.getParameter("paymentId");
//		String payerId = request.getParameter("PayerID");
//		try {
//
//			PaypalService paypalService = new PaypalService();
//			Payment payment = paypalService.getPaymentDetails(paymentId);
//
//			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
//			Transaction transaction = payment.getTransactions().get(0);
//			ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
//
//			request.setAttribute("payer", payerInfo);
//			request.setAttribute("transaction", transaction);
//			request.setAttribute("shippingAddress", shippingAddress);
//
//			String url = "reviewPaypal.jsp?paymentId=" + paymentId + "&PayerID=" + payerId;
//			request.getRequestDispatcher(url).forward(request, response);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("errorMessage", e.getMessage());
//			request.getRequestDispatcher("/errorPaypal.jsp").forward(request, response);
//		}
//
//	}
//
//}
