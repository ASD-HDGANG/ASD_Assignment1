package com.asd.smartcard.dto;

import com.asd.smartcard.model.User;

import java.time.LocalDate;
import java.util.UUID;

public class TokenDto {

    private String confirmationToken;

    private LocalDate createdDate;

    private User user;

    public TokenDto() {
    }

    public TokenDto(String confirmationToken, LocalDate createdDate, User user) {
        this.confirmationToken = UUID.randomUUID().toString();
        this.createdDate = LocalDate.now();
        this.user = user;
    }
}
