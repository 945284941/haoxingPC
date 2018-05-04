/**  
* @Title: isc.java
* @Package com.qlzy.util
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-11-6 下午5:09:36
* @version V1.0  
*/
package com.qlzy.util;

import java.security.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.qlzy.common.tools.MD5;

/**
 * @ClassName: isc
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-11-6 下午5:09:36
 */
public class isc {
	 private static final String HMAC_SHA1 = "HmacSHA1";  
	  
	    /** 
	     * 生成签名数据 
	     *  
	     * @param data 待加密的数据 
	     * @param key  加密使用的key 
	     * @return 生成MD5编码的字符串  
	     * @throws InvalidKeyException 
	     * @throws NoSuchAlgorithmException 
	     */  
	    public static String getSignature(byte[] data, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException {  
	        SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA1);  
	        Mac mac = Mac.getInstance(HMAC_SHA1);  
	        mac.init(signingKey);  
	        byte[] rawHmac = mac.doFinal(data);  
//	        return MD5.encode(rawHmac); 
	        return "";
	    }  
}
