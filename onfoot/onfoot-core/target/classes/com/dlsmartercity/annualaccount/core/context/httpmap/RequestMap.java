package com.dlsmartercity.annualaccount.core.context.httpmap;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class RequestMap extends BaseHttpMap {

	private HttpServletRequest request;

	public RequestMap(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public Enumeration<String> getNames() {
		return request.getAttributeNames();
	}

	@Override
	public Object getValue(Object key) {
		return request.getAttribute(String.valueOf(key));
	}

	@Override
	public void putValue(Object key, Object value) {
		request.setAttribute(String.valueOf(key), value);
	}

	@Override
	public void removeValue(Object key) {
		request.removeAttribute(String.valueOf(key));
	}

}
