package br.com.extra.api.resources;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import br.com.extra.api.core.CoreAPIImpl;
import br.com.extra.api.core.Hosts;
import br.com.extra.api.pojo.SellerItem;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class SellerItems extends CoreAPIImpl implements SellerItemsResource {

	public SellerItems(Hosts host, String appToken, String authToken) {
		super(host, appToken, authToken);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que traz a
	 * lista de produtos que são vendidos pelo lojista.
	 * <p/>
	 * GET /sellerItems
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de produtos vendidos pelo lojista
	 */
	public List<SellerItem> getSellerItems(String offset, String limit) {

		setResource("/sellerItems");

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
	 * Método responsável por recuperar detalhes do item do pedido por sku
	 * 
	 * @param skuID
	 *            Sku id do produto
	 * @return Detalhes do item
	 */
	public SellerItem getSellerItemBySkuID(String skuID) {

		if (!skuID.isEmpty()) {
			setResource("/sellerItems/" + skuID);
		} else {
			throw new RuntimeException("É obrigatório passar o sku.");
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
	 * Método responsável por recuperar detalhes do item do pedido por sku
	 * 
	 * @param skuOrigin
	 *            Sku id do produto
	 * @return Detalhes do item
	 */
	public SellerItem getSellerItemBySkuOrigin(String skuOrigin) {

		if (!skuOrigin.isEmpty()) {
			setResource("/sellerItems/skuOrigin/" + skuOrigin);
		} else {
			throw new RuntimeException("É obrigatório passar o sku.");
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
	 * Método utilizado para realizar a chamada ao WebService Restful que faz a
	 * associação do produto ao lojista.
	 * <p/>
	 * POST /sellerItems
	 * 
	 * @param bodyParams
	 *            Mapa contendo os parâmetros que precisam ser passados no body
	 *            da requisição. Exemplo de conteúdo do mapa:
	 *            <p/>
	 *            { "skuOrigin": "string", "skuId": "string", "defaultPrice":
	 *            "500.00", "salePrice": "460.00", "availableQuantity": "100",
	 *            "installmentId": "20p3x", "totalQuantity": "250",
	 *            "crossDockingTime": 1 }
	 * @return Retorno da requisição, composto do status e o location da
	 *         associação do produto ao lojista.
	 */
	public String postSellerItem(Map<String, Object> bodyParams) {

		setResource("/sellerItems");

		ClientResponse response = null;

		try {
			response = post(bodyParams);
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
	 * atualiza a quantidade disponível para venda de um item do Lojista.
	 * <p/>
	 * PUT /sellerItems/{skuId}/stock
	 * 
	 * @param skuId
	 *            ID do produto a venda
	 * @param availableQuantity
	 *            Quantidade disponível
	 * @param totalQuantity
	 *            Quantidade total de produtos
	 * @return Status da operação.
	 */
	public String uptadeStock(String skuId, String availableQuantity,
			String totalQuantity) {

		setResource("/sellerItems/" + skuId + "/stock");

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("availableQuantity", availableQuantity);
		data.put("totalQuantity", totalQuantity);

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
	 * Método responsável por atualizar o preços dos items
	 * 
	 * @param skuId
	 *            número do sku
	 * @param defaultPrice
	 *            preço 'de'
	 * @param salePrice
	 *            preço 'por'
	 * @param installmentId
	 *            parcelamento do produto
	 * @return
	 */
	public String uptadePrice(String skuId, String defaultPrice,
			String salePrice, String installmentId) {

		setResource("/sellerItems/" + skuId + "/stock");

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("defaultPrice", defaultPrice);
		data.put("salePrice", salePrice);
		data.put("installmentId", installmentId);

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
	 * Método responsável por recuperar itens do lojista que já estão
	 * disponíveis para venda relacionados com o token do lojista informado.
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos disponíveis para venda
	 */
	public String getAvailableSellerItems(String offset, String limit) {

		setResource("/sellerItems/status/selling");

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

}