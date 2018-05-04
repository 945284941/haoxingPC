package com.qlzy.memberCenter.news.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlzy.memberCenter.call.dao.MemberCollectMapper;
import com.qlzy.memberCenter.common.dao.ViewsMapper;
import com.qlzy.memberCenter.news.service.CenterNewsService;

@Service
public class CenterNewsServiceImpl implements CenterNewsService{
	
	@Autowired
	private MemberCollectMapper memberCollectMapper;
	
	@Autowired
	private ViewsMapper viewsMapper;

	@Override
	public List<Map<String,Object>> gainMemberCollectOfNews(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return memberCollectMapper.gainMemberCollectOfNews(map);
	}

	@Override
	public Long gainMemberCollectCountOfNews(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return memberCollectMapper.gainMemberCollectCountOfNews(map);
	}

	@Override
	public void deleteWzsc(List<String> stringConvertList) {
		memberCollectMapper.deleteBeach(stringConvertList);
	}

	@Override
	public List<Map<String, Object>> gainViewOfNews(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return viewsMapper.gainViewOfNews(map);
	}

	@Override
	public Long gainViewCountOfNews(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return viewsMapper.gainViewCountOfNews(map);
	}

	@Override
	public void deleteLljl(List<String> stringConvertList) {
		viewsMapper.deleteBeach(stringConvertList);
	}

}
