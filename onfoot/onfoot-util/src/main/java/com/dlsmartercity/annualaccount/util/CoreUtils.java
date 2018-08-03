package com.dlsmartercity.annualaccount.util;

public class CoreUtils {

	/**
	 * 隐藏姓名
	 * 
	 * @return
	 */
	public static String hidenName(String name) {
		String rtn = "";
		
		if (!StringUtils.isEmpty(name)) {
			int size = name.length();
			StringBuffer sb = new StringBuffer();
			sb.append(name.substring(0, 1));
			for (int i = 1; i < size; i++) {
				sb.append("*");
			}
			rtn = sb.toString();
		}
		return rtn;
	}
	
	/**
	 * 关注次数*10+随机数
	 * @return
	 * @throws Exception
	 */
	public static int getNumFollow(int num, String random) {
		/*int ret = num * 11;
		
		if (StringUtils.isEmpty(random)) {
			return ret;
		}
		
		String randomInt = random.substring(random.length()-1);
				
		ret = ret + Integer.parseInt(randomInt) ;

		return ret;*/
		
		
		return num * 3 + 2;
		
	}
}