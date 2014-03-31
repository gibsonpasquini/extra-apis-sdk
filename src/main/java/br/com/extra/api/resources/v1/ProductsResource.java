package br.com.extra.api.resources.v1;

import java.util.List;

import br.com.extra.api.core.exception.ServiceException;
import br.com.extra.api.pojo.v1.products.Product;

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
	 * consulta um produto pelo seu código do produto.
	 * <p/>
	 * GET /products/{productId}
	 * 
	 * @param productID
	 *            ID do produto.
	 * @return Produto consultado. Será retornado null caso o produto consultado
	 *         não exista.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<Product> getProduct(String productID) throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * consulta um produto pelo seu código SKU.
	 * <p/>
	 * GET /products/sku/{skuId}
	 * 
	 * @param productID
	 *            ID do produto no Marketplace.
	 * @return Lista de produtos relacionado ao productId consultado.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public Product getProductBySkuId(String skuID) throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * executa a consulta de produtos por ID da categoria.
	 * <p/>
	 * GET /products
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @param idCategory
	 *            ID da categoria utilizada para realizar busca de produtos.
	 * 
	 * @return Lista de produtos consultada.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<Product> getProducts(String offset, String limit,
			Integer idCategory) throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * executa a consulta de produtos por texto de busca livre.
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
	 * 
	 * @return Lista de produtos consultada.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<Product> getProducts(String offset, String limit,
			String searchText) throws ServiceException;

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
	 * @return Lista de produtos consultada. A lista será retornada vazia caso
	 *         não haja resultados.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<Product> getProducts(String offset, String limit,
			String searchText, Integer idCategory) throws ServiceException;
}
