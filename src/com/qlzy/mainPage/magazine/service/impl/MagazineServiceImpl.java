/**??
* @Title: MagazineServiceImpl.java
* @Package magazine.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author zhao yang bin
* @date 2013-11-2 下午2:23:47
* @version V1.0??
*/
package com.qlzy.mainPage.magazine.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlzy.common.constant.SysSetting;
import com.qlzy.mainPage.magazine.dao.MagazineMessageMapper;
import com.qlzy.mainPage.magazine.service.MagazineService;
import com.qlzy.mainPage.news.dao.NewsMapper;
import com.qlzy.model.MagazineMessage;
import com.qlzy.model.News;


/**
 * @ClassName: MagazineServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhao yang bin
 * @date 2013-11-2 下午2:23:47
 *
 */
@Service("magazineService")
public class MagazineServiceImpl implements MagazineService{
	
	@Autowired
	private NewsMapper newsMapper;
	@Autowired
	private MagazineMessageMapper magazineMessageMapper;
	
	@Override
	public Map<String, List<News>> gainLeftMagazineList() {
		Map<String,List<News>> mapList = new HashMap<String, List<News>>();
		List<News> list = new ArrayList<News>();
		Map<String ,Object> map = new HashMap<String, Object>();
		//新闻动态
		map.put("newsCatName",SysSetting.ZHAZ_ZHI_XINWEN );
		map.put("rowsNum",SysSetting.ZHA_ZHI_NUM);
		map.put("rowsNumJiaodian",SysSetting.ZHA_ZHI_JIAODIAN_NUM);
		list = newsMapper.gainNewByNumCat(map);
		mapList.put("list_xinwen",list);
		list = newsMapper.gainNewByNumCatJiaoDian(map);
		mapList.put("list_xinwen_jiaodian",list);
		//策划
		map.put("newsCatName",SysSetting.ZHAZ_ZHI_CEHUA );
		list = newsMapper.gainNewByNumCat(map);
		mapList.put("list_cehua",list);
		list = newsMapper.gainNewByNumCatJiaoDian(map);
		mapList.put("list_cehua_jiaodian",list);
		//市场行情
		map.put("newsCatName",SysSetting.ZHAZ_ZHI_SHICHANG);
		list = newsMapper.gainNewByNumCat(map);
		mapList.put("list_shichang",list);
		list = newsMapper.gainNewByNumCatJiaoDian(map);
		mapList.put("list_shichang_jiaodian",list);
		//人物专访
		map.put("newsCatName",SysSetting.ZHAZ_ZHI_RENWU);
		list = newsMapper.gainNewByNumCat(map);
		mapList.put("list_renwu",list);
		list = newsMapper.gainNewByNumCatJiaoDian(map);
		mapList.put("list_remwu_jiaodian",list);
		//政策解读
		map.put("newsCatName",SysSetting.ZHAZ_ZHI_ZHENGCE);
		list = newsMapper.gainNewByNumCat(map);
		mapList.put("list_zhengce",list);
		list = newsMapper.gainNewByNumCatJiaoDian(map);
		mapList.put("list_zhengce_jiaodian",list);
		//厂商展台
		map.put("newsCatName",SysSetting.ZHAZ_ZHI_CHANGSHANG);
		list = newsMapper.gainNewByNumCat(map);
		mapList.put("list_changshang",list);
		list = newsMapper.gainNewByNumCatJiaoDian(map);
		mapList.put("list_changshang_jiaodian",list);
		//供求信息
		map.put("newsCatName",SysSetting.ZHAZ_ZHI_GONGQIU);
		list = newsMapper.gainNewByNumCat(map);
		mapList.put("list_gongqiu",list);
		list = newsMapper.gainNewByNumCatJiaoDian(map);
		mapList.put("list_gongqiu_jiaodian",list);
		//重配学院
		map.put("newsCatName",SysSetting.ZHAZ_ZHI_ZHONGPEI);
		list = newsMapper.gainNewByNumCat(map);
		mapList.put("list_zhongpei",list);
		list = newsMapper.gainNewByNumCatJiaoDian(map);
		mapList.put("list_zhongpei_jiaodian",list);
		//乐活
		map.put("newsCatName",SysSetting.ZHAZ_ZHI_LEIHUO);
		list = newsMapper.gainNewByNumCat(map);
		mapList.put("list_lehuo",list);
		list = newsMapper.gainNewByNumCatJiaoDian(map);
		mapList.put("list_lehuo_jiaodian",list);
		return mapList;
	}

	@Override
	public List<MagazineMessage> gainMagazineList() {
		return magazineMessageMapper.gainMagazineList();
	}

}
