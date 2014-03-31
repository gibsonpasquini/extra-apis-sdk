package br.com.extra.api.pojo.v1.sellerItems;

import java.io.Serializable;

public class ProductSold implements Serializable {

	private static final long serialVersionUID = 1L;

	private String skuOrigin;

	private String skuId;

	private Double defaultPrice;

	private Double salePrice;

	private Integer availableQuantity;

	private String installmentId;

	private Integer totalQuantity;

	private String prodId;

	public ProductSold() {
	}

	public String getSkuOrigin() {
		return skuOrigin;
	}

	public void setSkuOrigin(String skuOrigin) {
		this.skuOrigin = skuOrigin;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public Double getDefaultPrice() {
		return defaultPrice;
	}

	public void setDefaultPrice(Double defaultPrice) {
		this.defaultPrice = defaultPrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public String getInstallmentId() {
		return installmentId;
	}

	public void setInstallmentId(String installmentId) {
		this.installmentId = installmentId;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

}
