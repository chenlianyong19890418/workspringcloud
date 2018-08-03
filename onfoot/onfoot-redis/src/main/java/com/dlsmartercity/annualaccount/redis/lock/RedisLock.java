package com.dlsmartercity.annualaccount.redis.lock;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.dlsmartercity.annualaccount.core.helper.ApplicationContextHolder;

public class RedisLock {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RedisLock.class);
	
	private RedisTemplate<String, String> redisTemplate;
	
	private String lockname;
	
	private static final long DEFAULT_TIMEOUT = 30000;
	
	private static final long DEFAULT_EXPIRE = 10000;
	
	private ThreadLocal<Boolean> locked = new ThreadLocal<>();
	
	private static ConcurrentMap<String, RedisLock> redisLockMap = new ConcurrentHashMap<>();
	
	@SuppressWarnings("unchecked")
	private RedisLock(String lockname) {
		this.lockname = lockname;
		this.redisTemplate = ApplicationContextHolder.getBean("redisTemplate", RedisTemplate.class);
	}
	
	public static RedisLock getInstance(String lockname) {
		if(!redisLockMap.containsKey(lockname)) {
			redisLockMap.putIfAbsent(lockname, new RedisLock(lockname));
		}
		return redisLockMap.get(lockname);
	}
	
	public boolean isLock() {
		return this.locked.get() != null && this.locked.get();
	}

	protected void setLock(boolean lock) {
		this.locked.set(lock);
	}

	public void lock(long timeout, long expire) {
		LOGGER.debug("获取分布式锁,lockname={}", this.lockname);
		String identity = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		long nano = System.nanoTime();
		timeout *= 1000000;
		Random r = new Random();
		ValueOperations<String, String> operations = this.redisTemplate.opsForValue();
		while((System.nanoTime() - nano) < timeout) {
			if(operations.setIfAbsent(lockname, identity)) {
				this.redisTemplate.expire(lockname, expire, TimeUnit.MILLISECONDS);
				setLock(true);
				LOGGER.info("获取分布式锁成功,lockname={}", this.lockname);
				return;
			} else {
				if(this.redisTemplate.getExpire(this.lockname) <= 0) {
					this.redisTemplate.expire(lockname, expire, TimeUnit.MILLISECONDS);
				}
			}
			try {
				LOGGER.info("分布式锁被被占用,lockname={},睡眠后重新尝试获取", this.lockname);
				Thread.sleep(3, r.nextInt(500));
			} catch (InterruptedException e) {
				return;
			}
		}
		LOGGER.warn("获取分布式锁失败,lockname={}", this.lockname);
	}
	
	public void lock(long timeout) {
		lock(timeout, DEFAULT_EXPIRE);
	}
	
	public void lock() {
		lock(DEFAULT_TIMEOUT);
	}
	
	public void unlock() {
		if(isLock()) {
			LOGGER.info("释放分布式锁,lockname={}", this.lockname);
			this.redisTemplate.delete(lockname);
			setLock(false);
		}
	}

}
