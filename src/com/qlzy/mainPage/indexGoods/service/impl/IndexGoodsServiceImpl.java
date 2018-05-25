/**  
* @Title: IndexGoodsServiceImpl.java
* @Package com.qlzy.mainPage.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-5-11 下午2:25:52
* @version V1.0  
*/
package com.qlzy.mainPage.indexGoods.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.qlzy.memberCenter.common.dao.AppraiseMapper;
import com.qlzy.memberCenter.goods.dao.GoodsPicMapper;
import com.qlzy.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.qlzy.common.util.UtilsJson;
import com.qlzy.mainPage.head.dao.CarBrandMapper;
import com.qlzy.mainPage.head.dao.GoodsCatMapper;
import com.qlzy.mainPage.indexGoods.dao.GoodsAndSkuMapper;
import com.qlzy.mainPage.indexGoods.dao.GoodsHotMapper;
import com.qlzy.mainPage.indexGoods.dao.GoodsItemMapper;
import com.qlzy.mainPage.indexGoods.dao.GoodsMapper;
import com.qlzy.mainPage.indexGoods.dao.GoodsSpecificationValueMapper;
import com.qlzy.mainPage.indexGoods.service.IndexGoodsService;

/**
 * @ClassName: IndexGoodsServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-5-11 下午2:25:52
 */
@Service("indexGoodsService")
public class IndexGoodsServiceImpl implements IndexGoodsService {
	@Resource
	private GoodsMapper goodsMapper;
	@Resource
	private GoodsCatMapper goodsCatMapper;
	@Resource
	private GoodsSpecificationValueMapper goodsSpecificationValueMapper;
	@Autowired
	private CarBrandMapper carBrandMapper;
	@Autowired
	private GoodsHotMapper goodsHotMapper;

	@Autowired
	private GoodsAndSkuMapper goodsAndSkuMapper;
	
	@Autowired
	private GoodsItemMapper goodsItemMapper;

	@Autowired
	private GoodsPicMapper goodsPicMapper;
	@Autowired
	private AppraiseMapper appraiseMapper;

	/***
	 * 查询商家的推荐商品
     * @return
     */
	@Override
	public List<Goods> selectGoodsByType(Map<String,Object> parmMap) {
		return goodsMapper.selectGoodsByType(parmMap);
	}

