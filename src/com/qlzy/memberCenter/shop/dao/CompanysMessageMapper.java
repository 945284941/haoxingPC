package com.qlzy.memberCenter.shop.dao;


import java.util.List;

import java.util.Map;


import com.qlzy.model.CompanysMessage;

public interface CompanysMessageMapper {
    int deleteByPrimaryKey(String id);

    int insert(CompanysMessage record);

    int updateByPrimaryKeySelective(CompanysMessage record);

    int updateByPrimaryKeyWithBLOBs(CompanysMessage record);

    int updateByPrimaryKey(CompanysMessage record);


	/**
	* @Title: gainCompanyMessageListById
	* @Description: TODO(得到商品留言列表)
	* @param @param string
	* @param @return    设定文件
	* @return List<CompanysMessage>    返回类型
	*/
	List<CompanysMessage> gainCompanyMessageListById(Map<String, Object> map);
	/**
	* @Title: gainCompanyMessageListByIdCount
	* @Description: TODO(留言数量)
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	Long gainCompanyMessageListByIdCount(Map<String, Object> map);
	/**
	* @Title: gainCustomerMessageById
	* @Description: TODO(得到客户留言信息)
	* @param @param id
	* @param @return    设定文件
	* @return CompanysMessage    返回类型
	*/
	CompanysMessage gainCustomerMessageById(String id);

    
    /**
     * @Title: gainById
     * @Description: TODO(根据留言ID查询留言详细信息)
     * @param @param id
     * @param @return    设定文件
     * @return CompanysMessage    返回类型
     * @author wangmei
     */
    CompanysMessage gainById(String id);
    
    /**
     * @Title: gainCompanysMessageListForPage
     * @Description: TODO(根据商家ID查询商家店铺客户留言列表信息(带分页))
     * @param @param map
     * @param @return    设定文件
     * @return List<CompanysMessage>    返回类型
     * @author wangmei
     */
    List<CompanysMessage> gainCompanysMessageListForPage(Map<String, Object> map);
    
    /**
     * @Title: gainCompanysMessageCount
     * @Description: TODO(根据商家ID查询客户留言列表的数量)
     * @param @param map
     * @param @return    设定文件
     * @return Long    返回类型
     * @author wangmei
     */
    Long gainCompanysMessageCount(Map<String, Object> map);

    /**
     * @Title: addCompanysMessage
     * @Description: TODO(添加留言)
     * @param @param companysMessage    设定文件
     * @return void    返回类型
     * @author wangmei
     */
    void addCompanysMessage(CompanysMessage companysMessage);

}