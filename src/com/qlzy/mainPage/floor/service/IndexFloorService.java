/**  
 * @Title: IndexFloorService.java 
 * @Package com.qlzy.mainPage.service 
 * @Description: TODO(这里用一句话描述这个方法的作用)
 * @author wangmei  
 * @date 2013-5-7 下午3:04:57
 * @version V1.0  
 */
package com.qlzy.mainPage.floor.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Company;
import com.qlzy.model.CompanysGoodsCat;
import com.qlzy.model.CompanysInfo;
import com.qlzy.model.Goods;
import com.qlzy.model.GoodsCat;
import com.qlzy.model.GoodsHot;
import com.qlzy.model.HomeSys;
import com.qlzy.model.Qixiuchang;
import com.qlzy.util.Pagination;

/**
 * @ClassName: IndexFloorService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangmei
 * @date 2013-5-7 下午3:04:57
 */
public interface IndexFloorService {
	/**
	 * @Title: gainCompanyById
	 * @Description: TODO(根据供应商id查询供应商信息)
	 * @param @param id
	 * @param @return 设定文件
	 * @return Company 返回类型
	 * @author wangmei
	 */
	public Company gainCompanyById(String id);
	/**
	 * @Title: gainCompanyGoodsCatListByCompanyId
	 * @Description: TODO(根据商家ID查询商家店铺首页热销品类)
	 * @param @param companyId
	 * @param @return 设定文件
	 * @return List<CompanysGoodsCat> 返回类型
	 * @author wangmei
	 */
	public List<CompanysGoodsCat> gainCompanyGoodsCatListByCompanyId(
			String companyId);
	/**
	 * @Title: gainComGoodsListByCat
	 * @Description: TODO(查询某商品分类下的商品信息)
	 * @param @param companyId
	 * @param @param goodsCatId
	 * @param @return 设定文件
	 * @return List<Goods> 返回类型
	 * @author wangmei
	 */
	public List<Goods> gainComGoodsListByCat(String companyId, String goodsCatId);
	/**
	 * @Title: gainGoodsListByCompanyIdForPage
	 * @Description: TODO(根据商家ID查询商品列表信息(带分页))
	 * @param @param pagination
	 * @param @param companyId
	 * @param @param goodsCatId
	 * @param @return 设定文件
	 * @return List<Goods> 返回类型
	 * @author wangmei
	 */
	public List<Goods> gainGoodsListByCompanyIdForPage(Pagination pagination,
			String companyId, String goodsCatId);
	/**
	 * @Title: gainGoodsListCountByCompanyId
	 * @Description: TODO(根据商家ID查询商品的数量)
	 * @param @param companyId
	 * @param @param goodsCatId
	 * @param @return 设定文件
	 * @return Long 返回类型
	 * @author wangmei
	 */
	public Long gainGoodsListCountByCompanyId(String companyId,
			String goodsCatId);

	public List<HomeSys> gainHomeSysList();
	public List<HomeSys> gainTemaiSysList();
	public GoodsHot gainGoodsHot();
}
