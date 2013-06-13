/**
 *
 */
package br.com.extra.api.core;

import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.filter.ClientFilter;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.Map;

/**
 * @author gibson
 */
public abstract class CoreAPIImpl implements CoreAPI {

	private String host;
	private String appToken;
	private String authToken;
	private String URI;

	public String getURL() {
		return this.host + this.URI;
	}

	public CoreAPIImpl(Hosts host, String appToken, String authToken) {
		this.host = host.toString();
		this.appToken = appToken;
		this.authToken = authToken;
	}

	public void setResource(String URI) {
		this.URI = URI;
	}


	@SuppressWarnings("rawtypes")
	public ClientResponse get(Map<String, Object> queryParams) {

		Client client = Client.create();

		// Headers da requisição
		client.addFilter(new ClientFilter() {
			@Override
			public ClientResponse handle(final ClientRequest clientRequest)
					throws ClientHandlerException {

				final MultivaluedMap<String, Object> headers = clientRequest
						.getHeaders();
				headers.add("nova-auth-token", authToken);
				headers.add("nova-app-token", appToken);

				return getNext().handle(clientRequest);
			}
		});

		@SuppressWarnings("unchecked")
		WebResource webResource = client.resource(host + URI).queryParams(
				(MultivaluedMap) queryParams);

		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(
				ClientResponse.class);

		return response;
	}

	public ClientResponse post(Map<String, Object> params) throws IOException {

		Client client = Client.create();

		// Inclusão dos headers de requisição
		client.addFilter(new ClientFilter() {
			@Override
			public ClientResponse handle(final ClientRequest clientRequest)
					throws ClientHandlerException {

				final MultivaluedMap<String, Object> headers = clientRequest
						.getHeaders();
				headers.add("nova-auth-token", authToken);
				headers.add("nova-app-token", appToken);

				return getNext().handle(clientRequest);
			}
		});

		WebResource webResource = client.resource(host + URI);

		String in = new ObjectMapper().writeValueAsString(params);

		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(
				ClientResponse.class, in);

		return response;
	}

	public ClientResponse put(Map<String, Object> params) throws IOException {

		Client client = Client.create();

		// Headers da requisição
		client.addFilter(new ClientFilter() {
			@Override
			public ClientResponse handle(final ClientRequest clientRequest)
					throws ClientHandlerException {

				final MultivaluedMap<String, Object> headers = clientRequest
						.getHeaders();
				headers.add("nova-auth-token", authToken);
				headers.add("nova-app-token", appToken);

				return getNext().handle(clientRequest);
			}
		});

		WebResource webResource = client.resource(host + URI);

		String in = new ObjectMapper().writeValueAsString(params);

		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, in);

		return response;

	}
}
