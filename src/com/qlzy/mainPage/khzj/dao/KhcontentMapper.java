package com.qlzy.mainPage.khzj.dao;
import java.util.List;

import com.qlzy.model.Khcontent;


public interface KhcontentMapper {
    int insert(Khcontent record);

    int insertSelective(Khcontent record);

	List<Khcontent> gainKhzjContentAll();

	Khcontent gainKhcontentById(String khContentid);

	void updatePointSelective(Khcontent khcontent);
	List<Khcontent> gainKhzjContentTop4();
}