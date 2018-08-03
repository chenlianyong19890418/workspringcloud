package com.dlsmartercity.annualaccount.api.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BaseParamsHandlerInterceptor extends HandlerInterceptorAdapter {

	/*@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String tokenid = WebUtils.findParameterValue(request, AppContants.BASE_REQUEST_PARAM_KEY_TOKENID);
		
		String apptype = WebUtils.findParameterValue(request, AppContants.BASE_REQUEST_PARAM_KEY_APPTYPE);
		if(StringUtils.isEmpty(apptype)) {
			BaseResponse appResponse = new BaseResponse();
			appResponse.setRetcode(RetMessageKey.RESPONSE_CODE_APPTYPE_MISSING);
			appResponse.setRetmessage(MessageSourceHolder.getMessage(RetMessageKey.RESPONSE_CODE_APPTYPE_MISSING));
			appResponse.setTokenid(tokenid);
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			response.getWriter().write(JsonUtils.serialize(appResponse));
			response.getWriter().flush();
			return false;
		}
		String appversion = WebUtils.findParameterValue(request, AppContants.BASE_REQUEST_PARAM_KEY_APPVERSION);
		if(StringUtils.isEmpty(appversion)) {
			BaseResponse appResponse = new BaseResponse();
			appResponse.setRetcode(RetMessageKey.RESPONSE_CODE_APPVERSION_MISSING);
			appResponse.setRetmessage(MessageSourceHolder.getMessage(RetMessageKey.RESPONSE_CODE_APPVERSION_MISSING));
			appResponse.setTokenid(tokenid);
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			response.getWriter().write(JsonUtils.serialize(appResponse));
			response.getWriter().flush();
			return false;
		}
		String channelid = WebUtils.findParameterValue(request, AppContants.BASE_REQUEST_PARAM_KEY_CHANNELID);
		if(StringUtils.isEmpty(channelid)) {
			BaseResponse appResponse = new BaseResponse();
			appResponse.setRetcode(RetMessageKey.RESPONSE_CODE_CHANNELID_MISSING);
			appResponse.setRetmessage(MessageSourceHolder.getMessage(RetMessageKey.RESPONSE_CODE_CHANNELID_MISSING));
			appResponse.setTokenid(tokenid);
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			response.getWriter().write(JsonUtils.serialize(appResponse));
			response.getWriter().flush();
			return false;
		}
		return true;
	}*/

}
