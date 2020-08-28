/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASD.SmartCard.Model;

/**
 *
 * @author daohuxia
 */
public class report {
    
     Integer reportID;
   String description;

    public report(Integer reportID, String description) {
        this.reportID = reportID;
        this.description = description;
    }

    public Integer getReportID() {
        return reportID;
    }

    public void setReportID(Integer reportID) {
        this.reportID = reportID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    
}
