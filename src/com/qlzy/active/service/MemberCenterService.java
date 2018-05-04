/**  
 * @Title: MemberService.java 
 * @Package com.qlzy.active.service 
 * @Description: TODO(会员中心管理接口类)
 * @author wangmei  
 * @date 2013-6-18 下午2:27:41
 * @version V1.0  
 */
package com.qlzy.active.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.ActiveCollectGoods;
import com.qlzy.model.ActiveCollectGoodsCheck;
import com.qlzy.model.Member;
import com.qlzy.model.MemberJob;

public interface MemberCenterService {
	
	/**
	 * @Title: gainMemberById
	 * @Description: TODO(根据id查询会员信息)
	 * @param @return    设定文件
	 * @return Member    返回类型
	 * @author wangmei
	 */
	public Member gainMemberById(String id);
	
	/**
	 * @Title: gainUploadCount
	 * @Description: TODO(根据会员id,上传通过标示查询上传的数据条数)
	 * @param @param memberId
	 * @param @param status
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainUploadCount(String memberId, Integer status);
	/**
	 * @Title: gainUploadCountByMemberId
	 * @Description: TODO(根据会员id上传数据且通过的数据条数)
	 * @param @param memberId
	 * @param @param status
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author
	 */
	public Long gainUploadCountByMemberId(String memberId, Integer status);
	
	/**
	 * @Title: gainCheckCount
	 * @Description: TODO(根据会员id,校对通过标示查询校对的数据条数)
	 * @param @param memberId
	 * @param @param status
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainCheckCount(String memberId, Integer status);
	
	/**
	 * @Title: gainActiveCollectGoodsList
	 * @Description: TODO(根据会员id查询上传数据信息)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ActiveCollectGoods>    返回类型
	 * @author wangmei
	 */
	public List<ActiveCollectGoods> gainActiveCollectGoodsList(Map<String, Object> map);
	
	/**
	 * @Title: gainActiveCollectGoodsTotalCount
	 * @Description: TODO(获取上传数据总行数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainActiveCollectGoodsTotalCount(Map<String, Object> map);
	
	/**
	 * @Title: gainCheckActiveCollectGoodsList
	 * @Description: TODO(根据会员id查询校对的数据信息)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ActiveCollectGoodsCheck>    返回类型
	 * @author wangmei
	 */
	public List<ActiveCollectGoodsCheck> gainCheckActiveCollectGoodsList(Map<String, Object> map);
	
	/**
	 * @Title: gainCheckActiveCollectGoodsTotalCount
	 * @Description: TODO(获取校对数据总行数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainCheckActiveCollectGoodsTotalCount(Map<String, Object> map);
	
	/**
	 * @Title: gainUploadAddUpPoint
	 * @Description: TODO(查询会员上传累计经验值)
	 * @param @param memberId
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainUploadAddUpPoint(String memberId);
	
	/**
	 * @Title: gainUploadAddUpMoney
	 * @Description: TODO(查询会员上传累计奖金)
	 * @param @param memberId
	 * @param @return    设定文件
	 * @return Double    返回类型
	 * @author wangmei
	 */
	public Double gainUploadAddUpMoney(String memberId);
	
	/**
	 * @Title: gainCheckAddUpPoint
	 * @Description: TODO(查询会员校对累计经验值)
	 * @param @param memberId
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainCheckAddUpPoint(String memberId);
	
	/**
	 * @Title: gainCheckAddUpMoney
	 * @Description: TODO(查询会员校对累计讲奖金)
	 * @param @param memberId
	 * @param @return    设定文件
	 * @return Double    返回类型
	 * @author wangmei
	 */
	public Double gainCheckAddUpMoney(String memberId);
	
	/**
	 * @Title: updateMember
	 * @Description: TODO(修改会员信息)
	 * @param @param member    设定文件
	 * @return void    返回类型
	 * @author wangmei
	 */
	public void updateMember(Member member);
	
	/**
	 * @Title: gainMemberJobList
	 * @Description: TODO(查询从事领域列表)
	 * @param @return    设定文件
	 * @return List<MemberJob>    返回类型
	 * @author wangmei
	 */
	public List<MemberJob> gainMemberJobList();
	
	/**
	 * @Title: gainUploadCountByTime
	 * @Description: TODO(查询今日、昨日、本月的上传数据统计)
	 * @param @param memberId
	 * @param @param status
	 * @param @param time
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param cxItem
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainUploadCountByTime(String memberId,Integer status,Integer time,String startTime,String endTime,String cxItem);
	
	/**
	 * @Title: gainUploadRankByTime
	 * @Description: TODO(查询今日、昨日、本月的上传数据总排名)
	 * @param @param memberId
	 * @param @param status
	 * @param @param time
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param cxItem
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainUploadRankByTime(String memberId,Integer status,Integer time,String startTime,String endTime,String cxItem);
	
	/**
	 * @Title: gainUploadGetPoint
	 * @Description: TODO(查询今日、昨日、本月的上传数据采用获得的经验值)
	 * @param @param memberId
	 * @param @param time
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param cxItem
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainUploadGetPoint(String memberId,Integer time,String startTime,String endTime,String cxItem);
	
	/**
	 * @Title: gainUploadGetMoney
	 * @Description: TODO(查询今日、昨日、本月的上传数据采用获得的奖金)
	 * @param @param memberId
	 * @param @param time
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param cxItem
	 * @param @return    设定文件
	 * @return Double    返回类型
	 * @author wangmei
	 */
	public Double gainUploadGetMoney(String memberId,Integer time,String startTime,String endTime,String cxItem);
	
