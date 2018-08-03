package com.dlsmartercity.annualaccount.api.request;

import java.io.Serializable;

import org.springframework.validation.Errors;

import com.dlsmartercity.annualaccount.api.exception.ParamsMissingResponseException;

public class BaseRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected String apptype;
	
	protected String appversion;
	
	protected Long channelid;
	
	protected String appkey;
	
	protected String mobileinfo;
	
	protected String mobilesystem;
	
	protected String tokenid;

	/** 基本请求参数-渠道编号-sysappchannelid **/
	protected String sysappchannelid;
	
	/** 基本请求参数-时间戳-timestamp **/
	protected String timestamp;
	
	/** 基本请求参数-验证字符串-valdatestr **/
	protected String valdatestr;
	
	
	public BaseRequest() {
	}
	
	public BaseRequest(Errors errors, Object... objects) throws Exception {
		if (errors.hasErrors()) {
			Object[] ids = objects.clone();
			for (Object filed : ids) {
				if (filed.equals(errors.getFieldError().getField()))
					throw new ParamsMissingResponseException(errors.getFieldError().getDefaultMessage());
			}
		}
	}

	public String getApptype() {
		return apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getAppversion() {
		return appversion;
	}

	public void setAppversion(String appversion) {
		this.appversion = appversion;
	}

	public Long getChannelid() {
		return channelid;
	}

	public void setChannelid(Long channelid) {
		this.channelid = channelid;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getMobileinfo() {
		return mobileinfo;
	}

	public void setMobileinfo(String mobileinfo) {
		this.mobileinfo = mobileinfo;
	}

	public String getMobilesystem() {
		return mobilesystem;
	}

	public void setMobilesystem(String mobilesystem) {
		this.mobilesystem = mobilesystem;
	}

	public String getTokenid() {
		return tokenid;
	}

	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
	}
	
	

	public String getSysappchannelid() {
		return sysappchannelid;
	}

	public void setSysappchannelid(String sysappchannelid) {
		this.sysappchannelid = sysappchannelid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getValdatestr() {
		return valdatestr;
	}

	public void setValdatestr(String valdatestr) {
		this.valdatestr = valdatestr;
	}

	@Override
	public String toString() {
		return "BaseRequest [apptype=" + apptype + ", appversion=" + appversion + ", channelid=" + channelid
				+ ", appkey=" + appkey + ", mobileinfo=" + mobileinfo + ", mobilesystem=" + mobilesystem + ", tokenid="
				+ tokenid + ", timestamp=" + timestamp + ", sysappchannelid=" + sysappchannelid + ", valdatestr=" + valdatestr + "]";
	}

}
