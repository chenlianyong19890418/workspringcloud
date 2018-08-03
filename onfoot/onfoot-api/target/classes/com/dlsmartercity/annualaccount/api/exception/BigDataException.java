package com.dlsmartercity.annualaccount.api.exception;

public class BigDataException extends Exception {

	private static final long serialVersionUID = -5257092802560117403L;

	public BigDataException() {
		super();
	}

	public BigDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BigDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public BigDataException(String message) {
		super(message);
	}

	public BigDataException(Throwable cause) {
		super(cause);
	}
}
