package com.mcnc.usermanagement.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8099609598298091957L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
