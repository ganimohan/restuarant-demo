package com.example.restuarant.exception;

/**
 * Invalid data source exception.
 * 
 * @author ganesh
 *
 */
public class DataNotFoundException extends Exception {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -4137739673000366906L;

	public DataNotFoundException() {

	}

	public DataNotFoundException(String message) {
		super(message);
	}

	public DataNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
