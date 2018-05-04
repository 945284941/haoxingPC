/**  
* @Title: SearchGoodsServiceImpl.java
* @Package com.qlzy.searchGoods.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com  
* @date 2013-5-21 下午3:48:12
* @version V1.0  
*/
package com.qlzy.searchGoods.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.common.tools.ToPinYin;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.head.dao.CarBrandMapper;
import com.qlzy.model.CarBrand;
import com.qlzy.model.Goods;
import com.qlzy.model.GoodsCarBrand;
import com.qlzy.model.GoodsDetail;
import com.qlzy.model.SearchKeyWord;
import com.qlzy.model.SpecificationInformation;
import com.qlzy.searchGoods.dao.GoodsDetailMapper;
import com.qlzy.searchGoods.dao.SearchKeyWordMapper;
import com.qlzy.searchGoods.service.SearchGoodsService;

/**
 * @ClassName: SearchGoodsServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author A18ccms a18ccms_gmail_com
 * @date 2013-5-21 下午3:48:12
 *
 */
@Service("searchGoodsService")
@Transactional(rollbackFor=Exception.class)
public class SearchGoodsServiceImpl implements SearchGoodsService{
	
	@Autowired
	private GoodsDetailMapper goodsDetailMapper ;
	@Autowired
	private CarBrandMapper carBrandMapper ;
	@Autowired
	private SearchKeyWordMapper searchKeyWordMapper ;
	
	
	@Override
	public List<GoodsDetail> gainGoodsListSearchGoods(Map<String, Object> map) {
	       List<GoodsDetail> list = goodsDetailMapper.gainGoodsListSearchGoods(map);
	     GoodsDetail goodsDetail= (GoodsDetail) map.get("goodsDetail");
	     if(null!=goodsDetail.getTopSearchLike()  && !"".equals(goodsDetail.getTopSearchLike())){
	    	//将搜索记录添加到表中
	    	List<SearchKeyWord> skwList = searchKeyWordMapper.gainByName(goodsDetail.getTopSearchLike());
	    	SearchKeyWord skw=new SearchKeyWord();
	    	if(skwList.size()==0){
	    		skw.setId(ToolsUtil.getUUID());
	    		skw.setName(goodsDetail.getTopSearchLike());
	    		skw.setClickNum(1L);
	    		skw.setPinName(ToPinYin.getFullSpell(goodsDetail.getTopSearchLike()));
	    		searchKeyWordMapper.addSearchKeyWord(skw);
	    	}else{
	    		skw = skwList.get(0);
	    		skw.setClickNum(skw.getClickNum()+1L);
	    		searchKeyWordMapper.updateByPrimaryKeySelective(skw);
	    	}
	     }
		return list;
	}
	
	@Override
	public List<GoodsDetail> gainGoodsListSearchShGoods(Map<String, Object> map) {
	       List<GoodsDetail> list = goodsDetailMapper.gainGoodsListSearchShGoods(map);
	       for (int i = 0; i < list.size(); i++) {
	    	   GoodsDetail	goodsDetail=list.get(i);
	    	   List<GoodsCarBrand> idList = carBrandMapper.gainCarBrandIdListByGoodsId(goodsDetail.getId());
	    	   String carVersionName="";
	    	   if(idList.size()!=0){
	    		   for (int j = 0; j < idList.size(); j++) {
	    		   CarBrand carVersion = carBrandMapper.gainCarBrandById(idList.get(j).getCarBrandId());
	    		   if("".equals(carVersionName)){
						carVersionName = carVersionName + carVersion.getName();
					}else{
						carVersionName = carVersionName +"  ,"+ carVersion.getName();
					}
	    		   }
	    	   }else{
	    		   carVersionName="暂无数据";
	    		   
	    	   }
	    	   list.get(i).setCarVersionId(carVersionName);
		}
	     GoodsDetail goodsDetail= (GoodsDetail) map.get("goodsDetail");
	     if(null!=goodsDetail.getTopSearchLike()  && !"".equals(goodsDetail.getTopSearchLike())){
	    	//将搜索记录添加到表中
	    	List<SearchKeyWord> skwList = searchKeyWordMapper.gainByName(goodsDetail.getTopSearchLike());
	    	SearchKeyWord skw=new SearchKeyWord();
	    	if(skwList.size()==0){
	    		skw.setId(ToolsUtil.getUUID());
	    		skw.setName(goodsDetail.getTopSearchLike());
	    		skw.setClickNum(1L);
	    		skw.setPinName(ToPinYin.getFullSpell(goodsDetail.getTopSearchLike()));
	    		searchKeyWordMapper.addSearchKeyWord(skw);
	    	}else{
	    		skw = skwList.get(0);
	    		skw.setClickNum(skw.getClickNum()+1L);
	    		searchKeyWordMapper.updateByPrimaryKeySelective(skw);
	    	}
	     }
		return list;
	}
	
