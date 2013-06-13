package br.com.extra.api.core;

import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.Map;

/**
 * 
 * @author gibson
 * 
 */
public interface CoreAPI {

	public ClientResponse put(Map<String, Object> params) throws IOException;

	public ClientResponse post(Map<String, Object> params) throws IOException;

	public ClientResponse get(MultivaluedMap queryParams);
}
