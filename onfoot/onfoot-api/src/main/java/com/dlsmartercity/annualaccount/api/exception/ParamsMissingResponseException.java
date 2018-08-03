package com.dlsmartercity.annualaccount.api.exception;

public class ParamsMissingResponseException extends Exception {
	private static final long serialVersionUID = -5257092802560117403L;

	public ParamsMissingResponseException() {
		super();
	}

	public ParamsMissingResponseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ParamsMissingResponseException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParamsMissingResponseException(String message) {
		super(message);
	}

	public ParamsMissingResponseException(Throwable cause) {
		super(cause);
	}
}
