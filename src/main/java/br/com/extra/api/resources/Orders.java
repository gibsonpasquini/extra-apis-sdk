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

    /**
     * Método utilizado para realizar a chamada ao WebService Restful que
     * recupera uma lista de pedidos com status aprovado.
     *
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

        ClientResponse response = null;

        response = get(queryParameters);

        if (response.getStatus() != ClientResponse.Status.OK.ordinal()) {
            // Fazer tratamento de erro adequado.
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.toString());
        }

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

		if (response.getStatus() != ClientResponse.Status.NO_CONTENT.ordinal()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return response.getEntity(String.class);
	}
}
