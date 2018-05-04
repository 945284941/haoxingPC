/**  
 * @Title: RegionsComRecommendServiceImpl.java 
 * @Package com.qlzy.mainPage.service.impl 
 * @Description: TODO(这里用一句话描述这个方法的作用)
 * @author wangmei  
 * @date 2013-5-9 下午4:42:39
 * @version V1.0  
 */
package com.qlzy.mainPage.floor.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qlzy.common.tools.LevelIconUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.common.dao.ContractMapper;
import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.mainPage.floor.dao.RegionsComRecommendMapper;
import com.qlzy.mainPage.floor.service.RegionsComRecommendService;
import com.qlzy.memberCenter.order.dao.OrderMapper;
import com.qlzy.model.Company;
import com.qlzy.model.Contract;
import com.qlzy.model.RegionsComRecommend;
import com.qlzy.util.Constant;

@Service("rComRecommendService")
public class RegionsComRecommendServiceImpl implements
		RegionsComRecommendService {

	@Resource
	private RegionsComRecommendMapper rComRecommendMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private ContractMapper contractMapper;

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainRegionsComRecommendByShow
	 * @Description: TODO(查询首页设置显示的前三家区域商家推荐)
	 * @param rComRecommend
	 * @return
	 * @see com.qlzy.mainPage.floor.service.RegionsComRecommendService#gainRegionsComRecommendByShow(com.qlzy.model.RegionsComRecommend)
	 */
	@Override
	public List<RegionsComRecommend> gainRegionsComRecommendByShow(
			Map<String, Object> map) {
		return rComRecommendMapper.gainRegionsComRecommendByShow(map);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainRegionsComRecommendByArea
	 * @Description: TODO(根据当前分类与区域查询商家推荐列表)
	 * @param map
	 * @return
	 * @see com.qlzy.mainPage.floor.service.RegionsComRecommendService#gainRegionsComRecommendByArea(java.util.Map)
	 */
	@Override
	public List<RegionsComRecommend> gainRegionsComRecommendByArea(
			Map<String, Object> map) {
		List<RegionsComRecommend> list = rComRecommendMapper
				.gainRegionsComRecommendByArea(map);
		if (null != list && list.size() > 0) {
			for (RegionsComRecommend r : list) {
				if (null == r.getPname()) {
					r.setPname("");
				}
				if (null == r.getCname()) {
					r.setCname("");
				}
				if (null == r.getAname()) {
					r.setAname("");
				}
				if (null == r.getAddress()) {
					r.setAddress("");
				}
				r.setPcaa(r.getPname() + r.getCname() + r.getAname()
						+ r.getAddress());
				
				gainCompanyById(r);
			}
		}
		return list;
	}
	
	/**
	 * @Title: gainCompanyById
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Company 返回类型 
	 * @author wangmei
	 */
	private RegionsComRecommend gainCompanyById(RegionsComRecommend rc) {
		// 根据企业会员ID查询其详细信息
		Company company = companyMapper.selectByPrimaryKey(rc.getCompanyId());
		if(null != company){
			Long term = 0L;// 合同期限 
			Long vipGradePoint = 0L;// 会员等级经验值
			Long sincerityPoint = 0L;// 诚信等级经验值
//			company.setSincerity(company.getSincerity()==null?0:company.getSincerity());
//			sincerityPoint = company.getSincerity();
			
			// 根据企业会员ID查询其成交量
			Long volume = orderMapper.selectTransactionNumByCompanyId(company.getId());
			
			// 根据企业会员ID查询其合同信息
			Contract contract = contractMapper.gainContractByCompanyId(company.getId());
			if(null != contract){
				String startTime = ToolsUtil.getStringByDate(contract.getStartTime());// 合同开始时间
				String endTime = ToolsUtil.getStringByDate(contract.getEndTime());// 合同结束时间
				term = ToolsUtil.compareDate(startTime, endTime, 2);
			}
			vipGradePoint = sincerityPoint+volume+1000*term;// 计算出会员等级经验值
//			company.setVipGradePoint(vipGradePoint);
//
//			// 根据企业会员等级经验值获取其会员等级图标
//			String vipGradeImgSrc = String.valueOf(LevelIconUtil.getVipLevelIcon(company.getVipGrade(), company.getVipGradePoint()).get("vipLevelIcon"));
//			rc.setVipGradeImgSrc(vipGradeImgSrc);
//
//			// 会员等级名称
//			rc.setVipLevelName(String.valueOf(LevelIconUtil.getVipLevelIcon(company.getVipGrade(), company.getVipGradePoint()).get("vipLevelName")));
//
//			// 根据质量经验值获取其质量等级图标
//			String qualityImgSrc = LevelIconUtil.getSincerityLevelIcon(company.getQuality()==null?0:company.getQuality(), Constant._QUALITY);
//			rc.setQualityImgSrc(qualityImgSrc);
//
//			// 根据信誉经验值获取其信誉等级图标
//			String creditImgSrc = LevelIconUtil.getSincerityLevelIcon(company.getCredit()==null?0:company.getCredit(), Constant._CREDIT);
//			rc.setCreditImgSrc(creditImgSrc);
//
//			// 根据服务经验值获取其服务等级图标
//			String serveImgSrc = LevelIconUtil.getSincerityLevelIcon(company.getServe()==null?0:company.getServe(), Constant._SERVE);
//			rc.setServeImgSrc(serveImgSrc);
//
//			// 根据物流经验值获取其物流等级图标
//			String logisticsImgSrc = LevelIconUtil.getSincerityLevelIcon(company.getLogistics()==null?0:company.getLogistics(), Constant._LOGISTICS);
//			rc.setLogisticsImgSrc(logisticsImgSrc);
		}
		return rc;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainRegionsComRecommendCountByArea
	 * @Description: TODO(获取总行数)
	 * @param map
	 * @return
	 * @see com.qlzy.mainPage.floor.service.RegionsComRecommendService#gainRegionsComRecommendCountByArea(java.util.Map)
	 */
	@Override
	public Long gainRegionsComRecommendCountByArea(Map<String, Object> map) {
		return rComRecommendMapper.gainRegionsComRecommendCountByArea(map);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainRegionsComRecommendList
	 * @Description: TODO(查询相关商家推荐列表)
	 * @return
	 * @see com.qlzy.mainPage.floor.service.RegionsComRecommendService#gainRegionsComRecommendList()
	 */
	@Override
	public List<RegionsComRecommend> gainRegionsComRecommendList() {
		return rComRecommendMapper.gainRegionsComRecommendList();
	}
}
