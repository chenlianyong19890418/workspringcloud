package com.dlsmartercity.annualaccount.core.context.httpmap;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionMap extends BaseHttpMap {

	private HttpSession session;

	public SessionMap(HttpServletRequest request) {
		this.session = request.getSession();
	}

	@Override
	protected Enumeration<String> getNames() {
		return session.getAttributeNames();
	}

	@Override
	protected Object getValue(Object key) {
		return session.getAttribute(String.valueOf(key));
	}

	@Override
	protected void putValue(Object key, Object value) {
		session.setAttribute(String.valueOf(key), value);
	}

	@Override
	protected void removeValue(Object key) {
		session.removeAttribute(String.valueOf(key));
	}

}
