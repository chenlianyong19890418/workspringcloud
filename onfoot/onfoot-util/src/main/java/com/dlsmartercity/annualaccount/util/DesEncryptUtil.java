package com.dlsmartercity.annualaccount.util;

import java.nio.charset.Charset;
import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.sun.crypto.provider.SunJCE;

@SuppressWarnings("restriction")
public final class DesEncryptUtil {
	
	/** 字符串默认键值     */
	private static String strDefaultKey = "annualstatics";
	
	private static String defaultEncodeing = "UTF-8";

	/** 加密工具     */
	private Cipher encryptCipher = null;

	/** 解密工具     */
	private Cipher decryptCipher = null;

	/**
	 * 默认构造方法，使用默认密钥
	 *
	 * @throws Exception
	 */
	public DesEncryptUtil() {
		this(strDefaultKey);
	}

	/**
	 * 指定密钥构造方法
	 *
	 * @param strKey
	 *            指定的密钥
	 * @throws Exception
	 */
	public DesEncryptUtil(String strKey) {
		try {
			Security.addProvider(new SunJCE());
			Key key = getKey(strKey.getBytes());
	
			encryptCipher = Cipher.getInstance("DES");
			encryptCipher.init(Cipher.ENCRYPT_MODE, key);
	
			decryptCipher = Cipher.getInstance("DES");
			decryptCipher.init(Cipher.DECRYPT_MODE, key);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 加密字节数组
	 *
	 * @param arrB
	 *            需加密的字节数组
	 * @return 加密后的字节数组
	 * @throws Exception
	 */
	public byte[] encrypt(byte[] arrB) {
		try{
			return encryptCipher.doFinal(arrB);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 加密字符串
	 * @param strIn 需加密的字符串
	 * @return 加密后的字符串(Hex)
	 */
	public String encrypt(String strIn) {
		return StringUtils.toHexString(encrypt(strIn.getBytes(Charset.forName(defaultEncodeing))));
	}
	
	/**
	 * 加密字符串
	 * @param strIn 需加密的字符串
	 * @return 加密后的字符串(Base64)
	 */
	public String encrypt2Base64(String strIn) {
		return Base64.encodeBase64String(encrypt(strIn.getBytes(Charset.forName(defaultEncodeing))));
	}
	
	/**
	 * 加密字符串
	 * @param strIn 需加密的字符串
	 * @return 加密后的字符串(Base64URLSafeString)
	 */
	public String encrypt2Base64URLSafeString(String strIn) {
		return Base64.encodeBase64URLSafeString(encrypt(strIn.getBytes(Charset.forName(defaultEncodeing))));
	}

	/**
	 * 解密字节数组
	 *
	 * @param arrB
	 *            需解密的字节数组
	 * @return 解密后的字节数组
	 * @throws Exception
	 */
	public byte[] decrypt(byte[] arrB) {
		try {
			return decryptCipher.doFinal(arrB);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 解密字符串
	 * @param strIn 需解密的字符串(Hex)
	 * @return 解密后的字符串
	 */
	public String decrypt(String strIn) {
		return new String(decrypt(StringUtils.toHex(strIn)), Charset.forName(defaultEncodeing));
	}
	
	/**
	 * 解密字符串
	 * @param strIn Base64String
	 * @return 解密后的字符串
	 */
	public String decrypt4Base64(String strIn) {
		return new String(decrypt(Base64.decodeBase64(strIn)), Charset.forName(defaultEncodeing));
	}

	/**
	 * 从指定字符串生成密钥，密钥所需的字节数组长度为8位 不足8位时后面补0，超出8位只取前8位
	 *
	 * @param arrBTmp
	 *            构成该字符串的字节数组
	 * @return 生成的密钥
	 * @throws Exception
	 */
	private Key getKey(byte[] arrBTmp) {
		// 创建一个空的8位字节数组（默认值为0）
		byte[] arrB = new byte[8];

		// 将原始字节数组转换为8位
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}

		// 生成密钥
		Key key = new SecretKeySpec(arrB, "DES");

		return key;
	}
	
	public static void main(String[] args) {
	    DesEncryptUtil desEncryptUtil = new DesEncryptUtil();
	    String oldpass = desEncryptUtil.encrypt2Base64URLSafeString("admin");
	    System.out.println("=================老密码加密开始=====================");
	    System.out.println("=================老密码=====================："+oldpass);
	    System.out.println("=================老密码加密结束=====================");
	    String newpass = desEncryptUtil.encrypt2Base64("092177");
        System.out.println("=================新密码加密开始=====================");
        System.out.println("=================新密码=====================："+newpass);
        System.out.println("=================新密码加密结束=====================");
	    
    }

}
