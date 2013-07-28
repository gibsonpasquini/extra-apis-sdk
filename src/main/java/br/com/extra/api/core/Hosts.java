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
	PRODUCAO("https://api.extra.com.br/api/v1"),
	/**
	 * Host do serviço em Homologação.
	 */
	HLG("http://busapi.mp.hlg.dc.nova/api/v1"),
	/**
	 * Host do serviço em Homologação.
	 */
	SHLG("http://busapi.sandbox.mp.hlg.dc.nova/api/v1"),
	/**
	 * Host do serviço em Homologação.
	 */
	ATD("http://atd.mp.hlg.dc.nova/api-front-importer/jersey"),
	
	SAPIFR0NT("http://apifront.sandbox.extra.com.br/api-front-importer/jersey"),
	
	/**
	 * Host do serviço em Homologação.
	 */
	NIRVANA("http://nirvana.cit:8001/api-front-importer/jersey");;
	
	 

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
