/**  
 * @Title: RegionsServiceImpl.java 
 * @Package com.qlzy.mainPage.service.impl 
 * @Description: TODO(地区接口实现类)
 * @author wangmei  
 * @date 2013-5-8 上午11:34:52
 * @version V1.0  
 */
package com.qlzy.mainPage.regions.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.regions.dao.RegionsMapper;
import com.qlzy.mainPage.regions.service.RegionsService;
import com.qlzy.model.Regions;

@Service("regionsService")
public class RegionsServiceImpl implements RegionsService {
	
	@Resource
	private RegionsMapper regionsMapper;

	/** (non-Javadoc)
	 * @Title: gainProvinceList
	 * @Description: TODO(查询省份列表)
	 * @return
	 * @see com.qlzy.mainPage.service.RegionsService#gainProvinceList()
	 */
	@Override
	public List<Regions> gainProvinceList() {
		return regionsMapper.gainProvinceList();
	}
	/** (non-Javadoc)
	 * @Title: gainCityListByPid
	 * @Description: TODO(根据省份id查询其市列表)
	 * @param pid
	 * @return
	 * @see com.qlzy.mainPage.service.RegionsService#gainCityListByPid(java.lang.String)
	 */
	@Override
	public List<Regions> gainCityListByPid(String pid) {
		return regionsMapper.gainCityListByPid(pid);
	}
	/**
	 * 根据市查询蛆或线
	 */
	@Override
	public List<Regions> gainAreaListByCityId(String cityId) {
		// TODO Auto-generated method stub
		return regionsMapper.gainAreaListByCityId(cityId);
	}
	/* (非 Javadoc)
	* <p>Title: gainNameByPid</p>
	* <p>Description: </p>
	* @param id
	* @return
	* @see com.qlzy.mainPage.regions.service.RegionsService#gainNameByPid(java.lang.String)
	*/
	@Override
	public Regions gainNameByPid(String id) {
		// TODO Auto-generated method stub
		return regionsMapper.gainNameByPid(id);
	}
	
	
	public List<Regions> gainNextCityOrAreaListByPid(String pid){
		
		return regionsMapper.gainNextCityOrAreaListByPid(ToolsUtil.StringConvertList(pid));
	}

}
