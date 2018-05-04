/**  
 * @Title: CompanysCarbrandService.java 
 * @Package com.qlzy.mainPage.service 
 * @Description: TODO(这里用一句话描述这个方法的作用)
 * @author wangmei  
 * @date 2013-5-10 下午1:34:51
 * @version V1.0  
 */
package com.qlzy.mainPage.floor.service;

import java.util.List;

import com.qlzy.model.CompanysCarbrand;

public interface CompanysCarbrandService {
	
	/**
	 * @Title: gainCompanysCarbrandByCompanyId
	 * @Description: TODO(根据供应商家id查询其汽车品牌信息)
	 * @param @param companyId
	 * @param @return    设定文件
	 * @return List<CompanysCarbrand>    返回类型
	 */
	public List<CompanysCarbrand> gainCompanysCarbrandByCompanyId(String companyId);
}
