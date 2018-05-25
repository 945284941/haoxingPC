package com.qlzy.payment.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.qlzy.common.tools.HttpRequestProxy;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.indexGoods.dao.GoodsMapper;
import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.memberCenter.common.dao.PointDetailMapper;
import com.qlzy.memberCenter.order.dao.OrderItemMapper;
import com.qlzy.memberCenter.order.dao.OrderMapper;
import com.qlzy.memberCenter.person.perinfo.dao.LiucunbiDetailMapper;
import com.qlzy.memberCenter.person.perinfo.dao.XianjinbiDetailMapper;
import com.qlzy.model.Goods;
import com.qlzy.model.LiucunbiDetail;
import com.qlzy.model.Member;
import com.qlzy.model.Order;
import com.qlzy.model.OrderItem;
import com.qlzy.model.OrderPayment;
import com.qlzy.model.PointDetail;
import com.qlzy.model.XianjinbiDetail;
import com.qlzy.payment.dao.OrderPaymentMapper;
import com.qlzy.payment.service.IPaymentService;

@Service("paymentService")
public class PaymentServiceImpl implements IPaymentService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderItemMapper orderItemMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private XianjinbiDetailMapper xianjinbiDetailMapper;
	@Autowired
	private LiucunbiDetailMapper liucunbiDetailMapper;
	@Resource
	private PointDetailMapper pointDetailMapper;
	@Autowired
	private OrderPaymentMapper paymentMapper;
	
	@Transactional
	public String dealHcResult(String type, String orderId, String memberId, BigDecimal beansAmount, BigDecimal huibaoAmount, BigDecimal pointAmount, String payuser, String paypass) {
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(!order.getMemberId().equals(memberId)) {
			throw new RuntimeException("订单【" + order.getOrderNum() + "】不属于您!");
		}
		BigDecimal totalCost = order.getTotalCost().setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal amount = huibaoAmount.add(beansAmount).add(pointAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		String payment = null;
		if("1".equals(type)) {
			payment = "4";
			beansAmount = totalCost;
		} else if("2".equals(type)) {
			payment = "5";
			huibaoAmount = totalCost;
		} else if("3".equals(type)) {
			payment = "6";
			pointAmount = totalCost;
		} else if("4".equals(type)) {
			payment = "7";
			if(totalCost.compareTo(amount) != 0){
				throw new RuntimeException("支付金额错误");
			}
		}else {
			throw new RuntimeException("支付方式错误");
		}
		
		DecimalFormat df = new DecimalFormat("0.00");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId", order.getOrderNum());
		params.put("type", type);	// 1汇豆，2汇宝，3汇积分，4汇豆+汇宝
		params.put("beansAmount", df.format(beansAmount));
		params.put("huibaoAmount", df.format(huibaoAmount));
		params.put("pointAmount", df.format(pointAmount));
		params.put("payuser", payuser);
		params.put("paypass", paypass);
		
		JSONObject result = null;
		try {
			result = JSONObject.parseObject(HttpRequestProxy.doPost(ResourceUtil.getHcpayGateway() + "/pay/directPay.html", addSign(params), "utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("支付失败");
		}
		boolean success = result.getBooleanValue("code");
		String message = result.getString("msg");
		if(success) {
			paymentSuccess(payment, order,new Date());
		} else if("订单已支付，请勿重复支付".equals(message)) {
			paymentSuccess(order.getPayMent(),order,order.getPayTime());
		}else{
			updatePayment(payment, order);
			throw new RuntimeException(message);
		}
		
		return message;
	}
	
	@Transactional
	public String dealOwnResult(String type, String orderId, String memberId, String payPassword) {
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(!order.getMemberId().equals(memberId)) {
			throw new RuntimeException("订单【" + order.getOrderNum() + "】不属于您!");
		}
		Member member = memberMapper.selectByPrimaryKey(memberId);
		
		if(member.getIsXiaofei().endsWith("0")){
				throw new RuntimeException("支付失败");
		}	
		if(!member.getPayPassword().equals(payPassword)) {
			throw new RuntimeException("支付密码错误!");
		}
		if(!"0".equals(order.getPayStatus())) {
			throw new RuntimeException("订单已支付,请勿重新支付!");
		}
		double totalCost = order.getTotalCost().doubleValue() - this.payByPoint(orderId, memberId);
		boolean flag = false;
		if("1".equals(type)){
				//金米
			if(member.getXianjinbi()>=totalCost) {
				XianjinbiDetail xian =new XianjinbiDetail();
				xian.setId(ToolsUtil.getUUID());
				xian.setBalance(member.getXianjinbi()-totalCost);
				xian.setCreatetime(new Date());
				xian.setMemberId(member.getId());
				xian.setPoint(totalCost);
				xian.setRemark("金米购买订单");
				xian.setStatus("1");
				xian.setType((short) 1L);
				xianjinbiDetailMapper.insertSelective(xian);
				member.setXianjinbi(member.getXianjinbi()-totalCost);
				memberMapper.updateByPrimaryKeySelective(member);
				flag=true;
			}else{
				throw new RuntimeException("金米不足");
			}
		}else if("2".equals(type)){
			throw new RuntimeException("目前不支持经验值支付，请选择其他支付方式");
//			double totalCost = 1000 * totalCost;
//			//经验值
//			if(member.getPoint() >= totalCost) {
//				PointDetail pointDetail =new PointDetail();
//				pointDetail.setId(ToolsUtil.getUUID());
//				pointDetail.setPoint(totalCost);
//				pointDetail.setMemberId(member.getId());
//				pointDetail.setRemark("经验值购买商品");
//				pointDetail.setCreatetime(new Date());
//				pointDetail.setBalance(member.getPoint());
//				pointDetail.setType(1);
//				pointDetailMapper.insertSelective(pointDetail);
//				member.setPoint(member.getPoint() - totalCost);
//				memberMapper.updateByPrimaryKeySelective(member);
//				flag=true;
//			}else{
//				throw new RuntimeException("经验值不足");
//			}
		}else if("3".equals(type)){
				//惠米
			if(member.getLiucunbi()>=totalCost) {
				LiucunbiDetail liu =new LiucunbiDetail();
				liu.setId(ToolsUtil.getUUID());
				liu.setBalance(member.getLiucunbi());
				liu.setCreatetime(new Date());
				liu.setMemberId(member.getId());
				liu.setPoint(totalCost);
				liu.setRemark("惠米购买订单");
				liu.setStatus("1");
				liu.setType((short) 1L);
				liucunbiDetailMapper.insertSelective(liu);
				member.setLiucunbi(member.getLiucunbi()-totalCost);
				memberMapper.updateByPrimaryKeySelective(member);
				flag=true;
			}else{
				throw new RuntimeException("惠米不足");
			}
		}else{
			throw new RuntimeException("支付方式错误!");
		}
			
		// 根据结果修改订单及支付状态
		if(flag) {
			paymentSuccess(type, order,new Date());
			return "paySuccess";
		}else{
			return "payFailure";
		}
	}
	
	/**
	 * 支付成功
	 * @param type		0 支付宝，1金米，2经验值， 3惠米，4汇豆，5汇宝，6汇积分，7汇豆+汇宝
	 * @param 	订单编号，不是orderNum
	 */
	private void paymentSuccess(String type, Order order,Date payDate) {
		if(order != null && !"1".equals(order.getPayStatus())) {
			List<OrderItem> itemList = orderItemMapper.selectByOrderId(order.getId());
			for(OrderItem item : itemList) {
				Goods goods = goodsMapper.gainGoodsById(item.getGoodsId());				
//				goods.setQueryNum(goods.getQueryNum() + item.getNums());
				goodsMapper.updateByPrimaryKeySelective(goods);
			}
		}
		
		Order order1 = new Order();
		order1.setPayMent(type);
		order1.setPayStatus("1");
		order1.setPayTime(payDate);
		order1.setOrderNum(order.getOrderNum());
		orderMapper.upadteOrderPayType(order1);
	}

	/***
	 * 更新支付方式
	 * @Title: updatePayment
	 * @Description:
	 * @date 2017-1-9 下午5:21:25 
	 * @param @param type
	 * @param @param order 设定文件
	 * @return void 返回类型
	 * @throws
	 * @version V1.0
	 */
	private void updatePayment(String type,Order order) {
		Order order1 = new Order();
		order1.setPayMent(type);
		order1.setPayTime(new Date());
		order1.setOrderNum(order.getOrderNum());
		orderMapper.upadteOrderPayType(order1);
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
	
	@Transactional
	public double payByPoint(String orderId, String memberId) {
		double count = 0;

		OrderPayment pointPayment = queryPointPayment(orderId);
		if(pointPayment != null) {
			if("1".equals(pointPayment.getStatus())) {
				count = pointPayment.getAmount().doubleValue();
			} else {
				Member member = memberMapper.selectByPrimaryKey(memberId);
				if(member.getPoint() >= pointPayment.getAmount().doubleValue()) {
					count = pointPayment.getAmount().doubleValue();
					PointDetail pointDetail =new PointDetail();
					pointDetail.setId(ToolsUtil.getUUID());
					pointDetail.setPoint(count);
					pointDetail.setMemberId(member.getId());
					pointDetail.setRemark("经验值购买商品");
					pointDetail.setCreatetime(new Date());
					pointDetail.setBalance(member.getPoint());
					pointDetail.setType(1);
					pointDetailMapper.insertSelective(pointDetail);
					member.setPoint(member.getPoint() - count);
					memberMapper.updateByPrimaryKeySelective(member);
					OrderPayment payment = new OrderPayment();
					payment.setPaymentId(pointPayment.getPaymentId());
					payment.setStatus("1");
					paymentMapper.updateByPrimaryKeySelective(payment);
				}
			}
		}
		
		return count;
	}

	@Transactional
	public double returnPoint(String orderId, String memberId) {
		double count = 0;
		
		OrderPayment pointPayment = queryPointPayment(orderId);
		if(pointPayment!=null && "1".equals(pointPayment.getStatus())) {
			count = pointPayment.getAmount().doubleValue();
			Member member = memberMapper.selectByPrimaryKey(memberId);
			PointDetail pointDetail =new PointDetail();
			pointDetail.setId(ToolsUtil.getUUID());
			pointDetail.setPoint(count);
			pointDetail.setMemberId(member.getId());
			pointDetail.setRemark("订单取消，退回经验值");
			pointDetail.setCreatetime(new Date());
			pointDetail.setBalance(member.getPoint());
			pointDetail.setType(0);
			pointDetailMapper.insertSelective(pointDetail);
			member.setPoint(member.getPoint() + count);
			memberMapper.updateByPrimaryKeySelective(member);
			OrderPayment payment = new OrderPayment();
			payment.setPaymentId(pointPayment.getPaymentId());
			payment.setStatus("2");
			paymentMapper.updateByPrimaryKeySelective(payment);
		}
		
		return count;
	}

	@Override
	public OrderPayment queryPointPayment(String orderId) {
		List<OrderPayment> list = this.queryPaymentRecord(orderId, "2", null);
		
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<OrderPayment> queryPaymentRecord(String orderId, String paymentType, String status) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("orderId", orderId);
		param.put("paymentType", paymentType);
		param.put("status", status);
		
		return paymentMapper.queryPaymentRecord(param);
	}

	@Override
	public BigDecimal queryPaidAmount(String orderId) {
		return paymentMapper.queryPaidAmount(orderId);
	}
}
