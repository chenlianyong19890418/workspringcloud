package com.dlsmartercity.annualaccount.api.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dlsmartercity.annualaccount.util.DateUtils;

public class PerformLogInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PerformLogInterceptor.class);
	
	private ThreadLocal<Long> startTimeMillis = new ThreadLocal<>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		startTimeMillis.set(startTime);

		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		if(!"/".equals(contextPath)) {
			requestURI = requestURI.replaceFirst(contextPath, "");
		}
		
		LOGGER.info("Processing request {} starttime {}", requestURI, DateUtils.convertDate2String(new Date(startTime), "yyyy-MM-dd HH:mm:ss"));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		long currTime = System.currentTimeMillis();
		long startTime = startTimeMillis.get();
		
		long duration = currTime - startTime;
		
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		if(!"/".equals(contextPath)) {
			requestURI = requestURI.replaceFirst(contextPath, "");
		}
		
		LOGGER.info("Process request {} finished, duration {} millis", requestURI, duration);
	}

}
