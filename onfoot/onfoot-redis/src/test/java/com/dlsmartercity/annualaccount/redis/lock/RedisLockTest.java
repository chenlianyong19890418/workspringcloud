package com.dlsmartercity.annualaccount.redis.lock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RedisLockTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RedisLockTest.class);
	
	private Account account;
	
	@Before
	public void setUp() throws Exception {
		account = new Account("account1", 1000);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		LOGGER.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		for (int i = 0; i < 100; i++) {
			new Thread(new Consumer(account)).start();
			new Thread(new Productor(account)).start();
		}
		Thread.sleep(10 * 1000);
		LOGGER.info("###############################################");
	}

}
