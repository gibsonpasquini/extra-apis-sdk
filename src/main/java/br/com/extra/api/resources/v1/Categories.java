package br.com.extra.api.resources.v1;

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
import br.com.extra.api.core.exception.ServiceDataManipulationException;
import br.com.extra.api.core.exception.ServiceException;
import br.com.extra.api.pojo.v1.categories.Category;
import br.com.extra.api.utils.Utils;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * 
 * ExtraAPI-SDK - Products.java
 * 
 * Implementação do Serviço Restful /categories.
 * 
 * Serviço que possibilita ao lojista consultar a árvore de categorias do
 * Marketplace.
 * 
 * @author Gibson Pasquini Nascimento
 * 
 *         22/06/2013
 */
public class Categories extends CoreAPIImpl<Category> implements
		CategoriesResource {

	/**
	 * Construtor que instancia um objeto do serviço que consome a API
	 * /categories.
	 * 
	 * @param host
	 *            Host do serviço.
	 * @param appToken
	 *            Token de Aplicação.
	 * @param authToken
	 *            Token de Autenticação.
	 */
	public Categories(Hosts host, AppToken appToken, AuthToken authToken) {
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
	protected List<Category> getListFromResponse(ClientResponse response)
			throws IOException {
		List<Category> pojos = new ArrayList<Category>();
		try {
			pojos = new ObjectMapper().readValue(
					response.getEntityInputStream(),
					new TypeReference<List<Category>>() {
					});
		} catch (IOException e) {
			throw e;
		}
		return pojos;
	}

	@Override
	protected Class<Category> getPojoClass() {
		return Category.class;
	}

	/**
	 * {@inheritDoc}
	 */
	public Category getCategory(String levelId) throws ServiceException {

		if (!Utils.isEmpty(levelId)) {
			setResource("/categories/" + levelId);
		} else {
			throw new ServiceDataManipulationException(
					"Parameter levelId is mandatory for this request.");
		}

		ClientResponse response = get();
		Category category = null;

		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				category = getObjectFromResponse(response);
			} catch (IOException e) {
				throw new ServiceDataManipulationException(
						"Error handling response. ", e);
			}
		} else if (response.getStatus() != ClientResponse.Status.NOT_FOUND
				.getStatusCode()) {
			throw errorHandler(response);
		}

		return category;
	}


	/**
	 * {@inheritDoc}
	 */
	public List<Category> getCategories(Integer offset, Integer limit) throws ServiceException {

		
		if (Utils.isEmpty(offset) || Utils.isEmpty(limit)) {
			throw new ServiceDataManipulationException(
					"Parameters offset and limit are mandatories for this request.");
		}
		
		setResource("/categories");

		// Parâmetros da requisição
		MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
		queryParameters.add("_offset", String.valueOf(offset));
		queryParameters.add("_limit", String.valueOf(limit));

		ClientResponse response = super.setQueryParams(queryParameters).get();
		List<Category> categories = new ArrayList<Category>();
		if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			try {
				categories = getListFromResponse(response);
			} catch (IOException e) {
				throw new ServiceDataManipulationException(
						"Error handling response. ", e);
			}
		} else {
			throw errorHandler(response);
		}

		return categories;

	}

}
