package com.dlsmartercity.annualaccount.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dlsmartercity.annualaccount.util.DesEncryptUtil;

public class DesEncryptUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		DesEncryptUtil des = new DesEncryptUtil();
		
		System.out.println(des.encrypt(""));
		System.out.println(des.encrypt2Base64("111111"));
		System.out.println(des.encrypt2Base64URLSafeString("hello 小风"));
		
		System.out.println(des.decrypt("0e08e47c4514279a027a4d51d7fe4d23"));
		System.out.println(des.decrypt4Base64("DgjkfEUUJ5oCek1R1/5NIw=="));
		System.out.println(des.decrypt4Base64("DgjkfEUUJ5oCek1R1_5NIw"));
	}

}
