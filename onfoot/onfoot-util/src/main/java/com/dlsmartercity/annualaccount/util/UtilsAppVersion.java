package com.dlsmartercity.annualaccount.util;


/**
 * 版本号比对
 * @author ujhan
 *
 */
public class UtilsAppVersion {
	
	public static Integer  getUtilsApp(String appIosVersion){
		 String version=appIosVersion.replace(".", ",");
		 String[] ids=version.split(",");
		 String versionStr="";
		 for (int i = 0; i < 3; i++) {
			 if(ids.length>i && null != ids[i] ){
				 versionStr += ids[i];
			 } else {
				 versionStr += 0;
			 }
		 }
		return Integer.parseInt(versionStr);
	}
	
	
	/**
	 * 对比两个版本号 如果版本好相同则也进行更新
	 * 版本号分为三段 x.x.x 主版本号.功能版本号.小本版号
	 * 从左侧向右侧分别对比
	 * 
	 * @author Jarod
	 * @param temVersion 配置文件中的版本号
	 * @param version 传入的版本号
	 * @return 如果 temVersion < version 返回 true
	 */
	public static boolean checkAppVersion(String temVersion ,String version) {
		
		if(temVersion.equals(version))
			return true;
		int[] temVersionInt = getVersion(temVersion);
		int[] versionInt = getVersion(version);
		
		for(int index = 0 ; index < temVersionInt.length ; index ++) {
			if(temVersionInt[index] < versionInt[index]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 将版本号拆分为三段int 
	 * @param version
	 * @return
	 */
	public static int[] getVersion(String version) {
		int[] vsersion = {0,0,0};
		if(!StringUtils.isEmpty(version)) {
			String[] temVersions = version.replace(".", ",").split(",");
			for(int index = 0; index< vsersion.length ; index++) {
				if(index <= temVersions.length) {
					vsersion[index] = Integer.parseInt(temVersions[index]);
				}
			}
		}
		return vsersion;
	}
	
	public static int compareVersion(String version1, String version2) {
		String[] version1Array = version1.split("\\.");
		String[] version2Array = version2.split("\\.");
		for (int i = 0; i < version1Array.length; i++) {
			if(Integer.parseInt(version1Array[i]) > Integer.parseInt(version2Array[i])) {
				return 1;
			} else if(Integer.parseInt(version1Array[i]) < Integer.parseInt(version2Array[i])) {
				return -1;
			}
		}
		return 0;
	}

}
