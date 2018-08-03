package com.dlsmartercity.annualaccount.util;

import java.util.Date;

/**
 * 获取游客编号工具
 * @author smartercity
 *
 */
public class RecommendedCodeUtils {
	
	final static String code = "00001";
	
	final static String codeError = "00000";
	
	final static int MIN_NUMBER = 1;
	
	final static int MAX_NUMBER = 39135392;
	
	final static char[] digits = {
	        '0' , '1' , '3' , '4' , '5' ,
	        '6' , '7' , '8' , '9' , 'a' , 'b' ,
	        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
	        'j' , 'k' , 'l' , 'm' , 'n' , 
	        'p' , 'q' , 'r' , 's' , 't' ,
	        'u' , 'v' , 'w' , 'x' , 'y' , 'z'
	    };
	
	/**
	 * 通过辅助数获得编号
	 * @param num 1~39135392 超出范围返回空
	 * @return
	 */
	public static String getCodeByNumber(int num) {
		if(num>= MIN_NUMBER && num<= MAX_NUMBER) {
			StringBuffer newCode = new StringBuffer();
			newCode.append(codeError);
			newCode.append(getCodeByNumberReverse(num));
			return newCode.substring(newCode.length()-4,newCode.length()).toUpperCase();
		} else {
			return "";
		}
	}
	
	
	protected static String getCodeByNumberCover(int num) {
		StringBuffer newCode = new StringBuffer();
		int remainder = 0;
		int result = num;
		do {
			remainder = result%digits.length;
			result = result/digits.length;
			newCode.append(digits[remainder]);
		} while(result>0);
		return newCode.toString();
	}
	
	
	protected static String getCodeByNumberReverse(int num) {
		StringBuffer newCode = new StringBuffer();
		newCode.append(getCodeByNumberCover(num));
		return newCode.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getCodeByNumber((int)new Date().getTime()));
		for(int i = 0 ; i< 10 ; i++) {
			System.out.println(i);
			System.out.println(getCodeByNumber(i));
		}
	}

}
