package br.com.extra.api.pojo.orders;

import java.io.Serializable;
import java.util.Date;

public class Tracking implements Serializable {
	private static final long serialVersionUID = 1L;

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

	public Tracking() {
	}

	public void setControlPoint(String controlPoint) {
		this.controlPoint = controlPoint;
	}

	public String getControlPoint() {
		return controlPoint;
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

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setOriginDeliveryId(String originDeliveryId) {
		this.originDeliveryId = originDeliveryId;
	}

	public String getOriginDeliveryId() {
		return originDeliveryId;
	}

	public void setAccessKeyNfe(String accessKeyNfe) {
		this.accessKeyNfe = accessKeyNfe;
	}

	public String getAccessKeyNfe() {
		return accessKeyNfe;
	}

	public void setLinkNfe(String linkNfe) {
		this.linkNfe = linkNfe;
	}

	public String getLinkNfe() {
		return linkNfe;
	}

	public void setSerieNfe(String serieNfe) {
		this.serieNfe = serieNfe;
	}

	public String getSerieNfe() {
		return serieNfe;
	}

	public void setNfe(String nfe) {
		this.nfe = nfe;
	}

	public String getNfe() {
		return nfe;
	}

}
