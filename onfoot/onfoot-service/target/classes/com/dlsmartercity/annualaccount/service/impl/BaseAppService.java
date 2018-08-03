package com.dlsmartercity.annualaccount.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.dlsmartercity.annualaccount.core.service.BaseService;

public abstract class BaseAppService extends BaseService {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	protected RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

}
