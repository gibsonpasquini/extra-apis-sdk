package br.com.extra.api.resources.v1;

import java.util.List;

import br.com.extra.api.core.exception.ServiceException;
import br.com.extra.api.pojo.v1.categories.Category;

/**
 * 
 * ExtraAPI-SDK - CategoriesResource.java
 * 
 * Interface do Serviço Restful /categories.
 * 
 * Serviço que possibilita ao lojista consultar a árvore de categorias do
 * Marketplace.
 * 
 * @author Gibson Pasquini Nascimento
 * 
 *         31/03/2014
 */
public interface CategoriesResource {

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * consulta uma categoria pelo seu código.
	 * <p/>
	 * GET /categories/{levelId}
	 * 
	 * @param levelID
	 *            ID da categoria.
	 * @return Categoria consultada. Será retornado nulo caso a categoria não
	 *         exista (404 - Not Found).
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public Category getCategory(String levelID) throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * retorna a listagem de categorias.
	 * <p/>
	 * GET /categories
	 * 
	 * @param offset
	 *            Parâmetro utilizado para indicar a posição inicial de
	 *            consulta.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela consulta.
	 * 
	 * 
	 * @return Lista de categorias consultada.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<Category> getCategories(Integer offset, Integer limit)
			throws ServiceException;

}
