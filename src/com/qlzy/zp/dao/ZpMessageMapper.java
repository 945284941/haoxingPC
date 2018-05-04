package com.qlzy.zp.dao;

import java.util.List;

import com.qlzy.model.ZpMessage;

public interface ZpMessageMapper {
    int insert(ZpMessage record);

    int insertSelective(ZpMessage record);
    
    ZpMessage selectAll();

	List<ZpMessage> gainZpMessageList();

	ZpMessage selectById(String zpId);
}