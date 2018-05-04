/**  
* @Title: CollectServiceImpl.java
* @Package com.qlzy.memberCenter.person.collect.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-10-9 下午3:24:05
* @version V1.0  
*/
package com.qlzy.memberCenter.person.xianjiantixian.service.impl;


import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.common.dao.ContractMapper;
import com.qlzy.mainPage.company.dao.CompanyMapper;
//import com.qlzy.mainPage.login.dao.BankcardMapper;
import com.qlzy.memberCenter.call.dao.MemberCollectMapper;
import com.qlzy.memberCenter.common.dao.ViewsMapper;
import com.qlzy.memberCenter.order.dao.OrderMapper;
import com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService;
import com.qlzy.memberCenter.person.perinfo.dao.XianjinbiCashApplyMapper;
import com.qlzy.memberCenter.person.xianjiantixian.service.XianJinService;
import com.qlzy.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Transactional(rollbackFor=Exception.class)
@Service("xianjinService")
/**
 * @ClassName: CollectServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ss
 * @date
 */
public class XianJinServicempl implements XianJinService{
		@Resource
		private XianjinbiCashApplyMapper xianjinbiCashApplyMapper;

	 public int insertSelective(XianjinbiCashApply record){

		return  xianjinbiCashApplyMapper.insertSelective(record);
	}


}
