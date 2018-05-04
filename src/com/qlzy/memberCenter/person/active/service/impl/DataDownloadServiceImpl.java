package com.qlzy.memberCenter.person.active.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlzy.memberCenter.person.active.dao.DataDownloadMapper;
import com.qlzy.memberCenter.person.active.service.DataDownloadService;
import com.qlzy.model.DataDownload;

@Service
public class DataDownloadServiceImpl implements DataDownloadService{
	@Autowired
	private DataDownloadMapper dataDownloadMapper;
	@Override
	public List<DataDownload> gainDataloadList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dataDownloadMapper.gainDataloadList(map);
	}
	@Override
	public Long gainDataloadListCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dataDownloadMapper.gainDataloadListCount(map);
	}
	@Override
	public void deleteDataDownloadByIds(String dataDownloadIds) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		String[] ids=dataDownloadIds.split(",");
		for (int i = 0; i < ids.length; i++) {
			list.add(ids[i]);
		}
		dataDownloadMapper.deleteDataDownloadByIds(list);
	}

}
