package com.dlsmartercity.annualaccount.core.context.request;

import javax.servlet.http.HttpServletRequest;

public class RequestInfo implements IRequestInfo {
	
	private HttpServletRequest request;
	
	public RequestInfo(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public String getCharacterEncoding() {
		return this.request.getCharacterEncoding();
	}

	@Override
	public String getContentType() {
		return this.request.getContentType();
	}

	@Override
	public String getLocalAddr() {
		return this.request.getLocalAddr();
	}

	@Override
	public String getLocalName() {
		return this.request.getLocalName();
	}

	@Override
	public int getLocalPort() {
		return this.request.getLocalPort();
	}

	@Override
	public String getMethod() {
		return this.request.getMethod();
	}

	@Override
	public String getPathInfo() {
		return this.request.getPathInfo();
	}

	@Override
	public String getProtocol() {
		return this.request.getProtocol();
	}

	@Override
	public String getQueryString() {
		return this.request.getQueryString();
	}

	@Override
	public String getRemoteAddr() {
		return this.request.getRemoteAddr();
	}

	@Override
	public String getRemoteHost() {
		return this.request.getRemoteHost();
	}

	@Override
	public int getRemotePort() {
		return this.request.getRemotePort();
	}

	@Override
	public String getRequestURI() {
		return this.request.getRequestURI();
	}

	@Override
	public String getScheme() {
		return this.request.getScheme();
	}

	@Override
	public String getServerName() {
		return this.request.getServerName();
	}

	@Override
	public int getServerPort() {
		return this.request.getServerPort();
	}

	@Override
	public String getServletPath() {
		return this.request.getServletPath();
	}

	@Override
	public String getRequestURL() {
		return this.request.getRequestURL().toString();
	}

}
