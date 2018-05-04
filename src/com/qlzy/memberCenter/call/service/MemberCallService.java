/**  
 * @Title: MemberCallService.java
 * @Package com.qlzy.memberCenter.call.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 周张豹  
 * @date 2013-6-5 上午10:05:28
 * @version V1.0  
 */
package com.qlzy.memberCenter.call.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qlzy.model.*;
import com.qlzy.pojo.LhPayPojo;
import com.qlzy.pojo.SessionInfo;

/**
 * @ClassName: MemberCallService
 * @Description: TODO(会员点击事件处理)
 * @author 周张豹
 * @date 2013-6-5 上午10:05:28
 */
public interface MemberCallService {

	/**
	 * 根据id查询银行卡信息
	 * @param id
	 * @return
	 */
	public Bankcard gainBankcardByPrimaryKey(String id);


	/**
	 * 根据id删除银行卡信息
	 * @param id
	 * @return
	 */
	public int delBankcardByPrimaryKey(String id);

	/**
	 * 添加或编辑银行卡
	 * @param bankcard
	 * @return
	 */
	public int addBanckcard(Bankcard bankcard);

	/**
	 * 根据memberId查询银行卡信息
	 * @param memberId
	 */
	public List<Bankcard> gainBanckcard(String memberId);

	/**
	 * 添加收藏操作
	 * @Title: memberCollect
	 * @Description: TODO(会员收藏操作)
	 * @param @param collect    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void addCollect(MemberCollect collect);

	/**
	 * 根据userId和type查询收藏商品
	 * @param memberCollect
	 * @return
	 */
	List<MemberCollect> gainGoodsCollect(MemberCollect memberCollect);
	/**
	 *根据userId和type查询收藏店铺
	 * @param memberCollect
	 * @return
	 */
	List<MemberCollect> gainShopCollect(MemberCollect memberCollect);

	/**
	 * 取消收藏
	 * @param id
	 * @return
	 */
	public int delCollect(String id);

	/**
	 *  根据商品的ID或者文章ID查询被收藏的总数
	 * @Title: selectCollectByGoodsId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param goodsId
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @author 周张豹
	 */
	public Integer selectCollectByCollectId(String collectId);

	/**
	 * 添加购物车
	 * @Title: addCart
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void addCart(Cart cart);

	/**
	 * @Title: gainCartByUserId
	 * @Description: TODO(根据用户ID获取购物车信息)
	 * @param @param userId
	 * @param @return    设定文件
	 * @return List<Goods>    返回类型
	 * @author 周张豹
	 */
	public List<Goods> gainCartByUserId(String userId);

	/**
	 * 根据商品ID查询购物车信息
	 * @Title: gainCartByGoodsIds
	 * @Description: TODO(获取购物车信息)
	 * @param @param object
	 * @param @return    设定文件
	 * @return List<Goods>    返回类型
	 * @author 周张豹
	 */
//	public List<Goods> gainCartByGoodsIds(List<String> goodsIds,SessionInfo sessionInfo);

	/**
	 *  根据商品的ID获取该商品在购物车中的信息
	 * @Title: gainGoodsNumInCartByGoodsID
	 * @Description: TODO(根据商品的ID获取该商品在购物车中的信息)
	 * @param goodsId
	 * @param     设定文件
	 * @return Integer    返回类型
	 * @author 周张豹
	 */
	public Cart gainGoodsByGoodsId(String userId , String goodsId);

	/**
	 * 当用户登录时将cookie中的商品信息放入购物车中
	 * @Title: updateCartByCookie
	 * @Description: TODO(用户登录时更新购物车信息)
	 * @param @param sessionInfo    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void updateCartByCookie(HttpServletResponse response,HttpServletRequest request , SessionInfo sessionInfo);

	/**
	 * 在用户没有登录下获取Cookie中购物车的信息
	 * @Title: gainCartByCookie
	 * @Description: TODO(获取购物车中商品的信息)
	 * @param @param request
	 * @param @param sessionInfo
	 * @param @return    设定文件
	 * @return List<Goods>    返回类型
	 * @author 周张豹
	 */
//	public List<Goods> gainCartByCookie(HttpServletRequest request );

