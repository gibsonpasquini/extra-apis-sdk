package br.com.extra.api.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import br.com.extra.api.core.AppToken;
import br.com.extra.api.core.AuthToken;
import br.com.extra.api.core.CoreAPIImpl;
import br.com.extra.api.core.Hosts;
import br.com.extra.api.core.exception.ServiceException;
import br.com.extra.api.pojo.products.Product;
import br.com.extra.api.utils.Utils;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * 
 * ExtraAPI-SDK - Products.java
 * 
 * Implementação do Serviço Restful /products.
 * 
 * Serviço que possibilita ao lojista consultar os produtos existentes no
 * Marketplace.
 * 
 * @author Gibson Pasquini Nascimento
 * @author Fillipe Massuda
 * 
 *         22/06/2013
 */
public class Products extends CoreAPIImpl<Product> implements ProductsResource {

	/**
	 * Construtor que instancia um objeto do serviço que consome a API
	 * /products.
	 * 
	 * @param host
	 *            Host do serviço.
	 * @param appToken
	 *            Token de Aplicação.
	 * @param authToken
	 *            Token de Autenticação.
	 */
	public Products(Hosts host, AppToken appToken, AuthToken authToken) {
		super(host, appToken, authToken);
	}

	/**
	 * Método que recupera do response uma lista de objeto que deverá ser
	 * retornado.
	 * 
	 * @param response
	 *            Response da requisição realizada.
	 * @return Lista de objetos produtos.
	 * @throws IOException
	 *             Exceção lançada no parse da lista de retorno.
	 */
	protected List<Product> getListFromResponse(ClientResponse response)
			throws IOException {
		List<Product> pojos = new ArrayList<Product>();
		try {
			pojos = new ObjectMapper().readValue(
					response.getEntityInputStream(),
					new TypeReference<List<Product>>() {
					});
		} catch (IOException e) {
			throw e;
		}
		return pojos;
	}

	@Override
	protected Class<Product> getPojoClass() {
		return Product.class;
	}

	/**
	 * {@inheritDoc}
	 */
	public Product getProduct(String productID) throws ServiceException {

		if (!Utils.isEmpty(productID)) {
			setResource("/products/" + productID);
		} else {
			throw new ServiceException("Parameter productId is mandatory.");
		}

		ClientResponse response = get();
		Product product = null;

		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				product = getObjectFromResponse(response);
			} catch (IOException e) {
				throw new ServiceException("Error handling response. ", e);
			}
		} else if (response.getStatus() != ClientResponse.Status.NOT_FOUND
				.getStatusCode()) {
			String message = response.getStatus() + " - "
					+ response.getClientResponseStatus().getReasonPhrase();
			throw new ServiceException(message);
		}

		return product;
	}

	public Product getProductBySkuId(String skuID) throws ServiceException {

		if (!Utils.isEmpty(skuID)) {
			setResource("/products/sku/" + skuID);
		} else {
			throw new ServiceException("Parameter skuId is mandatory.");
		}

		ClientResponse response = get();
		Product product = null;

		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				product = getObjectFromResponse(response);
			} catch (IOException e) {
				throw new ServiceException("Error handling response. ", e);
			}
		} else if (response.getStatus() != ClientResponse.Status.NOT_FOUND
				.getStatusCode()) {
			String message = response.getStatus() + " - "
					+ response.getClientResponseStatus().getReasonPhrase();
			throw new ServiceException(message);
		}

		return product;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Product> getProducts(String offset, String limit,
			Integer idCategory) throws ServiceException {
		return this.getProducts(offset, limit, null, idCategory);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Product> getProducts(String offset, String limit,
			String searchText) throws ServiceException {
		return this.getProducts(offset, limit, searchText, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Product> getProducts(String offset, String limit,
			String searchText, Integer idCategory) throws ServiceException {

		setResource("/products");

		// Parâmetros da requisição
		MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add("_offset", offset);
		queryParameters.add("_limit", limit);
		// Um dos dois parâmetros precisa ser inserido na consulta:
		// searchText ou idCategory
		if (searchText != null && searchText.length() > 0) {
			queryParameters.add("searchText", searchText);
		} else if (idCategory != null) {
			queryParameters.add("idCategory", idCategory.toString());
		} else {
			throw new ServiceException(
					"At least one parameter must be informed for this service: searchText or idCategory.");
		}

		ClientResponse response = super.setQueryParams(queryParameters).get();
		List<Product> products = new ArrayList<Product>();
		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				products = getListFromResponse(response);
			} catch (IOException e) {
				throw new ServiceException("Error handling response. ", e);
			}
		}

		return products;

	}

}
