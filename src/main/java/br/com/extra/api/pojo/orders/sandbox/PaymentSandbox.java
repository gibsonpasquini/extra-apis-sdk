package br.com.extra.api.pojo.orders.sandbox;

import java.io.Serializable;

public class PaymentSandbox implements Serializable {
    private static final long serialVersionUID = 1L;
        
    private String paymentId;
    private String paymentType;
    private String paymentKey;
    private String value;
    private String interestRate;
    private String interestAmount;
    private String dueDate;
    private String status;
    private String cardHoldersName;
    private String brand;
    private String numberOfInstallments;
    private String cardVerificationCode;
    
    public PaymentSandbox() { }

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentKey() {
		return paymentKey;
	}

	public void setPaymentKey(String paymentKey) {
		this.paymentKey = paymentKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public String getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(String interestAmount) {
		this.interestAmount = interestAmount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCardHoldersName() {
		return cardHoldersName;
	}

	public void setCardHoldersName(String cardHoldersName) {
		this.cardHoldersName = cardHoldersName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(String numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}

	public String getCardVerificationCode() {
		return cardVerificationCode;
	}

	public void setCardVerificationCode(String cardVerificationCode) {
		this.cardVerificationCode = cardVerificationCode;
	}

}
