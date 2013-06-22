package br.com.extra.api.pojo.orders;

import java.io.Serializable;

public class BillingInformation implements Serializable {
        
	private static final long serialVersionUID = 6739078559422462199L;

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

    public BillingInformation() { }

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
