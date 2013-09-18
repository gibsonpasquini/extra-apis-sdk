package br.com.extra.api.pojo.orders.sandbox;

import java.io.Serializable;
import java.util.List;

public class DeliveriesSandbox implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	private String deliveryId;
    private String orderId;
    private String deliveryType;
    private String status;
    private String totalAmount;
    private String totalDiscountAmount;
    private String billingAddressId;
    private String deliveryAddressId;
    private String wareHouseCNPJ;
    private String wareHouseId;
    private String carrierCode;
    private String relatedDeliveryId;
    private List<OrderLineSandbox> orderLineList;
    private DeliveryAddressSandbox deliveryAddress;
    private List<TrackingSandbox> trackingList;
    private List<SkuTrackingSandbox> skuDeliveryTrackingList;
    private FreightSandbox freightAmount;
    
    public DeliveriesSandbox() {
    }

	public String getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTotalDiscountAmount() {
		return totalDiscountAmount;
	}

	public void setTotalDiscountAmount(String totalDiscountAmount) {
		this.totalDiscountAmount = totalDiscountAmount;
	}

	public String getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(String billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public String getDeliveryAddressId() {
		return deliveryAddressId;
	}

	public void setDeliveryAddressId(String deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	public String getWareHouseCNPJ() {
		return wareHouseCNPJ;
	}

	public void setWareHouseCNPJ(String wareHouseCNPJ) {
		this.wareHouseCNPJ = wareHouseCNPJ;
	}
	
	public String getWareHouseId() {
		return wareHouseId;
	}

	public void setWareHouseId(String wareHouseId) {
		this.wareHouseId = wareHouseId;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getRelatedDeliveryId() {
		return relatedDeliveryId;
	}

	public void setRelatedDeliveryId(String relatedDeliveryId) {
		this.relatedDeliveryId = relatedDeliveryId;
	}

	public List<OrderLineSandbox> getOrderLineList() {
		return orderLineList;
	}

	public void setOrderLineList(List<OrderLineSandbox> orderLineList) {
		this.orderLineList = orderLineList;
	}

	public DeliveryAddressSandbox getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(DeliveryAddressSandbox deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	public List<TrackingSandbox> getTrackingList() {
		return trackingList;
	}

	public void setTrackingList(List<TrackingSandbox> trackingList) {
		this.trackingList = trackingList;
	}

	public List<SkuTrackingSandbox> getSkuDeliveryTrackingList() {
		return skuDeliveryTrackingList;
	}

	public void setSkuDeliveryTrackingList(
			List<SkuTrackingSandbox> skuDeliveryTrackingList) {
		this.skuDeliveryTrackingList = skuDeliveryTrackingList;
	}

	public FreightSandbox getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(FreightSandbox freightAmount) {
		this.freightAmount = freightAmount;
	}

}
