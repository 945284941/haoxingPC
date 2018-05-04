/**  
* @Title: LhPayAction.java
* @Package com.qlzy.memberCenter.call.action
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-11-12 上午10:19:39
* @version V1.0  
*/
package com.qlzy.memberCenter.call.action;

import java.util.Date;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import com.ecc.tool.Signature;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.memberCenter.call.service.MemberCallService;
import com.qlzy.memberCenter.order.service.OrderService;
import com.qlzy.model.Order;
import com.qlzy.model.PayDeal;
import com.qlzy.util.BaseAction;

@Namespace("/")
@Action(value = "lhPayAction", results = {
		@Result(name = "paymentFail", location = "/admin/carts/paymentFail.jsp"),
		@Result(name = "paymenSuccess", location = "/admin/carts/paymenSuccess.jsp")
		
})
/**
 * @ClassName: LhPayAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-11-12 上午10:19:39
 */
public class LhPayAction extends BaseAction{
	Logger log = Logger.getLogger(this.getClass());
	@Resource
	private MemberCallService memberCallService;
	@Resource
	private OrderService orderService;
	
	private String dealOrder;
	private Double dealFee;
	private String dealState;
	private String dealSignure;
	private String dealId;
	private Order order;
	/**
	* @ClassName: com.qlzy.memberCenter.call.actionLhPayAction.java
	* @Description: TODO(这里用一句话描述这个类的作用)
	* @author 周张豹
	* @date 2013-11-12 上午10:20:55
	*/
	private static final long serialVersionUID = 1L;
	
