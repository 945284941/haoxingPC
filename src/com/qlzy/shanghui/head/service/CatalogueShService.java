package com.qlzy.shanghui.head.service;

import java.util.List;

import com.qlzy.model.GoodsCatSh;

public interface CatalogueShService {

	List<GoodsCatSh> gainCatalogueShByGrade(int grade);

	List<GoodsCatSh> gainCatalogueShByPid(String pid);

	List<GoodsCatSh> gainCatalogueShTByPid(String pid);

}
