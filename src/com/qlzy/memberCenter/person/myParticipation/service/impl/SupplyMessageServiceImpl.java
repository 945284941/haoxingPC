/**??
* @Title: SupplyMessageServiceImpl.java
* @Package com.qlzy.memberCenter.person.myParticipation.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-10-6 下午1:32:09
* @version V1.0??
*/
package com.qlzy.memberCenter.person.myParticipation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlzy.common.constant.SysSetting;
import com.qlzy.mainPage.news.dao.SupplyMapper;
import com.qlzy.memberCenter.person.myParticipation.service.SupplyMessageService;
import com.qlzy.model.Supply;
import com.qlzy.pojo.StatisticsInfo;

/**
 * @ClassName: SupplyMessageServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhao yang bin
 * @date 2013-10-6 下午1:32:09
 *
 */
@Service
public class SupplyMessageServiceImpl implements  SupplyMessageService{
	
	@Autowired
	private SupplyMapper  supplyMapper;

	@Override
	public List<Supply> gainSupplyList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Supply> list = supplyMapper.gainSupplyListByType(map);
		return list;
	}

	@Override
	public Long gainSupplyListCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		return supplyMapper.gainSupplyListByTypeCount(map);
	}
	
	@Override
	public Long gainSupplyMessage(Map map) {
		Long count = supplyMapper.gainSupplyMessageByType(map);
		return count;
	}
}
