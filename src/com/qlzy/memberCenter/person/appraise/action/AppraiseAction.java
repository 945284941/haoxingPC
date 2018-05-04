/**??
* @Title: AppraiseAction.java
* @Package com.qlzy.memberCenter.person
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-10-7 下午2:09:22
* @version V1.0??
*/
package com.qlzy.memberCenter.person.appraise.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qlzy.common.util.PcOrWap;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.memberCenter.person.appraise.service.AppraiseService;
import com.qlzy.model.Appraise;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.aliyun.mns.client.impl.AbstractAction.logger;

/**
 * @ClassName: AppraiseAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhao yang bin
 * @date 2013-10-7 下午2:09:22
 *
 */
@Namespace("/")
@Action(value = "appraise", results = {
		@Result(name = "showGoodsAppraiseList", location = "/admin/goods/goodsAppraise.jsp"),
		@Result(name = "toList", location = "/memberCenter/person/appraise/myAppraise.jsp"),
		@Result(name = "memberAppraise", type="redirect", location = "orderAction!gainOrders.action"),
		@Result(name = "toCompanyList", location = "/memberCenter/company/appraise/myAppraise.jsp")
})
public class AppraiseAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Autowired
	private AppraiseService appraiseService;
	private SessionInfo sessionInfo;
	private List<Appraise> appraiseList;
	private Appraise appraise;
	private String appraiseType;//
	private String goodsId;
	private StatisticsInfo appraiseStatisticsInfo;//统计

	public String gainGoodsAppraiseList(){
		Pagination pagination = definationPagination(request);
		pagination.setRows(2L);//设置每页显示几条数据
		//查询该商品的评论信息分页
		Map<String,Object> parmMap = new HashMap<>();
		parmMap.put("appraiseType",appraiseType);
		parmMap.put("goodsId",goodsId);
		Long count = appraiseService.selectAppariseByTypeAndPageCount(parmMap);
		pagination.setTotalCount(count);
		parmMap.put("rows", pagination.getRows());
		parmMap.put("page", (pagination.getPage()-1)*pagination.getRows());
		appraiseList = appraiseService.selectAppariseByTypeAndPage(parmMap);
		request.setAttribute("pagination", pagination);
		return PcOrWap.isPc(request,"showGoodsAppraiseList");
	}


	public String gainAppraiseList(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows
		map.put("page", (pagination.getPage()-1)*pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("userId", sessionInfo.getUserId());
		//判断是企业会员还是个人会员
		if(sessionInfo.getUserType().equals("company")){
			if(appraiseType!=null && !appraiseType.equals("")){
				appraiseList = appraiseService.gainAppraiseListByType(map);
				pagination.setTotalCount(appraiseService.gainAppraiseListCountByType(map));
			}else{
				appraiseList = appraiseService.gainAppraiseList(map);
				pagination.setTotalCount(appraiseService.gainAppraiseListCount(map));
			}
			request.setAttribute("pagination", pagination);
			return "toCompanyList";
		}else{
			appraiseList = appraiseService.gainAppraiseList(map);
			pagination.setTotalCount(appraiseService.gainAppraiseListCount(map));
			request.setAttribute("pagination", pagination);
			return "toList";
		}
		
	}
	
	/**
	 * 会员进行评价
	* @Title: memberAppraise
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public String memberAppraise(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		appraise.setId(ToolsUtil.getUUID());
		appraise.setMemberId(sessionInfo.getUserId());
		appraise.setCreatetime(new Date());
		appraise.setSincerity(appraise.getServe()+appraise.getCredit()+appraise.getQuality()+appraise.getLogistics());
		appraiseService.memberAppraise(appraise);
		return "memberAppraise";
	}
	//个人评论右侧显示
	public void statisticsAppraise(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		appraiseStatisticsInfo=appraiseService.gainAllCountRight(sessionInfo.getUserId());
		writeJson(appraiseStatisticsInfo);
		
	}
	//企业评论右侧显示
	public void statisticsAppraiseByCompany(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		appraiseStatisticsInfo=appraiseService.gainAllCountRightByCompany(sessionInfo.getUserId());
		writeJson(appraiseStatisticsInfo);
		
	}
	
	public List<Appraise> getAppraiseList() {
		return appraiseList;
	}

	public void setAppraiseList(List<Appraise> appraiseList) {
		this.appraiseList = appraiseList;
	}

	/**
	 * @return the appraise
	 */
	public Appraise getAppraise() {
		return appraise;
	}

	/**
	 * @param appraise the appraise to set
	 */
	public void setAppraise(Appraise appraise) {
		this.appraise = appraise;
	}

	public StatisticsInfo getAppraiseStatisticsInfo() {
		return appraiseStatisticsInfo;
	}

	public void setAppraiseStatisticsInfo(StatisticsInfo appraiseStatisticsInfo) {
		this.appraiseStatisticsInfo = appraiseStatisticsInfo;
	}

	public String getAppraiseType() {
		return appraiseType;
	}

	public void setAppraiseType(String appraiseType) {
		this.appraiseType = appraiseType;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
}
