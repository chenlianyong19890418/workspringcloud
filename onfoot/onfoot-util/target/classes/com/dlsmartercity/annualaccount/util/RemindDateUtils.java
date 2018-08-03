package com.dlsmartercity.annualaccount.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public final class RemindDateUtils {

	private static final SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH");
	private static final SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 
	 * @Title: getCurrentWeekDayStartTime
	 * @Description: 获得本周的第一天，周一
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getCurrentWeekDayStartTime() {
		Calendar c = Calendar.getInstance();
		try {
			int weekday = c.get(Calendar.DAY_OF_WEEK) - 2;
			c.add(Calendar.DATE, -weekday);
			c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c.getTime();
	}

	/**
	 * 获得本周的第一天，周一
	 * 
	 * @return String
	 */
	public static String getCurrentWeekDayStartDate() {
		return shortSdf.format(getCurrentWeekDayStartTime());
	}

	/**
	 * 
	 * @Title: getCurrentWeekDayEndTime
	 * @Description: 获得本周的最后一天，周日
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getCurrentWeekDayEndTime() {
		Calendar c = Calendar.getInstance();
		try {
			int weekday = c.get(Calendar.DAY_OF_WEEK);
			c.add(Calendar.DATE, 8 - weekday);
			c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getCurrentDayStartTime
	 * @Description:获得本天的开始时间，即2012-01-01 00:00:00
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getCurrentDayStartTime() {
		Date now = new Date();
		try {
			now = shortSdf.parse(shortSdf.format(now));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 
	 * @Title: getCurrentDayEndTime
	 * @Description: 获得本天的结束时间，即2012-01-01 23:59:59
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getCurrentDayEndTime() {
		Date now = new Date();
		try {
			now = longSdf.parse(shortSdf.format(now) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 
	 * @Title: getCurrentHourStartTime
	 * @Description: 获得本小时的开始时间，即2012-01-01 23:59:59
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getCurrentHourStartTime() {
		Date now = new Date();
		try {
			now = longHourSdf.parse(longHourSdf.format(now));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 
	 * @Title: getCurrentHourEndTime
	 * @Description: 获得本小时的结束时间，即2012-01-01 23:59:59
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getCurrentHourEndTime() {
		Date now = new Date();
		try {
			now = longSdf.parse(longHourSdf.format(now) + ":59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 
	 * @Title: getCurrentMonthStartTime
	 * @Description: 获得本月的开始时间，即2012-01-01 00:00:00
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getCurrentMonthStartTime() {
		Calendar c = Calendar.getInstance();
		Date now = null;
		try {
			c.set(Calendar.DATE, 1);
			now = shortSdf.parse(shortSdf.format(c.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 
	 * @Title: getCurrentMonthStartDate
	 * @Description: 获得本月的开始时间，即2012-01-01 00:00:00
	 * @return 设定文件
	 * @return String 返回类型
	 */
	public static String getCurrentMonthStartDate() {
		return shortSdf.format(getCurrentMonthStartTime());
	}

	/**
	 * 
	 * @Title: getCurrentMonthEndTime
	 * @Description: 当前月的结束时间，即2012-01-31 23:59:59
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getCurrentMonthEndTime() {
		Calendar c = Calendar.getInstance();
		Date now = null;
		try {
			c.set(Calendar.DATE, 1);
			c.add(Calendar.MONTH, 1);
			c.add(Calendar.DATE, -1);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 
	 * @Title: getCurrentYearStartTime
	 * @Description: 当前年的开始时间，即2012-01-01 00:00:00
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getCurrentYearStartTime() {
		Calendar c = Calendar.getInstance();
		Date now = null;
		try {
			c.set(Calendar.MONTH, 0);
			c.set(Calendar.DATE, 1);
			now = shortSdf.parse(shortSdf.format(c.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 
	 * @Title: getCurrentYearStartDate
	 * @Description: 当前年的开始时间，即2012-01-01 00:00:00
	 * @return 设定文件
	 * @return String 返回类型
	 */
	public String getCurrentYearStartDate() {
		return shortSdf.format(getCurrentYearStartTime());
	}

	/**
	 * 
	 * @Title: getCurrentYearEndTime
	 * @Description: 当前年的结束时间，即2012-12-31 23:59:59
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getCurrentYearEndTime() {
		Calendar c = Calendar.getInstance();
		Date now = null;
		try {
			c.set(Calendar.MONTH, 11);
			c.set(Calendar.DATE, 31);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 
	 * @Title: getCurrentQuarterStartTime
	 * @Description: 当前季度的开始时间，即2012-01-1 00:00:00
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getCurrentQuarterStartTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3)
				c.set(Calendar.MONTH, 0);
			else if (currentMonth >= 4 && currentMonth <= 6)
				c.set(Calendar.MONTH, 3);
			else if (currentMonth >= 7 && currentMonth <= 9)
				c.set(Calendar.MONTH, 4);
			else if (currentMonth >= 10 && currentMonth <= 12)
				c.set(Calendar.MONTH, 9);
			c.set(Calendar.DATE, 1);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 
	 * @Title: getCurrentQuarterStartDate
	 * @Description: 当前季度的开始时间，即2012-01-1 00:00:00
	 * @return 设定文件
	 * @return String 返回类型
	 */
	public static String getCurrentQuarterStartDate() {
		return shortSdf.format(getCurrentQuarterStartTime());
	}

	/**
	 * 
	 * @Title: getCurrentQuarterEndTime
	 * @Description: 当前季度的结束时间，即2012-03-31 23:59:59
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getCurrentQuarterEndTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3) {
				c.set(Calendar.MONTH, 2);
				c.set(Calendar.DATE, 31);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 5);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				c.set(Calendar.MONTH, 8);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 11);
				c.set(Calendar.DATE, 31);
			}
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 
	 * @Title: getHalfYearStartTime
	 * @Description: 获取前/后半年的开始时间
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getHalfYearStartTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 0);
			} else if (currentMonth >= 7 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 6);
			}
			c.set(Calendar.DATE, 1);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;

	}

	/**
	 * 
	 * @Title: getHalfYearEndTime
	 * @Description: 获取前/后半年的结束时间
	 * @return 设定文件
	 * @return Date 返回类型
	 */
	public static Date getHalfYearEndTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 5);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 11);
				c.set(Calendar.DATE, 31);
			}
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 
	 * @Title: getCurrentWeek
	 * @Description: 计算当前周
	 * @return 设定文件
	 * @return int 返回类型
	 */
	public static int getCurrentWeek(String date) {
		Date time = DateUtils.convertString2Date(date, "yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		int week = cal.get(cal.WEEK_OF_YEAR);
		return week;
	}

	/**
	 * 
	 * @Title: getCurrentMonth
	 * @Description: 获取当前月份
	 * @return 设定文件
	 * @return int 返回类型
	 */
	public static int getCurrentMonth(String date) {
		Date time = DateUtils.convertString2Date(date, "yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		// 获得当前时间的月份，月份从0开始所以结果要加1
		int month = calendar.get(Calendar.MONTH) + 1;
		return month;
	}

	/**
	 * 
	 * @Title: getCurrentYear
	 * @Description: 获取当前月份
	 * @return 设定文件
	 * @return int 返回类型
	 */
	public static int getCurrentYear(String date) {
		Date time = DateUtils.convertString2Date(date, "yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		// 获得当前时间的月份，月份从0开始所以结果要加1
		int year = calendar.get(Calendar.YEAR);
		return year;
	}

	/**
	 * 
	 * @Title: getCurrentQuarter
	 * @Description: 计算当前季度
	 * @return 设定文件
	 * @return int 返回类型
	 */
	public static int getCurrentQuarter(String date) {
		Date time = DateUtils.convertString2Date(date, "yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(time);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		try {
			if (currentMonth >= 1 && currentMonth <= 3)
				return 1;
			else if (currentMonth >= 4 && currentMonth <= 6)
				return 2;
			else if (currentMonth >= 7 && currentMonth <= 9)
				return 3;
			else if (currentMonth >= 10 && currentMonth <= 12)
				return 4;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @Title: getNextDay
	 * @Description: 当前时间前一天
	 * @return 设定文件
	 * @return String 返回类型
	 */
	public static String getNextDay(String date) {
		if (StringUtils.isNotBlank(date)) {
			Calendar calendar = Calendar.getInstance();
			Date time = DateUtils.convertString2Date(date, "yyyy-MM-dd");
			calendar.setTime(time);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			Date calendarDate = calendar.getTime();
			return longHourSdf.format(calendarDate);
		}
		return null;

	}

	/**
	 * 获取两个日期之间的日期
	 * 
	 * @param start
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @return 日期集合
	 */
	public static List<String> getBetweenDates() {
		List<String> result = new ArrayList<String>();
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(DateUtils.convertString2Date(BigDataUtils.get("com.dlsmartercity.annualaccount.api.config.starttime"), "yyy-MM-dd"));
		tempStart.add(Calendar.DAY_OF_YEAR, 1);

		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(DateUtils.convertString2Date(BigDataUtils.get("com.dlsmartercity.annualaccount.api.config.endtime"), "yyy-MM-dd"));
		while (tempStart.before(tempEnd)) {
			result.add(DateUtils.convertDate2String(tempStart.getTime(), "yyyy-MM-dd"));
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
		}
		return result;
	}

	public static void main(String[] args) {
		RemindDateUtils data = new RemindDateUtils();
		List<String> list = getBetweenDates();
		/*
		 * System.out.println("=========周" + data.getCurrentWeekDayStartDate()); System.out.println("=========月" + data.getCurrentMonthStartDate());
		 * System.out.println("=========季" + data.getCurrentQuarterStartDate()); System.out.println("=========年" + data.getCurrentYearStartDate());
		 * System.out.println("=========第几周：" + data.getCurrentWeek("2017-11-08")); System.out.println("=========第几个月：" + data.getCurrentMonth("2017-11-08"));
		 * System.out.println("=========第几个季度：" + data.getCurrentQuarter("2017-11-08")); System.out.println("==========第几年：" +
		 * data.getCurrentYear("2017-11-08")); System.out.println("==========当前时间前一天：" + data.getNextDay("2017-11-08"));
		 */
	}
}
