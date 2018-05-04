package com.qlzy.huitie.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.HuiTie;
import com.qlzy.model.News;

public interface HuiTieService {

	HuiTie gainHuiTieById(String id); 
	
	void updateViewNumById(HuiTie huiTie);
	
	public List<HuiTie>gainHuiTieIndex(Map<String, Object> param);
	
	public List<HuiTie> gainHuiTieListById(Map<String, Object> map);
	
	public Long gainHuiTieListByIdCount(Map<String, Object> map);
	
	void InsertHuiTie(HuiTie huiTie);
	
	List<HuiTie> MyHuiTie(Map<String, Object> param);
	
    public List<HuiTie> MyHuiTieList(Map<String, Object> map);
	
	public Long MyHuiTieListCount(Map<String, Object> map);
	
	HuiTie selectById(HuiTie huiTie);
	
	void updateById(HuiTie huiTie);
}
