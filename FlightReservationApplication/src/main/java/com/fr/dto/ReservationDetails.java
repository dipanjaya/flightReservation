package com.fr.dto;

public class ReservationDetails {

	private long flightId;
	private String passengerFirstName;
	private String passengerLastName;
	private String passengerEmail;
	private String passengerPhone;

	private String cardName;
	private String cardNo;
	private String cardExpiryDate;
	private String securityCode;

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getPassengerFirstName() {
		return passengerFirstName;
	}

	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}

	public String getPassengerLastName() {
		return passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public String getPassengerPhone() {
		return passengerPhone;
	}

	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	@Override
	public String toString() {
		return "ReservationDetails [flightId=" + flightId + ", passengerFirstName=" + passengerFirstName
				+ ", passengerLastName=" + passengerLastName + ", passengerEmail=" + passengerEmail
				+ ", passengerPhone=" + passengerPhone + ", cardName=" + cardName + ", cardNo=" + cardNo
				+ ", cardExpiryDate=" + cardExpiryDate + ", securityCode=" + securityCode + "]";
	}

}
