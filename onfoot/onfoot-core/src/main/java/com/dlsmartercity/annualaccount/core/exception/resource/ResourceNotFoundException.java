package com.dlsmartercity.annualaccount.core.exception.resource;

import com.dlsmartercity.annualaccount.core.exception.PlatformException;

public class ResourceNotFoundException extends PlatformException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}

}