	/**
	 *   更新购物车信息
	 * @Title: updateCart
	 * @Description: TODO(更新购物车)
	 * @param @param cart    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void updateCart(Cart cart);

	/**
	 *  根据用户ID查询该用户的默认收货地址 <br> 如果用户存在收货地址，但是没有默认收货地址，返回已存在的一个收货地址
	 * @Title: gainReceiveAddressDefault
	 * @Description: TODO(根据用户ID查询该用户的默认收货地址)
	 * @param @param userId
	 * @param @return    设定文件
	 * @return ReceiveAddress    返回类型
	 * @author 周张豹
	 */
	public ReceiveAddress gainReceiveAddressDefault(String userId);

	/**
	 * 添加订单<br>需要参数：收货表中的ID，需要购物的商品ID,物流方式，支付方式,发票类型，发票抬头，发票内容
	 * @Title: addOrder
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param receiveAddress
	 * @param @param goodsIds    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
//	public TradePayDeail addOrder(ReceiveAddress receiveAddress, String[] goodsIds,SessionInfo sessionInfo,String logistics,String payment,
//			String billType,String billHead,String billContent,String remark,Double mailing, String[] payCartsIds);

	/**
	 * 根据用户ID和商品ID更新购物车的数量
	 * @Title: updateCartNumByGoodsId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param cart    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void updateCartNumByGoodsId(Cart cart);

	/**
	 * 查询用户的收货地址
	 * @Title: gainReceiveAddresses
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param userId
	 * @param @return    设定文件
	 * @return List<ReceiveAddress>    返回类型
	 * @author 周张豹
	 */
	public List<ReceiveAddress> gainReceiveAddresses(String userId);

	/**
	 * @Title: gainReceiveAddressById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ReceiveAddress    返回类型
	 * @author 周张豹
	 */
	public ReceiveAddress gainReceiveAddressById(String id);

	/**
	 * 根据ID更新收货地址
	 * @Title: updateReceiveAddress
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param receiveAddr    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void updateReceiveAddress(ReceiveAddress receiveAddr);


	/**
	 * 添加收货地址
	 * @Title: addReceiveAddress
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param receiveAddr    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public int addReceiveAddress(ReceiveAddress receiveAddr);

	/**
	 * 数据库中购物车里商品的数量
	 * @Title: gainCartNumByUserId
	 * @Description: TODO( 数据库中购物车里商品的数量)
	 * @param @param userId
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @author 周张豹
	 */
	public Integer gainCartNumByUserId(String userId);

	/**
	 * Cookie中购物车商品的数量
	 * @Title: gainCartNumByCookie
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param request
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @author 周张豹
	 */
	public Integer gainCartNumByCookie(HttpServletRequest request);


	/**
	 * 把用户立即购买的商品放入到购物车中<br>如果该用户的购物车存在该商品，则更新现在的数量
	 * @Title: addCartByNowBuy
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param sessionInfo
	 * @param @param goodsId
	 * @param @param num    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void addCartByNowBuy(SessionInfo sessionInfo, String goodsId, Integer num);

	/**
	 * @Title: memberDefaultAddr
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param sessionInfo
	 * @param @param receiveAddr    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void memberDefaultAddr(ReceiveAddress receiveAddr);

	/**
	 * 删除的收货地址（根据ID）
	 * @Title: delMemberAddr
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param receiveAddr    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void delMemberAddr(ReceiveAddress receiveAddr);

	/**
	 * @Title: gainBuyRecordByGoodsId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param goodsId
	 * @param @return    设定文件
	 * @return Object    返回类型
	 * @author 周张豹
	 */
	public List<OrderItem> gainBuyRecordByGoodsId(String goodsId);

	/**
	 * 根据商品ID查询商品的评价内容
	 * @Title: gainApprakiseByGoodsId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param goodsId
	 * @param @return    设定文件
	 * @return Object    返回类型
	 * @author 周张豹
	 */
	public List<Appraise> gainApprakiseByGoodsId(String goodsId);

