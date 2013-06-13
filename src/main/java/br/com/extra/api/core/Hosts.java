package br.com.extra.api.core;

public enum Hosts {

	SANDBOX("https://sabdbox.extra.com.br/api/v1"), 
	PRODUCAO("https://api.extra.com.br/api/v1"), 
	HLG("http://busapi.mp.hlg.dc.nova/api/v1");

	private String host;

	private Hosts(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return this.host;
	}

}
