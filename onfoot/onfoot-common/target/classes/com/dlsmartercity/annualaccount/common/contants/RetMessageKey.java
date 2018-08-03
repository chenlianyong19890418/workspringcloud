package com.dlsmartercity.annualaccount.common.contants;

public interface RetMessageKey {
	
	/** 正确返回 **/
	String RESPONSE_CODE_SUCCESS = "0000";
	
	/** 账户在别处登录 **/
	String RESPONSE_CODE_0001 = "0001";
	
	/** 账户锁定 **/
	String RESPONSE_CODE_0002 = "0002";
	
	/** 登录超时 **/
	String RESPONSE_CODE_0003 = "0003";
	
	/** 登录验证失败 **/
	String RESPONSE_CODE_0004 = "0004";
	
	/** 警号不存在 **/
	String RESPONSE_CODE_0005 = "0005";
	
	/** 用户密码错误 **/
	String RESPONSE_CODE_0006 = "0006";
	
	/** 修改头像失败 **/
	String RESPONSE_CODE_0007 = "0007";
	
	/** 请登录后再执行此操作  **/
	String RESPONSE_CODE_0008 = "0008";
	
	/**图片限制**/
	String RESPONSE_CODE_0009 = "0009";
	
	/**无效用户**/
	String RESPONSE_CODE_0010 = "0010";
	
	/**昵称已被占用**/
	String RESPONSE_CODE_0011 = "0011";
	
	/**原始密码错误**/
	String RESPONSE_CODE_0012 = "0012";
	
	/**昵称格式不正确**/
	String RESPONSE_CODE_0013 = "0013";
	
	/**密码格式不正确**/
	String RESPONSE_CODE_0014 = "0014";
	
	/**该用户未实名认证**/
	String RESPONSE_CODE_0015 = "0015";
	
	/**真实姓名不能为空**/
	String RESPONSE_CODE_0016 = "0016";
	
	/**身份证号不能为空**/
	String RESPONSE_CODE_0017 = "0017";

	/**新密码不能为空**/
	String RESPONSE_CODE_0018 = "0018";
	
	/**密码输入不一致**/
	String RESPONSE_CODE_0019 = "0019";
	
	/**事件不存在**/
	String RESPONSE_CODE_0020 = "0020";
	
	/**任务状态为{0}，无法接受该任务**/
	String RESPONSE_CODE_0021 = "0021";
	
	/**不是任务指定执行民警、不能接受任务**/
	String RESPONSE_CODE_0022 = "0022";
	
	/**核实结果不能为空**/
	String RESPONSE_CODE_0023 = "0023";
	
	/**任务不存在**/
	String RESPONSE_CODE_0024 = "0024";
	
	/**任务状态为{0}，无法提交该任务**/
	String RESPONSE_CODE_0025 = "0025";
	
	/**该用户未经授权，无法登陆**/
	String RESPONSE_CODE_0026 = "0026";
	
	/**房主信息有误**/
	String RESPONSE_CODE_0027 = "0027";
	
	/**租户信息有误**/
	String RESPONSE_CODE_0028 = "0028";
	
	/**用户组织机构信息缺失，请联系管理员**/
	String RESPONSE_CODE_0029 = "0029";
	
	/**该任务下尚有事件未处理，无法提交**/
	String RESPONSE_CODE_0030 = "0030";
	
	/**请上传承租人身份证的正面和背面2张照片**/
	String RESPONSE_CODE_0031 = "0031";
	
	/**请上传处理后照片**/
	String RESPONSE_CODE_0032 = "0032";
	
	/**请填写解决情况**/
	String RESPONSE_CODE_0033 = "0033";
	
	/**大数据同步异常**/
	String RESPONSE_CODE_0034 = "0034";
	
	/**该用户没有年度账单**/
	String RESPONSE_CODE_0035 = "0035";
	
	/**该用户已投过票**/
	String RESPONSE_CODE_0036 = "0036";
	
	/**该用户无任何事件上传**/
	String RESPONSE_CODE_0037 = "0037";
	
	/**年终奖励已经领取**/
	String RESPONSE_CODE_0038 = "0038";
	
	/**无此用户**/
	String RESPONSE_CODE_0039 = "0039";
	
	/**红包已领取**/
	String RESPONSE_CODE_0040 = "0040";
	
	/**活动暂未开始**/
	String RESPONSE_CODE_0041 = "0041";
	
	/**活动已结束**/
	String RESPONSE_CODE_0042 = "0042";
	
	/**获取用户微信授权信息失败**/
	String RESPONSE_CODE_0043 = "0043";
	
	/** 参数缺失 **/
	String RESPONSE_CODE_PARAMS_MISSING = "0101";

	/** 缺失APPKEY **/
	String RESPONSE_CODE_APPKEY_MISSING = "9001";
	
	/** 缺失TOCKENID **/
	String RESPONSE_CODE_TOCKENID_MISSING = "9002";
	
	/** 缺失app类型 **/
	String RESPONSE_CODE_APPTYPE_MISSING = "9003";
	
	/** 缺失app版本三段式版本号 **/
	String RESPONSE_CODE_APPVERSION_MISSING = "9004";
	
	/** 缺失渠道参数 **/
	String RESPONSE_CODE_CHANNELID_MISSING = "9005";
	
	/** 无效的APPKEY **/
	String RESPONSE_CODE_APPKEY_INVALID = "9006";
	
	/** 无效的TOCKENID **/
	String RESPONSE_CODE_TOCKENID_INVALID = "9007";
	
	/** 缺失rows参数 **/
	String RESPONSE_CODE_ROWS_MISSING = "9008";
	
	/** 无效的rows **/
	String RESPONSE_CODE_ROWS_INVALID = "9009";
	
	
	/** 缺失SYSAPPCHANNELID **/
	String RESPONSE_CODE_SYSAPPCHANNELID_MISSING = "9010";
	
	/** 无效的SYSAPPCHANNELID **/
	String RESPONSE_CODE_SYSAPPCHANNELID_INVALID = "9011";
	
	/** 缺失TIMESTAMP **/
	String RESPONSE_CODE_TIMESTAMP_MISSING = "9012";
	
	/** 缺失VALDATESTR **/
	String RESPONSE_CODE_VALDATESTR_MISSING = "9013";
	
	/** 无效的VALDATESTR **/
	String RESPONSE_CODE_VALDATESTR_INVALID = "9014";
	
	/** 参数验证有误 **/
	String RESPONSE_CODE_REQUEST_PARAMS_VERIFICATION_ERROR = "9997";
	
	/** 该接口暂未开放 **/
	String RESPONSE_CODE_REQUEST_NOT_MAPPING = "9998";
	
	/** 服务器忙请稍后尝试 **/
	String RESPONSE_CODE_SERVER_BUSY = "9999";
	
}
