package com.qlzy.mainPage.floor.dao;

import java.util.List;
import com.qlzy.model.CompanysCarbrand;

public interface CompanysCarbrandMapper {

	/**
	 * @Title: gainCompanysCarbrandByCompanyId
	 * @Description: TODO(根据供应商家id查询其汽车品牌信息)
	 * @param @param companyId
	 * @param @return    设定文件
	 * @return List<CompanysCarbrand>    返回类型
	 */
	public List<CompanysCarbrand> gainCompanysCarbrandByCompanyId(String companyId);
	 int insert(CompanysCarbrand companyCarbrand);
	 int insertSelective(CompanysCarbrand companyCarbrand);

}