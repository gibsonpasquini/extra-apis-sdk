package br.com.extra.api.resources;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.DateTime;

import br.com.extra.api.core.AppToken;
import br.com.extra.api.core.AuthToken;
import br.com.extra.api.core.CoreAPIImpl;
import br.com.extra.api.core.Hosts;
import br.com.extra.api.pojo.orders.Order;
import br.com.extra.api.pojo.orders.OrderItem;
import br.com.extra.api.pojo.orders.Tracking;
import br.com.extra.api.utils.Utils;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * 
 * ExtraAPI-SDK - Orders.java
 * 
 * Implementação do Serviço Restful /orders.
 * 
 * Serviço que possibilita ao lojista gerenciar os seus pedidos.
 * 
 * @author Gibson Pasquini Nascimento
 * @author Fillipe Massuda
 * 
 *         22/06/2013
 */
public class Orders extends CoreAPIImpl<Order> implements OrdersResource {

	/**
	 * Construtor que instancia um objeto do serviço que consome a API /orders.
	 * 
	 * @param host
	 *            Host do serviço.
	 * @param appToken
	 *            Token de Aplicação.
	 * @param authToken
	 *            Token de Autenticação.
	 */
	public Orders(Hosts host, AppToken appToken, AuthToken authToken) {
		super(host, appToken, authToken);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getOrders(String offset, String limit) {

		setResource("/orders");

		// Parâmetros da requisição
		MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add("_offset", offset);
		queryParameters.add("_limit", limit);

		ClientResponse response = super.setQueryParams(queryParameters).get();

		if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return getListFromResponse(response);
	}

	/**
	 * {@inheritDoc}
	 */
	public Order getOrder(String orderId) {

		if (!orderId.isEmpty()) {
			setResource("/orders/" + orderId);
		} else {
			throw new RuntimeException(
					"É obrigatório passar o número do pedido.");
		}

		ClientResponse response = get();

		if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return getObjectFromResponse(response);

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getNewOrders(String offset, String limit) {

		setResource("/orders/status/new");

		// Parâmetros da requisição
		MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add("_offset", offset);
		queryParameters.add("_limit", limit);

		ClientResponse response = super.setQueryParams(queryParameters).get();

		if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return getListFromResponse(response);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getApprovedOrders(String offset, String limit) {

		setResource("/orders/status/approved");

		// Parametros da requisição
		MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add("_offset", offset);
		queryParameters.add("_limit", limit);

		ClientResponse response = super.setQueryParams(queryParameters).get();

		if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return getListFromResponse(response);

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getSentOrders(String offset, String limit) {

		setResource("/orders/status/sent/");

		// Parâmetros da requisição
		MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add("_offset", offset);
		queryParameters.add("_limit", limit);

		ClientResponse response = super.setQueryParams(queryParameters).get();

		if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return getListFromResponse(response);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getDeliveredOrders(String offset, String limit) {

		setResource("/orders/status/delivered/");

		// Parâmetros da requisição
		MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add("_offset", offset);
		queryParameters.add("_limit", limit);

		ClientResponse response = super.setQueryParams(queryParameters).get();

		if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return getListFromResponse(response);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getCanceledOrders(String offset, String limit) {

		setResource("/orders/status/canceled/");

		// Parâmetros da requisição
		MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add("_offset", offset);
		queryParameters.add("_limit", limit);

		ClientResponse response = super.setQueryParams(queryParameters).get();

		if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return getListFromResponse(response);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getPartiallyDeliveredOrders(String offset, String limit) {

		setResource("/orders/status/partiallydelivered/");

		// Parâmetros da requisição
		MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add("_offset", offset);
		queryParameters.add("_limit", limit);

		ClientResponse response = super.setQueryParams(queryParameters).get();

		if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return getListFromResponse(response);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getSentPartiallyOrders(String offset, String limit) {

		setResource("/orders/status/sentpartially");

		// Parâmetros da requisição
		MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add("_offset", offset);
		queryParameters.add("_limit", limit);

		ClientResponse response = super.setQueryParams(queryParameters).get();

		if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return getListFromResponse(response);
	}

	/**
	 * {@inheritDoc}
	 */
	public String adjustItemsDeliveredDate(String orderId,
			Date orderDateAdjusted, String reason, String originDeliveryID) {

		if (!orderId.isEmpty()) {
			setResource("/orders/" + orderId + "/orderItems/dateDelivery");
		} else {
			throw new RuntimeException(
					"É obrigatório passar o número do pedido.");
		}

		DateTime dt = new DateTime(orderDateAdjusted);

		// Parâmetros da requisição
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("dateUpdate", dt.toString());
		data.put("reason", reason);
		data.put("originDeliveryId", originDeliveryID);

		ClientResponse response = null;
		try {
			response = post(data);
		} catch (IOException e) {
			throw new RuntimeException(
					"Error while trying to execute POST method on resource: "
							+ super.getURI());
		}

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return response.getEntity(String.class);

	}

	/**
	 * {@inheritDoc}
	 */
	public String requestOrderItemsCancellation(String orderId,
			String[] orderItemIdList, String reason) {

		setResource("/orders/" + orderId + "/ordersItems/status/canceled");

		// Parâmetros da requisição
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("orderItemIdList", orderItemIdList);
		data.put("reason", reason);

		ClientResponse response = null;
		try {
			response = post(data);
		} catch (IOException e) {
			throw new RuntimeException(
					"Error while trying to execute POST method on resource: "
							+ super.getURI());
		}

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return response.getEntity(String.class);
	}

	/**
	 * {@inheritDoc}
	 */
	public String requestOrderCancellation(String orderId, String reason) {

		setResource("/orders/" + orderId + "/status/canceled");

		// Parâmetros da requisição
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("reason", reason);

		ClientResponse response = null;
		try {
			response = post(data);
		} catch (IOException e) {
			throw new RuntimeException(
					"Error while trying to execute POST method on resource: "
							+ super.getURI());
		}

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return response.getEntity(String.class);
	}

	/**
	 * {@inheritDoc}
	 */
	public String registerDelivery(String orderId, Date occurenceDt,
			String originDeliveryID, String extraDescription) {

		setResource("/orders/" + orderId + "/status/delivered/");

		DateTime dt = new DateTime(occurenceDt);

		// Parâmetros da requisição
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("occurenceDt", dt.toString());
		data.put("originDeliveryId", originDeliveryID);
		data.put("extraDescription", extraDescription);

		ClientResponse response = null;
		try {
			response = put(data);
		} catch (IOException e) {
			throw new RuntimeException(
					"Error while trying to execute PUT method on resource: "
							+ super.getURI());
		}

		if (response.getStatus() != ClientResponse.Status.NO_CONTENT
				.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return response.getEntity(String.class);
	}

	/**
	 * {@inheritDoc}
	 */
	public String updateTracking(String orderId, String orderItemId,
			Tracking tracking) {

		setResource("/orders/" + orderId + "/ordersItems/" + orderItemId
				+ "/trackings");

		ClientResponse response = null;
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("accessKeyNfe", tracking.getAccessKeyNfe());
			params.put("carrierName", tracking.getCarrierName());
			params.put("controlPoint", tracking.getControlPoint());
			params.put("extraDescription", tracking.getExtraDescription());
			params.put("linkNfe", tracking.getLinkNfe());
			params.put("nfe", tracking.getNfe());
			params.put("objectId", tracking.getObjectId());
			params.put("occurenceDt", tracking.getOccurenceDt());
			params.put("originDeliveryId", tracking.getOriginDeliveryId());
			params.put("serieNfe", tracking.getSerieNfe());
			params.put("url", tracking.getUrl());
			response = post(params);
		} catch (IOException e) {
			throw new RuntimeException(
					"Error while trying to execute POST method on resource: "
							+ super.getURI());
		}

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return response.getEntity(String.class);

	}

	/**
	 * {@inheritDoc}
	 */
	public OrderItem getOrderItem(String orderId, String orderItemId) {
		if (!Utils.isEmpty(orderId)
				&& !Utils.isEmpty(orderItemId)) {
			setResource("/orders/" + orderId + "/orderItems/" + orderItemId);
		} else {
			throw new RuntimeException(
					"É obrigatório passar o número do pedido e o número do item.");
		}

		ClientResponse response = get();

		if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		OrderItem orderItem = new OrderItem();
		try {
			orderItem = new ObjectMapper().readValue(
					response.getEntityInputStream(), OrderItem.class);
		} catch (IOException e) {
			throw new RuntimeException(
					"Erro ao criar o retorno da requisição: " + e.toString());
		}

		return orderItem;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<Order> getPojoClass() {
		return Order.class;
	}
}
