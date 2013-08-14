package br.com.extra.api.pojo.loads;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ProductLoadResponse implements Serializable {

	private static final long serialVersionUID = -5960181958189123517L;

	private String importerInfoId;
	private String skuOrigin;
	private String statusCode;
	private String status;
	private String creationDate;
	private String approvalDate;

	public ProductLoadResponse() {
		super();
	}

	public void setImporterInfoId(String importerInfoId) {
		this.importerInfoId = importerInfoId;
	}

	public String getImporterInfoId() {
		return importerInfoId;
	}

	public void setSkuOrigin(String skuOrigin) {
		this.skuOrigin = skuOrigin;
	}

	public String getSkuOrigin() {
		return skuOrigin;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getApprovalDate() {
		return approvalDate;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
