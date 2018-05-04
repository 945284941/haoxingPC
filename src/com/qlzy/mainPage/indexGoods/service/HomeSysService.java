package com.qlzy.mainPage.indexGoods.service;

import com.qlzy.model.HomeSys;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/11.
 */
public interface HomeSysService {
    List<HomeSys> selectByType(Map<String, Object> parmMap);
}
