package com.qlzy.mainPage.magazine.dao;

import java.util.List;

import com.qlzy.model.MagazineMessage;



public interface MagazineMessageMapper {
    int deleteByPrimaryKey(String id);

    int insert(MagazineMessage record);

    int insertSelective(MagazineMessage record);

    MagazineMessage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MagazineMessage record);

    int updateByPrimaryKey(MagazineMessage record);

	/**
	* @Title: gainMagazineList
	* @Description: TODO(得到所有杂志列表)
	* @param @return设定文件
	* @return List<MagazineMessage>返回类型
	* @throws
	*/
	List<MagazineMessage> gainMagazineList();
}