package br.com.extra.api.pojo.v1.orders;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CancelRequest implements Serializable {
	
	private static final long serialVersionUID = -7535270782752652286L;

	private String reason;
	
	private List<String> orderItemIdList;
	
	public CancelRequest() { }

	public String getReason() {
		if ( reason == null ) {
			return "";
		}
		return reason.trim();
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public List<String> getOrderItemIdList() {
		return orderItemIdList;
	}

	public void setOrderItemIdList(List<String> orderItemIdList) {
		this.orderItemIdList = orderItemIdList;
	}
	
	@Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }

}
