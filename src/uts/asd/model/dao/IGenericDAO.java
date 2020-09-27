/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model.dao;

import java.util.List;

/**
 *
 * @author Patty
 * @param <T>
 */
public interface IGenericDAO<T> {

    public T create(T t);

    public T update(T t);

    public T get(Object id);

    public void delete(Object id);

    public List<T> listAll();

    public Long count();

}



