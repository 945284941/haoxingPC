/**  
 * @Title: RegionsService.java 
 * @Package com.qlzy.mainPage.service 
 * @Description: TODO(地区接口类)
 * @author wangmei  
 * @date 2013-5-8 上午11:34:07
 * @version V1.0  
 */
package com.qlzy.memberCenter.shop.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Company;
import com.qlzy.model.CompanySys;
import com.qlzy.model.CompanysGoodsCat;
import com.qlzy.model.CompanysHeadImg;
import com.qlzy.model.CompanysInfo;
import com.qlzy.model.CompanysMessage;


public interface MemberManageService {

	/**
	* @Title: gainGoodsCatList
	* @Description: TODO(根据用户id，查找CompanysGoodsCat列表)
	* @param @param memberIdString
	* @param @return    设定文件
	* @return List<CompanysGoodsCat>    返回类型
	*/
	List<CompanysGoodsCat> gainGoodsCatList(String memberIdString);

	/**
	* @Title: dropById
	* @Description: TODO(删除商品分类)
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	Long dropById(Map<String, Object>  map);

	/**
	* @Title: updateGoodsCat
	* @Description: TODO(更新分类排序)
	* @param @param map    设定文件
	* @return void    返回类型
	*/
	void updateGoodsCat(Map<String, Object> map);

	/**
	* @Title: gainGoodsCatListShop
	* @Description: TODO(得到shop的商品分类，除去店铺本身存在的分类)
	* @param @param memberIdString
	* @param @return    设定文件
	* @return Object    返回类型
	*/
	List<CompanysGoodsCat> gainGoodsCatListShop(String memberIdString);

	/**
	* @Title: addCompanyCat
	* @Description: TODO(添加店铺分类)
	* @param @param goodsCatId    设定文件
	* @return void    返回类型
	*/
	void addCompanyCat(String goodsCatId, String memberId);

	/**
	* @Title: gainCompanyById
	* @Description: TODO(根据id，查找店铺)
	* @param @param string
	* @param @return    设定文件
	* @return Company    返回类型
	*/
	Company gainCompanyById(String string);

	/**
	* @Title: updateMemberInoformation
	* @Description: TODO(更新企业简介)
	* @param @param company    设定文件
	* @return void    返回类型
	*/
	void updateMemberInoformation(Company company);

	/**
	* @Title: gainCompanysHeadImg
	* @Description: TODO(得到广告管理列表)
	* @param @param string
	* @param @return    设定文件
	* @return List<CompanysHeadImg>    返回类型
	*/
	List<CompanysHeadImg> gainCompanysHeadImg(String string);

	/**
	* @Title: updateHeadImg
	* @Description: TODO(更新店铺表头广告）
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
	* @param pagination 
	 * @Title: gainCompanyMessageListById
	* @Description: TODO(根据店铺id，得到留言列表)
	* @param @param string
	* @param @return    设定文件
	* @return List<CompanysMessage>    返回类型
	*/
	List<CompanysMessage> gainCompanyMessageListById(Map<String, Object> map);
	/**
	* @Title: gainCompanyMessageListByIdCount
	* @Description: TODO(留言列表数目)
	* @param @param string
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
	* @Title: gainCompanyInfoListCount
	* @Description: TODO(咨询数目)
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	Long gainCompanyInfoListCount(Map<String, Object> map);

	/**
	* @Title: gainCompanyInfoList
	* @Description: TODO(咨询列表)
	* @param @param map
	* @param @return    设定文件
	* @return List<CompanysMessage>    返回类型
	*/
	List<CompanysInfo> gainCompanyInfoList(Map<String, Object> map);

	/**
	* @Title: addCompanyInfo
	* @Description: TODO(添加咨询)
	* @param @param companysInfo    设定文件
	* @return void    返回类型
	*/
	void addCompanyInfo(CompanysInfo companysInfo);
	/**
	* @Title: updateCompanyInfo
	* @Description: TODO(更新咨询)
	* @param @param companysInfo    设定文件
	* @return void    返回类型
	*/
	void updateCompanyInfo(CompanysInfo companysInfo);
	/**
	* @Title: gainCompanyInfoById
	* @Description: TODO(更新咨询)
	* @param @param companysInfo    设定文件
	* @return void    返回类型
	*/
	CompanysInfo gainCompanyInfoById(String id);
	/**
	* @Title: deleteCompanyInfoList
	* @Description: TODO(更新咨询)
	* @param @param companysInfo    设定文件
	* @return void    返回类型
	*/
	void deleteCompanyInfoList(String companyInfoIds);

	List<CompanySys> gainCompanySys(String userId);

	void updateCompanySy(CompanySys companySy);

	void deleteCompanySys(CompanySys companySy);

	
}
