package com.qlzy.shanghui.head.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.qlzy.model.GoodsCat;
import com.qlzy.model.GoodsCatSh;
import com.qlzy.shanghui.head.dao.GoodsCatShMapper;
import com.qlzy.shanghui.head.service.CatalogueShService;

@Service("catalogueShService")
public class CatalogueShServiceImpl implements CatalogueShService {
	@Resource
	private GoodsCatShMapper goodsCatShMapper;

	@Override
	public List<GoodsCatSh> gainCatalogueShByGrade(int grade) {
		// TODO Auto-generated method stub
		List<GoodsCatSh> list =  goodsCatShMapper.gainCatalogueShByGrade(grade);
		return list;
	}

	@Override
	public List<GoodsCatSh> gainCatalogueShByPid(String pid) {
		// TODO Auto-generated method stub
		List<GoodsCatSh> list=null;
		//if(pid.length()==1){
			//list = goodsCatShMapper.gainCatalogueShByGrade(Integer.parseInt(pid));
		//}else{
			try {
				list = goodsCatShMapper.gainCatalogueShByPid(pid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
		//}
		return list;
	}

	@Override
	public List<GoodsCatSh> gainCatalogueShTByPid(String pid) {
		// TODO Auto-generated method stub
		List<GoodsCatSh> list=null;
		//if(pid.length()==1){
			//list = goodsCatShMapper.gainCatalogueShByGrade(Integer.parseInt(pid));
		//}else{
			try {
				list = goodsCatShMapper.gainCatalogueShByPid(pid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
		//}
		return list;
	}

}
