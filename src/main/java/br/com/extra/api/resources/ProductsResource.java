package br.com.extra.api.resources;

import java.util.List;

import br.com.extra.api.pojo.Product;

public interface ProductsResource {

	public List<Product> getProducts(String offset, String limit, String searchText, Integer idCategory);

	public Product getProduct(String skuID);
}