	/**
	 * 根据商品ID查询商品的成交量
	 * @Title: gainTransactionNumByGoodsId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param goodsId
	 * @param @return    设定文件
	 * @return Object    返回类型
	 * @author 周张豹
	 */
	public Integer gainTransactionNumByGoodsId(String goodsId);

	/**
	 * 删除购物车中的商品
	 * @Title: delCartByGoodsId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void delCartByGoodsId(List<String> goodsIds,String userId);

	/**
	 * 根据银行支付的序列号查询数据库已经存在的信息
	 * @Title: gainPayDealByDealId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param dealId
	 * @param @return    设定文件
	 * @return payDeal    返回类型
	 * @author 周张豹
	 */
	public PayDeal gainPayDealByDealId(String dealId,String type);
	/***
	 *
	 修改价格
	 * @Title: selectByOrderNum

	 * @Description: TODO(这里用一句话描述这个方法的作用)

	 * @param @param dealOrder
	 * @param @return    设定文件

	 * @return PayDeal    返回类型

	 * @throws
	 */
	public PayDeal selectByOrderNum(String dealOrder);
	/**
	 * 支付银行创建订单通知<br>
	 *  更新订单、插入PayDeal 实体
	 * @Title: lhCreateOrder
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param payDeal    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void lhCreateOrder(PayDeal payDeal,Order order);

	/**
	 * 买家支付通知处理<br>
	 * 更新穿过来的两个实体类
	 * @Title: lhDealPayNotify
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param order
	 * @param @param payDeal    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void lhDealPayNotify(Order order, PayDeal payDeal);

	/**
	 * 更新支付银行通知的状态
	 * @Title: updatePayDeal
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param payDeal    设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void updatePayDeal(PayDeal payDeal,Order order);
	public void updatePayDealPrice(PayDeal payDeal);
	/**
	 * 根据订单ID查询订单信息并转化为支付所需要的实体类
	 * @Title: gainlhPayByOrderId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @return    设定文件
	 * @return LhPayPojo    返回类型
	 * @author 周张豹
	 */
	public LhPayPojo gainlhPayByOrderId(String id);

	public Double gainCompanyGuaranteePriceByCompanyId(String id);

	public Order addOrderCh(ReceiveAddress receiveAddr, String[] goodsIds,
							SessionInfo sessionInfo, String logistics, String payment,
							String billType, String billHead, String billContent,String remark);

	LhPayPojo gainlhPayByOrderIdLjhk(String id);

	void lhDealPayNotifyLjhk(Order order, PayDeal payDeal);


	public List<Goods> gainGoodsByTypeList(Map<String, Object> map);

	public Long gainGoodsByTypeListcount(Map<String, Object> map);

//	public void addClickNum(String id);

	public TradePayDeail gainPayDeailPoByOrderId(String orderId);

	public TradePayDeail dealAliPay(String orderId);

	public Member gainMember(String userId);


	/**
	 * 根据单品ID获取商品
	 * @param userId
	 * @param itemId
	 * @return
	 */
	Cart gainGoodsByItemId(String userId, String itemId);

	/**
	 * 根据用户ID获取单品列表
	 * @param userId
	 * @return
	 */
	public List<Cart> gainCartsByUserId(String userId);
	//
	public List<Cart> gainCartsByIds(List<String> asList, SessionInfo sessionInfo);

	public TradePayDeail gainPObyOrderNum(String orderNum);

	public void updateTradePayDeail(TradePayDeail tradeDeail);

	public double getPoint(String[] payCartsIds);

	/**
	 * @Title: clearByUserId
	 * @Description:
	 * @date 2017-1-12 上午11:31:10 
	 * @param @param userId 设定文件
	 * @return void 返回类型
	 * @throws
	 * @version V1.0
	 */
	public void clearByUserId(String userId);

	Map<String,Double> getMailing();

	String addMember(Member member);

	List<Member> gainMemberByShangjiId(String shangjiId);

	Member getMemberListByOnlyId(String shangjiId);

	Member gainMemberListByMap(Map<String, String> parmMap);

	Map<String,Company> gainCartByCookie(HttpServletRequest request,Map<String,Object> parmMap,Map<String,Company> comMap);
}
