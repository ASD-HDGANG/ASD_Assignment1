/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.smartcard.service;

import com.asd.smartcard.model.User;
import com.asd.smartcard.dto.UserRegistrationDto;

public interface UserService {

    //User findByEmail(String email);
    User save(UserRegistrationDto registrationDto);
}




