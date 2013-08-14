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
import br.com.extra.api.core.exception.ServiceException;
import br.com.extra.api.pojo.sellerItems.SellerItem;
import br.com.extra.api.utils.Utils;

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
	 * Método que recupera do response uma lista de objeto que deverá ser
	 * retornado.
	 * 
	 * @param response
	 *            Response da requisição realizada.
	 * @return Lista de objetos items do lojista.
	 * @throws IOException
	 *             Exceção lançada no parse da lista de retorno.
	 */
	protected List<SellerItem> getListFromResponse(ClientResponse response)
			throws IOException {
		List<SellerItem> pojos = new ArrayList<SellerItem>();
		try {
			pojos = new ObjectMapper().readValue(
					response.getEntityInputStream(),
					new TypeReference<List<SellerItem>>() {
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
	protected Class<SellerItem> getPojoClass() {
		return SellerItem.class;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<SellerItem> getAvailableSellerItems(String offset, String limit)
			throws ServiceException {

		setResource("/sellerItems/status/selling");

		// Parâmetros da requisição
		MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add("_offset", offset);
		queryParameters.add("_limit", limit);

		ClientResponse response = super.setQueryParams(queryParameters).get();

		List<SellerItem> sellerItems = new ArrayList<SellerItem>();
		// Caso a consulta retornar algum resultado, o objeto será populado,
		// senão, retorna a lista vazia.
		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				sellerItems = getListFromResponse(response);
			} catch (IOException e) {
				throw new ServiceException("Error handling response. ", e);
			}
		} else {
			throw new ServiceException(response.toString());
		}

		return sellerItems;

	}

	/**
	 * {@inheritDoc}
	 */
	public SellerItem getSellerItemBySkuID(String skuID)
			throws ServiceException {

		if (!Utils.isEmpty(skuID)) {
			setResource("/sellerItems/" + skuID);
		} else {
			throw new ServiceException("Parameter skuId is mandatory.");
		}

		ClientResponse response = get();
		SellerItem sellerItem = null;

		// Caso a consulta retornar algum resultado, o objeto será populado,
		// senão, retorna null.
		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				sellerItem = getObjectFromResponse(response);
			} catch (IOException e) {
				throw new ServiceException("Error handling response. ", e);
			}
		} else if (response.getStatus() != ClientResponse.Status.NOT_FOUND
				.getStatusCode()) {
			String message = response.getStatus() + " - "
					+ response.getClientResponseStatus().getReasonPhrase();
			throw new ServiceException(message);
		}

		return sellerItem;
	}

	/**
	 * {@inheritDoc}
	 */
	public SellerItem getSellerItemBySkuOrigin(String skuOrigin)
			throws ServiceException {

		if (!Utils.isEmpty(skuOrigin)) {
			setResource("/sellerItems/skuOrigin/" + skuOrigin);
		} else {
			throw new ServiceException("Parameter skuOrigin is mandatory.");
		}

		ClientResponse response = get();

		SellerItem sellerItem = null;

		// Caso a consulta retornar algum resultado, o objeto será populado,
		// senão, retorna null.
		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				sellerItem = getObjectFromResponse(response);
			} catch (IOException e) {
				throw new ServiceException("Error handling response. ", e);
			}
		} else if (response.getStatus() != ClientResponse.Status.NOT_FOUND
				.getStatusCode()) {
			String message = response.getStatus() + " - "
					+ response.getClientResponseStatus().getReasonPhrase();
			throw new ServiceException(message);
		}

		return sellerItem;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<SellerItem> getSellerItems(String offset, String limit)
			throws ServiceException {

		setResource("/sellerItems");

		// Parâmetros da requisição
		MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add("_offset", offset);
		queryParameters.add("_limit", limit);

		ClientResponse response = super.setQueryParams(queryParameters).get();

		List<SellerItem> sellerItems = new ArrayList<SellerItem>();
		// Caso a consulta retornar algum resultado, o objeto será populado,
		// senão, retorna a lista vazia.
		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				sellerItems = getListFromResponse(response);
			} catch (IOException e) {
				throw new ServiceException("Error handling response. ", e);
			}
		} else {
			throw new ServiceException(response.toString());
		}

		return sellerItems;

	}

	/**
	 * {@inheritDoc}
	 */
	public String postSellerItem(SellerItem sellerItem) throws ServiceException {

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
				+ response.getClientResponseStatus().getReasonPhrase()
				+ " location: " + response.getLocation();
		return resp;

	}

	/**
	 * {@inheritDoc}
	 */
	public String uptadePrice(String skuId, Double defaultPrice,
			Double salePrice, String installmentId) throws ServiceException {

		setResource("/sellerItems/" + skuId + "/prices");

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("defaultPrice", defaultPrice);
		data.put("salePrice", salePrice);
		data.put("installmentId", installmentId);

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
	public String uptadeStock(String skuId, Integer availableQuantity,
			Integer totalQuantity) throws ServiceException {

		setResource("/sellerItems/" + skuId + "/stock");

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("availableQuantity", availableQuantity);
		data.put("totalQuantity", totalQuantity);

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

}