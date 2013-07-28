package br.com.extra.api.resources;

import br.com.extra.api.pojo.loads.ProductLoad;

/**
 * 
 * ExtraAPI-SDK - Loads.java
 * 
 * Interface do Serviço Restful /loads.
 * 
 * Serviço que possibilita ao lojista realizar cargas.
 * 
 * @author Gibson Pasquini Nascimento
 * 
 *         17/07/2013
 */
public interface LoadsResource {

	/**
	 * Método utilizado para enviar uma nova carga de produtos. Esta operação é
	 * assíncrona.
	 * <p/>
	 * POST /loads/products
	 * 
	 * @param products
	 *            Objeto que pode conter um arquivo JSON que será compactado ou
	 *            uma String que contém JSON que será compactada.
	 * @return Status da operação.
	 */
	public String loadProducts(ProductLoad products);
	
}