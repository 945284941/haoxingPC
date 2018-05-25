package com.qlzy.mainPage.login.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.qlzy.model.Member;

public interface MemberMapper {


	int insertShengjiLog(Member member);

	List<Map<String,Object>> gainMemberLv(Map<String,Object> map);


	BigDecimal gainXiaofeiTotal(Map<String,Object> map);
	/**
	 * 查询下线会员数量
	 * @param map
	 * @return
	 */
	Long getCountByMap(Map map);
	/**
	 * 查询下线会员信息
	 * @param map
	 * @return
	 */
	List<Member> getListByMap(Map map);

	/**
	 * 分销商统计
	 * @param map
	 * @return
	 */
	long getMemberCountByMap(Map map);

	/**
	 * 通过map查询用户信息
	 * @param map
	 * @return
	 */
	List<Member> getMemberListByMap(Map map);

	Double gainShouyi();

	Double gainYujiTicheng(Map<String,Object> map);



    int deleteByPrimaryKey(String id);
    /***
     * 插入member信息
     * @param record
     * @return
     */
    int insertSelective(Member record);
    /***
     * 通过id查member信息
     * @param id
     * @return
     */
    Member selectByPrimaryKey(String id);
    
    /**
     * 根据手机号查询用户列表
     * @param mobile
     * @return
     */
    List<Member> selectMemberByMobile(String mobile);
	/**
	 * 查询所有
	 * @param mobile
	 * @return
	 */
		Member selectKey();
    /****
     * 更新member信息
     * @param member
     * @return
     */
    int updateByPrimaryKeySelective(Member member);
    /****
     * 通过name查member
     * @param username
     * @return
     */
    List<Member> selectByMemberName(String username);
    List<Member> selectByMemberFirstName(String firstname);
	List<Member> selectByMemberUsername(String username);
    /**
     * @Title: gainMemberById
     * @Description: TODO(根据会员id查询会员详细信息)
     * @param @param id
     * @param @return    设定文件
     * @return Member    返回类型
     * @author wangmei
     */
    Member gainMemberById(String id);
    /***
     * 根据推荐会员ID跟注册IP查看注册权限
     * @param recommendUserId
     * @param regIp
     * @return
     */
    List<Member> gainMemberByUpd(Map<String, Object> map);
    /**
     * @Title: gainByMemberLastName
     * @Description: TODO(根据会员昵称查询(用于修改))
     * @param @param map
     * @param @return    设定文件
     * @return List<Member>    返回类型
     * @author wangmei
     */
    List<Member> gainByMemberLastName(Map<String, Object> map);
    /****
	 * 根据登录时间查看近15分钟的数据
	 * @return
	 */
    List<Member> gainActiveAllLoginNameByTime();
    /****
	 * 根据注册时间查看近15分钟的数据
	 * @return
	 */
    List<Member> gainActiveselectAllRegNameByTime();
    /****
	 * 根据校对时间查看近15分钟的数据
	 * @return
	 */
	List<Member> gainActiveGoodsCheckListByTime();
	 /****
	 * 根据商品上传时间查看近15分钟的数据
	 * @return
	 */
	List<Member> gainActiveGoodsListByTime();
	/***
	 * 查看全部登录数据
	* @Title: gainActiveAllLoginNameByTime
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<Member>    返回类型
	* @author 周张豹
	 */
	  List<Member> gainActiveAllLoginNameAll();
	    /****
		 * 根据全部注册的数据
		 * @return
		 */
	    List<Member> gainActiveselectAllRegNameAll();
	    /****
		 * 根据全部校对的数据
		 * @return
		 */
		List<Member> gainActiveGoodsCheckListAll();
		 /****
		 * 根据全部商品上传的数据
		 * @return
		 */
		List<Member> gainActiveGoodsListAll();
		
	/**
	 * @Title: gainMemberByIdAndPassword
	 * @Description: TODO(根据用户id与登录密码或支付密码查询会员信息)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<Member>    返回类型
	 * @throws
	 * @author wangmei
	 */
    List<Member> gainMemberByIdAndPassword(Map<String, Object> map);
    
    /**
     * @Title: MemberMapper.java 
     * @Description: TODO(查询会员安全保护问题)
     * @param @param id
     * @param @return    设定文件 
     * @return String 返回类型 
     * @author wangmei
     */
    String gainQuestionByMemberId(String id);
    
    /**
     * 根据用户的ID查询用户的信息<br>信息：支付密码
    * @Title: selectMemberById
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param id
    * @param @return    设定文件
    * @return Member    返回类型
    * @author 周张豹
     */
    public Member selectMemberById(String id);
    
    /**
     * @Title: gainMemberByUsername
     * @Description: TODO(根据用户名查询用户信息) 
     * @param @param userName
     * @param @return    设定文件 
     * @return Member 返回类型 
     * @author wangmei
     */
    Member gainMemberByUsername(String username);
    
    /**
     * @Title: gainInviteFriendsByMemberId
     * @Description: TODO(根据用户ID查询邀请好友数) 
     * @param @param id
     * @param @return    设定文件 
     * @return Long 返回类型 
     * @author wangmei
     */
    Long gainInviteFriendsByMemberId(String id);
	List<Member> getMemberListByShangjiId(String shangjiId);
	List<Member> getMemberListByOnlyId(String onlyId);
	List<Member> getMemberListByOnlyIdPutong(String onlyId);
	List<Member> gainMemberByShangjiId(String shangjiId);
	List<Member> gainMemberByO(Map<String, Object> map);
	List<Member> xiaxiayou(Map<String, Object> map);
	List<Member> xiaxiaxiayou(Map<String, Object> map);
	Long myYijiCount(Map<String, Object> map);
	Long myErjiCount(Map<String, Object> map);
	Long mySanjiCount(Map<String, Object> map);
	Long myYijiCountvip(Map<String, Object> map);
	Long myErjiCountvip(Map<String, Object> map);
	Long mySanjiCountvip(Map<String, Object> map);
	Member getMemberListByShangjiIdOne(String shangjiId);
	void updatePasswordByUsername(Member member);
	/**
	 * onlyId序列
	 * @return
	 */
	String nextOnlyId();
	
	/**
	 * 验证用户手机号是否已使用
	 * @param mobile
	 * @return
	 */
	List<Member> gainByMobile(String mobile);
	
	/**
	 * 根据用户名手机号验证登录
	 * @param map
	 * @return
	 */
	List<Member> validateLogin(Map<String, Object> map);

	/**
	 * @Title: batchUpdateDisableMobile
	 * @Description:
	 * @date 2017-1-11 上午10:28:31 
	 * @param @param mobileList 设定文件
	 * @return void 返回类型
	 * @throws
	 * @version V1.0
	 */
	void batchUpdateDisableMobile(List<Member> mobileList);
	/**
	 * @Title: batchUpdateEnableMobile
	 * @Description:
	 * @date 2017-1-11 上午10:28:37 
	 * @param @param mobileList 设定文件
	 * @return void 返回类型
	 * @throws
	 * @version V1.0
	 */
	void batchUpdateEnableMobile(List<Member> mobileList);
	/**
	 * @Title: gainMemberByLoginName
	 * @Description:
	 * @date 2017-1-11 上午11:08:22 
	 * @param @param username
	 * @param @return 设定文件
	 * @return List<Member> 返回类型
	 * @throws
	 * @version V1.0
	 */
	List<Member> gainMemberByLoginName(String username);

	List<Member> gainMemberListByMap(Map<String, String> parmMap);


}