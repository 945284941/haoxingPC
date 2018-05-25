package com.qlzy.mainPage.company.dao;


import com.qlzy.model.Company;

import java.util.List;
import java.util.Map;

public interface CompanyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String id);

    void updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKeyWithBLOBs(Company record);

    int updateByPrimaryKey(Company record);


    Long gainCompanyListSearchPageCount(Map<String, Object> parmMap);

    List<Company> gainCompanyListSearchPage(Map<String, Object> parmMap);
}