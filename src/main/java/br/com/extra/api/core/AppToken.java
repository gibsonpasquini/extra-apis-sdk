package br.com.extra.api.core;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * ExtraAPI-SDK - AppToken.java
 * 
 * Classe que representa um token de Aplicação.
 * 
 * @author Gibson Pasquini Nascimento
 * @author Fillipe Massuda
 * 
 *         21/06/2013
 */
public class AppToken {

	/**
	 * Token.
	 */
	private String code;

	/**
	 * Construtor que instancia um token de aplicação.
	 * 
	 * @param code
	 *            Token.
	 */
	public AppToken(String code) {
		this.code = code;
	}

	/**
	 * Método que recupera o token.
	 * 
	 * @return Token.
	 */
	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
