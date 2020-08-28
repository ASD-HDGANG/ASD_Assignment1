/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASD.SmartCard.Controller;

/**
 *
 * @author yike8
 */

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class ValidatorOrder implements Serializable {
    private String orderIdPattern = "([0-9]*)";
    private String orderAmountPattern = "[0-9]+([,.][0-9]{1,2})?";
    private String orderLocationPattern = "^[A-Za-z]+$";
    
    public ValidatorOrder() {
    }
    
    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }
    
    public boolean validateOrderId(String orderId) {
        return validate(orderIdPattern, orderId);
    }
    
    public boolean validateTotalAmount(String orderAmount) {
        return validate(orderAmountPattern, orderAmount);
    }
    
    public boolean validateFName(String orderLocation) {
        return validate(orderLocationPattern, orderLocation);
    }
   
    public void clear(HttpSession session) {
        session.setAttribute("orderIdErr", "Enter Order ID");
        session.setAttribute("orderAmountErr", "Enter Order Amount");
        session.setAttribute("orderLocationErr", "Enter Order Location");
    }
}
    
    