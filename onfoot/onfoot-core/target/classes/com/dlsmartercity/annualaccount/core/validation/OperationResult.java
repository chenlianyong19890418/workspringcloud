package com.dlsmartercity.annualaccount.core.validation;

import java.io.Serializable;

import com.dlsmartercity.annualaccount.core.helper.MessageSourceHolder;

public class OperationResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean success;
	
	private String code;
	
	private Object[] args;
	
	private String message;
	
	private T target;
	
	public OperationResult(T target, boolean success, String code, Object... args) {
		this.target = target;
		this.success = success;
		this.code = code;
		this.args = args;
		this.message = MessageSourceHolder.getMessage(code, args);
	}

	public boolean isSuccess() {
		return success;
	}

	public String getCode() {
		return code;
	}

	public Object[] getArgs() {
		return args;
	}

	public String getMessage() {
		return message;
	}

	public T getTarget() {
		return target;
	}

}
