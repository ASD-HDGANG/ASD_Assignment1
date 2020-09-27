/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

public class SmartCard implements Serializable{
    
    private String cardNumber;
    private String securityCode;
    private String userId;
    private String cardType;
    private String cardBalance;
    private String cardStatus;

    public SmartCard(String cardNumber, String securityCode, String userId, String cardType, String cardBalance, String cardStatus) {
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.userId = userId;
        this.cardType = cardType;
        this.cardBalance = cardBalance;
        this.cardStatus = cardStatus;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(String cardBalance) {
        this.cardBalance = cardBalance;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }
}
