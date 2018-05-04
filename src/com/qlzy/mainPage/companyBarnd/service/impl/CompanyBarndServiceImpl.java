package com.qlzy.mainPage.companyBarnd.service.impl;

import com.qlzy.mainPage.companyBarnd.dao.CompanyBarndMapper;
import com.qlzy.mainPage.companyBarnd.service.CompanyBarndService;
import com.qlzy.model.CompanyBarnd;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("comppanyBarndService")
public class CompanyBarndServiceImpl implements CompanyBarndService {
    @Resource
    private CompanyBarndMapper companyBarndMapper;
    @Override
    public List<CompanyBarnd> findBankCardByCid(CompanyBarnd bankcard) {
        return companyBarndMapper.findBankCardByCid(bankcard);
    }
}
