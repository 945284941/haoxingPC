package com.qlzy.mainPage.khzj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qlzy.mainPage.khzj.dao.KhcontentMapper;
import com.qlzy.mainPage.khzj.dao.KhzjMapper;
import com.qlzy.mainPage.khzj.service.KhzjService;
import com.qlzy.model.Khcontent;
import com.qlzy.model.Khzj;
@Service("khzjService")
public class KhzjServiceImpl implements KhzjService{
	@Resource
	private KhzjMapper khzjMapper;
	@Resource
	private KhcontentMapper khcontentMapper;
	@Override
	public List<Khcontent> gainKhzjContentAll() {
		// TODO Auto-generated method stub
		List<Khcontent> khcontentList = khcontentMapper.gainKhzjContentAll();
		
		return khcontentList;
	}

	@Override
	public List<Khzj> gainKhzjListByTel(String tpTelphone) {
		// TODO Auto-generated method stub
		List<Khzj> khazjList = khzjMapper.gainKhzjListByTel(tpTelphone);
		return khazjList;
	}

	@Override
	public Khcontent gainKhcontentById(String khContentid) {
		// TODO Auto-generated method stub
		Khcontent khcontent = khcontentMapper.gainKhcontentById(khContentid);
		return khcontent;
	}

	@Override
	public void updatekhzj(Khcontent khcontent, Khzj khzj1) {
		// TODO Auto-generated method stub
		khcontentMapper.updatePointSelective(khcontent);
		khzjMapper.insert(khzj1);
	}

	@Override
	public List<Khcontent> gainKhzjContentTop4() {
		// TODO Auto-generated method stub
		List<Khcontent> khcontentList = khcontentMapper.gainKhzjContentTop4();
		return khcontentList;
	}
	
}
