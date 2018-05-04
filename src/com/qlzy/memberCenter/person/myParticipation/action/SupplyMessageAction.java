/**??
* @Title: SupplyMessageAction.java
* @Package com.qlzy.memberCenter.person.myParticipation.action
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-10-6 下午1:31:32
* @version V1.0??
*/
package com.qlzy.memberCenter.person.myParticipation.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.constant.SysSetting;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.memberCenter.person.myParticipation.service.SupplyMessageService;
import com.qlzy.model.Supply;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;

/**
 * @ClassName: SupplyMessageAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhao yang bin
 * @date 2013-10-6 下午1:31:32
 *
 */
@Namespace("/")
@Action(value = "supplyMessage", results = {
		@Result(name = "supplyList", location = "/memberCenter/person/myParticipation/supplyMessage.jsp"),
		@Result(name = "supplyListCompany", location = "/memberCenter/company/myParticipation/supplyMessage.jsp")

})
public class SupplyMessageAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private String supplyType;
	private List<Supply> supplyList;
	@Autowired
	private SupplyMessageService supplyMessageService;
	
	private SessionInfo sessionInfo;
	
	
	
	
	public String gainSupplyList(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		map.put("userId", sessionInfo.getUserId());
		if(supplyType!=null && !supplyType.equals("")){
			if(supplyType.equals("zhengche")){
				map.put("supplyType", SysSetting.zhengche);
			}else if(supplyType.equals("peijian")){
				map.put("supplyType", SysSetting.peijian);
			}else if(supplyType.equals("shebei")){
				map.put("supplyType", SysSetting.shebei);
			}else if(supplyType.equals("qixiu")){
				map.put("supplyType", SysSetting.qixiu);
			}else if(supplyType.equals("wuliu")){
				map.put("supplyType", SysSetting.wuliu);
			}else if(supplyType.equals("zulin")){
				map.put("supplyType", SysSetting.zulin);
			}else if(supplyType.equals("qiuzhi")){
				map.put("supplyType", SysSetting.qiuzhi);
			}else if(supplyType.equals("qita")){
				map.put("supplyType", SysSetting.qita);
			}
		}
		supplyList = supplyMessageService.gainSupplyList(map);
		pagination.setTotalCount(supplyMessageService.gainSupplyListCount(map));
		request.setAttribute("pagination", pagination);
		if(sessionInfo.getUserType().equals("company")){
			return "supplyListCompany";
		}else{
			return "supplyList";
		}
	}
	//右端显示栏
	public void statisticsSupply(){
		// 统计
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		StatisticsInfo supplyStatisticsInfo = new StatisticsInfo();
		map.put("userId", sessionInfo.getUserId());
		
		map.put("typeName", SysSetting.zhengche);
		Long zhengche = supplyMessageService.gainSupplyMessage(map);
		map.put("typeName", SysSetting.peijian);
		Long peijian = supplyMessageService.gainSupplyMessage(map);
		map.put("typeName", SysSetting.shebei);
		Long shebei = supplyMessageService.gainSupplyMessage(map);
		map.put("typeName", SysSetting.qixiu);
		Long qixiu = supplyMessageService.gainSupplyMessage(map);
		map.put("typeName", SysSetting.wuliu);
		Long wuliu = supplyMessageService.gainSupplyMessage(map);
		map.put("typeName", SysSetting.zulin);
		Long zulin = supplyMessageService.gainSupplyMessage(map);
		map.put("typeName", SysSetting.qiuzhi);
		Long qiuzhi = supplyMessageService.gainSupplyMessage(map);
		map.put("typeName", SysSetting.qita);
		Long qita = supplyMessageService.gainSupplyMessage(map);
		
		supplyStatisticsInfo.setZhengcheCount(zhengche);
		supplyStatisticsInfo.setPeijianCount(peijian);
		supplyStatisticsInfo.setShebeiCount(shebei);
		supplyStatisticsInfo.setQixiuCount(qixiu);
		supplyStatisticsInfo.setWuliuCount(wuliu);
		supplyStatisticsInfo.setZulinCount(zulin);
		supplyStatisticsInfo.setQiuzhiCount(qiuzhi);
		supplyStatisticsInfo.setQitaCount(qita);
		
		writeJson(supplyStatisticsInfo);
	}
	
	
	public String getSupplyType() {
		return supplyType;
	}
	public void setSupplyType(String supplyType) {
		this.supplyType = supplyType;
	}
	public List<Supply> getSupplyList() {
		return supplyList;
	}
	public void setSupplyList(List<Supply> supplyList) {
		this.supplyList = supplyList;
	}

}
