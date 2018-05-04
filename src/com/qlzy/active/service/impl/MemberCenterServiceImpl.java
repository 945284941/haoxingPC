/**  
 * @Title: MemberCenterServiceImpl.java 
 * @Package com.qlzy.active.service 
 * @Description: TODO(会员中心管理接口实现类)
 * @author wangmei  
 * @date 2013-6-18 下午2:31:36
 * @version V1.0  
 */
package com.qlzy.active.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.active.dao.ActiveCollectGoodsCheckMapper;
import com.qlzy.active.dao.ActiveCollectGoodsMapper;
import com.qlzy.active.dao.ActiveCollectMoneyLogMapper;
import com.qlzy.active.dao.ActiveCollectPointLogMapper;
import com.qlzy.active.service.MemberCenterService;
import com.qlzy.mainPage.login.dao.MemberJobMapper;
import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.model.ActiveCollectGoods;
import com.qlzy.model.ActiveCollectGoodsCheck;
import com.qlzy.model.Member;
import com.qlzy.model.MemberJob;

@Service("memberCenterService")
@Transactional(rollbackFor=Exception.class)
public class MemberCenterServiceImpl implements MemberCenterService {

	@Resource
	private MemberMapper memberMapper;
	@Resource
	private ActiveCollectGoodsMapper activeCollectGoodsMapper;
	@Resource
	private ActiveCollectGoodsCheckMapper activeCollectGoodsCheckMapper;
	@Resource
	private MemberJobMapper memberJobMapper;
	@Resource
	private ActiveCollectPointLogMapper activeCollectPointLogMapper;
	@Resource
	private ActiveCollectMoneyLogMapper activeCollectMoneyLogMapper;
	
	/** (non-Javadoc)
	 * @Title: gainMemberById
	 * @Description: TODO(根据id查询会员信息)
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainMemberById()
	 */
	@Override
	public Member gainMemberById(String id) {
		return memberMapper.gainMemberById(id);
	}

	/** (non-Javadoc)
	 * @Title: gainUploadCount
	 * @Description: TODO(根据会员id,上传通过标示查询上传的数据条数)
	 * @param map
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainUploadCount(java.util.Map)
	 */
	@Override
	public Long gainUploadCount(String memberId, Integer status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberid", memberId);
		map.put("status", status);
		return activeCollectGoodsMapper.gainUploadCount(map);
	}

	/** (non-Javadoc)
	 * @Title: gainCheckCount
	 * @Description: TODO(根据会员id,校对通过标示查询校对的数据条数)
	 * @param memberId
	 * @param status
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainCheckCount(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Long gainCheckCount(String memberId, Integer status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("status", status);		
		return activeCollectGoodsCheckMapper.gainCheckCount(map);
	}

	/** (non-Javadoc)
	 * @Title: gainActiveCollectGoodsList
	 * @Description: TODO(根据会员id查询上传数据信息)
	 * @param map
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainActiveCollectGoodsList(java.util.Map)
	 */
	@Override
	public List<ActiveCollectGoods> gainActiveCollectGoodsList(
			Map<String, Object> map) {
		return activeCollectGoodsMapper.gainActiveCollectGoodsList(map);
	}
	
	/** (non-Javadoc)
	 * @Title: gainActiveCollectGoodsTotalCount
	 * @Description: TODO(获取上传数据总行数)
	 * @param map
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainActiveCollectGoodsTotalCount(java.util.Map)
	 */
	@Override
	public Long gainActiveCollectGoodsTotalCount(Map<String, Object> map) {
		return activeCollectGoodsMapper.gainUploadCount(map);
	}

	/** (non-Javadoc)
	 * @Title: gainCheckActiveCollectGoodsList
	 * @Description: TODO(根据会员id查询校对的数据信息)
	 * @param map
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainCheckActiveCollectGoodsList(java.util.Map)
	 */
	@Override
	public List<ActiveCollectGoodsCheck> gainCheckActiveCollectGoodsList(
			Map<String, Object> map) {
		return activeCollectGoodsCheckMapper.gainCheckActiveCollectGoodsList(map);
	}
	
	/** (non-Javadoc)
	 * @Title: gainCheckActiveCollectGoodsTotalCount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param map
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainCheckActiveCollectGoodsTotalCount(java.util.Map)
	 */
	@Override
	public Long gainCheckActiveCollectGoodsTotalCount(Map<String, Object> map) {
		return activeCollectGoodsCheckMapper.gainCheckCount(map);
	}

	/** (non-Javadoc)
	 * @Title: gainUploadAddUpPoint
	 * @Description: TODO(查询会员上传累计经验值)
	 * @param memberId
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainUploadAddUpPoint(java.lang.String)
	 */
	@Override
	public Long gainUploadAddUpPoint(String memberId) {
		return activeCollectGoodsMapper.gainUploadAddUpPoint(memberId);
	}

