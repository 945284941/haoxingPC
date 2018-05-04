package com.qlzy.common.tools;

import java.io.UnsupportedEncodingException;

public class URLEncoderTwice {
	public static String decoder(String st){
		String result = null;
		try {
			result=java.net.URLEncoder.encode(java.net.URLEncoder.encode(st, "UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
