package com.dlsmartercity.annualaccount.util;

/**
 * �ϴ��ļ�������
 * 
 * @author jun.liang
 *
 */
public class ReqFile {
	/**
	 *  用户唯一ID
	 */
	private String uid;
	
	/**
	 * 图片类型
	 */
	private String ptype;
	
	/**
	 * App版本0：Android，1：ios
	 */
	private String apptype;
	
	/**
	 * App版本
	 */
	private String appver;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getApptype() {
		return apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getAppver() {
		return appver;
	}

	public void setAppver(String appver) {
		this.appver = appver;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("uid=").append(uid).append(",");
		sb.append("apptype=").append(apptype).append(",");
		sb.append("appver=").append(appver).append(",");
		sb.append("ptype=").append(ptype);
		return sb.toString();
	}
	
}
