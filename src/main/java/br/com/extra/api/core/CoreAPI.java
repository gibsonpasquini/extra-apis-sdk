package br.com.extra.api.core;

import java.util.Map;

/**
 * 
 * @author gibson
 * 
 */
public interface CoreAPI {

	public void put(Map<String, Object> params);

	public void post(Map<String, Object> params);

	public void get(Map<String, Object> queryParams);
}
