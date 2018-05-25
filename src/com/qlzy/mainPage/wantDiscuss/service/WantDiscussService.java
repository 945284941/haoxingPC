package com.qlzy.mainPage.wantDiscuss.service;

import com.qlzy.model.WantDiscuss;

import java.util.List;

public interface WantDiscussService {

    /**
     * @Title list
     * @Description TODO(获取当前生活圈的回复)
     * @param wantDiscuss
     * @return
     * @auther JASON
     */
    public List<WantDiscuss> list(WantDiscuss wantDiscuss);
    /**
     * @Title count
     * @Description TODO(获取当前生活圈的回复数量)
     * @param wantDiscuss
     * @return
     * @auther JASON
     */
    public Long count(WantDiscuss wantDiscuss);
    /**
     * @Title add
     * @Description TODO(添加回复)
     * @param wantDiscuss
     * @return
     * @auther JASON
     */
    public void add(WantDiscuss wantDiscuss);
}
