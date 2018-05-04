package com.qlzy.memberCenter.goods.dao;

import java.util.List;

import com.qlzy.model.GoodsSpecification;

public interface SpecificationMapper {
    /**
    * @Title: gainGoodsSpecifications
    * @Description: TODO获取规格列表
    * @param @param gs
    * @param @return    设定文件
    * @return List<GoodsSpecification>    返回类型
    */
    List<GoodsSpecification> gainGoodsSpecifications(GoodsSpecification gs);
    
    Long gainGoodsSpecificationsCount(GoodsSpecification gs);
    
    /**
    * @Title: gainGoodsSpecificationsByPid
    * @Description: TODO根据PID查询子列表
    * @param @param pid
    * @param @return    设定文件
    * @return List<GoodsSpecification>    返回类型
    */
    List<GoodsSpecification> gainGoodsSpecificationsByPid(String pid);
}