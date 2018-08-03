package com.dlsmartercity.annualaccount.api.enums;

import java.util.HashMap;
import java.util.Map;

public enum FiledType {
	
	NONE("", ""),
	SINGLE("1", "单选"),
	MULTIPLE("2", "多选");
	
	private String code;
	private String value;
	
	private static final Map<String, FiledType> CODE_MAP = new HashMap<>();
	
	static {
		for(FiledType retCode : values()) {
			CODE_MAP.put(retCode.getCode(), retCode);
		}
	}
	
	FiledType(String code, String value) {
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static FiledType fromCode(String code) {
		return CODE_MAP.get(code);
	}

}
