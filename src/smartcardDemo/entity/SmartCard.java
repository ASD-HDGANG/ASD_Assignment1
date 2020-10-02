package smartcardDemo.entity;

import java.io.Serializable;
import java.util.Date;

public class SmartCard implements Serializable {

	private String cardNumber;
	private String securityCode;
	private String userId; // TODO customerid from db?
	private String cardType; // asList [youth] [adult] [senior] can also use enum class with image
	private float cardBalance;
	private String cardStatus;
	private boolean isActive;
	private Date timeCreated;
	// private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

	public SmartCard() {
	}

	public SmartCard(String cardNumber, String securityCode, String userId, String cardType, float cardBalance,
			String cardStatus, boolean isActive, Date timeCreated) {
		super();
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
		this.userId = userId;
		this.cardType = cardType;
		this.cardBalance = cardBalance;
		this.cardStatus = cardStatus;
		this.image = image;
		this.isActive = isActive;
		this.timeCreated = timeCreated;
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

}
