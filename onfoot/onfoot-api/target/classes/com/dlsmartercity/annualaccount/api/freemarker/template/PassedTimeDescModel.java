package com.dlsmartercity.annualaccount.api.freemarker.template;

import java.util.Date;
import java.util.List;

import com.dlsmartercity.annualaccount.util.DateUtils;

import freemarker.template.SimpleDate;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class PassedTimeDescModel implements TemplateMethodModelEx {
	
	private static long SECONDS_OF_MINUTE = 60 * 1000;
	private static long MINUTES_OF_HOUR = 60 * SECONDS_OF_MINUTE;
	private static long HOURS_OF_DAY = 24 * MINUTES_OF_HOUR;

	@SuppressWarnings("rawtypes")
	@Override
	public Object exec(List arguments) throws TemplateModelException {
		if(arguments.size() != 1) {
			throw new TemplateModelException("Arguments size must be one");
		}
		if(!(arguments.get(0) instanceof SimpleDate)) {
			throw new TemplateModelException("Arguments must be type of SimpleDate");
		}
		Date reporttime = ((SimpleDate) arguments.get(0)).getAsDate();
		
		Date currtime = DateUtils.getDateTime();
		
		String result = "";
		if((currtime.getTime() - reporttime.getTime()) <= MINUTES_OF_HOUR) {
			result = ((currtime.getTime() - reporttime.getTime()) / SECONDS_OF_MINUTE) + "分钟前";
		} else if((currtime.getTime() - reporttime.getTime()) <= HOURS_OF_DAY) {
			result = ((currtime.getTime() - reporttime.getTime()) / MINUTES_OF_HOUR) + "小时前";
		} else {
			result = DateUtils.convertDate2String(reporttime, "MM-dd HH:mm");
		}
		return result;
	}

}
