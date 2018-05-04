package com.qlzy.memberCenter.goods.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.qlzy.mainPage.indexGoods.dao.QlDictMapper;
import com.qlzy.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.common.tools.imageUtil.CompressPic;
import com.qlzy.mainPage.head.dao.CarBrandMapper;
import com.qlzy.mainPage.head.dao.GoodsCatMapper;
import com.qlzy.mainPage.indexGoods.dao.GoodsMapper;
import com.qlzy.memberCenter.goods.dao.CarPartsProducerMapper;
import com.qlzy.memberCenter.goods.dao.GoodsAndLabelMapper;
import com.qlzy.memberCenter.goods.dao.GoodsCarBrandMapper;
import com.qlzy.memberCenter.goods.dao.GoodsLabelMapper;
import com.qlzy.memberCenter.goods.dao.GoodsPicMapper;
import com.qlzy.memberCenter.goods.dao.SpecificationMapper;
import com.qlzy.memberCenter.goods.dao.SpecificationValueMapper;
import com.qlzy.memberCenter.goods.service.GoodsService;
import com.qlzy.shanghui.head.dao.GoodsCatShMapper;

/**
 * @ClassName: GoodsServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Huifeng Wang
 * @date 2013-5-28 下午4:52:05
 * 
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsCatMapper goodsCatMapper;
	@Autowired
	private GoodsCatShMapper goodsCatShMapper;
	@Autowired
	private CarBrandMapper carBrandMapper;
	@Autowired
	private CarPartsProducerMapper carPartsProducerMapper;
	@Autowired
	private GoodsLabelMapper goodsLabelMapper;
	@Autowired
	private SpecificationMapper specificationMapper;
	@Autowired
	private SpecificationValueMapper specificationValueMapper;
	@Autowired
	private GoodsPicMapper goodsPicMapper;
	@Autowired
	private GoodsCarBrandMapper goodsCarBrandMapper;
	@Autowired
	private GoodsAndLabelMapper goodsAndLabelMapper;
	@Resource
    private QlDictMapper qlDictMapper;
	@Override
	public void addGoods(Goods goods, Map<String, Object> map)
			throws UnsupportedEncodingException {
		String goodsLabelId = (String) map.get("goodsLabel");
		String specValues = new String(String.valueOf(map.get("specValues"))
				.getBytes("iso-8859-1"), "utf-8");
		// -----------------保存商品图片-------------
		String ttm = (String) (map.get("pic") == null ? "" : map
				.get("pic"));
		List<String> pic = ToolsUtil.StringConvertList(ttm);
		List<GoodsPic> goodsPicList = new ArrayList<GoodsPic>();
		for (String e : pic) {
			GoodsPic g = new GoodsPic();
			g.setId(ToolsUtil.getUUID());
			g.setGoodsId(goods.getId());
			g.setCompanyId("");
			g.setPicSrc(e);
			g.setPicSize(1D);
			goodsPicList.add(g);
		}
		if (pic.size() > 0) {
//			 CompressPic mypic = new CompressPic(); 
//			 pic.get(0);
//		     mypic.compressPic("e:\\", "e:\\test\\", "1.jpg", "r1"+i+".jpg", 214, 154, true);   压缩图片
			goods.setDefaultPicSrc(pic.get(0));
			goodsPicMapper.insertByList(goodsPicList);
		}
		if (!specValues.equals("")) {
			String[] temp = specValues.split(",");
			GoodsSpecificationValue gv;
			List<GoodsSpecificationValue> list = new ArrayList<GoodsSpecificationValue>();
			for (int i = 0; i < temp.length; i++) {
				gv = new GoodsSpecificationValue();
				String te = temp[i];
				String[] tem = te.split("~");
				gv.setId(ToolsUtil.getUUID());
				gv.setGoodsId(goods.getId());
				gv.setSpecificationId(tem[0]);
				gv.setSpecificationValue(tem[1]);
				list.add(gv);
			}
			specificationValueMapper.addSpecificationValue(list);
		}
		if (goodsLabelId != null && !goodsLabelId.equals("")) {
			String gli[] = goodsLabelId.split(",");
			GoodsAndLabel goodsAndLabel;
			List<GoodsAndLabel> li = new ArrayList<GoodsAndLabel>();
			for (int i = 0; i < gli.length; i++) {
				goodsAndLabel = new GoodsAndLabel();
				goodsAndLabel.setId(ToolsUtil.getUUID());
				goodsAndLabel.setGoodsId(goods.getId());
				goodsAndLabel.setGoodsLabelId(gli[i]);
				li.add(goodsAndLabel);
			}
			goodsAndLabelMapper.addGoodsAndLabel(li);
		}
		goodsMapper.addGoods(goods);
	}

	@Override
	public List<CarBrand> gainBrandList(Integer i) {
		return carBrandMapper.gainCarBrandList(1);
	}

	@Override
	public List<GoodsCat> gainCatList(Integer i) {
		return goodsCatMapper.gainCatalogueByGrade(1);
	}

	@Override
	public List<CarBrand> gainNextCarBrandListByPid(String pid) {
		if ("".equals(pid)) {
			return new ArrayList<CarBrand>();
		}
		return carBrandMapper.gainCarBrandListByPidBeach(ToolsUtil
				.StringConvertList(pid));
	}

	@Override
	public List<GoodsCat> gainNextGoodsCatListByPid(String pid) {
		return goodsCatMapper.gainCatalogueByPidBeach(ToolsUtil
				.StringConvertList(pid));
	}

	@Override
	public List<String> gainCarBrandNameById(String id) {
		return carBrandMapper.gainCarBrandNameById(ToolsUtil
				.StringConvertList(id));
	}

	@Override
	public List<CarBrand> gainBrandListByBrandName(String brand) {
		List<String> list = ToolsUtil.StringConvertList(brand);
		return carBrandMapper.gainBrandListByBrandName(list);
	}

	@Override
	public List<CarBrand> gainNextCarBrandListByPName(String parameter) {
		return carBrandMapper.gainNextCarBrandListByPName(ToolsUtil
				.StringConvertList(parameter));
	}

	@Override
	public List<GoodsCat> gainNextGoodsCatListByPName(String cat) {
		return goodsCatMapper.gainNextGoodsCatListByPName(ToolsUtil
				.StringConvertList(cat));
	}

	@Override
	public List<Goods> gainGoodsByIds(List<String> goodsIds) {
		return goodsMapper.selectGoodsByIds(goodsIds);
	}

	@Override
	public List<Goods> gainGoodsListByBn(String string) {
		// TODO Auto-generated method stub
		return goodsMapper.gainGoodsListByBn(string);
	}

	@Override
	public List<GoodsCat> gainGoodsCatList() {
		// TODO Auto-generated method stub
		return goodsCatMapper.gainGoodsCatList();
	}

	@Override
	public List<CarPartsProducer> gainCarPartsProducer() {
		return carPartsProducerMapper.gainCarPartsProducer();
	}

	@Override
	public List<GoodsLabel> gainGoodsLabels() {
		return goodsLabelMapper.gainGoodsLabelList(new GoodsLabel());
	}

	@Override
	public List<GoodsSpecification> gainGoodsSepcifications() {
		return specificationMapper
				.gainGoodsSpecifications(new GoodsSpecification());
	}

	@Override
	public List<Goods> gainGoodsListByCompanyIdWithPage(Map<String, Object> map) {
		return goodsMapper.gainGoodsListByCompanyIdWithPage(map);
	}

	@Override
	public Long gainGoodsListCountByCompanyIdWithPage(Map<String, Object> map) {
		return goodsMapper.gainGoodsListCountByCompanyIdWithPage(map);
	}

	@Override
	public List<CarBrand> gainCarBrandList() {
		return carBrandMapper.gainCarBrandListAll();
	}

	@Override
	public void delete(List<String> ids) {
		goodsMapper.delete(ids);
	}

	/* (非 Javadoc)
	* <p>Title: drop</p>
	* <p>Description: </p>
	* @param stringConvertList
	* @see com.qlzy.memberCenter.goods.service.GoodsService#drop(java.util.List)
	*/
	@Override
	public void drop(List<String> ids) {
		goodsMapper.drop(ids);
	}

	/* (非 Javadoc)
	* <p>Title: recover</p>
	* <p>Description: </p>
	* @param stringConvertList
	* @see com.qlzy.memberCenter.goods.service.GoodsService#recover(java.util.List)
	*/
	@Override
	public void recover(List<String> ids) {
		goodsMapper.recover(ids);
	}

	@Override
	public Goods gainGoodsById(String parameter) {
		Map<String,Object> parMap = new HashMap<String,Object>();
		parMap.put("goodsId",parameter);
		return goodsMapper.gainGoodsByPrm(parMap);
	}

	@Override
	public List<String> gainGoodsPicListByGoodsId(String goodsId) {
		return goodsPicMapper.gainGoodsPicListByGoodsId(goodsId);
	}

	@Override
	public List<GoodsSpecificationValue> gainGoodsSpecificationValueByGoodsId(
			String goodsId) {
		// TODO Auto-generated method stub
		return specificationValueMapper.gainGoodsSpecificationValueByGoodsId(goodsId);
	}

	@Override
	public List<GoodsAndLabel> gainGoodsAndLabelsByGoodsId(String goodsId) {
		// TODO Auto-generated method stub
		return goodsAndLabelMapper.gainGoodsAndLabelByGoodsId(goodsId);
	}

	@Override
	public List<String> gainGoodsMidCarBrand(String goodsId) {
		if(goodsId!=null){
			return goodsCarBrandMapper.gainGoodsMidCarBrand(goodsId);
		}else{
			return null;
		}
	}

	@Override
	public List<String> gainSecondCarBrand(List<String> carBrand) {
		if(carBrand!=null&&carBrand.size()>0){
			return carBrandMapper.gainCarBrandsByChildIds(carBrand);
		}else{
			return null;
		}
	}

	@Override
	public void updateGoods(Goods goods, Map<String, Object> map) throws UnsupportedEncodingException {
		String goodsLabelId = (String) map.get("goodsLabel");
		String specValues = new String(String.valueOf(map.get("specValues"))
				.getBytes("iso-8859-1"), "utf-8");
		String carBrand = String.valueOf(map.get("carBrand"));
		specificationValueMapper.dropSepcificationValueByGoodsId(goods.getId());
		
		goodsAndLabelMapper.dropGoodsAndLabelByGoodsId(goods.getId());
		
		List<String> goods_id=new ArrayList<String>();
		
		goods_id.add(goods.getId());
		
		goodsPicMapper.dropGoodsPicByGoodsId(goods_id);
		
		// -----------------保存商品图片-------------
		String ttm = (String) (map.get("pic") == null ? "" : map
				.get("pic"));
		List<String> pic = ToolsUtil.StringConvertList(ttm);
		List<GoodsPic> goodsPicList = new ArrayList<GoodsPic>();
		for (String e : pic) {
			GoodsPic g = new GoodsPic();
			g.setId(ToolsUtil.getUUID());
			g.setGoodsId(goods.getId());
			g.setCompanyId("");
			g.setPicSrc(e);
			g.setPicSize(1D);
			goodsPicList.add(g);
		}
		if (pic.size() > 0) {
			goods.setDefaultPicSrc(pic.get(0));
			goodsPicMapper.insertByList(goodsPicList);
		}
		if (!specValues.equals("")) {
			String[] temp = specValues.split(",");
			GoodsSpecificationValue gv;
			List<GoodsSpecificationValue> list = new ArrayList<GoodsSpecificationValue>();
			for (int i = 0; i < temp.length; i++) {
				gv = new GoodsSpecificationValue();
				String te = temp[i];
				String[] tem = te.split("~");
				gv.setId(ToolsUtil.getUUID());
				gv.setGoodsId(goods.getId());
				gv.setSpecificationId(tem[0]);
				gv.setSpecificationValue(tem[1]);
				list.add(gv);
			}
			specificationValueMapper.addSpecificationValue(list);
		}
		if (goodsLabelId != null && !goodsLabelId.equals("")) {
			String gli[] = goodsLabelId.split(",");
			GoodsAndLabel goodsAndLabel;
			List<GoodsAndLabel> li = new ArrayList<GoodsAndLabel>();
			for (int i = 0; i < gli.length; i++) {
				goodsAndLabel = new GoodsAndLabel();
				goodsAndLabel.setId(ToolsUtil.getUUID());
				goodsAndLabel.setGoodsId(goods.getId());
				goodsAndLabel.setGoodsLabelId(gli[i]);
				li.add(goodsAndLabel);
			}
			goodsAndLabelMapper.addGoodsAndLabel(li);
		}
		goodsMapper.updateByPrimaryKeySelective(goods);
	}

	@Override
	public void marketable(Map<String,Object> map ) {
		goodsMapper.marketable(map);
	}

	@Override
	public List<Goods> gainGoodsListByBnAndStanderIsZero(String parameter) {
		// TODO Auto-generated method stub
		return goodsMapper.gainGoodsListByBnAndStanderIsZero(parameter);
	}

	@Override
	public List<Map<String, Object>> gainNextGoodsCatListByPid2(String pid) {
		List<Map<String,Object>> lmap=new ArrayList<Map<String,Object>>();
		if(pid==null || pid.equals("")){
			List<GoodsCat> list =goodsCatMapper.gainCatalogueByGrade(1);
			if(list!=null && list.size()>0){
				for (int j = 0; j < list.size(); j++) {
					Map<String,Object> map =new HashMap<String,Object>();
					GoodsCat gc=list.get(j);
					map.put("id", gc.getId());
					map.put("text", gc.getName());
					if(goodsCatMapper.gainCatalogueCountByPid(gc.getId())>0){
						map.put("state", "closed");
					}else{
						map.put("state", "open");
					}
					lmap.add(map);
				}
			}
			
		}else{
			List<GoodsCat> list =goodsCatMapper.gainCatalogueByPid(pid);
			if(list!=null && list.size()>0){
				for (int j = 0; j < list.size(); j++) {
					Map<String,Object> map =new HashMap<String,Object>();
					GoodsCat gc=list.get(j);
					map.put("id", gc.getId());
					map.put("text", gc.getName());
					if(goodsCatMapper.gainCatalogueCountByPid(gc.getId())>0){
						map.put("state", "closed");
					}else{
						map.put("state", "open");
					}
					lmap.add(map);
				}
			}
		}
		return lmap;
	}

	
	@Override
	public List<Map<String, Object>> gainNextGoodsCatShListByPid2(String pid) {
		List<Map<String,Object>> lmap=new ArrayList<Map<String,Object>>();
		if(pid==null || pid.equals("")){
			List<GoodsCatSh> list = goodsCatShMapper.gainCatalogueShByGrade(1);
			if(list!=null && list.size()>0){
				for (int j = 0; j < list.size(); j++) {
					Map<String,Object> map =new HashMap<String,Object>();
					GoodsCatSh gc=list.get(j);
					map.put("id", gc.getId());
					map.put("text", gc.getName());
					if(goodsCatShMapper.gainCatalogueCountByPid(gc.getId())>0){
						map.put("state", "closed");
					}else{
						map.put("state", "open");
					}
					lmap.add(map);
				}
			}
			
		}else{
			List<GoodsCatSh> list =goodsCatShMapper.gainCatalogueShByPid(pid);
			if(list!=null && list.size()>0){
				for (int j = 0; j < list.size(); j++) {
					Map<String,Object> map =new HashMap<String,Object>();
					GoodsCatSh gc=list.get(j);
					map.put("id", gc.getId());
					map.put("text", gc.getName());
					if(goodsCatShMapper.gainCatalogueCountByPid(gc.getId())>0){
						map.put("state", "closed");
					}else{
						map.put("state", "open");
					}
					lmap.add(map);
				}
			}
		}
		return lmap;
	}
	
	
	@Override
	public String gainGoodsCatPidById(String carPartsId) {
		// TODO Auto-generated method stub
		return goodsCatMapper.gainGoodsCatPidById(carPartsId);
	}

	@Override
	public String gainGoodsCatPidShById(String shcarId) {
		// TODO Auto-generated method stub
		return goodsCatShMapper.gainGoodsCatPidShById(shcarId);
	}
	
	@Override
	public List<Map<String, Object>> gainCarBrandListByPid(String pid) {
		List<Map<String,Object>> lmap=new ArrayList<Map<String,Object>>();
		if(pid==null || pid.equals("")){
			List<CarBrand> list =carBrandMapper.gainCarBrandListForOneSelect();
			if(list!=null && list.size()>0){
				for (int j = 0; j < list.size(); j++) {
					Map<String,Object> map =new HashMap<String,Object>();
					CarBrand gc=list.get(j);
					map.put("id", gc.getId());
					map.put("text", gc.getName());
					if(carBrandMapper.gainCarBrandListCountByPid(gc.getId())>0){
						map.put("state", "closed");
					}else{
						map.put("state", "open");
					}
					lmap.add(map);
				}
			}
		}else{
			List<CarBrand> list =carBrandMapper.gainCarBrandListByPid(pid);
			if(list!=null && list.size()>0){
				for (int j = 0; j < list.size(); j++) {
					Map<String,Object> map =new HashMap<String,Object>();
					CarBrand gc=list.get(j);
					map.put("id", gc.getId());
					map.put("text", gc.getName());
					if(carBrandMapper.gainCarBrandListCountByPid(gc.getId())>0){
						map.put("state", "closed");
					}else{
						map.put("state", "open");
					}
					lmap.add(map);
				}
			}
		}
		return lmap;
	}

	@Override
	public String gainCarBrandPidById(String cpid) {
		// TODO Auto-generated method stub
		return carBrandMapper.gainCarBrandPidById(cpid);
	}

	@Override
	public String gainGoodsPicById(String goodsId) {
		// TODO Auto-generated method stub
		 String goodspics = goodsMapper.gainGoodsPicById(goodsId);
		 return goodspics;
	}

	@Override
	public List<Goods> gainGoodsListSearchShGoods(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodsMapper.gainGoodsListSearchShGoods(map);
	}

	@Override
	public Long gainGoodsListSearchGoodsShCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodsMapper.gainGoodsListSearchGoodsShCount(map);
	}

	@Override
	public List<GoodsSpecification> gainSpecification(String string) {
		// TODO Auto-generated method stub
		return specificationMapper.gainGoodsSpecificationsByPid(string);
	}

	@Override
	public List<Goods> selectByFlashSaleCat(Map<String, Object> parmMap) {
		return goodsMapper.selectByFlashSaleCat(parmMap);
	}

	@Override
	public List<Goods> selectGoodsByType(Map<String, Object> parmMap) {
		return goodsMapper.selectGoodsByType(parmMap);
	}
	@Override
	public List<Goods> selectGoodsByTypeAndPage(Map<String, Object> parmMap) {
		return goodsMapper.selectGoodsByTypeAndPage(parmMap);
	}

	@Override
	public Long selectGoodsByTypeAndPageCount(Map<String, Object> parmMap) {
		return goodsMapper.selectGoodsByTypeAndPageCount(parmMap);
	}

	@Override
	public Goods gainGoodsByPrm(Map<String, Object> parmMap) {
		return goodsMapper.gainGoodsByPrm(parmMap) ;
	}

	@Override
	public List<Goods> findGoodsListByCompanyId(String id) {
		List<Goods> goodsList=goodsMapper.findGoodsListByCompanyId(id);
		String USARate="";
		String ADMRate="";
		List<QlDict> dictList=qlDictMapper.selectByType("hv_type");
		for(int i=0;i<dictList.size();i++){
			if(dictList.get(i).getLabel().equals("now_rate_dlm")){
				ADMRate=dictList.get(i).getValue();
			}
			if(dictList.get(i).getLabel().equals("now_rate_doc")){
				USARate=dictList.get(i).getValue();
			}
		}
		DecimalFormat df = new DecimalFormat("#.00");
		for(int j=0;j<goodsList.size();j++){
			goodsList.get(j).setUSAMoney(Double.parseDouble(df.format(mul(Double.parseDouble(USARate),Double.parseDouble(goodsList.get(j).getPrice().toString())))));
			goodsList.get(j).setADMMoney(Double.parseDouble(df.format(mul(Double.parseDouble(ADMRate),Double.parseDouble(goodsList.get(j).getPrice().toString())))));
		}
		return goodsList;
	}

	@Override
	public List<Goods> gainFindGoodsBySelect(Goods goods) {
		return goodsMapper.gainFindGoodsBySelect(goods);
	}

	@Override
	public Long gainFindGoodsBySelectCount(Goods goods) {
		return goodsMapper.gainFindGoodsBySelectCount(goods);
	}

	public static double mul(double v1,double v2){
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}
}
