package com.qlzy.common.tools;

import java.io.UnsupportedEncodingException;

public class URLDecoderTwice {
	public static String decoder(String st){
		String result = null;
		try {
			result=java.net.URLDecoder.decode(java.net.URLDecoder.decode(st, "UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(URLDecoderTwice.decoder("%25E5%2593%2581%25E7%2589%258C%25E7%259F%25A5%25E8%25AF%2586"));
	}
}