	/*
         * (non-Javadoc)
         *
         * @see com.qlzy.mainPage.service.IndexGoodsService#gainHotGoods(java.lang.
         * String)
         */
	@Override
	public List<Goods> gainHotGoods(String type, String cat, Integer goodsLang) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("cat", cat);
		map.put("goodsLang", goodsLang);
		return goodsMapper.gainHotGoods(map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qlzy.mainPage.service.IndexGoodsService#gainGoodsCat(java.lang.
	 * Integer)
	 */
	@Override
	public List<GoodsCat> gainGoodsCat(Integer catLang) {
		return goodsCatMapper.gainGoodsCat(catLang);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.mainPage.service.IndexGoodsService#gainGoodsByType(java.lang.
	 * String, java.lang.Integer)
	 */
	@Override
	public List<Goods> gainGoodsByType(String type, Integer goodsLang) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("goodsLang", goodsLang);
		return goodsMapper.gainGoodsByType(map);
	}
	@Override
	public List<Goods> gainGoodsByTypeIndex(String type, Integer goodsLang) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("goodsLang", goodsLang);
		return goodsMapper.gainGoodsByTypeIndex(map);
	}

		/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.qlzy.mainPage.indexGoods.service.IndexGoodsService#gainGoodsById(java
	 * .lang.String)
	 */
	@Override
	public Goods gainGoodsByParm(Map<String,Object> parmMap) {
		Goods goods = goodsMapper.gainGoodsByPrm(parmMap);
		List<String> goodsPics = goodsPicMapper.gainGoodsPicListByGoodsId(parmMap.get("goodsId").toString());
		goods.setGoodsPics(goodsPics);
		//查询商品的评论数量
		Goods g = appraiseMapper.selectAppraiseCount(parmMap.get("goodsId").toString());
		if(g.getAllCount().compareTo(BigDecimal.ZERO) > 0){
			goods.setAllCount(g.getAllCount());
			goods.setHaopingCount(g.getHaopingCount());
			goods.setZhongpingCount(g.getZhongpingCount());
			goods.setChapingCount(g.getChapingCount());
			goods.setTupianCount(g.getTupianCount());
		}else{
			goods.setAllCount(BigDecimal.ZERO);
			goods.setHaopingCount(BigDecimal.ZERO);
			goods.setZhongpingCount(BigDecimal.ZERO);
			goods.setChapingCount(BigDecimal.ZERO);
			goods.setTupianCount(BigDecimal.ZERO);
		}
		goods.setClickNum(goods.getClickNum().add(new BigDecimal(1)));//点击量加1
		//设置商品规格start
		GoodsAndSku gas = new GoodsAndSku();
		gas.setGoodsId(goods.getId());
		List<GoodsAndSku> gaslist = goodsAndSkuMapper.selectGoodsAndSkuListByGoodsId(gas);
		if(!gaslist.isEmpty()){
			goods.setGasList(gaslist);
		}
		//重组产品规格等
		Multimap<String, Object> skuCode=ArrayListMultimap.create();
		Multimap<String, Object> skuStr=ArrayListMultimap.create();

		if(gaslist!=null){
			for (GoodsAndSku p : gaslist) {
				skuCode.put(p.getSkuCode(), p.getSkuOptionCode());
				skuStr.put(p.getSkuName(),p.getSkuOptionCode()+"-"+p.getSkuOptionValue());
			}
			//组装keys
			Set<String> keys = skuCode.keySet();
			String temp ="[";
			Iterator<String> it = keys.iterator();
			while(it.hasNext()){
				temp+=skuCode.get(it.next())+",";
			}
			temp = temp.substring(0, temp.length()-1)+"]";
			goods.setSkuKeys(temp);
			GoodsItem ppItem = new GoodsItem();
			ppItem.setProductId(goods.getId());
			ppItem.setStatus(1);
			List<GoodsItem> listppItems=goodsItemMapper.selectGoodsItemListByGoodsId(ppItem);
			Map<String,Object> skuJson  = new HashMap<String,Object>();
			if(listppItems!=null){
				for (GoodsItem e : listppItems) {
					//51571787:{"price":1, "count":2,"itemId":18954885177e4b9990d6b86d8feeabe0}
					Map<String,Object> m = new HashMap<String,Object>();
					String sku = e.getSkuJsonHf();
					System.out.println(sku);
					String[] skus = sku.split("--");
					String sku_key = skus[0];
					String sku_value=skus[1];
					sku_value=sku_value.trim();
					sku_value=sku_value.substring(1, sku_value.length()-1).replaceAll("\"", "");
					String[] sku_values=sku_value.split(",");
					for (String ee : sku_values) {
						String[] ees = ee.split(":");
						m.put(ees[0],ees[1]);
					}
					skuJson.put(sku_key,m);
				}
			}
			goods.setData(UtilsJson.toJson(skuJson));
			//封装属性选项按钮
			goods.setSkuCode(skuStr.asMap());
		}

		//设置商品规格end
		Goods goods1 = new Goods();
		goods1.setId(goods.getId());
		goods1.setClickNum(goods.getClickNum());//点击量加1
		goodsMapper.updateByPrimaryKeySelective(goods1);
		return goods;
	}

	@Override
	public List<Goods> gainGoodsByShType(String type, Integer goodsLang) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("goodsLang", goodsLang);
		return goodsMapper.gainGoodsByShType(map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.mainPage.indexGoods.service.IndexGoodsService#gainGoodsById(java
	 * .lang.String)
	 */
