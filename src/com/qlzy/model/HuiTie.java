package com.qlzy.model;


import java.util.Date;

import com.qlzy.util.Pagination;

import java.io.Serializable;

public class HuiTie extends Pagination implements Serializable {
	private static final long serialVersionUID = 1L;


	private String id;
	
	private String forumId;
	
	private String title;
	
	private Date createTime;
	
	private String message;
	
	private String pid;
	
	private Integer sort;
	
	private String userId;
	
	private String userName;
	
	private Integer viewnum;
	
	private Integer visit;
	/**
	 * 添加字段
	 */
	private Date createTimes;
	
	private String huitieSum;
	
	private String name;
	
	private String titles;
	
	private String userNames;
	
	private String messagees;
	
	private String userNamees;
	
	

	public String getMessagees() {
		return messagees;
	}

	public void setMessagees(String messagees) {
		this.messagees = messagees;
	}


	public String getUserNamees() {
		return userNamees;
	}

	public void setUserNamees(String userNamees) {
		this.userNamees = userNamees;
	}

	public Integer getVisit() {
		return visit;
	}

	public void setVisit(Integer visit) {
		this.visit = visit;
	}

	public String getUserNames() {
		return userNames;
	}

	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public Date getCreateTimes() {
		return createTimes;
	}

	public void setCreateTimes(Date createTimes) {
		this.createTimes = createTimes;
	}

	public String getHuitieSum() {
		return huitieSum;
	}

	public void setHuitieSum(String huitieSum) {
		this.huitieSum = huitieSum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getViewnum() {
		return viewnum;
	}

	public void setViewnum(Integer viewnum) {
		this.viewnum = viewnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
