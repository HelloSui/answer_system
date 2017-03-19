package com.suixue.user.dao;

import sun.misc.BASE64Encoder;

public class Test {
	public static void main(String[] args) {
		
		BASE64Encoder encoder = new BASE64Encoder();
		String encodeStr = encoder.encodeBuffer("1234".getBytes());
		byte[] bytes = "1234".getBytes();
		for(byte b: bytes){
			System.out.println(b);
		}
		System.out.println(encodeStr);
	}
}
