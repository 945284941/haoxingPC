package com.qlzy.zp.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlzy.model.ZpCompany;
import com.qlzy.model.ZpMessage;
import com.qlzy.zp.dao.ZpCompanyMapper;
import com.qlzy.zp.dao.ZpMessageMapper;
import com.qlzy.zp.service.ZpMessageService;

@Service("zpMessageService")
public class ZpMessageServiceImpl implements ZpMessageService{
	@Autowired
	private ZpMessageMapper zpMessageMapper;
	@Autowired
	private ZpCompanyMapper zpCompanyMapper;
	@Override
	public ZpMessage gainZpMessage() {
		// TODO Auto-generated method stub
		
		return zpMessageMapper.selectAll();
	}
	@Override
	public ZpCompany gainCompany() {
		// TODO Auto-generated method stub
		return zpCompanyMapper.gainZpCompany();
	}
	@Override
	public List<ZpMessage> gainZpMessageList() {
		// TODO Auto-generated method stub
		return zpMessageMapper.gainZpMessageList();
	}
	@Override
	public ZpMessage gainZpMessageById(String zpId) {
		// TODO Auto-generated method stub
		return zpMessageMapper.selectById(zpId);
	}

	

}
