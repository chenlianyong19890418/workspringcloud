package com.dlsmartercity.annualaccount.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:redis-beans.xml"})
public class JedisTest {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
		ops.set("test", "spring data");
		System.out.println(ops.get("test"));
		this.redisTemplate.delete("test");
	}
	
}
