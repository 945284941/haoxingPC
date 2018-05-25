package com.qlzy.mainPage.wantDiscuss.dao;

import com.qlzy.model.WantDiscuss;

import java.util.List;

public interface WantDiscussMapper {

    int insertSelective(WantDiscuss record);
    /**
     * @Title list
     * @Description TODO(获取当前生活圈的回复)
     * @param wantDiscuss
     * @return
     * @auther JASON
     */
    List<WantDiscuss> wantDiscussList(WantDiscuss wantDiscuss);
    /**
     * @Title count
     * @Description TODO(获取当前生活圈的回复数量)
     * @param wantDiscuss
     * @return
     * @auther JASON
     */
    Long wantDiscussListCount(WantDiscuss wantDiscuss);
}
