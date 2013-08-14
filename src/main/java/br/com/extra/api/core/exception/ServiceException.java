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

	private Integer errorCode;

	public ServiceException(Integer errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable e) {
		super(message, e);
	}

	public ServiceException(Throwable e) {
		super(e);
	}

	public Integer getErrorCode() {
		return errorCode;
	}

}
