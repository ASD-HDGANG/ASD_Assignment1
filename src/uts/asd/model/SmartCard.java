/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model;

import java.io.Serializable;

/**
 *
 * @author Patty
 */
public class SmartCard implements Serializable {

    private Long sc_id;
    private double balance;
    private String description;
    private byte[] image;
    //private Set<OrderDetail> orderDetail = new HasSet<OrderDetail>(0);

    private User user;

    public SmartCard() {
    }

    public SmartCard(double balance) {
        this.balance = 10;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

}

