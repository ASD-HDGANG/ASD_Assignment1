/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class Shipment {
   String name;
   String email;
   String phone_number;
   String address;
   String city;
   String territory;
   String post_code;
   String arriveDate;
   String shipmentMethod;
   String currentStatus;


    public Shipment( String name, String email, String phone_number, String address, String city, String territory, String post_code, String arriveDate, String shipmentMethod, String currentStatus) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.city = city;
        this.territory = territory;
        this.post_code = post_code;
        this.arriveDate = arriveDate;
        this.shipmentMethod = shipmentMethod;
        this.currentStatus = currentStatus;
    }

    public void setPreferName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public void setarriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public void setShipmentMethod(String shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }



    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getTerritory() {
        return territory;
    }

    public String getPost_code() {
        return post_code;
    }

    public String getarriveDate() {
        return arriveDate;
    }

    public String getShipmentMethod() {
        return shipmentMethod;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    
}