//	@Override
//	public Goods gainGoodsById(String id) {
//		Goods goods = goodsMapper.gainGoodsById(id);
//		if(goodsMapper.gainGoodsPicById(id)!=null){
//			goods.setPicSrc(goodsMapper.gainGoodsPicById(id));
//		}
//		List<GoodsSpecificationValue> specificationValues = goodsSpecificationValueMapper.gainGoodsAttributeById(id);
//		for (GoodsSpecificationValue value : specificationValues) {
//			if (value != null && !"".equals(value.getName())) {
//				if ("包装方式".equals(value.getName())) {
//					goods.setBaozhuangfangshi(value.getValue());
//				}else if ("净含量".equals(value.getName())) {
//					goods.setJinghanling(value.getValue());
//				}else if ("储存方式".equals(value.getName())) {
//					goods.setChucunfangshi(value.getValue());
//				}
//				else if ("食品添加剂".equals(value.getName())) {
//					goods.setShipintianjiaji(value.getValue());
//				}
//				else if ("保质期".equals(value.getName())) {
//					goods.setBaozhiqi(value.getValue());
//				}
//				else if ("品牌".equals(value.getName())) {
//					goods.setPinpai(value.getValue());
//				}
//				else if ("售卖方式".equals(value.getName())) {
//					goods.setShoumaifangshi(value.getValue());
//				}
//				else if ("省份".equals(value.getName())) {
//					goods.setShengfen(value.getValue());
//				}
//
//			}
//		}
//		if (goods != null && goods.getPicSrc() != null && !"".equals(goods.getPicSrc())) {
//			goods.setImg(goods.getPicSrc().split(","));
//		}
//
//		goods.setClickNumber(goods.getClickNumber()+1); //点击量加1
//
//
//		//设置商品规格start
//		GoodsAndSku gas = new GoodsAndSku();
//		gas.setGoodsId(goods.getId());
//		List<GoodsAndSku> gaslist = goodsAndSkuMapper.selectGoodsAndSkuListByGoodsId(gas);
//		if(!gaslist.isEmpty()){
//			goods.setGasList(gaslist);
//		}
//		//重组产品规格等
//		Multimap<String, Object> skuCode=ArrayListMultimap.create();
//		Multimap<String, Object> skuStr=ArrayListMultimap.create();
//
//		if(gaslist!=null){
//			for (GoodsAndSku p : gaslist) {
//				skuCode.put(p.getSkuCode(), p.getSkuOptionCode());
//				skuStr.put(p.getSkuName(),p.getSkuOptionCode()+"-"+p.getSkuOptionValue());
//			}
//			//组装keys
//			Set<String> keys = skuCode.keySet();
//			String temp ="[";
//			Iterator<String> it = keys.iterator();
//			while(it.hasNext()){
//				temp+=skuCode.get(it.next())+",";
//			}
//			temp = temp.substring(0, temp.length()-1)+"]";
//			goods.setSkuKeys(temp);
//			GoodsItem ppItem = new GoodsItem();
//			ppItem.setProductId(goods.getId());
//			ppItem.setStatus(1);
//			List<GoodsItem> listppItems=goodsItemMapper.selectGoodsItemListByGoodsId(ppItem);
//			Map<String,Object> skuJson  = new HashMap<String,Object>();
//			if(listppItems!=null){
// 				for (GoodsItem e : listppItems) {
// 					//51571787:{"price":1, "count":2,"itemId":18954885177e4b9990d6b86d8feeabe0}
// 					Map<String,Object> m = new HashMap<String,Object>();
//					String sku = e.getSkuJsonHf();
//					System.out.println(sku);
//					String[] skus = sku.split("--");
//					String sku_key = skus[0];
//					String sku_value=skus[1];
//					sku_value=sku_value.trim();
//					sku_value=sku_value.substring(1, sku_value.length()-1).replaceAll("\"", "");
//					String[] sku_values=sku_value.split(",");
//					for (String ee : sku_values) {
//						String[] ees = ee.split(":");
//						m.put(ees[0],ees[1]);
//					}
//					skuJson.put(sku_key,m);
//				}
//			}
//			goods.setData(UtilsJson.toJson(skuJson));
//			//封装属性选项按钮
//			goods.setSkuCode(skuStr.asMap());
//		}
//
//		//设置商品规格end
//		goodsMapper.updateByPrimaryKeySelective(goods);
//		return goods;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qlzy.mainPage.indexGoods.service.IndexGoodsService#selectAll()
	 */
	@Override
	public List<Goods> selectAll() {
		return goodsMapper.selectAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.mainPage.indexGoods.service.IndexGoodsService#insertGoodsPic(
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void insertGoodsPic(String id, String goodsId, String companyId, String pic) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uuid", id);
		map.put("goodsId", goodsId);
		map.put("companyId", companyId);
		map.put("pic", pic);
		goodsMapper.insertGoodsPic(map);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qlzy.mainPage.indexGoods.service.IndexGoodsService#
	 * gianHotGoodsByGoodId(java.lang.String)
	 */
	@Override
	public List<Goods> gianHotGoodsByGoodCatId(String goodsCatId, Integer goodsLang) {
		/*
		 * 根据商品的分类id获取相关热卖商品<br> 所查询的商品是根据销量和点击量排序<br> 基数为1，其中销量占0.7，点击量占0.3
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodsCatId", goodsCatId);
		map.put("goodsLang", goodsLang);
		return goodsMapper.gianHotGoodsByGoodCatId(map);
	}

	@Override
	public List<Goods> gianHotGoodsByShGoodCatId(String shCatId, Integer goodsLang) {
		/*
		 * 根据商品的分类id获取相关热卖商品<br> 所查询的商品是根据销量和点击量排序<br> 基数为1，其中销量占0.7，点击量占0.3
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("shCatId", shCatId);
		map.put("goodsLang", goodsLang);
		return goodsMapper.gianHotGoodsByShGoodCatId(map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.mainPage.indexGoods.service.IndexGoodsService#insertBenison(java
	 * .util.Map)
	 */
	@Override
	public void insertBenison(Map<String, Object> map) {
		goodsMapper.insertBenison(map);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.mainPage.indexGoods.service.IndexGoodsService#gainBenisons()
	 */
	@Override
	public List<Goods> gainBenisons() {
		// TODO Auto-generated method stub
		return goodsMapper.gainBenisons();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qlzy.mainPage.indexGoods.service.IndexGoodsService#
	 * gianDictionaryValue()
	 */

	@Override
	public List<GoodsHot> gainGoodsHotT() {
		// TODO Auto-generated method stub
		return goodsHotMapper.gainGoodsHotT();
	}

	@Override
	public List<GoodsHot> gainGoodsHotP() {
		// TODO Auto-generated method stub
		return goodsHotMapper.gainGoodsHotP();
	}

	@Override
	public List<GoodsHot> gainGoodsHotG() {
		// TODO Auto-generated method stub
		return goodsHotMapper.gainGoodsHotG();
	}

	@Override
	public List<GoodsHot> gainGoodsHot() {
		// TODO Auto-generated method stub
		return goodsHotMapper.gainGoodsHot();
	}

	@Override
	public List<GoodsHot> gainGoodsHotS() {
		// TODO Auto-generated method stub
		return goodsHotMapper.gainGoodsHotS();
	}

	@Override
	public List<Goods> gainShIndexGoodsList(String string, int i) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("catName", string);
		map.put("goodsNum", i);
		return goodsMapper.gainShIndexGoodsList(map);
	}

	@Override
	public Integer gainShGoodsNum() {
		// TODO Auto-generated method stub
		return goodsMapper.gainShGoodsNum();
	}

	@Override
	public List<Goods> gainGoodsByTypeListAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		map.put("type", "热卖");
		return goodsMapper.gainGoodsByTypeListAll(map);
	}

	@Override
	public Long gainGoodsByTypeListAllcount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		map.put("type", "热卖");
		return goodsMapper.gainGoodsByTypeListAllcount(map);
	}

	@Override
	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.updateByPrimaryKeySelective(goods);
	}

	/**
	 * 根据类目查找商品列表
	 */
	@Override
	public List<Goods> queryGoodsByCarPartsId(String carPartsId, int goodsLang, int goodsLang2) {
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("carPartsId", goods.getCarPartsId());
		map.put("carPartsId", carPartsId);
		map.put("goodsLang", goodsLang);
		map.put("goodsLang2", goodsLang2);
		return goodsMapper.queryGoodsByCarPartsId(map);
	}

}
