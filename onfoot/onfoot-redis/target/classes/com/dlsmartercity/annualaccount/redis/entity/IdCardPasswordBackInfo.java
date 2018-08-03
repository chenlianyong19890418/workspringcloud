package com.dlsmartercity.annualaccount.redis.entity;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@RedisHash("IdCardPasswordBackInfos")
public class IdCardPasswordBackInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String phoneNo;
	
	private Integer uid;
	
	private String uuid;
	
	private String realName;
	
	private String idCardNo;
	
	private Double lat;

    private Double lng;
    
    private String mcsys;

    private Double mlat;

    private Double mlng;
    
    private String pushtoken;
    
    private String pushclosed;
	
	@TimeToLive(unit = TimeUnit.MINUTES)
	private Long timeToLive;
	
	public IdCardPasswordBackInfo() {
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public String getMcsys() {
		return mcsys;
	}

	public void setMcsys(String mcsys) {
		this.mcsys = mcsys;
	}

	public Double getMlat() {
		return mlat;
	}

	public void setMlat(Double mlat) {
		this.mlat = mlat;
	}

	public Double getMlng() {
		return mlng;
	}

	public void setMlng(Double mlng) {
		this.mlng = mlng;
	}

	public String getPushtoken() {
		return pushtoken;
	}

	public void setPushtoken(String pushtoken) {
		this.pushtoken = pushtoken;
	}

	public String getPushclosed() {
		return pushclosed;
	}

	public void setPushclosed(String pushclosed) {
		this.pushclosed = pushclosed;
	}

	public Long getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(Long timeToLive) {
		this.timeToLive = timeToLive;
	}

}
