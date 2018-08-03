package com.dlsmartercity.annualaccount.util;

import java.text.MessageFormat;

public abstract class MessageFormatUtils {
	
	public static String format(String pattern, Object ... arguments) {
		return MessageFormat.format(pattern, arguments);
	}

}
