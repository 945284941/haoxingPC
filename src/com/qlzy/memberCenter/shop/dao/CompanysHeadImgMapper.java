package com.qlzy.memberCenter.shop.dao;

import java.util.List;

import com.qlzy.model.CompanysHeadImg;


public interface CompanysHeadImgMapper {
    int deleteByPrimaryKey(String id);

    int insert(CompanysHeadImg record);

    CompanysHeadImg selectByPrimaryKey(String id);


    int updateByPrimaryKey(CompanysHeadImg record);

	/**
	* @Title: gainCompanysHeadImgsByMember
	* @Description: TODO(根据memberID，查找广告列表)
	* @param @param string
	* @param @return    设定文件
	* @return List<CompanysHeadImg>    返回类型
	*/
	List<CompanysHeadImg> gainCompanysHeadImgsByMember(String string);

	/**
	* @Title: addCompanysHeadImg
	* @Description: TODO(添加广告管理)
	* @param @param companysHeadImg    设定文件
	* @return void    返回类型
	*/
	void addCompanysHeadImg(CompanysHeadImg companysHeadImg);

	/**
	* @Title: updateHeadImg
	* @Description: TODO(更新商品表头广告)
	* @param @param companysHeadImg    设定文件
	* @return void    返回类型
	*/
	void updateHeadImg(CompanysHeadImg companysHeadImg);

	/**
	* @Title: deleteHeadImg
	* @Description: TODO(删除图片)
	* @param @param companysHeadImg    设定文件
	* @return void    返回类型
	*/
	void deleteHeadImg(CompanysHeadImg companysHeadImg);
	
	/**
	 * @Title: gainCompanysHeadImgsByCompanyId
	 * @Description: TODO(商家店铺-获取头部广告列表)
	 * @param @param companyId
	 * @param @return    设定文件
	 * @return List<CompanysHeadImg>    返回类型
	 * @throws
	 * @author wangmei
	 */
	List<CompanysHeadImg> gainCompanysHeadImgsByCompanyId(String companyId);
}