package com.dlsmartercity.annualaccount.core.controller;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public abstract class BaseController implements ServletContextAware {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ServletContext servletContext;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	protected Logger getLogger() {
		return logger;
	}

	protected Object getRequestAttribute(String name) {
		return RequestContextHolder.getRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_REQUEST);
	}
	
	protected void setRequestAttribute(String name, Object value) {
		RequestContextHolder.getRequestAttributes().setAttribute(name, value, RequestAttributes.SCOPE_REQUEST);
	}
	
	protected void removeRequestAttribute(String name) {
		RequestContextHolder.getRequestAttributes().removeAttribute(name, RequestAttributes.SCOPE_REQUEST);
	}
	
	protected Object getSessionAttribute(String name) {
		return RequestContextHolder.getRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_SESSION);
	}
	
	protected void setSessionAttribute(String name, Object value) {
		RequestContextHolder.getRequestAttributes().setAttribute(name, value, RequestAttributes.SCOPE_SESSION);
	}
	
	protected void removeSessionAttribute(String name) {
		RequestContextHolder.getRequestAttributes().removeAttribute(name, RequestAttributes.SCOPE_SESSION);
	}
	
	protected Object getApplicationAttribute(String name) {
		return this.servletContext.getAttribute(name);
	}
	
	protected void setApplicationAttribute(String name, Object value) {
		this.servletContext.setAttribute(name, value);
	}
	
	protected void removeApplicationAttribute(String name) {
		this.servletContext.removeAttribute(name);
	}

}
