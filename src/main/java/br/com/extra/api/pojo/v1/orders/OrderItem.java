package br.com.extra.api.pojo.v1.orders;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	private String orderItemId;

	private String skuId;

	private BigDecimal salePrice;

	private Date deliveryDate;

	private Integer freightTime;

	private Integer leadTime;

	public OrderItem() {
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setFreightTime(Integer freightTime) {
		this.freightTime = freightTime;
	}

	public Integer getFreightTime() {
		return freightTime;
	}

	public void setLeadTime(Integer leadTime) {
		this.leadTime = leadTime;
	}

	public Integer getLeadTime() {
		return leadTime;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
