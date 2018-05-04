package com.qlzy.forum.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Forum;

public interface ForumMapper {

	List<Forum>gainHysqIndex(Map<String, Object> param);
	
    List<Forum> gainMoreForum(Map<String, Object> map);
	
	Long gainMoreForumCount(Map<String, Object> map);
	
	Forum gainForumById(String id);
	
	List<Forum> MyForum(Map<String, Object> param);
	
    List<Forum> MyForumList(Map<String, Object> map);
	
	Long MyForumListCount(Map<String, Object> map);
	
	void InsertForum(Forum forum);

	List<Forum> gainZuixin(int i);
	
	Forum selectById(Forum forum);
	
	void updateById(Forum forum);
	
	void updateByViewnums(Forum forum);
	
	Forum selectByForumId(Forum forum);
	void updateByHuiTieSum(Forum forum);
	
	Forum selectByShouCang(Forum forum);
	
	void updateByVisits(Forum forum);
}
