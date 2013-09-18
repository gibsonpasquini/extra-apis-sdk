package br.com.extra.api.pojo.orders.sandbox;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class OrderConfirmationSandbox implements Serializable {

	private static final long serialVersionUID = 8907019738703581892L;

	private String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
