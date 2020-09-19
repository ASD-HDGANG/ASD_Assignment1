/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.smartcard.model;

import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document(collection = "User")
public class User {

    @Id
    private String id; // JPS use Long to take less bit
    //@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private String name;
    private String email;
    private String password;

    private Boolean locked = false;

    private Boolean enabled = false;

    //private UserRole userRole = UserRole.USER;
//    @DBRef
//    private Set<Role> roles;
    
    private Collection<Role> roles;

    public User() {
    }



    public User(String name, String email, String password, Collection<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRole.name());
//        return Collections.singletonList(simpleGrantedAuthority);
//    }
//    @Override
//    public String getUsername() {
//        return email;
//    }
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

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isEnabled() {
        return enabled;
    }

    // Below are Springboot UserDetails feature
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//    
//    @Override
//    public boolean isAccountNonLocked() {
//        return !locked;
//    }
//
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
}







