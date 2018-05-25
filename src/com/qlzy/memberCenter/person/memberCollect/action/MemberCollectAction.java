/**  
* @Title: CollectAction.java
* @Package com.qlzy.memberCenter.person.collect.action
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-10-9 下午2:47:23
* @version V1.0  
*/
package com.qlzy.memberCenter.person.memberCollect.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ModelDriven;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.pojo.Json;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService;
import com.qlzy.memberCenter.statistics.service.StatisticsService;
import com.qlzy.model.Company;
import com.qlzy.model.MemberCollect;
import com.qlzy.model.Views;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;

/**
 * @ClassName: CollectAction 有关收藏的Action
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-10-9 下午2:47:23
 */
@Namespace("/")
@Action(value = "memberCollectAction", results = {
		@Result(name = "toPersonGoodsCollect", location = "/memberCenter/person/orders/goodsCollect.jsp"),
		@Result(name = "toPersonGoodsViews", location = "/memberCenter/person/orders/goodsViews.jsp"),
		@Result(name = "toPersonGoodsViewsByShop", location = "/memberCenter/person/orders/shopViews.jsp"),
		@Result(name = "toPersonGoodsCollectByShop", location = "/memberCenter/person/orders/shopCollect.jsp"),

		})
public class MemberCollectAction extends BaseAction implements ModelDriven<MemberCollect>{
	
	/**
	* @ClassName: com.qlzy.memberCenter.person.memberCollect.actionMemberCollectAction.java
	* @Description: TODO(这里用一句话描述这个类的作用)
	* @author 周张豹
	* @date 2013-10-9 下午3:37:24
	*/
	private static final long serialVersionUID = 1L;
	public MemberCollect memberCollect=new MemberCollect();
	@Resource
	private MemberCollectService memberCollectService;
	@Resource
	private StatisticsService statisticsService;// 统计信息接口类

