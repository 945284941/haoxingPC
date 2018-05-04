/**??
* @Title: CompanyMemberService.java
* @Package com.qlzy.memberCenter.company.service
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-10-15 下午1:24:30
* @version V1.0??
*/
package com.qlzy.memberCenter.company.companyMember.service;

import com.qlzy.model.Company;

/**
 * @ClassName: CompanyMemberService
 * @Description: TODO(企业个人会员)
 * @author zhao yang bin
 * @date 2013-10-15 下午1:24:30
 *
 */
public interface CompanyMemberService {

	/**
	* @Title: gainCompanyMessageById
	* @Description: TODO(根据id查找企业会员)
	* @param @param string
	* @param @return????设定文件
	* @return Company????返回类型
	* @throws
	*/
	Company gainCompanyMessageById(String string);

	/**
	* @Title: modifyCompany
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param company????设定文件
	* @return void????返回类型
	* @throws
	*/
	void modifyCompany(Company company);

}
