/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.smartcard.service;

import com.asd.smartcard.dto.UserDto;
import com.asd.smartcard.model.Role;
import com.asd.smartcard.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import com.asd.smartcard.repository.IUserRepository;
import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserDto registrationDto) {

        User user = new User(); // create new user for user signup      
        user.setName(registrationDto.getName());
        user.setEmail(registrationDto.getEmail());
        user.setEmail((passwordEncoder.encode(registrationDto.getPassword())));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));

        String verifyCode = RandomString.make(64);

        user.setVerificationCode(verifyCode);

        //user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        return userRepository.save(user);

    }

    // This is for login creditential to override default springboot login
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} not match.", username));
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


