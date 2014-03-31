package br.com.extra.api.pojo.v1.orders;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;

public class Tracking implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<String> orderItemId;
	private String controlPoint;
	private String extraDescription;
	private Date occurenceDt;
	private String carrierName;
	private String url;
	private String objectId;
	private String originDeliveryId;
	private String accessKeyNfe;
	private String linkNfe;
	private String serieNfe;
	private String nfe;
	private String orderId;
	private List<String> orderItems;
	
	

	public List<String> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<String> orderItems) {
		this.orderItems = orderItems;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Tracking() {
	}

	public String getAccessKeyNfe() {
		return accessKeyNfe;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public String getControlPoint() {
		return controlPoint;
	}

	public String getExtraDescription() {
		return extraDescription;
	}

	public String getLinkNfe() {
		return linkNfe;
	}

	public String getNfe() {
		return nfe;
	}

	public String getObjectId() {
		return objectId;
	}

	public String getOccurenceDt() {
		return new DateTime(occurenceDt).toString();
	}

	public String getOriginDeliveryId() {
		return originDeliveryId;
	}

	public String getSerieNfe() {
		return serieNfe;
	}

	public String getUrl() {
		return url;
	}

	public void setAccessKeyNfe(String accessKeyNfe) {
		this.accessKeyNfe = accessKeyNfe;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public void setControlPoint(String controlPoint) {
		this.controlPoint = controlPoint;
	}

	public void setExtraDescription(String extraDescription) {
		this.extraDescription = extraDescription;
	}

	public void setLinkNfe(String linkNfe) {
		this.linkNfe = linkNfe;
	}

	public void setNfe(String nfe) {
		this.nfe = nfe;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public void setOccurenceDt(Date occurenceDt) {
		this.occurenceDt = occurenceDt;
	}

	public List<String> getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(List<String> orderItemId) {
		this.orderItemId = orderItemId;
	}

	public void setOriginDeliveryId(String originDeliveryId) {
		this.originDeliveryId = originDeliveryId;
	}

	public void setSerieNfe(String serieNfe) {
		this.serieNfe = serieNfe;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
