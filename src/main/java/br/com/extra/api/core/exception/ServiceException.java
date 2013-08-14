package br.com.extra.api.core.exception;

/**
 * 
 * ExtraAPI-SDK - ServiceException.java
 * 
 * Exceção genérica lançada quando ocorrem erros na chamada às APIs.
 * 
 * @author Gibson Pasquini Nascimento
 * 
 *         09/08/2013
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 3027232279407255655L;

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable e) {
		super(message, e);
	}

}
