package com.dlsmartercity.annualaccount.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dlsmartercity.annualaccount.util.NumberUtils;

public class NumberFormatUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(NumberUtils.format(1.005, "0.0#####"));
	}

}
