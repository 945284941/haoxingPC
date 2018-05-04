package com.qlzy.mainPage.hotKeywords.dao;

import java.util.List;

import com.qlzy.model.Hotkeywords;

public interface HotkeywordsMapper {

	/**
	 * @Title: gainHotkeywordsListByType
	 * @Description: TODO(查询某位置的热词列表)
	 * @param @param type
	 * @param @return 设定文件
	 * @return List<Hotkeywords> 返回类型
	 * @author wangmei
	 */
	List<Hotkeywords> gainHotkeywordsListByType(Integer type);
}