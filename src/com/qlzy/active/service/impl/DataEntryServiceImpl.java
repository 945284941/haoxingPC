/**  
* @Title: DataEntryServiceImpl.java
* @Package com.qlzy.active.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-7-1 下午3:17:28
* @version V1.0  
*/
package com.qlzy.active.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qlzy.active.dao.ActiveCollectGoodsQBMapper;
import com.qlzy.active.service.DataEntryService;
import com.qlzy.mainPage.head.dao.CarBrandMapper;
import com.qlzy.mainPage.head.dao.GoodsCatMapper;
import com.qlzy.model.ActiveCollectGoodsQB;
import com.qlzy.model.CarBrand;
import com.qlzy.model.GoodsCat;


/**
 * @ClassName: DataEntryServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-7-1 下午3:17:28
 */
@Service("dataEntryService")
public class DataEntryServiceImpl implements DataEntryService{
	
	@Resource
	private ActiveCollectGoodsQBMapper activeCollectGoodsQBMapper;
	@Resource
	private GoodsCatMapper goodsCatMapper;
	@Resource
	private CarBrandMapper carBrandMapper;
	/* (non-Javadoc)
	 * @see com.qlzy.active.service.DaraEntryService#gainActiveGoodsQB()
	 */
	@Override
	public List<ActiveCollectGoodsQB> gainActiveGoodsQB(Map<String, Object> map) {

		return activeCollectGoodsQBMapper.selectAll(map);
	}
	/* (non-Javadoc)
	 * @see com.qlzy.active.service.DaraEntryService#gainActiveGoodsQBNum()
	 */
	@Override
	public Long gainActiveGoodsQBNum(Map<String, Object> map) {
		
		return activeCollectGoodsQBMapper.gainActiveGoodsQBNum(map);
	}
	/* (non-Javadoc)
	 * @see com.qlzy.active.service.DataEntryService#gainGoodsCat()
	 */
	@Override
	public List<GoodsCat> gainGoodsCat() {
		return goodsCatMapper.gainGoodsCat(null);
	}
	/* (non-Javadoc)
	 * @see com.qlzy.active.service.DataEntryService#gainCarBrandFirst()
	 */
	@Override
	public List<CarBrand> gainCarBrandFirst() {
		return carBrandMapper.gainCarBrandList(1);
	}

}
