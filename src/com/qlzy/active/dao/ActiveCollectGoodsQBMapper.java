package com.qlzy.active.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.ActiveCollectGoodsQB;


public interface ActiveCollectGoodsQBMapper {
    
	/**
	 * 根据ID查询题库信息
	* @Title: selectByPrimaryKey
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return ActiveCollectGoodsQB    返回类型
	* @author 周张豹
	 */
    public ActiveCollectGoodsQB selectByPrimaryKey(String id);
    
    /**
     * 获取题库中所有的信息<br> 根据map的里面分类名称和品牌名称以及是否有车型数据的查询条件
    * @Title: selectAll
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @return    设定文件
    * @return List<ActiveCollectGoodsQB>    返回类型
    * @author 周张豹
     */
    public List<ActiveCollectGoodsQB> selectAll(Map<String, Object> map);

	/**
	 * 获取题库的总数量
	* @Title: gainActiveGoodsQBNum
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return Long    返回类型
	* @author 周张豹
	*/
	public Long gainActiveGoodsQBNum(Map<String, Object> map);

  
}