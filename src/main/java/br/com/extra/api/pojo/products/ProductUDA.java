package br.com.extra.api.pojo.products;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ProductUDA implements Serializable {

	private static final long serialVersionUID = 6465243840704396326L;

	private int udaId;

	private String udaName;

	private String udaValue;

	public int getUdaId() {
		return udaId;
	}

	public void setUdaId(int udaId) {
		this.udaId = udaId;
	}

	public String getUdaName() {
		return udaName;
	}

	public void setUdaName(String udaName) {
		this.udaName = udaName;
	}

	public String getUdaValue() {
		return udaValue;
	}

	public void setUdaValue(String udaValue) {
		this.udaValue = udaValue;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
