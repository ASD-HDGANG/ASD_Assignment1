/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.smartcard.service;

import com.asd.smartcard.model.Role;
import com.asd.smartcard.model.User;
import com.asd.smartcard.repository.UserRepository;
import com.asd.smartcard.dto.UserRegistrationDto;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {

        User user = new User(); // create new user for user signup        
        user.setName(registrationDto.getName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        //user.setEnabled(true);

        //user.setRoles(Arrays.asList(new Role()));
//        user.setPassword(passwordEncoder.encode(registration.getPassword()));
//        (bCryptPasswordEncoder.encode(registration.getPassword()));
        return userRepository.save(user);

    }

}

//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setEnabled(true);
//        Role userRole = roleRepository.findByRole("ADMIN");
//        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
//        userRepository.save(user);


