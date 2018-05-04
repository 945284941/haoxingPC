/**
 * 
 */
package com.qlzy.mainPage.head.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.GoodsCat;
import com.qlzy.model.HomeSys;
import com.qlzy.model.News;

/**
 * @author 赵阳彬
 *
 */

public interface CatalogueService {

    /**
     * 根据目录查询分类List数据 
     * @param i
     * @return
     */
	List<GoodsCat> gainCatalogueByGrade(Integer i);

	/**
	 * 根据父类id查询分类List数据 
	 * @param pid
	 * @return
	 */
	List<GoodsCat> gainCatalogueByPid(String pid);
	
	/**
	 *  查询所有商品分类
	 * @return
	 */
	public List<GoodsCat> queryFullCategory(String type);


	/**
	* @Title: gainNewGongGaoList
	* @Description: TODO(商品公告列表)
	* @param @return设定文件
	* @return List<News>返回类型
	* @throws
	*/
	List<News> gainNewGongGaoList();

	List<HomeSys> gainLunbotu();

	List<HomeSys> gainLunbotuByShop(String type);

	List<HomeSys> gainLunbotuByMarket(String type);

	List<GoodsCat> gainCatalogueByPidAndSort(Map<String, String> shopMap);
}
