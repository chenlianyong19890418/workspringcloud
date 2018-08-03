package com.dlsmartercity.annualaccount.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptUtil {
	
    public static final String KEY_SHA = "SHA";  
    public static final String KEY_MD5 = "MD5";
    public static final String KEY_MAC = "HmacMD5";

    public static byte[] encrypt(byte[] source, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.reset();
        md.update(source);
        return md.digest();
    }

    public static String encrypt(String source, String algorithm) throws NoSuchAlgorithmException {
        byte[] resByteArray = encrypt(source.getBytes(), algorithm);
        return StringUtils.toHexString(resByteArray);
    }

    public static String encryptMD5(String source) {
        if (source == null) {
            source = "";
        }
        String result = "";
        try {
            result = encrypt(source, KEY_MD5);
        }
        catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static String encryptSHA(String source) {
        if (source == null) {
            source = "";
        }
        String result = "";
        try {
            result = encrypt(source, KEY_SHA);
        }
        catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static String initMacKey() throws Exception {  
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);  
        SecretKey secretKey = keyGenerator.generateKey();  
        return StringUtils.toHexString(secretKey.getEncoded()); 
    }  
  
    public static String encryptHMAC(byte[] data, String key) throws Exception {  
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), KEY_MAC);  
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());  
        mac.init(secretKey);
        return StringUtils.toHexString(mac.doFinal(data));
    }
  
    public static String encryptHMAC(String source, String key) throws Exception {  
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), KEY_MAC);  
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());  
        mac.init(secretKey);
        return StringUtils.toHexString(mac.doFinal(source.getBytes()));
    }

}