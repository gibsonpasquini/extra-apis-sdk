/**
 * 
 */
package br.com.extra.api.core;

import java.util.Map;

/**
 * @author gibson
 * 
 */
public abstract class CoreAPIImpl implements CoreAPI {

	private String host;
	private String appToken;
	private String authToken;
	private String URI;

	public CoreAPIImpl(Hosts host, String appToken, String authToken) {
		this.host = host.toString();
		this.appToken = appToken;
		this.authToken = authToken;
	}

	public void setResource(String URI) {
		this.URI = URI;
	}

	public void get(Map<String, Object> queryParams) {
		// TODO Auto-generated method stub

	}

	public void post(Map<String, Object> params) {
		// TODO Auto-generated method stub

	}

	public void put(Map<String, Object> params) {
		// TODO Auto-generated method stub

	}
}
