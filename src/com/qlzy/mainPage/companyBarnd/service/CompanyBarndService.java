package com.qlzy.mainPage.companyBarnd.service;

import com.qlzy.model.CompanyBarnd;

import java.util.List;

public interface CompanyBarndService {
    /**
     * @Title findBankCardByCid
     * @Description TODO(查询审核品牌列表)
     * @param companyBarnd
     * @return
     */
    public List<CompanyBarnd> findBankCardByCid(CompanyBarnd companyBarnd);
}
