/**  
 * @Title: MemberCenterAction.java 
 * @Package com.qlzy.active.action 
 * @Description: TODO(会员中心管理)
 * @author wangmei  
 * @date 2013-6-18 上午10:11:50
 * @version V1.0  
 */
package com.qlzy.active.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.active.service.MemberCenterService;
import com.qlzy.common.excel.ReadExcel;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.mainPage.regions.service.RegionsService;
import com.qlzy.model.ActiveCollectGoods;
import com.qlzy.model.Member;
import com.qlzy.model.MemberJob;
import com.qlzy.model.Regions;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;

@Namespace("/")
@Action(value = "memberCenterManager", results = {
		@Result(name = "toMemberCenterPage", location = "/active/memberCenterManager.jsp"),
		@Result(name = "toDataStatisticsPage", location = "/active/dataStatistics.jsp"),
		@Result(name = "showMemberInfo", location = "/active/include/memberInfo.jsp"),
		@Result(name = "toUpdateMember", location = "/active/memberUpdate.jsp"),
		@Result(name = "updateMember", location = "/active/memberCenterManager.jsp"),
		@Result(name = "toDataManagerPage", location = "/active/dataManager.jsp"),
		@Result(name = "toDataUploadTopPage", location = "/active/include/dataUploadTopList.jsp")
})
public class MemberCenterAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	/**
	 * 记录日志
	 */
	private Logger logger = Logger.getLogger(MemberCenterAction.class);
	
	@Resource
	private MemberCenterService memberCenterService;
	@Resource
	private RegionsService regionsService;
	
	private Member member = new Member();//会员实体类
	private Map<String, Object> memberMap = new HashMap<String, Object>();
	private Map<String, Object> dataStatisticsMap = new HashMap<String, Object>();
	private List list = new ArrayList();//上传或校对数据列表
	private String mark;//标示
	private List<MemberJob> memberJobs = new ArrayList<MemberJob>();
	private List<ActiveCollectGoods> topList = new ArrayList<ActiveCollectGoods>();
	private String startTime;
	private String endTime;
	private String cxItem;
	private Integer time;
	private Integer time1;
	private Integer time2;
	private String areaSize;
	
	private List<Regions> provinceList;//省份列表
	private List<Regions> cityList;//市列表
	private List<Regions> areaList;//区列表
	
	/**
	 * @Title: toMemberCenterPage
	 * @Description: TODO(转向会员中心会员信息页面)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author wangmei
	 */
	public String toMemberCenterPage(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		member = memberCenterService.gainMemberById(sessionInfo.getUserId());
		return "toMemberCenterPage";
	}
	
	/**
	 * @Title: showMemberInfo
	 * @Description: TODO(展示会员信息)
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public String showMemberInfo(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		member = memberCenterService.gainMemberById(sessionInfo.getUserId());
		//上传数据
		Long uploadCount = memberCenterService.gainUploadCount(sessionInfo.getUserId(), null);
		//上传采用
		Long passUploadCount = memberCenterService.gainUploadCount(sessionInfo.getUserId(), 1);
		//上传累计经验值
		Long uploadAddUpPoint = memberCenterService.gainUploadAddUpPoint(sessionInfo.getUserId());
		//上传累计奖金
		Double uploadAddUpMoney = memberCenterService.gainUploadAddUpMoney(sessionInfo.getUserId());
		memberMap.put("member", member);
		memberMap.put("uploadCount", uploadCount);
		memberMap.put("passUploadCount", passUploadCount);
		memberMap.put("uploadAddUpPoint", uploadAddUpPoint);
		memberMap.put("uploadAddUpMoney", uploadAddUpMoney);
		
		//校对数据
		Long checkCount = memberCenterService.gainCheckCount(sessionInfo.getUserId(), null);
		//校对采用
		Long passCheckCount = memberCenterService.gainCheckCount(sessionInfo.getUserId(), 1);
		//校对累计经验值
		Long checkAddUpPoint = memberCenterService.gainCheckAddUpPoint(sessionInfo.getUserId());
		//校对累计奖金
		Double checkAddUpMoney = memberCenterService.gainCheckAddUpMoney(sessionInfo.getUserId());
		memberMap.put("checkCount", checkCount);
		memberMap.put("passCheckCount", passCheckCount);
		memberMap.put("checkAddUpPoint", checkAddUpPoint);
		memberMap.put("checkAddUpMoney", checkAddUpMoney);
		return "showMemberInfo";
	}
	
	/**
	 * 调用
	 */
	private List<Regions> gainCityList(String proId){
		return regionsService.gainCityListByPid(proId);
	}
	private List<Regions> gainAreaList(String cityId){
		return regionsService.gainAreaListByCityId(cityId);
	}
	
	/**
	 * @Title: toUpdateMember
	 * @Description: TODO(跳转会员信息修改页面)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author wangmei
	 */
	public String toUpdateMember(){
		//会员详细信息
		member = memberCenterService.gainMemberById(member.getId());
		//从事领域列表
		memberJobs = memberCenterService.gainMemberJobList();
		//省份列表
		provinceList = regionsService.gainProvinceList();
		//市列表
		cityList = gainCityList(member.getProvince());
		//区列表
		areaList = gainAreaList(member.getCity());
		if(areaList.size()==0){
			areaSize = "0";
		}
		return "toUpdateMember";
	}
	
	/**
	 * @Title: getCitys
	 * @Description: TODO(根据省份获取城市列表)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author wangmei
	 */
	public void getCitys(){
		writeJson(gainCityList(member.getProvince()));
	}
	
	/**
	 * @Title: getAreas
	 * @Description: TODO(根据市获取区列表)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author wangmei
	 */
	public void getAreas(){
		writeJson(gainAreaList(member.getCity()));
	}
	
	/**
	 * @Title: gainCheckLastName
	 * @Description: TODO(会员信息修改时查询验证会员昵称是否存在)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author wangmei
	 */
	public void gainCheckLastName() {
		String result = "";
		List<Member> memberList = new ArrayList<Member>();
		try {
			if(member.getLastname()!=null && member.getLastname().length()>0){
				memberList = memberCenterService.gainByMemberLastName(member.getId(), member.getLastname(), "1");
			}else{
				memberList = memberCenterService.gainByMemberLastName(member.getId(), member.getFirstname(), null);
			}
			if(memberList!=null && memberList.size()>0){
				result = "exist";
			}
		} catch (Exception e) {
			result = "fail";
			logger.error("gainCheckLastName", e);
			e.printStackTrace();
		}
		super.writeJson(result);
	}
	
	/**
	 * @Title: updateMember
	 * @Description: TODO(会员信息修改)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author wangmei
	 */
	public void updateMember(){
		String result = "";
		try {
			if(member.getFirstname()!=null && member.getFirstname().length()>0){
				member.setLastname(member.getFirstname());
			}else{
				member.setFirstname(null);
			}
			//便于市下无县或区用
			if(null == member.getArea()){
				member.setArea("");
			}
			if("0" == member.getArea()){
				member.setArea("");
			}
			memberCenterService.updateMember(member);
			result = "success";
		} catch (Exception e) {
			result = "fail";
			logger.error("updateMember", e);
			e.printStackTrace();
		}
		writeJson(result);
	}
	
	/**
	 * @Title: toDataManagerPage
	 * @Description: TODO(跳转数据管理页面)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author wangmei
	 */
	public String toDataManagerPage(){
		if(null == mark || "".equals(mark)){
			mark = "1";
		}
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(10L);
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		try {
			if(mark.equals("1")){
				map.put("memberid", sessionInfo.getUserId());
				pagination.setTotalCount(memberCenterService.gainActiveCollectGoodsTotalCount(map));
				list = memberCenterService.gainActiveCollectGoodsList(map);
			}else{
				map.put("memberId", sessionInfo.getUserId());
				pagination.setTotalCount(memberCenterService.gainCheckActiveCollectGoodsTotalCount(map));
				list = memberCenterService.gainCheckActiveCollectGoodsList(map);
			}
		} catch (Exception e) {
			logger.error("toDataManagerPage", e);
			e.printStackTrace();
		}
		request.setAttribute("pagination", pagination);
		return "toDataManagerPage";
	}
	
	/**
	 * @Title: toDataStatisticsPage
	 * @Description: TODO(跳转数据统计页面)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author wangmei
	 */
	public String toDataStatisticsPage(){
		if((null==time||"".equals(time)) || (null==time1||"".equals(time1)) ||(null==time2||"".equals(time2))){
			time = 1;
			time1 = 1;
			time2 = 1;
		}
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		member = memberCenterService.gainMemberById(sessionInfo.getUserId());
		/**
		 * 上传数据统计
		 */
		Long uploadCount = memberCenterService.gainUploadCountByTime(member.getId(), null, time, startTime, endTime, cxItem);
		Long uploadPassCount = memberCenterService.gainUploadCountByTime(member.getId(), 1, time, startTime, endTime, cxItem);
		Long uploadRank = memberCenterService.gainUploadRankByTime(member.getId(), null, time, startTime, endTime, cxItem);
		Long uploadPassRank = memberCenterService.gainUploadRankByTime(member.getId(), 1, time, startTime, endTime, cxItem);
		Long uploadPassGetPoint = memberCenterService.gainUploadGetPoint(member.getId(), time, startTime, endTime, cxItem);
		Double uploadPassGetMoney = memberCenterService.gainUploadGetMoney(member.getId(),time, startTime, endTime, cxItem);
		uploadRank = uploadRank==null?0:uploadRank;
		uploadPassRank = uploadPassRank==null?0:uploadPassRank;
		dataStatisticsMap.put("uploadCount", uploadCount);
		dataStatisticsMap.put("uploadPassCount", uploadPassCount);
		dataStatisticsMap.put("uploadRank", uploadRank);
		dataStatisticsMap.put("uploadPassRank", uploadPassRank);
		dataStatisticsMap.put("uploadPassGetPoint", uploadPassGetPoint);
		dataStatisticsMap.put("uploadPassGetMoney", uploadPassGetMoney);
		
		/**
		 * 校对数据统计
		 */
		Long checkCount = memberCenterService.gainCheckCountByTime(member.getId(), null, time1, startTime, endTime, cxItem);
		Long checkPassCount = memberCenterService.gainCheckCountByTime(member.getId(), 1, time1, startTime, endTime, cxItem);
		Long checkRank = memberCenterService.gainCheckRankByTime(member.getId(), null, time1, startTime, endTime, cxItem);
		Long checkPassRank = memberCenterService.gainCheckRankByTime(member.getId(), 1, time1, startTime, endTime, cxItem);
		Long checkPassGetPoint = memberCenterService.gainCheckGetPoint(member.getId(), time1, startTime, endTime, cxItem);
		Double checkPassGetMoney = memberCenterService.gainCheckGetMoney(member.getId(), time1, startTime, endTime, cxItem);
		checkRank = checkRank==null?0:checkRank;
		checkPassRank = checkPassRank==null?0:checkPassRank;
		dataStatisticsMap.put("checkCount", checkCount);
		dataStatisticsMap.put("checkPassCount", checkPassCount);
		dataStatisticsMap.put("checkRank", checkRank);
		dataStatisticsMap.put("checkPassRank", checkPassRank);
		dataStatisticsMap.put("checkPassGetPoint", checkPassGetPoint);
		dataStatisticsMap.put("checkPassGetMoney", checkPassGetMoney);
		
		/**
		 * 经验值奖金统计
		 */
		Long totalPoint = memberCenterService.gainTotalPoint(member.getId(), time2, startTime, endTime, cxItem);
		Long totalPointRank = memberCenterService.gainTotalPointRank(member.getId(), time2, startTime, endTime, cxItem);
		Double totalMoney = memberCenterService.gainTotalMoney(member.getId(), time2, startTime, endTime, cxItem);
		Long totalMoneyRank = memberCenterService.gainTotalMoneyRank(member.getId(), time2, startTime, endTime, cxItem);
		totalPointRank = totalPointRank==null?0:totalPointRank;
		totalMoneyRank = totalMoneyRank==null?0:totalMoneyRank;		
		dataStatisticsMap.put("totalPoint", totalPoint);
		dataStatisticsMap.put("totalPointRank", totalPointRank);
		dataStatisticsMap.put("totalMoney", totalMoney);
		dataStatisticsMap.put("totalMoneyRank", totalMoneyRank);
		
		return "toDataStatisticsPage";
	}
	
	/**
	 * @Title: toDataUploadTopPage
	 * @Description: TODO(数据上传排行榜)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author wangmei
	 */
	public String toDataUploadTopPage(){
		topList = memberCenterService.gainListForUploadRankByTime(time);
		return "toDataUploadTopPage";
	}
	public void toDataUploadTopPage1(){
		topList = memberCenterService.gainListForUploadRankByTime(time);
		writeJson(topList);
	}
	
	
	
	public void ExcelUpdateMember(){
		ReadExcel re = new ReadExcel();
		List<Member>  mobileList = null;
			try {
				mobileList = re.readXlsOrXlsx();
				if(null != mobileList && mobileList.size() > 0){	
				     memberCenterService.batchUpdateDisableMobile(mobileList);
				     memberCenterService.batchUpdateEnableMobile(mobileList);
				}else{
					logger.info("excel读取的内容为空-----------");
				}
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Map<String, Object> getMemberMap() {
		return memberMap;
	}

	public void setMemberMap(Map<String, Object> memberMap) {
		this.memberMap = memberMap;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public List<MemberJob> getMemberJobs() {
		return memberJobs;
	}

	public void setMemberJobs(List<MemberJob> memberJobs) {
		this.memberJobs = memberJobs;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCxItem() {
		return cxItem;
	}

	public void setCxItem(String cxItem) {
		this.cxItem = cxItem;
	}

	public Map<String, Object> getDataStatisticsMap() {
		return dataStatisticsMap;
	}

	public void setDataStatisticsMap(Map<String, Object> dataStatisticsMap) {
		this.dataStatisticsMap = dataStatisticsMap;
	}

	public List<Regions> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Regions> provinceList) {
		this.provinceList = provinceList;
	}

	public List<Regions> getCityList() {
		return cityList;
	}

	public void setCityList(List<Regions> cityList) {
		this.cityList = cityList;
	}

	public List<Regions> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Regions> areaList) {
		this.areaList = areaList;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getTime1() {
		return time1;
	}

	public void setTime1(Integer time1) {
		this.time1 = time1;
	}

	public Integer getTime2() {
		return time2;
	}

	public void setTime2(Integer time2) {
		this.time2 = time2;
	}

	public List<ActiveCollectGoods> getTopList() {
		return topList;
	}

	public void setTopList(List<ActiveCollectGoods> topList) {
		this.topList = topList;
	}

	public String getAreaSize() {
		return areaSize;
	}

	public void setAreaSize(String areaSize) {
		this.areaSize = areaSize;
	}
}
