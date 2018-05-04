package com.qlzy.mainPage.floor.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.HomeSys;



public interface HomeSysMapper {
    int deleteByPrimaryKey(String id);

    int insert(HomeSys record);

    int insertSelective(HomeSys record);

    HomeSys selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HomeSys record);

    int updateByPrimaryKey(HomeSys record);

	List<HomeSys> gainAll();

	List<HomeSys> gainTemaiSysList();

	List<HomeSys> gainLunbotu();

    List<HomeSys> gainLunbotuByType(String picType);

    List<HomeSys> selectByType(Map<String, Object> parmMap);
}