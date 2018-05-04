package com.qlzy.mainPage.want.service;

import com.qlzy.model.WantBuy;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/12.
 */
public interface WantBuyService {
    Long gainWantBuyPageCount(Map<String, Object> parmMap);

    List<WantBuy> gainWantBuyPage(Map<String, Object> parmMap);

    void add(WantBuy wantBuy);

    List<WantBuy> selectByParm(Map<String, Object> parmMap);


    WantBuy selectOneByParm(Map<String, Object> parmMap);
        //求购
    WantBuy selectByKey(String id);
        //求购删除
     int delectwan(String id);
}
