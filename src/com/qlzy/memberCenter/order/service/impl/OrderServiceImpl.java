/**  
 * @Title: OrderServiceImpl.java
 * @Package com.qlzy.memberCenter.order.service.impl
 * @Description:
 * @author 周张豹  
 * @date 2013-9-23 上午11:27:37
 * @version V1.0  
 */
package com.qlzy.memberCenter.order.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.qlzy.mainPage.indexGoods.dao.QlDictMapper;
import com.qlzy.memberCenter.person.moneyManage.dao.AdvanceLogsMapper;
import com.qlzy.model.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.qlzy.common.tools.Arith;
import com.qlzy.common.tools.HttpRequestProxy;
import com.qlzy.common.tools.OrderUtil;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.indexGoods.dao.GoodsMapper;
import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.memberCenter.call.dao.TradePayDeailMapper;
import com.qlzy.memberCenter.common.dao.AppraiseMapper;
import com.qlzy.memberCenter.order.dao.OrderItemMapper;
import com.qlzy.memberCenter.order.dao.OrderMapper;
import com.qlzy.memberCenter.order.dao.OrderReturnMapper;
import com.qlzy.memberCenter.order.service.OrderService;
import com.qlzy.memberCenter.person.perinfo.dao.JiesuanItemMapper;
import com.qlzy.memberCenter.person.perinfo.dao.MemeberDeailMapper;
import com.qlzy.memberCenter.person.perinfo.dao.XianjinbiDetailMapper;
import com.qlzy.payment.service.IPaymentService;
import com.qlzy.pojo.DeliverPojo;
import com.qlzy.task.model.CashBackTask;
import com.qlzy.task.service.ITaskService;

@Transactional(rollbackFor = Exception.class)
@Service("orderService")
/**
 * @ClassName: OrderServiceImpl
 * @Description: 
 * @author 周张豹
 * @date 2013-9-23 上午11:27:37
 */
public class OrderServiceImpl implements OrderService {
	private static final Logger logger = Logger.getLogger(OrderServiceImpl.class);
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private OrderItemMapper orderItemMapper;
	@Resource
	private OrderReturnMapper orderReturnMapper;
	@Resource
	private GoodsMapper goodsMapper;
//	@Resource
//	private GoodsPicMapper goodsPicMapper;
	@Resource
	private AppraiseMapper appraiseMapper;
	@Resource
	private TradePayDeailMapper tradePayDeailMapper;
	@Resource
	private MemberMapper membersMapper;
	@Resource
	private JiesuanItemMapper jiesuanItemMapper;
	@Resource
	private XianjinbiDetailMapper xianjinbiDetailMapper;
	@Resource
	private MemeberDeailMapper memeberDeailMapper;
	@Resource
	private ITaskService taskService;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private QlDictMapper dictMapper;
	@Autowired
	private AdvanceLogsMapper advanceLogsMapper;


	@Override
	public Order gainPercentageById(Map map){
		return orderMapper.getPercentageById(map);
	}


	/**
	 * 获得预计提成列表
	 * @return
	 */
	@Override
	public List<Order> gainYujitichengList(Map<String,Object> map) {
		return orderMapper.gainYujitichengList(map);
	}



	public List<OrderItem> gainByOrderId(OrderItem item){
		return orderItemMapper.gainByOrderId(item);
	}




	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.order.service.OrderService#gainOrdersByUserIdGetLong
	 * (java.util.Map)
	 */

