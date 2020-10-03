package smartcardDemo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class SmartCard implements Serializable {

	private String cardNumber;
	private String securityCode;
	private String userId; // TODO customerid from db?
	private String cardType; // TODO asList to specific card type
	private float cardBalance;
	private String cardStatus;
	private boolean isActive;
	private Date timeCreated;
	// private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
	private byte[] image;

	public SmartCard() {
	}

	public SmartCard(String cardNumber, String securityCode, String cardType, float cardBalance, String cardStatus,
			boolean isActive, Date timeCreated, byte[] image) {
		super();
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
		this.cardType = cardType;
		this.cardBalance = cardBalance;
		this.cardStatus = cardStatus;
		this.isActive = isActive;
		this.timeCreated = timeCreated;
		this.image = image;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public float getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(float cardBalance) {
		this.cardBalance = cardBalance;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
