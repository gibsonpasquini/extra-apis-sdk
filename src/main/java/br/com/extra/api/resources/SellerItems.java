package br.com.extra.api.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import br.com.extra.api.core.AppToken;
import br.com.extra.api.core.AuthToken;
import br.com.extra.api.core.CoreAPIImpl;
import br.com.extra.api.core.Hosts;
import br.com.extra.api.pojo.sellerItems.SellerItem;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * ExtraAPI-SDK - SellerItems.java
 * 
 * Implementação da interface do Serviço Restful /sellerItems.
 * 
 * Serviço que possibilita ao lojista gerenciar os seus produtos vendidos.
 * 
 * @author Gibson Pasquini Nascimento
 * @author Fillipe Massuda
 * 
 *         21/06/2013
 */
public class SellerItems extends CoreAPIImpl<SellerItem> implements
		SellerItemsResource {

	/**
	 * Construtor que instancia um objeto do serviço que consome a API
	 * /sellerItems
	 * 
	 * @param host
	 *            Host do serviço.
	 * @param appToken
	 *            Token de Aplicação.
	 * @param authToken
	 *            Token de Autenticação.
	 */
	public SellerItems(Hosts host, AppToken appToken, AuthToken authToken) {
		super(host, appToken, authToken);
	}

	/**
	 * {@inheritDoc}
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

		// List<SellerItem> sellerItems = new ArrayList<SellerItem>();
		// try {
		// sellerItems = new ObjectMapper().readValue(
		// response.getEntityInputStream(),
		// new TypeReference<List<SellerItem>>() {
		// });
		// } catch (IOException e) {
		// throw new RuntimeException(
		// "Erro ao criar o retorno da requisição: " + e.toString());
		// }

		List<SellerItem> sellerItems = getListFromResponse(response);

		return sellerItems;

	}

	/**
	 * {@inheritDoc}
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

		// SellerItem sellerItem = new SellerItem();
		// try {
		// sellerItem = new ObjectMapper().readValue(
		// response.getEntityInputStream(),
		// new TypeReference<SellerItem>() {
		// });
		// } catch (IOException e) {
		// throw new RuntimeException(
		// "Erro ao criar o retorno da requisição: " + e.toString());
		// }

		SellerItem sellerItem = getObjectFromResponse(response);

		return sellerItem;
	}

	/**
	 * {@inheritDoc}
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

		SellerItem sellerItem = new SellerItem();
		try {
			sellerItem = new ObjectMapper().readValue(
					response.getEntityInputStream(),
					new TypeReference<SellerItem>() {
					});
		} catch (IOException e) {
			throw new RuntimeException(
					"Erro ao criar o retorno da requisição: " + e.toString());
		}

		return sellerItem;
	}

	public String postSellerItem(SellerItem sellerItem) {

		setResource("/sellerItems");

		ClientResponse response = null;

		try {
			Map<String, Object> bodyParams = new HashMap<String, Object>();
			bodyParams.put("skuOrigin", sellerItem.getSkuOrigin());
			bodyParams.put("skuId", sellerItem.getSkuId());
			bodyParams.put("defaultPrice", sellerItem.getDefaultPrice());
			bodyParams.put("salePrice", sellerItem.getSalePrice());
			bodyParams.put("availableQuantity",
					sellerItem.getAvailableQuantity());
			bodyParams.put("installmentId", sellerItem.getInstallmentId());
			bodyParams.put("totalQuantity", sellerItem.getTotalQuantity());
			bodyParams
					.put("crossDockingTime", sellerItem.getCrossDockingTime());

			response = post(bodyParams);
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

		String resp = response.getStatus() + " - "
				+ response.getClientResponseStatus().getReasonPhrase()
				+ " location: " + response.getLocation();
		return resp;

	}

	/**
	 * {@inheritDoc}
	 */
	public String uptadeStock(String skuId, Integer availableQuantity,
			Integer totalQuantity) {

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
							+ super.getURI());
		}

		if (response.getStatus() != ClientResponse.Status.NO_CONTENT
				.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return response.getClientResponseStatus().getStatusCode() + " - "
				+ response.getClientResponseStatus().name();
	}

	/**
	 * {@inheritDoc}
	 */
	public String uptadePrice(String skuId, Double defaultPrice,
			Double salePrice, String installmentId) {

		setResource("/sellerItems/" + skuId + "/prices");

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
							+ super.getURI());
		}

		if (response.getStatus() != ClientResponse.Status.NO_CONTENT
				.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		return response.getClientResponseStatus().getStatusCode() + " - "
				+ response.getClientResponseStatus().name();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<SellerItem> getAvailableSellerItems(String offset, String limit) {

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

		List<SellerItem> sellerItems = new ArrayList<SellerItem>();
		try {
			sellerItems = new ObjectMapper().readValue(
					response.getEntityInputStream(),
					new TypeReference<List<SellerItem>>() {
					});
		} catch (IOException e) {
			throw new RuntimeException(
					"Erro ao criar o retorno da requisição: " + e.toString());
		}

		return sellerItems;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<SellerItem> getPojoClass() {
		return SellerItem.class;
	}

}