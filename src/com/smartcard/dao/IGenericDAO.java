package com.smartcard.dao;

import java.util.List;

import com.smartcard.entity.User;

public interface IGenericDAO<T> {
	public T create(T t);

	public T update(T t); // seem redundant for design pattern

	public T get(Object id);

	public void delete(Object id);

	public List<T> listAll();

	public Long count();

}
