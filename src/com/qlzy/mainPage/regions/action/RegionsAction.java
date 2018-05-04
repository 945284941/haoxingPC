/**   
 * @Title: RegionsAction.java 
 * @Package com.qlzy.mainPage.regions 
 * @Description: TODO(地区管理公共实现类) 
 * @author wangmei   
 * @date 2013-10-31 下午4:57:16 
 * @version V1.0   
 */
package com.qlzy.mainPage.regions.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.qlzy.mainPage.regions.service.RegionsService;
import com.qlzy.model.Regions;
import com.qlzy.util.BaseAction;

@Namespace("/")
@Action(value = "regionsAction")
public class RegionsAction extends BaseAction {

	@Resource
	private RegionsService regionsService;

	/**
	 * @Title: getCitys
	 * @Description: TODO(根据省份获取城市列表)
	 * @param 设定文件
	 * @return void 返回类型
	 * @author wangmei
	 */
	public void getCitys() {
		String province = request.getParameter("province");// 获取省
		List<Regions> regionList = new ArrayList<Regions>();
		if (null != province && !"".equals(province)) {
			regionList = gainCityList(province);
		}
		writeJson(regionList);
	}

	/**
	 * @Title: getAreas
	 * @Description: TODO(根据市获取区列表)
	 * @param 设定文件
	 * @return void 返回类型
	 * @author wangmei
	 */
	public void getAreas() {
		String city = request.getParameter("city");// 获取市
		List<Regions> regionList = new ArrayList<Regions>();
		if (null != city && !"".equals(city)) {
			regionList = gainAreaList(city);
		}
		writeJson(regionList);
	}

	/**
	 * 调用
	 */
	private List<Regions> gainCityList(String proId) {
		return regionsService.gainCityListByPid(proId);
	}

	private List<Regions> gainAreaList(String cityId) {
		return regionsService.gainAreaListByCityId(cityId);
	}
}
