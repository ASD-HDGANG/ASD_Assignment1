/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class Admin {
   String userID;



    public Admin( String userID) {
        this.userID = userID;

    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

 

    public String getUserID() {
        return userID;
    }

    
}
