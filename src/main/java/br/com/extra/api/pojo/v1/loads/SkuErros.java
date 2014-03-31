package br.com.extra.api.pojo.v1.loads;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SkuErros implements Serializable {

	private static final long serialVersionUID = 7253758011783057542L;
	private String skuOrigin;
	private String message;

	public String getSkuOrigin() {
		return skuOrigin;
	}

	public void setSkuOrigin(String skuOrigin) {
		this.skuOrigin = skuOrigin;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
