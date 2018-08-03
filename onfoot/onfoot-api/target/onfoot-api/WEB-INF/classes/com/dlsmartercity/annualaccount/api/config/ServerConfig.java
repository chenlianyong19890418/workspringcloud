package com.dlsmartercity.annualaccount.api.config;

import com.dlsmartercity.annualaccount.core.config.IConfig;
import com.dlsmartercity.annualaccount.core.config.properties.PropertiesConfig;

public class ServerConfig extends PropertiesConfig implements IConfig {
	
	private static ServerConfig config = new ServerConfig();
	
	private ServerConfig() {
		super();
	}

	@Override
	protected String getConfigName() {
		return "serverConfig.properties";
	}
	
	public static ServerConfig getInstance() {
		return config;
	}
	
}
