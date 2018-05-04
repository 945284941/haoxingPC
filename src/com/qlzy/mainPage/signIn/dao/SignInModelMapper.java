package com.qlzy.mainPage.signIn.dao;


import java.util.List;
import java.util.Map;

import com.qlzy.model.SignInModel;



public interface SignInModelMapper {
    int deleteByPrimaryKey(String id);

    int insert(SignInModel record);

    int insertSelective(SignInModel record);

    SignInModel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SignInModel record);

    int updateByPrimaryKey(SignInModel record);

	List<SignInModel> isAlreadySigned(Map<String, Object> map);//是否在一个时间段内

	List<SignInModel> selectByComanyId(String companyId);
}