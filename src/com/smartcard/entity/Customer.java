package com.smartcard.entity;

import java.util.Date;
import java.util.stream.Stream;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Customer {

	@BsonProperty("_id")
	@BsonId
	private ObjectId customerId;
	private String email;
	private String password;
	private String fullName;
	private String firstName;
	private String lastName;
	private String address;
	// private String addressLine2;
	private String city;
	private String state;
	private String postCode;
	private String phone;
	private Date registerDate;

	public Customer() {
		super();
	}

	public Customer(String email, String password, String fullName) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
	}

	public Customer(ObjectId customerId, String email, String password, String firstName, String lastName,
			String address, String city, String state, String postCode, String phone, Date registerDate,
			String fullName) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		// this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
		this.phone = phone;
		this.registerDate = registerDate;
		this.fullName = fullName;
	}

	public ObjectId getCustomerId() {
		return customerId;
	}

	public void setCustomerId(ObjectId customerId) {
		this.customerId = customerId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", email=" + email + ", password=" + password + ", fullName="
				+ fullName + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", postCode=" + postCode + ", phone=" + phone + ", registerDate="
				+ registerDate + "]";
	}

}