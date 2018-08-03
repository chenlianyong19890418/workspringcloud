package com.dlsmartercity.annualaccount.util;

public abstract class ArrayUtils {
	
	public static int[] toPrimitive(Integer[] array) {
		return org.apache.commons.lang.ArrayUtils.toPrimitive(array);
	}
	
	public static int[] toPrimitive(Integer[] array, int valueForNull) {
		return org.apache.commons.lang.ArrayUtils.toPrimitive(array, valueForNull);
	}
	
	public static Integer[] toObject(int[] array) {
		return org.apache.commons.lang.ArrayUtils.toObject(array);
	}
	
	public static boolean isEquals(Object array1, Object array2) {
		return org.apache.commons.lang.ArrayUtils.isEquals(array1, array2);
	}

}
