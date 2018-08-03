package com.dlsmartercity.annualaccount.core.context.httpmap;

import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieMap extends BaseHttpMap {

	private Cookie[] cookies;

	public CookieMap(HttpServletRequest request) {
		cookies = request.getCookies();
	}

	public Enumeration<Object> getNames() {
		return new CookieEnumerator(cookies);
	}

	public Object getValue(Object key) {
		for (int i = 0; i < cookies.length; i++) {
			if (key.equals(cookies[i].getName())) {
				return cookies[i].getValue();
			}
		}
		return null;
	}

	public void putValue(Object key, Object value) {
		throw new UnsupportedOperationException();
	}

	public void removeValue(Object key) {
		throw new UnsupportedOperationException();
	}

	private class CookieEnumerator implements Enumeration<Object> {

		private int i = 0;

		private Cookie[] cookieArray;

		public CookieEnumerator(Cookie[] cookies) {
			this.cookieArray = cookies;
		}

		public synchronized boolean hasMoreElements() {
			return cookieArray.length > i;
		}

		public synchronized Object nextElement() {
			Object element = cookieArray[i];
			i++;
			return element;
		}

	}

}
