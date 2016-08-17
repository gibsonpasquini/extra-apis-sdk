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

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import br.com.extra.api.core.exception.ServiceBusinessException;
import br.com.extra.api.core.exception.ServiceDataManipulationException;
import br.com.extra.api.core.exception.ServiceException;
import br.com.extra.api.core.exception.ServiceInfrastructureException;
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

	private static final Logger logger = Logger.getLogger(CoreAPIImpl.class);
	/**
	 * Endereço principal do serviço.<br/>
	 * Pode ser o endereço de Sandbox ou de Produção.
	 */
	private Hosts host;

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
	 * Objeto utilizado para receber o conteúdo que será utilizado como corpo do
	 * Request
	 */
	private Object requestBody;

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
		this.host = host;
		this.appToken = appToken.getCode();
		this.authToken = authToken.getCode();
		queryParams = new MultivaluedMapImpl();
	}

	/**
	 * Método utilizado para construir o Client do serviço.
	 * 
	 * @return WebResource que executa a chamada ao serviço
	 */
	private WebResource build() {
		Client client = Client.create();
		// Inclusão dos headers de requisição
		client.addFilter(this.getFilter());
		// Criação do serviço
		WebResource webResource = client.resource(host + resource);

		return webResource;
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
				headers.remove("Host");
				return getNext().handle(clientRequest);
			}
		};
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
	 * Método utilizado para fazer o tratamento de erros
	 * 
	 * @param response
	 *            Resposta da requisição.
	 * @param message
	 *            Mensagem que será retornada na exceção.
	 * @throws ServiceException
	 *             Exceção que deverá ser lançada.
	 */
	protected ServiceException errorHandler(ClientResponse response) {
		String message = "Error on your request: " + response.toString()
				+ ". Reason: " + response.getEntity(String.class);
		if (response.getStatus() >= 400 && response.getStatus() < 500) {
			ServiceException ex = new ServiceBusinessException(
					response.getStatus(), message);
			logger.error(ex);
			return ex;
		} else if (response.getStatus() >= 500) {
			ServiceException ex = new ServiceInfrastructureException(
					response.getStatus(), message);
			logger.error(ex);
			return ex;
		} else {
			ServiceException ex = new ServiceException(response.getStatus(),
					message);
			logger.error(ex);
			return ex;
		}
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
	 * Método utilizado para validar se a chamada realmente está sendo realizada
	 * para Sandbox
	 * 
	 * @throws ServiceInfrastructureException
	 *             Exceção lançada caso a chamada seja feita para o Host de
	 *             Produção.
	 */
	protected void validateSandboxRequest()
			throws ServiceInfrastructureException {
		if (Hosts.SANDBOX != getHost()) {
			throw new ServiceInfrastructureException(
					403,
					"You are not allowed to perform this operation in Production Environment. POST /orders is only allowed in Sandbox.");
		}
	}

	/**
	 * Método GET.
	 * 
	 * @return Objeto contendo o retorno da requisição.
	 */
	public ClientResponse get() {

		WebResource webResource = build().queryParams(this.queryParams);
		if (logger.isDebugEnabled()) {
			logger.debug(webResource + ". nova-app-token: " + this.appToken
					+ ", nova-auth-token: " + this.authToken);
		}
		// Invocação do serviço
		ClientResponse response = webResource.accept(getMediaType()).get(
				ClientResponse.class);
		this.queryParams.clear();
		this.mediaType = null;
		return response;
	}

	/**
	 * Retorna o host que está sendo utilizado.
	 * 
	 * @return Host.
	 */
	public Hosts getHost() {
		return this.host;
	}

	/**
	 * Método que recupera o endereço do serviço.
	 * 
	 * @return Endereço completo do serviço.
	 */
	public String getURI() {
		return this.host.toString() + this.resource;
	}

	/**
	 * Método POST sem parâmetros.
	 * 
	 * @return Objeto contendo o retorno da requisição.
	 * @throws ServiceDataManipulationException
	 *             Exceção lançada caso haja problemas na manipulação dos dados
	 *             da chamada.
	 */
	public ClientResponse post() throws ServiceDataManipulationException {
		WebResource webResource = build();
		ClientResponse response = webResource.type(getMediaType()).post(
				ClientResponse.class);
		this.mediaType = null;
		return response;
	}

	/**
	 * Método POST.
	 * 
	 * @param params
	 *            Objeto contendo os parâmetros que serão incluídos no corpo da
	 *            requisição.
	 * @return Objeto contendo o retorno da requisição.
	 * @throws ServiceDataManipulationException
	 *             Exceção lançada caso haja problemas na manipulação dos dados
	 *             da chamada.
	 */
	public ClientResponse post(Object params)
			throws ServiceDataManipulationException {

		WebResource webResource = build();

		if (!(params instanceof byte[])) {
			// Criação do objeto JSON com os parâmetros quando for enviado um
			// Mapa
			try {
				requestBody = new ObjectMapper().writeValueAsString(params);
			} catch (IOException e) {
				throw new ServiceDataManipulationException(e);
			}
		} else {
			requestBody = params;
		}
		if (logger.isDebugEnabled()) {
			logger.debug(webResource + ". nova-app-token: " + this.appToken
					+ ", nova-auth-token: " + this.authToken);
			logger.debug(requestBody);
		}

		// Invocação do serviço
		ClientResponse response = webResource.type(getMediaType()).post(
				ClientResponse.class, requestBody);
		this.mediaType = null;
		return response;
	}

	/**
	 * Método PUT sem parâmetros.
	 * 
	 * @return Objeto contendo o retorno da requisição.
	 * @throws ServiceDataManipulationException
	 *             Exceção lançada caso haja problemas na manipulação dos dados
	 *             da chamada.
	 */
	public ClientResponse put() throws ServiceDataManipulationException {
		WebResource webResource = build();
		ClientResponse response = webResource.type(getMediaType())
				.accept(getMediaType()).put(ClientResponse.class);
		this.mediaType = null;
		return response;
	}

	/**
	 * Método PUT.
	 * 
	 * @param params
	 *            Mapa contendo os parâmetros que serão incluídos no corpo da
	 *            requisição.
	 * @return Objeto contendo o retorno da requisição.
	 * @throws ServiceDataManipulationException
	 *             Exceção lançada caso haja problemas na manipulação dos dados
	 *             da chamada.
	 */
	public ClientResponse put(Map<String, Object> params)
			throws ServiceDataManipulationException {

		WebResource webResource = build();
		// Criação do objeto JSON com os parâmetros
		try {
			requestBody = new ObjectMapper().writeValueAsString(params);
		} catch (IOException e) {
			throw new ServiceDataManipulationException(e);
		}
		// Invocação do serviço
		if (logger.isDebugEnabled()) {
			logger.debug(webResource + ". nova-app-token: " + this.appToken
					+ ", nova-auth-token: " + this.authToken);
			logger.debug(requestBody);
		}
		ClientResponse response = webResource.type(getMediaType())
				.accept(getMediaType()).put(ClientResponse.class, requestBody);
		this.mediaType = null;
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
