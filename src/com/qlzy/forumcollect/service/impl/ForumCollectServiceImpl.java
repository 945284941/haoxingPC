package com.qlzy.forumcollect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.forumcollect.dao.ForumCollectMapper;
import com.qlzy.forumcollect.service.ForumCollectService;
import com.qlzy.model.ForumCollect;
@Service("forumCollectService")
@Transactional(rollbackFor=Exception.class)
public class ForumCollectServiceImpl implements ForumCollectService{
	@Autowired
	private ForumCollectMapper forumCollectMapper;

	@Override
	public void addCollect(ForumCollect forumCollect) {
		// TODO Auto-generated method stub
		forumCollectMapper.addCollect(forumCollect);
	}
}