	/** (non-Javadoc)
	 * @Title: gainUploadAddUpMoney
	 * @Description: TODO(查询会员上传累计奖金)
	 * @param memberId
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainUploadAddUpMoney(java.lang.String)
	 */
	@Override
	public Double gainUploadAddUpMoney(String memberId) {
		return activeCollectGoodsMapper.gainUploadAddUpMoney(memberId);
	}

	/** (non-Javadoc)
	 * @Title: gainCheckAddUpPoint
	 * @Description: TODO(查询会员校对累计经验值)
	 * @param memberId
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainCheckAddUpPoint(java.lang.String)
	 */
	@Override
	public Long gainCheckAddUpPoint(String memberId) {
		return activeCollectGoodsCheckMapper.gainCheckAddUpPoint(memberId);
	}

	/** (non-Javadoc)
	 * @Title: gainCheckAddUpMoney
	 * @Description: TODO(查询会员校对累计奖金)
	 * @param memberId
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainCheckAddUpMoney(java.lang.String)
	 */
	@Override
	public Double gainCheckAddUpMoney(String memberId) {
		return activeCollectGoodsCheckMapper.gainCheckAddUpMoney(memberId);
	}

	/** (non-Javadoc)
	 * @Title: updateMember
	 * @Description: TODO(修改会员信息)
	 * @param member
	 * @see com.qlzy.active.service.MemberCenterService#updateMember(com.qlzy.model.Member)
	 */
	@Override
	public void updateMember(Member member) {
		memberMapper.updateByPrimaryKeySelective(member);
	}

