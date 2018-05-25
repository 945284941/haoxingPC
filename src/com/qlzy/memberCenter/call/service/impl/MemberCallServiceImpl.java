/**  
 * @Title: MemberCallServiceImpl.java
 * @Package com.qlzy.memberCenter.call.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 周张豹  
 * @date 2013-6-5 上午11:27:49
 * @version V1.0  
 */
package com.qlzy.memberCenter.call.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.qlzy.common.tools.*;
import com.qlzy.common.util.UtilsJson;
import com.qlzy.mainPage.indexGoods.dao.QlDictMapper;
import com.qlzy.memberCenter.call.dao.*;
import com.qlzy.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.mainPage.indexGoods.dao.GoodsItemMapper;
import com.qlzy.mainPage.indexGoods.dao.GoodsMapper;
import com.qlzy.mainPage.login.dao.LoginLogMapper;
import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.memberCenter.call.service.MemberCallService;
import com.qlzy.memberCenter.common.dao.AppraiseMapper;
import com.qlzy.memberCenter.order.dao.OrderItemMapper;
import com.qlzy.memberCenter.order.dao.OrderMapper;
import com.qlzy.memberCenter.order.service.OrderService;
import com.qlzy.payment.dao.OrderPaymentMapper;
import com.qlzy.payment.service.IPaymentService;
import com.qlzy.pojo.LhPayPojo;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.CookieUtils;

@Transactional(rollbackFor = Exception.class)
@Service("memberCallService")
/**
 * @ClassName: MemberCallServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-6-5 上午11:27:49
 */
public class MemberCallServiceImpl implements MemberCallService {

