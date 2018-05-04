package com.qlzy.memberCenter.shop.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.CompanysInfo;

public interface CompanysInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(CompanysInfo record);


    int updateByPrimaryKeySelective(CompanysInfo record);

    int updateByPrimaryKeyWithBLOBs(CompanysInfo record);

    int updateByPrimaryKey(CompanysInfo record);
    
    /**
     * @Title: gainCompanysInfoList
     * @Description: TODO(根据商家ID查询商家店铺首页资讯列表)
     * @param @param map
     * @param @return    设定文件
     * @return List<CompanysInfo>    返回类型
     * @author wangmei
     */
    List<CompanysInfo> gainCompanysInfoList(Map<String, Object> map);
    
    /**
     * @Title: gainCompanysInfoListForPage
     * @Description: TODO(商家店铺首页企业资讯，点击更多查询企业资讯列表(带分页))
     * @param @param map
     * @param @return    设定文件
     * @return List<CompanysInfo>    返回类型
     * @author wangmei
     */
    List<CompanysInfo> gainCompanysInfoListForPage(Map<String, Object> map);
    
    /**
     * @Title: gainCompanysInfoListCount
     * @Description: TODO(根据商家ID查询企业资讯的数量)
     * @param @param map
     * @param @return    设定文件
     * @return Long    返回类型
     * @author wangmei
     */
    Long gainCompanysInfoListCount(Map<String, Object> map);
    
    /**
     * @Title: gainById
     * @Description: TODO(根据资讯ID查询其详细信息)
     * @param @param id
     * @param @return    设定文件
     * @return CompanysInfo    返回类型
     * @author wangmei
     */
    CompanysInfo gainById(String id);
    
    /**
     * @Title: gainForAdjacent
     * @Description: TODO(查询资讯的上下篇)
     * @param @param map
     * @param @return    设定文件
     * @return CompanysInfo    返回类型
     * @throws
     * @author wangmei
     */
    CompanysInfo gainForAdjacent(Map<String, Object> map);

	/**
	* @Title: addCompanyInfo
	* @Description: TODO(添加咨询)
	* @param @param companysInfo    设定文件
	* @return void    返回类型
	*/
	void addCompanyInfo(CompanysInfo companysInfo);
	/**
	* @Title: addCompanyInfo
	* @Description: TODO(更新咨询)
	* @param @param companysInfo    设定文件
	* @return void    返回类型
	*/
	void updateCompanyInfo(CompanysInfo companysInfo);
	/**
	* @Title: deleteCompanyInfoList
	* @Description: TODO(删除咨询)
	* @param @param companysInfo    设定文件
	* @return void    返回类型
	*/
	void deleteCompanyInfoList(List list);
}