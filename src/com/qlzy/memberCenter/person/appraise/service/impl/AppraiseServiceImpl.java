/**??
* @Title: AppraiseServiceImpl.java
* @Package com.qlzy.memberCenter.person.appraise.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-10-7 下午2:11:55
* @version V1.0??
*/
package com.qlzy.memberCenter.person.appraise.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qlzy.memberCenter.common.dao.AppraisePicMapper;
import com.qlzy.model.AppraisePic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlzy.memberCenter.common.dao.AppraiseMapper;
import com.qlzy.memberCenter.order.dao.OrderItemMapper;
import com.qlzy.memberCenter.person.appraise.service.AppraiseService;
import com.qlzy.model.Appraise;
import com.qlzy.model.OrderItem;
import com.qlzy.pojo.StatisticsInfo;

/**
 * @ClassName: AppraiseServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhao yang bin
 * @date 2013-10-7 下午2:11:55
 *
 */
@Service
public class AppraiseServiceImpl implements AppraiseService{
	@Autowired
	private AppraiseMapper appraiseMapper;
	@Autowired
	private AppraisePicMapper appraisePicMapper;
	@Autowired
	private OrderItemMapper orderItemMapper;




	@Override
	public List<Appraise> gainAppraiseList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return appraiseMapper.gainAppraiseList(map);
	}

	@Override
	public Long gainAppraiseListCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return appraiseMapper.gainAppraiseListCount(map);
	}

	/* (non-Javadoc)
	 * @see com.qlzy.memberCenter.person.appraise.service.AppraiseService#memberAppraise(com.qlzy.model.Appraise)
	 */
	@Override
	public void memberAppraise(Appraise appraise) {
		appraiseMapper.insertSelective(appraise);
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderId(appraise.getOrderId());
		orderItem.setGoodsId(appraise.getGoodsId());
		orderItemMapper.updateAppraiseByOrderIdAndGoodsId(orderItem);
		
	}

	@Override
	public StatisticsInfo gainAllCountRight(String userId) {
		return appraiseMapper.gainAllCountRight(userId);
	}

	@Override
	public List<Appraise> gainAppraiseListByType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return appraiseMapper.gainAppraiseListByType(map);
	}

	@Override
	public Long gainAppraiseListCountByType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return appraiseMapper.gainAppraiseListCountByType(map);
	}
	@Override
	public StatisticsInfo gainAllCountRightByCompany(String userId) {
		// TODO Auto-generated method stub
		return appraiseMapper.gainAllCountRightByCompany(userId);
	}

	@Override
	public List<Appraise> selectAppariseByTypeAndPage(Map<String, Object> parmMap) {
		List<Appraise> appraiseList1 = appraiseMapper.selectAppariseByTypeAndPage(parmMap);
		List<Appraise> appraiseList = null;
		if(null != appraiseList1 && appraiseList1.size() > 0){
			appraiseList = new ArrayList<>();
			for(Appraise appraise:appraiseList1){
				if("1".equals(appraise.getIsPic())){
					List<AppraisePic> appraisePics = appraisePicMapper.selectByAppraiseId(appraise.getId());
					appraise.setAppraisePics(appraisePics);
				}
				appraiseList.add(appraise);
			}
		}
		return appraiseList;
	}

	@Override
	public Long selectAppariseByTypeAndPageCount(Map<String, Object> parmMap) {
		return appraiseMapper.selectAppariseByTypeAndPageCount(parmMap);
	}


}
