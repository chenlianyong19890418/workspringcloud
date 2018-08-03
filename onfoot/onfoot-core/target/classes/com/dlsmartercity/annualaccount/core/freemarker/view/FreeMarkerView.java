package com.dlsmartercity.annualaccount.core.freemarker.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import freemarker.ext.beans.BeansWrapper;

public class FreeMarkerView extends org.springframework.web.servlet.view.freemarker.FreeMarkerView {

	@Override
	protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
		BeansWrapper wrapper = (BeansWrapper) getObjectWrapper();
		model.put("statics", wrapper.getStaticModels());
		model.put("enums", wrapper.getEnumModels());
	}

}
