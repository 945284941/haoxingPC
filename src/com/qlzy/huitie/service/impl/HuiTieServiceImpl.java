package com.qlzy.huitie.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.huitie.dao.HuiTieMapper;
import com.qlzy.huitie.service.HuiTieService;
import com.qlzy.model.HuiTie;
@Service("huiTieService")
@Transactional(rollbackFor=Exception.class)
public class HuiTieServiceImpl implements HuiTieService{
	@Autowired
	private HuiTieMapper huiTieMapper;
	@Override
	public HuiTie gainHuiTieById(String id) {
		// TODO Auto-generated method stub
		return huiTieMapper.gainHuiTieById(id);
	}
	@Override
	public void updateViewNumById(HuiTie huiTie) {
		// TODO Auto-generated method stub
		huiTieMapper.updateViewNumById(huiTie);
	}
	@Override
	public List<HuiTie> gainHuiTieIndex(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return huiTieMapper.gainHuiTieIndex(param);
	}
	@Override
	public List<HuiTie> gainHuiTieListById(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return huiTieMapper.gainHuiTieListById(map);
	}
	@Override
	public Long gainHuiTieListByIdCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return huiTieMapper.gainHuiTieListByIdCount(map);
	}
	@Override
	public void InsertHuiTie(HuiTie huiTie) {
		// TODO Auto-generated method stub
		huiTieMapper.InsertHuiTie(huiTie);
	}
	@Override
	public List<HuiTie> MyHuiTie(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return huiTieMapper.MyHuiTie(param);
	}
	@Override
	public List<HuiTie> MyHuiTieList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return huiTieMapper.MyHuiTieList(map);
	}
	@Override
	public Long MyHuiTieListCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return huiTieMapper.MyHuiTieListCount(map);
	}
	@Override
	public HuiTie selectById(HuiTie huiTie) {
		// TODO Auto-generated method stub
		return huiTieMapper.selectById(huiTie);
	}
	@Override
	public void updateById(HuiTie huiTie) {
		// TODO Auto-generated method stub
		huiTieMapper.updateById(huiTie);
	}

}
