package com.dlsmartercity.annualaccount.core.context.request;

public interface IRequestInfo {
	
	String getCharacterEncoding();
	
	String getContentType();
	
	String getLocalAddr();
	
	String getLocalName();
	
	int getLocalPort();
	
	String getMethod();
	
	String getPathInfo();
	
	String getProtocol();
	
	String getQueryString();
	
	String getRemoteAddr();
	
	String getRemoteHost();
	
	int getRemotePort();
	
	String getRequestURI();
	
	String getScheme();
	
	String getServerName();
	
	int getServerPort();
	
	String getServletPath();
	
	String getRequestURL();

}
