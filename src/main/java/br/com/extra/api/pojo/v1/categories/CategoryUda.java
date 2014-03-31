package br.com.extra.api.pojo.v1.categories;

import java.io.Serializable;

public class CategoryUda implements Serializable {

	private static final long serialVersionUID = 8041180012777290798L;

	private Integer udaId;
	private String udaName;
	private Boolean variant;

	public Integer getUdaId() {
		return udaId;
	}

	public String getUdaName() {
		return udaName;
	}

	public Boolean getVariant() {
		return variant;
	}

	public void setUdaId(Integer udaId) {
		this.udaId = udaId;
	}

	public void setUdaName(String udaName) {
		this.udaName = udaName;
	}

	public void setVariant(Boolean variant) {
		this.variant = variant;
	}

}
