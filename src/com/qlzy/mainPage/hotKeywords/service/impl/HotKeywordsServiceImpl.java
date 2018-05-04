/**  
 * @Title: HotKeywordsServiceImpl.java 
 * @Package com.gx.hotKeywords.service.impl 
 * @Description: TODO(热词管理实现类)
 * @author wangmei  
 * @date 2013-7-17 下午2:48:29
 * @version V1.0  
 */
package com.qlzy.mainPage.hotKeywords.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.mainPage.hotKeywords.dao.HotkeywordsMapper;
import com.qlzy.mainPage.hotKeywords.service.HotKeywordsService;
import com.qlzy.model.Hotkeywords;

@Service("hotKeywordsService")
@Transactional(rollbackFor = Exception.class)
public class HotKeywordsServiceImpl implements HotKeywordsService {

	@Resource
	private HotkeywordsMapper hotkeywordsMapper;

	/**
	 * (non-Javadoc)
	 * 
	 * @Title: gainHotkeywordsListByType
	 * @Description: TODO(查询某位置的热词列表)
	 * @param type
	 * @return
	 * @see com.qlzy.mainPage.hotKeywords.service.HotKeywordsService#gainHotkeywordsListByType(java.lang.Integer)
	 */
	@Override
	public List<Hotkeywords> gainHotkeywordsListByType(Integer type) {
		return hotkeywordsMapper.gainHotkeywordsListByType(type);
	}

}