	private List<MemberCollect> memberCollects;
	private List<Views> viewsList;
	private List<Company> companies;
	private SessionInfo sessionInfo;
	private Date startTime ;
	private Date endTime;
	private StatisticsInfo collectStatisticsInfo;// 收藏统计
	private StatisticsInfo browseStatisticsInfo;// 浏览统计
	/**
	 * 跳转到个人会员中的商品收藏列表页面
	* @Title: toPersonGoodsCollect
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public String toPersonGoodsCollect(){
		try {
			sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			Map<String, Object> map = new HashMap<String, Object>();
			Pagination pagination = definationPagination(request);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 设置每页显示几条数据
			pagination.setRows(8L);
			map.put("page", (pagination.getPage()-1)*pagination.getRows());
			map.put("rows", pagination.getRows());
			map.put("userId", sessionInfo.getUserId());
			map.put("userType", sessionInfo.getUserType());
			map.put("type", "goods");
			if (startTime != null && !"".equals(startTime)) {
				map.put("startTime", startTime);
				request.setAttribute("startTimeStr", sf.format(startTime));
			}
			if (endTime != null && !"".equals(endTime)) {
				map.put("endTime", endTime);
				request.setAttribute("endTimeStr", sf.format(endTime));
			}
			
			pagination.setTotalCount(memberCollectService.gainMemberCollectLong(map));
			memberCollects = memberCollectService.gainMemberCollectList(map);
			request.setAttribute("pagination", pagination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "toPersonGoodsCollect";
	}
	/**
	 * 跳转到个人会员中的浏览过的商品列表页面
	 * @Title: toPersonGoodsCollect
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 周张豹
	 */
	public String toPersonGoodsViews(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 设置每页显示几条数据
		pagination.setRows(6L);
		map.put("page", (pagination.getPage()-1)*pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("userId", sessionInfo.getUserId());
		map.put("userType", sessionInfo.getUserType());
		map.put("type", "goods");
		if (startTime != null && !"".equals(startTime)) {
			map.put("startTime", startTime);
			request.setAttribute("startTimeStr", sf.format(startTime));
		}
		if (endTime != null && !"".equals(endTime)) {
			map.put("endTime", endTime);
			request.setAttribute("endTimeStr", sf.format(endTime));
		}
		pagination.setTotalCount(memberCollectService.gainMemberViewsLong(map));
		try {
			viewsList = memberCollectService.gainMemberViewsList(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pagination", pagination);
		return "toPersonGoodsViews";
	}

	/**
	 * 跳转到个人会员中的店铺收藏列表页面
	 * @Title: toPersonGoodsCollect
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 周张豹
	 */
	public String toPersonGoodsCollectBysShop(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		// 设置每页显示几条数据
		pagination.setRows(9L);
		map.put("page", (pagination.getPage()-1)*pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("userId", sessionInfo.getUserId());
		map.put("userType", sessionInfo.getUserType());
		map.put("type", "shop");
		if (startTime != null && !"".equals(startTime)) {
			map.put("startTime", startTime);
		}
		if (endTime != null && !"".equals(endTime)) {
			map.put("endTime", endTime);
		}
		pagination.setTotalCount(memberCollectService.gainMemberCollectLong(map));
		companies = memberCollectService.gainMemberCollectShopList(map);
		request.setAttribute("pagination", pagination);
		return "toPersonGoodsCollectByShop";
	}
	/**
	 * 跳转到个人会员中的浏览过的店铺列表页面
	 * @Title: toPersonGoodsCollect
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 周张豹
	 */
	public String toPersonGoodsViewsByShop(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		// 设置每页显示几条数据
		pagination.setRows(9L);
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		map.put("userId", sessionInfo.getUserId());
		map.put("userType", sessionInfo.getUserType());
		map.put("type", "shop");
		if (startTime != null && !"".equals(startTime)) {
			map.put("startTime", startTime);
		}
		if (endTime != null && !"".equals(endTime)) {
			map.put("endTime", endTime);
		}
		pagination.setTotalCount(memberCollectService.gainMemberViewsLong(map));
		companies = memberCollectService.gainMemberViewsShopList(map);
		// 浏览统计
		browseStatisticsInfo = statisticsService.gainBrowseStatisticsByTime("0", sessionInfo);
		request.setAttribute("pagination", pagination);
		return "toPersonGoodsViewsByShop";
	}

	/**
	 * @Title : updateMemberCollect
	 * @Description : TODO(添加收藏)
	 * @param : 设定文件
	 * @author : Jason
	 */
    public void updateMemberCollect(){
		Json j=new Json();
        String action=request.getParameter("action");
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());

		if(sessionInfo.getUserId() == null || sessionInfo.getUserId().equals("")){
			j.setMsg("noLogin");
			j.setSuccess(false);
		}else {
			try {
				if (action.equals("add")) {
					memberCollect.setCollectTime(new Date());
					memberCollect.setUserId(sessionInfo.getUserId());
					memberCollect.setCollectIp(sessionInfo.getIp());
					memberCollect.setId(ToolsUtil.getUUID());
					memberCollectService.insertSelective(memberCollect);
					j.setSuccess(true);
					j.setMsg("收藏成功");
					j.setObj(memberCollectService.followNum(memberCollect.getCollectId()));
				} else {
					//删除
					memberCollect.setUserId(sessionInfo.getUserId());
					memberCollectService.deleteMemberCollect(memberCollect);
					j.setSuccess(true);
					j.setMsg("取消收藏成功");
					j.setObj(memberCollectService.followNum(memberCollect.getCollectId()));
				}
			} catch (Exception e) {
				e.printStackTrace();
				j.setMsg("收藏失败");
				j.setSuccess(false);
			}
		}
		 writeJson(j);
	}
	/**
	 * @return the memberCollect
	 */
	public MemberCollect getMemberCollect() {
		return memberCollect;
	}

	/**
	 * @param memberCollect the memberCollect to set
	 */
	public void setMemberCollect(MemberCollect memberCollect) {
		this.memberCollect = memberCollect;
	}

	
	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the memberCollects
	 */
	public List<MemberCollect> getMemberCollects() {
		return memberCollects;
	}

	/**
	 * @param memberCollects the memberCollects to set
	 */
	public void setMemberCollects(List<MemberCollect> memberCollects) {
		this.memberCollects = memberCollects;
	}
	/**
	 * @return the companies
	 */
	public List<Company> getCompanies() {
		return companies;
	}
	/**
	 * @param companies the companies to set
	 */
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	/**
	 * @return the collectStatisticsInfo
	 */
	public StatisticsInfo getCollectStatisticsInfo() {
		return collectStatisticsInfo;
	}
	/**
	 * @param collectStatisticsInfo the collectStatisticsInfo to set
	 */
	public void setCollectStatisticsInfo(StatisticsInfo collectStatisticsInfo) {
		this.collectStatisticsInfo = collectStatisticsInfo;
	}
	/**
	 * @return the browseStatisticsInfo
	 */
	public StatisticsInfo getBrowseStatisticsInfo() {
		return browseStatisticsInfo;
	}
	/**
	 * @param browseStatisticsInfo the browseStatisticsInfo to set
	 */
	public void setBrowseStatisticsInfo(StatisticsInfo browseStatisticsInfo) {
		this.browseStatisticsInfo = browseStatisticsInfo;
	}
	/**
	 * @return the viewsList
	 */
	public List<Views> getViewsList() {
		return viewsList;
	}
	/**
	 * @param viewsList the viewsList to set
	 */
	public void setViewsList(List<Views> viewsList) {
		this.viewsList = viewsList;
	}


	@Override
	public MemberCollect getModel() {
		return memberCollect;
	}
}