	@Resource
	private CartMapper cartMapper;
	@Resource
	private MemberCollectMapper memberCollectMapper;
	@Resource
	private GoodsMapper goodsMapper;
	@Resource
	private ReceiveAddressMapper receiveAddressMapper;
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private OrderItemMapper orderItemMapper;
	@Resource
	private AppraiseMapper appraiseMapper;
	@Resource
	private PayDealMapper payDealMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private TradePayDeailMapper tradePayDeailMapper;
	@Resource
	private MemberMapper membersMapper;
	@Resource
	private LoginLogMapper loginLogMapper;
	@Autowired
	private GoodsItemMapper goodsItemMapper;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderPaymentMapper orderPaymentMapper;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private QlDictMapper qlDictMapper;
	@Autowired
	private BankcardMapper bankcardMapper;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#addCollect(com.qlzy.
	 * model.MemberCollect)
	 */

	@Override
	public int delCollect(String id){
		return memberCollectMapper.deleteByPrimaryKey(id);
	}
	@Override
	public List<MemberCollect> gainGoodsCollect(MemberCollect memberCollect){
		return memberCollectMapper.gainGoodsCollect(memberCollect);
	}

	@Override
	public List<MemberCollect> gainShopCollect(MemberCollect memberCollect){

		return memberCollectMapper.gainShopCollect(memberCollect);
	}

	@Override
	public int updateByPrimaryKey(Bankcard record){
		return bankcardMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public Bankcard gainBankcardByPrimaryKey(String id){

		return bankcardMapper.selectByPrimaryKey(id);
	}

	@Override
	public int delBankcardByPrimaryKey(String id){
		return bankcardMapper.deleteByPrimaryKey(id);

	}

	@Override
	public int addBanckcard(Bankcard bankcard){
		int num;
		if(bankcard.getId() != null && !"".equals(bankcard.getId())){
			num = bankcardMapper.updateByPrimaryKeySelective(bankcard);
		}else{
			bankcard.setId(ToolsUtil.getUUID());
			num = bankcardMapper.insertSelective(bankcard);
		}
		return num;
	}

	@Override
	public List<Bankcard> gainBanckcard(String memberId){
		return bankcardMapper.selectByMemberId(memberId);
	}
	@Override
	public void addCollect(MemberCollect collect) {
		Integer i = memberCollectMapper.selectCollectLong(collect);
		if (i > 0) {// 已经收藏了，则更新时间
			memberCollectMapper.updateCollect(collect);
		} else {// 没有收藏
			memberCollectMapper.insert(collect);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#addCart(com.qlzy.
	 * model.Cart)
	 */
	@Override
	public void addCart(Cart cart) {
		cartMapper.insert(cart);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#gainCartByUserId(
	 * java.lang.String)
	 */
	@Override
	public List<Goods> gainCartByUserId(String userId) {
		// 根据用户ID获取商品的名称、价格、默认图片
		return goodsMapper.selectGoodsByCart(userId);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#gainCartByGoodsIds(
	 * java.util.List)
	 */
//	@Override
//	public List<Goods> gainCartByGoodsIds(List<String> goodsIds, SessionInfo sessionInfo) {
//		if (goodsIds != null && goodsIds.size() >= 1) {
//
//			List<Goods> list = goodsMapper.selectGoodsByIds(goodsIds);
//			Cart cart = new Cart();
//			cart.setUserId(sessionInfo.getUserId());
//			for (Goods goods : list) {
//				cart.setGoodsId(goods.getId());
//				Cart c = cartMapper.selectGoodsNumInCartByGoodsId(cart);
//				goods.setCartNum(c.getGoodsNum());
//			}
//			return list;
//		} else {
//			return null;
//		}
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qlzy.memberCenter.call.service.MemberCallService#
	 * gainGoodsNumInCartByGoodsID(java.lang.String)
	 */
	@Override
	public Cart gainGoodsByGoodsId(String userId, String goodsId) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setGoodsId(goodsId);
		return cartMapper.selectGoodsNumInCartByGoodsId(cart);
	}

	@Override
	public Cart gainGoodsByItemId(String userId, String itemId) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setItemId(itemId);
		return cartMapper.selectGoodsNumInCartByItemId(cart);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#updateCartByCookie(
	 * com.qlzy.pojo.SessionInfo)
	 */
	@Override
	public void updateCartByCookie(HttpServletResponse response, HttpServletRequest request, SessionInfo sessionInfo) {
		/*
		 * 在用户登录的时候把客户端存放的购物车信息放入到数据库中<br> 如果数据库存在该商品，并且数量大于cookie的数量则不做任何操作<br>
		 * 如果数据存存在该商品，并且数量小于cookie的数量则更新数量为cookie中的数量 操作完成后把客户端的购物车信息清空
		 */

		LoginLog loginLog = new LoginLog();
		loginLog.setId(ToolsUtil.getUUID());
		loginLog.setLoginTime(new Date());
		loginLog.setUserId(sessionInfo.getUserId());
		loginLog.setUserName(sessionInfo.getLoginName());
		loginLogMapper.insertSelective(loginLog);

		List<Cart> list = CookieUtils.getCookieCart(request, sessionInfo);
		for (Cart cart : list) {
			Cart o = cartMapper.selectGoodsNumInCartByGoodsId(cart);
			GoodsItem goodsItem = goodsItemMapper.selectByPrimaryKey(cart.getItemId());
			if (o != null && o.getGoodsNum() < cart.getGoodsNum()) {
				// 数据库中存在该商品，并且数量小于cookie的数量
				o.setGoodsNum(cart.getGoodsNum());
				o.setGoodsId(goodsItem.getProductId());
				cartMapper.updateByPrimaryKey(o);
			} else if (o == null) {
				// 数据库中不存在该商品
				cart.setId(ToolsUtil.getUUID());
				cart.setGoodsId(goodsItem.getProductId());
				cartMapper.insert(cart);
			}

		}
		// 清空本地购物车信息
		// 没有找到合适的方法
		CookieUtils.deleteCookieCartAll(response, request, "/");

	}


	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#gainCartByCookie(
	 * javax.servlet.http.HttpServletRequest, com.qlzy.pojo.SessionInfo)
	 */

	@Override
	public Map<String,Company> gainCartByCookie(HttpServletRequest request,Map<String,Object> parmMap,Map<String,Company> comMap) {
		/*
		 * 获取Cookie中购物车信息
		 */
		List<Cart> list = CookieUtils.getCookieCart(request, null);
		for (Cart cart : list) {
			GoodsItem goodsItem = goodsItemMapper.selectByPrimaryKey(cart.getItemId());
			cart.setId(cart.getItemId());
			parmMap.put("goodsId",goodsItem.getProductId());
			Goods g = goodsMapper.gainGoodsByPrm(parmMap) ;
			cart.setGoods(g);
			cart.setGoodsItem(goodsItemMapper.selectByPrimaryKey(goodsItem.getId()));
			if(null != g){
				if(!comMap.containsKey(g.getCompanyId())){
					Company company = new Company();
					company.setCompanyName(g.getCompanyName());
					List<Cart> carts = new ArrayList<>();
					carts.add(cart);
					company.setCartList(carts);
					comMap.put(g.getCompanyId(),company);
				}else{
					Company company = comMap.get(g.getCompanyId());
					company.getCartList().add(cart);
					comMap.put(g.getCompanyId(),company);
				}
			}
		}
		return comMap;
	}
	@Override
	public Integer gainCartNumByCookieParmMap(HttpServletRequest request, Map<String, Object> parmMap) {
		List<Cart> list = CookieUtils.getCookieCart(request, null);
		int c = 0;
		for (Cart cart : list) {
			parmMap.put("goodsId", cart.getGoodsId());
			Goods g = goodsMapper.gainGoodsByPrm(parmMap);
			if(null != g){
				c = c + cart.getGoodsNum();
			}
		}
		return c;
	}
		/*
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#updateCart(com.qlzy.
	 * model.Cart)
	 */
	@Override
	public void updateCart(Cart cart) {
		memberCollectMapper.updateByPrimaryKeySelective(cart);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qlzy.memberCenter.call.service.MemberCallService#
	 * gainReceiveAddressDefault(java.lang.String)
	 */
	@Override
	public ReceiveAddress gainReceiveAddressDefault(String userId) {
		// 获取用户的默认收货地址
		ReceiveAddress receiveAddress = receiveAddressMapper.selectReceiveAddressDefault(userId);
		if (receiveAddress == null) {
			// 在默认地址不存在的情况下，获取所有的收货地址
			List<ReceiveAddress> list = receiveAddressMapper.selectReceiveAddressAll(userId);
			if (list != null && list.size() >= 1) {
				// 如果存在收货地址将第一个地址返回
				receiveAddress = list.get(0);
			}
		}
		return receiveAddress;
	}
	@Override
	public TradePayDeail addOrder(String receiveAddrId, String goodsItemIds,
										  SessionInfo sessionInfo, String countryId,String orderMsg,
								  String isNowBuy, String isOneBuy,Integer nowBuyNum){
		BigDecimal payPrice = BigDecimal.ZERO;//应该支付的金额 人民币
		BigDecimal payDlmPrice = BigDecimal.ZERO;
		BigDecimal payDocPrice = BigDecimal.ZERO;
		BigDecimal orderPoint = BigDecimal.ZERO;
		Order order = new Order();
		order.setId(ToolsUtil.getUUID());
		order.setCountryId(countryId);
		order.setMemberId(sessionInfo.getUserId());
		order.setOrderNum(OrderUtil.getOrderId());
		order.setOrderMsg(orderMsg);
		order.setCreatetime(new Date());
		List<OrderItem> orderItemList = new ArrayList<>();
		Map<String,Goods> goodsMap = new HashMap<>();
		List<String> cartsIds = new ArrayList<>();//用来删除购物车信息

		TradePayDeail payDeail = new TradePayDeail();
		/*
		 * 根据收货表Id查询收货人的信息
		 */
		ReceiveAddress	receiveAddress = receiveAddressMapper.selectByPrimaryKey(receiveAddrId);
		order.setShipName(receiveAddress.getReceiveName());
		order.setShipTel(receiveAddress.getMobile());
		order.setAddress(receiveAddress.getReceiveAddress());
		order.setShipZip(receiveAddress.getZip());
		/*
		 * 商品ID，查询商品信息
		 */
		Map<String, Object> parmMap = new HashMap<>();
		String goodsItemIds1[] = goodsItemIds.split(",");
		parmMap.put("userId", sessionInfo.getUserId());
		parmMap.put("addressId", countryId);
		parmMap.put("itemList", Arrays.asList(goodsItemIds1));
		if("1".equals(isNowBuy)) {//立即购买
			OrderItem orderItem = hanldeOrderItem(goodsItemIds,parmMap, isOneBuy,goodsMap,order.getId(),nowBuyNum, countryId);
			orderItemList.add(orderItem);
			payPrice = orderItem.getAmount();
			payDlmPrice = orderItem.getDlmPrice();
			payDocPrice = orderItem.getDocPrice();
			orderPoint = orderItem.getPoint();
			order.setDocBili(orderItem.getDocBili());
			order.setDlmBili(orderItem.getDlmBili());
		}else {//加入购物车购买
			List<Cart> carts = cartMapper.selectCartsByUserIdAndAd(parmMap);
			if (!carts.isEmpty()) {
				for (Cart e : carts) {
					OrderItem orderItem = hanldeOrderItem(e.getItemId(),parmMap, "1",goodsMap,order.getId(),e.getGoodsNum(), countryId);
					payPrice = payPrice.add(orderItem.getAmount());
					payDlmPrice = payDlmPrice.add(orderItem.getDlmPrice());
					payDocPrice = payDocPrice.add(orderItem.getDocPrice());
					orderPoint = orderPoint.add(orderItem.getPoint());
					order.setDocBili(orderItem.getDocBili());
					order.setDlmBili(orderItem.getDlmBili());
					orderItemList.add(orderItem);
					cartsIds.add(e.getId());
				}
			}
		}
		order.setTotalCost(payPrice);
		order.setTotalDlmPrice(payDlmPrice);
		order.setTotalDocPrice(payDocPrice);
		order.setOrderPoints(orderPoint);
		payDeail.setId(ToolsUtil.getUUID());
		payDeail.setOrderId(order.getId());
		payDeail.setOrderMsg(orderMsg);
		payDeail.setOrderNum(order.getOrderNum());
		String orderName = "颐佳商城";
		payDeail.setOrderName(orderName);
		payDeail.setTotalPrice(order.getTotalCost().doubleValue());
		payDeail.setPaydate(new Date());
		tradePayDeailMapper.insertSelective(payDeail);

		/*
		 * 将订单、订单详情存入数据库中
		 */
		orderMapper.insertSelective(order);
		orderItemMapper.batchInsert(orderItemList);
		//提交完订单应清除对应购物车里面的商品
		if(null != cartsIds && cartsIds.size() > 0){
			Map<String, Object> map = new HashMap<>();
			map.put("item", cartsIds);
			map.put("userId", sessionInfo.getUserId());
			cartMapper.deleteByGoodeIds(map);
		}
		return payDeail;
	}

	public OrderItem hanldeOrderItem(String goodsItemId,Map<String,Object> parmMap,String isOneBuy,
						   Map<String,Goods> goodsMap,String orderId,
							   Integer nowBuyNum,String countryId){
		String isActivity = "0";
		BigDecimal payItemPrice = BigDecimal.ZERO;//应该支付的金额 人民币
		BigDecimal payItemDlmPrice = BigDecimal.ZERO;
		BigDecimal payItemDocPrice = BigDecimal.ZERO;
		BigDecimal dealItemPrice = BigDecimal.ZERO;//单个商品价格
		Goods g = null;
		GoodsItem goodsItem = goodsItemMapper.selectByPrimaryKey(goodsItemId);
		if(null != goodsMap && goodsMap.size() > 0){
			if(goodsMap.containsKey(goodsItem.getProductId())){
				g = goodsMap.get(goodsItem.getProductId());
			}else{
				parmMap.put("goodsId", goodsItem.getProductId());
				g = goodsMapper.gainGoodsByPrm(parmMap);
			}
		}else{
			parmMap.put("goodsId", goodsItem.getProductId());
			g = goodsMapper.gainGoodsByPrm(parmMap);
		}

		if (null == isOneBuy || "".equals(isOneBuy) || "1".equals(isOneBuy)) {//单独购买
			payItemPrice = new BigDecimal(goodsItem.getPrice()).multiply(g.getSaleRate()).setScale(2,BigDecimal.ROUND_HALF_UP);
		} else {
			if ("1".equals(g.getIsGroup()) || "1".equals(g.getIsFlashSale())) {
				isActivity = "1";
				payItemPrice = new BigDecimal(goodsItem.getPrice()).multiply(g.getSaleRate()).multiply(g.getActivityPrice()).setScale(2,BigDecimal.ROUND_HALF_UP);
			} else {
				payItemPrice = new BigDecimal(goodsItem.getPrice()).multiply(g.getSaleRate()).setScale(2,BigDecimal.ROUND_HALF_UP);
			}
		}
		dealItemPrice = payItemPrice;
		payItemPrice = payItemPrice.multiply(new BigDecimal(nowBuyNum)).setScale(2,BigDecimal.ROUND_HALF_UP);
		payItemDlmPrice = payItemPrice.multiply(g.getDlmRate()).setScale(2,BigDecimal.ROUND_HALF_UP);
		payItemDocPrice = payItemPrice.multiply(g.getDocRate()).setScale(2,BigDecimal.ROUND_HALF_UP);
		OrderItem orderItem = new OrderItem();
		orderItem.setId(ToolsUtil.getUUID());
		orderItem.setOrderId(orderId);
		orderItem.setGoodsId(g.getId());
		orderItem.setGoodsItemId(goodsItem.getId());
		orderItem.setGoodsName(g.getName());
		orderItem.setGoodsEnName(g.getEnName());
		orderItem.setMarketbalePrice(new BigDecimal(goodsItem.getPrice()));
		orderItem.setNums(nowBuyNum);
		orderItem.setDealPrice(dealItemPrice);
		orderItem.setCountryId(countryId);
		orderItem.setCountryBili(g.getSaleRate());
		orderItem.setAmount(payItemPrice);
		orderItem.setDlmBili(g.getDlmRate());
		orderItem.setDocBili(g.getDocRate());
		orderItem.setDlmPrice(payItemDlmPrice);
		orderItem.setDocPrice(payItemDocPrice);
		orderItem.setCompanyId(g.getCompanyId());// 该商品所属商家的ID
		orderItem.setItemSku(goodsItem.getSkuJsonHz());
		orderItem.setPoint(payItemPrice.multiply(g.getFanxian()).setScale(2,BigDecimal.ROUND_HALF_UP));//该商品所获得的心动值
		orderItem.setPointBili(g.getFanxian());
		orderItem.setSaleActiveId(isActivity);
		orderItem.setSaleActiveReduceMoney(g.getActivityPrice());
		return orderItem;
	}
	@Override
	public Order addOrderCh(ReceiveAddress receiveAddress, String[] goodsIds, SessionInfo sessionInfo, String logistics,
							String payment, String billType, String billHead, String billContent, String remark) {
		Order order = new Order();
		Double totalCost = 0.00;
		String zoneType="";
		/*
		 * 根据收货表Id查询收货人的信息
		 */
		receiveAddress = receiveAddressMapper.selectByPrimaryKey(receiveAddress.getId());
		/*
		 * 商品ID，查询商品信息
		 */
		// 查询购物车中的单品?
		List<Cart> carts = cartMapper.gainCartsByIds(Arrays.asList(goodsIds));

		String companyId = "";
		String dealName = "";
		for (Cart cart : carts) {
			String goodsId = cart.getGoodsId();
			String goodsItemId = cart.getItemId();
			Goods goods = goodsMapper.gainGoodsById(goodsId);
			if ("".equals(zoneType)) {
				zoneType = goods.getGoodstype();
			}
			GoodsItem gi = goodsItemMapper.selectByPrimaryKey(goodsItemId);
			totalCost = totalCost + cart.getGoodsNum() * (gi.getPrice() * 10000) / 10000;
			dealName = goods.getName() + "," + dealName;
			companyId = goods.getCompanyId();
		}
		totalCost = totalCost * sessionInfo.getZhekou();
		String orderId = ToolsUtil.getUUID();
		order = createOrderSh(sessionInfo, totalCost, receiveAddress, orderId, logistics, payment, billType, billHead,
				billContent, companyId, remark,zoneType);// 创建订单
		List<OrderItem> orderItems = createOrderItems(orderId, carts);// 创建订单详情
//		Company company = companyMapper.gainCompanyMessageById(sessionInfo.getUserId());
//		company.setGuaranteePrice(company.getGuaranteePrice() - totalCost);

		/*
		 * 将订单、订单详情存入数据库中
		 */
		orderMapper.insertSelectiveCh(order);
		orderItemMapper.batchInsert(orderItems);
//		companyMapper.updateByPrimaryKeySelective(company);

		/*
		 * 提交完订单应清除对应购物车里面的商品
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item", Arrays.asList(goodsIds));
		map.put("userId", sessionInfo.getUserId());
		cartMapper.deleteByGoodeIds(map);
		return order;
	}

	private Order createOrderSh(SessionInfo sessionInfo, Double totalCost, ReceiveAddress receiveAddress,
								String orderId, String logistics, String payment, String billType, String billHead, String billContent,
								String companyId, String remark,String zoneType) {
		/*
		 * 将商品放入订单中
		 */
		Order order = new Order();
		order.setId(orderId);
		order.setMemberId(sessionInfo.getUserId());
		order.setMemberType(sessionInfo.getUserType());
		order.setCreatetime(new Date());
		order.setPayTime(new Date());

		order.setHkType("0");// 0未还款 1 已还款
		order.setZoneType(zoneType);
		order.setSourceType("0");// 0-网上订的，1-手机订的，2-电话订的
		order.setStatus("0");// 0-未审核，1-已审核，2-取消，3-无效
		order.setPayStatus("1");// 0-未支付，1-已付款，2-待退款，3-已退款
		order.setShipStatus("0");// 0-未发货，1-已发货，2-已收货，3-待退货，4-已退货
		order.setKeshStatus("0");// 0-未客审，1-已客审
		order.setIsDelivery(logistics);// N-不需要自提，Y-需要自提
		order.setPayMent(payment);// 0-网上支付，1- 预存款支付
		order.setTotalCost(new BigDecimal(totalCost));// 商品总价格
		order.setOrderPoints(new BigDecimal(totalCost));// 该单获取商城经验值
		order.setCompanyId(companyId);// 商家的ID
		order.setOrderNum(OrderUtil.getOrderId());// 根据日期生成订单编号
		// 下面关于收货信息
		order.setShipName(receiveAddress.getReceiveName());// 收货人姓名
		if (null != receiveAddress.getMobile()) {
			order.setShipTel(receiveAddress.getMobile());// 收货人电话
		} else {
			order.setShipTel(receiveAddress.getTelephone());// 收货人电话
		}

		order.setShipZip(receiveAddress.getZip() + "");// 邮编
		order.setProvince(receiveAddress.getProvince());// 省
		order.setCity(receiveAddress.getCity()); // 市
		order.setArea(receiveAddress.getArea());// 区
		order.setAddress(receiveAddress.getReceiveAddress());// 详细地址

		// 发票信息
		order.setBillType(billType);
		order.setBillHead(billHead);
		order.setBillContent(billContent);
		order.setOrderType("1");
		return order;

	}

	/**
	 * 生成ORDER
	 *
	 * @Title: careOrder
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param
	 *            sessionInfo
	 * @param @param
	 *            totalCost
	 * @param @param
	 *            receiveAddress
	 * @param @return    设定文件
	 * @return Order    返回类型
	 * @author 周张豹
	 */
	private Order createOrder(SessionInfo sessionInfo, Double wuliuTotalCost,Double proTotalCost,Double totalCost, ReceiveAddress receiveAddress, String orderId,
							  String logistics, String payment, String billType, String billHead, String billContent, String companyId,
							  String remark, Double mailing,String zoneType) {
		/*
		 * 将商品放入订单中
		 */

		Order order = new Order();
		order.setId(orderId);
		order.setMemberId(sessionInfo.getUserId());
		order.setMemberType(sessionInfo.getUserType());
		order.setCreatetime(new Date());
		order.setSourceType("0");// 0-网上订的，1-手机订的，2-电话订的
		order.setStatus("0");// 0-未审核，1-已审核，2-取消，3-无效
		order.setPayStatus("0");// 0-未支付，1-已付款，2-待退款，3-已退款
		order.setShipStatus("0");// 0-未发货，1-已发货，2-已收货，3-待退货，4-已退货
		order.setKeshStatus("0");// 0-未客审，1-已客审
		order.setIsDelivery(logistics);// N-不需要自提，Y-需要自提
		order.setZoneType(zoneType);//哪个专区的订单
		order.setPayMent(payment);// 0-网上支付，1- 预存款支付
		order.setCostProtect(new BigDecimal(proTotalCost));//商品总价格
		order.setCarriage(new BigDecimal(wuliuTotalCost));//总物流费用
		order.setTotalCost(new BigDecimal(totalCost));// 订单总价格
		//order.setOrderPoints(totalCost);// 不送经验值了该单获取商城经验值
		order.setCompanyId(companyId);// 商家的ID
		order.setOrderNum(OrderUtil.getOrderId());// 根据日期生成订单编号
		// 下面关于收货信息
		order.setShipName(receiveAddress.getReceiveName());// 收货人姓名
		if (null != receiveAddress.getMobile()) {
			order.setShipTel(receiveAddress.getMobile());// 收货人电话
		} else {
			order.setShipTel(receiveAddress.getTelephone());// 收货人电话
		}
		order.setRemark(remark);
		order.setShipZip(receiveAddress.getZip() + "");// 邮编
		order.setProvince(receiveAddress.getProvince());// 省
		order.setCity(receiveAddress.getCity()); // 市
		order.setArea(receiveAddress.getArea());// 区
		order.setAddress(receiveAddress.getReceiveAddress());// 详细地址

		// 发票信息
		order.setBillType(billType);
		order.setBillHead(billHead);
		order.setBillContent(billContent);

		return order;
	}

	/**
	 * 生成ORDERITEMS
	 *
	 * @Title: createOrderItems
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return List<OrderItem>    返回类型
	 * @author 周张豹
	 */
	private List<OrderItem> createOrderItems(String orederId, List<Cart> list) {
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		OrderItem orderItem;

		for (Cart e : list) {
			String goodsId = e.getGoodsId();
			String goodsItemId = e.getItemId();
			Goods goods = goodsMapper.gainGoodsById(goodsId);
			GoodsItem gi = goodsItemMapper.selectByPrimaryKey(goodsItemId);
			orderItem = new OrderItem();
			orderItem.setId(ToolsUtil.getUUID());
			orderItem.setOrderId(orederId);
			orderItem.setGoodsId(e.getGoodsId());
			orderItem.setGoodsItemId(e.getItemId());
			orderItem.setGoodsName(goods.getName());
			orderItem.setMarketbalePrice(new BigDecimal(gi.getPrice()));
			orderItem.setNums(e.getGoodsNum());
			orderItem.setDealPrice(new BigDecimal(gi.getPrice()));
			orderItem.setAmount(new BigDecimal(gi.getPrice() * e.getGoodsNum()));
			orderItem.setCompanyId(goods.getCompanyId());// 该商品所属商家的ID
			orderItem.setItemSku(gi.getSkuJsonHz());
			orderItem.setPoint(new BigDecimal(e.getPoint()));	//该商品所使用的的经验值
			orderItems.add(orderItem);
		}
		return orderItems;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qlzy.memberCenter.call.service.MemberCallService#
	 * updateCartNumByGoodsId(com.qlzy.model.Cart)
	 */
	@Override
	public void updateCartNumByGoodsId(Cart cart) {
		cartMapper.updateCartNumByGoodsId(cart);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#gainReceiveAddresses
	 * (java.lang.String)
	 */
	@Override
	public List<ReceiveAddress> gainReceiveAddresses(String userId) {
		return receiveAddressMapper.gainReceiveAddresses(userId);
	}
	@Override
	public List<ReceiveAddress> gainReceiveAddressesList(String userId) {
		return receiveAddressMapper.gainReceiveAddressesList(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qlzy.memberCenter.call.service.MemberCallService#
	 * gainReceiveAddressById(java.lang.String)
	 */
	@Override
	public ReceiveAddress gainReceiveAddressById(String id) {
		return receiveAddressMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#updateReceiveAddress
	 * (com.qlzy.model.ReceiveAddress)
	 */
	@Override
	public void updateReceiveAddress(ReceiveAddress receiveAddr) {
		receiveAddressMapper.updateByPrimaryKeySelective(receiveAddr);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#addReceiveAddress(
	 * com.qlzy.model.ReceiveAddress)
	 */
	@Override
	public int addReceiveAddress(ReceiveAddress receiveAddr) {
		int i;
		if ("true".equals(receiveAddr.getIsDefault())) {
			receiveAddressMapper.cancelDefaultAddrkByUserId(receiveAddr);// 取消用户的默认收货地址
		}
		//有id 走update
		if(receiveAddr.getId() != null && !"".equals(receiveAddr.getId())){
			i = receiveAddressMapper.updateByPrimaryKeySelective(receiveAddr);
		}else{
			receiveAddr.setId(ToolsUtil.getUUID());
			i = receiveAddressMapper.insertSelective(receiveAddr);
		}
		return i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#gainCartNumByUserId(
	 * java.lang.String)
	 */
	@Override
	public Integer gainCartNumByUserId(String userId) {
		Integer num = cartMapper.selectCartNumByUserId(userId);
		if (num == null) {
			return 0;
		} else {
			return num;
		}
	}
	@Override
	public Integer gainCartNumByParm(Map<String,Object> parmMap) {
		Integer num = cartMapper.gainCartNumByParm(parmMap);
		if (num == null) {
			return 0;
		} else {
			return num;
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#gainCartNumByCookie(
	 * javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public Integer gainCartNumByCookie(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return CookieUtils.getCookieCartNum(request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#addCartByNowBuy(com.
	 * qlzy.pojo.SessionInfo, java.lang.String, java.lang.Integer)
	 */
	@Override
	public void addCartByNowBuy(SessionInfo sessionInfo, String itemId, Integer num) {
		Cart cart = new Cart();
		// 查询单品
		GoodsItem goodsItem = goodsItemMapper.selectByPrimaryKey(itemId);
		// 商品ID
		String productId = goodsItem.getProductId();
		cart.setUserId(sessionInfo.getUserId());
		cart.setItemId(itemId);
		cart.setGoodsId(productId);
		cart = cartMapper.selectGoodsNumInCartByGoodsId(cart);
		if (cart != null && cart.getGoodsNum() != null) {
			cart.setGoodsNum(num);
			cartMapper.updateByPrimaryKey(cart);
		} else {
			cart = new Cart();
			cart.setId(ToolsUtil.getUUID());
			cart.setUserId(sessionInfo.getUserId());
			cart.setGoodsId(productId);
			cart.setItemId(itemId);
			cart.setCreateIp(sessionInfo.getIp());
			cart.setCreateTime(new Date());
			cart.setGoodsNum(num);
			cart.setUserType(sessionInfo.getUserType());
			cartMapper.insert(cart);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#memberDefaultAddr(
	 * com.qlzy.pojo.SessionInfo, com.qlzy.model.ReceiveAddress)
	 */
	@Override
	public void memberDefaultAddr(ReceiveAddress receiveAddr) {
		receiveAddressMapper.cancelDefaultAddrkByUserId(receiveAddr);// 取消用户的默认收货地址
		receiveAddr.setIsDefault("true");
		receiveAddressMapper.updateByPrimaryKeySelective(receiveAddr);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#delMemberAddr(com.
	 * qlzy.model.ReceiveAddress)
	 */
	@Override
	public void delMemberAddr(ReceiveAddress receiveAddr) {
		receiveAddressMapper.deleteByPrimaryKey(receiveAddr.getId());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qlzy.memberCenter.call.service.MemberCallService#
	 * selectCollectByGoodsId(java.lang.String)
	 */
	@Override
	public Integer selectCollectByCollectId(String collectId) {
		return memberCollectMapper.selectCollectByCollectId(collectId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qlzy.memberCenter.call.service.MemberCallService#
	 * gainBuyRecordByGoodsId(java.lang.String)
	 */
	@Override
	public List<OrderItem> gainBuyRecordByGoodsId(String goodsId) {
		List<OrderItem> item = orderItemMapper.selectBuyRecordByGoodsId(goodsId);
		for (OrderItem ot : item) {
			try {
				String times = ot.getCreatetime().substring(0, ot.getCreatetime().length() - 2);
				ot.setCreatetime(times);
			} catch (Exception e) {
				ot.setCreatetime("--");
			}
		}
		return item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qlzy.memberCenter.call.service.MemberCallService#
	 * gainApprakiseByGoodsId(java.lang.String)
	 */
	@Override
	public List<Appraise> gainApprakiseByGoodsId(String goodsId) {
		return appraiseMapper.gainAllByGoodsId(goodsId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qlzy.memberCenter.call.service.MemberCallService#
	 * gainTransactionNumByGoodsId(java.lang.String)
	 */
	@Override
	public Integer gainTransactionNumByGoodsId(String goodsId) {
		return orderMapper.selectTransactionNumByGoodsId(goodsId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#delCartByGoodsId(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void   delCartByGoodsId(List<String> goodsIds, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("item", goodsIds);
		cartMapper.deleteByGoodeIds(map);

	}
	@Override
	public void clearByUserId(String userId) {
		cartMapper.deleteByUserId(userId);

	}

	@Override
	public Map<String,Double> getMailing() {
		Map<String,Double> mailMap  = new HashMap<>();
		List<QlDict> qlDicts = qlDictMapper.selectByType("member_mail");
		for(QlDict qlDict:qlDicts){
			if("mailMax".equals(qlDict.getLabel())){
				mailMap.put("mailMax",Double.parseDouble(qlDict.getValue()));
			}
			if("mail".equals(qlDict.getLabel())){
				mailMap.put("mail",Double.parseDouble(qlDict.getValue()));
			}
		}
		return mailMap;
	}

	/****
	 * 注册用户
	 * @param member
	 */
	@Override
	public String addMember(Member member) {
		String random = CodeUtils.createRandom(true, 6);
		//查看这个id是否已经存在了，存在重新生成一个
		List<Member> members = membersMapper.getMemberListByOnlyId(random);
		if(null != members && members.size() > 0){
			while(true){
				random = CodeUtils.createRandom(true, 6);
				members = membersMapper.getMemberListByOnlyId(random);
				if(null != members && members.size() > 0){
					break;
				}
			}
		}
		member.setId(ToolsUtil.getUUID());
		member.setOnlyId(random);
		member.setRegTime(new Date());
		member.setPassword(MD5.encrypt(member.getPassword()));
		membersMapper.insertSelective(member);
		return random;
	}

	/***
	 * 通过onlyId查询该用户存在么
	 * @param shangjiId
	 * @return
	 */
	@Override
	public List<Member> gainMemberByShangjiId(String shangjiId) {
		return membersMapper.gainMemberByShangjiId(shangjiId);
	}

	@Override
	public Member getMemberListByOnlyId(String onlyId) {
		List<Member> members = membersMapper.getMemberListByOnlyId(onlyId);
		if(null != members && members.size() > 0){
			return members.get(0);
		}else{
			return null;
		}

	}

	@Override
	public Member gainMemberListByMap(Map<String, String> parmMap) {
		List<Member> members = membersMapper.gainMemberListByMap(parmMap);
		if(null != members && members.size() > 0){
			return members.get(0);
		}else{
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#gainPayDealByDealId(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public PayDeal gainPayDealByDealId(String dealId, String type) {
		PayDeal payDeal = new PayDeal();
		payDeal.setDealId(dealId);
		payDeal.setType(type);
		return payDealMapper.selectByDealId(payDeal);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#lhCreateOrder(com.
	 * qlzy.model.PayDeal)
	 */
	@Override
	public void lhCreateOrder(PayDeal payDeal, Order order) {
		payDealMapper.insertSelective(payDeal);
		orderMapper.updateByPrimaryKeySelective(order);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#lhDealPayNotify(com.
	 * qlzy.model.Order, com.qlzy.model.PayDeal)
	 */
	@Override
	public void lhDealPayNotify(Order order, PayDeal payDeal) {
		orderMapper.updateByPrimaryKeySelective(order);
		payDealMapper.updateByPrimaryKeySelective(payDeal);

	}

	@Override
	public void lhDealPayNotifyLjhk(Order order, PayDeal payDeal) {
//		Company company = companyMapper.gainCompanyMessageById(order.getMemberId());
//		BigDecimal b1 = new BigDecimal(company.getGuaranteePrice().toString());
//		BigDecimal b2 = new BigDecimal(order.getTotalCost().toString());
//		company.setGuaranteePrice(b1.add(b2).doubleValue());
//		companyMapper.updateByPrimaryKeySelective(company);
		orderMapper.updateByPrimaryKeySelective(order);
		payDealMapper.updateByPrimaryKeySelective(payDeal);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#updatePayDeal(com.
	 * qlzy.model.PayDeal)
	 */
	@Override
	public void updatePayDeal(PayDeal payDeal, Order order) {
		payDealMapper.updateByPrimaryKeySelective(payDeal);
		orderMapper.updateByPrimaryKeySelective(order);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.call.service.MemberCallService#gainlhPayByOrderId(
	 * java.lang.String)
	 */
	@Override
	public LhPayPojo gainlhPayByOrderId(String id) {
		Order order = orderMapper.selectByPrimaryKey(id);
		LhPayPojo pojo = new LhPayPojo();
		if (order != null) {
			pojo.setMerId(ResourceUtil.getLhMerId());
			pojo.setDealOrder(order.getOrderNum());
			pojo.setDealFee(order.getTotalCost() + "");
			pojo.setDealReturn(ResourceUtil.getLhDealReturn());
			pojo.setDealNotify(ResourceUtil.getLhDealNotify());
			pojo.setDealSignure(OrderUtil.getSignature(pojo));
		}
		return pojo;
	}

	@Override
	public LhPayPojo gainlhPayByOrderIdLjhk(String id) {
		Order order = orderMapper.selectByPrimaryKey(id);
		LhPayPojo pojo = new LhPayPojo();
		if (order != null) {
			pojo.setMerId(ResourceUtil.getLhMerId());
			pojo.setDealOrder(order.getOrderNum());
			pojo.setDealFee(order.getTotalCost() + "");
			pojo.setDealReturn(ResourceUtil.getLhDealReturn());
			pojo.setDealNotify(ResourceUtil.LhDealNotifyljhk());
			pojo.setDealSignure(OrderUtil.getSignature(pojo));
		}
		return pojo;
	}

	@Override
	public PayDeal selectByOrderNum(String dealOrder) {
		// TODO Auto-generated method stub
		return payDealMapper.selectByOrderNum(dealOrder);
	}

	@Override
	public void updatePayDealPrice(PayDeal payDeal) {
		// TODO Auto-generated method stub
		payDealMapper.updateByPrimaryKeySelective(payDeal);
	}

	@Override
	public Double gainCompanyGuaranteePriceByCompanyId(String id) {
		// TODO Auto-generated method stub
//		return companyMapper.gainCompanyGuaranteePriceByCompanyId(id);
		return null;
	}

	@Override
	public List<Goods> gainGoodsByTypeList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodsMapper.gainGoodsByTypeList(map);
	}

	@Override
	public Long gainGoodsByTypeListcount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodsMapper.gainGoodsByTypeListcount(map);
	}

//	@Override
//	public void addClickNum(String id) {
//		Goods goods = new Goods();
//		goods = goodsMapper.gainGoodsById(id);
//		goods.setClickNumber(goods.getClickNumber() + 1);
//		goodsMapper.updateByPrimaryKeySelective(goods);
//	}

	@Override
	public TradePayDeail gainPayDeailPoByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return tradePayDeailMapper.gainPayDeailPoByOrderId(orderId);
	}

	@Override
	public TradePayDeail dealAliPay(String orderId) {
		TradePayDeail trade = this.gainPayDeailPoByOrderId(orderId);
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(order!=null && !"1".equals(order.getPayStatus())) {
			double totalPrice = trade.getTotalPrice();
			totalPrice -= paymentService.payByPoint(order.getId(), order.getMemberId());
			trade.setTotalPrice(totalPrice);
		}
		return trade;
	}

	@Override
	public Member gainMember(String userId) {
		// TODO Auto-generated method stub
		return membersMapper.selectByPrimaryKey(userId);
	}

//	@Override
//	public Double getMailing() {
//		// TODO Auto-generated method stub
//		String vString = "";
//		try {
//			vString = dictionaryMapper.selectByKey("mail");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return Double.valueOf(vString);
//	}

//	@Override
//	public Double getMailMax() {
//		String vString = "";
//		try {
//			vString = dictionaryMapper.selectByKey("mailMax");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return Double.valueOf(vString);
//	}

	@Override
	public List<Cart> gainCartsByUserId(String userId) {
		// TODO Auto-generated method stub
		List<Cart> list = cartMapper.selectCartsByUserId(userId);
		return list;
	}
	@Override
	public List<Cart> selectCartsByUserIdAndAd(Map<String,Object> parm) {
		// TODO Auto-generated method stub
		List<Cart> list = cartMapper.selectCartsByUserIdAndAd(parm);
		return list;
	}


	@Override
	public List<Cart> gainCartsByIds(List<String> asList, SessionInfo sessionInfo) {
		List<Cart> list = cartMapper.gainCartsByIds(asList);
		return list;
	}

	@Override
	public TradePayDeail gainPObyOrderNum(String orderNum) {
		// TODO Auto-generated method stub
		return tradePayDeailMapper.gainPObyOrderNum(orderNum);
	}

	@Override
	public void updateTradePayDeail(TradePayDeail tradeDeail) {
		// TODO Auto-generated method stub
		tradePayDeailMapper.updateBySelective(tradeDeail);
	}

	@Override
	public double getPoint(String[] payCartsIds) {
		return 0;
	}
}
