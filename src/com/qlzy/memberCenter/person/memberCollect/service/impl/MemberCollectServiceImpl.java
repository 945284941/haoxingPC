/**  
* @Title: CollectServiceImpl.java
* @Package com.qlzy.memberCenter.person.collect.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-10-9 下午3:24:05
* @version V1.0  
*/
package com.qlzy.memberCenter.person.memberCollect.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.common.tools.LevelIconUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.common.dao.ContractMapper;
import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.memberCenter.call.dao.MemberCollectMapper;
import com.qlzy.memberCenter.common.dao.ViewsMapper;
import com.qlzy.memberCenter.order.dao.OrderMapper;
import com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService;
import com.qlzy.model.Company;
import com.qlzy.model.Contract;
import com.qlzy.model.MemberCollect;
import com.qlzy.model.Views;
import com.qlzy.util.Constant;
@Transactional(rollbackFor=Exception.class)
@Service("memberCollectService")
/**
 * @ClassName: CollectServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-10-9 下午3:24:05
 */
public class MemberCollectServiceImpl implements MemberCollectService{
	@Resource
	private MemberCollectMapper memberCollectMapper;
	@Resource
	private ViewsMapper viewsMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private ContractMapper contractMapper;

	/* (non-Javadoc)
	 * @see com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService#gainMemberCollectLong(java.util.Map)
	 */
	@Override
	public Long gainMemberCollectLong(Map<String, Object> map) {
		return memberCollectMapper.gainMemberCollectLong(map);
	}

	/* (non-Javadoc)
	 * @see com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService#gainMemberCollectList(java.util.Map)
	 */
	@Override
	public List<MemberCollect> gainMemberCollectList(Map<String, Object> map) {
		return memberCollectMapper.gainMemberCollectList(map);
	}


	/* (non-Javadoc)
	 * @see com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService#gainMemberCollectShopList(java.util.Map)
	 */
	@Override
	public List<Company> gainMemberCollectShopList(Map<String, Object> map) {
		List<Company> list = memberCollectMapper.gainMemberCollectShopList(map);
		if(null !=list && list.size() > 0){
			for (Company c : list) {
				gainCompanyById(c);
			}
		}
		return list;
	}
	
	/**
	 * @Title: gainCompanyById
	 * @Description: TODO(查询会员等级图标) 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Company 返回类型 
	 * @author wangmei
	 */
	private Company gainCompanyById(Company c) {
		Company company = null;
// companyMapper.selectById(c.getId());
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
//			c.setVipGradeImgSrc(vipGradeImgSrc);
//
//			// 会员等级名称
//			c.setVipLevelName(String.valueOf(LevelIconUtil.getVipLevelIcon(company.getVipGrade(), company.getVipGradePoint()).get("vipLevelName")));
		}
		return c;
	}

	/* (non-Javadoc)
	 * @see com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService#gainMemberViewsLong(java.util.Map)
	 */
	@Override
	public Long gainMemberViewsLong(Map<String, Object> map) {
		return viewsMapper.gainMemberViewsLong(map);
	}

	/* (non-Javadoc)
	 * @see com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService#gainMemberViewsShopList(java.util.Map)
	 */
	@Override
	public List<Company> gainMemberViewsShopList(Map<String, Object> map) {
		List<Company> list = viewsMapper.gainMemberViewsShopList(map);
		if(null !=list && list.size() > 0){
			for (Company c : list) {
				gainCompanyById(c);
			}
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService#gainMemberViewsList(java.util.Map)
	 */
	@Override
	public List<Views> gainMemberViewsList(Map<String, Object> map) {
		return viewsMapper.gainMemberViewsList(map);
	}

	/* (non-Javadoc)
	 * @see com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService#insetMemberCollect(com.qlzy.model.MemberCollect)
	 */
	@Override
	public void insetMemberViews(Views views) {
		Integer i = viewsMapper.selectViewsLang(views);
		if (i>0) {
			viewsMapper.updateViews(views);
		} else {
			viewsMapper.insert(views);
		}	
		
	}

	@Override
	public void insertSelective(MemberCollect memberCollect) {
		memberCollectMapper.insertSelective(memberCollect);
	}

	@Override
	public void deleteMemberCollect(MemberCollect memberCollect) {
		memberCollectMapper.deleteMemberCollect(memberCollect);
	}

	@Override
	public List<MemberCollect> findListByMemberCollect(MemberCollect memberCollect) {
		return memberCollectMapper.findListByMemberCollect(memberCollect);
	}

}
