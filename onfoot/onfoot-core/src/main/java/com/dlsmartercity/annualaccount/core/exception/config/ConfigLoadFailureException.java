package com.dlsmartercity.annualaccount.core.exception.config;

import com.dlsmartercity.annualaccount.core.exception.PlatformException;

public class ConfigLoadFailureException extends PlatformException {

	private static final long serialVersionUID = 1L;

	public ConfigLoadFailureException() {
		super();
	}

	public ConfigLoadFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConfigLoadFailureException(String message) {
		super(message);
	}

	public ConfigLoadFailureException(Throwable cause) {
		super(cause);
	}

}
