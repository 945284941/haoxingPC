package com.qlzy.mainPage.floor.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.RegionsComRecommend;

public interface RegionsComRecommendMapper {
    
	/**
	 * @Title: gainRegionsComRecommendByShow
	 * @Description: TODO(查询首页设置显示的前三家区域商家推荐)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<RegionsComRecommend>    返回类型
	 * @author wangmei
	 */
    List<RegionsComRecommend> gainRegionsComRecommendByShow(Map<String, Object> map);
    
    /**
     * @Title: gainRegionsComRecommendByArea
     * @Description: TODO(根据当前分类与区域查询商家推荐列表)
     * @param @param map
     * @param @return    设定文件
     * @return List<RegionsComRecommend>    返回类型
     * @author wangmei
     */
    List<RegionsComRecommend> gainRegionsComRecommendByArea(Map<String, Object> map);
    
    /**
     * @Title: gainRegionsComRecommendCountByArea
     * @Description: TODO(获取总行数)
     * @param @param map
     * @param @return    设定文件
     * @return Long    返回类型
     * @author wangmei
     */
    Long gainRegionsComRecommendCountByArea(Map<String, Object> map);
    
    /**
     * @Title: gainRegionsComRecommendList
     * @Description: TODO(查询相关商家推荐列表)
     * @param @return    设定文件
     * @return List<RegionsComRecommend>    返回类型
     * @author wangmei
     */
    List<RegionsComRecommend> gainRegionsComRecommendList();
}