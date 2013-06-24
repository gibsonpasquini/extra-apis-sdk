package br.com.extra.api.resources;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import br.com.extra.api.core.AppToken;
import br.com.extra.api.core.AuthToken;
import br.com.extra.api.core.CoreAPIImpl;
import br.com.extra.api.core.Hosts;
import br.com.extra.api.pojo.products.Product;

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

	public Products(Hosts host, AppToken appToken, AuthToken authToken) {
		super(host, appToken, authToken);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Product> getProducts(String offset, String limit,
			String searchText) {
		return this.getProducts(offset, limit, searchText, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Product> getProducts(String offset, String limit,
			Integer idCategory) {
		return this.getProducts(offset, limit, null, idCategory);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<Product> getProducts(String offset, String limit,
			String searchText, Integer idCategory) {

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
			throw new RuntimeException(
					"É obrigatório inserir pelo menos um dos parâmetros: searchText ou idCategory.");
		}

		ClientResponse response = super.setQueryParams(queryParameters).get();

		if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}
		List<Product> products = getListFromResponse(response);

		return products;

	}

	/**
	 * {@inheritDoc}
	 */
	public Product getProduct(String skuID) {

		if (skuID != null && !skuID.isEmpty()) {
			setResource("/products/" + skuID);
		} else {
			throw new RuntimeException("É obrigatório passar o skuID.");
		}

		ClientResponse response = get();

		if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
			// Fazer tratamento de erro adequado.
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.toString());
		}

		Product product = getObjectFromResponse(response);
		return product;
	}

	@Override
	protected Class<Product> getPojoClass() {
		return Product.class;
	}

}
