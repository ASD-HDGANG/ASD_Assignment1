/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Kyle
 */
public class Promotion {
    

    String title;
    String startDate;
    String endDate;
    String author;
    String status;
    String description;
    
    public Promotion(String title, String startDate, String endDate, String author, String status, String description) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.author = author;
        this.status = status;
        this.description = description;
    }
    

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getStartDate() {
        return startDate;
    }
    
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }
    
    public String getEndDate() {
        return endDate;
    }
    
    public void setEndDate(String endDate){
        this.endDate = endDate;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
}