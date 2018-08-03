package com.dlsmartercity.annualaccount.core.exception.message;

import com.dlsmartercity.annualaccount.core.exception.PlatformException;
import com.dlsmartercity.annualaccount.core.helper.MessageSourceHolder;

public class RetMessageException extends PlatformException {
	
	private static final long serialVersionUID = 1L;

	private String code;
	
	private Object[] args;
	
	public RetMessageException(String code, Object... args) {
		super(MessageSourceHolder.getMessage(code, args));
		this.code = code;
		this.args = args;
	}
	
	public RetMessageException(Throwable cause, String code, Object... args) {
		super(MessageSourceHolder.getMessage(code, args), cause);
		this.code = code;
		this.args = args;
	}

	public String getCode() {
		return code;
	}

	public Object[] getArgs() {
		return args;
	}

}
