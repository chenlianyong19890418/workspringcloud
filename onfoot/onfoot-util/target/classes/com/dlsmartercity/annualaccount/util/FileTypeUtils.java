package com.dlsmartercity.annualaccount.util;

public class FileTypeUtils {
	
	private static final String[] IMG_TABLE = {
			"bmp", "jpg", "jpeg", "png", "tiff", "gif", "pcx", "tga", "exif", "fpx", "svg", "psd",
			"cdr", "pcd", "dxf", "ufo", "eps", "ai", "raw", "wmf"
	};
	
	private static final String[] VIDEO_TABLE = {
			"mp4", "avi", "mov", "wmv", "asf", "navi", "3gp", "mkv", "f4v", "rmvb", "webm"
	};
	
	private static final String[] DOCUMENT_TABLE = {
			"txt", "doc", "docx", "xls", "htm", "html", "jsp", "rtf", "wpd", "pdf", "ppt"
	};
	
	private static final String[] MUSIC_TABLE = {
			"mp3", "wma", "wav", "mod", "ra", "cd", "md", "asf", "aac", "vqf", "ape", "mid", "ogg", "m4a", "vqf"
	};
	
	
	public static String getFileType(String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return "";
		}
		String fileSuffix = getFileSuffix(fileName);
		
		for (int i = 0; i < IMG_TABLE.length; i++) {
			if (IMG_TABLE[i].equals(fileSuffix)) {
				return "1";
			}
		}
		
		for (int i = 0; i < VIDEO_TABLE.length; i++) {
			if (VIDEO_TABLE[i].equals(fileSuffix)) {
				return "2";
			}
		}
		
		for (int i = 0; i < DOCUMENT_TABLE.length; i++) {
			if (DOCUMENT_TABLE[i].equals(fileSuffix)) {
				return "3";
			}
		}
		
		for (int i = 0; i < MUSIC_TABLE.length; i++) {
			if (MUSIC_TABLE[i].equals(fileSuffix)) {
				return "4";
			}
		}
		return "";
	}
	
	public static String getFileSuffix(String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return "";
		}
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}

}
