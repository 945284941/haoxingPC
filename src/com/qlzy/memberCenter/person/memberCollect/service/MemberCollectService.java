/**  
* @Title: collectService.java
* @Package com.qlzy.memberCenter.person.collect.service
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-10-9 下午3:22:49
* @version V1.0  
*/
package com.qlzy.memberCenter.person.memberCollect.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Company;
import com.qlzy.model.MemberCollect;
import com.qlzy.model.Views;

/**
 * @ClassName: collectService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-10-9 下午3:22:49
 */
public interface MemberCollectService {

	/**
	 * 根据用户ID、用户类型、收藏的类型以及收藏时间查询收藏商品的条数
	* @Title: gainMemberCollectLong
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	* @author 周张豹
	*/
	public Long gainMemberCollectLong(Map<String, Object> map);

	/**
	 * 根据用户ID、用户类型、收藏的类型以及收藏时间查询收藏信息
	* @Title: gainMemberCollectList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return List<MemberCollect>    返回类型
	* @author 周张豹
	*/
	public List<MemberCollect> gainMemberCollectList(Map<String, Object> map);

	

	/**
	 * 根据用户ID、用户类型、收藏的类型以及收藏时间查询收藏店铺信息
	* @Title: gainMemberCollectShopList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return List<Company>    返回类型
	* @author 周张豹
	*/
	public List<Company> gainMemberCollectShopList(Map<String, Object> map);

	/**
	 * 根据用户ID、用户类型、浏览的类型以及浏览时间查询浏览的条数
	* @Title: gainMemberViewsLong
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	* @author 周张豹
	*/
	public Long gainMemberViewsLong(Map<String, Object> map);

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
	 * 增加浏览记录
	* @Title: insetMemberViews
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param memberCollect    设定文件
	* @return void    返回类型
	* @author 周张豹
	*/
	public void insetMemberViews(Views views);

	/**
	 * @Title insertSelective
	 * @Description TODO(添加收藏记录)
	 * @param memberCollect
	 * @author Jason
	 */
	public void insertSelective(MemberCollect memberCollect);

	/**
	 * @Title deleteMemberCollect
	 * @Description TODO(删除收藏记录)
	 * @param memberCollect
	 * @author Jason
	 */
	public void deleteMemberCollect(MemberCollect memberCollect);

	/**
	 * @Title findListByMemberCollect
	 * @Desctiption TODO(查看对于是否收藏了当前店铺)
	 * @param memberCollect
	 * @return
	 * @author Jason
	 */
	public List<MemberCollect> findListByMemberCollect(MemberCollect memberCollect);


}
