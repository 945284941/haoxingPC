package com.qlzy.mainPage.want.service.impl;

import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.want.dao.WantBuyMapper;
import com.qlzy.mainPage.want.dao.WantBuyPicMapper;
import com.qlzy.mainPage.want.service.WantBuyService;
import com.qlzy.model.WantBuy;
import com.qlzy.model.WantBuyPic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2018/4/12.
 */
@Service("wantBuyServiceImpl")
public class WantBuyServiceImpl implements WantBuyService{
    @Autowired
    WantBuyMapper wantBuyMapper;
    @Autowired
    WantBuyPicMapper wantBuyPicMapper;
    @Override
    public Long gainWantBuyPageCount(Map<String, Object> parmMap) {
        return wantBuyMapper.gainWantBuyPageCount(parmMap);
    }

    @Override
    public List<WantBuy> gainWantBuyPage(Map<String, Object> parmMap) {
        return wantBuyMapper.gainWantBuyPage(parmMap);
    }

    @Override
    public void add(WantBuy wantBuy) {
        wantBuy.setId(ToolsUtil.getUUID());
        wantBuy.setCreateDate(new Date());
        wantBuy.setUpdateDate(new Date());
        if(null == wantBuy.getSendDate()){
            wantBuy.setSendDate(wantBuy.getUpdateDate());
        }
        wantBuy.setSendDate(new Date());
        List<String> picList = null;
        if(null != wantBuy.getPicArry() && !"".equals(wantBuy.getPicArry())){
            picList = Arrays.asList(wantBuy.getPicArry().split(","));
            wantBuy.setPicUrl(picList.get(0));
            List<WantBuyPic> wantBuyPicList = new ArrayList<>();
            for (String pic:picList) {
                WantBuyPic wantBuyPic = new WantBuyPic();
                wantBuyPic.setId(ToolsUtil.getUUID());
                wantBuyPic.setPicUrl(pic);
                wantBuyPic.setBuyId(wantBuy.getId());
                wantBuyPic.setBuyType(wantBuy.getBuyType());
                wantBuyPicList.add(wantBuyPic);
            }
            wantBuyPicMapper.batchInsert(wantBuyPicList);
        }
        wantBuyMapper.insertSelective(wantBuy);
    }

    @Override
    public List<WantBuy> selectByParm(Map<String, Object> parmMap) {
        List<WantBuy> wantBuyList = null;
        parmMap.put("limitNum",10);
        if(null != parmMap && ("3".equals(parmMap.get("buyType").toString()))){
            wantBuyList =  wantBuyMapper.selectLclByParm(parmMap);
        }else{
            wantBuyList =  wantBuyMapper.selectByParm(parmMap);
        }
//        List<WantBuy> wantBuys = null;
//        if(null != wantBuyList && wantBuyList.size() > 0){
//            wantBuys = new ArrayList<>();
//            for(WantBuy wantBuy:wantBuyList){
//                List<String> picList = wantBuyPicMapper.selectByBuyId(wantBuy.getId());
//                wantBuy.setPicList(picList);
//                wantBuys.add(wantBuy);
//            }
//        }
        return wantBuyList;
    }

    @Override
    public WantBuy selectOneByParm(Map<String, Object> parmMap) {
        WantBuy wantBuy =  null;
        List<WantBuy> wantBuys = null;
        if(null != parmMap && null != parmMap.get("buyType") && ("3".equals(parmMap.get("buyType").toString()))){
            wantBuys =  wantBuyMapper.selectLclByParm(parmMap);
        }else{
            wantBuys =  wantBuyMapper.selectByParm(parmMap);
        }
        if(null != wantBuys && wantBuys.size() > 0){
            wantBuy = wantBuys.get(0);
            List<String> picList = wantBuyPicMapper.selectByBuyId(wantBuy.getId());
            wantBuy.setPicList(picList);
        }
        return wantBuy;
    }
    //求购
    @Override
   public WantBuy selectByKey(String id){

        return wantBuyMapper.selectByPrimaryKey(id);
    }
    //求购的删除

    public int delectwan(String id){
     return  wantBuyMapper.deleteByPrimaryKey(id);
    }
}
