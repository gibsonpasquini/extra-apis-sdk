package br.com.extra.api.resources;

import java.util.List;

import br.com.extra.api.pojo.products.Product;

/**
 * 
 * ExtraAPI-SDK - ProductsResource.java
 * 
 * Interface do Serviço Restful /products.
 * 
 * Serviço que possibilita ao lojista consultar os produtos existentes no
 * Marketplace.
 * 
 * @author Gibson Pasquini Nascimento
 * @author Fillipe Massuda
 * 
 *         22/06/2013
 */
public interface ProductsResource {

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * executa a consulta de produtos.
	 * <p/>
	 * GET /products
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @param searchText
	 *            Texto livre para busca de produtos.
	 * @param idCategory
	 *            ID da categoria utilizada para realizar busca de produtos.
	 * 
	 * @return Lista de produtos consultada.
	 */
	public List<Product> getProducts(String offset, String limit,
			String searchText, Integer idCategory);

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * consulta um produto pelo seu código SKU.
	 * <p/>
	 * GET /products/{skuId}
	 * 
	 * @param skuID
	 *            SKU ID do produto no Marketplace.
	 * @return Produto consultado.
	 */
	public Product getProduct(String skuID);
}
