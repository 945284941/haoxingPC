package com.qlzy.mainPage.common.dao;

import com.qlzy.model.Contract;

public interface ContractMapper {

	/**
	 * @Title: gainContractByCompanyId
	 * @Description: TODO(根据企业会员ID查询其合同信息) 
	 * @param @param companyId
	 * @param @return    设定文件 
	 * @return Contract 返回类型 
	 * @author wangmei
	 */
	Contract gainContractByCompanyId(String companyId);
}