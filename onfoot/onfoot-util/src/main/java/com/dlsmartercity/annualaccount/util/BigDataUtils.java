package com.dlsmartercity.annualaccount.util;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class BigDataUtils {

	private static ResourceBundle res = ResourceBundle.getBundle("appconfig");
	private static Map<String, String> urlsMap = null;

	/**
	 * 获取urlMap
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, String> getUrlMap() {
		if (urlsMap != null && !urlsMap.isEmpty()) {
			return urlsMap;
		}
		urlsMap = new HashMap<String, String>();
		Enumeration e = res.getKeys();
		while (e.hasMoreElements()) {
			String key = e.nextElement().toString();
			String value = get(key);
			urlsMap.put(key, value);
		}
		return urlsMap;
	}

	public static String get(String key) {
		return res.getString(key);
	}
	
	public static String getReqUri(String reqUrl){
		try {
			URL url  = new URL(reqUrl);
			return url.getPath();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}