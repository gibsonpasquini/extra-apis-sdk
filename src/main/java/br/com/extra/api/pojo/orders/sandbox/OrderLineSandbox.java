package br.com.extra.api.pojo.orders.sandbox;

import java.io.Serializable;

public class OrderLineSandbox implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String orderLineId;
    private String sku;
    private String skuType;
    private String quantity;
    private String measureUnit;
    private String listPrice;
    private String salePrice;
    private String unconditionalDiscountAmount;
    private String conditionalDiscountAmount;
    private String inventoryType;
    private String skuName;
    private String productBrandName;
    private FreightSandbox freight;
    
    public OrderLineSandbox() { 
    }


	public String getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(String orderLineId) {
		this.orderLineId = orderLineId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getSkuType() {
		return skuType;
	}

	public void setSkuType(String skuType) {
		this.skuType = skuType;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public String getListPrice() {
		return listPrice;
	}

	public void setListPrice(String listPrice) {
		this.listPrice = listPrice;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getUnconditionalDiscountAmount() {
		return unconditionalDiscountAmount;
	}

	public void setUnconditionalDiscountAmount(String unconditionalDiscountAmount) {
		this.unconditionalDiscountAmount = unconditionalDiscountAmount;
	}

	public String getConditionalDiscountAmount() {
		return conditionalDiscountAmount;
	}

	public void setConditionalDiscountAmount(String conditionalDiscountAmount) {
		this.conditionalDiscountAmount = conditionalDiscountAmount;
	}

	public String getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getProductBrandName() {
		return productBrandName;
	}

	public void setProductBrandName(String productBrandName) {
		this.productBrandName = productBrandName;
	}

	public FreightSandbox getFreight() {
		return freight;
	}

	public void setFreight(FreightSandbox freight) {
		this.freight = freight;
	}

}
