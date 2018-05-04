package com.qlzy.memberCenter.person.perinfo.dao;

import java.util.List;

import com.qlzy.model.Jiesuan;
import com.qlzy.model.JiesuanItem;




public interface JiesuanItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(JiesuanItem record);

    int insertSelective(JiesuanItem record);

    JiesuanItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JiesuanItem record);

    int updateByPrimaryKey(JiesuanItem record);

	List<Jiesuan> gainJiesuanItemList(JiesuanItem jiesuanItem);

	Long gainJiesuanItemListCount(JiesuanItem jiesuanItem);

	List<JiesuanItem> gainJiesuanList(Jiesuan jiesuan);

	List<JiesuanItem> selectByPici(String orderNum);
}