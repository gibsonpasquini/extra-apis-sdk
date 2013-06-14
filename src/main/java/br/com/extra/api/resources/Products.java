package br.com.extra.api.resources;

import java.util.List;

import br.com.extra.api.core.CoreAPIImpl;
import br.com.extra.api.core.Hosts;
import br.com.extra.api.pojo.Product;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;

public class Products extends CoreAPIImpl implements ProductsResource {

	public Products(Hosts host, String appToken, String authToken) {
		super(host, appToken, authToken);
	}

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * executal consulta de produtos.
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @param searchText
	 *            Texto livre para busca de produtos.
	 * @param idCategory
	 *            ID da categoria utilizada para realizar busca de produtos.
	 * 
	 * @return Lista de produtos consultada.
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
		if (searchText != null && searchText.length() == 0) {
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

		return null;

	}

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * consulta um produto pelo seu código SKU.
	 * 
	 * GET /products/{skuId}
	 * 
	 * @param skuID
	 *            ID do produto
	 * @return Produto consultado
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

		return null;
	}

}
