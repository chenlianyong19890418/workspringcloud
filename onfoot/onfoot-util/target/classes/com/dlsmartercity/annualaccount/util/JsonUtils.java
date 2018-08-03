package com.dlsmartercity.annualaccount.util;

import java.nio.charset.Charset;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;

/**
 * json操作工具类
 *
 */
public abstract class JsonUtils {
	
	private static FastJsonConfig fastJsonConfig;
	
	static {
		fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setCharset(Charset.forName("UTF-8"));
		fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
		fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
	}
	
	/**
	 * 将对象序列化为json字符串
	 *
	 * @param obj
	 *            需要被序列化的内容
	 * @return
	 */
	public static String serialize(Object obj) {
		return JSON.toJSONString(obj, fastJsonConfig.getSerializeConfig(), fastJsonConfig.getSerializeFilters(), fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, fastJsonConfig.getSerializerFeatures());
	}

	/**
	 * 将json字符串反序列化为对象
	 *
	 * @param json 需要反序列化的json字符串
	 * @param clazz 需要反序列化成的类
	 * @return
	 */
	public static <T> T deserialize(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz, fastJsonConfig.getParserConfig(), null, JSON.DEFAULT_PARSER_FEATURE, fastJsonConfig.getFeatures());
	}
}
