package com.dlsmartercity.annualaccount.core.exception.message;

public class ValidationException extends RetMessageException {

	private static final long serialVersionUID = 1L;

	public ValidationException(String code, Object... args) {
		super(code, args);
	}

	public ValidationException(Throwable cause, String code, Object... args) {
		super(cause, code, args);
	}

}
