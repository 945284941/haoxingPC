/**  
* @Title: LhPayAction.java
* @Package com.qlzy.memberCenter.call.action
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-11-12 上午10:19:39
* @version V1.0  
*/
package com.qlzy.memberCenter.call.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alipay.common.AlipayConfig;
import com.alipay.common.AlipayNotify;
import com.alipay.common.AlipaySign;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.memberCenter.call.service.MemberCallService;
import com.qlzy.memberCenter.order.service.OrderService;
import com.qlzy.model.TradePayDeail;
import com.qlzy.util.BaseAction;

@Namespace("/")
@Action(value = "aliPayAction", results = {
		@Result(name = "paymentFail", location = "/admin/carts/paymentFail.jsp"),
		@Result(name = "paymenSuccess", location = "/admin/carts/paymenSuccess.jsp"),
		@Result(name = "alipayapi", location = "/admin/carts/alipayapi.jsp"),
		@Result(name = "success" ,location = "/admin/carts/alipayapi.jsp")
		
})
/**
 * @ClassName: LhPayAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-11-12 上午10:19:39
 */
public class AliPayAction extends BaseAction {
	Logger log = Logger.getLogger(this.getClass());
	@Resource
	private MemberCallService memberCallService;
	@Resource
	private OrderService orderService;
	
	private TradePayDeail tradePayDeail =new TradePayDeail();
	private Map<String, String> sPara;
	/**
	* @ClassName: com.qlzy.memberCenter.call.actionLhPayAction.java
	* @Description: TODO(这里用一句话描述这个类的作用)
	* @author 周张豹
	* @date 2013-11-12 上午10:20:55
	*/
	private static final long serialVersionUID = 1L;
	public String goAlipayapi() {
		
		String payment_type = "1";
		String notify_url = ResourceUtil.getnotify_url();
		String return_url = ResourceUtil.getreturn_url();
		String out_trade_no = tradePayDeail.getOrderNum(); // 商户网站订单系统中唯一订单号，必填
		String subject = tradePayDeail.getOrderName();// 必填
		String total_fee = tradePayDeail.getTotalPrice().toString();// 必填
		String body = tradePayDeail.getOrderMsg();
		String show_url = tradePayDeail.getProductUrl(); 

		// 防钓鱼时间戳
		String anti_phishing_key = "";
		// 若要使用请调用类文件submit中的query_timestamp函数

		// 客户端的IP地址
		String exter_invoke_ip = "";
		// 非局域网的外网IP地址，如：221.0.0.1

		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_direct_pay_by_user");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("seller_email", AlipayConfig.seller_email);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", payment_type);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("return_url", return_url);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("body", body);
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("anti_phishing_key", anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
		
		Map<String, String> sPara = AlipaySign.paraFilter(sParaTemp);
		// 生成签名结果
		String mysign = AlipaySign.buildRequestMysign(sPara);
		tradePayDeail.setMysign(mysign);
		tradePayDeail.setSignType(AlipayConfig.sign_type);
		//更新这条数据的签名
		
		try {
			TradePayDeail tradeDeail =new TradePayDeail();
			tradeDeail.setId(tradePayDeail.getId());
			tradeDeail.setMysign(mysign);
			tradeDeail.setSignType(AlipayConfig.sign_type);
			orderService.updatePayDeail(tradeDeail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sPara.put("sign", mysign);
		sPara.put("sign_type", AlipayConfig.sign_type);
		request.setAttribute("sPara", sPara);
		return "alipayapi";
	}
	
	public void notifyUrl() throws IOException {
		log.info("来到了支付异步这里=============");
		PrintWriter pw = response.getWriter();
		String payType="0";
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			log.info("转换之前======"+valueStr);
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号
		String out_trade_no = "";
		//支付宝交易号
		String  trade_no = "";
		//交易状态
		String trade_status = "";
		try {
			 out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			 trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			 trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.info("转换出错 "+e);
			pw.write("fail");//请不要修改或删除
			pw.flush();
			pw.close();
			
		}
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		log.info(" 验证参数============"+params);
	log.info("验证的结果是=========="+AlipayNotify.verify(params));
		if(AlipayNotify.verify(params)){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			
			if(trade_status.equals("TRADE_FINISHED")){//交易完成
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
				
					
				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			} else if (trade_status.equals("TRADE_SUCCESS")){//支付成功
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
				// 修改销量
//				orderService.updateSaleQuantity(out_trade_no);
				//注意：
				//付款完成后，支付宝系统发送该交易状态通知
				//根据订单号查找订单信息 并更新相关信息
				log.info("开始更改订单状态==========");				
				orderService.updateOrderAndPayDeail(out_trade_no,trade_no,trade_status,payType);
				log.info("修改状态完成=====");

			}else{
				pw.write("fail");//请不要修改或删除
				pw.flush();
				pw.close();	
			}

			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
				
			pw.write("success");//请不要修改或删除
			pw.flush();
			pw.close();	
			//////////////////////////////////////////////////////////////////////////////////////////
		}else{//验证失败
			pw.write("fail");//请不要修改或删除
			pw.flush();
			pw.close();	
		}
		
	}
	public String doNotNeedSession_returnUrl() {
		String payType = "0";
		String orderId = "";
		Map<String,String> params = new HashMap<String,String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			try {
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				//logger.info("valueStr 转换出错"+e);
				e.printStackTrace();
			}
			params.put(name, valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号
		String out_trade_no = "";
		//支付宝交易号
		String  trade_no = "";
		//交易状态
		String trade_status = "";
		try {
			 out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			 trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			 trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.info("转换出错"+e);
			return "paymentFail";
		}

		

		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		request.setAttribute("orderNum", out_trade_no);
		orderId = orderService.gainOrdersByOrderNum(out_trade_no);
		request.setAttribute("orderId", orderId);
		//计算得出通知验证结果
		boolean verify_result = AlipayNotify.verify(params);
		log.info("同步方法里验证结果======"+verify_result);
		if(verify_result){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
			}else if(trade_status.equals("TRADE_SUCCESS")){
				// 修改销量
//				orderService.updateSaleQuantity(out_trade_no);
//			log.info("来到了同步方法里，修改状态开始======");
				orderService.updateOrderAndPayDeail(out_trade_no,trade_no,trade_status,payType);
				//orderService.orderFanxian(out_trade_no);
//				log.info("来到了同步方法里，修改状态j结束======");
				
			}else{
				return "paymentFail";
			}
			
			//该页面可做页面美工编辑
			System.out.println("验证成功<br />");
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
			//map.put("orderId", orderId);
			return "paymenSuccess";
			//////////////////////////////////////////////////////////////////////////////////////////
		}else{
			//该页面可做页面美工编辑
			System.out.println("验证失败");
			return "paymentFail";
		}
		
	}
	
	public TradePayDeail getTradePayDeail() {
		return tradePayDeail;
	}
	public void setTradePayDeail(TradePayDeail tradePayDeail) {
		this.tradePayDeail = tradePayDeail;
	}
	public Map<String, String> getsPara() {
		return sPara;
	}
	public void setsPara(Map<String, String> sPara) {
		this.sPara = sPara;
	}
	
	
}
