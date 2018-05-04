package com.qlzy.mainPage.want.dao;


import com.qlzy.model.WantBuy;

import java.util.List;
import java.util.Map;

public interface WantBuyMapper {
    int deleteByPrimaryKey(String id);

    int insert(WantBuy record);

    int insertSelective(WantBuy record);

    WantBuy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WantBuy record);

    int updateByPrimaryKey(WantBuy record);
    Long gainWantBuyPageCount(Map<String, Object> parmMap);

    List<WantBuy> gainWantBuyPage(Map<String, Object> parmMap);

    List<WantBuy> selectByParm(Map<String, Object> parmMap);

    List<WantBuy> selectLclByParm(Map<String, Object> parmMap);
}