package com.qlzy.mainPage.news.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.News;

public interface NewsMapper {
	/**
	* @Title: gainAll
	* @Description: 获取所有发布的文章信息
	* @param @param news
	* @param @return    设定文件
	* @return List<News>    返回类型
	*/
	List<News> gainAll(News news);

	/**
	* @Title: gainAllCount
	* @Description: 获得所有文章数量
	* @param @param news
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	Long gainAllCount(News news);

	/**
	* @Title: addNews
	* @Description: 添加文章
	* @param @param news    设定文件
	* @return void    返回类型
	*/
	void addNews(News news);

	/**
	* @Title: updateNews
	* @Description: 更新新闻
	* @param @param news    设定文件
	* @return void    返回类型
	*/
	void updateNews(News news);
	
	/**
	* @Title: gainNewsCountByNewsCatId
	* @Description: 根据新闻分类查询该新闻分类下新闻的数量
	* @param @param id
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	Long gainNewsCountByNewsCatId(String id);

	/**
	* @Title: delete
	* @Description: 批量删除新闻
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	void delete(List<String> stringConvertList);

	/**
	* @Title: recover
	* @Description: 批量恢复新闻
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	void recover(List<String> stringConvertList);

	/**
	* @Title: drop
	* @Description: 批量物理删除新闻
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	void drop(List<String> stringConvertList);

	/**
	* @Title: gainNewsById
	* @Description: 根据新闻ID查询新闻
	* @param @param id
	* @param @return    设定文件
	* @return News    返回类型
	*/
	News gainNewsById(String id);
	
	/**
	* @Title: gainNewsForMainPage
	* @Description: 点击主页,查询主页新闻列表
	* @param @param map
	* @param @return    设定文件
	* @return List<News>    返回类型
	*/
	List<News> gainNewsForMainPage(Map<String, Object> map);

	/**
	* @Title: gainNewsListByNewsCatName
	* @Description: 根据新闻分类,查询该分类下的列表
	* @param @param parameter
	* @param @return    设定文件
	* @return List<News>    返回类型
	*/
	List<News> gainNewsListByNewsCatNameForMain(Map<String, Object> map);

	/**
	* @Title: gainNewsListCountByNewsCatName
	* @Description: 根据新闻分类,查询该分类下新闻的数量
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	Long gainNewsListCountByNewsCatNameForMain(Map<String, Object> map);

	/**
	* @Title: gainNewsForQPZX
	* @Description: 点击首页汽配资讯,查询汽配资讯页面的新闻
	* @param @param param
	* @param @return    设定文件
	* @return List<News>    返回类型
	*/
	List<News> gainNewsForQPZX(Map<String, Object> param);

	/**
	* @Title: gainNewsListCountByNewsCatNameForQpzx
	* @Description: 点击汽配资讯页面更多,查询数量
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	Long gainNewsListCountByNewsCatNameForQpzx(Map<String, Object> map);

	/**
	* @Title: gainNewsListByNewsCatNameForQpzx
	* @Description: 点击汽配资讯页面更多
	* @param @param map
	* @param @return    设定文件
	* @return List<News>    返回类型
	*/
	List<News> gainNewsListByNewsCatNameForQpzx(Map<String, Object> map);


	void updateNewsViewById(News news);
	
	/**
	 * @Title: gainNewsStatisticsByTime
	 * @Description: TODO(统计信息-发布的新闻资讯数(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainNewsStatisticsByTime(Map<String, Object> map);

	/**
	* @Title: gaingainNewGongGaoByNameList
	* @Description: TODO(首页商城公告列表)
	* @param @param shangchenggonggao
	* @param @return设定文件
	* @return List<News>返回类型
	* @throws
	*/
	List<News> gaingainNewGongGaoByNameList(Map<String, Object> map);

	List<News> gainNewsListByNewsCatNameWithOutPage(Map<String, Object> map);

	List<News> gainNewsListByNewsCatNameWithPage(Map<String, Object> map);

	Long gainNewsListCountByNewsCatNameWithPage(Map<String, Object> map);

	List<News> gainNewsListByParentCatNameWithPage(Map<String, Object> map);

	/**
	* @Title: gainNewByNumCat
	* @Description: TODO(根据分类名称及需要的条数查找，非焦点)
	* @param @param zHAZ_ZHI_XINWEN
	* @param @param zHA_ZHI_NUM
	* @param @return设定文件
	* @return List<News>返回类型
	* @throws
	*/
	List<News> gainNewByNumCat(Map<String, Object> map);

	/**
	* @Title: gainNewByNumCatJiaoDian
	* @Description: TODO(焦点)
	* @param @param zHAZ_ZHI_XINWEN
	* @param @param zHA_ZHI_JIAODIAN_NUM
	* @param @return设定文件
	* @return List<News>返回类型
	* @throws
	*/
	List<News> gainNewByNumCatJiaoDian(Map<String, Object> map);

	/**
	* @Title: searchAllNews
	* @Description: TODO(查询所有新闻信息)
	* @param @param map1
	* @param @return设定文件
	* @return List<?>返回类型
	* @throws
	*/
	List<?> searchAllNews(Map<String, Object> map1);

	/**
	* @Title: searchAllNewsCount
	* @Description: TODO(查询所有新闻信息数目)
	* @param @param map1
	* @param @return设定文件
	* @return Long返回类型
	* @throws
	*/
	Long searchAllNewsCount(Map<String, Object> map1);


}