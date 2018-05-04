package com.qlzy.zp.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.model.ZpCompany;
import com.qlzy.model.ZpMessage;
import com.qlzy.util.BaseAction;
import com.qlzy.zp.service.ZpMessageService;

@Namespace("/")
@Action(value = "zpmessage", results = {
		@Result(name = "toCome", location = "/admin/foot/cpyc.jsp"),
		@Result(name = "toComeZpjj", location = "/admin/foot/zpjj.jsp"),
		@Result(name = "toZpDetail", location = "/admin/foot/zpMessage.jsp")
})
public class ZpMessageAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private ZpMessage zpMessage;	
	private ZpCompany zpCompany;
	private List<ZpMessage> zpList;
	private String zpId;
	
	@Resource
	private ZpMessageService zpMessageService;
	
	public String toCome() {
		//zpMessage = zpMessageService.gainZpMessage();
		//zpCompany = zpMessageService.gainCompany();
		return "toCome";
	}
	public String toComeZpjj() {
		//zpMessage = zpMessageService.gainZpMessage();
		zpCompany = zpMessageService.gainCompany();
		zpList = zpMessageService.gainZpMessageList();
		return "toComeZpjj";
	}
	public ZpMessage getZpMessage() {
		return zpMessage;
	}
	public String gainZpMessage() {
		zpMessage = zpMessageService.gainZpMessageById(zpId);
		return "toZpDetail";
	}

	public void setZpMessage(ZpMessage zpMessage) {
		this.zpMessage = zpMessage;
	}

	public ZpMessageService getZpMessageService() {
		return zpMessageService;
	}

	public void setZpMessageService(ZpMessageService zpMessageService) {
		this.zpMessageService = zpMessageService;
	}
	public ZpCompany getZpCompany() {
		return zpCompany;
	}
	public void setZpCompany(ZpCompany zpCompany) {
		this.zpCompany = zpCompany;
	}
	public List<ZpMessage> getZpList() {
		return zpList;
	}
	public void setZpList(List<ZpMessage> zpList) {
		this.zpList = zpList;
	}
	public String getZpId() {
		return zpId;
	}
	public void setZpId(String zpId) {
		this.zpId = zpId;
	}
	
}
