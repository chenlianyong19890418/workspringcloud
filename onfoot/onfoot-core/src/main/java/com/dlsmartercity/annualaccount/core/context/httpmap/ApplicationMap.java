package com.dlsmartercity.annualaccount.core.context.httpmap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class ApplicationMap extends BaseHttpMap {

	private ServletContext context;

	public ApplicationMap(HttpServletRequest request) {
		context = request.getSession().getServletContext();
	}

	public Enumeration<String> getNames() {
		return context.getAttributeNames();
	}

	public Object getValue(Object key) {
		return context.getAttribute(String.valueOf(key));
	}

	public void putValue(Object key, Object value) {
		context.setAttribute(String.valueOf(key), value);
	}

	public void removeValue(Object key) {
		context.removeAttribute(String.valueOf(key));
	}

}
