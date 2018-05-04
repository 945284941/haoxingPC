package com.qlzy.forum.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.forum.dao.ForumMapper;
import com.qlzy.forum.service.ForumService;
import com.qlzy.model.Forum;
@Service("forumService")
@Transactional(rollbackFor=Exception.class)
public class ForumServiceImpl implements ForumService{
	@Autowired
	private ForumMapper forumMapper;

	@Override
	public List<Forum> gainHysqIndex(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return forumMapper.gainHysqIndex(param);
	}

	@Override
	public List<Forum> gainMoreForum(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return forumMapper.gainMoreForum(map);
	}

	@Override
	public Long gainMoreForumCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return forumMapper.gainMoreForumCount(map);
	}

	@Override
	public Forum gainForumById(String id) {
		// TODO Auto-generated method stub
		return forumMapper.gainForumById(id);
	}

	@Override
	public List<Forum> MyForum(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return forumMapper.MyForum(param);
	}

	@Override
	public List<Forum> MyForumList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return forumMapper.MyForumList(map);
	}

	@Override
	public Long MyForumListCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return forumMapper.MyForumListCount(map);
	}

	@Override
	public void InsertForum(Forum forum) {
		// TODO Auto-generated method stub
		forumMapper.InsertForum(forum);
	}

	@Override
	public List<Forum> gainZuixin(int i) {
		// TODO Auto-generated method stub
		return forumMapper.gainZuixin(i);
	}

	@Override
	public Forum selectById(Forum forum) {
		// TODO Auto-generated method stub
		return forumMapper.selectById(forum);
	}

	@Override
	public void updateById(Forum forum) {
		// TODO Auto-generated method stub
		forumMapper.updateById(forum);
	}

	@Override
	public void updateByViewnums(Forum forum) {
		// TODO Auto-generated method stub
		forumMapper.updateByViewnums(forum);
	}

	@Override
	public Forum selectByForumId(Forum forum) {
		// TODO Auto-generated method stub
		return forumMapper.selectByForumId(forum);
	}

	@Override
	public void updateByHuiTieSum(Forum forum) {
		// TODO Auto-generated method stub
		forumMapper.updateByHuiTieSum(forum);
	}

	@Override
	public Forum selectByShouCang(Forum forum) {
		// TODO Auto-generated method stub
		return forumMapper.selectByShouCang(forum);
	}

	@Override
	public void updateByVisits(Forum forum) {
		// TODO Auto-generated method stub
		forumMapper.updateByVisits(forum);
	}
	
}
