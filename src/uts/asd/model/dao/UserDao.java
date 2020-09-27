/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model.dao;

import java.util.List;
import uts.asd.model.User;

/**
 *
 * @author Patty
 */
public class UserDAO implements IGenericDAO<User> {

    @Override
    public User create(User user) {
        return user;
    }

    @Override
    public User update(User user) {
        return user;

    }

    @Override
    public User get(Object userId) {
        return null;
    }
    
    public User findByEmail(String email){
        return null;
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}







