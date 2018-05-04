/**  
* @Title: CompanyService.java
* @Package com.qlzy.mainPage.company.service
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-5-31 下午1:21:16
* @version V1.0  
*/
package com.qlzy.mainPage.company.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Company;

/**
 * @ClassName: CompanyService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-5-31 下午1:21:16
 */
public interface CompanyService {

	public int insertCompany(Company company);
	
	/**
	 *根据供应商ID查询供应商信息
	* @Title: gainCompanyById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return Company    返回类型
	* @author 周张豹
	 */
	public Company gainCompanyById(String id);

	/**
	 * 根据二级域名查询卖家信息
	* @Title: gainCompanyByDomain
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param domain
	* @param @return    设定文件
	* @return Company    返回类型
	* @author 周张豹
	*/
	public Company gainCompanyByDomain(String domain);

	/**
	 *  根据ID查询信息<br>信息：支付密码
	* @Title: selectcCompanyById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param userId
	* @param @return    设定文件
	* @return Company    返回类型
	* @author 周张豹
	*/
	public Company selectcCompanyById(String userId);

	/**
	* @Title: gainCompanyListHeadCount
	* @Description: TODO(店铺列表)
	* @param @param map
	* @param @return设定文件
	* @return Long返回类型
	* @throws
	*/
	public Long gainCompanyListHeadCount(Map<String, Object> map);

	/**
	* @Title: gainCompanyListHead
	* @Description: TODO(店铺列表)
	* @param @param map
	* @param @return设定文件
	* @return List<Company>返回类型
	* @throws
	*/
	public List<Company> gainCompanyListHead(Map<String, Object> map);

	public Integer gainCompanyNum();

	public void updateByPrimaryKeySelective(Company company);

	public List<Company> gainCHCompanyList(Map<String, Object> map);

	public Long gainCHCompanyListCount(Map<String, Object> map);

}
