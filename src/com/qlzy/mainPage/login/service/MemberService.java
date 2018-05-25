package com.qlzy.mainPage.login.service;

import com.qlzy.model.Member;

public interface MemberService {

    /**
     * 查询所有
     * @param mobile
     * @return
     */
    public Member selectKey(String id);

    public int updateomember(Member member);
    public void updatePasswordByUsername(Member member);
}

