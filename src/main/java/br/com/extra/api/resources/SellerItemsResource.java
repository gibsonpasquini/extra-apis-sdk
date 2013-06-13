package br.com.extra.api.resources;

import java.util.List;
import java.util.Map;

import br.com.extra.api.pojo.SellerItem;

public interface SellerItemsResource {

	public List<SellerItem> getSellerItems(String offset, String limit);

	public SellerItem getSellerItemBySkuID(String skuID);

	public SellerItem getSellerItemBySkuOrigin(String skuOrigin);

	public String postSellerItem(Map<String, Object> bodyParams);

	public String uptadeStock(String skuId, String availableQuantity,
			String totalQuantity);

	public String uptadePrice(String skuId, String defaultPrice,
			String salePrice, String installmentId);

    public String getAvailableSellerItems(String offset, String limit);
}
