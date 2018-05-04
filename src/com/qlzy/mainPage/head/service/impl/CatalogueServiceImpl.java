/**
 * 
 */
package com.qlzy.mainPage.head.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.qlzy.common.tools.ResourceUtil;
import org.springframework.stereotype.Service;
import com.qlzy.common.constant.SysSetting;
import com.qlzy.mainPage.floor.dao.HomeSysMapper;
import com.qlzy.mainPage.head.dao.GoodsCatMapper;
import com.qlzy.mainPage.head.service.CatalogueService;
import com.qlzy.mainPage.news.dao.NewsMapper;
import com.qlzy.model.GoodsCat;
import com.qlzy.model.HomeSys;
import com.qlzy.model.News;

/**
 * @author 赵阳彬
 *
 */
@Service("catalogueService")
public class CatalogueServiceImpl implements CatalogueService{
	
	@Resource
	private GoodsCatMapper goodsCatMapper;
	@Resource
	private NewsMapper newsMapper;
	@Resource
	private HomeSysMapper homeSysMapper;
	@Override
	public List<GoodsCat> gainCatalogueByGrade(Integer grade) {
		List<GoodsCat> list =  goodsCatMapper.gainCatalogueByGrade(grade);
		return list;
	}
	
	@Override
	public List<GoodsCat> gainCatalogueByPid(String pid) {
		List<GoodsCat> list;
		if(pid.length()==1){
		list = goodsCatMapper.gainCatalogueByGrade(Integer.parseInt(pid));
		}else{
		 list = goodsCatMapper.gainCatalogueByPid(pid);
		}
		return list;
	}

	/***
	 * 根据分类查询相关分类
	 * @return
     */
	@Override
	public List<GoodsCat> queryFullCategory(String type) {
		List<GoodsCat> list  = null;
		String catId = "";
		if("gwsc".equals(type.trim())){
			catId = ResourceUtil.getShoppingId();
		}
		//团多多和限时抢购都查询商城分类
		if("xsqg".equals(type.trim()) || "tdd".equals(type.trim()) || "qg".equals(type.trim())){
			catId = ResourceUtil.getShoppingId();
		}
		if("cs".equals(type.trim())){
			catId = ResourceUtil.getShoppingId();
		}
		if("jcsb".equals(type.trim())){
			catId = ResourceUtil.getBuildingId();
		}
		Map<String,String> parmMap = new HashMap<>();
		parmMap.put("catType",type);
		parmMap.put("pid",catId);
		list = goodsCatMapper.gainCatalogueByPidAndSort(parmMap);
		for (GoodsCat cat : list) {
			parmMap.put("pid",cat.getId());
			List<GoodsCat> subCatList = goodsCatMapper.gainCatalogueByPidAndSort(parmMap);
			cat.setSubCatList(subCatList);
			if (null != subCatList) {
				for (GoodsCat c : subCatList) {
					parmMap.put("pid",c.getId());
					List<GoodsCat> threeCatList = goodsCatMapper.gainCatalogueByPidAndSort(parmMap);
					c.setThreeCatList(threeCatList);
				}
			}
		}
		return list;
	}


	@Override
	public List<News> gainNewGongGaoList() {
		// TODO Auto-generated method stub
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("newsCatId", "0");
		map.put("pageNum", 5);
		return newsMapper.gaingainNewGongGaoByNameList(map);
	}


	@Override
	public List<HomeSys> gainLunbotu() {
		// TODO Auto-generated method stub
		return homeSysMapper.gainLunbotu();
	}

	/***
	 * 轮播图 购物商城
	 * @param type
	 * @return
     */
	@Override
	public List<HomeSys> gainLunbotuByShop(String type) {
		return homeSysMapper.gainLunbotuByType(type);
	}

	@Override
	public List<HomeSys> gainLunbotuByMarket(String type) {
		return homeSysMapper.gainLunbotuByType(type);
	}

	@Override
	public List<GoodsCat> gainCatalogueByPidAndSort(Map<String, String> shopMap) {
		return goodsCatMapper.gainCatalogueByPidAndSort(shopMap);
	}

}
