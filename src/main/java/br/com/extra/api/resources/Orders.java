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
import br.com.extra.api.core.exception.ServiceDataManipulationException;
import br.com.extra.api.core.exception.ServiceException;
import br.com.extra.api.pojo.orders.Order;
import br.com.extra.api.pojo.orders.OrderItem;
import br.com.extra.api.pojo.orders.Tracking;
import br.com.extra.api.pojo.orders.sandbox.OrderConfirmationSandbox;
import br.com.extra.api.pojo.orders.sandbox.OrderSandbox;
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

		List<Order> orders = new ArrayList<Order>();
		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				orders = getListFromResponse(response);
			} catch (IOException e) {
				throw new ServiceDataManipulationException(
						"Error handling response. ", e);
			}
		} else {
			throw errorHandler(response);
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
	public Boolean adjustItemsDeliveredDate(String orderId,
			Date orderDateAdjusted, String reason, String originDeliveryID)
			throws ServiceException {

		// if (!Utils.isEmpty(orderId)) {
		// setResource("/orders/" + orderId + "/orderItems/dateDelivery");
		// } else {
		// throw new
		// ServiceDataManipulationException("Parameter skuId is mandatory.");
		// }
		//
		// DateTime dt = new DateTime(orderDateAdjusted);
		//
		// // Parâmetros da requisição
		// Map<String, Object> data = new HashMap<String, Object>();
		// data.put("dateUpdate", dt.toString());
		// data.put("reason", reason);
		// data.put("originDeliveryId", originDeliveryID);
		//
		// ClientResponse response = post(data);
		//
		// if (response.getStatus() != ClientResponse.Status.CREATED
		// .getStatusCode()) {
		// throw errorHandler(response, "Error on your request. "
		// + response.toString());
		// }
		//
		// return true;

		throw new ServiceException("Sorry, this method is not implemented yet!");

	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean approveOrder(String orderId) throws ServiceException {
		validateSandboxRequest();
		setResource("/orders/status/approved/" + orderId);
		ClientResponse response = post();

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			throw errorHandler(response);
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public OrderConfirmationSandbox createOrder(OrderSandbox order)
			throws ServiceException {
		validateSandboxRequest();
		setResource("/orders");
		ClientResponse response = post(order);

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			throw errorHandler(response);
		}

		// Esse código deverá mudar pois o header correto é o location, que será
		// recuperado através de response.getLocation()
		List<String> list = response.getHeaders().get("Content-Location");
		OrderConfirmationSandbox confirmation = new OrderConfirmationSandbox();
		confirmation.setLocation(list.get(0));
		return confirmation;
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
			throw new ServiceDataManipulationException(
					"Parameter orderId is mandatory.");
		}

		ClientResponse response = get();

		Order order = null;

		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				order = getObjectFromResponse(response);
			} catch (IOException e) {
				throw new ServiceDataManipulationException(
						"Error handling response. ", e);
			}
		} else if (response.getStatus() != ClientResponse.Status.NOT_FOUND
				.getStatusCode()) {
			throw errorHandler(response);
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
			throw new ServiceDataManipulationException(
					"Parameters orderId and orderItemId are mandatory.");
		}

		ClientResponse response = get();

		OrderItem orderItem = null;
		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				orderItem = new ObjectMapper().readValue(
						response.getEntityInputStream(), OrderItem.class);
			} catch (IOException e) {
				throw new ServiceDataManipulationException(
						"Error handling response. ", e);
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
	public Boolean registerDelivery(String orderId, Date occurenceDt,
			String originDeliveryID, String extraDescription)
			throws ServiceException {

		setResource("/orders/" + orderId + "/status/delivered/");

		DateTime dt = new DateTime(occurenceDt);

		// Parâmetros da requisição
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("occurenceDt", dt.toString());
		data.put("originDeliveryId", originDeliveryID);
		data.put("extraDescription", extraDescription);

		ClientResponse response = put(data);

		if (response.getStatus() != ClientResponse.Status.NO_CONTENT
				.getStatusCode()) {
			throw errorHandler(response);
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean requestOrderCancellation(String orderId, String reason)
			throws ServiceException {

		setResource("/orders/" + orderId + "/status/canceled");

		// Parâmetros da requisição
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("reason", reason);

		ClientResponse response = post(data);

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			throw errorHandler(response);
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean requestOrderItemsCancellation(String orderId,
			String[] orderItemIdList, String reason) throws ServiceException {

		setResource("/orders/" + orderId + "/ordersItems/status/canceled");

		// Parâmetros da requisição
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("orderItemIdList", orderItemIdList);
		data.put("reason", reason);

		ClientResponse response = post(data);

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			throw errorHandler(response);
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean updateTracking(String orderId, Tracking trackingUpdate)
			throws ServiceException {

		setResource("/orders/" + orderId + "/ordersItems/trackings");

		ClientResponse response = post(trackingUpdate);

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			throw errorHandler(response);
		}

		return true;

	}
}
