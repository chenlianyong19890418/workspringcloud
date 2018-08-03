package com.dlsmartercity.annualaccount.core.context.httpmap;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class ParameterMap extends BaseHttpMap {

	private HttpServletRequest request;

	public ParameterMap(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public Enumeration<String> getNames() {
		return request.getParameterNames();
	}

	@Override
	public Object getValue(Object key) {
		return request.getParameter(String.valueOf(key));
	}

	public Object[] getValues(Object key) {
		return request.getParameterValues(String.valueOf(key));
	}

	@Override
	public void putValue(Object key, Object value) {
		throw new UnsupportedOperationException("Cannot put value to ParameterMap.");
	}

	@Override
	public void removeValue(Object key) {
		throw new UnsupportedOperationException("Cannot remove value from ParameterMap.");
	}

}
