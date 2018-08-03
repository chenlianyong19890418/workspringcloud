package com.dlsmartercity.annualaccount.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories(basePackages = "com.dlsmartercity.annualaccount.redis.repositories")
public class RedisConfig {

}
