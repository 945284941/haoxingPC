package com.qlzy.mainPage.companyBarnd.dao;

import com.qlzy.model.Bankcard;
import com.qlzy.model.CompanyBarnd;

import java.util.List;

public interface CompanyBarndMapper {
    int deleteByPrimaryKey(String id);

    int insert(CompanyBarnd record);

    int insertSelective(CompanyBarnd record);

    CompanyBarnd selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CompanyBarnd record);

    int updateByPrimaryKey(CompanyBarnd record);
    /**
     * @Title findBankCardByCid
     * @Description TODO(查询审核品牌列表)
     * @param companyBarnd
     * @return
     */
    List<CompanyBarnd> findBankCardByCid(CompanyBarnd companyBarnd);
}