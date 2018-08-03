package com.dlsmartercity.annualaccount.core.redis.serializer;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;

public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
	
	private FastJsonConfig fastJsonConfig = new FastJsonConfig();
	
	private Class<T> clazz;
	
	public FastJsonRedisSerializer() {
	}
	
	public FastJsonRedisSerializer(Class<T> clazz) {
		this.clazz = clazz;
	}

	public FastJsonConfig getFastJsonConfig() {
		return fastJsonConfig;
	}

	public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
		this.fastJsonConfig = fastJsonConfig;
	}

	@Override
	public byte[] serialize(T t) throws SerializationException {
		return JSON.toJSONBytes(t, this.fastJsonConfig.getSerializeConfig(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
	}

	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		return JSON.parseObject(bytes, 0, bytes.length, this.fastJsonConfig.getCharset(), clazz, this.fastJsonConfig.getFeatures());
	}

}
