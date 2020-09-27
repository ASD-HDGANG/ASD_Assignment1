/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin
 */
public class Billing {
    private int orderID;
    private int CustomerID;
    private String paymentMethod;
    private String paymentDate;
    private String BillDateGenerated;
    private String tax;
    private String service;
    private double amount;

    public Billing(int orderID, int CustomerID, String paymentMethod, String paymentDate, String BillDateGenerated, String tax, String service, double amount) {
        this.orderID = orderID;
        this.CustomerID = CustomerID;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.BillDateGenerated = BillDateGenerated;
        this.tax = tax;
        this.service = service;
        this.amount = amount;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getBillDateGenerated() {
        return BillDateGenerated;
    }

    public void setBillDateGenerated(String BillDateGenerated) {
        this.BillDateGenerated = BillDateGenerated;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
    
}
