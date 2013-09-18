package br.com.extra.api.pojo.orders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrackingUpdate implements Serializable {

	private static final long serialVersionUID = 1867639233950999007L;

	private Tracking tracking;

	private List<String> orderItemIds;

	public TrackingUpdate() {
		this.orderItemIds = new ArrayList<String>();
	}

	public Tracking getTracking() {
		return tracking;
	}

	public void setTracking(Tracking tracking) {
		this.tracking = tracking;
	}

	public List<String> getOrderItemIds() {
		return orderItemIds;
	}

	public void setOrderItemIds(List<String> orderItemIds) {
		this.orderItemIds = orderItemIds;
	}

}
