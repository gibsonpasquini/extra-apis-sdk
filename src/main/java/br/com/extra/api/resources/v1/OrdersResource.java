package br.com.extra.api.resources.v1;

import java.util.Date;
import java.util.List;

import br.com.extra.api.core.exception.ServiceException;
import br.com.extra.api.pojo.v1.orders.Order;
import br.com.extra.api.pojo.v1.orders.OrderItem;
import br.com.extra.api.pojo.v1.orders.Tracking;
import br.com.extra.api.pojo.v1.orders.sandbox.OrderConfirmationSandbox;
import br.com.extra.api.pojo.v1.orders.sandbox.OrderSandbox;

/**
 * 
 * ExtraAPI-SDK - OrdersResource.java
 * 
 * Interface do Serviço Restful /orders.
 * 
 * Serviço que possibilita ao lojista gerenciar os seus pedidos.
 * 
 * @author Gibson Pasquini Nascimento
 * @author Fillipe Massuda
 * 
 *         21/06/2013
 */
public interface OrdersResource {

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que é
	 * responsável por atualizar a data de entrega dos itens de pedidos
	 * informado.
	 * <p/>
	 * POST /orders/{orderId}/orderItems/dateDelivery/
	 * 
	 * @param orderId
	 *            ID do pedido.
	 * @param orderDateAdjusted
	 *            Nova data de entrega do item.
	 * @param reason
	 *            Texto com o motivo da alteração Nova data de entrega do item.
	 * @param originDeliveryID
	 *            Id da entrega para o lojista no parceiro.
	 * @return Confirmação da execução da operação.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public Boolean adjustItemsDeliveredDate(String orderId,
			Date orderDateAdjusted, String reason, String originDeliveryID)
			throws ServiceException;

	/**
	 * 
	 * @param orderId
	 * @return
	 * @throws ServiceException
	 */
	public Boolean approveOrder(String orderId) throws ServiceException;

	/**
	 * 
	 * @param order
	 * @return
	 * @throws ServiceException
	 */
	public OrderConfirmationSandbox createOrder(OrderSandbox order)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que é
	 * responsável por recuperar lista de pedidos aprovados do Lojista.
	 * <p/>
	 * GET /orders/status/approved
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos aprovados do lojista.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<Order> getApprovedOrders(String offset, String limit)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que é
	 * responsável por recuperar lista de pedidos cancelados do Lojista.
	 * <p/>
	 * GET /orders/status/canceled
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos cancelados do lojista.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<Order> getCanceledOrders(String offset, String limit)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que é
	 * responsável por recuperar lista de pedidos entregues do Lojista.
	 * <p/>
	 * GET /orders/status/delivered
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos entregues do lojista.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<Order> getDeliveredOrders(String offset, String limit)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que é
	 * responsável por recuperar lista de novos pedidos do Lojista.
	 * <p/>
	 * GET /orders/status/new
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos novos do lojista.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<Order> getNewOrders(String offset, String limit)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que é
	 * responsável por recuperar um pedido.
	 * <p/>
	 * GET /orders/{orderId}
	 * 
	 * @param orderId
	 *            ID do pedido.
	 * @return Pedido solicitado.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public Order getOrder(String orderId) throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que é
	 * responsável por recuperar um item de um pedido.
	 * <p/>
	 * GET /orders/{orderId}/orderItems/{orderItemId}
	 * 
	 * @param orderId
	 *            ID do pedido.
	 * @param orderItemId
	 *            ID do item do pedido.
	 * @return Item solicitado.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public OrderItem getOrderItem(String orderId, String orderItemId)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que é
	 * responsável por recuperar lista de pedidos do Lojista.
	 * <p/>
	 * GET /orders
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
	public List<Order> getOrders(String offset, String limit)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que é
	 * responsável por recuperar lista de pedidos parcialmente entregues do
	 * Lojista.
	 * <p/>
	 * GET /orders/status/partiallyDelivered
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos parcialmente entregues do lojista.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<Order> getPartiallyDeliveredOrders(String offset, String limit)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que é
	 * responsável por recuperar lista de pedidos enviados do Lojista.
	 * <p/>
	 * GET /orders/status/sent
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos enviados do lojista.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<Order> getSentOrders(String offset, String limit)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que é
	 * responsável por recuperar lista de pedidos parcialmente enviados do
	 * Lojista.
	 * <p/>
	 * GET /orders/status/sentPartially
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos parcialmente enviados do lojista.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<Order> getSentPartiallyOrders(String offset, String limit)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * registra a entrega do pedido.
	 * 
	 * PUT /orders/{orderId}/status/delivered/
	 * 
	 * @param orderId
	 *            ID do pedido.
	 * @param occurenceDt
	 *            Nova data de entrega d o item.
	 * @param originDeliveryID
	 *            Id da entrega para o lojista no parceiro.
	 * @param extraDescription
	 *            Texto com o motivo da alteração.
	 * @return Confirmação da execução da operação.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public Boolean registerDelivery(String orderId, Date occurenceDt,
			String originDeliveryID, String extraDescription)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful
	 * responsável por solicitar o cancelamento do pedido.
	 * <p/>
	 * 
	 * POST /orders/{orderId}/status/canceled/
	 * 
	 * @param orderId
	 *            ID do pedido.
	 * @param reason
	 *            Texto com o motivo.
	 * @return Confirmação da execução da operação.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public Boolean requestOrderCancellation(String orderId, String reason)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful
	 * responsável por solicitar o cancelamento dos itens informados do pedido.
	 * <p/>
	 * 
	 * POST /orders/{orderId}/ordersItems/status/canceled/
	 * 
	 * @param orderId
	 *            ID do pedido.
	 * @param orderItemIdList
	 *            Lista de itens do pedido que serão cancelados.
	 * @param reason
	 *            Texto com o motivo.
	 * @return Confirmação da execução da operação.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public Boolean requestOrderItemsCancellation(String orderId,
			String[] orderItemIdList, String reason) throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * registra uma nova operação de tracking do pedido.
	 * 
	 * 
	 * POST /orders/{orderId}/ordersItems/{orderItemId}/trackings/
	 * 
	 * @param orderId
	 *            ID do pedido.
	 * @param trackingUpdate
	 *            Objeto contendo informações sobre o tracking.
	 * 
	 * @return Confirmação da execução da operação.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public Boolean updateTracking(String orderId, Tracking trackingUpdate)
			throws ServiceException;
}
