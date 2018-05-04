/**  
 * @Title: IndexFloorServiceImpl.java 
 * @Package com.qlzy.mainPage.service.impl 
 * @Description: TODO(这里用一句话描述这个方法的作用)
 * @author wangmei  
 * @date 2013-5-7 下午3:05:54
 * @version V1.0  
 */
package com.qlzy.mainPage.floor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.mainPage.floor.dao.HomeSysMapper;
import com.qlzy.mainPage.floor.service.IndexFloorService;
import com.qlzy.mainPage.head.dao.GoodsCatMapper;
import com.qlzy.mainPage.indexGoods.dao.GoodsHotMapper;
import com.qlzy.mainPage.indexGoods.dao.GoodsMapper;
import com.qlzy.memberCenter.shop.dao.CompanysGoodsCatMapper;
import com.qlzy.memberCenter.shop.dao.CompanysInfoMapper;
import com.qlzy.model.Company;
import com.qlzy.model.CompanysGoodsCat;
import com.qlzy.model.Goods;
import com.qlzy.model.GoodsCat;
import com.qlzy.model.GoodsHot;
import com.qlzy.model.HomeSys;
import com.qlzy.util.Pagination;


@Service("indexFloorService")
@Transactional(rollbackFor = Exception.class)
public class IndexFloorServiceImpl implements IndexFloorService {

	@Resource
	private HomeSysMapper  homeSysMapper;
	@Resource
	private GoodsCatMapper goodsCatMapper;
	@Resource
	private GoodsMapper goodsMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private CompanysGoodsCatMapper companysGoodsCatMapper;
	
	@Resource
	private GoodsHotMapper goodsHotMapper;

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainCompanyById
	 * @Description: TODO(根据供应商id查询供应商信息)
	 * @param id
	 * @return
	 * @see com.qlzy.mainPage.floor.service.(java.lang.String)
	 */
	@Override
	public Company gainCompanyById(String id) {
		return companyMapper.selectByPrimaryKey(id);
	}
	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainCompanyGoodsCatListByCompanyId
	 * @Description: TODO(根据商家ID查询商家店铺首页热销品类)
	 * @param companyId
	 * @return
	 * @see com.qlzy.mainPage.floor.service.IndexFloorService#gainCompanyGoodsCatListByCompanyId(java.lang.String)
	 */
	@Override
	public List<CompanysGoodsCat> gainCompanyGoodsCatListByCompanyId(
			String companyId) {
		return companysGoodsCatMapper.gainCompanyGoodsCatList(companyId);
	}
	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainComGoodsListByCat
	 * @Description: TODO(查询某商品分类下的商品信息)
	 * @param companyId
	 * @param goodsCatId
	 * @return
	 * @see com.qlzy.mainPage.floor.service.IndexFloorService#gainComGoodsListByCat(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public List<Goods> gainComGoodsListByCat(String companyId, String goodsCatId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		map.put("goodsCatId", goodsCatId);
		List<GoodsCat> list = goodsCatMapper.gainSonGoodsCatsByPid(map);
		if(list != null && list.size() > 0){
			map.put("type", 1);
		}else{
			map.put("type", 2);
		}
		return goodsMapper.gainComGoodsListByCat(map);
	}
	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainGoodsListByCompanyIdForPage
	 * @Description: TODO(根据商家ID查询商品列表信息(带分页))
	 * @param pagination
	 * @param companyId
	 * @param goodsCatId
	 * @return
	 * @see com.qlzy.mainPage.floor.service.IndexFloorService#gainGoodsListByCompanyIdForPage(com.qlzy.util.Pagination,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public List<Goods> gainGoodsListByCompanyIdForPage(Pagination pagination,
			String companyId, String goodsCatId) {
		if("0".equals(goodsCatId)){
			goodsCatId = "null";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		map.put("companyId", companyId);
		map.put("goodsCatId", goodsCatId);
		return goodsMapper.gainGoodsListByCompanyIdForPage(map);
	}
	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainGoodsListCountByCompanyId
	 * @Description: TODO(根据商家ID查询商品的数量)
	 * @param pagination
	 * @param companyId
	 * @param goodsCatId
	 * @return
	 * @see com.qlzy.mainPage.floor.service.IndexFloorService#gainGoodsListCountByCompanyId(com.qlzy.util.Pagination,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public Long gainGoodsListCountByCompanyId(String companyId,
			String goodsCatId) {
		if("0".equals(goodsCatId)){
			goodsCatId = "null";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		map.put("goodsCatId", goodsCatId);
		return goodsMapper.gainGoodsListCountByCompanyId(map);
	}

	@Override
	public List<HomeSys> gainHomeSysList() {
		// TODO Auto-generated method stub
		return homeSysMapper.gainAll();
	}
	@Override
	public List<HomeSys> gainTemaiSysList() {
		// TODO Auto-generated method stub
		return homeSysMapper.gainTemaiSysList();
	}
	@Override
	public GoodsHot gainGoodsHot() {
		// TODO Auto-generated method stub
		return goodsHotMapper.gainGoodsHotList(new GoodsHot()).get(0);
	}
}
