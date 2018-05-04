package com.qlzy.memberCenter.common.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Company;
import com.qlzy.model.Views;


public interface ViewsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Views record);

    int insertSelective(Views record);

    Views selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Views record);

    int updateByPrimaryKey(Views record);
    
    /**
     * @Title: ViewsMapper.java 
     * @Description: TODO(统计信息-浏览统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年) 
     * @param @param map
     * @param @return    设定文件 
     * @return Long 返回类型 
     * @author wangmei
     */
    Long gainBrowseStatisticsByTime(Map<String, Object> map);

	/**
	 * 根据用户ID、用户类型、浏览的类型以及浏览时间查询浏览商品信息
	* @Title: gainMemberViewsList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return List<MemberCollect>    返回类型
	* @author 周张豹
	*/
	public List<Views> gainMemberViewsList(Map<String, Object> map);

	/**
	 * 根据用户ID、用户类型、浏览的类型以及浏览时间查询浏览店铺信息
	* @Title: gainMemberViewsShopList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return List<Company>    返回类型
	* @author 周张豹
	*/
	public List<Company> gainMemberViewsShopList(Map<String, Object> map);

	/**
	 *  根据用户ID、用户类型、浏览的类型以及浏览时间查询浏览的条数
	* @Title: gainMemberViewsLong
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	* @author 周张豹
	*/
	public Long gainMemberViewsLong(Map<String, Object> map);
	
	/**
	 * 根据USERID、浏览ID、浏览类型查询<br>主要用于判断是否已经浏览该商品或者店铺或者文章
	* @Title: selectViewsLang
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param views
	* @param @return    设定文件
	* @return Integer    返回类型
	* @author 周张豹
	 */
	public Integer selectViewsLang(Views views);
	
	/**
	 * 根据USERID、浏览ID、浏览ID更新浏览的时间<br>主要用于已经浏览过的再次更新则更新一下浏览时间
	* @Title: updateViews
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param views    设定文件
	* @return void    返回类型
	* @author 周张豹
	 */
	public void updateViews(Views views);

	/**
	 * 浏览记录列表
	 * @author HuifengWang
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> gainViewOfNews(Map<String, Object> map);

	/**
	 * 浏览记录数量
	 * @author HuifengWang
	 * @param map
	 * @return
	 */
	Long gainViewCountOfNews(Map<String, Object> map);

	/**
	 * 批量删除
	 * @author HuifengWang
	 * @param stringConvertList
	 */
	void deleteBeach(List<String> stringConvertList);
	
	/**
	 * @Title: gainCustomerViewsStatisticsByTime
	 * @Description: TODO(统计信息-访问统计-客户浏览商品数(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainCustomerViewsStatisticsByTime(Map<String, Object> map);
	
}