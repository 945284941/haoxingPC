package com.qlzy.shanghui.searchGoods.action;

import java.util.List;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import com.qlzy.model.GoodsCatSh;
import com.qlzy.shanghui.head.service.CatalogueShService;
import com.qlzy.util.BaseAction;

@Namespace("/")
// 命名空间
@Action(value = "searchGoodsShAction", results = {
		
		@Result(name = "firstList", location = "/shanghui/head/head.jsp")
		 })
public class SearchGoodsShAction extends BaseAction {
	private Logger logger = Logger.getLogger(SearchGoodsShAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 商会目录列表
	private List<GoodsCatSh> firstGoodsCatShList;
	private List<GoodsCatSh> secondGoodsCatShList;
	private String pid;
	@Resource
	private CatalogueShService catalogueShService;
	/***
	 * 
	
	* @Title: gainFirstShList 
	
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	
	* @param @return    设定文件 
	
	* @return String    返回类型 
	
	* @throws
	 */
	public String gainFirstShList() {
		// 左侧菜单 目录列表
		firstGoodsCatShList = catalogueShService.gainCatalogueShByGrade(1);// 一级目录
		return "firstList";
	}

	
	public List<GoodsCatSh> getFirstGoodsCatShList() {
		return firstGoodsCatShList;
	}

	public void setFirstGoodsCatShList(List<GoodsCatSh> firstGoodsCatShList) {
		this.firstGoodsCatShList = firstGoodsCatShList;
	}

	public List<GoodsCatSh> getSecondGoodsCatShList() {
		return secondGoodsCatShList;
	}

	public void setSecondGoodsCatShList(List<GoodsCatSh> secondGoodsCatShList) {
		this.secondGoodsCatShList = secondGoodsCatShList;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public CatalogueShService getCatalogueShService() {
		return catalogueShService;
	}

	public void setCatalogueShService(CatalogueShService catalogueShService) {
		this.catalogueShService = catalogueShService;
	}
	
}
