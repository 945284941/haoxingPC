package com.qlzy.memberCenter.shop.service.impl;

import com.qlzy.memberCenter.shop.dao.CompanysGoodsCatMapper;
import com.qlzy.memberCenter.shop.service.CompanysGoodsCatService;
import com.qlzy.model.CompanysGoodsCat;
import com.qlzy.model.GoodsCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/23.
 */
@Service("companysGoodsCatService")
@Transactional(rollbackFor = Exception.class)
public class CompanysGoodsCatServiceImpl implements CompanysGoodsCatService {
    @Autowired
    CompanysGoodsCatMapper companysGoodsCatMapper;
    @Override
    public List<CompanysGoodsCat> gainAllCompanyCat(String companyId) {
        Map<String, Object> parmMap = new HashMap<>();
        parmMap.put("companyId",companyId);
        parmMap.put("grade","1");
     List<CompanysGoodsCat>   list = companysGoodsCatMapper.gainCompanyCatByParm(parmMap);
        parmMap = new HashMap<>();
        for (CompanysGoodsCat cat : list) {
            parmMap.put("pid",cat.getId());
            List<CompanysGoodsCat> subCatList = companysGoodsCatMapper.gainCompanyCatByParm(parmMap);
            cat.setSubCompanyCatList(subCatList);
//            if (null != subCatList) {
//                for (CompanysGoodsCat c : subCatList) {
//                    parmMap.put("pid",c.getId());
//                    List<CompanysGoodsCat> threeCatList = companysGoodsCatMapper.gainCompanyCatByParm(parmMap);
//                    c.setThreeCompanyCatList(threeCatList);
//                }
//            }
        }
        return list;
    }

    @Override
    public List<CompanysGoodsCat> findCompanyGoodsCatByCompanyId(String companyId) {
        return companysGoodsCatMapper.findCompanyGoodsCatByCompanyId(companyId);
    }

    @Override
    public List<CompanysGoodsCat> findChildrenByPid(String pid) {
        return companysGoodsCatMapper.findChildrenByPid(pid);
    }

}
