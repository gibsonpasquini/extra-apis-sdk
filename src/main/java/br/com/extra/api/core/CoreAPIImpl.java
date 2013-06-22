/**
 *
 */
package br.com.extra.api.core;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.extra.api.pojo.Pojos;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * ExtraAPI-SDK - CoreAPIImpl.java
 * 
 * Implementação das operações padrão para chamada aos Serviços REST.
 * 
 * @author Gibson Pasquini Nascimento
 * @author Fillipe Massuda
 * 
 *         21/06/2013
 */
public abstract class CoreAPIImpl<T extends Pojos> implements CoreAPI {

	/**
	 * Endereço principal do serviço.<br/>
	 * Pode ser o endereço de Sandbox ou de Produção.
	 */
	private String host;

	/**
	 * Token que identifica a Aplicação que está efetuando a chamada aos
	 * recursos disponibilizados através da API.
	 */
	private String appToken;

	/**
	 * Token que identifica o Lojista que está utilizando a Aplicação para
	 * efetuar chamadas aos recursos disponibilizados através da API.
	 */
	private String authToken;

	/**
	 * Nome do serviço que será invocado.
	 */
	private String resource;

	/**
	 * Mapa de parâmetros que serão inseridos na queryString.
	 */
	private MultivaluedMap<String, String> queryParams;

	/**
	 * Construtor que cria uma instância do serviço.
	 * 
	 * @param host
	 *            Endereço principal do serviço.
	 * @param appToken
	 *            Token de Aplicação.
	 * @param authToken
	 *            Token de Autenticação.
	 */
	public CoreAPIImpl(Hosts host, AppToken appToken, AuthToken authToken) {
		this.host = host.toString();
		this.appToken = appToken.getCode();
		this.authToken = authToken.getCode();
		queryParams = new MultivaluedMapImpl();
	}

	/**
	 * Método que recupera o endereço do serviço.
	 * 
	 * @return Endereço completo do serviço.
	 */
	public String getURI() {
		return this.host + this.resource;
	}

	/**
	 * Método utilizado para setar o serviço que será invocado.
	 * 
	 * @param resource
	 *            Caminho do serviço.
	 */
	public void setResource(String resource) {
		this.resource = resource;
	}

	/**
	 * {@inheritDoc}
	 */
	public ClientResponse get() {

		Client client = Client.create();
		// Headers da requisição
		client.addFilter(getFilter());
		// Criação do serviço
		WebResource webResource = client.resource(host + resource).queryParams(
				this.queryParams);
		// Invocação do serviço
		ClientResponse response = webResource.accept(
				MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);

		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	public ClientResponse post(Map<String, Object> params) throws IOException {

		Client client = Client.create();
		// Inclusão dos headers de requisição
		client.addFilter(this.getFilter());
		// Criação do serviço
		WebResource webResource = client.resource(host + resource);
		// Criação do objeto JSON com os parâmetros
		String in = new ObjectMapper().writeValueAsString(params);
		// Invocação do serviço
		ClientResponse response = webResource.type(
				MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, in);

		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	public ClientResponse put(Map<String, Object> params) throws IOException {

		Client client = Client.create();
		// Headers da requisição
		client.addFilter(getFilter());
		// Criação do serviço
		WebResource webResource = client.resource(host + resource);
		// Criação do objeto JSON com os parâmetros
		String in = new ObjectMapper().writeValueAsString(params);
		// Invocação do serviço
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, in);

		return response;

	}

	/**
	 * {@inheritDoc}
	 */
	public CoreAPI setQueryParams(MultivaluedMap<String, String> queryParams) {
		this.queryParams = queryParams;
		return this;
	}

	/**
	 * Método que recupera do response o objeto que deverá ser retornado.
	 * 
	 * @param response
	 *            Response da requisição realizada.
	 * @return <T> Objeto criado de acordo com o tipo definido nas classes dos
	 *         serviços.
	 */
	protected T getObjectFromResponse(ClientResponse response) {
		T pojo = null;
		try {
			pojo = new ObjectMapper().readValue(
					response.getEntityInputStream(), getPojoClass());
		} catch (IOException e) {
			throw new RuntimeException(
					"Erro ao criar o retorno da requisição: " + e.toString());
		}
		return pojo;
	}

	/**
	 * Método que recupera do response uma lista de objeto que deverá ser
	 * retornado.
	 * 
	 * @param response
	 *            Response da requisição realizada.
	 * @return <T> Lista de objetos criada de acordo com o tipo definido nas
	 *         classes dos serviços.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> getListFromResponse(ClientResponse response) {
		List<T> pojos = null;
		try {
			pojos = new ObjectMapper().readValue(
					response.getEntityInputStream(), List.class);
		} catch (IOException e) {
			throw new RuntimeException(
					"Erro ao criar o retorno da requisição: " + e.toString());
		}
		return pojos;
	}

	/**
	 * Método que cria o filtro contendo os tokens no header.
	 * 
	 * @return Filtro com os tokens.
	 */
	private ClientFilter getFilter() {
		return new ClientFilter() {
			@Override
			public ClientResponse handle(final ClientRequest clientRequest)
					throws ClientHandlerException {
				// Criação do mapa para inclusão de parâmetros do header
				final MultivaluedMap<String, Object> headers = clientRequest
						.getHeaders();
				headers.add("nova-auth-token", authToken);
				headers.add("nova-app-token", appToken);
				return getNext().handle(clientRequest);
			}
		};
	}

	/**
	 * Método abstrato que deverá ser implementado nas classes dos serviços e
	 * que deverá retornar a classe para a qual os objetos obtidos do response
	 * deverão ser convertidos.
	 * 
	 * @return Classe para conversão.
	 */
	protected abstract Class<T> getPojoClass();

}
