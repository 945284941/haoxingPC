/**  
 * @Title: HotKeywordsService.java 
 * @Package com.gx.hotKeywords.service 
 * @Description: TODO(热词管理接口)
 * @author wangmei  
 * @date 2013-7-17 下午2:46:02
 * @version V1.0  
 */
package com.qlzy.mainPage.hotKeywords.service;

import java.util.List;

import com.qlzy.model.Hotkeywords;

public interface HotKeywordsService {

	/**
	 * @Title: gainHotkeywordsListByType
	 * @Description: TODO(查询某位置的热词列表)
	 * @param @param type
	 * @param @return 设定文件
	 * @return List<Hotkeywords> 返回类型
	 * @author wangmei
	 */
	public List<Hotkeywords> gainHotkeywordsListByType(Integer type);
}
