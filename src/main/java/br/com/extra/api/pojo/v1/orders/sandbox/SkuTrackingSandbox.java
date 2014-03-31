package br.com.extra.api.pojo.v1.orders.sandbox;

import java.io.Serializable;

public class SkuTrackingSandbox implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String skuId;
    private String skuName;
    
    public SkuTrackingSandbox() { }

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

 }
