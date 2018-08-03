package com.dlsmartercity.annualaccount.api.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.dlsmartercity.annualaccount.api.response.BaseResponse;
import com.dlsmartercity.annualaccount.common.contants.RetMessageKey;
import com.dlsmartercity.annualaccount.core.helper.MessageSourceHolder;
import com.dlsmartercity.annualaccount.util.Constants;
import com.dlsmartercity.annualaccount.util.JsonUtils;
import com.dlsmartercity.annualaccount.util.StringUtils;

public class OpenidHandlerInterceptor extends HandlerInterceptorAdapter {
	
	@Value("${com.dlsmartercity.annualaccount.api.urls.config.yearUrl}")
	private String yearUrl;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uid = WebUtils.findParameterValue(request, "uid");
		if (StringUtils.isEmpty(uid)) {
			BaseResponse appResponse = new BaseResponse();
			appResponse.setRetcode(RetMessageKey.RESPONSE_CODE_PARAMS_MISSING);
			appResponse.setRetmessage(MessageSourceHolder.getMessage(RetMessageKey.RESPONSE_CODE_PARAMS_MISSING));
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			response.getWriter().write(JsonUtils.serialize(appResponse));
			response.getWriter().flush();
			return false;
		}
		
		String openid = (String) request.getSession().getAttribute("openid");
		String urlRedirect = yearUrl+"?uid=" + uid;
		String newUrlRedirect = URLEncoder.encode(urlRedirect, "UTF-8");
		if(StringUtils.isEmpty(openid)) {
//			// 获取请求转发器对象，该转发器的指向通过getRequestDisPatcher()的参数设置
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("http://localhost:8080/annualaccount-api/annual/getRequestCodeUrl/2017?requestURL=" + requestURL);
//			// 调用forward()方法，转发请求
//			request.setAttribute("requestURL", requestURL+"?"+queryString);
//			requestDispatcher.forward(request, response);
//			String appid = "wxb3ef5aefb9f5fff2";
//			String secret = "a05f09bf0c5b10ff2ad5f1d4d3033cfa";
			 String appid = Constants.WE_CHAT_APPID;
			 String secret = Constants.WE_CHAT_APPSECRET;
			System.out.println("==========" + response.isCommitted());
			response.sendRedirect("http://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri="+newUrlRedirect+"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");
			System.out.println("==========" + response.isCommitted());
			return false;
		}
		return true;
	}

}
