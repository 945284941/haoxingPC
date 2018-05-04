package com.qlzy.memberCenter.call.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Cart;
import com.qlzy.model.Company;
import com.qlzy.model.Member;
import com.qlzy.model.MemberCollect;

public interface MemberCollectMapper {
	/**
	 * 根据userId type查询收藏商品
	 * @param memberCollect
	 * @return
	 */
	List<MemberCollect> gainGoodsCollect(MemberCollect memberCollect);

	/**
	 * 根据userId type查询收藏店铺
	 * @param memberCollect
	 * @return
	 */
	List<MemberCollect> gainShopCollect(MemberCollect memberCollect);

	/**
	 * 取消收藏
	 * @param id
	 */
	public int deleteByPrimaryKey(String id);

	public void insert(MemberCollect record);

	public void insertSelective(MemberCollect record);

	/**
	 * @Title: updateByPrimaryKeySelective
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param cart    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void updateByPrimaryKeySelective(Cart cart);

	/**
	 * @Title: MemberCollectMapper.java
	 * @Description: TODO(统计信息-收藏统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainCollectStatisticsByTime(Map<String, Object> map);

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
	 * 根据用户ID、用户类型、收藏的类型以及收藏时间查询收藏的条数
	 * @Title: gainMemberCollectLong
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author 周张豹
	 */
	public Long gainMemberCollectLong(Map<String, Object> map);

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
	 * 根据USERID、收藏ID、收藏类型查询<br>主要用于判断是否已经收藏该商品或者店铺或者文章
	 * @Title: selectCollectLong
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param memberCollect
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @author 周张豹
	 */
	public Integer selectCollectLong(MemberCollect memberCollect);

	/**
	 * 根据USERID、收藏ID、收藏ID更新收藏的时间<br>主要用于已经收藏过的再次更新则更新一下收藏时间
	 * @Title: updateCollect
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param memberCollect    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void updateCollect(MemberCollect memberCollect);

	/**
	 * 获取文章收藏记录
	 * @author HuifengWang
	 * @param map
	 * @return
	 */
	public Long gainMemberCollectCountOfNews(Map<String, Object> map);

	/**
	 * 获取文章收藏记录数量
	 * @author HuifengWang
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> gainMemberCollectOfNews(Map<String, Object> map);

	public void deleteBeach(List<String> stringConvertList);

	/**
	 * @Title: gainCustomerCollectsStatisticsByTime
	 * @Description: TODO(统计信息-访问统计-客户收藏商品数(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainCustomerCollectsStatisticsByTime(Map<String, Object> map);

	/**
	 *  根据收藏商品ID/文章ID 查询被收藏的总数
	 * @Title: selectCollectByGoodsId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param goodsId
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @author 周张豹
	 */
	public Integer selectCollectByCollectId(String collectId);

	/**
	 * 根据当期登录人以及店铺的id和收藏的类型来删除
	 * @Title deleteMemberCollect
	 * @Description TODO(取消收藏)
	 * @param memberCollect
	 * @author Jason
	 */
    public void deleteMemberCollect(MemberCollect memberCollect);

	/**
	 * @Title: findListByMemberCollect
	 * @Description TODO(是否收藏了当前店铺)
	 * @param memberCollect
	 * @return
	 * @author Jason
	 */
	public List<MemberCollect> findListByMemberCollect(MemberCollect memberCollect);
}