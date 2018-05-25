package com.qlzy.mainPage.news.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.common.constant.SysSetting;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.head.dao.GoodsCatMapper;
import com.qlzy.mainPage.news.dao.CarBrandTypeMapper;
import com.qlzy.mainPage.news.dao.NewsMapper;
import com.qlzy.mainPage.news.dao.SupplyMapper;
import com.qlzy.mainPage.news.dao.SupplyTypeMapper;
import com.qlzy.mainPage.news.service.NewsService;
import com.qlzy.mainPage.school.dao.TechnologyQuestionMapper;
import com.qlzy.model.CarBrandType;
import com.qlzy.model.GoodsCat;
import com.qlzy.model.News;
import com.qlzy.model.Supply;
import com.qlzy.model.SupplyType;
import com.qlzy.model.TechnologyQuestion;
import com.qlzy.pojo.SessionInfo;

/**
 * @ClassName: NewsServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Huifeng Wang
 * @date 2013-5-7 下午1:07:35
 *
 */
@Service("newsService")
@Transactional(rollbackFor=Exception.class)
public class NewsServiceImpl implements NewsService{

	@Autowired
	private NewsMapper newsMapper;

	@Autowired
	private CarBrandTypeMapper carBrandTypeMapper; 
	@Autowired
	private GoodsCatMapper goodsCatMapper;
	@Autowired
	private SupplyMapper supplyMapper;
	@Autowired
	private SupplyTypeMapper supplyTypeMapper;
	@Autowired
	private TechnologyQuestionMapper technologyQuestionMapper;
	
	/**
	* @Title: gainAll
	* @Description: TODO获取所有发布的新闻信息
	* @param @param news
	* @param @return    设定文件
	* @return List<News>    返回类型
	*/
	public List<News> gainAll(News news) {
		// TODO Auto-generated method stub
		return newsMapper.gainAll(news);
	}

	/**
	* @Title: gainAllCount
	* @Description: TODO获得数量
	* @param @param news
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	public Long gainAllCount(News news) {
		// TODO Auto-generated method stub
		return newsMapper.gainAllCount(news);
	}

	/* (非 Javadoc)
	* <p>Title: add</p>
	* <p>Description: </p>
	* @param news
	* @see com.gx.news.service.NewsService#add(com.gx.model.News)
	*/
	@Override
	public void addNews(News news) {
		newsMapper.addNews(news);
	}

	/* (非 Javadoc)
	* <p>Title: updateNews</p>
	* <p>Description: </p>
	* @param news
	* @see com.gx.news.service.NewsService#updateNews(com.gx.model.News)
	*/
	@Override
	public void updateNews(News news) {
		newsMapper.updateNews(news);
	}

	public Long gainNewsCountByNewsCatId(String id){
		return newsMapper.gainNewsCountByNewsCatId(id);
	}

	/* (非 Javadoc)
	* <p>Title: delete</p>
	* <p>Description: </p>
	* @param stringConvertList
	* @see com.gx.news.service.NewsService#delete(java.util.List)
	*/
	@Override
	public void delete(List<String> stringConvertList) {
		newsMapper.delete(stringConvertList);
	}

	/* (非 Javadoc)
	* <p>Title: recover</p>
	* <p>Description: </p>
	* @param stringConvertList
	* @see com.gx.news.service.NewsService#recover(java.util.List)
	*/
	@Override
	public void recover(List<String> stringConvertList) {
		newsMapper.recover(stringConvertList);
	}

	/* (非 Javadoc)
	* <p>Title: drop</p>
	* <p>Description: </p>
	* @param stringConvertList
	* @see com.gx.news.service.NewsService#drop(java.util.List)
	*/
	@Override
	public void drop(List<String> stringConvertList) {
		newsMapper.drop(stringConvertList);
	}

	/* (非 Javadoc)
	* <p>Title: gainNewsById</p>
	* <p>Description: </p>
	* @param id
	* @return
	* @see com.gx.news.service.NewsService#gainNewsById(java.lang.String)
	*/
	@Override
	public News gainNewsById(String id) {
		return newsMapper.gainNewsById(id);
	}


	/* (非 Javadoc)
	* <p>Title: gainNewsForMainPage</p>
	* <p>Description: </p>
	* @param map
	* @return
	* @see com.qlzy.mainPage.news.service.NewsService#gainNewsForMainPage(java.util.Map)
	*/
	@Override
	public List<News> gainNewsForMainPage(Map<String,Object> map) {
		return newsMapper.gainNewsForMainPage(map);
	}

	/* (非 Javadoc)
	* <p>Title: gainNewsListByNewsCatName</p>
	* <p>Description: </p>
	* @param parameter
	* @return
	* @see com.qlzy.mainPage.news.service.NewsService#gainNewsListByNewsCatName(java.lang.String)
	*/
	@Override
	public List<News> gainNewsListByNewsCatNameForMain(Map<String,Object> map) {
		return newsMapper.gainNewsListByNewsCatNameForMain(map);
	}

	/* (非 Javadoc)
	* <p>Title: gainNewsListCountByNewsCatName</p>
	* <p>Description: </p>
	* @param map
	* @return
	* @see com.qlzy.mainPage.news.service.NewsService#gainNewsListCountByNewsCatName(java.util.Map)
	*/
	@Override
	public Long gainNewsListCountByNewsCatNameForMain(Map<String, Object> map) {
		return newsMapper.gainNewsListCountByNewsCatNameForMain(map);
	}

