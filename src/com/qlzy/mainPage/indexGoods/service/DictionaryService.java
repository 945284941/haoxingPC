package com.qlzy.mainPage.indexGoods.service;

import com.qlzy.model.QlDict;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/2.
 */
public interface DictionaryService {
    Map<String,Double> selectByHvType(String hv_type);

    List<QlDict> selectByType(String type);

    QlDict gainByType(String type);
}
