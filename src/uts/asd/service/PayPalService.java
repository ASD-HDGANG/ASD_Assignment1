/*
 * Paypal api test for payment feature
 * https://developer.paypal.com/docs/api/quickstart/payments/ 
 * 
 * 
 */
package uts.asd.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.*;
import java.util.ArrayList;
import java.util.List;
import uts.asd.model.dao.OrderDAO;

/**
 *
 * @author Patty
 */
public class PayPalService {

    private static final String CLIENT_ID = "AWkzGOMI3ak_AR5gBb-2Wip8dQ_snOIVUiPyZLUpwwPX-JYtM4hqXpVOVMtNQtalojsH1-vo8zpUuF7Y";
    private static final String CLIENT_SECRET = "EIZxmbhY6oxmUJy0FcuVsodaAr5QM4bOI8PdOUtuLY03sAFSKipuc9euzkKZrOJ7e2xSHZlg54K2PRcH";
    private static final String MODE = "sandbox";

    public String authorizePaypal(OrderDAO orderDetail) throws PayPalRESTException {

        Payer payer = getPayerInfo();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInfo(orderDetail);

        // Add payment detail
        Payment payment = new Payment();

        // Set Payment intent to authorize        
        payment.setIntent("authorize");
        payment.setPayer(payer);
        payment.setRedirectUrls(redirectUrls);
        payment.setTransactions(listTransaction);

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        Payment approvedPayment = payment.create(apiContext);

        System.out.println("Testing Result is :" + approvedPayment);

        return getApprovalURL(approvedPayment);
    }

    private String getApprovalURL(Payment approvedPayment) {

        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;

        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }
        return approvalLink;
    }

    private List<Transaction> getTransactionInfo(OrderDAO orderDetail) {
        // Set payment details
        Details details = new Details();
        details.setShipping(orderDetail.getShipping());
        details.setSubtotal(orderDetail.getSubtotal());
        details.setTax(orderDetail.getTax());

        // Payment amount
        Amount amount = new Amount();
        amount.setCurrency("AUD");
        amount.setTotal(orderDetail.getTotal());
        amount.setDetails(details);

        // Transaction information
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(orderDetail.getProductName());

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();

        Item item = new Item();
        item.setCurrency("AUD");
        item.setName(orderDetail.getProductName());
        item.setPrice(orderDetail.getSubtotal());
        item.setTax(orderDetail.getTax());
        item.setQuantity("1");

        items.add(item);
        itemList.setItems(items);
        transaction.setItemList(itemList);

        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);

        return listTransaction;
    }

    private RedirectUrls getRedirectURLs() {
        // Set redirect URLs
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/smartcard/cancel");
        redirectUrls.setReturnUrl("http://localhost:8080/smartcard/return");

        return redirectUrls;
    }

    private Payer getPayerInfo() {

        // Set payer details
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("Lucy");
        payerInfo.setLastName("Liu");
        payerInfo.setEmail("lucy@uts.com");

        payer.setPayerInfo(payerInfo);

        return payer;
    }

}



