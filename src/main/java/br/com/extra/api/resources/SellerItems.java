package br.com.extra.api.resources;

import java.util.List;
import java.util.Map;

import br.com.extra.api.core.CoreAPIImpl;
import br.com.extra.api.core.Hosts;
import br.com.extra.api.pojo.SellerItem;

public class SellerItems extends CoreAPIImpl implements SellerItemsResource {

	public SellerItems(Hosts host, String appToken, String authToken) {
		super(host, appToken, authToken);
		// TODO Auto-generated constructor stub
	}

	public List<SellerItem> getSellerItems(String offset, String limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public SellerItem getSellerItemBySkuID(String skuID) {
		// TODO Auto-generated method stub
		return null;
	}

	public SellerItem getSellerItemBySkuOrigin(String skuOrigin) {
		// TODO Auto-generated method stub
		return null;
	}

	public String postSellerItem(Map<String, Object> bodyParams) {
		// TODO Auto-generated method stub
		return null;
	}

	public String uptadeStock(String skuId, String availableQuantity,
			String totalQuantity) {
		// TODO Auto-generated method stub
		return null;
	}

	public String uptadePrice(String skuId, String defaultPrice,
			String salePrice, String installmentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
