package com.qlzy.mainPage.login.service.impl;


import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.mainPage.login.service.MemberService;
import com.qlzy.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("MService")
@Transactional(rollbackFor=Exception.class)
public class MemberServicelmpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;

    /**
     * 查询所有
     */
    @Override
    public Member selectKey(String id){
        return memberMapper.selectByPrimaryKey(id);
    }
    @Override
    public int updateomember(Member member){
      return   memberMapper.updateByPrimaryKeySelective(member);
    }
    public void updatePasswordByUsername(Member member){
        memberMapper.updatePasswordByUsername(member);
    }

}
