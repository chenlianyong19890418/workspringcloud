package com.dlsmartercity.annualaccount.core.config.properties;

import java.io.IOException;
import java.util.Properties;

import com.dlsmartercity.annualaccount.core.config.IConfig;
import com.dlsmartercity.annualaccount.core.exception.config.ConfigLoadFailureException;

public abstract class PropertiesConfig implements IConfig {
	
	protected Properties props = new Properties();
	
	protected PropertiesConfig() {
		try {
			props.load(this.getClass().getClassLoader().getResourceAsStream(getConfigName()));
		} catch (IOException e) {
			throw new ConfigLoadFailureException(e);
		}
	}
	
	@Override
	public String get(String key) {
		return this.get(key, "");
	}

	@Override
	public String get(String key, String defaultValue) {
		return this.props.getProperty(key, defaultValue);
	}
	
	protected abstract String getConfigName();

}
