package com.qlzy.mainPage.want.action;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.util.PcOrWap;
import com.qlzy.mainPage.country.service.NCountryService;
import com.qlzy.mainPage.head.service.CatalogueService;
import com.qlzy.mainPage.want.service.WantBuyService;
import com.qlzy.model.GoodsCat;
import com.qlzy.model.NCountry;
import com.qlzy.model.WantBuy;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/12.
 */
@Namespace("/")
@Action(value = "wantBuy", results = {
        @Result(name="toAddWantBuy",location="/admin/want/add.jsp"),
        @Result(name="toWantBuyView",location="/admin/want/view.jsp"),
        @Result(name="toAddHand",location="/admin/want/addHand.jsp"),
        @Result(name="toHandView",location="/admin/want/handView.jsp"),
        @Result(name="toAddLcl",location="/admin/want/addLcl.jsp"),
        @Result(name="toLclView",location="/admin/want/lclView.jsp"),
        @Result(name="toAddLife",location="/admin/want/addLife.jsp"),
        @Result(name="toLifeView",location="/admin/want/lifeView.jsp")
})
public class WantBuyController extends BaseAction {
    @Resource
    private CatalogueService catalogueService;
    @Resource
    private NCountryService nCountryService;
    @Resource
    private WantBuyService wantBuyService;

    private List<GoodsCat> shopOneCatList;//商城一级分类
    private List<NCountry> fromCountryList;//求购国家
    private WantBuy wantBuy;
    private List<WantBuy> wantBuyList;

    /***
     * 跳转发布求购页面
     * @return
     */
    public String toAddWantBuy() {
        //查询商城的一级分类
        Map<String,String> shopMap = new HashMap<>();
        shopMap.put("pid",ResourceUtil.getShoppingId());
        shopOneCatList = catalogueService.gainCatalogueByPidAndSort(shopMap);
        //求购的国家
        fromCountryList = nCountryService.gainNCountry();
        if("2".equals(wantBuy.getBuyType())){
            return PcOrWap.isPc(request,"toAddHand");
        }else  if("3".equals(wantBuy.getBuyType())){
            return PcOrWap.isPc(request,"toAddLcl");
        }else if("4".equals(wantBuy.getBuyType())){
            return PcOrWap.isPc(request,"toAddLife");
        }else {
            return PcOrWap.isPc(request,"toAddWantBuy");
        }

    }

    /***
     * 求购添加
     */
    public void add(){
        String result = "success";
        try {
            SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
                    .getSessionInfoName());// 获取登录人信息
            if (sessionInfo != null && sessionInfo.getUserId() != null && !"".equals(sessionInfo.getUserId())) {
                wantBuy.setMemberId(sessionInfo.getUserId());
                wantBuyService.add(wantBuy);
            }else{
                result = "error";
            }
        } catch (Exception e) {
            result = "error";
            e.printStackTrace();
        }
        super.writeJson(result);

    }

    /***
     * 跳转求购详情
     * @return
     */
    public String toWantBuyView(){
        //根据id查询want信息
        Map<String,Object> parmMap = new HashMap<>();
        parmMap.put("id",wantBuy.getId());
        parmMap.put("buyType",wantBuy.getBuyType());
        wantBuy = wantBuyService.selectOneByParm(parmMap);
        parmMap = new HashMap<>();
        parmMap.put("buyType",wantBuy.getBuyType());
        wantBuyList = wantBuyService.selectByParm(parmMap);
        if("2".equals(wantBuy.getBuyType())){
            return PcOrWap.isPc(request,"toHandView");
        }else if("3".equals(wantBuy.getBuyType())){
            return PcOrWap.isPc(request,"toLclView");
        }else if("4".equals(wantBuy.getBuyType())){
            return PcOrWap.isPc(request,"toLifeView");
        }else{
            return PcOrWap.isPc(request,"toWantBuyView");
        }

    }

    public List<GoodsCat> getShopOneCatList() {
        return shopOneCatList;
    }

    public void setShopOneCatList(List<GoodsCat> shopOneCatList) {
        this.shopOneCatList = shopOneCatList;
    }

    public List<NCountry> getFromCountryList() {
        return fromCountryList;
    }

    public void setFromCountryList(List<NCountry> fromCountryList) {
        this.fromCountryList = fromCountryList;
    }

    public WantBuy getWantBuy() {
        return wantBuy;
    }

    public void setWantBuy(WantBuy wantBuy) {
        this.wantBuy = wantBuy;
    }

    public List<WantBuy> getWantBuyList() {
        return wantBuyList;
    }

    public void setWantBuyList(List<WantBuy> wantBuyList) {
        this.wantBuyList = wantBuyList;
    }

}
