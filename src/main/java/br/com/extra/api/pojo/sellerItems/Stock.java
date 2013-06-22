package br.com.extra.api.pojo.sellerItems;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Stock implements Serializable {

	private static final long serialVersionUID = -1814989374653525590L;

	private Integer availableQuantity;

    private Integer totalQuantity;

    public Stock() {
        super();
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
}
