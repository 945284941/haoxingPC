/**  
 * @Title: MemberCallAction.java
 * @Package com.qlzy.memberCall.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 周张豹  
 * @date 2013-5-31 下午4:27:36
 * @version V1.0  
 */
package com.qlzy.memberCenter.call.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.qlzy.mainPage.company.service.CompanyService;
import com.qlzy.mainPage.companyBarnd.service.CompanyBarndService;
import com.qlzy.mainPage.country.service.NCountryService;
import com.qlzy.memberCenter.call.service.BankcardService;
import com.qlzy.memberCenter.call.service.impl.MemberCallServiceImpl;
import com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService;
import com.qlzy.memberCenter.shop.service.CompanysGoodsCatService;
import com.qlzy.model.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.qlzy.common.tools.Arith;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.common.util.UtilsHttp;
import com.qlzy.mainPage.indexGoods.dao.GoodsItemMapper;
import com.qlzy.mainPage.regions.service.RegionsService;
import com.qlzy.memberCenter.call.service.MemberCallService;
import com.qlzy.memberCenter.goods.service.GoodsService;
import com.qlzy.pojo.Json;
import com.qlzy.pojo.LhPayPojo;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.CookieUtils;
import com.qlzy.util.Pagination;
import org.springframework.ui.Model;

@Namespace("/")
@Action(value = "memberCallAction", results = {
		@Result(name = "showGoodsCollect", location = "/memberCenter/person/orders/goodsCollect.jsp"),
		@Result(name = "showShopCollect", location = "/memberCenter/person/orders/shopCollect.jsp"),
		@Result(name = "showBankcard", location = "/memberCenter/person/orders/bankcard.jsp"),
		@Result(name = "loadReceiveAddr", location = "/memberCenter/person/orders/newShippingAddr.jsp"),
		@Result(name = "shopDetail", location = "/memberCenter/person/orders/shopDetail.jsp"),
		@Result(name = "companyTail" , location = "/memberCenter/person/orders/companyDetail.jsp"),
		@Result(name = "toCart", location = "/admin/carts/cart.jsp"),
		@Result(name = "addr", location = "/admin/carts/addr.jsp"),
		@Result(name = "clearingAddr", location = "/admin/carts/clearingAddr.jsp"),
		@Result(name = "paymentFail", location = "/admin/carts/paymentFail.jsp"),
		@Result(name = "lhPayOrder", location = "/admin/carts/lhPay.jsp"),
		@Result(name = "lhPayLjhkOrder", location = "/admin/carts/lhPayLjhk.jsp"),
		@Result(name = "goClearing", location = "/admin/carts/clearing.jsp"),
		@Result(name = "goShChClearing", location = "/admin/carts/shChclearing.jsp"),
		@Result(name = "toPersonShippingAddr", location = "/memberCenter/person/orders/shippingAddr.jsp"),
		@Result(name = "loadMemberShippingAddr", location = "/memberCenter/person/orders/memberShippingAddr.jsp"),
		@Result(name = "paymentFail", location = "/admin/carts/paymentFail.jsp"),
		@Result(name = "paymenSuccess", location = "/admin/carts/paymenSuccess.jsp"),
		@Result(name = "webaGoods", location = "/shanghui/goods/webaGoods.jsp"),
		@Result(name = "topayment", type="redirect", location = "payment!toPaymentType.action?orderId=${orderId}"),
		@Result(name = "gozfbPay", type = "redirect", location = "memberCallAction!toZfbPay.action?orderId=${orderId}"),
		@Result(name = "tozfbPay", location = "/admin/carts/zfb.jsp"),
		@Result(name = "guliangbi", type = "redirect", location = "person/order/myOrders.html"),
		@Result(name = "companyGoodsList", location = "/memberCenter/person/orders/companyGoodsList.jsp")

})
/**
 * @ClassName: MemberCallAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-5-31 下午4:27:36
 */
public class MemberCallAction extends BaseAction {

	private static final Logger logger = Logger
			.getLogger(MemberCallAction.class);

	private static final long serialVersionUID = 1L;
	@Resource
	private MemberCallService memberCallService;
	@Resource
	private RegionsService regionsService;
	@Resource
	private GoodsService goodsService;
	@Resource
    private BankcardService bankcardService;
	@Autowired
	private GoodsItemMapper goodsItemMapper;
	@Autowired
	private NCountryService nCountryService;
    @Resource
	private CompanyService companyService;
    @Resource
    private CompanyBarndService companyBarndService;
    @Resource
    private CompanysGoodsCatService companysGoodsCatService;
    @Resource
    private MemberCollectService memberCollectService;
	private ReceiveAddress receiveAddress;
	private String goodsId;

	private String id;

	private String[] goodsIds;
	private SessionInfo sessionInfo = new SessionInfo();
	private List<Goods> goodsList;
	private String userId;
	private ReceiveAddress receiveAddr;
	private List<ReceiveAddress> raList;
	private String type;
	private Integer num;
	private List<Regions> provinces;
	private List<Regions> cityList;
	private List<Regions> areaList;
	private LhPayPojo lhPayPojo;
	private String isMail;
	private Double mailing;
	private Double mailMax;
	private List<GoodsItem> goodsItems;

	private List<Cart> carts;
	private List<Company> companyCarts;

	private String[] payCartsIds;

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public List<GoodsItem> getGoodsItems() {
		return goodsItems;
	}

	public void setGoodsItems(List<GoodsItem> goodsItems) {
		this.goodsItems = goodsItems;
	}

	private Member member = new Member();

	private TradePayDeail tradePayDeail;

	private String logistics;// 物流状态，N-不需要自提（物流发送），Y-需要自提
	private String payment;// 支付方式，1-粮票支付，0-网银支付

	private String remark;

	private String billType;
	private String billHead;
	private String billContent;

	private String downName;

	private String orderId;
	private String carId;


	private Bankcard bankcard;

	/**
	 * 显示收藏商品
	 * @return
	 */
	public String showGoodsCollect(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		String userId = sessionInfo.getUserId();
		MemberCollect memberCollect = new MemberCollect();
		memberCollect.setType("goods");
		memberCollect.setUserId(userId);
		List<MemberCollect> memberCollectList = memberCallService.gainGoodsCollect(memberCollect);
		request.setAttribute("memberCollectList",memberCollectList);
		request.setAttribute("sessionInfo",sessionInfo);
		return "showGoodsCollect";
	}

