package br.com.extra.api.pojo.v1.orders.sandbox;

import java.io.Serializable;

public class FreightSandbox implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String chargedAmount;
    private String actualAmount;
    private String expectedDeliveryDate;
    
    public FreightSandbox() { }

	public String getChargedAmount() {
		return chargedAmount;
	}

	public void setChargedAmount(String chargedAmount) {
		this.chargedAmount = chargedAmount;
	}

	public String getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(String actualAmount) {
		this.actualAmount = actualAmount;
	}

	public String getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(String expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

 }
