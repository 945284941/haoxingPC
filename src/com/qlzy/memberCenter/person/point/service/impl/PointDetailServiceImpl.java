/**??
* @Title: PointDetailServiceImpl.java
* @Package com.qlzy.memberCenter.person.point.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-10-5 上午10:05:26
* @version V1.0??
*/
package com.qlzy.memberCenter.person.point.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlzy.memberCenter.common.dao.PointDetailMapper;
import com.qlzy.memberCenter.person.point.dao.CourtesyMemberMapper;
import com.qlzy.memberCenter.person.point.service.PointDetailService;
import com.qlzy.model.CourtesyMember;
import com.qlzy.model.PointDetail;

/**
 * @ClassName: PointDetailServiceImpl
 * @Description: TODO(经验值管理)
 * @author zhao  yang bin 
 * @date 2013-10-5 上午10:05:26
 *
 */
@Service
public class PointDetailServiceImpl implements PointDetailService{
	@Autowired
	private PointDetailMapper pointDetailMapper;
	
	@Autowired
	private  CourtesyMemberMapper courtesyMemberMapper;
	@Override
	public List<PointDetail> gainPointList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pointDetailMapper.gainPointList(map);
	}

	@Override
	public Long gainPointListCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pointDetailMapper.gainPointListCount(map);
	}

	@Override
	public void deletePointList(String pointId) {
		// TODO Auto-generated method stub
		pointDetailMapper.deletePointList(pointId);
	}

	@Override
	public List<CourtesyMember> gainYouhuiquanList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return courtesyMemberMapper.gainYouhuiquanList(map);
	}

}
