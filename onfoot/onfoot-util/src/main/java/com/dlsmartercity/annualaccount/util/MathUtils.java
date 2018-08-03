package com.dlsmartercity.annualaccount.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * Math常用函数定义类。
 */
public final class MathUtils {
    
    private static final String NUMBER_PATTERN = "^[0-9]+(.[0-9]{0,2})?$";// 判断小数点后二位的数字的正则表达式
    private static java.text.DecimalFormat df = new java.text.DecimalFormat("#.#");   
    /**
     * BigDecimal除法，最大标度29。
     *
     * @param dividend
     * @param divisor
     * @return　BigDecimal1 / BigDecimal2
     */
    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
        if (dividend == null || divisor == null) {
            throw new RuntimeException("不能除 NULL值。");
        }
        BigDecimal result = null;

        try {
            result = dividend.divide(divisor);
        } catch (ArithmeticException ex) {
            result = dividend.divide(divisor, 29, BigDecimal.ROUND_HALF_EVEN);
        }

        return result;
    }
    
    /**
     * 金额是数字判断,小数点后二位。
     *
     * @param input
     * @return　boolean
     */
    public static boolean isDecimalNumber(String input) {

        boolean isDecimal = false;

        if (StringUtils.isEmpty(input)) {
            isDecimal = false;
        } else {
            if (input.lastIndexOf(".") == input.length() - 1) {
                isDecimal = false;
            } else {
                isDecimal = match(NUMBER_PATTERN, input);
            }
        }

        return isDecimal;
    }
    
    private static boolean match(String pattern, String str) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        return m.find();
    }
    
    public static boolean isMatch(String pattern, String str) {
    	Pattern p = Pattern.compile(pattern);
    	Matcher m = p.matcher(str);
    	return m.find();
    }
    
    /**
      * 截取小数点后一位
      * @param decimal String
      * @return
      */
    public static String getStrDecimalFormat(String decimal){
      if(null == decimal || "".equals(decimal)){
          return "0.0";
      }
      Double d=Double.valueOf(decimal);
      return  Double.valueOf(df.format(d)).toString();
    }
    /**
     * 关注次数*10+随机数
     * @return
     * @throws Exception
     */
    public static int getNumFollow(int num, String random) {
        int ret = num * 11;
        
        if (StringUtils.isEmpty(random)) {
            
            return ret;
        }
        
        String randomInt = random.substring(random.length()-1);
                
        ret = ret + Integer.parseInt(randomInt) ;

        return ret;
    }
}