package com.qlzy.zp.dao;

import com.qlzy.model.ZpCompany;





public interface ZpCompanyMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZpCompany record);

    int insertSelective(ZpCompany record);

    ZpCompany selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZpCompany record);

    int updateByPrimaryKey(ZpCompany record);

	ZpCompany gainZpCompany();
}