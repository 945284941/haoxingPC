/**  
 * @Title: AdverService.java 
 * @Package com.qlzy.mainPage.service 
 * @Description: TODO(这里用一句话描述这个方法的作用)
 * @author wangmei  
 * @date 2013-5-8 下午3:54:05
 * @version V1.0  
 */
package com.qlzy.mainPage.floor.service;

import java.util.List;

import com.qlzy.model.Adver;

/**
 * @ClassName: AdverService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangmei
 * @date 2013-5-8 下午3:54:05
 */
public interface AdverService {
	
	/**
	 * @Title: gainAdverByFloor
	 * @Description: TODO(根据设置的首页广告位置查询)
	 * @param @param floor
	 * @param @return    设定文件
	 * @return List<Adver>    返回类型
	 */
	public List<Adver> gainAdverByFloor(Integer floor,String num);
}
