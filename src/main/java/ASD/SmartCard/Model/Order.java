/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASD.SmartCard.Model;

/**
 *
 * @author yike8
 */
public class Order {    
    int orderId;
    int userId;
    int cardNumber;
    String orderTime;
    boolean topUpOrConsume;
    double orderAmount;
    String orderLocation;

    public Order(int orderId, int userId, int cardNumber, String orderTime, boolean topUpOrConsume, double orderAmount, String orderLocation) {
        this.orderId = orderId;
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.orderTime = orderTime;
        this.topUpOrConsume = topUpOrConsume;
        this.orderAmount = orderAmount;
        this.orderLocation = orderLocation;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public boolean isTopUpOrConsume() {
        return topUpOrConsume;
    }

    public void setTopUpOrConsume(boolean topUpOrConsume) {
        this.topUpOrConsume = topUpOrConsume;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderLocation() {
        return orderLocation;
    }

    public void setOrderLocation(String orderLocation) {
        this.orderLocation = orderLocation;
    }  
}
