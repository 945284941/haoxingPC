/**??
* @Title: PointDetailAction.java
* @Package com.qlzy.memberCenter.person.point
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-10-5 上午10:01:25
* @version V1.0??
*/
package com.qlzy.memberCenter.person.point.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.memberCenter.person.point.service.PointDetailService;
import com.qlzy.memberCenter.statistics.service.StatisticsService;
import com.qlzy.model.CourtesyMember;
import com.qlzy.model.PointDetail;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;

/**
 * @ClassName: PointDetailAction
 * @Description: TODO(经验值管理)
 * @author  zhao  yang bin 
 * @date 2013-10-5 上午10:01:25
 *
 */
@Namespace("/")
@Action(value = "pointDetail", results = {
		@Result(name = "toPointList", location = "/memberCenter/person/pointCenter/myPoint.jsp"),
		@Result(name = "toBalance", location = "/memberCenter/person/pointCenter/pointBalance.jsp"),
		@Result(name = "toPointListCompany", location = "/memberCenter/company/pointCenter/myPoint.jsp"),
		@Result(name = "toBalanceCompany", location = "/memberCenter/company/pointCenter/pointBalance.jsp"),
		@Result(name = "youhuiquan", location = "/memberCenter/person/moneyCenter/youhuiquan.jsp"),
		@Result(name = "toList",type="redirect", location = "pointDetail!gainPointList.action")
		
})
public class PointDetailAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Autowired
	private PointDetailService pointDetailService;
	
	private List<PointDetail> pointDetailList;
	
	private String pointType;
	
	private SessionInfo sessionInfo;
	
	private List<CourtesyMember> courtesyMemberList;
	
	@Resource
	private StatisticsService statisticsService;// 统计信息接口类
	
	private StatisticsInfo pointStatisticsInfo;// 经验值统计
	
//	private String pointId;
	
	public String gainPointList(){
		Boolean isB=true;
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows
		map.put("page", (pagination.getPage()-1)*pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("userId", sessionInfo.getUserId());
		if(pointType!=null && !pointType.equals("") ){
			if(pointType.equals("10")){
				isB=false;
			}else{
				map.put("pointType", pointType);
			}
		}
		pointDetailList = pointDetailService.gainPointList(map);
		pagination.setTotalCount(pointDetailService.gainPointListCount(map));
		request.setAttribute("pagination", pagination);
		if(isB){
			if(sessionInfo.getUserType().equals("company")){
				return "toPointListCompany";
			}else{
				return "toPointList";
			}
		}else{
			if(sessionInfo.getUserType().equals("company")){
				return "toBalanceCompany";
			}else{
				return "toBalance";
			}
		}
		
	}
	public String gainYouhuiquanList(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", sessionInfo.getUserId());
		courtesyMemberList = pointDetailService.gainYouhuiquanList(map);
		return "youhuiquan";
	}
	
	/**
	 * 经验值列表右端显示栏
	 * 
	 * */
	public void statisticsPoint(){
		// 经验值统计
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		pointStatisticsInfo = statisticsService.gainPointStatisticsByTime("0", sessionInfo);
		writeJson(pointStatisticsInfo);
	}
//	public String  deletePointList(){
//		pointDetailService.deletePointList(pointId);
//		return "toList";
//	}

	public List<PointDetail> getPointDetailList() {
		return pointDetailList;
	}

	public void setPointDetailList(List<PointDetail> pointDetailList) {
		this.pointDetailList = pointDetailList;
	}

	public String getPointType() {
		return pointType;
	}

	public void setPointType(String pointType) {
		this.pointType = pointType;
	}
//	public String getPointId() {
//		return pointId;
//	}
//	public void setPointId(String pointId) {
//		this.pointId = pointId;
//	}
	public List<CourtesyMember> getCourtesyMemberList() {
		return courtesyMemberList;
	}
	public void setCourtesyMemberList(List<CourtesyMember> courtesyMemberList) {
		this.courtesyMemberList = courtesyMemberList;
	}
	
}
