package com.dlsmartercity.annualaccount.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.sf.cglib.beans.BeanCopier;

public class BeanCopierUtils {
	
	private static final ConcurrentMap<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<>();
	
	public static void copyProperties(Object source, Object target) {
		String beanKey = generateKey(source.getClass(), target.getClass());
		BeanCopier copier = null;
		if(!beanCopierMap.containsKey(beanKey)) {
			copier = BeanCopier.create(source.getClass(), target.getClass(), false);
			beanCopierMap.putIfAbsent(beanKey, copier);
		} else {
			copier = beanCopierMap.get(beanKey);
		}
		copier.copy(source, target, null);
	}
	
	private static String generateKey(Class<?> source, Class<?> target) {
		return source.toString() + target.toString();
	}
	
}
