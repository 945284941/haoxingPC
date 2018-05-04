package com.qlzy.mainPage.floor.dao;

import java.util.List;

import com.qlzy.model.Adver;

public interface AdverMapper {
    
    /**
     * @Title: gainAdverByFloor
     * @Description: TODO(根据设置的广告位置查询其广告信息)
     * @param @param adver
     * @param @return    设定文件
     * @return List<Adver>    返回类型
     */
    public List<Adver> gainAdverByFloor(Adver adver);
}