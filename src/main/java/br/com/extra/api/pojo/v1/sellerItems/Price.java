package br.com.extra.api.pojo.v1.sellerItems;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Price implements Serializable {

	private static final long serialVersionUID = 4516365876372643567L;

    private Double defaultPrice;

    private Double salePrice;

    private String installmentId;

    public Price() {
        super();
    }

    public void setDefaultPrice(Double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Double getDefaultPrice() {
        return defaultPrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setInstallmentId(String installmentId) {
        this.installmentId = installmentId;
    }

    public String getInstallmentId() {
        return installmentId;
    }
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
}