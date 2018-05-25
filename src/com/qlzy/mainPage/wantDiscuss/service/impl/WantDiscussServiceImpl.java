package com.qlzy.mainPage.wantDiscuss.service.impl;

import com.qlzy.mainPage.wantDiscuss.dao.WantDiscussMapper;
import com.qlzy.mainPage.wantDiscuss.service.WantDiscussService;
import com.qlzy.model.WantDiscuss;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("wantDiscussService")
public class WantDiscussServiceImpl implements WantDiscussService{

    @Resource
    private WantDiscussMapper wantDiscussMapper;

    @Override
    public List<WantDiscuss> list(WantDiscuss wantDiscuss) {
        return wantDiscussMapper.wantDiscussList(wantDiscuss);
    }

    @Override
    public Long count(WantDiscuss wantDiscuss) {
        return wantDiscussMapper.wantDiscussListCount(wantDiscuss);
    }

    @Override
    public void add(WantDiscuss wantDiscuss) {
        wantDiscussMapper.insertSelective(wantDiscuss);
    }
}
