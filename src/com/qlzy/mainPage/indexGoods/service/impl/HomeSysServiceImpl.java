package com.qlzy.mainPage.indexGoods.service.impl;

import com.qlzy.mainPage.floor.dao.HomeSysMapper;
import com.qlzy.mainPage.indexGoods.service.HomeSysService;
import com.qlzy.model.HomeSys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/11.
 */
@Service("homeSysService")
public class HomeSysServiceImpl implements HomeSysService {
    @Autowired
    HomeSysMapper homeSysMapper;
    @Override
    public List<HomeSys> selectByType(Map<String, Object> parmMap) {
       return homeSysMapper.selectByType(parmMap);
    }
}
