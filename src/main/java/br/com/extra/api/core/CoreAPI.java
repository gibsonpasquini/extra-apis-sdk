package br.com.extra.api.core;

import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.Map;

/**
 * ExtraAPI-SDK - CoreAPI.java
 * 
 * Interface com as operações padrão para chamada aos Serviços REST.
 * 
 * @author Gibson Pasquini Nascimento
 * @author Fillipe Massuda
 * 
 *         21/06/2013
 */
public interface CoreAPI {

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
	public ClientResponse put(Map<String, Object> params) throws IOException;

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
	public ClientResponse post(Object params) throws IOException;
	

	/**
	 * Método GET.
	 * 
	 * @return Objeto contendo o retorno da requisição.
	 */
	public ClientResponse get();

	/**
	 * Método utilizado para setar parâmetros que devem ser incluídos na
	 * queryString da operação GET
	 * 
	 * @param queryParams
	 *            Mapa de parâmetros para a queryString
	 * @return Instância atual da classe.
	 */
	public CoreAPI setQueryParams(MultivaluedMap<String, String> queryParams);
}
