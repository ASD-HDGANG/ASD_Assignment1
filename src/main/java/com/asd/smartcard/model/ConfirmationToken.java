package com.asd.smartcard.model;

import com.asd.smartcard.dto.UserDto;
import java.util.Date;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "confirmationToken")
public class ConfirmationToken {

    @Id
    private String tokenid;
    @Field("confirmation_token")
    private String confirmationToken;
    private Date createdDate;

    private UserDto userDto;

    public ConfirmationToken(UserDto userDto) {
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
        this.userDto = userDto;
    }

    public String getTokenid() {
        return tokenid;
    }

    public void setTokenid(String tokenid) {
        this.tokenid = tokenid;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
    
    

}




