package br.com.extra.api.pojo.v1.loads;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ProductLoadResponse implements Serializable {

	private static final long serialVersionUID = -5960181958189123517L;

	private String importerInfoId;
	private String skuOrigin;
	private String statusCode;
	private String status;
	private Date creationDate;
	private String approvalDate;
	private List<Problem> problems;

	public ProductLoadResponse() {
		super();
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public String getImporterInfoId() {
		return importerInfoId;
	}

	public List<Problem> getProblems() {
		return problems;
	}

	public String getSkuOrigin() {
		return skuOrigin;
	}

	public String getStatus() {
		return status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setImporterInfoId(String importerInfoId) {
		this.importerInfoId = importerInfoId;
	}

	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}

	public void setSkuOrigin(String skuOrigin) {
		this.skuOrigin = skuOrigin;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
