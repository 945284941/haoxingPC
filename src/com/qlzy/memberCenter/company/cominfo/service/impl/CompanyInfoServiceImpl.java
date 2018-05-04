/**   
 * @Title: CompanyInfoServiceImpl.java 
 * @Package com.qlzy.memberCenter.company.cominfo.service.impl 
 * @Description: TODO(企业信息接口实现类) 
 * @author wangmei   
 * @date 2013-10-23 下午4:18:15 
 * @version V1.0   
 */
package com.qlzy.memberCenter.company.cominfo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.common.tools.LevelIconUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.common.dao.ContractMapper;
import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.memberCenter.company.cominfo.service.CompanyInfoService;
import com.qlzy.memberCenter.order.dao.OrderMapper;
import com.qlzy.model.Company;
import com.qlzy.model.Contract;
import com.qlzy.util.Constant;

@Service("companyInfoService")
@Transactional(rollbackFor=Exception.class)
public class CompanyInfoServiceImpl implements CompanyInfoService {

	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private ContractMapper contractMapper;
	
	/** (非 Javadoc) 
	 * @Title:gainCompanyById 
	 * @Description: TODO(根据ID查询企业详细信息)  
	 * @param id
	 * @return 
	 * @see com.qlzy.memberCenter.company.cominfo.service.CompanyInfoService#gainCompanyById(java.lang.String) 
	 */
	@Override
	public Company gainCompanyById(String id) {
		// 根据企业会员ID查询其详细信息
		Company company = companyMapper.selectByPrimaryKey(id);
		if(null != company){
			Long term = 0L;// 合同期限 
			Long vipGradePoint = 0L;// 会员等级经验值
			Long sincerityPoint = 0L;// 诚信等级经验值
//			company.setSincerity(company.getSincerity()==null?0:company.getSincerity());
//			sincerityPoint = company.getSincerity();
			
			// 根据企业会员ID查询其成交量
			Long volume = orderMapper.selectTransactionNumByCompanyId(company.getId());
			
			vipGradePoint = sincerityPoint+volume+1000*term;// 计算出会员等级经验值
//			company.setVipGradePoint(vipGradePoint);
		}
		return company;
	}

	/** (非 Javadoc) 
	 * @Title:gainQuestionByComId 
	 * @Description: TODO(查询会员安全保护问题)  
	 * @param id
	 * @return 
	 * @see com.qlzy.memberCenter.company.cominfo.service.CompanyInfoService#gainQuestionByComId(java.lang.String) 
	 */
	@Override
	public String gainQuestionByComId(String id) {
//		return companyMapper.gainQuestionByComId(id);
		return null;
	}


	/** (非 Javadoc) 
	 * @Title:updateComInfo 
	 * @Description: TODO(修改企业会员信息)  
	 * @param company 
	 * @see com.qlzy.memberCenter.company.cominfo.service.CompanyInfoService#updateComInfo(com.qlzy.model.Company) 
	 */
	@Override
	public void updateComInfo(Company company) {
		companyMapper.updateByPrimaryKeySelective(company);
	}
}
