package br.com.extra.api.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.joda.time.DateTime;

import br.com.extra.api.core.AppToken;
import br.com.extra.api.core.AuthToken;
import br.com.extra.api.core.CoreAPIImpl;
import br.com.extra.api.core.Hosts;
import br.com.extra.api.core.exception.ServiceException;
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
	 * Método utilizado para realizar as consultas de pedidos.
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos do lojista.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	private List<Order> getListOfOrders(String offset, String limit)
			throws ServiceException {
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

		List<Order> orders = new ArrayList<Order>();
		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				orders = getListFromResponse(response);
			} catch (IOException e) {
				throw new ServiceException("Error handling response. ", e);
			}
		} else {
			throw new ServiceException(response.toString());
		}

		return orders;
	}

	/**
	 * Método que recupera do response uma lista de objeto que deverá ser
	 * retornado.
	 * 
	 * @param response
	 *            Response da requisição realizada.
	 * @return Lista de objetos pedidos.
	 * @throws IOException
	 *             Exceção lançada no parse da lista de retorno.
	 */
	protected List<Order> getListFromResponse(ClientResponse response)
			throws IOException {
		List<Order> pojos = new ArrayList<Order>();
		try {
			pojos = new ObjectMapper().readValue(
					response.getEntityInputStream(),
					new TypeReference<List<Order>>() {
					});
		} catch (IOException e) {
			throw e;
		}
		return pojos;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<Order> getPojoClass() {
		return Order.class;
	}

	/**
	 * {@inheritDoc}
	 */
	public String adjustItemsDeliveredDate(String orderId,
			Date orderDateAdjusted, String reason, String originDeliveryID)
			throws ServiceException {

//		if (!Utils.isEmpty(orderId)) {
//			setResource("/orders/" + orderId + "/orderItems/dateDelivery");
//		} else {
//			throw new ServiceException("Parameter skuId is mandatory.");
//		}
//
//		DateTime dt = new DateTime(orderDateAdjusted);
//
//		// Parâmetros da requisição
//		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("dateUpdate", dt.toString());
//		data.put("reason", reason);
//		data.put("originDeliveryId", originDeliveryID);
//
//		ClientResponse response = null;
//		try {
//			response = post(data);
//		} catch (IOException e) {
//			throw new ServiceException(
//					"Error while trying to execute POST method on resource: "
//							+ super.getURI(), e);
//		}
//
//		if (response.getStatus() != ClientResponse.Status.CREATED
//				.getStatusCode()) {
//			throw new ServiceException("Error on your request. "
//					+ response.toString());
//		}
//
//		return response.getEntity(String.class);
		
		throw new ServiceException("Sorry, this method is not implemented yet!");

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getApprovedOrders(String offset, String limit)
			throws ServiceException {

		setResource("/orders/status/approved");

		return getListOfOrders(offset, limit);

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getCanceledOrders(String offset, String limit)
			throws ServiceException {

		setResource("/orders/status/canceled/");

		return getListOfOrders(offset, limit);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getDeliveredOrders(String offset, String limit)
			throws ServiceException {

		setResource("/orders/status/delivered/");

		return getListOfOrders(offset, limit);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getNewOrders(String offset, String limit)
			throws ServiceException {

		setResource("/orders/status/new");

		return getListOfOrders(offset, limit);
	}

	/**
	 * {@inheritDoc}
	 */
	public Order getOrder(String orderId) throws ServiceException {

		if (!Utils.isEmpty(orderId)) {
			setResource("/orders/" + orderId);
		} else {
			throw new ServiceException("Parameter orderId is mandatory.");
		}

		ClientResponse response = get();

		Order order = null;

		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				order = getObjectFromResponse(response);
			} catch (IOException e) {
				throw new ServiceException("Error handling response. ", e);
			}
		} else if (response.getStatus() != ClientResponse.Status.NOT_FOUND
				.getStatusCode()) {
			String message = response.getStatus() + " - "
					+ response.getClientResponseStatus().getReasonPhrase();
			throw new ServiceException(message);
		}

		return order;

	}

	/**
	 * {@inheritDoc}
	 */
	public OrderItem getOrderItem(String orderId, String orderItemId)
			throws ServiceException {
		if (!Utils.isEmpty(orderId) && !Utils.isEmpty(orderItemId)) {
			setResource("/orders/" + orderId + "/orderItems/" + orderItemId);
		} else {
			throw new ServiceException(
					"Parameters orderId and orderItemId are mandatory.");
		}

		ClientResponse response = get();

		OrderItem orderItem = null;
		if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
			try {
				orderItem = new ObjectMapper().readValue(
						response.getEntityInputStream(), OrderItem.class);
			} catch (IOException e) {
				throw new ServiceException("Error handling response. ", e);
			}
		}

		return orderItem;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getOrders(String offset, String limit)
			throws ServiceException {
		
		throw new ServiceException("Sorry, this method is not implemented yet!");

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getPartiallyDeliveredOrders(String offset, String limit)
			throws ServiceException {

		setResource("/orders/status/partiallyDelivered/");

		return getListOfOrders(offset, limit);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getSentOrders(String offset, String limit)
			throws ServiceException {

		setResource("/orders/status/sent/");

		return getListOfOrders(offset, limit);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> getSentPartiallyOrders(String offset, String limit)
			throws ServiceException {

		setResource("/orders/status/sentPartially");

		return getListOfOrders(offset, limit);
	}

	/**
	 * {@inheritDoc}
	 */
	public String registerDelivery(String orderId, Date occurenceDt,
			String originDeliveryID, String extraDescription)
			throws ServiceException {

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
			throw new ServiceException(
					"Error while trying to execute PUT method on resource: "
							+ super.getURI(), e);
		}

		if (response.getStatus() != ClientResponse.Status.NO_CONTENT
				.getStatusCode()) {
			throw new ServiceException("Error on your request. "
					+ response.toString());
		}

		return response.getClientResponseStatus().getStatusCode() + " - "
				+ response.getClientResponseStatus().name();
	}

	/**
	 * {@inheritDoc}
	 */
	public String requestOrderCancellation(String orderId, String reason)
			throws ServiceException {

		setResource("/orders/" + orderId + "/status/canceled");

		// Parâmetros da requisição
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("reason", reason);

		ClientResponse response = null;
		try {
			response = post(data);
		} catch (IOException e) {
			throw new ServiceException(
					"Error while trying to execute PUT method on resource: "
							+ super.getURI(), e);
		}

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			throw new ServiceException("Error on your request. "
					+ response.toString());
		}

		String resp = response.getStatus() + " - "
				+ response.getClientResponseStatus().getReasonPhrase();
		return resp;
	}

	/**
	 * {@inheritDoc}
	 */
	public String requestOrderItemsCancellation(String orderId,
			String[] orderItemIdList, String reason) throws ServiceException {

		setResource("/orders/" + orderId + "/ordersItems/status/canceled");

		// Parâmetros da requisição
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("orderItemIdList", orderItemIdList);
		data.put("reason", reason);

		ClientResponse response = null;
		try {
			response = post(data);
		} catch (IOException e) {
			throw new ServiceException(
					"Error while trying to execute POST method on resource: "
							+ super.getURI(), e);
		}

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			throw new ServiceException("Error on your request. "
					+ response.toString());
		}

		String resp = response.getStatus() + " - "
				+ response.getClientResponseStatus().getReasonPhrase();
		return resp;
	}

	/**
	 * {@inheritDoc}
	 */
	public String updateTracking(String orderId, String orderItemId,
			Tracking tracking) throws ServiceException {

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
			throw new ServiceException(
					"Error while trying to execute POST method on resource: "
							+ super.getURI(), e);
		}

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			throw new ServiceException("Error on your request. "
					+ response.toString());
		}

		String resp = response.getStatus() + " - "
				+ response.getClientResponseStatus().getReasonPhrase();
		return resp;

	}
}
