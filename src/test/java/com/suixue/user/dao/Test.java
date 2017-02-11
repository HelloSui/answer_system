package com.suixue.user.dao;

import com.suixue.base.encrypt.Base64;
import com.suixue.base.encrypt.EncryptUtil;
import com.suixue.base.encrypt.MD5Utils;

public class Test {
	public static void main(String[] args) {
		
		String encry = EncryptUtil.doubleEncrypt("admin");
		System.out.println(encry);
		
		String res = Base64.encode("A".getBytes());
		
		System.out.println(res);
		
		System.out.println(MD5Utils.getMD5("admin"));
		System.out.println(MD5Utils.getMD5("admin"));
	}
}
