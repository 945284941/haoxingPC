package com.qlzy.shanghui.goodshot.action;

import java.util.List;
import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import com.qlzy.mainPage.indexGoods.service.IndexGoodsService;
import com.qlzy.model.GoodsHot;
import com.qlzy.util.BaseAction;
@Namespace("/")
//命名空间
@Action(value = "shGoodsHotAction", results = {
		@Result(name = "hotGoods", location = "/admin/goods/hotGoods.jsp"),
		@Result(name = "goods", location = "/admin/goods/goods.jsp"),
		@Result(name = "goodsHot", location = "/admin/goodsHot/goodsHot.jsp"),
		@Result(name = "toIndexGoodsHot", location = "/shanghui/goodsHot/indexGoodsHot.jsp")})
public class ShGoodsHotAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private IndexGoodsService indexGoodsService;
	public String toIndexGoodsHot(){
		List<GoodsHot> goodsHotList = indexGoodsService.gainGoodsHotS();
		request.setAttribute("goodsHotList", goodsHotList);
		return "toIndexGoodsHot";
	}
}
