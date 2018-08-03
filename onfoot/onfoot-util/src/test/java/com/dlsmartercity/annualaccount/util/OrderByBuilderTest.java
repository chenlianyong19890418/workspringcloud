package com.dlsmartercity.annualaccount.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dlsmartercity.annualaccount.util.OrderByBuilder;

public class OrderByBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		OrderByBuilder builder = new OrderByBuilder();
		builder.orderBy("uid").orderBy("tid").desc().orderBy("utid").asc();
		System.out.println(builder);
	}

}
