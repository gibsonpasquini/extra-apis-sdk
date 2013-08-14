package br.com.extra.api.core.exception;

public class ServiceInfrastructureException extends ServiceException {

	private static final long serialVersionUID = 5092551410288525717L;

	public ServiceInfrastructureException(Integer errorCode, String message) {
		super(errorCode, message);
	}

}
