package br.com.extra.api.resources;

import br.com.extra.api.core.exception.ServiceException;
import br.com.extra.api.pojo.loads.LoadConfirmation;
import br.com.extra.api.pojo.loads.LoadResponse;
import br.com.extra.api.pojo.loads.ProductLoad;
import br.com.extra.api.pojo.loads.ProductLoadResponse;

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
	 * Método utilizado para consultar o status da carga dos produtos.
	 * 
	 * <p/>
	 * GET /loads/products/{importerInfoId
	 * 
	 * @param importerInfoId
	 *            ID da operação de importação.
	 * @return Objeto que contém o status da importação.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public LoadResponse getLoadStatus(String importerInfoId)
			throws ServiceException;

	/**
	 * Método utilizado para consultar o status de um produto da carga dos
	 * produtos.
	 * 
	 * <p/>
	 * GET /loads/products/{importerInfoId
	 * 
	 * @param importerInfoId
	 *            ID da operação de importação.
	 * @param skuOrigin
	 *            SKU ID do produto do Lojista.
	 * @return Objeto que contém o status do produto importado.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public ProductLoadResponse getProductLoadStatus(String importerInfoId,
			String skuOrigin) throws ServiceException;

	/**
	 * Método utilizado para enviar uma nova carga de produtos. Esta operação é
	 * assíncrona.
	 * <p/>
	 * POST /loads/products
	 * 
	 * @param products
	 *            Objeto que pode conter um arquivo JSON que será compactado ou
	 *            uma String que contém JSON que será compactada.
	 * @return Confirmação da execução da operação.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public LoadConfirmation loadProducts(ProductLoad products) throws ServiceException;

}