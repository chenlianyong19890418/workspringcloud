package com.dlsmartercity.annualaccount.util;

/**
 * 系统常量Class
 * @author shaoru.ning
 *
 */
public class AnnualaccountConstant {
	
	/**
	 * push消息是否关闭
	 * 1：关闭
	 * 2：未关闭
	 * @author ujhan
	 *
	 */
	public static enum USER_PUSHCLOSE{
		 
		GB("1","关闭"),
		WGB("2","未关闭");
		public String key;
		public String value;
		private USER_PUSHCLOSE(String key, String value){
			this.key = key;
			this.value = value;
		}
		public static String get(String key) {
			USER_PUSHCLOSE[] values = USER_PUSHCLOSE.values();
			for (USER_PUSHCLOSE object : values) {
				if (object.key.equals(key)) {
					return object.value;
				}
			}
			return null;
		}
	}
	
	public static enum MESSAGE_FORM_TYPE{
		NONE("", ""),
		ACTIVITY("0","活动奖励"),
		GRHSRW("1","个人核实任务"),
		DZHSRW("2","大众核实任务"),
		DZSC("3","大众上传"),
		XCRW("4","巡查任务"),
		EWEWHDJL("5","额外额外活动奖励"),
		HDZTJL("6","活动专题发放奖励"),
		NZJLANDZCJL("7","年终奖励和新用户注册奖励");
		public String key;
		public String value;
		private MESSAGE_FORM_TYPE(String key, String value){
			this.key = key;
			this.value = value;
		}
		public static String get(String key) {
			MESSAGE_FORM_TYPE[] values = MESSAGE_FORM_TYPE.values();
			for (MESSAGE_FORM_TYPE object : values) {
				if (object.key.equals(key)) {
					return object.value;
				}
			}
			return null;
		}
	}
	
	/**
	 * 手机类型常量
	 * 0:Android
	 * 1:iOS
	 * @author shaoru.ning
	 *
	 */
	public static enum MOBILE_TYPE{
		ANDROID("0","Android"),
		IOS("1","iOS");
		public String key;
		public String value;
		private MOBILE_TYPE(String key, String value){
			this.key = key;
			this.value = value;
		}
		public static String get(String key) {
			MOBILE_TYPE[] values = MOBILE_TYPE.values();
			for (MOBILE_TYPE object : values) {
				if (object.key.equals(key)) {
					return object.value;
				}
			}
			return null;
		}
	}
	
	/**
	 * 消息类型常量
	 * 0:奖励消息
	 * 1:事件状态变更
	 * 2:提现驳回
	 * @author shaoru.ning
	 *
	 */
	public static enum MESSAGE_TYPE{
		JLXX("0","奖励消息"),
		SJZTBG("1","事件状态变更"),
		XSRWHB("2","新手任务奖励"),
		TXBH("3","提现驳回"),
		GRFHRWZTBG("4","个人核实任务状态变更"),
		DZFHRWZTBG("5","大众核实任务状态变更"),
		XCRWZTBG("6","巡查任务状态变更"),
		HDJLXX("9","活动专题奖励消息"),
		EWJL("10","活动额外奖励"),
		EWEWFJL("11","额外额外奖励"),
		LYHSBZX("12","老用户双倍酬谢"),
		XYHSDJL("13","新用户首单奖励"),
		XYHSDGL("14","新用户首单鼓励"),
		ZNSJBG("15","治安事件状态变更"),
		ZNSJJL("16","治安奖励"),
		ZNSJLAJL("17","治安立案奖励"),
		NZHBJL("18","年终奖红包奖励"),
		XSZCHBJL("19","新手注册红包奖励");
		 
		public String key;
		public String value;
		private MESSAGE_TYPE(String key, String value){
			this.key = key;
			this.value = value;
		}
		public static String get(String key) {
			MESSAGE_TYPE[] values = MESSAGE_TYPE.values();
			for (MESSAGE_TYPE object : values) {
				if (object.key.equals(key)) {
					return object.value;
				}
			}
			return null;
		}
	}
	
	/**
	 * 系统用户ID常量
	 * 10000:系统用户
	 * @author shaoru.ning
	 *
	 */
	public static enum USER_ID{
		SYSTEM(10000,"系统用户");
		public Integer key;
		public String value;
		private USER_ID(Integer key, String value){
			this.key = key;
			this.value = value;
		}
		public static String get(Integer key) {
			USER_ID[] values = USER_ID.values();
			for (USER_ID object : values) {
				if (object.key.equals(key)) {
					return object.value;
				}
			}
			return null;
		}
	}
	
	/**
	 * 现金流水类型常量
	 * 0:提现
	 * 1:奖励
	 * @author shaoru.ning
	 *
	 */
	public static enum MONEY_LOG_TYPE{
		TX("0","提现"),
		JL("1","奖励"),
		TXBH("2","提现驳回"),
	    HDJL("3","活动奖励"),
		GLYCZ("4","管理员操作"),
		YHXF("5","用户消费");
		public String key;
		public String value;
		private MONEY_LOG_TYPE(String key, String value){
			this.key = key;
			this.value = value;
		}
		public static String get(String key) {
			MONEY_LOG_TYPE[] values = MONEY_LOG_TYPE.values();
			for (MONEY_LOG_TYPE object : values) {
				if (object.key.equals(key)) {
					return object.value;
				}
			}
			return null;
		}
	}
}
