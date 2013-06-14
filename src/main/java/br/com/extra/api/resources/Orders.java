package br.com.extra.api.resources;

import br.com.extra.api.core.CoreAPIImpl;
import br.com.extra.api.core.Hosts;
import br.com.extra.api.pojo.Order;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.joda.time.DateTime;

import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orders extends CoreAPIImpl implements OrdersResource {

	public Orders(Hosts host, String appToken, String authToken) {
		super(host, appToken, authToken);
	}

	/**
	 * Método utilizado para recupera uma lista de pedidos.
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos realizados pelo lojista.
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

		return null;
	}

	/**
	 * Método que recupera detalhes do pedido informado
	 * 
	 * @param orderId
	 *            Número do pedido
	 * @return Detalhes do pedido informado.
	 */
	public List<Order> getOrder(String orderId) {

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

		return null;
	}

	/**
	 * Método responsável por listar os pedidos novos.
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos novos
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

		return null;
	}

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * recupera uma lista de pedidos com status aprovado.
	 * <p/>
	 * GET /orders/status/approved/
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos com status aprovados.
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

		return null;

	}

	/**
	 * Método responsável por listas os pedidos enviados.
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista com os pedidos com status sent.
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

		return null;
	}

	/**
	 * Método responsável por listar os pedidos entregues
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos com o status entregue.
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

		return null;
	}

	/**
	 * Método responsável por listar os pedidos cancelados.
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos com o status cancelado.
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

		return null;
	}

	/**
	 * Método responsável por listar os pedidos parcialmente entregues.
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos com o status parcialmente entregues.
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

		return null;
	}

	/**
	 * Método responsável por retornar uma lista com os pedidos parcialmente
	 * enviados.
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos com o status parcialmente enviados.
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

		return null;
	}

	/**
	 * Método responsável por atualizar a data de entrega dos itens do pedido.
	 * 
	 * @param orderId
	 *            Número do pedido
	 * @param orderDateAdjusted
	 *            Data de atualização
	 * @param reason
	 *            Motivo de alteração na entrega do item
	 * @param originDeliveryID
	 *            Id de entrega do pedido para o lojista
	 * @return
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
							+ super.getURL());
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
	 * Método responsável por cancelar um item em um pedido.
	 * 
	 * @param orderId
	 *            Número do pedido
	 * @param orderItemIdList
	 *            Número do item do pedido
	 * @param reason
	 *            Motivo de cancelamento do item
	 * @return
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
							+ super.getURL());
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
	 * Método responsável por cancelar um pedido
	 * 
	 * @param orderId
	 *            Número do pedido
	 * @param reason
	 *            Motivo do cancelamento do pedido
	 * @return
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
							+ super.getURL());
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
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * registra a entrega do pedido.
	 * <p/>
	 * PUT /orders/{orderId}/status/delivered/
	 * 
	 * @param orderId
	 *            ID do pedido.
	 * @param occurenceDt
	 *            Nova data de entrega d o item.
	 * @param extraDescription
	 *            Texto com o motivo da alteração.
	 * @param originDeliveryID
	 *            Id da entrega para o lojista no parceiro.
	 * @return
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
							+ super.getURL());
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
	 * Método responsável por registrar uma nova operação de tracking para o
	 * Item do Pedido informado.
	 * 
	 * @param orderId
	 *            número do pedido
	 * @param orderItemId
	 *            número do item do pedido
	 * @param tracking
	 *            tracking do item
	 * @return
	 */
	public String updateTracking(String orderId, String orderItemId,
			Map<String, Object> tracking) {

		setResource("/orders/" + orderId + "/ordersItems/" + orderItemId
				+ "/trackings");

		ClientResponse response = null;
		try {
			response = post(tracking);
		} catch (IOException e) {
			throw new RuntimeException(
					"Error while trying to execute POST method on resource: "
							+ super.getURL());
		}

		if (response.getStatus() != ClientResponse.Status.CREATED
				.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return response.getEntity(String.class);

	}
}
