/**??
* @Title: MagazineNews.java
* @Package magazine
* @Description: TODO(古道金典杂志)
* @author zhao yang bin
* @date 2013-11-2 下午2:18:59
* @version V1.0??
*/
package com.qlzy.mainPage.magazine.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.mainPage.magazine.service.MagazineService;
import com.qlzy.model.MagazineMessage;
import com.qlzy.model.News;
import com.qlzy.util.BaseAction;

/**
 * @ClassName: MagazineNews
 * @Description: TODO(古道金典杂志)
 * @author zhao yang bin
 * @date 2013-11-2 下午2:18:59
 *
 */
@Namespace("/")
@Action(value = "magazineNews", results = {
		@Result(name = "toMagazine", location = "/admin/magazine/zzsk.jsp")
	 })
public class MagazineNewsAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MagazineService magazineService;
	
	private List<MagazineMessage> magazineList;
	
	private Map<String,List<News>> mapLeft;
	
	//进入古道金典杂志
	public String toMagazine(){
		mapLeft = magazineService.gainLeftMagazineList();
		magazineList=magazineService.gainMagazineList();
		return "toMagazine";
	}

	
	
	
	public Map<String, List<News>> getMapLeft() {
		return mapLeft;
	}

	public void setMapLeft(Map<String, List<News>> mapLeft) {
		this.mapLeft = mapLeft;
	}
	public List<MagazineMessage> getMagazineList() {
		return magazineList;
	}
	public void setMagazineList(List<MagazineMessage> magazineList) {
		this.magazineList = magazineList;
	}


	
}
