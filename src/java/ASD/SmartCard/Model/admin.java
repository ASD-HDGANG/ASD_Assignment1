/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASD.SmartCard.Model;

/**
 *
 * @author admin
 */
public class admin {
    Integer adminID;
    Integer userID;
    String email;
    
    public admin(Integer adminID, Integer userID, String email){
        this.adminID = adminID;
        this.userID = userID;
        this.email = email;
    }

    public Integer getAdminID() {
        return adminID;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