	/**
	 * @Title: gainCheckCountByTime
	 * @Description: TODO(查询今日、昨日、本月的校对数据统计)
	 * @param @param memberId
	 * @param @param status
	 * @param @param time
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param cxItem
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainCheckCountByTime(String memberId,Integer status,Integer time,String startTime,String endTime,String cxItem);
	
	/**
	 * @Title: gainCheckRankByTime
	 * @Description: TODO(查询今日、昨日、本月的校对数据总排名)
	 * @param @param memberId
	 * @param @param status
	 * @param @param time
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param cxItem
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainCheckRankByTime(String memberId,Integer status,Integer time,String startTime,String endTime,String cxItem);
	
	/**
	 * @Title: gainCheckGetPoint
	 * @Description: TODO(查询今日、昨日、本月的校对数据采用获得的经验值)
	 * @param @param memberId
	 * @param @param time
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param cxItem
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainCheckGetPoint(String memberId,Integer time,String startTime,String endTime,String cxItem);
	
	/**
	 * @Title: gainCheckGetMoney
	 * @Description: TODO(查询今日、昨日、本月的校对数据采用获得的奖金)
	 * @param @param memberId
	 * @param @param time
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param cxItem
	 * @param @return    设定文件
	 * @return Double    返回类型
	 * @author wangmei
	 */
	public Double gainCheckGetMoney(String memberId,Integer time,String startTime,String endTime,String cxItem);
	
	/**
	 * @Title: gainTotalMoney
	 * @Description: TODO(查询今日、昨日、本月的上传和校对采用获得的总奖金)
	 * @param @param memberId
	 * @param @param time
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param cxItem
	 * @param @return    设定文件
	 * @return Double    返回类型
	 * @author wangmei
	 */
	public Double gainTotalMoney(String memberId,Integer time,String startTime,String endTime,String cxItem);
	
	/**
	 * @Title: gainTotalMoneyRank
	 * @Description: TODO(查询今日、昨日、本月的上传和校对采用获得的总奖金的总排名)
	 * @param @param memberId
	 * @param @param time
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param cxItem
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainTotalMoneyRank(String memberId,Integer time,String startTime,String endTime,String cxItem);
	
	/**
	 * @Title: gainTotalPoint
	 * @Description: TODO(查询今日、昨日、本月的上传和校对采用获得的总经验值)
	 * @param @param memberId
	 * @param @param time
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param cxItem
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainTotalPoint(String memberId,Integer time,String startTime,String endTime,String cxItem);
	
	/**
	 * @Title: gainTotalPointRank
	 * @Description: TODO(查询今日、昨日、本月的上传和校对采用获得的总经验值的总排名)
	 * @param @param memberId
	 * @param @param time
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param cxItem
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public Long gainTotalPointRank(String memberId,Integer time,String startTime,String endTime,String cxItem);
	
	/**
	 * @Title: gainByMemberLastName
	 * @Description: TODO(根据会员昵称查询(用于修改))
	 * @param @param memberId
	 * @param @param lastName
	 * @param @param update
	 * @param @return    设定文件
	 * @return List<Member>    返回类型
	 * @author wangmei
	 */
	public List<Member> gainByMemberLastName(String memberId,String lastName,String update);
	
	/**
	 * @Title: gainListForUploadRankByTime
	 * @Description: TODO(数据上传排行榜)
	 * @param @param time
	 * @param @return    设定文件
	 * @return List<ActiveCollectGoods>    返回类型
	 * @author wangmei
	 */
	public List<ActiveCollectGoods> gainListForUploadRankByTime(Integer time);

	/**
	 * @Title: batchUpdateDisableMobile
	 * @Description:
	 * @date 2017-1-11 上午10:27:20 
	 * @param @param mobileList 设定文件
	 * @return void 返回类型
	 * @throws
	 * @version V1.0
	 */
	public void batchUpdateDisableMobile(List<Member> mobileList);

	/**
	 * @Title: batchUpdateEnableMobile
	 * @Description:
	 * @date 2017-1-11 上午10:27:42 
	 * @param @param mobileList 设定文件
	 * @return void 返回类型
	 * @throws
	 * @version V1.0
	 */
	public void batchUpdateEnableMobile(List<Member> mobileList);
}
