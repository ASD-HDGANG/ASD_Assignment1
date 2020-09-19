/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.smartcard.service;

import com.asd.smartcard.model.User;
import com.asd.smartcard.repository.UserRepository;
import com.asd.smartcard.dto.UserRegistrationDto;
import com.asd.smartcard.model.Role;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {

//        User user = new User(); // create new user for user signup      
//        user.setName(registrationDto.getName());
//        user.setEmail(registrationDto.getEmail());
//        user.setPassword(registrationDto.getPassword());
        User user = new User(
                registrationDto.getName(), registrationDto.getEmail(), passwordEncoder.encode((registrationDto.getPassword())), Arrays.asList(new Role("ROLE_USER")));

//        Role userRole = roleRepository.findByRole("USER");
//        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    // This is for login creditential to override default springboot login
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} not match.", email));
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    // Spring secuirty expect user login for security reason
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {

        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }
}

//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setEnabled(true);
//        Role userRole = roleRepository.findByRole("ADMIN");
//        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
//        userRepository.save(user);



