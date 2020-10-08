package com.smartcard.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class User {

	private ObjectId id;

	@BsonProperty(value = "user_id")
	private Long userId;
	private String email;
	private String fullName;
	// private String lastName;
	private String password;

	// private String role;
	// private boolean isEnable;

	public User() {
		super();
	}

	public User(Long userId, String email, String fullName, String password) {
		this.userId = userId;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}

	public User(String email, String fullName, String password) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public boolean match(String email) {
		return this.email.equalsIgnoreCase(email.trim());
	}

}
