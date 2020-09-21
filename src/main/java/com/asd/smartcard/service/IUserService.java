/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.smartcard.service;

import com.asd.smartcard.dto.UserDto;
import com.asd.smartcard.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    User save(UserDto userDto);
    
    //User sendEmail(UserDto userDto);

}


