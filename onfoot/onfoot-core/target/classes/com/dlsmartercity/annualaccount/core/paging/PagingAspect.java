package com.dlsmartercity.annualaccount.core.paging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dlsmartercity.annualaccount.core.dto.BaseDto;
import com.github.pagehelper.PageHelper;

public class PagingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PagingAspect.class);
	
	public Object paging(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.debug("paging aspect method{} args{}", joinPoint.getSignature().getName(), joinPoint.getArgs());
		for(Object arg : joinPoint.getArgs()) {
			if(BaseDto.class.isAssignableFrom(arg.getClass())) {
				BaseDto baseDto = (BaseDto) arg;
				PageHelper.startPage(baseDto.getPageIndex(), baseDto.getPageSize());
				if(baseDto.getOrderBy() != null && !baseDto.getOrderBy().trim().equals("")) {
					PageHelper.orderBy(baseDto.getOrderBy());
				}
				break;
			}
		}
		return joinPoint.proceed();
	}

}
