package br.com.extra.api.pojo.v1.orders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.extra.api.pojo.Pojos;

public class Order extends Pojos {
	private static final long serialVersionUID = 4533081453854098795L;

	private String orderId;

	private String orderMasterId;

	private BigDecimal totalAmount;

	private Date purchaseDate;

	private BigDecimal freightChargedAmount;

	private BigDecimal freightActualAmount;

	private List<OrderItem> orderItems;

	private List<BillingInformation> billingInformations;

	private List<ShippingInformation> shippingInformationsList;

	private String documentNr;

	private String inscricaoEstadual;

	private String customerEmail;

	private String customerName;

	private String customerGender;

	private Integer paymentTpId;

	private String freightAdditionalInfo;

	private Date approvedDate;

	private List<Tracking> trackingList;

	private String customerPhoneNumber;

	public Order() {
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderMasterId(String orderMasterId) {
		this.orderMasterId = orderMasterId;
	}

	public String getOrderMasterId() {
		return orderMasterId;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setFreightChargedAmount(BigDecimal freightChargedAmount) {
		this.freightChargedAmount = freightChargedAmount;
	}

	public BigDecimal getFreightChargedAmount() {
		return freightChargedAmount;
	}

	public void setFreightActualAmount(BigDecimal freightActualAmount) {
		this.freightActualAmount = freightActualAmount;
	}

	public BigDecimal getFreightActualAmount() {
		return freightActualAmount;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public void setBillingInformations(
			List<BillingInformation> billingInformations) {
		this.billingInformations = billingInformations;
	}

	public List<BillingInformation> getBillingInformations() {
		return billingInformations;
	}

	public void setShippingInformationsList(
			List<ShippingInformation> shippingInformationsList) {
		this.shippingInformationsList = shippingInformationsList;
	}

	public List<ShippingInformation> getShippingInformationsList() {
		return shippingInformationsList;
	}

	public void setDocumentNr(String documentNr) {
		this.documentNr = documentNr;
	}

	public String getDocumentNr() {
		return documentNr;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setPaymentTpId(Integer paymentTpId) {
		this.paymentTpId = paymentTpId;
	}

	public Integer getPaymentTpId() {
		return paymentTpId;
	}

	public void setFreightAdditionalInfo(String freightAdditionalInfo) {
		this.freightAdditionalInfo = freightAdditionalInfo;
	}

	public String getFreightAdditionalInfo() {
		return freightAdditionalInfo;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setTrackingList(List<Tracking> trackingList) {
		this.trackingList = trackingList;
	}

	public List<Tracking> getTrackingList() {
		return trackingList;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
