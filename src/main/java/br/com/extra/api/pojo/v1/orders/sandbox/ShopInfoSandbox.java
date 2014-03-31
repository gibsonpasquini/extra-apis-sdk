package br.com.extra.api.pojo.v1.orders.sandbox;

import java.io.Serializable;

public class ShopInfoSandbox implements Serializable {

	private static final long serialVersionUID = 1L;

	private String shopId;
	private String shopCode;
	private String legacyShopId;
	private String shopName;
	private String classification;

	public ShopInfoSandbox() {
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getLegacyShopId() {
		return legacyShopId;
	}

	public void setLegacyShopId(String legacyShopId) {
		this.legacyShopId = legacyShopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

}