	/* (非 Javadoc)
	* <p>Title: gainNewsForQPZX</p>
	* <p>Description: </p>
	* @param param
	* @return
	* @see com.qlzy.mainPage.news.service.NewsService#gainNewsForQPZX(java.util.Map)
	*/
	@Override
	public List<News> gainNewsForQPZX(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return newsMapper.gainNewsForQPZX(param);
	}

	/* (非 Javadoc)
	* <p>Title: gainNewsListByNewsCatNameForQpzx</p>
	* <p>Description: </p>
	* @param map
	* @return
	* @see com.qlzy.mainPage.news.service.NewsService#gainNewsListByNewsCatNameForQpzx(java.util.Map)
	*/
	@Override
	public List<News> gainNewsListByNewsCatNameForQpzx(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return newsMapper.gainNewsListByNewsCatNameForQpzx(map);
	}

	/* (非 Javadoc)
	* <p>Title: gainNewsListCountByNewsCatNameForQpzx</p>
	* <p>Description: </p>
	* @param map
	* @return
	* @see com.qlzy.mainPage.news.service.NewsService#gainNewsListCountByNewsCatNameForQpzx(java.util.Map)
	*/
	@Override
	public Long gainNewsListCountByNewsCatNameForQpzx(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return newsMapper.gainNewsListCountByNewsCatNameForQpzx(map);
	}

	@Override
	public void updateNewsViewNumById(News news) {
		 newsMapper.updateNewsViewById(news);
	}
	
	@Override
	public List<CarBrandType> gainAllList(CarBrandType carBrandType) {
		
		return carBrandTypeMapper.gainAllList(carBrandType);
	}
	@Override
	public List<GoodsCat> gainFirstGoodsCatList(Integer i) {
		
		return goodsCatMapper.gainCatalogueByGrade(i);
	}

	@Override
	public List<GoodsCat> gainNextGoodsCatByPid(String pid) {
		return goodsCatMapper.gainCatalogueByPid(pid);
	}
	@Override
	public void save(Supply supply, SessionInfo sessionInfo) {
		supply.setId(ToolsUtil.getUUID());
		supply.setCreatetime(new Date());
		supply.setUserId(sessionInfo.getUserId());
		supplyMapper.insertSelective(supply);
	}

	@Override
	public List<SupplyType> gainAllSupplyType() {
		
		return supplyTypeMapper.gainAllSupplyType();
	}

	@Override
	public String gainSupplyTypeNameById(String parameter) {
		
		return supplyTypeMapper.gainSupplyTypeNameById(parameter);
	}

	@Override
	public List<Supply> gainSupplyAll() {
		
		return supplyMapper.gainSupplyAll();
	}
	@Override
	public Supply gainSupplyById(String parameter) {
		
		return supplyMapper.selectByPrimaryKey(parameter);
	}
	@Override
	public List<Supply> gainSupplyNew(String string) {
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("status", string);
		return supplyMapper.gainSupplyNew(map);
	}
	@Override
	public List<Supply> gainAllByType(Map<String, Object> map) {
		
		return supplyMapper.gainAllByType(map);
	}
	@Override
	public Long gainAllCountByType(Map<String, Object> map) {
		
		return supplyMapper.gainAllCountByType(map);
	}
	@Override
	public void updateSupplyViewNum(Supply s) {
		supplyMapper.updateSupplyViewNum(s);
	}

	@Override
	public List<News> gainNewsListByNewsCatNameWithPage(Map<String, Object> map) {
		return newsMapper.gainNewsListByNewsCatNameWithPage(map);
	}

	@Override
	public List<News> gainNewsListByNewsCatNameWithOutPage(Map<String, Object> map) {
		return newsMapper.gainNewsListByNewsCatNameWithOutPage(map);
	}

	@Override
	public Long gainNewsListCountByNewsCatNameWithPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return newsMapper.gainNewsListCountByNewsCatNameWithPage(map);
	}

	@Override
	public List<TechnologyQuestion> gainJsdyListByCatNameWithPage(
			Map<String, Object> map1) {
		// TODO Auto-generated method stub
		return technologyQuestionMapper.gainJsdyListByCatNameWithPage(map1);
	}

	@Override
	public Long gainJsdyListCountByCatNameWithPage(Map<String, Object> map1) {
		// TODO Auto-generated method stub
		return technologyQuestionMapper.gainJsdyListCountByCatNameWithPage(map1);
	}

	@Override
	public List<News> gainNewsListByParentCatNameWithPage(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return newsMapper.gainNewsListByParentCatNameWithPage(map);
	}

	@Override
	public List<?> searchAllNews(Map<String, Object> map1) {
		// TODO Auto-generated method stub
		return newsMapper.searchAllNews(map1);
	}

	@Override
	public Long searchAllNewsCount(Map<String, Object> map1) {
		// TODO Auto-generated method stub
		return newsMapper.searchAllNewsCount(map1);
	}

	@Override
	public List<News> gainNewShGongGaoList() {
		// TODO Auto-generated method stub
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("catName", SysSetting.shgonggao);
		map.put("pageNum", 4);
		return newsMapper.gaingainNewGongGaoByNameList(map);
	}

	@Override
	public List<News> newListByPage(News news) {
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("newsCatId", "41302a038a5449c985f429a4b1e397a5");
		map.put("pageNum", 5);
		return newsMapper.gaingainNewGongGaoByNameList(map);
		//return newsMapper.newListByPage(news);
	}

	@Override
	public Long newCount(News news) {
		return newsMapper.newCount(news);
	}

	@Override
	public News newDetail(News news) {
		return newsMapper.newDetail(news);
	}
}
