package br.com.extra.api.pojo.orders.sandbox;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.extra.api.pojo.Pojos;
import br.com.extra.api.pojo.orders.Sku;

public class OrderSandbox extends Pojos implements Serializable {

	private static final long serialVersionUID = 4533081453854098795L;

	private String orderId;
	private CustomerSandbox customer;
	private List<Sku> skuidList;

	public OrderSandbox() {
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<Sku> getSkuidList() {
		return skuidList;
	}

	public void setSkuidList(List<Sku> skuidList) {
		this.skuidList = skuidList;
	}

	public CustomerSandbox getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerSandbox customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
