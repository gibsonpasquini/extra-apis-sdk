package br.com.extra.api.pojo.v1.orders.sandbox;

import java.io.Serializable;


public class DeliveryAddressSandbox implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private String addressId;
    private String addressType;
    private String recipientNm;
    private String address;
    private String addressNr;
    private String additionalInfo;
    private String quarter;
    private String city;
    private String state;
    private String countryId;
    private String postalCd;
    
    public DeliveryAddressSandbox() {
    }

    

    
	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getRecipientNm() {
		return recipientNm;
	}

	public void setRecipientNm(String recipientNm) {
		this.recipientNm = recipientNm;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressNr() {
		return addressNr;
	}

	public void setAddressNr(String addressNr) {
		this.addressNr = addressNr;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
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

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getPostalCd() {
		return postalCd;
	}

	public void setPostalCd(String postalCd) {
		this.postalCd = postalCd;
	}

}
