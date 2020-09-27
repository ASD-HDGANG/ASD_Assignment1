/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
/**
 *
 * @author yike8
 */
public class Order implements Serializable{
    
        private String orderId;
	private String cardNumber;
	private String orderType; //Train, Bus, Ship
	private String orderDate;
	private String fromLocation;
        private String toLoaction;

    public Order(String orderId, String cardNumber, String orderType, String orderDate, String fromLocation, String toLoaction) {
        this.orderId = orderId;
        this.cardNumber = cardNumber;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.fromLocation = fromLocation;
        this.toLoaction = toLoaction;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLoaction() {
        return toLoaction;
    }

    public void setToLoaction(String toLoaction) {
        this.toLoaction = toLoaction;
    }

        
}
