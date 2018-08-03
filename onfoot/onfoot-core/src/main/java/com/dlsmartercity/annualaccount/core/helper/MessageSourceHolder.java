package com.dlsmartercity.annualaccount.core.helper;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class MessageSourceHolder implements MessageSourceAware {
	
	private static MessageSource msg;

	@Override
	public void setMessageSource(MessageSource messageSource) {
		msg = messageSource;
	}
	
	public static String getMessage(String code, Object... args) {
		return msg.getMessage(code, args, "", null);
	}
	
	public static String getMessage(String code, Object[] args, String defaultMessage) {
		return msg.getMessage(code, args, defaultMessage, null);
	}

	public static String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
		return msg.getMessage(code, args, defaultMessage, locale);
	}
	
}
