/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.smartcard.model;

import java.util.Collection;
import java.util.Collections;
import javax.management.relation.Role;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document(collection = "User")
public class User {

    @Id
    private String id; // consider use Long to take less bit
    private String name;

    //@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String email;
    private String password;


//    @DBRef
//    private Set<Role> roles;
//    @Builder.Default
//    private UserRole userRole = UserRole.USER;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRole.name());
//        return Collections.singletonList(simpleGrantedAuthority);
//    }

    private Collection<Role> roles;

    public User() {
    }

    public User(String name, String email, String password, Collection<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

}

// Other possible method
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRole.name());
//        return Collections.singletonList(simpleGrantedAuthority);
//    }




