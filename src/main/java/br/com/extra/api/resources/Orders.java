package br.com.extra.api.resources;

import java.util.Date;
import java.util.List;

import br.com.extra.api.core.CoreAPIImpl;
import br.com.extra.api.core.Hosts;
import br.com.extra.api.pojo.Order;

public class Orders extends CoreAPIImpl implements OrdersResource {

	public Orders(Hosts host, String appToken, String authToken) {
		super(host, appToken, authToken);
	}

	public List<Order> getOrders(String offset, String limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> getOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> getNewOrders(String offset, String limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> getApprovedOrders(String offset, String limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> getSentOrders(String offset, String limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> getDeliveredOrders(String offset, String limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> getCanceledOrders(String offset, String limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> getPartiallyDeliveredOrders(String offset, String limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> getSentPartiallyOrders(String offset, String limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public String adjustItemsDeliveredDate(String orderId,
			Date orderDateAdjusted, String reason, String originDeliveryID) {
		// TODO Auto-generated method stub
		return null;
	}

	public String requestOrderItemsCancellation(String orderId,
			String[] orderItemIdList, String reason) {
		// TODO Auto-generated method stub
		return null;
	}

	public String requestOrderCancellation(String orderId, String reason) {
		// TODO Auto-generated method stub
		return null;
	}

	public String registerDelivery(String orderId, Date occurenceDt,
			String originDeliveryID, String extraDescription) {
		// TODO Auto-generated method stub
		return null;
	}

}
