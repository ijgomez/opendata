package org.opendata.madrid.exceptions;

public class OpenDataServiceException extends Exception {

	private static final long serialVersionUID = 7595721071423234467L;

	public OpenDataServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
