package br.com.extra.api.core;

public enum Hosts {

	SANDBOX("sabdbox.extra.com.br"), PRODUCAO("api.extra.com.br");

	private String host;

	private Hosts(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return this.host;
	}

}
