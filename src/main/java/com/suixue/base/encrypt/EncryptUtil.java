package com.suixue.base.encrypt;


import java.util.Random;

/**
 * 加密工具类
 */
public class EncryptUtil {

    /**
     * 加密Salt值长度
     */
    private static final int SALT_LENGTH = 5;

    /**
     * 双重加密固定后缀#
     */
    public static final String DOUBLE_ENCRYPT_SUFFIX = "";

    /**
     * 简单双重加密固定后缀@
     */
    public static final String SIMPLE_DOUBLE_ENCRYPT_SUFFIX = "@";


    private static final int SIMPLE_DOUBLE_ENCRYPT_FLAG_LENGTH = 1;

    private static final String RANDOM_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String RANDOM_NUMBER = "0123456789";

    //private static final String DES3KEY = "123457jhik3256789abcdefghijklmnopqrstuvwxyz@#$kjoisldrgl54r65q4gu87843918u%%4r0-*1qlkfl;ads7454dmnmkwaeriql1r4g57fgjdu893w842872y7u$";
    private static final String DES3KEY = "r4g57fgjdu893w842872y7$u";
    private static final String AESKEY = "123456789abcdefg";

    private static String getRandomString(int len) {
        StringBuilder buf = new StringBuilder(len + 1);

        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            buf.append(RANDOM_CHARS.charAt(rand.nextInt(RANDOM_CHARS.length())));
        }
        return buf.toString();
    }

    public static String getRandomNumber(int len){
        StringBuilder buf = new StringBuilder();

        Random rand = new Random();
        for(int i=0; i<len; i++){
            buf.append(RANDOM_NUMBER.charAt(rand.nextInt(RANDOM_NUMBER.length())));
        }
        return buf.toString();
    }


    /**
     * 双重加密：DES3和AES，加密结果随机
     *
     * @param content 明文
     * @param des3Key DES3的密钥
     * @param aesKey  AES的密钥
     * @param suffix  加密结果的固定后缀，长度只能为1位，如果超出此长度，将只取第一位不为空的字符；如果该参数为空，则不设置固定后缀
     * @return
     * @throws RuntimeException
     */
    public static String doubleEncrypt(String content, String des3Key,
                                       String aesKey, final String suffix) throws RuntimeException {
        if (content == null || des3Key == null || aesKey == null) {
            throw new RuntimeException("doubleEncrypt, params is error");
        }
        /***String salt1 = getRandomString(SALT_LENGTH);
        String salt2;
        if (suffix == null) {
            salt2 = getRandomString(SALT_LENGTH);
        } else {
            if (StringUtils.isBlank(suffix)) {
                salt2 = getRandomString(SALT_LENGTH);
            } else {
                salt2 = getRandomString(SALT_LENGTH - 1)
                        + suffix.substring(0, 1);
            }
        }
        String result = null;
        try {
            result = DES3.encrypt(content + salt1, des3Key + salt1) + salt1;
            result = AESHelper.encrypt(result, aesKey + salt2) + salt2;
        } catch (Exception e) {
            throw new RuntimeException("encrypt error, " + e.getMessage(), e);
        }****/
        String result = null;
        try {
            result = DES3.encrypt(content.trim(), des3Key);
            result = AESOperator.getInstance().encrypt(result.replace(" ",""));
        } catch (Exception e) {
            throw new RuntimeException("encrypt error, " + e.getMessage(), e);
        }
        return result;
    }

    public static String doubleEncrypt(String content) throws RuntimeException {
        return doubleEncrypt(content, DES3KEY, AESKEY, DOUBLE_ENCRYPT_SUFFIX);
    }


    /**
     * 双重加密：DES3和AES，加密结果固定
     *
     * @param content 明文
     * @param des3Key DES3的密钥
     * @param aesKey  AES的密钥
     * @param suffix  加密结果的固定后缀，长度只能为1位，如果超出此长度，将只取第一位不为空的字符；如果该参数为空，则不设置固定后缀
     * @return
     * @throws RuntimeException
     */
    public static String simpleDoubleEncrypt(String content, String des3Key,
                                             String aesKey, final String suffix) throws RuntimeException {
        if (content == null || des3Key == null || aesKey == null) {
            throw new RuntimeException("doubleEncrypt, params is error");
        }
        String result = null;
        try {
            result = DES3.encrypt(content, des3Key);
            result = AESHelper.encrypt(result, aesKey) + suffix;
        } catch (Exception e) {
            throw new RuntimeException("encrypt error, " + e.getMessage(), e);
        }
        return result;
    }

    /**
     * simpleDoubleEncrypt双重加密对应的解密
     *
     * @param content 密文
     * @param des3Key DE3S的密钥
     * @param aesKey  AES的密钥
     * @return
     * @throws RuntimeException 解密失败，或者密文长度不正确
     */
    public static String simpleDoubleDecrypt(String content, String des3Key,
                                             String aesKey) throws RuntimeException {
        if (content == null || des3Key == null || aesKey == null) {
            throw new RuntimeException("simpleDoubleDecrypt, params is error");
        }
        // AES解密
        if (content.length() < SIMPLE_DOUBLE_ENCRYPT_FLAG_LENGTH) {
            throw new RuntimeException("the length of the content is error");
        }
        content = content.substring(0, content.length() - SIMPLE_DOUBLE_ENCRYPT_FLAG_LENGTH);
        try {
            content = AESHelper.decrypt(content, aesKey);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        // DES3解密
        if (content.length() < SIMPLE_DOUBLE_ENCRYPT_FLAG_LENGTH) {
            throw new RuntimeException(
                    "the length of the ciphertext is error");
        }
        try {
            content = DES3.decrypt(content, des3Key);
            return content;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * doubleEncrypt双重加密对应的解密
     *
     * @param content 密文
     * @param des3Key DE3S的密钥
     * @param aesKey  AES的密钥
     * @return
     * @throws RuntimeException 解密失败，或者密文长度不正确
     */
    public static String doubleDecrypt(String content, String des3Key,
                                       String aesKey) throws RuntimeException {
        if (content == null || des3Key == null || aesKey == null) {
            throw new RuntimeException("doubleDecrypt, params is error");
        }
        // AES解密
        /***if (content.length() < SALT_LENGTH) {
            throw new RuntimeException("the length of the content is error");
        }
        String salt = content.substring(content.length() - SALT_LENGTH);
        content = content.substring(0, content.length() - SALT_LENGTH);
        try {
            content = AESHelper.decrypt(content, aesKey + salt);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        // DES3解密
        if (content.length() < SALT_LENGTH) {
            throw new RuntimeException(
                    "the length of the ciphertext is error");
        }
        salt = content.substring(content.length() - SALT_LENGTH);
        content = content.substring(0, content.length() - SALT_LENGTH);
        try {
            content = DES3.decrypt(content, des3Key + salt);
            return content.substring(0, content.length() - SALT_LENGTH);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }***/
        String decrypt = "";
        try {
            content = AESOperator.getInstance().decrypt(content);
            //content = AESHelper.decrypt(content, aesKey);
            content = DES3.decrypt(content, des3Key);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return content;
    }

    public static String doubleDecrypt(String content) throws RuntimeException {
        return doubleDecrypt(content, DES3KEY, AESKEY);
    }

    public static void main(String args[]) {
        String cont2 = "{\"categoryIds\":[1,2,3],\"channelIds\":[1,2,3],\"qtype\":\"1\",\"qdate\":\"2016\"}";
        String test = "{\"userId\":\"34\",\"passport\":\"15249065555\",\"password\":\"gaodengpan\",\"userName\":\"燕小六\",\"roleList\":[{\"roleId\":\"3\"}],\"categoryList\":[{\"categoryId\":\"2\"}],\"channelList\":[{\"channelId\":\"11\"}]}";
        String test2 = "{\"tagsId\":\"22\",\"tagName\":\"哔哩哔哩22娘\",\"userId\":\"4\",\"channelIds\":\"1,3\",\"request\":\"update\"}";
        String test3 = "{\"tagsId\":\"22\",\"request\":\"delete\"}";
        String ecrypt = doubleEncrypt(cont2);
        System.out.println("---------------");
        System.out.println(ecrypt);
        System.out.println("----------");
        String ecrypt2 = "RMovRfohkTx8Od1GotAqXtSgYxKcHb4Pbjo9bPreuGs0l5JddcX1yE4pU+XuxZOcMerKYTSdtzZfde50Tg\\/2BMpfDKreaSfbQLneL++fJcyzBdLnw2WKcj7GsOJR42Eg8Rax5iF7WohLd7WefAQYAJdmyDniin+u4I2uPwhC6Gr1FWNU3ZuGmOJuoNiz5DZQ1hzvNilyDa1kEXRlFFlMBMLFKH1kllxYEdSLHWweTO9AEz3v9thzurb6FgPQlJk63k7Jtoz9vmS8l5KDKJlt\\/Q==";

        String decrypt = doubleDecrypt(ecrypt);
        System.out.println(decrypt);
    }
}
