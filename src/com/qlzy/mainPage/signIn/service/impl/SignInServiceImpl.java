package com.qlzy.mainPage.signIn.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.mainPage.signIn.dao.SignInModelMapper;
import com.qlzy.mainPage.signIn.service.SignInService;
import com.qlzy.memberCenter.common.dao.PointDetailMapper;
import com.qlzy.model.Member;
import com.qlzy.model.PointDetail;
import com.qlzy.model.SignInModel;
@Service("signInService")
public class SignInServiceImpl implements SignInService{
	
	@Resource
	private SignInModelMapper signInModelMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private MemberMapper memberMapper;
	@Resource
	private PointDetailMapper pointMapper;
	
	@Override
	public String IsAlreadySigned(String companyId) {
		// TODO Auto-generated method stub
		Member member = new Member();
		
		member = memberMapper.gainMemberById(companyId);
		String msg = "恭喜您签到成功";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId",companyId);
		Calendar currentDate = new GregorianCalendar();   
	    currentDate.set(Calendar.HOUR_OF_DAY, 0);  
	    currentDate.set(Calendar.MINUTE, 0);  
	    currentDate.set(Calendar.SECOND, 0);  
		map.put("startTime", (Date)currentDate.getTime().clone());
		
		currentDate.set(Calendar.HOUR_OF_DAY, 23);  
	    currentDate.set(Calendar.MINUTE, 59);  
	    currentDate.set(Calendar.SECOND, 59);  
	    map.put("endTime", (Date)currentDate.getTime().clone());
	    map.put("nowDate", new Date());
		List<SignInModel> list = signInModelMapper.isAlreadySigned(map);
		if(list.size() != 0){
				msg="您今天已经签到"; 
		}else{
				SignInModel record = new SignInModel();
				record.setId(ToolsUtil.getUUID());
				record.setCompanyId(companyId);
				record.setCompanyName(member.getUsername());
				record.setFirstTime(new Date());
				record.setLastTime(new Date());
				//record.setLoginNum(1);
				record.setDisable("false");
				signInModelMapper.insert(record);
				
				
				
				PointDetail pt = new PointDetail();
				pt.setId(ToolsUtil.getUUID());
				pt.setBalance(member.getPoint());
				pt.setCreatetime(new Date());
				pt.setMemberId(member.getId());
				pt.setPoint(100D);
				pt.setRemark("签到获取经验值100经验值");
				pt.setType(0);
				pointMapper.insertSelective(pt);
				
				member.setPoint(member.getPoint()+100);
				memberMapper.updateByPrimaryKeySelective(member);
		
		}
		return msg;
	}
	//获得广告币个数
	public Integer DeGuangBi(Integer num){
			if(num==1){ return 1;}
			else if(num==2){return 2;}
			else if(num==3){return 4;}
			else if(num==30){return 30;}
			else if(num==60){return 70;}
			else if(num==90){return 100;}
			else{
				return 5;
			}
	}
}
