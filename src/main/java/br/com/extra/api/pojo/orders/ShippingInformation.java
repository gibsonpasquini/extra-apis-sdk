package br.com.extra.api.pojo.orders;

import java.io.Serializable;
import java.util.Date;

public class ShippingInformation implements Serializable {
	private static final long serialVersionUID = 1L;

	private String deliveryType;

	private Date scheduledDate;

	private String scheduledPeriod;

	private String recipientName;

	private String address;

	private String addressNr;

	private String additionalInfo;

	private String quarter;

	private String city;

	private String state;

	private String countryId;

	private String postalCd;

	private String reference;

	private String addressExtraField1;

	private String addressExtraField2;

	private String buildingNm;

	public ShippingInformation() {
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledPeriod(String scheduledPeriod) {
		this.scheduledPeriod = scheduledPeriod;
	}

	public String getScheduledPeriod() {
		return scheduledPeriod;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddressNr(String addressNr) {
		this.addressNr = addressNr;
	}

	public String getAddressNr() {
		return addressNr;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setPostalCd(String postalCd) {
		this.postalCd = postalCd;
	}

	public String getPostalCd() {
		return postalCd;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getReference() {
		return reference;
	}

	public void setAddressExtraField1(String addressExtraField1) {
		this.addressExtraField1 = addressExtraField1;
	}

	public String getAddressExtraField1() {
		return addressExtraField1;
	}

	public void setAddressExtraField2(String addressExtraField2) {
		this.addressExtraField2 = addressExtraField2;
	}

	public String getAddressExtraField2() {
		return addressExtraField2;
	}

	public void setBuildingNm(String buildingNm) {
		this.buildingNm = buildingNm;
	}

	public String getBuildingNm() {
		return buildingNm;
	}

}
