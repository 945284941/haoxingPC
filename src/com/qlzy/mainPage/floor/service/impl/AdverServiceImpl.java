/**  
 * @Title: AdverServiceImpl.java 
 * @Package com.qlzy.mainPage.service.impl 
 * @Description: TODO(这里用一句话描述这个方法的作用)
 * @author wangmei  
 * @date 2013-5-8 下午3:55:23
 * @version V1.0  
 */
package com.qlzy.mainPage.floor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qlzy.mainPage.floor.dao.AdverMapper;
import com.qlzy.mainPage.floor.service.AdverService;
import com.qlzy.model.Adver;
@Service("adverService")
public class AdverServiceImpl implements AdverService {

	@Resource
	private AdverMapper adverMapper;
	
	/** (non-Javadoc)
	 * @Title: gainAdverByFloor
	 * @Description: TODO(根据设置的首页广告位置查询)
	 * @param floor
	 * @return
	 * @see com.qlzy.mainPage.service.AdverService#gainAdverByFloor(java.lang.String)
	 */
	@Override
	public List<Adver> gainAdverByFloor(Integer floor,String num) {
		Adver adver = new Adver();
		if(num.equals("1")){
			adver.setName(floor+"F-");
		}else{
			adver.setName(floor+"F_top");
		}
		return adverMapper.gainAdverByFloor(adver);
	}
}
