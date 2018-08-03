package com.dlsmartercity.annualaccount.util;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dlsmartercity.annualaccount.util.DateUtils;
import com.dlsmartercity.annualaccount.util.PgnoUtils;

public class PgnoUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < 46656; i++) {
			String pgno = PgnoUtils.getPgno();
			while(!set.add(pgno)) {
				pgno = PgnoUtils.getPgno();
			}
			System.out.println(pgno);
		}
		Assert.assertEquals(46656, set.size());
		System.out.println(DateUtils.convertDate2String(DateUtils.getDate(), "yyMMdd"));
		
	}

}
