package com.dlsmartercity.annualaccount.util;

import java.math.BigDecimal;

public class Utils {
	
	private static    java.text.DecimalFormat   df=new   java.text.DecimalFormat("#.#");   
	
	/**
	 * 截取小数点后一位
	 * @param decimal Double
	 * @return
	 */
   public static Double getDecimalFormat(String decimal){
	      Double d=Double.valueOf(decimal);
		return  Double.valueOf(df.format(d));
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
   
   public static BigDecimal  getBigDecimalFormatStr(String str) { 
	   if(null == str || "".equals(str)){
		   BigDecimal bd=new BigDecimal("0.0");
		   return bd;
	   }
       BigDecimal bd=new BigDecimal(str);
       BigDecimal  bd2 = bd.setScale(1,BigDecimal.ROUND_HALF_UP);
       return bd2;
   } 
	 
   
   /**
  	 * 截取小数点后一位
  	 * @param decimal String
  	 * @return
  	 */
     public static BigDecimal getBigDecimalFormat(BigDecimal decimal){
    	 if(null == decimal){
    		 BigDecimal bd = new BigDecimal(0.0);
        	 BigDecimal  bd2 = bd.setScale(1,BigDecimal.ROUND_HALF_UP);
    		 return bd2;
    	 }
    	 Double d= Double.valueOf(decimal.floatValue());
    	 BigDecimal bd = new BigDecimal(d);
    	 BigDecimal  bd2 = bd.setScale(1,BigDecimal.ROUND_HALF_UP);
		return bd2;
     }
     public static void main(String[] args) {
    	 Utils u=new Utils();
    	 System.out.println("============="+u.getBigDecimalFormatStr("10"));
	}
     
}