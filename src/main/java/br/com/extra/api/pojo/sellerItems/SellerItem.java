package br.com.extra.api.pojo.sellerItems;

import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.extra.api.pojo.Pojos;

public class SellerItem extends Pojos {

	private static final long serialVersionUID = -7802371601055210474L;

	private String skuOrigin;
	private String skuId;
	private Double defaultPrice;
	private Double salePrice;
	private Integer availableQuantity;
	private String installmentId;
	private Integer crossDockingTime;
	private Integer totalQuantity;

	public SellerItem() {
		super();
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

	public Integer getCrossDockingTime() {
		return crossDockingTime;
	}

	public void setCrossDockingTime(Integer crossDockingTime) {
		this.crossDockingTime = crossDockingTime;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
