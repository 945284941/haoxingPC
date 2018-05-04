/**  
 * @Title: CompanyShopManageService.java 
 * @Package com.qlzy.memberCenter.shop.service 
 * @Description: TODO(店铺管理接口类)
 * @author wangmei  
 * @date 2013-8-20 上午10:12:44
 * @version V1.0  
 */
package com.qlzy.memberCenter.shop.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.CompanysHeadImg;
import com.qlzy.model.CompanysInfo;
import com.qlzy.model.CompanysMessage;
import com.qlzy.model.Goods;
import com.qlzy.model.Member;
import com.qlzy.util.Pagination;

public interface CompanyShopManageService {

	/**
	 * @Title: gainHeadImgsByCompanyId
	 * @Description: TODO(根据商家ID查询商家店铺头部广告图片)
	 * @param @param companyId
	 * @param @return 设定文件
	 * @return List<CompanysHeadImg> 返回类型
	 * @author wangmei
	 */
	public List<CompanysHeadImg> gainHeadImgsByCompanyId(String companyId);

	/**
	 * @Title: gainGoodsCatNameById
	 * @Description: TODO(根据商品分类ID查询商品分类名称)
	 * @param @param id
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String gainGoodsCatNameById(String id);

	/**
	 * @Title: gainCompanysInfoListByPage
	 * @Description: TODO(查询企业资讯列表)
	 * @param @param pagination
	 * @param @param companyId
	 * @param @return 设定文件
	 * @return List<CompanysInfo> 返回类型
	 * @author wangmei
	 */
	public List<CompanysInfo> gainCompanysInfoListByPage(Pagination pagination,
			String companyId);

	/**
	 * @Title: gainCompanysInfoListCount
	 * @Description: TODO(查询企业资讯列表的数量)
	 * @param @param companyId
	 * @param @return 设定文件
	 * @return Long 返回类型
	 * @author wangmei
	 */
	public Long gainCompanysInfoListCount(String companyId);

	/**
	 * @Title: gainCompanysInfoById
	 * @Description: TODO(根据资讯ID查询其详细信息)
	 * @param @param id
	 * @param @return 设定文件
	 * @return CompanysInfo 返回类型
	 * @author wangmei
	 */
	public CompanysInfo gainCompanysInfoById(String id);

	/**
	 * @Title: gainCompanysMessageListForPage
	 * @Description: TODO(根据商家ID查询商家店铺客户留言列表信息(带分页))
	 * @param @param pagination
	 * @param @param companyId
	 * @param @return 设定文件
	 * @return List<CompanysMessage> 返回类型
	 * @author wangmei
	 */
	public List<CompanysMessage> gainCompanysMessageListForPage(
			Pagination pagination, String companyId);
	
	/**
	 * @Title: gainCompanysMessageCount
	 * @Description: TODO(根据商家ID查询客户留言列表的数量)
	 * @param @param companyId
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainCompanysMessageCount(String companyId);
	
	/**
	 * @Title: gainMemberById
	 * @Description: TODO(根据id查询个人会员信息)
	 * @param @return    设定文件
	 * @return Member    返回类型
	 * @author wangmei
	 */
	public Member gainMemberById(String id);
	
    /**
     * @Title: addCompanysMessage
     * @Description: TODO(添加留言)
     * @param @param companysMessage    设定文件
     * @return void    返回类型
     * @author wangmei
     */
    public void addCompanysMessage(CompanysMessage companysMessage);
    
    /**
     * @Title: updateViewsForCompanyInfo
     * @Description: TODO(更新浏览量)
     * @param @param companysInfo    设定文件
     * @return void    返回类型
     * @throws
     * @author wangmei
     */
    public void updateViewsForCompanyInfo(CompanysInfo companysInfo);
    
    /**
     * @Title: gainForAdjacent
     * @Description: TODO(查询资讯的上下篇)
     * @param @param id
     * @param @param companyId
     * @param @param type
     * @param @return    设定文件
     * @return CompanysInfo    返回类型
     * @throws
     * @author wangmei
     */
    public CompanysInfo gainForAdjacent(String id,String companyId,Integer type);
}
