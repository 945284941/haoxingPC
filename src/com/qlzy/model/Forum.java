package com.qlzy.model;

import java.util.Date;

import com.qlzy.util.Pagination;

import java.io.Serializable;

public class Forum extends Pagination implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String id;
	
	private String title;
	
	private String information;
	
	private Date  createTime;
	
	private String userId;
	
	private String type;
	
	private Integer huitieSum;
	
	private String disabled;
	
	private String userName;
	
	private Integer viewnum;
	
	private Integer visits;
	
	private Integer praise;
	
	private Integer viewnums;
	
	private String pid;
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Integer getViewnums() {
		return viewnums;
	}

	public void setViewnums(Integer viewnums) {
		this.viewnums = viewnums;
	}

	public Integer getPraise() {
		return praise;
	}

	public void setPraise(Integer praise) {
		this.praise = praise;
	}

	public Integer getVisits() {
		return visits;
	}

	public void setVisits(Integer visits) {
		this.visits = visits;
	}

	public Integer getViewnum() {
		return viewnum;
	}

	public void setViewnum(Integer viewnum) {
		this.viewnum = viewnum;
	}

	/**
	 * 回帖显示
	 * @return
	 */
	private Date createTimes;
	
	private String message;
	
	private Integer sort;
	
	private String userNames;
	/**
	 * 时间差
	 */
	private Date difference;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}



	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getHuitieSum() {
		return huitieSum;
	}

	public void setHuitieSum(Integer huitieSum) {
		this.huitieSum = huitieSum;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public Date getCreateTimes() {
		return createTimes;
	}

	public void setCreateTimes(Date createTimes) {
		this.createTimes = createTimes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getUserNames() {
		return userNames;
	}

	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}

	public Date getDifference() {
		return difference;
	}

	public void setDifference(Date difference) {
		this.difference = difference;
	}	
}
