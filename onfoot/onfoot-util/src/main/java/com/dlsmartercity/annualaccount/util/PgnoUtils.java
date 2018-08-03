package com.dlsmartercity.annualaccount.util;

import java.util.Random;

/**
 * 事件编号生成工具
 * @author huangxu
 *
 */
public abstract class PgnoUtils {
	
	private static final char[] ENCODE_TABLE = {
        'A', 'B', 'C', 'D', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
	};
	
	/**
	 * 默认长度
	 */
	private static final int DEFAULT_LENGTH = 3;
	
	private static final Random random = new Random();
	
	/**
	 * 根据默认长度生成事件编号
	 * @return 事件编号
	 */
	public static String getPgno() {
		return getPgno(DEFAULT_LENGTH);
	}
	
	/**
	 * 根据给定长度生成事件编号
	 * @param length 编号长度
	 * @return 事件编号
	 */
	public static String getPgno(int length) {
		StringBuilder pgno = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			pgno.append(ENCODE_TABLE[Math.abs(random.nextInt() % ENCODE_TABLE.length)]);
		}
		return pgno.toString();
	}

}
