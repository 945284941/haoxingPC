package com.qlzy.common.tools;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

/**
 *功能描述：
 *创建时间：Mar 9, 2009 11:18:04 AM 
 *@version 1.0
 */

public class PwdCrypt {
	final static String love = "huifeng@126>COM!@#$%^&";
	
	public static PwdCrypt getInstance(){
		return new PwdCrypt();
	}
    /**
     * 加密操作
     * @param data
     * @return
     */
    public static String encrypt(String data) {
    	return new String(Base64.encodeBase64(simplecrypt(data).getBytes()));
    }
    
    /**
     * 解密操作
     * @param data
     * @return
     * @throws IOException
     */
    public static String decrypt(String data) {
    	return simplecrypt(new String(Base64.decodeBase64(data)));
    }
    
    /**
     * 
     *功能描述：进行常量异或
     *@param
     *@return String
     *@version 1.0
     *@date Mar 9, 200911:44:02 AM
     */
    public static String simplecrypt(String data){
    	char[] a = data.toCharArray();
		for (int i = 0; i < a.length; i++) {
			for(int j=0;j<love.length();j++){
				char c = love.charAt(j);
				a[i] = (char) (a[i] ^ c);
			}
		}
		String s = new String(a);
		return s;
    }
    
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		PwdCrypt pwdCrypt = new PwdCrypt();
//		String estr = pwdCrypt.encrypt("admin");
//		System.out.println("estr is : " + estr);
//		String dstr = pwdCrypt.decrypt(estr);
//		System.out.println("dstr is : " + dstr);
//		  BASE64Decoder decoder = new BASE64Decoder();
//	        byte[] result = null;
//			try {
//				result = decoder.decodeBuffer("UhIUBhEXF1Y=");
//				System.out.println("dstr is : " + pwdCrypt.simplecrypt(new String(result)));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}

}
