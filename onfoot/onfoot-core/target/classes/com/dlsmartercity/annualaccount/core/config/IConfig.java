package com.dlsmartercity.annualaccount.core.config;

public interface IConfig {
	
	String get(String key);
	
	String get(String key, String defaultValue);

}
