package com.smartcard.entity;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class SmartCard {

	@BsonProperty("_id")
	@BsonId
	private ObjectId cardId;
	private String cardNumber;
	private String securityCode;
	private String cardType; // TODO asList to specific card type
	private float cardBalance;
	// private String cardStatus;
	private boolean isActive;
	private Date lastUpdateTime;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
	private byte[] image;

	private Integer qty;

	private Customer customer;

	public SmartCard() {
	}

	public SmartCard(Integer qty) {
		super();
		this.qty = qty;
	}

	public SmartCard(String cardNumber, String securityCode, String cardType, boolean isActive, Date lastUpdateTime,
			Set<OrderDetail> orderDetails, byte[] image) {
		super();
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
		this.cardType = cardType;
		this.cardBalance = getCardBalance();
		this.isActive = isActive;
		this.lastUpdateTime = lastUpdateTime;
		this.orderDetails = orderDetails;
		this.image = image;
	}

	public ObjectId getCardId() {
		return cardId;
	}

	public void setCardId(ObjectId cardId) {
		this.cardId = cardId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public float getCardBalance() {
		System.out.println("Initial " + cardType + " balance: $");
		return cardBalance;
	}

	public void setCardBalance(float cardBalance) {
		this.cardBalance = cardBalance;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "SmartCard [cardId=" + cardId + ", cardNumber=" + cardNumber + ", securityCode=" + securityCode
				+ ", cardType=" + cardType + ", cardBalance=" + cardBalance + ", isActive=" + isActive
				+ ", lastUpdateTime=" + lastUpdateTime + ", orderDetails=" + orderDetails + ", image="
				+ Arrays.toString(image) + ", qty=" + qty + ", customer=" + customer + "]";
	}

}
