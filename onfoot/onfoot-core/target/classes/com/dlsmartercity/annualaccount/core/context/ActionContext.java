package com.dlsmartercity.annualaccount.core.context;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlsmartercity.annualaccount.core.context.httpmap.ApplicationMap;
import com.dlsmartercity.annualaccount.core.context.httpmap.CookieMap;
import com.dlsmartercity.annualaccount.core.context.httpmap.ParameterMap;
import com.dlsmartercity.annualaccount.core.context.httpmap.RequestMap;
import com.dlsmartercity.annualaccount.core.context.httpmap.SessionMap;
import com.dlsmartercity.annualaccount.core.context.request.IRequestInfo;
import com.dlsmartercity.annualaccount.core.context.request.RequestInfo;

public class ActionContext {

	private static final ThreadLocal<ActionContext> localContext = new ThreadLocal<>();
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<Object, Object> cookieMap;
	private Map<Object, Object> parameterMap;
	private Map<Object, Object> requestMap;
	private Map<Object, Object> sessionMap;
	private Map<Object, Object> applicationMap;
	private IRequestInfo requestInfo;

	private ActionContext() {
	}

	protected static void initialize(HttpServletRequest request, HttpServletResponse response) {
		ActionContext ctx = getActionContext();
		ctx.request = request;
		ctx.response = response;
		ctx.cookieMap = null;
		ctx.parameterMap = null;
		ctx.requestMap = null;
		ctx.sessionMap = null;
		ctx.applicationMap = null;
		ctx.requestInfo = null;
	}

	public Map<Object, Object> getCookieMap() {
		if (cookieMap == null) {
			cookieMap = new CookieMap(request);
		}
		return cookieMap;
	}

	public Map<Object, Object> getParameterMap() {
		if (parameterMap == null) {
			parameterMap = new ParameterMap(request);
		}
		return parameterMap;
	}

	public Map<Object, Object> getRequestMap() {
		if (requestMap == null) {
			requestMap = new RequestMap(request);
		}
		return requestMap;
	}

	public Map<Object, Object> getSessionMap() {
		if (sessionMap == null) {
			sessionMap = new SessionMap(request);
		}
		return sessionMap;
	}

	public Map<Object, Object> getApplicationMap() {
		if (applicationMap == null) {
			applicationMap = new ApplicationMap(request);
		}
		return applicationMap;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}
	
	public IRequestInfo getRequestInfo() {
		if(requestInfo == null) {
			requestInfo = new RequestInfo(request);
		}
		return requestInfo;
	}

	public static ActionContext getActionContext() {
		ActionContext ctx = localContext.get();
		if (ctx == null) {
			ctx = new ActionContext();
			localContext.set(ctx);
		}
		return ctx;
	}
}
