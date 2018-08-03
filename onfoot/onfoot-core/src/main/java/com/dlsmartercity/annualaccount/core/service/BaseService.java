package com.dlsmartercity.annualaccount.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	protected Logger getLogger() {
		return logger;
	}

}
