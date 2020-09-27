/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model.dao;

import java.util.ArrayList;
import java.util.List;
import uts.asd.model.SmartCard;

/**
 *
 * @author Patty
 */
public class SmartCardDAO implements IGenericDAO<SmartCard> {

    private List<SmartCard> smartcards = new ArrayList();;

    public SmartCardDAO() {
        super();
    }

    @Override
    public SmartCard create(SmartCard smartcard) {
        return smartcard;
    }

    @Override
    public SmartCard update(SmartCard t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SmartCard get(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SmartCard> listAll() {
        
            //    public void showall(Users users) {
//        for (User u : users.getList()) {
//            System.out.println(u.getName());

        return null;
    }

    @Override
    public Long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}







