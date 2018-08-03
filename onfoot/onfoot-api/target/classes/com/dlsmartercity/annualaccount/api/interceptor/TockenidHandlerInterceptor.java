package com.dlsmartercity.annualaccount.api.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TockenidHandlerInterceptor extends HandlerInterceptorAdapter {
	
	/*@Autowired
	private ISysUserService sysUserService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String tokenid = WebUtils.findParameterValue(request, AppContants.BASE_REQUEST_PARAM_KEY_TOKENID);
		if(!StringUtils.isEmpty(tokenid)) {
			String appkey = WebUtils.findParameterValue(request, AppContants.BASE_REQUEST_PARAM_KEY_APPKEY);
			if(StringUtils.isEmpty(appkey)) {
				BaseResponse appResponse = new BaseResponse();
				appResponse.setRetcode(RetMessageKey.RESPONSE_CODE_APPKEY_MISSING);
				appResponse.setRetmessage(MessageSourceHolder.getMessage(RetMessageKey.RESPONSE_CODE_APPKEY_MISSING));
				appResponse.setTokenid(tokenid);
				response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
				response.getWriter().write(JsonUtils.serialize(appResponse));
				response.getWriter().flush();
				return false;
			}
			
			SysUser token = sysUserService.getSysUserByUserToken(tokenid);
			if(token == null) {
				BaseResponse appResponse = new BaseResponse();
				appResponse.setRetcode(RetMessageKey.RESPONSE_CODE_TOCKENID_INVALID);
				appResponse.setRetmessage(MessageSourceHolder.getMessage(RetMessageKey.RESPONSE_CODE_TOCKENID_INVALID));
				appResponse.setTokenid(tokenid);
				response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
				response.getWriter().write(JsonUtils.serialize(appResponse));
				response.getWriter().flush();
				return false;
			}
		}
		return true;
	}*/

}
