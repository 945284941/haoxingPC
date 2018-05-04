/**  
 * @Title: CompanyShopManageServiceImpl.java 
 * @Package com.qlzy.memberCenter.shop.service.impl 
 * @Description: TODO(店铺管理接口实现类)
 * @author wangmei  
 * @date 2013-8-20 上午10:13:02
 * @version V1.0  
 */
package com.qlzy.memberCenter.shop.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.mainPage.head.dao.GoodsCatMapper;
import com.qlzy.mainPage.indexGoods.dao.GoodsMapper;
import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.memberCenter.shop.dao.CompanysHeadImgMapper;
import com.qlzy.memberCenter.shop.dao.CompanysInfoMapper;
import com.qlzy.memberCenter.shop.dao.CompanysMessageMapper;
import com.qlzy.memberCenter.shop.service.CompanyShopManageService;
import com.qlzy.model.CompanysHeadImg;
import com.qlzy.model.CompanysInfo;
import com.qlzy.model.CompanysMessage;
import com.qlzy.model.Goods;
import com.qlzy.model.Member;
import com.qlzy.util.Constant;
import com.qlzy.util.Pagination;

@Service("companyShopManageService")
@Transactional(rollbackFor = Exception.class)
public class CompanyShopManageServiceImpl implements CompanyShopManageService {

	@Resource
	private CompanysHeadImgMapper companysHeadImgMapper;
	@Resource
	private GoodsMapper goodsMapper;
	@Resource
	private GoodsCatMapper goodsCatMapper;
	@Resource
	private CompanysInfoMapper companysInfoMapper;
	@Resource
	private CompanysMessageMapper companysMessageMapper;
	@Resource
	private MemberMapper memberMapper;
	@Resource
	private CompanyMapper companyMapper;

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainHeadImgsByCompanyId
	 * @Description: TODO(根据商家ID查询商家店铺头部广告图片)
	 * @param companyId
	 * @return
	 * @see com.qlzy.memberCenter.shop.service.CompanyShopManageService#gainHeadImgsByCompanyId(java.lang.String)
	 */
	@Override
	public List<CompanysHeadImg> gainHeadImgsByCompanyId(String companyId) {
		return companysHeadImgMapper.gainCompanysHeadImgsByCompanyId(companyId);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainGoodsCatNameById
	 * @Description: TODO(根据商品分类ID查询商品分类名称)
	 * @param id
	 * @return
	 * @see com.qlzy.memberCenter.shop.service.CompanyShopManageService#gainGoodsCatNameById(java.lang.String)
	 */
	@Override
	public String gainGoodsCatNameById(String id) {
		return goodsCatMapper.gainGoodsCatNameById(id);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainCompanysInfoListCount
	 * @Description: TODO(查询企业资讯列表的数量)
	 * @param companyId
	 * @return
	 * @see com.qlzy.memberCenter.shop.service.CompanysInfoService#gainCompanysInfoListCount(java.lang.String)
	 */
	@Override
	public Long gainCompanysInfoListCount(String companyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		return companysInfoMapper.gainCompanysInfoListCount(map);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainCompanysInfoById
	 * @Description: TODO(根据资讯ID查询其详细信息)
	 * @param id
	 * @return
	 * @see com.qlzy.memberCenter.shop.service.CompanysInfoService#gainById(java.lang.String)
	 */
	@Override
	public CompanysInfo gainCompanysInfoById(String id) {
		return companysInfoMapper.gainById(id);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainCompanysInfoListByPage
	 * @Description: TODO(查询企业资讯列表)
	 * @param pagination
	 * @param companyId
	 * @return
	 * @see com.qlzy.memberCenter.shop.service.CompanysInfoService#gainCompanysInfoListByPage(com.qlzy.util.Pagination,
	 *      java.lang.String)
	 */
	@Override
	public List<CompanysInfo> gainCompanysInfoListByPage(Pagination pagination,
			String companyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		map.put("companyId", companyId);
		return companysInfoMapper.gainCompanysInfoListForPage(map);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainCompanysMessageListForPage
	 * @Description: TODO(根据商家ID查询商家店铺客户留言列表信息(带分页))
	 * @param pagination
	 * @param companyId
	 * @return
	 * @see com.qlzy.memberCenter.shop.service.CompanyShopManageService#gainCompanysMessageListForPage(com.qlzy.util.Pagination,
	 *      java.lang.String)
	 */
	@Override
	public List<CompanysMessage> gainCompanysMessageListForPage(
			Pagination pagination, String companyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		map.put("companyId", companyId);
		return companysMessageMapper.gainCompanysMessageListForPage(map);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainCompanysMessageCount
	 * @Description: TODO(根据商家ID查询客户留言列表的数量)
	 * @param companyId
	 * @return
	 * @see com.qlzy.memberCenter.shop.service.CompanyShopManageService#gainCompanysMessageCount(java.lang.String)
	 */
	@Override
	public Long gainCompanysMessageCount(String companyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		return companysMessageMapper.gainCompanysMessageCount(map);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainMemberById
	 * @Description: TODO(根据id查询个人会员信息)
	 * @param id
	 * @return
	 * @see com.qlzy.memberCenter.shop.service.CompanyShopManageService#gainMemberById(java.lang.String)
	 */
	@Override
	public Member gainMemberById(String id) {
		return memberMapper.gainMemberById(id);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: addCompanysMessage
	 * @Description: TODO(添加留言)
	 * @param companysMessage
	 * @see com.qlzy.memberCenter.shop.service.CompanyShopManageService#addCompanysMessage(com.qlzy.model.CompanysMessage)
	 */
	@Override
	public void addCompanysMessage(CompanysMessage companysMessage) {
		companysMessage.setId(ToolsUtil.getUUID());
		companysMessage.setCreateTime(new Date());
		companysMessageMapper.addCompanysMessage(companysMessage);
	}

	/** (非 Javadoc)
	 * @Title: updateViewsForCompanyInfo
	 * @Description: TODO(更新浏览量)
	 * @param @param companysInfo
	 * @see com.qlzy.memberCenter.shop.service.CompanyShopManageService#updateViewsForCompanyInfo(com.qlzy.model.CompanysInfo)
	 */
	@Override
	public void updateViewsForCompanyInfo(CompanysInfo companysInfo) {
		companysInfoMapper.updateCompanyInfo(companysInfo);
	}

	/** (非 Javadoc)
	 * @Title: CompanyShopManageServiceImpl.java
	 * @Description: TODO(查询资讯的上下篇)
	 * @param @param id
	 * @param @param companyId
	 * @param @param type
	 * @param @return
	 * @see com.qlzy.memberCenter.shop.service.CompanyShopManageService#gainForAdjacent(java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public CompanysInfo gainForAdjacent(String id, String companyId,
			Integer type) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("companyId", companyId);
		map.put("type", type);
		return companysInfoMapper.gainForAdjacent(map);
	}
}