	@Override
	public Long gainGoodsListSearchGoodsCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodsDetailMapper.gainGoodsListSearchGoodsCount(map);
	}
	@Override
	public Long gainGoodsListSearchGoodsShCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodsDetailMapper.gainGoodsListSearchGoodsShCount(map);
	}
	@Override
	public GoodsDetail gainStanderGoods(String bn) {
		// TODO Auto-generated method stub
		List<GoodsDetail> goodsDetailList = goodsDetailMapper.gainStanderGoods(bn);
		GoodsDetail	goodsDetail=null;
		if(goodsDetailList.size()!=0){
			goodsDetail=goodsDetailList.get(0);
		
			//根据商品id，得到该商品试用品牌，试用车系，试用车型
			List<GoodsCarBrand> idList = carBrandMapper.gainCarBrandIdListByGoodsId(goodsDetail.getId());
			if(idList.size()==0){
				goodsDetail.setCarBrandId("暂无数据");
				goodsDetail.setCarLineId("暂无数据");
				goodsDetail.setCarVersionId("暂无数据");
			}else{
				String carVersionName="";
				List<String> carLineNameList = new ArrayList<String>();
				List<String> carBrandNameList = new ArrayList<String>();
				for (int i = 0; i < idList.size(); i++) {
					if(i==0){
						CarBrand carVersion = carBrandMapper.gainCarBrandById(idList.get(i).getCarBrandId());
						CarBrand carLine = carBrandMapper.gainCarBrandById(carVersion.getPid());
						CarBrand carBrand = carBrandMapper.gainCarBrandById(carLine.getPid());
						if("".equals(carVersionName)){
							carVersionName = carVersionName + carVersion.getName();
						}else{
							carVersionName = carVersionName +","+ carVersion.getName();
						}
						carLineNameList.add(carLine.getName());
						carBrandNameList.add(carBrand.getName());

					}else{
						CarBrand carVersion = carBrandMapper.gainCarBrandById(idList.get(i).getCarBrandId());
						CarBrand carLine = carBrandMapper.gainCarBrandById(carVersion.getPid());
						CarBrand carBrand = carBrandMapper.gainCarBrandById(carLine.getPid());
						carVersionName = carVersionName +","+ carVersion.getName();
						boolean line=true;
						boolean brand=true;
						for (int j = 0; j < carLineNameList.size(); j++) {
							System.out.println("a"+carLineNameList.get(j)+"a");
							System.out.println("a"+carLine.getName()+"a");
							System.out.println(carLine.getName().equals(carLineNameList.get(j)));
							if(carLine.getName().equals(carLineNameList.get(j))){
								line=false;
							}
						}
						if(line){
							 carLineNameList.add(carLine.getName());
						 }
						for (int j = 0; j < carBrandNameList.size(); j++) {
							if(carBrand.getName().equals(carBrandNameList.get(j))){
								brand=false;
							}
						}
						 if(brand){
							 carBrandNameList.add(carBrand.getName());
						 }
					}
					
				}
				goodsDetail.setCarVersionId(carVersionName);
				String carLineNameString=(carLineNameList+"");
				String carBrandNameString=(carBrandNameList+"");
				if(!"".equals(carLineNameString)){
					carLineNameString=carLineNameString.substring(1,carLineNameString.length()-1);
				}
				if(!"".equals(carBrandNameString)){
					carBrandNameString=carBrandNameString.substring(1,carBrandNameString.length()-1);
				}
				goodsDetail.setCarLineId(carLineNameString);
				goodsDetail.setCarBrandId(carBrandNameString);
			}
		//产品规格
		List<SpecificationInformation> specificationInformations=goodsDetailMapper.gainSpecificationListByGoodsId(goodsDetail.getId());
		if (specificationInformations.size()!=0) {
			goodsDetail.setSpecificationInformationList(specificationInformations);
		} 
		}
		return goodsDetail;
	}
	
	@Override
	public List<Goods> gainGoodsByCompany(Map<String, Object> map) {
		
		return goodsDetailMapper.gainGoodsByCompany(map);
	}

}
