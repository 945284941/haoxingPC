/**  
 * @Title: CompanysCarbrandServiceImpl.java 
 * @Package com.qlzy.mainPage.service.impl 
 * @Description: TODO(这里用一句话描述这个方法的作用)
 * @author wangmei  
 * @date 2013-5-10 下午1:36:14
 * @version V1.0  
 */
package com.qlzy.mainPage.floor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qlzy.mainPage.floor.dao.CompanysCarbrandMapper;
import com.qlzy.mainPage.floor.service.CompanysCarbrandService;
import com.qlzy.model.CompanysCarbrand;

@Service("companysCarbrandService")
public class CompanysCarbrandServiceImpl implements CompanysCarbrandService {

	@Resource
	private CompanysCarbrandMapper companysCarbrandMapper;
	/** (non-Javadoc)
	 * @Title: gainCompanysCarbrandByCompanyId
	 * @Description: TODO(根据供应商家id查询其汽车品牌信息)
	 * @param companyId
	 * @return
	 * @see com.qlzy.mainPage.service.CompanysCarbrandService#gainCompanysCarbrandByCompanyId(java.lang.String)
	 */
	@Override
	public List<CompanysCarbrand> gainCompanysCarbrandByCompanyId(
			String companyId) {
		return companysCarbrandMapper.gainCompanysCarbrandByCompanyId(companyId);
	}

}
