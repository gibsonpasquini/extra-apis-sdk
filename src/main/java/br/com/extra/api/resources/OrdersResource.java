package br.com.extra.api.resources;

import java.util.Date;
import java.util.List;
import java.util.Map;

import br.com.extra.api.pojo.Order;

public interface OrdersResource {

	public List<Order> getOrders(String offset, String limit);

	public List<Order> getOrder(String orderId);

	public List<Order> getNewOrders(String offset, String limit);

	public List<Order> getApprovedOrders(String offset, String limit);

	public List<Order> getSentOrders(String offset, String limit);

	public List<Order> getDeliveredOrders(String offset, String limit);

	public List<Order> getCanceledOrders(String offset, String limit);

	public List<Order> getPartiallyDeliveredOrders(String offset, String limit);

	public List<Order> getSentPartiallyOrders(String offset, String limit);

	public String adjustItemsDeliveredDate(String orderId,
			Date orderDateAdjusted, String reason, String originDeliveryID);

	public String requestOrderItemsCancellation(String orderId,
			String[] orderItemIdList, String reason);

	public String requestOrderCancellation(String orderId, String reason);

	public String registerDelivery(String orderId, Date occurenceDt,
			String originDeliveryID, String extraDescription);

    public String updateTracking(String orderId, String orderItemId, Map<String, Object> tracking);
}