	@Override
	public Long gainOrdersByUserIdGetLong(Map<String, Object> map) {
		return orderMapper.gainOrdersByUserIdGetLong(map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.order.service.OrderService#gainOrdersByUserIdGetList
	 * (java.util.Map)
	 */
	@Override
	public List<Order> gainOrdersByUserIdGetList(Map<String, Object> map) {
		List<Order> orderList = orderMapper.gainOrdersByUserIdGetList(map);
		List<Order> orderListNew = new ArrayList<Order>();
		if (null != orderList && orderList.size() > 0) {
			for (int n= 0;n<orderList.size();n++) {
				int count = 0;
				Order order = orderList.get(n);
				OrderItem item = new OrderItem();
				item.setOrderId(order.getId());
				item.setGoodsName((String)map.get("goodsName"));
				List<OrderItem> items = orderItemMapper.gainByOrderId(item);
				if(null != items &&items.size() > 0){
					List<OrderItem> itemsList = new ArrayList<OrderItem>();
						for (OrderItem i : items) {
							Goods goods = goodsMapper.gainGoodsById(i.getGoodsId());
							if (goods != null) {
								i.setGoods(goods);
							}
							itemsList.add(i);
							count += i.getNums();
						}
					order.setCount(count);
					order.setItems(itemsList);
					orderListNew.add(order);
				}
			}
		}
		return orderListNew;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.order.service.OrderService#receiveGoodsById(java
	 * .lang.String)
	 */
	@Override
	public void receiveGoodsById(String id) {
		Order order = new Order();
		order.setId(id);
		order.setShipStatus("2");
		orderMapper.updateByPrimaryKeySelective(order);
	}

	private void fanxian(Double fanxian, Integer fanxianNum, String userId,String username, String orderNum, String goodsId) {
		/*JiesuanItem jiesuanItem = new JiesuanItem();
		jiesuanItem.setId(ToolsUtil.getUUID());
		jiesuanItem.setMemberId(userId);
		jiesuanItem.setCount(Arith.div(fanxian, Double.parseDouble(fanxianNum.toString()), 2));
		jiesuanItem.setRemark("订单返现,订单号：" + orderNum);
		jiesuanItem.setCreatetime(new Date());
		jiesuanItem.setPici(orderNum);
		jiesuanItem.setGoodsId(goodsId);
		jiesuanItem.setNum(Long.parseLong(fanxianNum.toString()));*/
		Goods goods=goodsMapper.gainGoodsById(goodsId);
		CashBackTask task=new CashBackTask();
		task.setMemberId(userId);
		task.setMemberName(username);
		task.setBackKey("1");   //返现类型：1商品返现，2升级返现
		task.setBackValue(orderNum); //订单编号
		task.setGoodsId(goodsId);
		task.setGoodsName(goods.getName());
		task.setRemark("订单返现,订单号：" + orderNum);
		task.setTotalBalance(new BigDecimal(fanxian));
		task.setTotalNumber(fanxianNum);
		task.setAmount(new BigDecimal(Arith.div(fanxian, Double.parseDouble(fanxianNum.toString()), 2)));
		taskService.insertCashBackTask(task);
	}

//	/***
//	 * 三级分销返现
//	 *
//	 * @param id
//	 */
//	@Override
//	public void orderSanjifenxiao(Order order, String userId) {
//		String memberThree = "";
//		String memberTwo = "";
//		String memberOne = "";
//
//		Member member = membersMapper.gainMemberById(userId);
//
//		if (null != member) {
//			// 查询这个用户的三级用户分别是谁
//			if (null != member.getShangjiId() && !"".equals(member.getShangjiId())) {
//				Member member1 = membersMapper.getMemberListByShangjiIdOne(member.getShangjiId());
//				if (null != member1) {
//					memberOne = member1.getId();
//					if (null != member1.getShangjiId() && !"".equals(member1.getShangjiId())) {
//						Member member2 = membersMapper.getMemberListByShangjiIdOne(member1.getShangjiId());
//
//						if (null != member2) {
//							memberTwo = member2.getId();
//							if (null != member2.getShangjiId() && !"".equals(member2.getShangjiId())) {
//								Member member3 = membersMapper.getMemberListByShangjiIdOne(member2.getShangjiId());
//								if (null != member3) {
//									memberThree = member3.getId();
//								}
//							}
//						}
//					}
//				}
//			}
//
//			//查询该订单是否使用了经验值
//			OrderPayment orderPayment = paymentService.queryPointPayment(order.getId());
//
//			/**
//			 * 订单遍历，每个商品每次返现多少，分多少次返
//			 */
//			List<OrderItem> items = orderItemMapper.selectByOrderId(order.getId());
//			if (null != items && items.size() > 0) {
//				for (OrderItem item : items) {
//					Goods goods = goodsMapper.gainGoodsById(item.getGoodsId());
//
//					if (null != goods) {
//						if (0 != goods.getFanxian() && 0 != goods.getFanxiannum()) {
//							// 返现给自己
//							Double zijiFanxian = Arith.mul(item.getNums().doubleValue(), goods.getFanxian());
//
//							if(null != orderPayment && "1".equals(orderPayment.getStatus())){
//								//各商品总额 - 各商品所用经验值
//								zijiFanxian = zijiFanxian - item.getPoint();
//							}
//
//							Integer zijiNum = goods.getFanxiannum();//返现期数
//							fanxian(zijiFanxian, zijiNum, userId,member.getUsername(), order.getOrderNum(), goods.getId());
//						}
//					}
//				}
//			}
//
////			返现给上级
//			if (!"".equals(memberOne)) {
//				Double yijiFanxian = order.getTotalCost();
//				//订单总额 - 订单使用经验值总额
//				if(null != orderPayment && "1".equals(orderPayment.getStatus())){
//					yijiFanxian = Arith.mul((order.getTotalCost()-order.getCarriage())- orderPayment.getAmount().doubleValue(), 0.1);
//				}else{
//					 yijiFanxian = Arith.mul((order.getTotalCost()-order.getCarriage()), 0.1);
//				}
//
//				this.returnCashNow(memberOne, yijiFanxian, "一级代言【"+ member.getUsername()+"】购买商品获得金米,订单号：" + order.getOrderNum());
//			}
//			if (!"".equals(memberTwo)) {
//				Double fanxian =order.getTotalCost();
//				//订单总额 - 订单使用经验值总额
//				if(null != orderPayment && "1".equals(orderPayment.getStatus())){
//					fanxian =  Arith.mul((order.getTotalCost()-order.getCarriage())- orderPayment.getAmount().doubleValue(), 0.1);
//				}else{
//					fanxian = Arith.mul((order.getTotalCost()-order.getCarriage()), 0.1);
//				}
//
//				this.returnCashNow(memberTwo, fanxian, "二级代言【"+ member.getUsername()+"】购买商品获得金米,订单号：" + order.getOrderNum());
//			}
//			if (!"".equals(memberThree)) {
//				Double fanxian = order.getTotalCost();
//				//订单总额 - 订单使用经验值总额
//				if(null != orderPayment && "1".equals(orderPayment.getStatus())){
//					fanxian = Arith.mul((order.getTotalCost()-order.getCarriage()) - orderPayment.getAmount().doubleValue(), 0.1);
//				}else{
//					 fanxian = Arith.mul((order.getTotalCost()-order.getCarriage()), 0.1);
//				}
//
//				this.returnCashNow(memberThree, fanxian, "三级代言【"+ member.getUsername()+"】购买商品获得金米,订单号：" + order.getOrderNum());
//			}
//		}
//		logger.info("处理用户"+member.getUsername()+",的订单确"+order.getOrderNum()+"返现完成。");
//	}

	/**
	 * 立即返现
	 * 给指定用户返现给指定的金额
	 * 并保存返现记录和金米记录
	 * @param memberId 要返现给的用户id
	 * @param cash 返现金额
	 */
	private void returnCashNow(String memberId, Double cash, String remark) {
		
		
		Member member = membersMapper.gainMemberById(memberId);
		
		//金米添加日志
		XianjinbiDetail xianjinbiDetail = new XianjinbiDetail();
		xianjinbiDetail.setId(ToolsUtil.getUUID());
		xianjinbiDetail.setMemberId(memberId);
		xianjinbiDetail.setRemark(remark);
		xianjinbiDetail.setCreatetime(new Date());
		xianjinbiDetail.setType((short) 0);
		xianjinbiDetail.setStatus("1");
		xianjinbiDetail.setPoint(cash);//本次用户金米变化的数量
		xianjinbiDetail.setBalance(member.getXianjinbi());//用户金米操作之前的余额
		
		member.setXianjinbi(member.getXianjinbi()+cash);
		membersMapper.updateByPrimaryKeySelective(member);
		
		xianjinbiDetailMapper.insertSelective(xianjinbiDetail);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.order.service.OrderService#gainOrdersByCompanyIdGetLong
	 * (java.util.Map)
	 */
	@Override
	public Long gainOrdersByCompanyIdGetLong(Map<String, Object> map) {

		return orderMapper.gainOrdersByCompanyIdGetLong(map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.order.service.OrderService#gainOrdersByCompanyIdGetList
	 * (java.util.Map)
	 */
	@Override
	public List<Order> gainOrdersByCompanyIdGetList(Map<String, Object> map) {
		List<Order> orderList = orderMapper.gainOrdersByCompanyIdGetList(map);
		if (null != orderList && orderList.size() > 0) {
			for (Order order : orderList) {
				List<OrderItem> items = orderItemMapper.selectByOrderId(order.getId());
				OrderItem orderItems = new OrderItem();
				List<OrderItem> itemsList = new ArrayList<OrderItem>();
				if (null != items && items.size() > 0) {
					for (OrderItem item : items) {
						String goodspics = goodsMapper.gainGoodsPicById(item.getGoodsId());
						orderItems = item;
						if (null != goodspics && goodspics.length() > 0) {
							orderItems.setGoodsPic(goodspics.split(",")[0]);
						} else {
							orderItems.setGoodsPic("/images/360-270zwpic.gif");
						}

						itemsList.add(orderItems);
					}
				}
				order.setItems(itemsList);
			}
		}
		return orderList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.order.service.OrderService#gainOrderItemsByOrderId
	 * (java.lang.String)
	 */
	@Override
	public List<OrderItem> gainOrderItemsByOrderId(String orderId) {
		List<OrderItem> orderItems = orderItemMapper.selectByOrderId(orderId);
		for (OrderItem item : orderItems) {
			Goods goods = goodsMapper.gainGoodsById(item.getGoodsId());
			if (goods != null) {
				item.setGoods(goods);
			}
		}
		return orderItems;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.order.service.OrderService#gainOrderById(java.lang
	 * .String)
	 */
	@Override
	public Order gainOrderById(String id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.order.service.OrderService#returnGoods(com.qlzy
	 * .model.OrderReturn)
	 */
	@Override
	public void returnGoods(OrderReturn orderReturn) {
		orderReturnMapper.insertSelective(orderReturn);// 添加到退款退货表中
		Order order = orderMapper.selectByPrimaryKey(orderReturn.getOrderId());
		order.setStatus("7");
		/**
		 * 只要买家已付款，才存在退款（因为电商只支持在线付款和预存款支付）
		 */
		if (order != null && "1".equals(order.getPayStatus())
				&& "0".equals(order.getShipStatus())) {// 买家已付款商家未发货，只需更改订单为待退款
			order.setPayStatus("2");// 付款状态改为待退款
			orderMapper.updateByPrimaryKeySelective(order);

		} else if (order != null && "1".equals(order.getPayStatus())
				&& "1".equals(order.getShipStatus())) {// 买家已付款商家已发货，则订单改为：待退款、待退货
			order.setPayStatus("2");// 付款状态改为待退款
			order.setShipStatus("3");// 待退货
			orderMapper.updateByPrimaryKeySelective(order);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.order.service.OrderService#returnPay(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void returnPay(String orderId, String type) {
		Order order = new Order();
		OrderReturn orderReturn = new OrderReturn();
		order.setId(orderId);
		orderReturn.setOrderId(orderId);
		if ("ok".equals(type)) {
			order.setPayStatus("3");// 同意退款，把订单支付状态改为已退款-3，次时应该把钱打回买家，没有网银接口所以没做
			orderReturn.setReturnType("2");
		} else if ("no".equals(type)) {
			order.setPayStatus("4");// 拒绝退款，把订单支付状态改为卖家拒绝退款-4，
			orderReturn.setReturnType("3");
		}
		orderMapper.updateByPrimaryKeySelective(order);// 更新订单支付状态
		orderReturnMapper.updatePayStatus(orderReturn);// 更新退单申请中的状态，此时可能存在多个申请，这里更新为待退款的
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qlzy.memberCenter.order.service.OrderService#returnShip(java.lang
	 * .String)
	 */
	@Override
	public void returnShip(String id) {
		Order order = new Order();
		order.setId(id);
		order.setShipStatus("4");
		orderMapper.updateByPrimaryKeySelective(order);
	}

	/**
	 * 发货规则修改，时间2016.08.26
	 * 物流信息有与订单关联现改为与订单和订单中的商品相关联
	 * 1：商家发货首先会根据订单中的某一个商品来发货。此时保存某一个商品的发货信息。
	 * 2：如果该订单中所有的商品均已发货则修改订单中的是否已发货状态为已发货。
	 * 	订单表中也会保存物流的信息，但准确性不会太大了，因为订单表中保存的物流的信息为该订单最后一次发货的信息
	 */
	@Override
	public void compayDeliverShip(Order order, String orderItemId) {
		OrderItem item = orderItemMapper.selectByPrimaryKey(orderItemId);
		if (item != null){
			item.setLogisticsNum(order.getLogisticsNum());
			item.setLogisticsName(order.getLogisticsName());
			item.setLogisticsTel(order.getLogisticsTel());
			item.setIsLogistice(1);
			orderItemMapper.updateByPrimaryKeySelective(item);
		}
		order.setShipStatus("1");// 订单状态需要改为发货状态
		order.setShipTime(new Date());
		orderMapper.updateByPrimaryKeySelective(order);
		Order o = orderMapper.selectByPrimaryKey(order.getId());
		DeliverPojo pojo = new DeliverPojo();
		pojo.setDealId(o.getDealId());
		pojo.setMerId(ResourceUtil.getLhMerId());
		try {
			OrderUtil.deliverOrderToLh(pojo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public Order gainOrderByOrderNum(String orderNum) {
		return orderMapper.gainOrderByOrderNum(orderNum);
	}

	@Override
	public void deleteByPrimaryKey(String id) {
		Order order = orderMapper.selectByPrimaryKey(id);
		if(order != null) {
			try {
				paymentService.returnPoint(order.getId(), order.getMemberId());
			} catch (Exception e) {}
		}
		
		List<OrderItem> orderItems = orderItemMapper.selectByOrderId(id);
		orderMapper.deleteByPrimaryKey(id);
		List<String> orderItemIds = new ArrayList<String>();
		if (null != orderItems && orderItems.size() > 0) {
			for (OrderItem orderItem : orderItems) {
				orderItemIds.add(orderItem.getId());
			}
			orderItemMapper.droporderItems(orderItemIds);
		}
		appraiseMapper.deleteByOrderId(id);
	}

	@Override
	public OrderItem selectByOrderItemId(String id) {
		return orderItemMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateItemByOrderItemId(OrderItem record) {
		return orderItemMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public int updateAppraiseById(OrderItem record){
		return orderItemMapper.updateAppraiseById(record);
	}

	@Override
	public int updateOrderByOrderId(Order record) {
		return orderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Order> gainOrderByCreateTime(Integer i) {
		return orderMapper.gainOrderByCreateTime(i);
	}

	@Override
	public Long gainOrdersByCompanyIdGetLongxs(Map<String, Object> map) {
		return orderMapper.gainOrdersByCompanyIdGetLongxs(map);
	}

	@Override
	public List<Order> gainOrdersByCompanyIdGetListxs(Map<String, Object> map) {
		List<Order> orderList = orderMapper.gainOrdersByCompanyIdGetListxs(map);
		if (null != orderList && orderList.size() > 0) {
			for (Order order : orderList) {
				List<OrderItem> items = orderItemMapper.selectByOrderId(order
						.getId());
				OrderItem orderItems = new OrderItem();
				List<OrderItem> itemsList = new ArrayList<OrderItem>();
				if (null != items && items.size() > 0) {
					for (OrderItem item : items) {
						String goodspics = goodsMapper.gainGoodsPicById(item
								.getGoodsId());
						orderItems = item;
						if (null != goodspics && goodspics.length() > 0) {
							orderItems.setGoodsPic(goodspics.split(",")[0]);
						} else {
							orderItems.setGoodsPic("/images/360-270zwpic.gif");
						}

						itemsList.add(orderItems);
					}
				}
				order.setItems(itemsList);
			}
		}
		return orderList;
	}

	@Override
	public Long gainOrdersByCompanyIdGetLonggm(Map<String, Object> map) {
		return orderMapper.gainOrdersByCompanyIdGetLonggm(map);
	}

	@Override
	public List<Order> gainOrdersByCompanyIdGetListgm(Map<String, Object> map) {
		List<Order> orderList = orderMapper.gainOrdersByCompanyIdGetListgm(map);
		if (null != orderList && orderList.size() > 0) {
			for (Order order : orderList) {
				List<OrderItem> items = orderItemMapper.selectByOrderId(order
						.getId());
				OrderItem orderItems = new OrderItem();
				List<OrderItem> itemsList = new ArrayList<OrderItem>();
				if (null != items && items.size() > 0) {
					for (OrderItem item : items) {
						String goodspics = goodsMapper.gainGoodsPicById(item
								.getGoodsId());
						orderItems = item;
						if (null != goodspics && goodspics.length() > 0) {
							orderItems.setGoodsPic(goodspics.split(",")[0]);
						} else {
							orderItems.setGoodsPic("/images/360-270zwpic.gif");
						}

						itemsList.add(orderItems);
					}
				}
				order.setItems(itemsList);
			}
		}
		return orderList;
	}

	@Override
	public Double gaintotalCostgm(Map<String, Object> paramMap) {
		return orderMapper.gaintotalCostgm(paramMap);
	}

	@Override
	public Double gaintotalCostxs(Map<String, Object> paramMap) {
		return orderMapper.gaintotalCostxs(paramMap);
	}

	@Override
	public Long gainOrdersByCompanyIdGetLongCh(Map<String, Object> map) {
		return orderMapper.gainOrdersByCompanyIdGetLongCh(map);
	}

	@Override
	public List<Order> gainOrdersByCompanyIdGetListCh(Map<String, Object> map) {
		List<Order> orderList = orderMapper.gainOrdersByCompanyIdGetListCh(map);
		if (null != orderList && orderList.size() > 0) {
			for (Order order : orderList) {
				List<OrderItem> items = orderItemMapper.selectByOrderId(order.getId());
				OrderItem orderItems = new OrderItem();
				List<OrderItem> itemsList = new ArrayList<OrderItem>();
				if (null != items && items.size() > 0) {
					for (OrderItem item : items) {
						String goodspics = goodsMapper.gainGoodsPicById(item.getGoodsId());
						orderItems = item;
						if (null != goodspics && goodspics.length() > 0) {
							orderItems.setGoodsPic(goodspics.split(",")[0]);
						} else {
							orderItems.setGoodsPic("images/360-270zwpic.gif");
						}

						itemsList.add(orderItems);
					}
				}
				order.setItems(itemsList);
			}
		}
		return orderList;
	}

	@Override
	public List<Order> gainChuanhuoList() {
		return orderMapper.gainChuanhuoList();
	}

	@Override
	public void updatePayDeail(TradePayDeail tradePayDeail) {
		tradePayDeailMapper.updateBySelective(tradePayDeail);
	}

	@Override
	public void updateOrderAndPayDeail(String out_trade_no, String trade_no, String trade_status, String payType) {
		Order order = new Order();
		order.setOrderNum(out_trade_no);
		order.setPayMent("0");
		order.setPayStatus("1");
		order.setPayTime(new Date());
		orderMapper.upadteOrderPayType(order);
		// mem.setPoint(mem.getPoint()+order.getTotalCost());
		// membersMapper.updateByPrimaryKeySelective(mem);
		TradePayDeail tradePayDeail = new TradePayDeail();
		tradePayDeail.setOrderNum(out_trade_no);
		tradePayDeail.setTradeNo(trade_no);
		tradePayDeail.setTradeStatus("0");

		tradePayDeailMapper.upadteOrderPayType(tradePayDeail);

	}



	@Override
	public String gainOrdersByOrderNum(String out_trade_no) {
		Order order = orderMapper.gainOrdersByOrderNum(out_trade_no);
		String orderId = order.getId();
		return orderId;
	}

	@Override
	public OrderReturn gainOrderReturnById(String id) {
		return orderReturnMapper.gainByOrderId(id);
	}

	@Override
	public synchronized void orderFanxian(String out_trade_no) {
		/*Order order = orderMapper.gainOrderByOrderNum(out_trade_no);
		Member mem = membersMapper.selectByPrimaryKey(order.getMemberId());
		// 添加隔月结算列表
		List<OrderItem> orderItems = orderItemMapper.selectByOrderId(order.getId());

		Goods goods = goodsMapper.gainGoodsById(orderItems.get(0).getGoodsId());
		String isFanli = goods.getGoodstype();
		if (isFanli.endsWith("1")) {
			Double orderDouble = order.getTotalCost();
			if (orderDouble > 997) {
				mem.setType("82ee892375df4c1e98a3d8c9fd6e7612");
				membersMapper.updateByPrimaryKeySelective(mem);
			}

			List<JiesuanItem> list = jiesuanItemMapper.selectByPici(order.getOrderNum());
			if (list.size() == 0) {
				JiesuanItem jiesuanItem = new JiesuanItem();
				jiesuanItem.setId(ToolsUtil.getUUID());
				jiesuanItem.setMemberId(mem.getId());
				jiesuanItem.setCount(order.getTotalCost() / 40);// 40
				jiesuanItem.setRemark("订单返现,订单号：" + order.getOrderNum());
				jiesuanItem.setCreatetime(new Date());
				jiesuanItem.setPici(order.getOrderNum());
				jiesuanItem.setNum(40L);
				jiesuanItemMapper.insertSelective(jiesuanItem);
			}

			// 上级得到相应返现
			if (mem.getShangjiId() != null && (!mem.getShangjiId().equals(""))) {
				Member smMember = membersMapper.gainMemberByShangjiId(mem.getShangjiId()).get(0);

				XianjinbiDetail xianjinbiDetail = new XianjinbiDetail();
				xianjinbiDetail.setId(ToolsUtil.getUUID());
				xianjinbiDetail.setMemberId(smMember.getId());
				xianjinbiDetail.setRemark("一级下游【" + mem.getUsername() + "】订单返现,订单号：" + order.getOrderNum() + "获得金米");
				xianjinbiDetail.setCreatetime(new Date());
				xianjinbiDetail.setType((short) 0);
				xianjinbiDetail.setStatus("1");
				xianjinbiDetail.setPoint((order.getTotalCost() * 0.1) / 40);
				xianjinbiDetail.setBalance(smMember.getXianjinbi());

				List<XianjinbiDetail> xd = xianjinbiDetailMapper.gainListByRemark(xianjinbiDetail.getRemark());
				if (xd.size() == 0) {
					xianjinbiDetailMapper.insertSelective(xianjinbiDetail);
					smMember.setXianjinbi(smMember.getXianjinbi()+ (order.getTotalCost() * 0.1) / 40);
					membersMapper.updateByPrimaryKeySelective(smMember);
				}
				Member ssMember = membersMapper.gainMemberByShangjiId(smMember.getShangjiId()).get(0);
				if (smMember.getShangjiId() != null && (!smMember.getShangjiId().equals(""))) {
					XianjinbiDetail xianjinbiDetail2 = new XianjinbiDetail();
					xianjinbiDetail2.setId(ToolsUtil.getUUID());
					xianjinbiDetail2.setMemberId(ssMember.getId());
					xianjinbiDetail2.setRemark("二级下游【" + mem.getUsername() + "】订单返现,订单号：" + order.getOrderNum() + "获得金米");
					xianjinbiDetail2.setCreatetime(new Date());
					xianjinbiDetail2.setType((short) 0);
					xianjinbiDetail2.setStatus("1");
					xianjinbiDetail2.setPoint((order.getTotalCost() * 0.1) / 40);
					xianjinbiDetail2.setBalance(ssMember.getXianjinbi());
					List<XianjinbiDetail> xd2 = xianjinbiDetailMapper.gainListByRemark(xianjinbiDetail2.getRemark());
					if (xd2.size() == 0) {
						xianjinbiDetailMapper.insertSelective(xianjinbiDetail2);
						ssMember.setXianjinbi(ssMember.getXianjinbi() + (order.getTotalCost() * 0.1) / 40);
						membersMapper.updateByPrimaryKeySelective(ssMember);
					}

					Member sssMember = membersMapper.gainMemberByShangjiId(ssMember.getShangjiId()).get(0);
					if (ssMember.getShangjiId() != null && (!ssMember.getShangjiId().equals(""))) {
						XianjinbiDetail xianjinbiDetail3 = new XianjinbiDetail();
						xianjinbiDetail3.setId(ToolsUtil.getUUID());
						xianjinbiDetail3.setMemberId(sssMember.getId());
						xianjinbiDetail3.setRemark("三级下游【" + mem.getUsername() + "】订单返现,订单号：" + order.getOrderNum() + "获得金米");
						xianjinbiDetail3.setCreatetime(new Date());
						xianjinbiDetail3.setType((short) 0);
						xianjinbiDetail3.setStatus("1");
						xianjinbiDetail3.setPoint((order.getTotalCost() * 0.1) / 40);
						xianjinbiDetail3.setBalance(sssMember.getXianjinbi());
						List<XianjinbiDetail> xd3 = xianjinbiDetailMapper.gainListByRemark(xianjinbiDetail3.getRemark());
						if (xd3.size() == 0) {
							xianjinbiDetailMapper.insertSelective(xianjinbiDetail3);
							sssMember.setXianjinbi(sssMember.getXianjinbi() + (order.getTotalCost() * 0.1) / 40);
							membersMapper.updateByPrimaryKeySelective(sssMember);
						}
					}
				}

			}
		}*/
	}



	public void receiveQuartzUpdate(List<Order> orderList) {
		List<String> orderIds = new ArrayList<String>();
		for (Order o : orderList) {
			orderIds.add(o.getId());
//			orderSanjifenxiao(o, o.getMemberId());
		}
		// 确认收货订单批量修改
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderIds", orderIds);
		map.put("shipStatus", "2");
		map.put("completeTime", new Date());
		orderMapper.updateBatchReceive(map);
	}

	/** 添加分销 心动值 log **/
	public void addAdvanceLog(Member member,BigDecimal money,BigDecimal bili,BigDecimal orderTotal) {
		AdvanceLogs logs = new AdvanceLogs();
		logs.setId(ToolsUtil.getUUID());
		logs.setBalance(member.getAdvance());
		logs.setDoTime(new Date());
		logs.setDoType("3");//操作方式 0 充值；1 取现 2消费 3分销
		logs.setTrading("1");//交易状态 0 未完成 1  已完成
		logs.setUserId(member.getId());
		logs.setMessage("获得分销金额："+money);
		logs.setDoMoney(money.doubleValue());
		logs.setDoWhat(bili.toString());//分销比例
        logs.setPaymentId(orderTotal.toString());//订单总金额
		advanceLogsMapper.insertSelective(logs);
	}

	/** 添加升级 log **/
	public void addShengjiLog(Member member) {
		member.setId(ToolsUtil.getUUID());
		member.setLastLoginTime(new Date());
		membersMapper.insertShengjiLog(member);
	}


	/***
	 * 确认收货
	 */
	@Override
    @Transactional
	public void receiveAndFenxiao(Order order, String memberId) {

		Map<String,Object> paraMap = new HashMap<String,Object>();
		// 三级分销
		Order order2 = orderMapper.selectByPrimaryKey(order.getId());
		Member member = membersMapper.selectByPrimaryKey(order2.getMemberId());
		// 已付款订单，判断订单状态不能为已收货（防止多次提交）
		if("3".equals(order2.getStatus()) && "1".equals(order2.getPayStatus()) && !"2".equals(order2.getShipStatus())) {
			/****************************三级分销开始**********************************************/
			BigDecimal orderPoints = order2.getOrderPoints();//订单分销总金额
			BigDecimal totalCost = order2.getTotalCost();//订单分销总金额

			BigDecimal yijiBili = new BigDecimal(dictMapper.getByType("FirstDistributionRatio").getValue());
			BigDecimal erjiBili = new BigDecimal(dictMapper.getByType("SedDistributionRatio").getValue());

			//查询直接上级
			Member newMember = membersMapper.getMemberListByShangjiIdOne(member.getShangjiId());
			if(newMember != null ){
				BigDecimal yijii = new BigDecimal(newMember.getAdvance()).add(orderPoints.multiply(yijiBili));
				addAdvanceLog(newMember,orderPoints.multiply(yijiBili),yijiBili,totalCost);//添加分销log
				newMember.setAdvance(yijii.doubleValue());
				membersMapper.updateByPrimaryKeySelective(newMember);
				//查询上上级
				Member newOldMember = membersMapper.getMemberListByShangjiIdOne(newMember.getShangjiId());
				if(newOldMember != null ){
					BigDecimal erji = new BigDecimal(newOldMember.getAdvance()).add(orderPoints.multiply(erjiBili));
					addAdvanceLog(newOldMember,orderPoints.multiply(erjiBili),erjiBili,totalCost);//添加分销log
					newOldMember.setAdvance(erji.doubleValue());
					membersMapper.updateByPrimaryKeySelective(newOldMember);
				}
			}

			/**************************************************************************/

			/************************升星开始*********************************************/
			// 消费金额 升级  普通用户消费累计达到A则成为1星会员。 自己和1级下线累计消费B，升级为2星会员
			//先判断自己够升级
			paraMap.put("memberId",member.getId());
			BigDecimal mimeXiaofei = membersMapper.gainXiaofeiTotal(paraMap);//自己消费
			List<Map<String,Object>> moneyMap = membersMapper.gainMemberLv(paraMap);//自己下一等级升级标准

			//计算自己消费金额 升星
			if(!("0").equals(member.getType())){//判断自己等级是 普通用户吗
                //查询自己和1级下级的消费
                paraMap.put("memberId", "");
                paraMap.put("onlyId", member.getOnlyId());
                BigDecimal xiajiXiaofei = membersMapper.gainXiaofeiTotal(paraMap);
                for(Map<String,Object> map : moneyMap){
                    String lvId = map.get("id").toString();
                    BigDecimal shangjiminPoint = new BigDecimal(map.get("minPoint").toString());
                    int shangjimaxPoint = Integer.parseInt(map.get("maxPoint").toString());
                    if ((mimeXiaofei.add(xiajiXiaofei)).compareTo(shangjiminPoint) == 1) {
                        member.setType(lvId);
                        membersMapper.updateByPrimaryKeySelective(member);
                        continue;
                    }
                }
			}else {
                //查询普通升1星金额
                //查询自己消费
                for(Map<String,Object> map : moneyMap){
                    String lvId = map.get("id").toString();
                    BigDecimal shangjiminPoint = new BigDecimal(map.get("minPoint").toString());
                    String shangjimaxPoint = map.get("maxPoint").toString();
                    if(shangjiminPoint.compareTo(mimeXiaofei) == -1){
                        member.setType(lvId);
                        membersMapper.updateByPrimaryKeySelective(member);
                        continue;
                    }
                }
			}
			addShengjiLog(member);
			//计算上级消费金额 升星
			if(newMember != null ){
				if(("0").equals(newMember.getType())){//判断上级等级是 普通用户，不升星

				}else {
					//查询1级上级的消费 升星
					paraMap.put("memberId",newMember.getId());
					paraMap.put("onlyId", "");
					BigDecimal shangjiXiaofei = membersMapper.gainXiaofeiTotal(paraMap);//自己消费
					List<Map<String,Object>> shangjimoneyMap = membersMapper.gainMemberLv(paraMap);//自己下一等级升级标准


					paraMap.put("memberId", "");
					paraMap.put("onlyId", newMember.getOnlyId());
					BigDecimal xiajiXiaofei = membersMapper.gainXiaofeiTotal(paraMap);

					for(Map<String,Object> map : shangjimoneyMap){
                        String lvId = map.get("id").toString();
                        BigDecimal shangjiminPoint = new BigDecimal(map.get("minPoint").toString());
                        int shangjimaxPoint = Integer.parseInt(map.get("maxPoint").toString());
                        if ((shangjiXiaofei.add(xiajiXiaofei)).compareTo(shangjiminPoint) == -1) {
                            newMember.setType(lvId);
                            membersMapper.updateByPrimaryKeySelective(newMember);
                            continue;
                        }
                    }
				}
			}
			addShengjiLog(newMember);

			/****************************升星结束*****************************************/

		}
		Order order1 = new Order();
		order1.setId(order.getId());
		order1.setShipStatus("2");
		order1.setStatus("4");
		order1.setCompleteTime(new Date());	//收货时间
		orderMapper.updateByPrimaryKeySelective(order1);
		Map<String, Object> params = new HashMap<String, Object>();
		JSONObject result = null;
		params.put("orderId", order.getOrderNum());
		try {
			result = JSONObject.parseObject(HttpRequestProxy.doPost(ResourceUtil.getHcpayGateway() + "/pay/querenshouhuo.html", addSign(params), "utf-8"));
			boolean success = result.getBooleanValue("code");
			if(!success){ 
				throw new RuntimeException("确认失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("确认失败");
		}
	
	}


	private Map<String, Object> addSign(Map<String, Object> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		
		StringBuffer buffer = new StringBuffer();
		for(String key : keys) {
			buffer.append(key).append("=").append(params.get(key)).append("&");
		}
		String linkString = buffer.length()>0 ? buffer.substring(0, buffer.length()-1) : "";
		params.put("sign", DigestUtils.md5Hex(DigestUtils.md5Hex(linkString + "b6799bcf12c84133abf39c25a5f80c92") + "9ea041d043494d9f83b8a4cb5ea96e8d"));
		
		return params;
	}
	/**
	 * 订单消费金额满998，自动升级vip会员
	 * @param
	 */
	private void autoUpdateVip(Member member, Order order) {
		member.setType("82ee892375df4c1e98a3d8c9fd6e7612");
		membersMapper.updateByPrimaryKeySelective(member);
		
		MemeberDeail mem = new MemeberDeail();
		mem.setId(ToolsUtil.getUUID());
		mem.setMembername(member.getUsername());
		mem.setMemberid(member.getId());
		mem.setMessage("单次消费满998（仅限现金支付）自动升级会员：" + order.getOrderNum());
		mem.setCreatetime(new Date());
		mem.setStutas("1");
		mem.setNum(0L);
		mem.setZengsongtype(member.getIstop());
		memeberDeailMapper.insertSelective(mem);
	}

//	@Override
//	public void updateSaleQuantity(String out_trade_no) {
//		Order originOrder = orderMapper.selectByPrimaryKey(out_trade_no);
////		if(originOrder != null && !"1".equals(originOrder.getPayStatus())) {
//			List<OrderItem> itemList = orderItemMapper.selectByOrderId(originOrder.getId());
//			for(OrderItem item : itemList) {
//				Goods goods = goodsMapper.gainGoodsById(item.getGoodsId());
//				goods.setQueryNum(goods.getQueryNum() + item.getNums());
//				goodsMapper.updateByPrimaryKeySelective(goods);
//			}
////		}
//	}

	@Override
	public void receiveTimeout() {
		logger.info("==== 自动收货任务开始 ==================================================");
		List<Order> orderList = orderMapper.receiveQuartz(Integer.parseInt(ResourceUtil.getReceiveDateNum()));
		int success = 0;
		int failure = 0;
		for (Order order : orderList) {
			try {
				receiveAndFenxiao(order, null);
				success++;
			} catch (Exception e) {
				failure++;
				logger.error("订单【" + order.getOrderNum() + "】自动收货失败");
			}
		}
		logger.info("==== 自动收货任务结束：共" + orderList.size() + "条，成功" + success + "条，失败" + failure + "条================================");
	}

	@Override
	public void notpayTimeout() {
		logger.info("==== 未支付取消订单任务开始 ==================================================");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("timeNow", new Date());
		map.put("timeout", ResourceUtil.getPayTimeout());
		
		List<Order> list = orderMapper.queryNopayOrders(map);
		for(Order order : list) {
			try {
				paymentService.returnPoint(order.getId(), order.getMemberId());
			} catch (Exception e) {
				logger.error("订单 " + order.getOrderNum() + " 退还经验值失败");
			}
		}
		orderMapper.noPayQuartz(map);
		
		logger.info("==== 未支付取消订单任务结束 ==================================================");
	}
}
