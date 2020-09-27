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
public class Smartcard {
    int cardNumber;
    int securityCode;
    int userId;
    String cardType;
    double cardBalance;
    String cardStatus;
    boolean isLinked;

    public Smartcard(int cardNumber, int securityCode, int userId, String cardType, double cardBalance, String cardStatus, boolean isLinked) {
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.userId = userId;
        this.cardType = cardType;
        this.cardBalance = cardBalance;
        this.cardStatus = cardStatus;
        this.isLinked = isLinked;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public boolean isIsLinked() {
        return isLinked;
    }

    public void setIsLinked(boolean isLinked) {
        this.isLinked = isLinked;
    }    
}
