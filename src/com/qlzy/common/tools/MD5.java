package com.qlzy.common.tools;
/*
 * Copyright (c) CNSOFTWARE 2010 All Rights Reserved
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static String encrypt(String plainText) {
    	if(plainText==null){
    		return null;
    	}
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
           // System.out.println("result: " + buf.toString());// 32位
            result = buf.toString();// 16位
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {
		System.out.println(MD5.encrypt("123456")+" >>>>>");
	}
}