	/**
	 * 店铺详情的一部分列表
	 * @return
	 */
	public String shopDetail(){
		List<Goods> goodsList2=new ArrayList<Goods>();
		List<CompanysGoodsCat> goodsCatList=new ArrayList<CompanysGoodsCat>();
		String like ="";
        Company c=new Company();
		try {
			String id = request.getParameter("id");
			//对该店铺的商品进行处理
			goodsList2 = goodsService.findGoodsListByCompanyId(id);
           //店铺的父级分类
			goodsCatList=companysGoodsCatService.findCompanyGoodsCatByCompanyId(id);

			c = companyService.selectcCompanyById(id);

			for(int k=0;k<goodsCatList.size();k++){
				List<CompanysGoodsCat> companysGoodsCatList=findChildrenByPid(goodsCatList.get(k).getId());
			    if(companysGoodsCatList!=null&&companysGoodsCatList.size()!=0){
                  for(int o=0;o<companysGoodsCatList.size();o++){
                  	List<CompanysGoodsCat> cpgList=findChildrenByPid(companysGoodsCatList.get(o).getPid());
                  	companysGoodsCatList.get(o).setThreeCompanyCatList(cpgList);
				  }
				}
				goodsCatList.get(k).setThreeCompanyCatList(companysGoodsCatList);
			}
			//是否对店铺收藏过
			MemberCollect memberCollect=new MemberCollect();
			sessionInfo = (SessionInfo) session.get(ResourceUtil
					.getSessionInfoName());
			memberCollect.setUserId(sessionInfo.getUserId());
			memberCollect.setCollectId(id);
			memberCollect.setType("shop");
			List<MemberCollect> memberCollectList=memberCollectService.findListByMemberCollect(memberCollect);
			if(memberCollectList!=null&&memberCollectList.size()!=0){
              like="like";
			}else{
				like ="disLike";
			}
		}catch (Exception e){
				e.printStackTrace();
		}
		request.setAttribute("hobby",like);
		request.setAttribute("company",c);
		request.setAttribute("goodsList", goodsList2);
		request.setAttribute("goodsCatList",goodsCatList);
		return "shopDetail";
	}

	/**
	 * @Title companyGoodsList
	 * @Description TODO(条件查询当前店铺的商品)
	 * @return String
	 * @author Jason
	 */
	public String companyGoodsList(){
      Goods goods=new Goods();
      goods.setCompanyId(request.getParameter("id"));
      goods.setName(request.getParameter("name"));
      goods.setMinMoney(Double.parseDouble(request.getParameter("minMoney")));
      goods.setMaxMoney(Double.parseDouble(request.getParameter("maxMoney")));
      goods.setCarPartsProducerId(request.getParameter("carPartsProducerId"));
      String page=request.getParameter("page");
      int goodsPage=0;
      if(page!=null&&!page.equals("")){
		  goodsPage=Integer.parseInt(page);
	  }
      goods.setMinPage((goodsPage-1)*9);
      goods.setMaxPage(goodsPage*9);
      List<Goods> goodsList=goodsService.gainFindGoodsBySelect(goods);
      Long count=goodsService.gainFindGoodsBySelectCount(goods);

      request.setAttribute("goodPageList",goodsList);
	  return "companyGoodsList";
	}
	//店铺详情
    public String companyTail(){
		String id = request.getParameter("id");
        Company c=new Company();
		c = companyService.selectcCompanyById(id);
		CompanyBarnd companyBarnd = new CompanyBarnd();
		companyBarnd.setCompanyId(id);
		List<CompanyBarnd> bankcardList = companyBarndService.findBankCardByCid(companyBarnd);
		List<String> stringList = new ArrayList<String>();
		for (int i = 0; i < bankcardList.size(); i++) {
			stringList.add("<img src=" + bankcardList.get(i).getBarndLogo() + ">");
		}
		c.setImgList(stringList);
		request.setAttribute("company",c);
		return "companyTail";
	}

     public  List<CompanysGoodsCat> findChildrenByPid(String pid){
        return  companysGoodsCatService.findChildrenByPid(pid);
	 }
	/**
	 * 显示收藏店铺
	 * @return
	 */
	public String showShopCollect(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		String userId = sessionInfo.getUserId();
		MemberCollect memberCollect = new MemberCollect();
		memberCollect.setType("shop");
		memberCollect.setUserId(userId);
		List<MemberCollect> memberCollectList = memberCallService.gainShopCollect(memberCollect);
		request.setAttribute("memberCollectList",memberCollectList);
		return "showShopCollect";
	}

	/**
	 * 取消收藏
	 */
	public void delCollect(){
		String result="";
		int num = memberCallService.delCollect(request.getParameter("id"));
		if(num>0){
			result="success";
		}
		writeJson(result);
	}

	/**
	 * 查询银行卡信息
	 * @return
	 */
	public String showBankcard(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		List<Bankcard> bankcardList = memberCallService.gainBanckcard(sessionInfo.getUserId());
		for(Bankcard bc : bankcardList){
			String number = bc.getCardNumber();
			bc.setCardNumber(number.substring(number.length()- 4));
		}
		request.setAttribute("bankcardList",bankcardList);
		return "showBankcard";
	}

	/**
	 * 添加银行卡
	 */
	public void addBankcard(){
		String result = "";
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		bankcard = new Bankcard();
		bankcard.setId(request.getParameter("id"));
		bankcard.setMemberId(sessionInfo.getUserId());
		bankcard.setName(request.getParameter("name"));
		bankcard.setBank(request.getParameter("bank"));
		bankcard.setCardNumber(request.getParameter("cardNumber"));
		bankcard.setOpenBank(request.getParameter("openBank"));
		int num = memberCallService.addBanckcard(bankcard);
		if(num>0){
			result ="success";
		}
		writeJson(result);
	}

	/**
	 * 删除银行卡
	 */
	public void delBankcard(){
		memberCallService.delBankcardByPrimaryKey(request.getParameter("id"));
	}

