package com.qlzy.memberCenter.company.companyMember.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.memberCenter.company.companyMember.service.CompanyMemberService;
import com.qlzy.model.Company;


/**
 * @ClassName: companyMemberImpl
 * @Description: TODO(企业实现类)
 * @author A18ccms a18ccms_gmail_com
 * @date 2013-10-15 下午1:24:05
 *
 */
@Service
public class CompanyMemberServiceImpl implements CompanyMemberService{
	@Resource
	private CompanyMapper companyMapper;
	
	
	@Override
	public Company gainCompanyMessageById(String id) {
		// TODO Auto-generated method stub
//		return companyMapper.gainCompanyMessageById(id);
		return null;
	}


	@Override
	public void modifyCompany(Company company) {
		// TODO Auto-generated method stub
		companyMapper.updateByPrimaryKeySelective(company);
	}

}
