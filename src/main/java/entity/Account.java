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
public class Account implements Serializable{
    
     private String userName;
     private String passWord;
     private String userId;

    public Account(String userName, String passWord, String userId) {
        this.userName = userName;
        this.passWord = passWord;
        this.userId = userId;
    }

    public String getAccountNumber() {
        return userName;
    }

    public void setAccountNumber(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
     
     
}
