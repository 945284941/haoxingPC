package com.qlzy.mainPage.common.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Qixiuchang;

public interface QixiuchangMapper {
    
    /**
     * @Title: gainQixiuchangListForPage
     * @Description: TODO(查询所有汽修厂信息(带分页)) 
     * @param @param map
     * @param @return    设定文件 
     * @return List<Qixiuchang> 返回类型 
     * @author wangmei
     */
    List<Qixiuchang> gainQixiuchangListForPage(Map<String, Object> map);
    
    /**
     * @Title: gainAllCount
     * @Description: TODO(查询所有汽修厂的数量)
     * @param @param map
     * @param @return    设定文件 
     * @return Long 返回类型 
     * @author wangmei
     */
    Long gainAllCount(Map<String, Object> map);
}