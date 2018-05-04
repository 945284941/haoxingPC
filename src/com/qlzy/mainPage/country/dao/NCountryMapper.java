package com.qlzy.mainPage.country.dao;

import com.qlzy.model.NCountry;
import java.util.List;
import java.util.Map;

public interface NCountryMapper {

    int deleteByPrimaryKey(String id);

    int insert(NCountry record);

    int insertSelective(NCountry record);

    NCountry selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NCountry record);

    int updateByPrimaryKey(NCountry record);

    List<NCountry> gainAll();

    List<NCountry> gainNCountryByLikeName(Map<String,String> parmMap);
}