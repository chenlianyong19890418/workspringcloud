package com.dlsmartercity.annualaccount.api.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.dlsmartercity.annualaccount.api.response.BaseResponse;

//@Aspect
public class TokenAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TokenAspect.class);
	
	@Value("${com.dlsmartercity.annualaccount.api.config.serverid}")
	private String serverId;
	
	//@Autowired
	//private ISysUserService sysUserService;
	
	@Around("execution(com.dlsmartercity.annualaccount.api.response.BaseResponse+ com.dlsmartercity.annualaccount.api.controller.*Controller.*(..,com.dlsmartercity.annualaccount.api.request.BaseRequest+,..))")
	public BaseResponse setTokenId(ProceedingJoinPoint joinPoint) throws Throwable {
		/*BaseRequest request = new BaseRequest();
		for(Object arg : joinPoint.getArgs()) {
			if(BaseRequest.class.isAssignableFrom(arg.getClass())) {
				request = (BaseRequest) arg;
				break;
			}
		}
		*/
		BaseResponse response = (BaseResponse) joinPoint.proceed();
		
		/*LOGGER.debug("TokenAspect.setTokenId....");
		if(StringUtils.isEmpty(response.getTokenid()) && !StringUtils.isEmpty(request.getTokenid())) {
			SysUser token = sysUserService.getSysUserByUserToken(request.getTokenid());
			if(token != null) {
				response.setTokenid(request.getTokenid());
			} else {
				response.setTokenid("");
			}
		}*/
		
		return response;
	}

}
