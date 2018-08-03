package com.dlsmartercity.annualaccount.redis.repositories;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dlsmartercity.annualaccount.redis.entity.PhoneNoPasswordBackInfo;
import com.dlsmartercity.annualaccount.redis.repositories.PhoneNoPasswordBackInfoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class PhoneNoPasswordBackInfoRepositoryTest {
	
	@Autowired
	private PhoneNoPasswordBackInfoRepository phoneNoPasswordBackInfoRepository;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void testSave() {
		PhoneNoPasswordBackInfo info = new PhoneNoPasswordBackInfo();
		info.setNewPassword("newpassword");
		info.setPhoneNo("13591994822");
		info.setTimeToLive(5L);
		info = this.phoneNoPasswordBackInfoRepository.save(info);
	}
	
	@Test
	public void testFindOne() {
		Assert.assertTrue(this.phoneNoPasswordBackInfoRepository.exists("tokenid1"));
		
		PhoneNoPasswordBackInfo info = this.phoneNoPasswordBackInfoRepository.findOne("tokenid1");
		Assert.assertNotNull(info);
		
		System.out.println(info.getNewPassword());
		System.out.println(info.getPhoneNo());
		System.out.println(info.getTimeToLive());
	}

}
