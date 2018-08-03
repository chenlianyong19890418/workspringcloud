package com.dlsmartercity.annualaccount.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 随机数生成工具
 * @author huangxu
 *
 */
public abstract class RandomUtils {
	
	public static int nextInt() {
		return org.apache.commons.lang.math.RandomUtils.nextInt();
	}
	
	public static int nextInt(int n) {
		return org.apache.commons.lang.math.RandomUtils.nextInt(n);
	}
	
	public static long nextLong() {
		return org.apache.commons.lang.math.RandomUtils.nextLong();
	}
	
	public static boolean nextBoolean() {
		return org.apache.commons.lang.math.RandomUtils.nextBoolean();
	}
	
	public static float nextFloat() {
		return org.apache.commons.lang.math.RandomUtils.nextFloat();
	}
	
	public static double nextDouble() {
		return org.apache.commons.lang.math.RandomUtils.nextDouble();
	}
	
	/**
	 * 随机获取给定数组的子集
	 * @param array 给定数据
	 * @param count 需要获取子集的元素个数
	 * @return 子集
	 */
	public static int[] getRandomSubArray(int[] array, int count) {
		int[] result = new int[count];
		
		List<Integer> list = new ArrayList<>(array.length);
		for(int e : array) {
			list.add(e);
		}
		
		for (int i = 0; i < result.length; i++) {
			int index = nextInt(list.size());
			result[i] = list.get(index);
			list.remove(index);
		}
		
		return result;
	}

}
