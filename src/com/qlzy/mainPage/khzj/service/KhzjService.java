package com.qlzy.mainPage.khzj.service;

import java.util.List;

import com.qlzy.model.Khcontent;
import com.qlzy.model.Khzj;

public interface KhzjService {
	public List<Khcontent> gainKhzjContentAll();

	public List<Khzj> gainKhzjListByTel(String tpTelphone);

	public Khcontent gainKhcontentById(String khContentid);

	public void updatekhzj(Khcontent khcontent, Khzj khzj1);
	
	public List<Khcontent> gainKhzjContentTop4();
}
