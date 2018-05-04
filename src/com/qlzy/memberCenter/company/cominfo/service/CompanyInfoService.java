/**   
 * @Title: CompanyInfoService.java 
 * @Package com.qlzy.memberCenter.company.cominfo.service 
 * @Description: TODO(企业信息接口类) 
 * @author wangmei   
 * @date 2013-10-23 下午4:17:19 
 * @version V1.0   
 */
package com.qlzy.memberCenter.company.cominfo.service;

import com.qlzy.model.Company;

public interface CompanyInfoService {

	/**
	 * @Title: gainCompanyById
	 * @Description: TODO(根据ID查询企业详细信息) 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Company 返回类型 
	 * @author wangmei
	 */
	public Company gainCompanyById(String id);
	
	/**
	 * @Title: gainQuestionByComId
	 * @Description: TODO(根据ID查询安全保护问题) 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return String 返回类型 
	 * @author wangmei
	 */
	public String gainQuestionByComId(String id);
	
	/**
	 * @Title: updatePersonInfo
	 * @Description: TODO(修改企业会员信息)
	 * @param @param member    设定文件
	 * @return void    返回类型
	 * @throws
	 * @author wangmei
	 */
	public void updateComInfo(Company company);
}
