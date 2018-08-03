package com.dlsmartercity.annualaccount.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class NumberUtils {

	public static final String DEFAULT_PATTERN = "0.00";

	public static final String ONE_DECIMAL_PATTERN = "0.0";

	public static final String EIGHT_DECIMAL_PATTERN = "0.00000000";

	public static String format(BigDecimal number) {
		return format(number, DEFAULT_PATTERN);
	}

	public static String format(BigDecimal number, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		if (number == null) {
			return df.format(BigDecimal.ZERO);
		}
		return df.format(number);
	}

	public static String format(Double number) {
		return format(number, DEFAULT_PATTERN);
	}

	public static String format(Double number, String pattern) {
		if (number == null) {
			return format(0.00, pattern);
		}
		return format(number.doubleValue(), pattern);
	}

	public static String format(double number) {
		return format(number, DEFAULT_PATTERN);
	}

	public static String format(double number, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(number);
	}
	
	public static String formatWithPositivePrefix(BigDecimal number) {
		return formatWithPositivePrefix(number, DEFAULT_PATTERN);
	}
	
	public static String formatWithPositivePrefix(BigDecimal number, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		df.setPositivePrefix("+");
		if (number == null) {
			return df.format(BigDecimal.ZERO);
		}
		return df.format(number);
	}
	
	public static String formatWithPositivePrefix(Double number) {
		return formatWithPositivePrefix(number, DEFAULT_PATTERN);
	}
	
	public static String formatWithPositivePrefix(Double number, String pattern) {
		if(number == null) {
			return formatWithPositivePrefix(0.00, pattern);
		}
		return formatWithPositivePrefix(number.doubleValue(), pattern);
	}
	
	public static String formatWithPositivePrefix(double number) {
		return formatWithPositivePrefix(number, DEFAULT_PATTERN);
	}
	
	public static String formatWithPositivePrefix(double number, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		df.setPositivePrefix("+");
		return df.format(number);
	}

}
