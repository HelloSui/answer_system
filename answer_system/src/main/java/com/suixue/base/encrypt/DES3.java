package com.suixue.base.encrypt;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 3DES加密工具类
 */
public class DES3 {
    // 向量
    private final static String iv = "01234567";

    // 加解密统一使用的编码方式
    private final static String encoding = "utf-8";

    /**
     * 3DES加密
     * 
     * @param plainText
     *            普通文本
     * @return
     * @throws Exception
     */
    public static String encrypt(String plainText, String secretKey)
            throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes(encoding));
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes(encoding));
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        //cipher.init(Cipher.ENCRYPT_MODE, deskey);
        byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
        return Base64.encode(encryptData);
    }

    /**
     * 3DES解密
     * 
     * @param encryptText
     *            加密文本
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptText, String secretKey)
            throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes(encoding));
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes(encoding));
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
        //cipher.init(Cipher.DECRYPT_MODE, deskey);

        byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));

        return new String(decryptData, encoding);
    }

    public static void main(String[] args) throws Exception {
        String message = "{\"passport\":\"15920397970\",\"password\":\"25d55ad283aa400af464c76d713c07ad\"}";
        String key = "r4g57fgjdu893w842872y7$u";
        // faefd16@@93f1-54a849%844!ed3a2#9
        String s = encrypt(message, key);
        System.out.println(s);
        String t = decrypt(s, key);
        System.out.println(t);
    }
}
