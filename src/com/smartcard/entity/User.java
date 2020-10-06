package com.smartcard.entity;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class User {

	private static final long serialVersionUID = 1L;

	private ObjectId id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;

	// private String role;
	// private boolean isEnable;

	public User() {

	}

	public User(String email, String fullName, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return firstName + lastName;
	}

	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean match(String email) {
		return this.email.equalsIgnoreCase(email.trim());
	}

}
