/**  
* @Title: CompanyServiceImpl.java
* @Package com.qlzy.mainPage.company.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-5-31 下午1:24:02
* @version V1.0  
*/
package com.qlzy.mainPage.company.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlzy.common.tools.LevelIconUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.common.dao.ContractMapper;
import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.mainPage.company.service.CompanyService;
import com.qlzy.memberCenter.order.dao.OrderMapper;
import com.qlzy.model.Company;
import com.qlzy.model.Contract;
import com.qlzy.model.RegionsComRecommend;
import com.qlzy.util.Constant;

/**
 * @ClassName: CompanyServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-5-31 下午1:24:02
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
	
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private ContractMapper contractMapper;
	@Autowired
	private MemberMapper memberMapper;

	/* (non-Javadoc)
	 * @see com.qlzy.mainPage.company.service.CompanyService#gainCompanyById(java.lang.String)
	 */
	@Override
	public Company gainCompanyById(String id) {
		// TODO Auto-generated method stub
		return companyMapper.selectByPrimaryKey(id);
	}


	/**
	 * 品牌入驻
	 * @param company
	 */
	@Override
	public int insertCompany(Company company) {
		// TODO Auto-generated method stub
		//根据推荐码 查询会员id
		String recomMa = company.getRecommendUserid();
		if(recomMa != null && !("").equals(recomMa)){
			List<Member> mmList = memberMapper.getMemberListByOnlyId(recomMa);
			if(mmList.size() == 1){
				String memberId = mmList.get(0).getId();
				company.setRecommendUserid(memberId);
			}
		}
		company.setId(ToolsUtil.getUUID());
		company.setModifytime(new Date());
		return companyMapper.insertSelective(company);

	}

	/* (non-Javadoc)
	 * @see com.qlzy.mainPage.company.service.CompanyService#gainCompanyByDomain(java.lang.String)
	 */
	@Override
	public Company gainCompanyByDomain(String domain) {
//		List<Company> list = companyMapper.selectByDomain(domain);
		List<Company> list = null;
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.qlzy.mainPage.company.service.CompanyService#selectcCompanyById(java.lang.String)
	 */
	@Override
	public Company selectcCompanyById(String companyId) {
		return companyMapper.selectByPrimaryKey(companyId);
	}

	@Override
	public Long gainCompanyListHeadCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
//		return companyMapper.gainCompanyListHeadCount(map);
		return null;
	}

	@Override
	public List<Company> gainCompanyListHead(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Company> list = null;
//				companyMapper.gainCompanyListHead(map);
//		if (null != list && list.size() > 0) {
//			for (Company r : list) {
//				if (null == r.getPname()) {
//					r.setPname("");
//				}
//				if (null == r.getCname()) {
//					r.setCname("");
//				}
//				if (null == r.getAname()) {
//					r.setAname("");
//				}
//				if (null == r.getAddress()) {
//					r.setAddress("");
//				}
//				r.setPcaa(r.getPname() + r.getCname() + r.getAname()
//						+ r.getAddress());
//
//				gainCompanyByIdHead(r);
//			}
//		}
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
	private Company gainCompanyByIdHead(Company rc) {
		// 根据企业会员ID查询其详细信息
		Company company = companyMapper.selectByPrimaryKey(rc.getId());
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
			
			// 根据企业会员等级经验值获取其会员等级图标
//			String vipGradeImgSrc = String.valueOf(LevelIconUtil.getVipLevelIcon(company.getVipGrade(), company.getVipGradePoint()).get("vipLevelIcon"));
//			rc.setVipGradeImgSrc(vipGradeImgSrc);
			
			// 会员等级名称
//			rc.setVipLevelName(String.valueOf(LevelIconUtil.getVipLevelIcon(company.getVipGrade(), company.getVipGradePoint()).get("vipLevelName")));
			
			// 根据质量经验值获取其质量等级图标
//			String qualityImgSrc = LevelIconUtil.getSincerityLevelIcon(company.getQuality()==null?0:company.getQuality(), Constant._QUALITY);
//			rc.setQualityImgSrc(qualityImgSrc);
			
			// 根据信誉经验值获取其信誉等级图标
//			String creditImgSrc = LevelIconUtil.getSincerityLevelIcon(company.getCredit()==null?0:company.getCredit(), Constant._CREDIT);
//			rc.setCreditImgSrc(creditImgSrc);
			
			// 根据服务经验值获取其服务等级图标
//			String serveImgSrc = LevelIconUtil.getSincerityLevelIcon(company.getServe()==null?0:company.getServe(), Constant._SERVE);
//			rc.setServeImgSrc(serveImgSrc);
			
			// 根据物流经验值获取其物流等级图标
//			String logisticsImgSrc = LevelIconUtil.getSincerityLevelIcon(company.getLogistics()==null?0:company.getLogistics(), Constant._LOGISTICS);
//			rc.setLogisticsImgSrc(logisticsImgSrc);
		}
		return rc;
	}

	@Override
	public Integer gainCompanyNum() {
		// TODO Auto-generated method stub
//		return companyMapper.gainCompanyNum();
		return null;
	}

	@Override
	public void updateByPrimaryKeySelective(Company company) {
		// TODO Auto-generated method stub
		 companyMapper.updateByPrimaryKeySelective(company);
		
	}


	@Override
	public Long gainCHCompanyListCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
//		return companyMapper.gainCHCompanyListCount();
		return null;
	}

	@Override
	public List<Company> gainCompanyListSearchPage(Map<String, Object> parmMap) {
		return companyMapper.gainCompanyListSearchPage(parmMap);
	}

	@Override
	public Long gainCompanyListSearchPageCount(Map<String, Object> parmMap) {
		return companyMapper.gainCompanyListSearchPageCount(parmMap);
	}

	@Override
	public void updateByPrimaryKeyWithBLOBs(Company company) {
		companyMapper.updateByPrimaryKeyWithBLOBs(company);
	}

	@Override
	public List<Company> gainCHCompanyList(Map<String, Object> map) {
		// TODO Auto-generated method stub
//		return companyMapper.gainCHCompanyList(map);
		return null;
	}

}
