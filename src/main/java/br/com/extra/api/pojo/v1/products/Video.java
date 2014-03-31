package br.com.extra.api.pojo.v1.products;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Video implements Serializable {

	private static final long serialVersionUID = 661136757901728374L;

	private String name;

	private String url;

	public Video() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
