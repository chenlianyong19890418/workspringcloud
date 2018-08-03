package com.dlsmartercity.annualaccount.core.exception.db;

import com.dlsmartercity.annualaccount.core.exception.PlatformException;

public class DBOptException extends PlatformException {

	private static final long serialVersionUID = 1L;

	public DBOptException() {
		super();
	}

	public DBOptException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBOptException(String message) {
		super(message);
	}

	public DBOptException(Throwable cause) {
		super(cause);
	}

}
