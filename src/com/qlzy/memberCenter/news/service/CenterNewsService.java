package com.qlzy.memberCenter.news.service;

import java.util.List;
import java.util.Map;

public interface CenterNewsService {

	List<Map<String,Object>> gainMemberCollectOfNews(Map<String, Object> map);

	Long gainMemberCollectCountOfNews(Map<String, Object> map);

	void deleteWzsc(List<String> stringConvertList);

	List<Map<String, Object>> gainViewOfNews(Map<String, Object> map);

	Long gainViewCountOfNews(Map<String, Object> map);

	void deleteLljl(List<String> stringConvertList);

}
