package com.dlsmartercity.annualaccount.util;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dlsmartercity.annualaccount.util.RandomUtils;

public class RandomUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRandomSubArray() {
		int[] array = new int[60];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		int[] result = RandomUtils.getRandomSubArray(array, 30);
		System.out.println(Arrays.toString(result));
	}

}
