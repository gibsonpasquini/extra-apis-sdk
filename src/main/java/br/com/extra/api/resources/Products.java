package br.com.extra.api.resources;

import java.util.List;

import br.com.extra.api.core.CoreAPIImpl;
import br.com.extra.api.core.Hosts;
import br.com.extra.api.pojo.Product;

public class Products extends CoreAPIImpl implements ProductsResource {

	public Products(Hosts host, String appToken, String authToken) {
		super(host, appToken, authToken);
	}

	public List<Product> getProducts(String offset, String limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProduct(String skuID) {
		// TODO Auto-generated method stub
		return null;
	}

}
