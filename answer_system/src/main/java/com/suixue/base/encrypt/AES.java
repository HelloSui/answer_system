package com.suixue.base.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AES {
	public AES() {
	}

	private String oldKey = "3775C568A5B3E1E3";

	public String getOldKey() {
		return oldKey;
	}

	public void setOldKey(String oldKey) {
		this.oldKey = oldKey;
	}


	// 加密
	public String Encrypt(String sSrc, String sKey) throws Exception {
		try {
			// ||sKey.equals("")
			if (sKey == null) {
				// System.out.print("Key为空null");
				sKey = getOldKey();
				// return null;
			}
			// 判断Key是否为16位
			if (sKey.length() != 16) {
				// System.out.print("Key长度不是16位");
				return null;
			}
			byte[] raw = sKey.getBytes();
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
			IvParameterSpec iv = new IvParameterSpec("L+\\~f4,Ir)b$=pkf"
					.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes());

			return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码功能
		} catch (Exception ex) {

			return null;
		}
	}

	// 解密
	public String Decrypt(String sSrc, String sKey) throws Exception {
		try {
			// 判断Key是否正确
			// ||sKey.equals("")
			if (sKey == null) {
				//System.out.print("Key为空null");
				sKey = getOldKey();
				// return null;
			}
			// 判断Key是否为16位
			if (sKey.length() != 16) {
				//System.out.print("Key长度不是16位");
				return null;
			}
			byte[] raw = sKey.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			//IvParameterSpec iv = new IvParameterSpec("L+\\~f4,Ir)b$=pkf"
					//.getBytes());
			IvParameterSpec iv = new IvParameterSpec("Lkeff4,Ir)b$=pkf"
					.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
			try {
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original);

				return originalString;
			} catch (Exception e) {
				System.out.println(e.toString());

				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());

			return null;
		}
	}

}