	/** (non-Javadoc)
	 * @Title: gainMemberJobList
	 * @Description: TODO(查询从事领域列表)
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainMemberJobList()
	 */
	@Override
	public List<MemberJob> gainMemberJobList() {
		return memberJobMapper.gainMemberJobList();
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainUploadCountByTime
	 * @Description: TODO(查询今日、昨日、本月的上传数据统计)
	 * @param memberId
	 * @param status
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param cxItem
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainUploadCountByTime(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long gainUploadCountByTime(String memberId,Integer status,Integer time,String startTime,String endTime,String cxItem) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberid", memberId);
		map.put("status", status);
		map.put("time", time);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("cxItem", cxItem);
		return activeCollectGoodsMapper.gainUploadCountByTime(map);
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainUploadRankByTime
	 * @Description: TODO(查询今日、昨日、本月的上传数据总排名)
	 * @param memberId
	 * @param status
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param cxItem
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainUploadRankByTime(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long gainUploadRankByTime(String memberId,Integer status,Integer time,String startTime,String endTime,String cxItem) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberid", memberId);
		map.put("status", status);
		map.put("time", time);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("cxItem", cxItem);		
		return activeCollectGoodsMapper.gainUploadRankByTime(map);
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainUploadGetPoint
	 * @Description: TODO(查询今日、昨日、本月的上传数据采用获得的经验值)
	 * @param memberId
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param cxItem
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainUploadGetPoint(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long gainUploadGetPoint(String memberId,Integer time,String startTime,String endTime,String cxItem) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberid", memberId);
		map.put("time", time);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("cxItem", cxItem);		
		return activeCollectGoodsMapper.gainUploadGetPoint(map);
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainUploadGetMoney
	 * @Description: TODO(查询今日、昨日、本月的上传数据采用获得的奖金)
	 * @param memberId
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param cxItem
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainUploadGetMoney(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Double gainUploadGetMoney(String memberId,Integer time,String startTime,String endTime,String cxItem) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberid", memberId);
		map.put("time", time);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("cxItem", cxItem);		
		return activeCollectGoodsMapper.gainUploadGetMoney(map);
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainCheckCountByTime
	 * @Description: TODO(查询今日、昨日、本月的校对数据统计)
	 * @param memberId
	 * @param status
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param cxItem
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainCheckCountByTime(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long gainCheckCountByTime(String memberId,Integer status,Integer time,String startTime,String endTime,String cxItem) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("status", status);
		map.put("time1", time);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("cxItem", cxItem);		
		return activeCollectGoodsCheckMapper.gainCheckCountByTime(map);
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainCheckRankByTime
	 * @Description: TODO(查询今日、昨日、本月的校对数据总排名)
	 * @param memberId
	 * @param status
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param cxItem
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainCheckRankByTime(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long gainCheckRankByTime(String memberId,Integer status,Integer time,String startTime,String endTime,String cxItem) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("status", status);
		map.put("time1", time);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("cxItem", cxItem);		
		return activeCollectGoodsCheckMapper.gainCheckRankByTime(map);
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainCheckGetPoint
	 * @Description: TODO(查询今日、昨日、本月的校对数据采用获得的经验值)
	 * @param memberId
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param cxItem
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainCheckGetPoint(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long gainCheckGetPoint(String memberId,Integer time,String startTime,String endTime,String cxItem) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("time1", time);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("cxItem", cxItem);		
		return activeCollectGoodsCheckMapper.gainCheckGetPoint(map);
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainCheckGetMoney
	 * @Description: TODO(查询今日、昨日、本月的校对数据采用获得的奖金)
	 * @param memberId
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param cxItem
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainCheckGetMoney(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Double gainCheckGetMoney(String memberId,Integer time,String startTime,String endTime,String cxItem) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("time1", time);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("cxItem", cxItem);		
		return activeCollectGoodsCheckMapper.gainCheckGetMoney(map);
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainTotalMoney
	 * @Description: TODO(查询今日、昨日、本月的上传和校对采用获得的总奖金)
	 * @param memberId
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param cxItem
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainTotalMoney(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Double gainTotalMoney(String memberId,Integer time,String startTime,String endTime,String cxItem) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("time2", time);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("cxItem", cxItem);		
		return activeCollectMoneyLogMapper.gainTotalMoney(map);
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainTotalMoneyRank
	 * @Description: TODO(查询今日、昨日、本月的上传和校对采用获得的总奖金的总排名)
	 * @param memberId
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param cxItem
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainTotalMoneyRank(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long gainTotalMoneyRank(String memberId,Integer time,String startTime,String endTime,String cxItem) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("time2", time);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("cxItem", cxItem);		
		return activeCollectMoneyLogMapper.gainTotalMoneyRank(map);
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainTotalPoint
	 * @Description: TODO(查询今日、昨日、本月的上传和校对采用获得的总经验值)
	 * @param memberId
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param cxItem
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainTotalPoint(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long gainTotalPoint(String memberId,Integer time,String startTime,String endTime,String cxItem) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("time2", time);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("cxItem", cxItem);
		return activeCollectPointLogMapper.gainTotalPoint(map);
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainTotalPointRank
	 * @Description: TODO(查询今日、昨日、本月的上传和校对采用获得的总经验值的总排名)
	 * @param memberId
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @param cxItem
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainTotalPointRank(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long gainTotalPointRank(String memberId,Integer time,String startTime,String endTime,String cxItem) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("time2", time);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("cxItem", cxItem);		
		return activeCollectPointLogMapper.gainTotalPointRank(map);
	}

	/** (non-Javadoc)
	 * @Title: gainByMemberLastName
	 * @Description: TODO(根据会员昵称查询(用于修改))
	 * @param memberId
	 * @param lastName
	 * @param update
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainByMemberLastName(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Member> gainByMemberLastName(String memberId,
			String lastName, String update) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", memberId);
		map.put("lastname", lastName);
		map.put("update", update);
		return memberMapper.gainByMemberLastName(map);
	}

	/** (non-Javadoc)
	 * @Title: gainListForUploadRankByTime
	 * @Description: TODO(数据上传排行榜)
	 * @param time
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainListForUploadRankByTime(java.lang.Integer)
	 */
	@Override
	public List<ActiveCollectGoods> gainListForUploadRankByTime(Integer time) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("time", time);
		List<ActiveCollectGoods> topList = activeCollectGoodsMapper.gainListForUploadRankByTime(map);
		if(topList!=null && topList.size()>0){
			for (ActiveCollectGoods acg : topList) {
				if(acg.getMemberid()!=null){
					acg.setMemName(memberMapper.gainMemberById(acg.getMemberid()).getUsername());
				}
			}			
		}
		return topList;
	}
	/** (non-Javadoc)
	 * @Title: gainUploadCountByMemberId
	 * @Description: TODO(根据会员id,上传通过标示查询上传且审核通过的数据条数)
	 * @param map
	 * @return
	 * @see com.qlzy.active.service.MemberCenterService#gainUploadCountByMemberId(java.util.Map)
	 */
	@Override
	public Long gainUploadCountByMemberId(String memberId, Integer status) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberid", memberId);
		map.put("status", status);
		return activeCollectGoodsMapper.gainUploadCountByMemberId(map);
	}
	/* (non-Javadoc)
	 * @see com.qlzy.active.service.MemberCenterService#batchUpdateDisableMobile(java.util.List)
	 */
	@Override
	public void batchUpdateDisableMobile(List<Member> mobileList) {
		// TODO Auto-generated method stub
		memberMapper.batchUpdateDisableMobile(mobileList);
	}

	/* (non-Javadoc)
	 * @see com.qlzy.active.service.MemberCenterService#batchUpdateEnableMobile(java.util.List)
	 */
	@Override
	public void batchUpdateEnableMobile(List<Member> mobileList) {
		// TODO Auto-generated method stub
		memberMapper.batchUpdateEnableMobile(mobileList);
	}
	
}
