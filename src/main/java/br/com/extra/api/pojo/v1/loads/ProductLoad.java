package br.com.extra.api.pojo.v1.loads;

import java.io.File;

import br.com.extra.api.pojo.Pojos;

public class ProductLoad extends Pojos {

	private static final long serialVersionUID = 7745159119155280847L;

	/** String que contém o JSON para compactação. **/
	private String productsJson;

	/** Arquivo JSON sem compactação. **/
	private File jsonFile;

	/** Arquivo JSON compactado. **/
	private File gzFile;

	public File getGzFile() {
		return gzFile;
	}

	public File getJsonFile() {
		return jsonFile;
	}

	public String getProductsJson() {
		return productsJson;
	}

	public void setGzFile(File gzFile) {
		this.gzFile = gzFile;
	}

	public void setJsonFile(File jsonFile) {
		this.jsonFile = jsonFile;
	}

	public void setProductsJson(String productsJson) {
		this.productsJson = productsJson;
	}

}
