package br.com.extra.api.pojo.v1.orders.sandbox;

import java.io.Serializable;
import java.util.Date;

import org.joda.time.DateTime;

public class CustomerSandbox implements Serializable {
	
	private static final long serialVersionUID = -7535270782752652286L;

	private String name;
	private String lastName;
	private String gender;
	private String documentNumber;
	private String email;
	private String phoneMobile;
	private String phoneHome;
	private String phoneOffice;
	private Date birthDt;
	private String address;
	private String addressNr;
	private String additionalInfo;
	private String quarter;
	private String city;
	private String state;
	private String postalCd;	
	
	public CustomerSandbox() { }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneMobile() {
		return phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}

	public String getPhoneHome() {
		return phoneHome;
	}

	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}

	public String getPhoneOffice() {
		return phoneOffice;
	}

	public void setPhoneOffice(String phoneOffice) {
		this.phoneOffice = phoneOffice;
	}

	public String getBirthDt() {
		return new DateTime(this.birthDt).toString();
	}

	public void setBirthDt(Date birthDt) {
		this.birthDt = birthDt;
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

	public String getPostalCd() {
		return postalCd;
	}

	public void setPostalCd(String postalCd) {
		this.postalCd = postalCd;
	}
	
	/*public TOCustomerSandbox(Customer back) {
		super();
		
		this.setCustomerId(back.getCustomerId());
		this.setDocumentNumber(back.getDocumentNumber());
		this.setCustomerClassification(back.getCustomerClassification());
		this.setCustomerType(back.getCustomerType());
		this.setName(back.getName());
		this.setLastName(back.getLastName());
		this.setEmail(back.getEmail());
		this.setPhoneMobile(back.getPhoneMobile());
		this.setPhoneHome(back.getPhoneHome());
		this.setPhoneOffice(back.getPhoneOffice());
		this.setGender(back.getGender());
		this.setBirthDt(back.getBirthDt().toString());
		this.setCreateDt(back.getCreateDt().toString());
		this.setUpdateDt(back.getUpdateDt().toString());
		
	}*/	
}
