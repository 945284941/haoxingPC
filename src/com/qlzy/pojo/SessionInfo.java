package com.qlzy.pojo;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Company;



/**
 * 登录信息
* @ClassName: SessionInfo
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 周张豹
* @date 2013-4-24 下午1:47:09
 */
public class SessionInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String userId;// 用户ID
	private String loginName;// 用户登录名称
	private String loginPassword;// 登录密码
	private String loginNickName;//昵称
	private String shCheck;//是否是商会会员
	private String userName;
	private String ip;// IP地址
	private String userType;//用户类别：个人会员——'member'，企业会员——'company'
	private List<Company> companyName; 
	private Double zhekou;
	private Double jifen;
	private String language;
	private String msg;
	private Map<String,String> huilvMap;
	private String curentMenu;
	private String toUrl;
	private Map<String,String> addressMap;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * @return the loginPassword
	 */
	public String getLoginPassword() {
		return loginPassword;
	}
	/**
	 * @param loginPassword the loginPassword to set
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getLoginNickName() {
		return loginNickName;
	}
	public void setLoginNickName(String loginNickName) {
		this.loginNickName = loginNickName;
	}
	

	public List<Company> getCompanyName() {
		return companyName;
	}
	public void setCompanyName(List<Company> companyName) {
		this.companyName = companyName;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getShCheck() {
		return shCheck;
	}
	public void setShCheck(String shCheck) {
		this.shCheck = shCheck;
	}
	public Double getZhekou() {
		return zhekou;
	}
	public void setZhekou(Double zhekou) {
		this.zhekou = zhekou;
	}
	public Double getJifen() {
		return jifen;
	}
	public void setJifen(Double jifen) {
		this.jifen = jifen;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Map<String, String> getHuilvMap() {
		return huilvMap;
	}

	public void setHuilvMap(Map<String, String> huilvMap) {
		this.huilvMap = huilvMap;
	}


	public String getCurentMenu() {
		return curentMenu;
	}

	public void setCurentMenu(String curentMenu) {
		this.curentMenu = curentMenu;
	}

	public String getToUrl() {
		return toUrl;
	}

	public void setToUrl(String toUrl) {
		this.toUrl = toUrl;
	}

	public Map<String, String> getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}
}
