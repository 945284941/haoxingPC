package com.qlzy.shop.action;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.qlzy.common.util.PcOrWap;
import com.qlzy.mainPage.company.service.CompanyService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.memberCenter.company.cominfo.service.CompanyInfoService;
import com.qlzy.model.Company;
import com.qlzy.model.Goods;
import com.qlzy.searchGoods.service.SearchGoodsService;
import com.qlzy.util.BaseAction;

@Namespace("/")
@Action(value = "shopAction",
		results = {
		@Result(name = "toBrands", location = "/admin/login/brands.jsp"),
        @Result(name = "toBrandsSuccess", location = "/admin/login/brandsSuccess.jsp"),
		@Result(name = "shopIndex", location = "/admin/shop/index.jsp")})
public class ShopAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Company company;
	private String companyId;
	private List<Goods> paiGoodsList;
	private List<Goods> hotGoodsList;
	private List<Goods> newGoodsList;

	
	@Resource
	private CompanyInfoService companyInfoService;
	@Resource
	private SearchGoodsService searchGoodsService;
    @Resource
    private CompanyService companyService;
	/**
	 * 进入品牌入驻界面
	 * @return
	 */
	public String toBrands() {
		return PcOrWap.isPc(request,"toBrands");
	}

    /**
     * 进入品牌入驻成功界面
     * @return
     */
    public String toBrandsSuccess() {
        return PcOrWap.isPc(request,"toBrandsSuccess");
    }

	/**
	 * 品牌入驻验证
	 */

	public void brands() {
        String result = "";
        HttpServletRequest request = ServletActionContext.getRequest();
        String linkmanName = request.getParameter("company.linkmanName");
        String linkmanPhone = request.getParameter("company.linkmanPhone");
        String remark = request.getParameter("company.remark");
        String recommendUserid = request.getParameter("company.recommendUserid");
        company.setRecommendUserid(recommendUserid);
        company.setLinkmanName(linkmanName);
        company.setLinkmanPhone(linkmanPhone);
        company.setRemark(remark);
        company.setIsonline(new BigDecimal(2));
        int num = companyService.insertCompany(company);
        if (num > 0) {
            result = "success";
		}

        super.writeJson(result);
    }
	/**
	 * 商家首页
	 * @return
	 */
	public String shopIndex() {

		//商家信息
		company = companyInfoService.gainCompanyById(companyId);
		//宝贝排行榜
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		map.put("sort", "QUERY_NUM");
		map.put("goodsLang1", 0);
		map.put("goodsLang2", 6);
		paiGoodsList = searchGoodsService.gainGoodsByCompany(map);
		
		//商品推荐
		map.put("sort", "CREATETIME");
		map.put("goodsLang1", 0);
		map.put("goodsLang2", 8);
		hotGoodsList = searchGoodsService.gainGoodsByCompany(map);
		
		//最新上架
		map.put("goodsLang1", 8);
		map.put("goodsLang2", 10);
		newGoodsList = searchGoodsService.gainGoodsByCompany(map);
		
		return "shopIndex";
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public List<Goods> getPaiGoodsList() {
		return paiGoodsList;
	}

	public void setPaiGoodsList(List<Goods> paiGoodsList) {
		this.paiGoodsList = paiGoodsList;
	}

	public List<Goods> getHotGoodsList() {
		return hotGoodsList;
	}

	public void setHotGoodsList(List<Goods> hotGoodsList) {
		this.hotGoodsList = hotGoodsList;
	}

	public List<Goods> getNewGoodsList() {
		return newGoodsList;
	}

	public void setNewGoodsList(List<Goods> newGoodsList) {
		this.newGoodsList = newGoodsList;
	}
	
}
