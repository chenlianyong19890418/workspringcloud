package com.dlsmartercity.annualaccount.api.response;

public class BodyResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
