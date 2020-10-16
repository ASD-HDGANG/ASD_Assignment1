package com.smartcard.entity;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class User {

	@BsonProperty("_id")
	// @JsonProperty("_id")
	@BsonId
	private ObjectId id;

	// @BsonProperty(value = "user_id")
	private String userId;
	private String email;
	private String fullName;
	// private String lastName;
	private String password;

	// private String role;
	// private boolean isEnable;

	public User() {
		super();
	}

	public User(ObjectId id, String email, String fullName, String password) {
		super();
		this.id = id;
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

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", fullName=" + fullName + ", password=" + password + "]";
	}

}