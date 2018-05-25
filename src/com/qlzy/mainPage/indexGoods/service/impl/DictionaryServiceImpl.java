package com.qlzy.mainPage.indexGoods.service.impl;

import com.qlzy.mainPage.indexGoods.dao.QlDictMapper;
import com.qlzy.mainPage.indexGoods.service.DictionaryService;
import com.qlzy.model.QlDict;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/2.
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
    @Resource
    QlDictMapper qlDictMapper;


    @Override
    public QlDict gainByType(String type){
        return qlDictMapper.getByType(type);
    }

    @Override
    public Map<String, Double> selectByHvType(String hv_type) {
        Map<String,Double> resultMap = new HashMap<>();
       List<QlDict> querMap =  qlDictMapper.selectByType(hv_type);
        if(null != querMap && querMap.size() > 0){
            for(QlDict dictionary :querMap){
                resultMap.put(dictionary.getLabel(),Double.parseDouble(dictionary.getValue()));
            }
        }
        return resultMap;
    }

    @Override
    public List<QlDict> selectByType(String type) {
        List<QlDict> querMap =  qlDictMapper.selectByType(type);
        return querMap;
    }
}
