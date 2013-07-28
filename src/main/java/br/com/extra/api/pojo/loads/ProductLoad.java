package br.com.extra.api.pojo.loads;

import java.io.File;

import br.com.extra.api.pojo.Pojos;

public class ProductLoad extends Pojos {

	private static final long serialVersionUID = 7745159119155280847L;

	private String productsJson;

	private File jsonFile;

	public File getJsonFile() {
		return jsonFile;
	}

	public void setJsonFile(File jsonFile) {
		this.jsonFile = jsonFile;
	}

	public String getProductsJson() {
		return productsJson;
	}

	public void setProductsJson(String productsJson) {
		this.productsJson = productsJson;
	}

}
