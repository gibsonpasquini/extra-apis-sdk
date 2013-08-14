package br.com.extra.api.pojo.loads;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoadResponse implements Serializable {

	private static final long serialVersionUID = -7396238930281832837L;

	private BigDecimal importerInfoId;

	private String status;

	private String creationDate;

	private String executionDate;

	public LoadResponse() {
	}

	public BigDecimal getImporterInfoId() {
		return importerInfoId;
	}

	public void setImporterInfoId(BigDecimal importerInfoId) {
		this.importerInfoId = importerInfoId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this);
	}
}
