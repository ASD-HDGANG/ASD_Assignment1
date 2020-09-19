package com.asd.smartcard.dto;

import java.util.Set;
import javax.management.relation.Role;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class UserRegistrationDto {

    private String name;
    private String password;
    private String email;
  


    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getConfirmPassword() {
//        return confirmPassword;
//    }
//
//    public void setConfirmPassword(String confirmPassword) {
//        this.confirmPassword = confirmPassword;
//    }
//
//    public String getConfirmEmail() {
//        return confirmEmail;
//    }
//
//    public void setConfirmEmail(String confirmEmail) {
//        this.confirmEmail = confirmEmail;
//    }
//    public Boolean getTerms() {
//        return terms;
//    }
//
//    public void setTerms(Boolean terms) {
//        this.terms = terms;
//    }
}

//    private String confirmPassword;
//    private String confirmEmail;
//    private Boolean terms;