	/**
	 * 支付完成后支付结果返回到该url，主要用于结果展示
	* @Title: dealReturn
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public  String dealReturn(){
		try {
//			System.out.println(dealOrder+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			order = orderService.gainOrderByOrderNum(dealOrder);
//			System.out.println(order+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			if ("0".equals(order.getPayStatus())) {
				return "paymenFail";
			}else {
				return "paymenSuccess";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 支付完成后支付结果通知到该url，主要用于通知接受<br>
	 * 买家生成订单的返回状态 WAIT_BUYER_PAY<br>
	 * 买家付款成功返回状态 WAIT_SELLER_SEND
	* @Title: dealNotify
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public void dealNotify(){
		String qlSignure = Signature.backSignure(dealOrder, dealState, ResourceUtil.getLhKey());
		if (qlSignure != null && qlSignure.equals(dealSignure)) {
			//数字签名通过
			Order order = orderService.gainOrderByOrderNum(dealOrder);
			PayDeal payDeal = memberCallService.gainPayDealByDealId(dealId, "LH");
			Double u = order.getTotalCost() - dealFee;
			if (u == 0.0) {//比较订单价格是否相同
				if (payDeal == null && "WAIT_BUYER_PAY".equals(dealState) ) {//对方创建订单通知
					payDeal = new PayDeal();
					payDeal.setId(ToolsUtil.getUUID());
					payDeal.setDealFee(dealFee);
					payDeal.setDealId(dealId);
					payDeal.setDealOrder(dealOrder);
					payDeal.setDealSignure(dealSignure);
					payDeal.setDealState(dealState);
					payDeal.setType("LH");
					payDeal.setUpdatetime(new Date());
					order.setDealId(dealId);
					order.setDealType("LH");
					memberCallService.lhCreateOrder(payDeal,order);
	
				}else if ("WAIT_SELLER_SEND".equals(dealState) && !"WAIT_SELLER_SEND".equals(payDeal.getDealState())) {//买家付款通知
						order.setPayStatus("1");
						order.setPayTime(new Date());
						payDeal.setDealState(dealState);
						payDeal.setUpdatetime(new Date());
						memberCallService.lhDealPayNotify(order,payDeal);
						
				}else if("WAIT_BUYER_RECIVE".equals(dealState) && !"WAIT_BUYER_RECIVE".equals(payDeal.getDealState())){
					payDeal.setDealState(dealState);
					order.setShipStatus("1");
					order.setShipTime(new Date());
					payDeal.setUpdatetime(new Date());
					memberCallService.updatePayDeal(payDeal,order);
					
					
				}
//				else if ("WAIT_BUYER_SEND".equals(dealState) && !"WAIT_BUYER_SEND".equals(payDeal.getDealState())) {//卖家发货通知
//					System.out.println(dealState);WAIT_BUYER_RECIVE
//					payDeal.setDealState(dealState);
//					order.setShipStatus("1");
//					order.setShipTime(new Date());
//					payDeal.setUpdatetime(new Date());
//					memberCallService.updatePayDeal(payDeal,order);
//				}
				else if ("SUCCESS".equals(dealState) && !"SUCCESS".equals(payDeal.getDealState())) {//买家收货通知
					payDeal.setDealState(dealState);
					payDeal.setUpdatetime(new Date());
					order.setShipStatus("2");
					memberCallService.updatePayDeal(payDeal,order);
					
				}
				super.writeJson("notify_success");
			}else {
				//订单价格不一样
				log.info("数字签名通过，但是价格不一致，不给与处理，时间为："+new Date()+"本次通知的信息为：dealOrder："+dealOrder+",dealFee:"+dealFee+",dealState"+dealState+",dealId"+dealId+",dealSignure"+dealSignure);
			}
			
		}else {
			//数字签名失败
			log.info("数字签名没有通过，但是价格不一致，不给与处理，时间为："+new Date()+"本次通知的信息为：dealOrder："+dealOrder+",dealFee:"+dealFee+",dealState"+dealState+",dealId"+dealId+",dealSignure"+dealSignure);
		}
		
	}

	public void dealNotifyljhk(){
		String qlSignure = Signature.backSignure(dealOrder, dealState, ResourceUtil.getLhKey());
		if (qlSignure != null && qlSignure.equals(dealSignure)) {
			//数字签名通过
			Order order = orderService.gainOrderByOrderNum(dealOrder);
			PayDeal payDeal = memberCallService.gainPayDealByDealId(dealId, "LH");
			Double u = order.getTotalCost() - dealFee;
			if (u == 0.0) {//比较订单价格是否相同
				if (payDeal == null && "WAIT_BUYER_PAY".equals(dealState) ) {//对方创建订单通知
					payDeal = new PayDeal();
					payDeal.setId(ToolsUtil.getUUID());
					payDeal.setDealFee(dealFee);
					payDeal.setDealId(dealId);
					payDeal.setDealOrder(dealOrder);
					payDeal.setDealSignure(dealSignure);
					payDeal.setDealState(dealState);
					payDeal.setType("LH");
					payDeal.setUpdatetime(new Date());
					order.setDealId(dealId);
					order.setDealType("LH");
					memberCallService.lhCreateOrder(payDeal,order);
	
				}else if ("WAIT_SELLER_SEND".equals(dealState) && !"WAIT_SELLER_SEND".equals(payDeal.getDealState())) {//买家付款通知
						order.setPayStatus("1");
						order.setSjhkTime(new Date());
						order.setHkType("1");
						//order.setPayTime(new Date());
						payDeal.setDealState(dealState);
						payDeal.setUpdatetime(new Date());
						memberCallService.lhDealPayNotifyLjhk(order,payDeal);
				}else if("WAIT_BUYER_RECIVE".equals(dealState) && !"WAIT_BUYER_RECIVE".equals(payDeal.getDealState())){
					payDeal.setDealState(dealState);
					order.setShipStatus("1");
					order.setShipTime(new Date());
					payDeal.setUpdatetime(new Date());
					memberCallService.updatePayDeal(payDeal,order);
				}
//				else if ("WAIT_BUYER_SEND".equals(dealState) && !"WAIT_BUYER_SEND".equals(payDeal.getDealState())) {//卖家发货通知
//					System.out.println(dealState);WAIT_BUYER_RECIVE
//					payDeal.setDealState(dealState);
//					order.setShipStatus("1");
//					order.setShipTime(new Date());
//					payDeal.setUpdatetime(new Date());
//					memberCallService.updatePayDeal(payDeal,order);
//				}
				else if ("SUCCESS".equals(dealState) && !"SUCCESS".equals(payDeal.getDealState())) {//买家收货通知
					payDeal.setDealState(dealState);
					payDeal.setUpdatetime(new Date());
					order.setShipStatus("2");
					memberCallService.updatePayDeal(payDeal,order);
					
				}
				super.writeJson("notify_success");
			}else {
				//订单价格不一样
				log.info("数字签名通过，但是价格不一致，不给与处理，时间为："+new Date()+"本次通知的信息为：dealOrder："+dealOrder+",dealFee:"+dealFee+",dealState"+dealState+",dealId"+dealId+",dealSignure"+dealSignure);
			}
			
		}else {
			//数字签名失败
			log.info("数字签名没有通过，但是价格不一致，不给与处理，时间为："+new Date()+"本次通知的信息为：dealOrder："+dealOrder+",dealFee:"+dealFee+",dealState"+dealState+",dealId"+dealId+",dealSignure"+dealSignure);
		}
		
	}

	/**
	 * @return the dealOrder
	 */
	public String getDealOrder() {
		return dealOrder;
	}


	/**
	 * @param dealOrder the dealOrder to set
	 */
	public void setDealOrder(String dealOrder) {
		this.dealOrder = dealOrder;
	}


	/**
	 * @return the dealFee
	 */
	public Double getDealFee() {
		return dealFee;
	}


	/**
	 * @param dealFee the dealFee to set
	 */
	public void setDealFee(Double dealFee) {
		this.dealFee = dealFee;
	}


	/**
	 * @return the dealState
	 */
	public String getDealState() {
		return dealState;
	}


	/**
	 * @param dealState the dealState to set
	 */
	public void setDealState(String dealState) {
		this.dealState = dealState;
	}


	/**
	 * @return the dealSignure
	 */
	public String getDealSignure() {
		return dealSignure;
	}


	/**
	 * @param dealSignure the dealSignure to set
	 */
	public void setDealSignure(String dealSignure) {
		this.dealSignure = dealSignure;
	}


	/**
	 * @return the dealId
	 */
	public String getDealId() {
		return dealId;
	}


	/**
	 * @param dealId the dealId to set
	 */
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}


	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}


	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
