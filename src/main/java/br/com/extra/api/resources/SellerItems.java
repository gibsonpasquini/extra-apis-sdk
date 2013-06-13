package br.com.extra.api.resources;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.extra.api.core.CoreAPIImpl;
import br.com.extra.api.core.Hosts;
import br.com.extra.api.pojo.SellerItem;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.core.MultivaluedMap;

public class SellerItems extends CoreAPIImpl implements SellerItemsResource {

    public SellerItems(Hosts host, String appToken, String authToken) {
        super(host, appToken, authToken);
        // TODO Auto-generated constructor stub
    }

    /**
     * Método utilizado para realizar a chamada ao WebService Restful que traz a
     * lista de produtos que são vendidos pelo lojista.
     * <p/>
     * GET /sellerItems
     *
     * @param offset Parâmetro utilizado para limitar a quantidade de registros
     *               trazidos por página.
     * @param limit  Parâmetro utilizado para limitar a quantidade de registros
     *               trazidos pela operação.
     * @return Lista de produtos vendidos pelo lojista
     */
    public List<SellerItem> getSellerItems(String offset, String limit) {

        setResource("/sellerItems");

        // Parâmetros da requisição
        MultivaluedMap<String, String> queryParameters = new MultivaluedMapImpl();
        queryParameters.add("_offset", offset);
        queryParameters.add("_limit", limit);

        ClientResponse response = null;

        response = get(queryParameters);

        if (response.getStatus() != ClientResponse.Status.OK.ordinal()) {
            // Fazer tratamento de erro adequado.
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.toString());
        }

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

    /**
     * Método utilizado para realizar a chamada ao WebService Restful que faz a
     * associação do produto ao lojista.
     * <p/>
     * POST /sellerItems
     *
     * @param bodyParams Mapa contendo os parâmetros que precisam ser passados no body
     *                   da requisição. Exemplo de conteúdo do mapa:
     *                   <p/>
     *                   { "skuOrigin": "string", "skuId": "string", "defaultPrice":
     *                   "500.00", "salePrice": "460.00", "availableQuantity": "100",
     *                   "installmentId": "20p3x", "totalQuantity": "250",
     *                   "crossDockingTime": 1 }
     * @return Retorno da requisição, composto do status e o location da
     *         associação do produto ao lojista.
     */
    public String postSellerItem(Map<String, Object> bodyParams) {

        ClientResponse response = null;


        setResource("/sellerItems");

        response = null;

        try {
            response = post(bodyParams);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Error while trying to execute POST method on resource: "
                            + super.getURL());
        }

        if (response.getStatus() != ClientResponse.Status.CREATED.ordinal()) {
            // Fazer tratamento de erro adequado.
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.toString());
        }

        return response.getEntity(String.class);

    }

    /**
     * Método utilizado para realizar a chamada ao WebService Restful que
     * atualiza a quantidade disponível para venda de um item do Lojista.
     *
     * PUT /sellerItems/{skuId}/stock
     *
     * @param skuId
     *            ID do produto a venda
     * @param availableQuantity
     *            Quantidade disponível
     * @param totalQuantity
     *            Quantidade total de produtos
     * @return Status da operação.
     */
    public String uptadeStock(String skuId, String availableQuantity,
                              String totalQuantity) {

        setResource("/sellerItems/" + skuId + "/stock");

        ClientResponse response = null;

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("availableQuantity", availableQuantity);
        data.put("totalQuantity", totalQuantity);

        try {
            response = put(data);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Error while trying to execute PUT method on resource: "
                            + super.getURL());
        }

        if (response.getStatus() != ClientResponse.Status.NO_CONTENT.ordinal()) {
            // Fazer tratamento de erro adequado.
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.toString());
        }

        return response.getEntity(String.class);
    }

    public String uptadePrice(String skuId, String defaultPrice,
                              String salePrice, String installmentId) {
        // TODO Auto-generated method stub
        return null;
    }

}
