package com.dlsmartercity.annualaccount.api.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String retcode = "";
	
	private String retmessage = "";
 
	
	public BaseResponse() {
	}

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public String getRetmessage() {
		return retmessage;
	}

	public void setRetmessage(String retmessage) {
		this.retmessage = retmessage;
	}

 

}
