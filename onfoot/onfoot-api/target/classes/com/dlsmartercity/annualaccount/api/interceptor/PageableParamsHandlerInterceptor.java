package com.dlsmartercity.annualaccount.api.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PageableParamsHandlerInterceptor extends HandlerInterceptorAdapter {

	/*@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String tokenid = WebUtils.findParameterValue(request, AppContants.BASE_REQUEST_PARAM_KEY_TOKENID);
		
		String rows = WebUtils.findParameterValue(request, AppContants.PAGEABLE_REQUEST_PARAM_KEY_ROWS);
		if(StringUtils.isEmpty(rows)) {
			BaseResponse appResponse = new BaseResponse();
			appResponse.setRetcode(RetMessageKey.RESPONSE_CODE_ROWS_MISSING);
			appResponse.setRetmessage(MessageSourceHolder.getMessage(RetMessageKey.RESPONSE_CODE_ROWS_MISSING));
			appResponse.setTokenid(tokenid);
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			response.getWriter().write(JsonUtils.serialize(appResponse));
			response.getWriter().flush();
			return false;
		}
		if(!StringUtils.isDigit(rows)) {
			BaseResponse appResponse = new BaseResponse();
			appResponse.setRetcode(RetMessageKey.RESPONSE_CODE_ROWS_INVALID);
			appResponse.setRetmessage(MessageSourceHolder.getMessage(RetMessageKey.RESPONSE_CODE_ROWS_INVALID));
			appResponse.setTokenid(tokenid);
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			response.getWriter().write(JsonUtils.serialize(appResponse));
			response.getWriter().flush();
			return false;
		}
		return true;
	}*/

}
