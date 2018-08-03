package com.dlsmartercity.annualaccount.core.exception.message;

public class ValidationWithDataException extends RetMessageException {

	private static final long serialVersionUID = 1L;

	private Object data;
	
	public ValidationWithDataException(String code,Object data, Object... args) {
		super(code, args);
		this.data = data;
	}

	public ValidationWithDataException(Throwable cause, String code,Object data, Object... args) {
		super(cause, code, args);
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
