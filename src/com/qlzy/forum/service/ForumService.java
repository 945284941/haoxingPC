package com.qlzy.forum.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Forum;

public interface ForumService {

	public List<Forum> gainHysqIndex(Map<String, Object> param);
	
	public List<Forum> gainMoreForum(Map<String, Object> map);
	
	public Long gainMoreForumCount(Map<String, Object> map);
	
	Forum gainForumById(String id);
	
	public List<Forum> MyForum(Map<String, Object> param);
	
	public List<Forum>MyForumList(Map<String, Object> map);
	
	public Long MyForumListCount(Map<String, Object> map);
	
	void InsertForum(Forum forum);

	public List<Forum> gainZuixin(int i);
	
	Forum selectById(Forum forum);
	
	void updateById(Forum forum);
	
	void updateByViewnums(Forum forum);
	
	Forum selectByForumId(Forum forum);
	
	void updateByHuiTieSum(Forum forum);
	
	Forum selectByShouCang(Forum forum);
	
	void updateByVisits(Forum forum);
}
