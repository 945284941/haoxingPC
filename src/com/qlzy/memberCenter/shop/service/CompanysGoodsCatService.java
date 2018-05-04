package com.qlzy.memberCenter.shop.service;

import com.qlzy.model.CompanysGoodsCat;

import java.util.List;


/**
 * Created by Administrator on 2018/4/23.
 */
public interface CompanysGoodsCatService {

    List<CompanysGoodsCat> gainAllCompanyCat(String companyId);

    /**
     * @decription TODO(获取当前店铺的所有父级的分类)
     * @param companyId
     * @return
     */
    List<CompanysGoodsCat> findCompanyGoodsCatByCompanyId(String companyId);

    List<CompanysGoodsCat> findChildrenByPid(String pid);
}
