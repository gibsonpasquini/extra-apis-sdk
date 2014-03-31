package br.com.extra.api.pojo.v1.loads;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Problem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7261225947701200222L;

	private String fieldName;
	private String message;
	private String type;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
