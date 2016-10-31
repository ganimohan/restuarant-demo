package com.example.restuarant.exception;

/**
 * Invalid data source exception.
 * 
 * @author ganesh
 *
 */
public class InvalidDatasourceException extends Exception {

	/**
	 * generated serial version id
	 */
	private static final long serialVersionUID = 918021413697173215L;

	public InvalidDatasourceException() {

	}

	public InvalidDatasourceException(String message) {
		super(message);
	}

	public InvalidDatasourceException(String message, Throwable cause) {
		super(message, cause);
	}

}
