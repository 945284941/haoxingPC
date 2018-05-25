package com.qlzy.memberCenter.person.receive.service.impl;

import com.qlzy.memberCenter.call.dao.ReceiveAddressMapper;
import com.qlzy.memberCenter.person.receive.service.ReceiveAddressService;
import com.qlzy.model.ReceiveAddress;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/5/15.
 */
@Service("receiveAddressService")
@Transactional(rollbackFor = Exception.class)
public class ReceiveAddressServiceImpl implements ReceiveAddressService {
    @Resource
    ReceiveAddressMapper receiveAddressMapper;

    @Override
    public ReceiveAddress selectById(String receiveAddrId) {
        ReceiveAddress receiveAddress =  receiveAddressMapper.selectByPrimaryKey(receiveAddrId);
        return receiveAddress;
    }
}
