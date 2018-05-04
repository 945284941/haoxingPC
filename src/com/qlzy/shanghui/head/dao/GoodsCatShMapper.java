package com.qlzy.shanghui.head.dao;

import java.util.List;

import com.qlzy.model.GoodsCatSh;


public interface GoodsCatShMapper {
    

	List<GoodsCatSh> gainCatalogueShByGrade(int grade);

	List<GoodsCatSh> gainCatalogueShByPid(String pid);

	Long gainCatalogueCountByPid(String id);
	
	String gainGoodsCatPidShById(String id);
}