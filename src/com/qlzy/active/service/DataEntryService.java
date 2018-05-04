/**  
* @Title: DaraEntryService.java
* @Package com.qlzy.active.service
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-7-1 下午3:12:41
* @version V1.0  
*/
package com.qlzy.active.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.ActiveCollectGoodsQB;
import com.qlzy.model.CarBrand;
import com.qlzy.model.GoodsCat;

/**
 * 数据入口有关操作
 * @ClassName: DaraEntryService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-7-1 下午3:12:41
 */
public interface DataEntryService {
	
	/**
	 * 获取题库中所有的数据
	* @Title: gainActiveGoodsQB
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<ActiveCollectGoodsQB>    返回类型
	* @author 周张豹
	 */
	public List<ActiveCollectGoodsQB> gainActiveGoodsQB(Map<String, Object> map);
	
	/**
	 * 获取题库的总数量
	* @Title: gainActiveGoodsQBNum
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return Long    返回类型
	* @author 周张豹
	 */
	public Long gainActiveGoodsQBNum(Map<String, Object> map);

	/**
	 * 查询商品分类的一级分类
	* @Title: gainGoodsCat
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<GoodsCat>    返回类型
	* @author 周张豹
	*/
	public List<GoodsCat> gainGoodsCat();

	/**
	 *  获取一级品牌分类
	* @Title: gainCarBrandFirst
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<CarBrand>    返回类型
	* @author 周张豹
	*/
	public List<CarBrand> gainCarBrandFirst();

}
