package br.com.extra.api.core;

/**
 * ExtraAPI-SDK - Hosts.java
 * 
 * Enum que possui os Hosts que podem ser chamados pela API.
 * 
 * @author Gibson Pasquini Nascimento
 * @author Fillipe Massuda
 * 
 *         21/06/2013
 */
public enum Hosts {

	/**
	 * Host do serviço em Ambiente de Sandbox.
	 */
	SANDBOX("https://sandbox.extra.com.br/api/v1"),
	/**
	 * Host do serviço em Ambiente de Produção.
	 */
	PRODUCAO("https://api.extra.com.br/api/v1");	 

	/**
	 * Endereço do host.
	 */
	private String host;

	/**
	 * Construtor que cria um Host.
	 * 
	 * @param host
	 *            Endereço do serviço
	 */
	private Hosts(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return this.host;
	}

}
