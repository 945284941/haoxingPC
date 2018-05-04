package com.qlzy.email.util;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.Constant;

/***@author yhl
 * 生成好友分享链接、重新设置密码的链接
 */
public class GenerateLinkUtils {
	final static String love = "liangs2yixiu!@#$%^&";
	
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
     *@author yhl
     *@param
     *@return String
     *@throws
     *@version 1.0
     *@date 2013-08-06
     */
    public static String simplecrypt(String data){
    	char[] a = data.toCharArray();
		for (int i = 0; i < a.length; i++) {
			for(int j=0;j<love.length();j++){
				char c = love.charAt(j);
				a[i] = (char) (a[i] ^ c);
			}
		}
		return new String(a);
    }
	/***
	 * 好友分享生成新链接
	 * @param Uid
	 * @return
	 */
	public static String generateResetNewUrl(String Uid) {
		return "http://www.sanguhuivip.com/toActiveMemberRegister.html?mdid="+ encrypt(Uid);
	}
	/**
	 * 生成重设密码的链接
	 */
	public static String generateResetPwdLink(String userName,String userId,String userType) {
		return "http://www.sanguhuivip.com/toMemberforgotPwdClickUrl.html?userName=" 
				+ encrypt(userName) + "&mdid=" + encrypt(userId) + "&userType=" + userType;
	}	
	
	/**
	 * @Title: generateResetNewUrlForWebsite
	 * @Description: TODO(个人或企业好友分享生成新链接(用于网站)) 
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return String 返回类型 
	 * @author wangmei
	 */
	public static String generateResetNewUrlForWebsite(SessionInfo sessionInfo) {
		if(Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())){
			return "http://www.sanguhuivip.com/toMemberRegister.html?mdid="+ encrypt(sessionInfo.getUserId());
		}else{
			return "http://www.sanguhuivip.com/toCompanyRegister.html?mdid="+ encrypt(sessionInfo.getUserId());
		}
	}	

}