	/**
	 * 编辑银行卡
	 */
	public void getBankcard(){
		bankcard = memberCallService.gainBankcardByPrimaryKey(request.getParameter("id"));
		writeJson(bankcard);
	}


	/**
	 *查询收货地址
	 * @return
	 */
	public String loadReceiveAddr() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		List<ReceiveAddress> addrList = memberCallService.gainReceiveAddresses(sessionInfo.getUserId());
		request.setAttribute("addrList",addrList);
		List<NCountry> countryList = nCountryService.gainNCountry();
		for(NCountry coun : countryList){
			String name = coun.getName()+"_"+coun.getNameEng();
			coun.setName(name);
		}
		request.setAttribute("countryList",countryList);
		return "loadReceiveAddr";
	}

	/**
	 * 编辑地址
	 */
	public void getReceiveAddr(){
		String id = request.getParameter("id");
		receiveAddress = memberCallService.gainReceiveAddressById(id);
//		NCountry nCountry = nCountryService.gainNCountryByPrimaryKey(receiveAddress.getCountryId());
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("receiveAddr",receiveAddress);
//		map.put("nCountry",nCountry);
		writeJson(receiveAddress);
	}


	/**
	 * 设置默认地址
	 */
	public  void setDefaultAddr(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		List<ReceiveAddress> receiveAddrList = memberCallService.gainReceiveAddresses(sessionInfo.getUserId());
		for(ReceiveAddress ra : receiveAddrList){
			ra.setIsDefault("false");
			memberCallService.updateReceiveAddress(ra);
		}
		String id = request.getParameter("id");
		receiveAddress = memberCallService.gainReceiveAddressById(id);
		receiveAddress.setIsDefault("true");
		memberCallService.updateReceiveAddress(receiveAddress);
	}

	/**
	 * 添加收货地址
	 * @return
	 */
	public void  addReceiveAddr() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		String result="";
		String country = request.getParameter("countryId");
		receiveAddress = new ReceiveAddress();
		receiveAddress.setUserId(sessionInfo.getUserId());
		receiveAddress.setId(request.getParameter("id"));
		receiveAddress.setReceiveName(request.getParameter("receiveName"));
		receiveAddress.setCountryId(country);
		receiveAddress.setReceiveAddress(request.getParameter("receiveAddress"));
		receiveAddress.setMobile(request.getParameter("mobile"));
		receiveAddress.setZip(request.getParameter("zip"));
		int num = memberCallService.addReceiveAddress(receiveAddress);
		if(num>0){
			result = "success";
		}
		super.writeJson(result);
	}

	/**
	 * 删除地址
	 */
	public void delReceiveAddr(){
		String id = request.getParameter("id");
		receiveAddress = memberCallService.gainReceiveAddressById(id);
		memberCallService.delMemberAddr(receiveAddress);
	}

	/**
	 * 会员收藏商品操作
	 *
	 * @Title: memberCollect
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void memberCollect() {
		try {
			sessionInfo = (SessionInfo) session.get(ResourceUtil
					.getSessionInfoName());
			if (sessionInfo != null) {

				if (type.endsWith("goods")) {
//					memberCallService.addClickNum(id);
				}
				// 用户登录情况下加入收藏
				MemberCollect memberCollect = new MemberCollect();
				memberCollect.setId(ToolsUtil.getUUID());
				memberCollect.setCollectId(id);
				memberCollect.setUserId(sessionInfo.getUserId());
				memberCollect.setUserType(sessionInfo.getUserType());
				memberCollect.setCollectIp(sessionInfo.getIp());
				memberCollect.setCollectTime(new Date());
				memberCollect.setType(type);
				memberCallService.addCollect(memberCollect);

			} else {
				// 用户不登陆情况下的临时购物车
				logger.error("用户未登录(Session中未获取到用户的信息)，收藏商品失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 加入购物车<br>
	 * 用户登录前：<br>
	 * 传递到这里，这时候，后台要做的就是从cookie中查询出是否有相同的记录，如果有相同的记录<br>
	 * 则把相应的记录更新；否则，就添加新的记录<br>
	 * 用户登录后：<br>
	 * 用户在登录后，如果有添加购物车操作，则不用保存到cookie中，而是直接持久化购物车信息<br>
	 *
	 * @Title: memberAddCart
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 *
	 *         2015年1约7号23点35分修改
	 */
	public void memberAddCart() {
		// 获取用户信息
		String a[] = goodsId.split(",");

		// 单品ID
		String goodsIda = a[0];
		Integer goodsNum = Integer.parseInt(a[1]);
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if (sessionInfo != null && sessionInfo.getUserId() != null
				&& !"".equals(sessionInfo.getUserId())) {
			userId = sessionInfo.getUserId();
			// 在用户登录状态下，直接将用户的购物车持久化到数据库中
			/*
			 * 首先要判断购物车是否有该商品，如果没有直接添加购物车 <br> 如果该数据库已经有该商品则商品的数量加1
			 */
			// 获取购物车该商品的数量

			Cart cart = memberCallService.gainGoodsByItemId(userId, goodsIda);
			if (cart != null && cart.getGoodsNum() != null
					&& cart.getGoodsNum() >= 1) {
				cart.setGoodsNum(cart.getGoodsNum() + goodsNum);

				memberCallService.updateCart(cart);

			} else {
				GoodsItem goodsItem = goodsItemMapper
						.selectByPrimaryKey(goodsIda);
				cart = new Cart();
				cart.setId(ToolsUtil.getUUID());
				cart.setUserId(userId);
				cart.setItemId(goodsIda);
				cart.setGoodsId(goodsItem.getProductId());
				cart.setGoodsNum(goodsNum);
				cart.setUserType(sessionInfo.getUserType());
				cart.setCreateTime(new Date());
				cart.setCreateIp(sessionInfo.getIp());
				memberCallService.addCart(cart);
			}
		} else {
			// 未登录的用户，将购物车信息放入cookie中
			try {
				CookieUtils.addCartInCookie(response, request, goodsIda,
						goodsNum);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

//	/**
//	 * 查看购物车<br>
//	 * 返回数据类型为：JSON
//	 *
//	 * @Title: gainCart
//	 * @Description: TODO(这里用一句话描述这个方法的作用)
//	 * @param     设定文件
//	 * @return void    返回类型
//	 * @author 周张豹
//	 */
//	public void gainCart() {
//		// 查看用户是否登录状态
//		sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());
//		if (sessionInfo != null && sessionInfo.getUserId() != null
//				&& !"".equals(sessionInfo.getUserId())) {
//			// 登录的用户从数据库中获取购物车信息
//			goodsList = memberCallService.gainCartByUserId(sessionInfo
//					.getUserId());
//		} else {
////			 未登录的用户从session中获取购物车信息
//			goodsList = memberCallService.gainCartByCookie(request);
//		}
//		super.writeJson(goodsList);
//	}

	/**
	 * 查看购物车商品的数量<br>
	 * 只查询数量
	 *
	 * @Title: gainCart
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void gainCartNum() {
		// 查看用户是否登录状态
		Integer num = 0;
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if (sessionInfo != null && sessionInfo.getUserId() != null
				&& !"".equals(sessionInfo.getUserId())) {
			// 登录的用户从数据库中获取购物车信息
			num = memberCallService
					.gainCartNumByUserId(sessionInfo.getUserId());
		} else {
			// 未登录的用户从session中获取购物车信息
			num = memberCallService.gainCartNumByCookie(request);
		}
		super.writeJson(num);
	}

	/**
	 * 转到购物车页面
	 *
	 * @Title: goCart
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 周张豹
	 */
	public String goCart() {
		// 查看用户是否登录状态
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		// 获取购物车中每个商家的购物车单品的列表
		companyCarts = new ArrayList<>();
		Map<String,Company> comMap = new HashMap<>();
		if (sessionInfo != null && sessionInfo.getUserId() != null
				&& !"".equals(sessionInfo.getUserId())) {
			// goodsList =
			// memberCallService.gainCartByUserId(sessionInfo.getUserId());
			carts = memberCallService
					.gainCartsByUserId(sessionInfo.getUserId());
			Map<String,Object> parmMap = new HashMap<>();
			parmMap.put("addressId",sessionInfo.getAddressMap().get("addressId"));
			if (!carts.isEmpty()) {
				for (Cart e : carts) {
					parmMap.put("goodsId",e.getGoodsId());
					Goods g = goodsService.gainGoodsByPrm(parmMap);
					e.setGoods(g);
					e.setGoodsItem(goodsItemMapper.selectByPrimaryKey(e
							.getItemId()));
					if(null != g){
						if(!comMap.containsKey(g.getCompanyId())){
							Company company = new Company();
							company.setCompanyName(g.getCompanyName());
							List<Cart> carts = new ArrayList<>();
							carts.add(e);
							company.setCartList(carts);
							comMap.put(g.getCompanyId(),company);
						}else{
							Company company = comMap.get(g.getCompanyId());
							company.getCartList().add(e);
							comMap.put(g.getCompanyId(),company);
						}
					}

				}
			}
		} else {
			// 未登录的用户从session中获取购物车信息
			Map<String,Object> parmMap = new HashMap<>();
			parmMap.put("addressId",sessionInfo.getAddressMap().get("addressId"));
			comMap = memberCallService.gainCartByCookie(request,parmMap,comMap);
		}
		if(null != comMap && comMap.size() > 0){
			for(Map.Entry<String,Company> c:comMap.entrySet()){
				System.out.println(c.getKey());
				System.out.println(c.getValue());
				companyCarts.add(c.getValue());
			}
		}
		return "toCart";
	}
	/**
	 * 修改购物车数量
	 *
	 * @Title: updateCartNum
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void updateCartNum() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		Json json = new Json();
		if (0 < num && num <= 1000) {
			Cart cart = new Cart();
			cart.setId(goodsId);
			cart.setGoodsNum(num);
			memberCallService.updateCartNumByGoodsId(cart);
			json.setSuccess(true);
			json.setMsg("成功");
		} else {
			json.setSuccess(false);
			json.setMsg("购物车的数量只能在1至1000之间");
		}
		super.writeJson(json);

	}
	/**
	 * 删除购物车中的商品<br>
	 * 分为两张情况：登录状态直接从数据库中删除，未登录从cookie删除
	 *
	 * @Title: memberDelCartGoods
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author
	 */
	public void memberDelCartGoods() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if (sessionInfo != null && sessionInfo.getUserId() != null
				&& !"".equals(sessionInfo.getUserId())) {
			try {
				memberCallService.delCartByGoodsId(
						ToolsUtil.StringConvertList(goodsId),
						sessionInfo.getUserId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			List<String> gList = ToolsUtil.StringConvertList(goodsId);
			if (gList.size() > 1) {// 大于1就是清除购物车
				CookieUtils.deleteCookieCartAll(response, request, "/");
			} else {
				CookieUtils.deleteCookieCartByGoodsId(response, request,
						gList.get(0));
			}

		}

	}
	/**
	 * 根据用户ID清空购物车
	 */
	public void clearCartGoods() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if (sessionInfo != null && sessionInfo.getUserId() != null
				&& !"".equals(sessionInfo.getUserId())) {
			try {
				memberCallService.clearByUserId(sessionInfo.getUserId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			List<String> gList = ToolsUtil.StringConvertList(goodsId);
			if (gList.size() > 1) {// 大于1就是清除购物车
				CookieUtils.deleteCookieCartAll(response, request, "/");
			} else {
				CookieUtils.deleteCookieCartByGoodsId(response, request,
						gList.get(0));
			}

		}

	}
	/**
	 * 立即购买<br>
	 * 先将用户现在立即购买的商品放入到购物车中 如果购物车存在，则更新为用户现在行为的数量<br>
	 * 再转到用户结算页面
	 *
	 * @Title: nowBuy
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 周张豹
	 */
//	public String nowBuy() {
//		try {
//			sessionInfo = (SessionInfo) session.get(ResourceUtil
//					.getSessionInfoName());
//			member = memberCallService.gainMember(sessionInfo.getUserId());
//			// System.out.println(member.getAdvance());
//			// 把用户立即购买的商品放入到购物车中
//			// goodsList =
//			// memberCallService.gainCartByGoodsIds(Arrays.asList(goodsId),
//			// sessionInfo);
//			// Goods goods = new Goods();
//			// 查询单品
//			GoodsItem goodsItem = goodsItemMapper.selectByPrimaryKey(goodsId);
//			// 商品ID
//			String productId = goodsItem.getProductId();
//			Goods goods = goodsService.gainGoodsById(productId);
//			goods.setShowSku(goodsItem.getSkuJsonHz());
//			goods.setPrice(goodsItem.getPrice());
//			goods.setCartNum(num);
//			if (goods.getIsMail().equals("true")) {
//				isMail = "true";
//				mailing = 0.0;
//			} else {
//				isMail = "false";
//				Map<String,Double> mMap = memberCallService.getMailing();
//				mailing = mMap.get("mail");
//				mailMax = mMap.get("mailMax");
//			}
//			String pic = goodsService.gainGoodsPicById(goods.getId());
//			if (null != pic && pic.length() > 0) {
//				goods.setDefaultPicSrc(pic.split(",")[0]);
//			} else {
//				goods.setDefaultPicSrc("/images/360-270zwpic.gif");
//			}
//			memberCallService.addCartByNowBuy(sessionInfo, productId, num);//
//			goodsList = Lists.newArrayList();
//			goodsList.add(goods);
//			// List<Goods> goodsList2 = new ArrayList<Goods>();
//			// if (null != goodsList && goodsList.size() > 0) {
//			// for (Goods good : goodsList) {
//			// String pic = goodsService.gainGoodsPicById(good.getId());
//			// goods = good;
//			// if (null != pic && pic.length() > 0) {
//			// goods.setDefaultPicSrc(pic.split(",")[0]);
//			// } else {
//			// goods.setDefaultPicSrc("/images/360-270zwpic.gif");
//			// }
//			// goodsList2.add(goods);
//			// }
//			// goodsList = goodsList2;
//			// }
//			// 查询用户的默认收货地址
//			receiveAddr = memberCallService
//					.gainReceiveAddressDefault(sessionInfo.getUserId());
//			if (receiveAddr == null) {
//				receiveAddr = new ReceiveAddress();
//				receiveAddr.setProvince("1");
//				receiveAddr.setCity("2");
//			}
//			raList = memberCallService.gainReceiveAddresses(sessionInfo
//					.getUserId());
//			provinces = regionsService.gainProvinceList();
//			cityList = regionsService.gainCityListByPid(receiveAddr
//					.getProvince());
//			areaList = regionsService.gainAreaListByCityId(receiveAddr
//					.getCity());
//		} catch (Exception e) {
//			System.err.println("用户立即购买出现问题！");
//			e.printStackTrace();
//		}
//		return "goClearing";
//	}

	public String nowBuyShCh() {
		try {
			sessionInfo = (SessionInfo) session.get(ResourceUtil
					.getSessionInfoName());
			memberCallService.addCartByNowBuy(sessionInfo, goodsId, num);// 把用户立即购买的商品放入到购物车中
//			goodsList = memberCallService.gainCartByGoodsIds(
//					Arrays.asList(goodsId), sessionInfo);
			Goods goods = new Goods();
			List<Goods> goodsList2 = new ArrayList<Goods>();
			if (null != goodsList && goodsList.size() > 0) {
				for (Goods good : goodsList) {
					String pic = goodsService.gainGoodsPicById(good.getId());
					goods = good;
					if (null != pic && pic.length() > 0) {
						goods.setDefaultPicSrc(pic.split(",")[0]);
					} else {
						goods.setDefaultPicSrc("/images/360-270zwpic.gif");
					}
					goodsList2.add(goods);
				}
				goodsList = goodsList2;
			}
			// 查询用户的默认收货地址
			receiveAddr = memberCallService
					.gainReceiveAddressDefault(sessionInfo.getUserId());
			if (receiveAddr == null) {
				receiveAddr = new ReceiveAddress();
				receiveAddr.setProvince("1");
				receiveAddr.setCity("2");
			}
			// 查询用户的担保信用
			Double guaranteePrice = memberCallService
					.gainCompanyGuaranteePriceByCompanyId(sessionInfo
							.getUserId());

			request.setAttribute("guaranteePrice", guaranteePrice);
			raList = memberCallService.gainReceiveAddresses(sessionInfo
					.getUserId());
			provinces = regionsService.gainProvinceList();
			cityList = regionsService.gainCityListByPid(receiveAddr
					.getProvince());
			areaList = regionsService.gainAreaListByCityId(receiveAddr
					.getCity());
		} catch (Exception e) {
			System.err.println("用户担保串货出现问题！");
			e.printStackTrace();
		}
		return "goShChClearing";
	}

//	/***
//	 * 转向结算页面
//	 *
//	 * @return
//	 */
//	public String goClearing(){
//		mailing = 0.0;
//		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
//		member = memberCallService.gainMember(sessionInfo.getUserId());
//		try {
//			//goodsList = memberCallService.gainCartByGoodsIds(Arrays.asList(goodsIds), sessionInfo);
//			List<Cart> cartList= memberCallService.gainCartsByIds(Arrays.asList(goodsIds),sessionInfo);
//			goodsList=Lists.newArrayList();
//
//			if(!cartList.isEmpty() && null != cartList){
//				carts = Lists.newArrayList();
//				for (Cart e : cartList) {
//					Goods goods = goodsService.gainGoodsById(e.getGoodsId());
//					/**
//					 * 最新的包邮政策
//					 * 1.需要买家咨询运费的不计算
//					 * 2.购买商品大于等于商品中规定的数量后免该商品的邮费
//					 */
//					if(null != goods.getIsConsultingPostage() && goods.getIsConsultingPostage().equals("1")){
//						mailing = Arith.add(mailing, (double) 0);
//						goods.setPostage((double) 0);
//					}else{
//						if (goods.getFreePostageNum() != null && goods.getFreePostageNum()!= 0
//								&& e.getGoodsNum().intValue() >= goods.getFreePostageNum().intValue() ) {
//
//							mailing = Arith.add(mailing, (double) 0);
//							goods.setPostage((double) 0);
//						} else {
//							//Double goodsMail = Arith.mul(goods.getWuliu(), e.getGoodsNum().doubleValue());
//							// 不免邮费的，买多少个都是设定的邮费
//							Double goodsMail = goods.getWuliu();
//							mailing = Arith.add(mailing, goodsMail);
//							goods.setPostage(goodsMail);
//						}
//					}
//
//					e.setGoods(goods);
//					e.setGoodsItem(goodsItemMapper.selectByPrimaryKey(e.getItemId()));
//
//					carts.add(e);
//					goodsList.add(goods);
//				}
//			}
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//
//		try {
//			// 查询用户的默认收货地址
//			receiveAddr = memberCallService.gainReceiveAddressDefault(sessionInfo.getUserId());
//			if (receiveAddr == null) {
//				receiveAddr = new ReceiveAddress();
//				receiveAddr.setProvince("1");
//				receiveAddr.setCity("2");
//			}
//			raList = memberCallService.gainReceiveAddresses(sessionInfo.getUserId());
//			provinces = regionsService.gainProvinceList();
//			cityList = regionsService.gainCityListByPid(receiveAddr.getProvince());
//			areaList = regionsService.gainAreaListByCityId(receiveAddr.getCity());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "goClearing";
//	}

	/**
	 * 转向结算页面
	 *
	 * @Title: goClearing
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 周张豹
	 */
	public String goClearing1() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		member = memberCallService.gainMember(sessionInfo.getUserId());
		try {
			// goodsList =
			// memberCallService.gainCartByGoodsIds(Arrays.asList(goodsIds),
			// sessionInfo);
			carts = memberCallService.gainCartsByIds(Arrays.asList(goodsIds),
					sessionInfo);

			if (!carts.isEmpty() && carts != null) {
				for (Cart e : carts) {
					e.setGoods(goodsService.gainGoodsById(e.getGoodsId()));
					e.setGoodsItem(goodsItemMapper.selectByPrimaryKey(e
							.getItemId()));
				}
			}
			goodsList = Lists.newArrayList();
			if (!carts.isEmpty() && carts != null) {
				for (Cart e : carts) {
					goodsList.add(e.getGoods());

				}
			}
			int i = 0;
			for (Goods g : goodsList) {
				if ("true".equals(g.getIsMail())) {
					i++;
				}
			}
			if (i > 0) {
				isMail = "true";
				mailing = 0.0;
				mailMax = 0.0;
			} else {
				isMail = "false";
				Map<String,Double> mMap = memberCallService.getMailing();
				mailing = mMap.get("mail");
				mailMax = mMap.get("mailMax");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			// 查询用户的默认收货地址
			receiveAddr = memberCallService
					.gainReceiveAddressDefault(sessionInfo.getUserId());
			if (receiveAddr == null) {
				receiveAddr = new ReceiveAddress();
				receiveAddr.setProvince("1");
				receiveAddr.setCity("2");
			}
			raList = memberCallService.gainReceiveAddresses(sessionInfo
					.getUserId());
			provinces = regionsService.gainProvinceList();
			cityList = regionsService.gainCityListByPid(receiveAddr
					.getProvince());
			areaList = regionsService.gainAreaListByCityId(receiveAddr
					.getCity());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "goClearing";
	}

//	/**
//	 * 查询用户的收货地址
//	 *
//	 * @Title: loadReceiveAddr
//	 * @Description: TODO(这里是修改收货地址时候使用de)
//	 * @param     设定文件
//	 * @return void    返回类型
//	 * @author 周张豹
//	 */
//	public String loadReceiveAddr() {
//		receiveAddr = memberCallService.gainReceiveAddressById(receiveAddr
//				.getId());
//		provinces = regionsService.gainProvinceList();
//		cityList = regionsService.gainCityListByPid(receiveAddr.getProvince());
//		areaList = regionsService.gainAreaListByCityId(receiveAddr.getCity());
//		return "addr";
//	}

	/**
	 * 查询用户的收货地址
	 *
	 * @Title: loadReceiveAddr
	 * @Description: TODO(这里是收货地址使用的)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public String loadReceiveClearingAddr() {
		receiveAddr = memberCallService.gainReceiveAddressById(receiveAddr
				.getId());
		provinces = regionsService.gainProvinceList();
		cityList = regionsService.gainCityListByPid(receiveAddr.getProvince());
		areaList = regionsService.gainAreaListByCityId(receiveAddr.getCity());
		return "clearingAddr";
	}

	/**
	 * 查询用户的收货地址(转向个人会员中心的收货地址管理)
	 *
	 * @Title: loadReceiveAddr
	 * @Description: TODO(这里是收货地址使用的)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public String toPersonShippingAddr() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		raList = memberCallService
				.gainReceiveAddresses(sessionInfo.getUserId());
		provinces = regionsService.gainProvinceList();
		cityList = regionsService.gainCityListByPid("1");
		areaList = regionsService.gainAreaListByCityId("2");
		return "toPersonShippingAddr";
	}

	/**
	 * 生成订单
	 *
	 * @Title: CreateOrder
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 周张豹
	 */
	public String CreateOrder() {
		TradePayDeail payDeail = null;
		try {
			sessionInfo = (SessionInfo) session.get(ResourceUtil
					.getSessionInfoName());
//			payDeail = memberCallService.addOrder(receiveAddr, goodsIds,
//					sessionInfo, logistics, payment, billType, billHead,
//					billContent, remark, mailing, payCartsIds);
			orderId = payDeail.getOrderId();

			// request.setAttribute("orderId", orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "topayment";
		/*if (payment.equals("0")) {
			return "gozfbpay";
		} else {
			return "guliangbi";
		}  */

	}

	public String toZfbPay() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		tradePayDeail = memberCallService.dealAliPay(orderId);
		return "tozfbPay";
	}

	public String CreateOrderCh() {
		try {
			sessionInfo = (SessionInfo) session.get(ResourceUtil
					.getSessionInfoName());
			Order order = memberCallService.addOrderCh(receiveAddr, goodsIds,
					sessionInfo, logistics, payment, billType, billHead,
					billContent, remark);
			request.setAttribute("order", order);
			return "paymenSuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "paymentFail";
		}

	}

	/**
	 * 对于已经生成订单前去付款
	 *
	 * @Title: toLhPay
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 周张豹
	 */
	public String toLhPay() {
		lhPayPojo = memberCallService.gainlhPayByOrderId(id);
		return "lhPayOrder";
	}

	public String toLhPayLjhk() {
		lhPayPojo = memberCallService.gainlhPayByOrderIdLjhk(id);
		return "lhPayLjhkOrder";
	}



	/**
	 * 用户删除收货地址
	 *
	 * @Title: memberDelAddr
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void memberDelAddr() {
		memberCallService.delMemberAddr(receiveAddr);
	}

	/**
	 * 修改用户的收货地址
	 *
	 * @Title: updateMemberAddr
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 周张豹
	 */
	public void updateMemberAddr() {
		String receiveAddrId = null;
		if (receiveAddr != null && receiveAddr.getId() != null
				&& !"".equals(receiveAddr.getId())) {
			memberCallService.updateReceiveAddress(receiveAddr);
			receiveAddrId = receiveAddr.getId();
		} else if (receiveAddr != null) {
			sessionInfo = (SessionInfo) session.get(ResourceUtil
					.getSessionInfoName());
			receiveAddrId = ToolsUtil.getUUID();
			receiveAddr.setId(receiveAddrId);
			receiveAddr.setUserId(sessionInfo.getUserId());
			memberCallService.addReceiveAddress(receiveAddr);
		}
		super.writeJson(receiveAddrId);
	}

	/**
	 * 修改用户的收货地址
	 *
	 * @Title: addMemberAddr
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 周张豹
	 */
	public void addMemberAddr() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		receiveAddr.setId(ToolsUtil.getUUID());
		receiveAddr.setUserId(sessionInfo.getUserId());
		memberCallService.addReceiveAddress(receiveAddr);
		super.writeJson(receiveAddr.getId());
	}

	/**
	 * 修改用户的默认收货地址
	 *
	 * @Title: memberDefaultAddr
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void memberDefaultAddr() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		receiveAddr.setUserId(sessionInfo.getUserId());
		memberCallService.memberDefaultAddr(receiveAddr);
	}

	public void downloadFile() throws Exception {
		String name = request.getParameter("path");
		String path = "../download/" + name + ".zip";// 从页面获取要下载的文件的相对路径
		// path="download/2013zhanwei.zip";
		if (!"".equals(path)) {
			path = new String(path.getBytes("ISO-8859-1"), "UTF-8");
			name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
			File file = new File(ResourceUtil.getWebAppPath() + path);// 构造要下载的文件
			if (file.exists()) {
				InputStream ins = new FileInputStream(
						ResourceUtil.getWebAppPath() + path);// 构造一个读取文件的IO流对象
				BufferedInputStream bins = new BufferedInputStream(ins);// 放到缓冲流里面
				OutputStream outs = response.getOutputStream();// 获取文件输出IO流
				BufferedOutputStream bouts = new BufferedOutputStream(outs);
				response.setContentType("application/x-download");// 设置response内容的类型
				// response.setHeader("Content-disposition","attachment;filename="+
				// URLEncoder.encode(name+".zip", "UTF-8"));//设置头部信息
				String fileName = name + ".zip";
				String agent = (String) request.getHeader("USER-AGENT");
				if (agent != null && agent.indexOf("MSIE") == -1) {// FF
					String enableFileName = "=?UTF-8?B?"
							+ (new String(Base64.encodeBase64(fileName
							.getBytes("UTF-8")))) + "?=";
					response.setHeader("Content-Disposition",
							"attachment; filename=" + enableFileName);
					response.setHeader("Content-Length", "" + file.length());
				} else { // IE
					String enableFileName = new String(
							fileName.getBytes("GBK"), "ISO-8859-1");
					response.setHeader("Content-Disposition",
							"attachment; filename=" + enableFileName);
					response.setHeader("Content-Length", "" + file.length());
				}

				int bytesRead = 0;
				byte[] buffer = new byte[8192];
				// 开始向网络传输文件流
				while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
					bouts.write(buffer, 0, bytesRead);
				}
				bouts.flush();// 这里一定要调用flush()方法
				ins.close();
				bins.close();
				outs.close();
				bouts.close();
			} else {
				super.writeJson("下载文件路径不存在");
			}
		} else {
			super.writeJson("下载文件时参数错误");
		}
	}

	/**
	 * 查询用户的所有的收货地址
	 *
	 * @Title: loadMemberShippingAddr
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public String loadMemberShippingAddr() {

		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		raList = memberCallService
				.gainReceiveAddresses(sessionInfo.getUserId());
		return "loadMemberShippingAddr";
	}

	/**
	 * 根据商品ID查询被收藏的总数、也可以是文章的ID
	 *
	 * @Title: selectCollect
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void selectCollect() {
		try {
			super.writeJson(memberCallService.selectCollectByCollectId(id));
		} catch (Exception e) {
			System.out.println("根据商品ID查询被收藏的总数、也可以是文章的ID" + e);
			e.printStackTrace();
		}
	}

	/**
	 * 查询购买记录
	 *
	 * @Title: gainBuyRecordByGoodsId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void gainBuyRecordByGoodsId() {
		try {
			super.writeJson(memberCallService.gainBuyRecordByGoodsId(goodsId));
		} catch (Exception e) {
			System.out.println("查询购买记录" + e);
			e.printStackTrace();
		}
	}

	/**
	 * 查询商品评价
	 *
	 * @Title: gainApprakiseByGoodsId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void gainApprakiseByGoodsId() {
		try {
			super.writeJson(memberCallService.gainApprakiseByGoodsId(goodsId));
		} catch (Exception e) {
			System.out.println("查询商品评价" + e);
			e.printStackTrace();
		}
	}

	/**
	 * 根据商品ID查询商品的成交量
	 *
	 * @Title: gainTransactionNumByGoodsId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void gainTransactionNumByGoodsId() {
		try {
			super.writeJson(memberCallService
					.gainTransactionNumByGoodsId(goodsId));
		} catch (Exception e) {
			System.out.println("根据商品ID查询商品的成交量" + e);
			e.printStackTrace();
		}
	}


	public String webaGoods() {
		Pagination pagination = definationPagination(request);
		pagination.setRows(20L);// 设置每页显示几条数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", "528商品");
		// map.put("goodsLang", goodsLang);
		pagination.setTotalCount(memberCallService
				.gainGoodsByTypeListcount(map));
		map.put("rows", pagination.getRows());
		map.put("page", pagination.getPage());
		goodsList = memberCallService.gainGoodsByTypeList(map);
		request.setAttribute("pagination", pagination);
		return "webaGoods";
	}

	public String webaGoodsByPtree() {
		Pagination pagination = definationPagination(request);
		pagination.setRows(20L);// 设置每页显示几条数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", "528商品");
		map.put("carId", carId);
		// map.put("goodsLang", goodsLang);
		pagination.setTotalCount(memberCallService
				.gainGoodsByTypeListcount(map));
		map.put("rows", pagination.getRows());
		map.put("page", pagination.getPage());
		goodsList = memberCallService.gainGoodsByTypeList(map);
		request.setAttribute("pagination", pagination);
		return "webaGoods";
	}

	/**
	 * 计算所需经验值
	 */
	public void getPercentage(){
		String payCartIds[] = goodsId.split(",");

		double amount = memberCallService.getPoint(payCartIds);
		writeJson(String.valueOf(amount));
	}

	/**
	 * @return the goodsId
	 */
	public String getGoodsId() {
		return goodsId;
	}

	/**
	 * @param goodsId
	 *            the goodsId to set
	 */
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	/**
	 * @return the sessionInfo
	 */
	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}

	/**
	 * @param sessionInfo
	 *            the sessionInfo to set
	 */
	public void setSessionInfo(SessionInfo sessionInfo) {
		this.sessionInfo = sessionInfo;
	}

	/**
	 * @return the goodsList
	 */
	public List<Goods> getGoodsList() {
		return goodsList;
	}

	/**
	 * @param goodsList
	 *            the goodsList to set
	 */
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	/**
	 * @return the goodsIds
	 */
	public String[] getGoodsIds() {
		return goodsIds;
	}

	/**
	 * @param goodsIds
	 *            the goodsIds to set
	 */
	public void setGoodsIds(String[] goodsIds) {
		this.goodsIds = goodsIds;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the receiveAddr
	 */
	/*public ReceiveAddress getReceiveAddr() {
		return receiveAddr;
	}*/

	/**
	 * @param receiveAddr
	 *            the receiveAddr to set
	 */
	public void setReceiveAddr(ReceiveAddress receiveAddr) {
		this.receiveAddr = receiveAddr;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * @param num
	 *            the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * @return the raList
	 */
	public List<ReceiveAddress> getRaList() {
		return raList;
	}

	/**
	 * @param raList
	 *            the raList to set
	 */
	public void setRaList(List<ReceiveAddress> raList) {
		this.raList = raList;
	}

	/**
	 * @return the provinces
	 */
	public List<Regions> getProvinces() {
		return provinces;
	}

	/**
	 * @param provinces
	 *            the provinces to set
	 */
	public void setProvinces(List<Regions> provinces) {
		this.provinces = provinces;
	}

	/**
	 * @return the cityList
	 */
	public List<Regions> getCityList() {
		return cityList;
	}

	/**
	 * @param cityList
	 *            the cityList to set
	 */
	public void setCityList(List<Regions> cityList) {
		this.cityList = cityList;
	}

	/**
	 * @return the areaList
	 */
	public List<Regions> getAreaList() {
		return areaList;
	}

	/**
	 * @param areaList
	 *            the areaList to set
	 */
	public void setAreaList(List<Regions> areaList) {
		this.areaList = areaList;
	}

	/**
	 * @return the logistics
	 */
	public String getLogistics() {
		return logistics;
	}

	/**
	 * @param logistics
	 *            the logistics to set
	 */
	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}

	/**
	 * @return the payment
	 */
	public String getPayment() {
		return payment;
	}

	/**
	 * @param payment
	 *            the payment to set
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}

	/**
	 * @return the billType
	 */
	public String getBillType() {
		return billType;
	}

	/**
	 * @param billType
	 *            the billType to set
	 */
	public void setBillType(String billType) {
		this.billType = billType;
	}

	/**
	 * @return the billHead
	 */
	public String getBillHead() {
		return billHead;
	}

	/**
	 * @param billHead
	 *            the billHead to set
	 */
	public void setBillHead(String billHead) {
		this.billHead = billHead;
	}

	/**
	 * @return the billContent
	 */
	public String getBillContent() {
		return billContent;
	}

	/**
	 * @param billContent
	 *            the billContent to set
	 */
	public void setBillContent(String billContent) {
		this.billContent = billContent;
	}

	/**
	 * @return the downName
	 */
	public String getDownName() {
		return downName;
	}

	/**
	 * @param downName
	 *            the downName to set
	 */
	public void setDownName(String downName) {
		this.downName = downName;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the lhPayPojo
	 */
	public LhPayPojo getLhPayPojo() {
		return lhPayPojo;
	}

	/**
	 * @param lhPayPojo
	 *            the lhPayPojo to set
	 */
	public void setLhPayPojo(LhPayPojo lhPayPojo) {
		this.lhPayPojo = lhPayPojo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public TradePayDeail getTradePayDeail() {
		return tradePayDeail;
	}

	public void setTradePayDeail(TradePayDeail tradePayDeail) {
		this.tradePayDeail = tradePayDeail;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getIsMail() {
		return isMail;
	}

	public void setIsMail(String isMail) {
		this.isMail = isMail;
	}

	public Double getMailing() {
		return mailing;
	}

	public void setMailing(Double mailing) {
		this.mailing = mailing;
	}

	public Double getMailMax() {
		return mailMax;
	}

	public void setMailMax(Double mailMax) {
		this.mailMax = mailMax;
	}

	public String[] getPayCartsIds() {
		return payCartsIds;
	}

	public void setPayCartsIds(String[] payCartsIds) {
		this.payCartsIds = payCartsIds;
	}

	public List<Company> getCompanyCarts() {
		return companyCarts;
	}

	public void setCompanyCarts(List<Company> companyCarts) {
		this.companyCarts = companyCarts;
	}
}