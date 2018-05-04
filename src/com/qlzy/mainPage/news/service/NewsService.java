package com.qlzy.mainPage.news.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.CarBrandType;
import com.qlzy.model.GoodsCat;
import com.qlzy.model.News;
import com.qlzy.model.Supply;
import com.qlzy.model.SupplyType;
import com.qlzy.model.TechnologyQuestion;
import com.qlzy.pojo.SessionInfo;

/**
 * @ClassName: NewsService
 * @Description: 
 * @author Huifeng Wang
 * @date 2013-5-7 下午1:07:25
 *
 */
public interface NewsService{
	/**
	* @Title: gainAll
	* @Description: 
	* @param @param news
	* @param @return    设定文件
	* @return List<News>    返回类型
	*/
	public List<News> gainAll(News news);
	/**
	* @Title: gainAllCount
	* @Description: 
	* @param @param news
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	public Long gainAllCount(News news);
	/**
	* @Title: add
	* @Description: TODO添加文章
	* @param @param news    设定文件
	* @return void    返回类型
	*/
	public void addNews(News news);
	/**
	* @Title: updateNews
	* @Description: 
	* @param @param news    设定文件
	* @return void    返回类型
	*/
	public void updateNews(News news);
	
	public Long gainNewsCountByNewsCatId(String id);
	/**
	* @Title: delete
	* @Description: 
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	public void delete(List<String> stringConvertList);
	/**
	* @Title: recover
	* @Description: 
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	public void recover(List<String> stringConvertList);
	/**
	* @Title: drop
	* @Description: 
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	public void drop(List<String> stringConvertList);
	/**
	* @Title: drop
	* @Description: 
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	/**
	* @Title: gainNewsById
	* @Description: 
	* @param @param id
	* @param @return    设定文件
	* @return News    返回类型
	*/
	public News gainNewsById(String id);
	/**
	* @Title: gainNewsForMainPage
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param news
	* @param @return    设定文件
	* @return List<News>    返回类型
	*/
	public List<News> gainNewsForMainPage(Map<String, Object> map);
	/**
	* @Title: gainNewsListByNewsCatName
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param parameter
	* @param @return    设定文件
	* @return List<News>    返回类型
	*/
	public List<News> gainNewsListByNewsCatNameForMain(Map<String, Object> map);
	/**
	* @Title: gainNewsListCountByNewsCatName
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return int    返回类型
	*/
	public Long gainNewsListCountByNewsCatNameForMain(Map<String, Object> map);
	/**
	* @Title: gainNewsForQPZX
	* @Description: TODO为汽配资讯导航栏查询信息
	* @param @param param
	* @param @return    设定文件
	* @return Collection<? extends News>    返回类型
	*/
	public List<News> gainNewsForQPZX(Map<String, Object> param);
	/**
	* @Title: gainNewsListByNewsCatNameForQpzx
	* @Description: 点击汽配资讯页面更多
	* @param @param map
	* @param @return    设定文件
	* @return List<?>    返回类型
	*/
	public List<News> gainNewsListByNewsCatNameForQpzx(Map<String, Object> map);
	/**
	* @Title: gainNewsListCountByNewsCatNameForQpzx
	* @Description: 点击汽配资讯页面更多,查询数量
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	public Long gainNewsListCountByNewsCatNameForQpzx(Map<String, Object> map);
	/**
	* @Title: gainNewsListCountByNewsCatNameForQpzx
	* @Description: 
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	public void updateNewsViewNumById(News news);
	
	public List<CarBrandType> gainAllList(CarBrandType carBrandType);
	public List<GoodsCat> gainFirstGoodsCatList(Integer i);
	public List<GoodsCat> gainNextGoodsCatByPid(String pid);
	public void save(Supply supply, SessionInfo sessionInfo);
	public List<SupplyType> gainAllSupplyType();
	public String gainSupplyTypeNameById(String parameter);
	public List<Supply> gainSupplyAll();
	public Supply gainSupplyById(String parameter);
	public List<Supply> gainSupplyNew(String string);
	public List<Supply> gainAllByType(Map<String, Object> map);
	public Long gainAllCountByType(Map<String, Object> map);
	public void updateSupplyViewNum(Supply s);
	/**
	 * @author HuifengWang
	 * @param map
	 * 根据二级新闻分类名称查询新闻列表(带分页)
	 */
	public List<News> gainNewsListByNewsCatNameWithPage(Map<String, Object> map);
	
	/**
	 * @author HuifengWang
	 * @param map
	 * 根据二级新闻分类名称查询新闻列表(不带分页)
	 */
	public List<News> gainNewsListByNewsCatNameWithOutPage(Map<String,Object> map);
	/**
	 * @author HuifengWang
	 * @param map
	 * 根据二级新闻分类名称查询新闻列表数量(带分页)
	 */
	public Long gainNewsListCountByNewsCatNameWithPage(Map<String, Object> map1);
	/**
	 * @author HuifengWang
	 * 获取技术答疑,根据答疑分类
	 * @param map1
	 * @return
	 */
	public List<TechnologyQuestion> gainJsdyListByCatNameWithPage(
			Map<String, Object> map1);
	/**
	 * @author HuifengWang
	 * 获取技术答疑数量
	 * @param map1
	 * @return
	 */
	public Long gainJsdyListCountByCatNameWithPage(Map<String, Object> map1);
	/**
	 * @author HuifengWang
	 * 根据父类新闻的Name查询所有孩子分类的新闻
	 * @param map
	 * @return
	 */
	public List<News> gainNewsListByParentCatNameWithPage(Map<String, Object> map);
	/**
	* @Title: searchAllNews
	* @Description: TODO(按条件按查询新闻)
	* @param @param map1
	* @param @return设定文件
	* @return List<?>返回类型
	* @throws
	*/
	public List<?> searchAllNews(Map<String, Object> map1);
	/**
	* @Title: searchAllNewsCount
	* @Description: TODO(按条件按查询新闻数目)
	* @param @param map1
	* @param @return设定文件
	* @return Long返回类型
	* @throws
	*/
	public Long searchAllNewsCount(Map<String, Object> map1);
	public List<News> gainNewShGongGaoList();
}
