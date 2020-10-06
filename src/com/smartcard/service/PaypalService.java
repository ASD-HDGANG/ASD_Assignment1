//package com.smartcard.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.transaction.Transaction;
//
//import com.paypal.api.payments.Amount;
//import com.paypal.api.payments.Details;
//import com.paypal.api.payments.ItemList;
//import com.paypal.api.payments.Links;
//import com.paypal.api.payments.PayerInfo;
//import com.paypal.api.payments.Payment;
//import com.paypal.api.payments.RedirectUrls;
//import com.paypal.core.rest.APIContext;
//import com.paypal.core.rest.PayPalRESTException;
//import com.paypal.orders.Item;
//import com.paypal.orders.Payer;
//import com.smartcard.entity.OrderDetail;
//
//public class PaypalService {
//
//	public PaypalService() {
//
//	}
//
//	private static final String CLIENT_ID = "TOKEN_ID"; // TODO need to change both to work, find way to hide sensitive
//														// data
//	private static final String CLIENT_SECRET = "TOKEN_SECRET";
//	private static final String MODE = "sandbox";
//
//	public String authorizePayment(OrderDetail orderDetail) throws PayPalRESTException {
//
//		Payer payer = getPayerInfo();
//		RedirectUrls redirectUrls = getRedirectURLs();
//		List<Transaction> listTransaction = getTransactionInfo(orderDetail);
//
//		// Add payment detail
//		Payment payment = new Payment();
//
//		// Set Payment intent to authorize
//		payment.setIntent("authorize");
//		payment.setPayer(payer);
//		payment.setRedirectUrls(redirectUrls);
//		payment.setTransactions(listTransaction);
//
//		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
//		Payment approvedPayment = payment.create(apiContext);
//
//		System.out.println("Testing Result is :" + approvedPayment);
//
//		return getApprovalURL(approvedPayment);
//	}
//
//	private String getApprovalURL(Payment approvedPayment) {
//
//		List<Links> links = approvedPayment.getLinks();
//		String approvalLink = null;
//
//		for (Links link : links) {
//			if (link.getRel().equalsIgnoreCase("approval_url")) {
//				approvalLink = link.getHref();
//				break;
//			}
//		}
//		return approvalLink;
//	}
//
//	private List<Transaction> getTransactionInfo(OrderDetail orderDetail) {
//		// Set payment details
//		Details details = new Details();
//		details.setShipping(orderDetail.getShipping());
//		details.setSubtotal(orderDetail.getSubtotal());
//		details.setTax(orderDetail.getTax());
//
//		// Payment amount
//		Amount amount = new Amount();
//		amount.setCurrency("AUD");
//		amount.setTotal(orderDetail.getTotal());
//		amount.setDetails(details);
//
//		// Transaction information
//		Transaction transaction = new Transaction();
//		transaction.setAmount(amount);
//		transaction.setDescription(orderDetail.getProductName());
//
//		ItemList itemList = new ItemList();
//		List<Item> items = new ArrayList<>();
//
//		Item item = new Item();
//		item.setCurrency("AUD");
//		item.setName(orderDetail.getProductName());
//		item.setPrice(orderDetail.getSubtotal());
//		item.setTax(orderDetail.getTax());
//		item.setQuantity("1");
//
//		items.add(item);
//		itemList.setItems(items);
//		transaction.setItemList(itemList);
//
//		List<Transaction> listTransaction = new ArrayList<>();
//		listTransaction.add(transaction);
//
//		return listTransaction;
//	}
//
//	private RedirectUrls getRedirectURLs() {
//		// Set redirect URLs
//		RedirectUrls redirectUrls = new RedirectUrls();
//		redirectUrls.setCancelUrl("http://localhost:9090/smartcard/cancel.html");
//		redirectUrls.setReturnUrl("http://localhost:9090/smartcard/review_paypal");
//
//		return redirectUrls;
//	}
//
//	// Payment Id on the url to identify/proceed specific payment process
//	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
//		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
//		return Payment.get(apiContext, paymentId);
//	}
//
//	private Payer getPayerInfo() {
//
//		// Set payer details
//		Payer payer = new Payer();
//		payer.setPaymentMethod("paypal");
//
//		PayerInfo payerInfo = new PayerInfo();
//		payerInfo.setFirstName("Lucy");
//		payerInfo.setLastName("Liu");
//		payerInfo.setEmail("lucy@uts.com");
//
//		payer.setPayerInfo(payerInfo);
//
//		return payer;
//	}
//
//}
