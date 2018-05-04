package com.qlzy.shanghui.head.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.qlzy.model.GoodsCatSh;
import com.qlzy.model.News;
import com.qlzy.shanghui.head.service.CatalogueShService;
import com.qlzy.util.BaseAction;
@Namespace("/")
//命名空间
@Action(value = "catalogueShAction", results = {})
public class CatalogueShAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private CatalogueShService catalogueShService;
	private Logger logger = Logger.getLogger(CatalogueShAction.class);
	//前台展示所需字段
	private List<GoodsCatSh> firstGoodsCatShList;
	private List<GoodsCatSh> secondGoodsCatShList;
	private List<GoodsCatSh> threeGoodsCatShList;
	private String pid;
	private Map<String,List<GoodsCatSh>> secondThreeGoodsCatShMap ;
	
	/***
	* @Title: gainFirstCatalogue
	* @Description: TODO(得到一级目录)
	* @param     设定文件
	* @return void    返回类型
	 */
    public void gainFirstCatalogue(){
    	//一级目录参数
    	firstGoodsCatShList=catalogueShService.gainCatalogueShByGrade(1);
    	writeJson(firstGoodsCatShList);
    }
    /***
	* @Title: gainSecondCatalogue
	* @Description: TODO(得到二级目录)
	* @param     设定文件
	* @return void    返回类型
	 */
    public void gainSecondCatalogue(){
    	secondGoodsCatShList=catalogueShService.gainCatalogueShByPid(pid);
    	writeJson(secondGoodsCatShList);
    	
    }
	
	public void gainThreeCatalogue(){
		threeGoodsCatShList = catalogueShService.gainCatalogueShTByPid(pid);
		writeJson(threeGoodsCatShList);
	}
	
	public void gainSecondThreeCatalogue(){
		secondThreeGoodsCatShMap =  new HashMap<String,List<GoodsCatSh>>();
		secondGoodsCatShList=catalogueShService.gainCatalogueShByPid(pid);
		if(null != secondGoodsCatShList){
			for(GoodsCatSh sGoods:secondGoodsCatShList ){
				threeGoodsCatShList = catalogueShService.gainCatalogueShTByPid(sGoods.getId());
				if(null != threeGoodsCatShList){
					String key=sGoods.getName()+","+sGoods.getPicSrc()+","+sGoods.getId();
					secondThreeGoodsCatShMap.put(key, threeGoodsCatShList);
				}
				
			}
		}
		
		writeJson(secondThreeGoodsCatShMap);
		
	}
	

	public CatalogueShService getCatalogueShService() {
		return catalogueShService;
	}
	public void setCatalogueShService(CatalogueShService catalogueShService) {
		this.catalogueShService = catalogueShService;
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
	public List<GoodsCatSh> getThreeGoodsCatShList() {
		return threeGoodsCatShList;
	}
	public void setThreeGoodsCatShList(List<GoodsCatSh> threeGoodsCatShList) {
		this.threeGoodsCatShList = threeGoodsCatShList;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Map<String, List<GoodsCatSh>> getSecondThreeGoodsCatShMap() {
		return secondThreeGoodsCatShMap;
	}
	public void setSecondThreeGoodsCatShMap(
			Map<String, List<GoodsCatSh>> secondThreeGoodsCatShMap) {
		this.secondThreeGoodsCatShMap = secondThreeGoodsCatShMap;
	}
	
	
}
