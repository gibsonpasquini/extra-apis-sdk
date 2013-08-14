/**
 *
 */
package br.com.extra.api.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import br.com.extra.api.pojo.Pojos;
import br.com.extra.api.utils.Utils;

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
public abstract class CoreAPIImpl<T extends Pojos> {

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
	 * Tipo de media da requisição;
	 */
	private String mediaType;

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
	 * Método GET.
	 * 
	 * @return Objeto contendo o retorno da requisição.
	 */
	public ClientResponse get() {

		Client client = Client.create();
		// Headers da requisição
		client.addFilter(getFilter());
		// Criação do serviço
		WebResource webResource = client.resource(host + resource).queryParams(
				this.queryParams);
		// Invocação do serviço
		ClientResponse response = webResource.accept(getMediaType()).get(
				ClientResponse.class);

		return response;
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
				headers.add("Host", "sandbox.extra.com.br");
				return getNext().handle(clientRequest);
			}
		};
	}

	/**
	 * Método que recupera do response uma lista de objeto que deverá ser
	 * retornado.
	 * 
	 * @param response
	 *            Response da requisição realizada.
	 * @return <T> Lista de objetos criada de acordo com o tipo definido nas
	 *         classes dos serviços.
	 * @throws IOException
	 * @deprecated - Esta operação não está sendo utilizada devido um problema
	 *             na tipagem da lista de retorno.
	 */
	@Deprecated
	protected List<T> getListFromResponse(ClientResponse response)
			throws IOException {
		List<T> pojos = new ArrayList<T>();
		try {
			pojos = new ObjectMapper().readValue(
					response.getEntityInputStream(),
					new TypeReference<List<T>>() {
					});
		} catch (IOException e) {
			throw new RuntimeException(
					"Erro ao criar o retorno da requisição: " + e.toString());
		}
		return pojos;
	}

	/**
	 * Método utilizado para recuperar o MediaType do Request
	 * 
	 * @return MediaType informado ou APPLICATION_JSON_TYPE.toString() como
	 *         padrão
	 */
	private String getMediaType() {
		String type = Utils.isEmpty(mediaType) ? MediaType.APPLICATION_JSON_TYPE
				.toString() : this.mediaType;
		return type;
	}

	/**
	 * Método que recupera do response o objeto que deverá ser retornado.
	 * 
	 * @param response
	 *            Response da requisição realizada.
	 * @return <T> Objeto criado de acordo com o tipo definido nas classes dos
	 *         serviços.
	 * @throws IOException
	 *             Exceção lançada no parse da lista de retorno.
	 */
	protected T getObjectFromResponse(ClientResponse response)
			throws IOException {
		T pojo = null;
		try {
			pojo = new ObjectMapper().readValue(
					response.getEntityInputStream(), getPojoClass());
		} catch (IOException e) {
			throw e;
		}
		return pojo;
	}

	/**
	 * Método abstrato que deverá ser implementado nas classes dos serviços e
	 * que deverá retornar a classe para a qual os objetos obtidos do response
	 * deverão ser convertidos.
	 * 
	 * @return Classe para conversão.
	 */
	protected abstract Class<T> getPojoClass();

	/**
	 * Método que recupera o endereço do serviço.
	 * 
	 * @return Endereço completo do serviço.
	 */
	public String getURI() {
		return this.host + this.resource;
	}

	/**
	 * Método POST.
	 * 
	 * @param params
	 *            Objeto contendo os parâmetros que serão incluídos no corpo da
	 *            requisição.
	 * @return Objeto contendo o retorno da requisição.
	 * @throws IOException
	 *             Exceção lançada caso haja problemas com a chamada.
	 */
	public ClientResponse post(Object params) throws IOException {

		Client client = Client.create();
		// Inclusão dos headers de requisição
		client.addFilter(this.getFilter());
		// Criação do serviço
		WebResource webResource = client.resource(host + resource);

		Object input = null;
		if (params instanceof Map) {
			// Criação do objeto JSON com os parâmetros quando for enviado um
			// Mapa
			input = new ObjectMapper().writeValueAsString(params);
		} else {
			input = params;
		}

		// Invocação do serviço
		ClientResponse response = webResource.type(getMediaType()).post(
				ClientResponse.class, input);

		return response;
	}

	/**
	 * Método PUT.
	 * 
	 * @param params
	 *            Mapa contendo os parâmetros que serão incluídos no corpo da
	 *            requisição.
	 * @return Objeto contendo o retorno da requisição.
	 * @throws IOException
	 *             Exceção lançada caso haja problemas com a chamada.
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
		ClientResponse response = webResource.type(getMediaType())
				.accept(getMediaType()).put(ClientResponse.class, in);

		return response;

	}

	/**
	 * Método utilizado para setar o tipo de media da requisição.
	 * 
	 * @param mediaType
	 *            Tipo de media
	 * @return Instância atual da classe.
	 */
	public CoreAPIImpl<T> setMediaType(String mediaType) {
		this.mediaType = mediaType;
		return this;
	}

	/**
	 * Método utilizado para setar parâmetros que devem ser incluídos na
	 * queryString da operação GET
	 * 
	 * @param queryParams
	 *            Mapa de parâmetros para a queryString
	 * @return Instância atual da classe.
	 */
	public CoreAPIImpl<T> setQueryParams(
			MultivaluedMap<String, String> queryParams) {
		this.queryParams = queryParams;
		return this;
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

}
