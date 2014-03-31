package br.com.extra.api.pojo.v1.orders;

import java.util.Date;

public class Delivered {

	private String originDeliveryId;
	private String extraDescription;
	private Date occurenceDt;

	public Delivered() {
	}

	public void setOriginDeliveryId(String originDeliveryId) {
		this.originDeliveryId = originDeliveryId;
	}

	public String getOriginDeliveryId() {
		return originDeliveryId;
	}

	public void setExtraDescription(String extraDescription) {
		this.extraDescription = extraDescription;
	}

	public String getExtraDescription() {
		return extraDescription;
	}

	public void setOccurenceDt(Date occurenceDt) {
		this.occurenceDt = occurenceDt;
	}

	public Date getOccurenceDt() {
		return occurenceDt;
	}
}
