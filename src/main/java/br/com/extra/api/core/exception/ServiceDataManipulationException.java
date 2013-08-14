package br.com.extra.api.core.exception;

public class ServiceDataManipulationException extends ServiceException {

	private static final long serialVersionUID = 5092551410288525717L;

	public ServiceDataManipulationException(String message) {
		super(message);
	}

	public ServiceDataManipulationException(String message, Throwable e) {
		super(message, e);
	}

	public ServiceDataManipulationException(Throwable e) {
		super(e);
	}

}
