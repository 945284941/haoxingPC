/**   
 * @Title: ExhibitionApplyServiceImpl.java 
 * @Package com.qlzy.mainPage.common.service.impl 
 * @Description: TODO(展会报名管理接口实现类) 
 * @author wangmei   
 * @date 2013-11-4 下午1:35:18 
 * @version V1.0   
 */
package com.qlzy.mainPage.common.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.common.dao.ExhibitionApplyMapper;
import com.qlzy.mainPage.common.service.ExhibitionApplyService;
import com.qlzy.model.ExhibitionApply;

@Service("exhibitionApplyService")
@Transactional(rollbackFor = Exception.class)
public class ExhibitionApplyServiceImpl implements ExhibitionApplyService {
	
	@Resource
	private ExhibitionApplyMapper exhibitionApplyMapper;
	
	/** (非 Javadoc) 
	 * @Title:addExhibitionApply 
	 * @Description: TODO(添加展会报名信息)  
	 * @param exhibitionApply 
	 * @see com.qlzy.mainPage.common.service.ExhibitionApplyService#addExhibitionApply(com.qlzy.model.ExhibitionApply) 
	 */
	@Override
	public void addExhibitionApply(ExhibitionApply exhibitionApply) {
		exhibitionApply.setId(ToolsUtil.getUUID());
		exhibitionApply.setCreatetime(new Date());
		exhibitionApplyMapper.addExhibitionApply(exhibitionApply);
	}
}
