package com.dlsmartercity.annualaccount.util;

import java.util.Random;

/**
 * 服务端发起验证请求验证移动端(手机)发送的短信
 * 
 * @author jun.liang
 *
 */
public class RandomCode {

	// 验证码字符个数
	private final static int codeCount = 6;

	private final static char[] codeSequence = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * 服务端发起发送短信请求
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getRandomCode() {

		// 创建一个随机数生成器类
		Random random = new Random();

		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		// 随机产生codeCount数字的验证码。
		for (int i = 0; i < codeCount; i++) {
			// 得到随机产生的验证码数字。
			String strRand = String.valueOf(codeSequence[random.nextInt(10)]);
			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
		}
	
		return randomCode.toString();
	}

}
