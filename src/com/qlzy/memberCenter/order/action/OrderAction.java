/**  
* @Title: OrderAction.java
* @Package com.qlzy.memberCenter.order.action
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-9-23 上午11:03:47
* @version V1.0  
*/
package com.qlzy.memberCenter.order.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.qlzy.common.util.PcOrWap;
import com.qlzy.mainPage.indexGoods.service.DictionaryService;
import com.qlzy.mainPage.login.service.MemberService;
import com.qlzy.memberCenter.person.appraise.service.AppraiseService;
import com.qlzy.memberCenter.person.perinfo.service.PersonalInfoService;
import com.qlzy.model.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.ecc.tool.Signature;
import com.qlzy.common.tools.Arith;
import com.qlzy.common.tools.MD5;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.common.util.UtilsHttp;
import com.qlzy.mainPage.company.service.CompanyService;
import com.qlzy.mainPage.login.service.LoginService;
import com.qlzy.memberCenter.call.service.MemberCallService;
import com.qlzy.memberCenter.goods.service.GoodsService;
import com.qlzy.memberCenter.order.service.OrderService;
import com.qlzy.memberCenter.statistics.service.StatisticsService;
import com.qlzy.pojo.Json;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;

/**
 * @ClassName: OrderAction
 * @Description: TODO(会员中心处理订单的主类)
 * @author 周张豹
 * @date 2013-9-23 上午11:03:47
 */
@Namespace("/")
@Action(value = "orderAction", results = {
		@Result(name = "toCommentWap", location = "/wap/person/shangpingPingjia.jsp"),
		@Result(name = "pingJiaStatusWap", location = "/wap/person/pingJiaStatus.jsp"),
		@Result(name = "toComment", location = "/memberCenter/person/orders/commentNew.jsp"),
		@Result(name = "toHuiyuanzhongxin", location = "/memberCenter/person/orders/huiyuanzhongxinNew.jsp"),
		@Result(name = "toHuiyuanzhongxinWap", location = "/wap/person/huiyuanzhongxinNew.jsp"),
		@Result(name = "memberOrders", location = "/memberCenter/person/orders/ordersNew.jsp"),
		@Result(name = "memberOrdersWap", location = "/wap/person/myOrders.jsp"),
		@Result(name = "memberChOrders", location = "/memberCenter/person/orders/memberchorders.jsp"),
		@Result(name = "chOrders", location = "/memberCenter/person/orders/chorders.jsp"),
		@Result(name = "memberChTjOrders", location = "/memberCenter/person/orders/chorderstj.jsp"),
		@Result(name = "companySellOrders", location = "/memberCenter/company/orders/sellOrders.jsp"),
		@Result(name = "companyChOrders", location = "/memberCenter/company/orders/sellChOrders.jsp"),
		@Result(name = "companySellOrdersItem", location = "/memberCenter/company/orders/sellOrderItem.jsp"),
		@Result(name = "companySellChOrdersItem", location = "/memberCenter/company/orders/sellChOrderItem.jsp"),
		@Result(name = "receiveGoods", type="redirect", location = "orderAction!gainOrders.action"),
		@Result(name = "toCompanySellOrderItem", type="redirect", location = "/person/order/sellOrderItem/${id}.html"),
		@Result(name = "orderDetail", location = "/memberCenter/person/orders/orderDetailNew.jsp"),
		@Result(name = "orderDetailWap", location = "/wap/order/orderDetail.jsp"),
		@Result(name = "logistics", location = "/memberCenter/person/orders/logistics.jsp"),
		@Result(name = "login_hf", location = "/")
		})
public class OrderAction extends BaseAction{
	private static final Logger logger = Logger.getLogger(OrderAction.class);
	/**
	* @ClassName: com.qlzy.memberCenter.order.actionOrderAction.java
	* @Description: TODO(这里用一句话描述这个类的作用)
	* @author 周张豹
	* @date 2013-9-23 上午11:17:56
	*/
	private static final long serialVersionUID = 1L;
	@Resource
	private AppraiseService  appraiseService;
	@Resource
	private OrderService orderService;
	@Resource
	private LoginService loginService;
	@Resource
	private StatisticsService statisticsService;// 统计信息接口类
	@Resource
	private CompanyService companyService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private MemberCallService memberCallService;
	@Resource
	private MemberService memberService;
	@Resource
	private DictionaryService dictionaryService;
	private List<Order> orderList = new ArrayList<Order>();
	private List<Order> orderList2 = new ArrayList<Order>();
	private SessionInfo sessionInfo = new SessionInfo();
	private Date startTime ;
	private Date endTime;
	private String payPassword;//支付密码
	private Order order;
	private OrderItem orderItem;
	private List<OrderItem> orderItems;
	private OrderReturn orderReturn;
	private StatisticsInfo orderStatisticsInfo;// 订单统计
	private String status;
	private String payStatus;
	private String shipStatus;
	private String disabled;
	private String id ;
	private String type; 
	private String password;
	private String orderItemId;
	private String bcvalue;
	private PayDeal paydeal;
	private String jylx;
	private String sjId;
	private String khId;
	//分销比例信息
	Map<String,Double> yijibiliMap = new HashMap<>();
	Map<String,Double> erjibiliMap = new HashMap<>();
	private String wuliu;
	private String messagew;
	private String orderId;
	private String orderNum;

	/**
	 * 修改订单状态
	 */
	public void changeOrderStatus(){
		String result = "";
		status = request.getParameter("status");
		payStatus = request.getParameter("payStatus");
		shipStatus = request.getParameter("shipStatus");
		disabled = request.getParameter("disabled");
		id = request.getParameter("orderId");
		order = new Order();
		order.setId(id);
		order.setStatus(status);
		order.setPayStatus(payStatus);
		order.setShipStatus(shipStatus);
		order.setDisabled(disabled);
		int n = orderService.updateOrderByOrderId(order);
		if(n>0){
			result = "ok";
		}
		writeJson(result);
	}

	/**
	 * 会员中心
	 * @Title: gainOrders
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 周张豹
	 */
	public String toHuiyuanzhongxin(){
		try {
			sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			if(null == sessionInfo){
				return "login_hf";
			}
			QlDict dict = dictionaryService.gainByType("FirstDistributionRatio");
			session.put("yijibili",dict.getValue());
			dict = dictionaryService.gainByType("SedDistributionRatio");
			session.put("erjibili",dict.getValue());
			//查询会员信息
			Member mm = memberService.selectKey(sessionInfo.getUserId());
			request.setAttribute("member", mm);
			MemberCollect memberCollect = new MemberCollect();
			memberCollect.setType("goods");
			memberCollect.setUserId(sessionInfo.getUserId());
			List<MemberCollect> memberCollectList = memberCallService.gainGoodsCollect(memberCollect);
			request.setAttribute("memberCollectList",memberCollectList);

			Map<String, Object> map = new HashMap<String, Object>();
			Pagination pagination = definationPagination(request);
			// 设置每页显示几条数据
			pagination.setRows(8L);
			map.put("page", (pagination.getPage()-1)* pagination.getRows());
			map.put("rows", pagination.getRows());
			map.put("userId", sessionInfo.getUserId());
			map.put("userType", sessionInfo.getUserType());
			if (startTime != null && !"".equals(startTime)) {
				map.put("startTime", startTime);
			}
			if (endTime != null && !"".equals(endTime)) {
				map.put("endTime", endTime);
			}
			if ( null != shipStatus && !"-1".equals(shipStatus)) {
				map.put("shipStatus", shipStatus);
			}

			map.put("orderType", "0");
			map.put("orderNum", orderNum);
			pagination.setTotalCount(orderService.gainOrdersByUserIdGetLong(map));//rComRecommendService.gainRegionsComRecommendCountByArea(map));
			//所有订单
			orderList = orderService.gainOrdersByUserIdGetList(map);
			//已付款订单
			map.put("payStatus", "1");
			List<Order> oList = orderService.gainOrdersByUserIdGetList(map);
			Double total = 0.0;
			for(Order o : oList){
				total += o.getTotalCost().doubleValue();
			}
			request.setAttribute("total",total);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (startTime != null) {
				request.setAttribute("startTimeStr", sf.format(startTime));
			}
			if (endTime != null) {
				request.setAttribute("endTimeStr", sf.format(endTime));
			}
			request.setAttribute("orderList", orderList);
			request.setAttribute("pagination", pagination);
			request.setAttribute("payStatus", payStatus);
			request.setAttribute("shipStatus", shipStatus);
			//request.setAttribute("orderNum", orderNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  PcOrWap.isPc(request,"toHuiyuanzhongxin");
	}






	/**
	 * 查询个人会员下购买的订单信息
	* @Title: gainOrders
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public String gainOrders(){
		try {
			sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			if(null == sessionInfo){
				return "login_hf";
			}
			request.setAttribute("sessionInfo",sessionInfo);
			status = request.getParameter("status");
			Map<String, Object> map = new HashMap<String, Object>();
			Pagination pagination = definationPagination(request);
			// 设置每页显示几条数据
			pagination.setRows(8L);
			map.put("page", (pagination.getPage()-1)* pagination.getRows());
			map.put("rows", pagination.getRows());
			map.put("status",status);
			map.put("userId", sessionInfo.getUserId());
			map.put("userType", sessionInfo.getUserType());
			String orderNum = request.getParameter("orderNum");
			String goodsName = request.getParameter("goodsName");
			String shipName = request.getParameter("shipName");
			//String zhuangtai = request.getParameter("zhuangtai");
			String qixian = request.getParameter("qixian");
			map.put("orderNum",orderNum);
			map.put("shipName",shipName);
			//map.put("status",zhuangtai);
			map.put("qixian",qixian);
			map.put("goodsName",goodsName);
			if (startTime != null && !"".equals(startTime)) {
				map.put("startTime", startTime);
			}
			if (endTime != null && !"".equals(endTime)) {
				map.put("endTime", endTime);
			}
			
			if ( null != payStatus && !"-1".equals(payStatus)) {
				map.put("payStatus", payStatus);
			}
			if ( null != shipStatus && !"-1".equals(shipStatus)) {
				map.put("shipStatus", shipStatus);
			}
			
			map.put("orderType", "0");
			map.put("orderNum", orderNum);
			
			pagination.setTotalCount(orderService.gainOrdersByUserIdGetLong(map));//rComRecommendService.gainRegionsComRecommendCountByArea(map));
			orderList = orderService.gainOrdersByUserIdGetList(map);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (startTime != null) {
				request.setAttribute("startTimeStr", sf.format(startTime));
			}
			if (endTime != null) {
				request.setAttribute("endTimeStr", sf.format(endTime));
			}
			request.setAttribute("orderList", orderList);
			request.setAttribute("pagination", pagination);
			request.setAttribute("payStatus", payStatus);
			request.setAttribute("shipStatus", shipStatus);
			//request.setAttribute("orderNum", orderNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  PcOrWap.isPc(request,"memberOrders");
	}
	
	/**
	 * 查看详情
	 */
	
	public String gainChOrders(){
		try {
			sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			Map<String, Object> map = new HashMap<String, Object>();
			Pagination pagination = definationPagination(request);
			// 设置每页显示几条数据
			pagination.setRows(8L);
			map.put("page", pagination.getPage());
			map.put("rows", pagination.getRows());
			map.put("userId", sessionInfo.getUserId());
			map.put("userType", sessionInfo.getUserType());
			if (startTime != null && !"".equals(startTime)) {
				map.put("startTime", startTime);
			}
			if (endTime != null && !"".equals(endTime)) {
				map.put("endTime", endTime);
			}
			
			if ( null !=payStatus && !"-1".equals(payStatus)) {
				map.put("payStatus", payStatus);
			}
			if ( null !=shipStatus && !"-1".equals(shipStatus)) {
				map.put("shipStatus", shipStatus);
			}
			map.put("orderType", "1");
			
			if("1".equals(jylx)){
				if(!"".equals(khId) && null != khId) {//我销售给这家的信息
					map.put("memberId", khId);
					request.setAttribute("khId", khId);
				}
				pagination.setTotalCount(orderService.gainOrdersByCompanyIdGetLongCh(map));//rComRecommendService.gainRegionsComRecommendCountByArea(map));
				orderList = orderService.gainOrdersByCompanyIdGetListCh(map);
			}else{
				if(!"".equals(sjId) && null != sjId) {//我够买的，并且商家是这家的信息
					map.put("companyId", sjId);
					request.setAttribute("sjId", sjId);
				}
				pagination.setTotalCount(orderService.gainOrdersByUserIdGetLong(map));//rComRecommendService.gainRegionsComRecommendCountByArea(map));
				orderList = orderService.gainOrdersByUserIdGetList(map);
				// 订单统计
				orderStatisticsInfo = statisticsService.gainOrderStatisticsByTime("0","1", sessionInfo);
			}
			
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (startTime != null) {
				request.setAttribute("startTimeStr", sf.format(startTime));
			}
			if (endTime != null) {
				request.setAttribute("endTimeStr", sf.format(endTime));
			}
			
			request.setAttribute("pagination", pagination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if("1".equals(jylx)){
			return "companyChOrders";
		}else{
			
			return "memberChOrders";
		}
		
		
	}
	
	public String gainChOrdersTj(){
		try {
			sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			Map<String, Object> map = new HashMap<String, Object>();
			//Pagination pagination = definationPagination(request);
			// 设置每页显示几条数据
			//pagination.setRows(8L);
			//map.put("page", pagination.getPage());
			//map.put("rows", pagination.getRows());
			map.put("userId", sessionInfo.getUserId());
			map.put("userType", sessionInfo.getUserType());
			if (startTime != null && !"".equals(startTime)) {
				map.put("startTime", startTime);
			}
			if (endTime != null && !"".equals(endTime)) {
				map.put("endTime", endTime);
			}
			
			if ( null !=payStatus && !"-1".equals(payStatus)) {
				map.put("payStatus", payStatus);
			}
			if ( null !=shipStatus && !"-1".equals(shipStatus)) {
				map.put("shipStatus", shipStatus);
			}
			
			map.put("orderType", "1");
			if("1".equals(jylx)){
				//pagination.setTotalCount(orderService.gainOrdersByCompanyIdGetLongxs(map));//rComRecommendService.gainRegionsComRecommendCountByArea(map));
				orderList = orderService.gainOrdersByCompanyIdGetListxs(map);
			}else if("0".equals(jylx)){
				//pagination.setTotalCount(orderService.gainOrdersByCompanyIdGetLonggm(map));//rComRecommendService.gainRegionsComRecommendCountByArea(map));
				orderList2 = orderService.gainOrdersByCompanyIdGetListgm(map);
			}else{
				//pagination.setTotalCount(orderService.gainOrdersByCompanyIdGetLongxs(map));//rComRecommendService.gainRegionsComRecommendCountByArea(map));
				orderList = orderService.gainOrdersByCompanyIdGetListxs(map);
				//pagination.setTotalCount(orderService.gainOrdersByCompanyIdGetLonggm(map));//rComRecommendService.gainRegionsComRecommendCountByArea(map));
				orderList2 = orderService.gainOrdersByCompanyIdGetListgm(map);
			}
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userId", sessionInfo.getUserId());
			
			Double totalgm = 0.00;
			Double totalxs = 0.00;
			totalgm = orderService.gaintotalCostgm(paramMap);
			totalxs = orderService.gaintotalCostxs(paramMap);
			
			if(null == totalgm){
				totalgm = 0.00;
			}
			if(null == totalxs){
				totalxs = 0.00;
			}
			request.setAttribute("totalgm", totalgm);
			request.setAttribute("totalxs", totalxs);
			// 订单统计
			//orderStatisticsInfo = statisticsService.gainOrderStatisticsByTime("0","1", sessionInfo);
			
			//查询用户的担保信用
			Double guaranteePrice = 0.00;
			guaranteePrice = memberCallService.gainCompanyGuaranteePriceByCompanyId(sessionInfo
					.getUserId());
			if(null == guaranteePrice){
				guaranteePrice = 0.00;
			}
			
			request.setAttribute("guaranteePrice", guaranteePrice);
			
			BigDecimal b1 = new BigDecimal(guaranteePrice.toString());
			BigDecimal b2 = new BigDecimal(totalgm.toString());
			Double totalGuaranteePrice = b1.add(b2).doubleValue();
			
			request.setAttribute("totalGuaranteePrice", totalGuaranteePrice);
			
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (startTime != null) {
				request.setAttribute("startTimeStr", sf.format(startTime));
			}
			if (endTime != null) {
				request.setAttribute("endTimeStr", sf.format(endTime));
			}
			
			//request.setAttribute("pagination", pagination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "memberChTjOrders";
	}

	public void receivingOrders(){
		String result = "";
		try {
			 Order order = orderService.gainOrderById(id);
			 order.setShipStatus("2");
			 orderService.updateOrderByOrderId(order);
			result = "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "error";
		}
		super.writeJson(result);

	}
	
	public void dropOrders(){
		String result = "";
		try {
			orderService.deleteByPrimaryKey(id);
			result = "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "error";
		}
		super.writeJson(result);

	}
	public void dropCompanyOrders(){
		String result = "";
		try {
			orderService.deleteByPrimaryKey(id);
			result = "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "error";
		}
		super.writeJson(result);

	}
	
	/**
	 * 企业出售订单信息
	* @Title: companySellOrders
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public String companySellOrders(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		// 设置每页显示几条数据
		pagination.setRows(8L);
		map.put("page", (pagination.getPage()-1)* pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("userId", sessionInfo.getUserId());
		if (startTime != null && !"".equals(startTime)) {
			map.put("startTime", startTime);
		}
		if (endTime != null && !"".equals(endTime)) {
			map.put("endTime", endTime);
		}
		
		if ( null !=payStatus && !"-1".equals(payStatus)) {
			map.put("payStatus", payStatus);
		}
		if ( null !=shipStatus && !"-1".equals(shipStatus)) {
			map.put("shipStatus", shipStatus);
		}
		map.put("orderType", "0");
		
		pagination.setTotalCount(orderService.gainOrdersByCompanyIdGetLong(map));//rComRecommendService.gainRegionsComRecommendCountByArea(map));
		orderList = orderService.gainOrdersByCompanyIdGetList(map);
		// 订单统计
		orderStatisticsInfo = statisticsService.gainOrderStatisticsByTime("0","0", sessionInfo);
		logger.error("come on baby3");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (startTime != null) {
			request.setAttribute("startTimeStr", sf.format(startTime));
		}
		if (endTime != null) {
			request.setAttribute("endTimeStr", sf.format(endTime));
		}
		
		request.setAttribute("pagination", pagination);
		return "companySellOrders";
	}
	
	/**
	 * 企业查看订单详情
	* @Title: companySellOrdersItem
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public String companySellChOrderItem(){
		orderItems = orderService.gainOrderItemsByOrderId(id);
		 OrderItem orderItem= new OrderItem();
		 List<OrderItem> itemsList = new ArrayList<OrderItem>();
			if(null != orderItems && orderItems.size() > 0){
				for(OrderItem item:orderItems){
					String goodspics =  goodsService.gainGoodsPicById(item.getGoodsId());
					orderItem = item;
					if(null != goodspics && goodspics.length() > 0){
						orderItem.setGoodsPic(goodspics.split(",")[0]);
					}else{
						orderItem.setGoodsPic("/images/360-270zwpic.gif");
					}
					itemsList.add(orderItem);
				}
			}
		
		orderItems = itemsList;
		order = orderService.gainOrderById(id);
		return "companySellChOrdersItem";
	}
	public String companySellOrderItem(){
		orderItems = orderService.gainOrderItemsByOrderId(id);
		orderReturn = orderService.gainOrderReturnById(id);
		if(null != orderItems && orderItems.size() > 0){
			for(OrderItem item:orderItems){
				String goodspics =  goodsService.gainGoodsPicById(item.getGoodsId());
				if(null != goodspics && goodspics.length() > 0){
					item.setGoodsPic(goodspics.split(",")[0]);
				}else{
					item.setGoodsPic("/images/360-270zwpic.gif");
				}
				
			}
		}
		order = orderService.gainOrderById(id);
		return "companySellOrdersItem";
	}
	public String testpost(String merId, String dealId, Double dealDiscount, String dealSignure) throws IOException{
		  URL url = new URL("http://i.chinaecpay.com/merchant_remote_change_price.html");  
	        URLConnection connection = url.openConnection();  
	        connection.setDoOutput(true);  
	        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "8859_1");  
	        out.write("merId="+merId+"&dealId="+dealId+"&dealDiscount="+dealDiscount+"&dealSignure="+dealSignure+""); // 向页面传递数据。post的关键所在！  
	        out.flush();  
	        out.close();  
	        // 一旦发送成功，用以下方法就可以得到服务器的回应：  
	        String sCurrentLine;  
	        String sTotalString;  
	        sCurrentLine = "";  
	        sTotalString = "";  
	        InputStream l_urlStream;  
	        l_urlStream = connection.getInputStream();  
	        // 传说中的三层包装阿！  
	        BufferedReader l_reader = new BufferedReader(new InputStreamReader(  
	                l_urlStream));  
	        while ((sCurrentLine = l_reader.readLine()) != null) {  
	            sTotalString += sCurrentLine + "\r\n";  
	  
	        }  
	        return sTotalString;
	       // System.out.println(sTotalString);  
	}
	public void sellOrderChItemModifyPrice(){
		String result = "";
		String orderId = "";
		Double oldPrice = 0.00;
		Double oldTotalCost = 0.00;
		Double newTotalCost = 0.00;
		BigDecimal totalCost = BigDecimal.ZERO ;
		Double sendPrice = 0.00;
		OrderItem orderItem = orderService.selectByOrderItemId(orderItemId);
		try {
			if(null != orderItem){
				oldPrice = orderItem.getDealPrice().doubleValue();
				orderId = orderItem.getOrderId();
				orderItem.setDealPrice(new BigDecimal(bcvalue));
				orderItem.setNums(orderItem.getNums());
				orderItem.setAmount(new BigDecimal(Double.parseDouble(bcvalue)*orderItem.getNums()));
				oldTotalCost = oldPrice * orderItem.getNums();
				newTotalCost = Double.parseDouble(bcvalue)*orderItem.getNums();
				BigDecimal b1 = new BigDecimal(newTotalCost.toString());
				BigDecimal b2 = new BigDecimal(oldTotalCost.toString());
				sendPrice = b1.subtract(b2).doubleValue();
				orderItem.setMemberlvRedceMoney(new BigDecimal(sendPrice));
				
				Order order = orderService.gainOrderById(orderId);
				if(null != order){
					BigDecimal orderOld = new BigDecimal(order.getTotalCost().toString());
					BigDecimal orderSend = new BigDecimal(sendPrice.toString());
					totalCost = orderOld.add(orderSend);
					order.setTotalCost(totalCost);
					
					Company company = companyService.gainCompanyById(order.getMemberId());
//					BigDecimal guaranteePriceOld = new BigDecimal(company.getGuaranteePrice().toString());
//					Double guaranteePrice = guaranteePriceOld.subtract(orderSend).doubleValue();
//					company.setGuaranteePrice(guaranteePrice);
					companyService.updateByPrimaryKeySelective(company);
					orderService.updateItemByOrderItemId(orderItem);
					orderService.updateOrderByOrderId(order);
					result = "ok";
				}
				
				
			}
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			result = "no";
		
		}
		super.writeJson(result);
	}
	/***
	 * 修改物流费用
	 */
	public void sellOrderItemModifyCarr(){
		String result = "";
		Order order = orderService.gainOrderById(id);
		Double cj = Arith.sub(order.getCarriage().doubleValue(), Double.parseDouble(bcvalue));

		BigDecimal totalCost = order.getTotalCost().subtract(new BigDecimal(cj));
		order.setCarriage(new BigDecimal(bcvalue));
		order.setTotalCost(totalCost);
		try {
			orderService.updateOrderByOrderId(order);
			result = "ok";
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			result = "no";
			logger.info(e1.getMessage());
		}
		TradePayDeail tradeDeail = memberCallService.gainPObyOrderNum(order.getOrderNum()); 
		if(null != tradeDeail){
			tradeDeail.setTotalPrice(totalCost.doubleValue());
			try {
				memberCallService.updateTradePayDeail(tradeDeail);
				result = "ok";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				result = "no";
				logger.info(e.getMessage());
			}
			
		}else{
			result = "ok";
		}
		
		
		
	}
	public void sellOrderItemModifyPrice(){
		String result = "";
		String orderId = "";
		BigDecimal oldPrice = BigDecimal.ZERO;
		BigDecimal oldTotalCost = BigDecimal.ZERO;
		BigDecimal newTotalCost = BigDecimal.ZERO;
		BigDecimal totalCost = BigDecimal.ZERO;
		Double sendPrice = 0.00;
		OrderItem orderItem = orderService.selectByOrderItemId(orderItemId);
		try {
			if(null != orderItem){
				oldPrice = orderItem.getDealPrice();
				orderId = orderItem.getOrderId();
				orderItem.setDealPrice(new BigDecimal(bcvalue));
				orderItem.setNums(orderItem.getNums());
				orderItem.setAmount(new BigDecimal(Double.parseDouble(bcvalue)*orderItem.getNums()));
				oldTotalCost = oldPrice.multiply(new BigDecimal(orderItem.getNums()));
				newTotalCost = new BigDecimal(bcvalue).multiply(new BigDecimal(orderItem.getNums()));
				BigDecimal b1 = new BigDecimal(newTotalCost.toString());
				BigDecimal b2 = new BigDecimal(oldTotalCost.toString());
				sendPrice = b1.subtract(b2).doubleValue();
				orderItem.setMemberlvRedceMoney(new BigDecimal(sendPrice));
				
				Order order = orderService.gainOrderById(orderId);
				if(null != order){
					BigDecimal orderOld = new BigDecimal(order.getTotalCost().toString());
					BigDecimal orderSend = new BigDecimal(sendPrice.toString());
					totalCost = orderOld.add(orderSend);
					order.setTotalCost(totalCost);
					
					PayDeal payDeal = memberCallService.selectByOrderNum(order.getOrderNum());
					if(null != payDeal){
						String fillFee =ResourceUtil.getLhMerId()+ResourceUtil.getLhKey()+(new java.text.SimpleDateFormat("yyyyMMdd")).format(new Date()); 
						String qlSignure = Signature.fillSignure(fillFee);
						String lhResult = "";
						try {
							 lhResult = this.testpost(ResourceUtil.getLhMerId(),payDeal.getDealId(),orderItem.getMemberlvRedceMoney().doubleValue(),qlSignure).trim();;
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							lhResult = "no";
							
							//e.printStackTrace();
						}
						if("REMOTE_CHANGE_PRICE_SUCCESS".equals(lhResult) || "REMOTE_CHANGE_PRICE_SUCCESS" == lhResult){
							payDeal.setUpdatePriceResult(lhResult);
							payDeal.setUpdatetime(new Date());
							payDeal.setDealFee(order.getTotalCost().doubleValue());
							memberCallService.updatePayDealPrice(payDeal);
							orderService.updateItemByOrderItemId(orderItem);
							orderService.updateOrderByOrderId(order);
							lhResult = "ok";
						}else if("GOOD_DISCOUNT_PRICE_LESS_THAN_DEAL_FEE".equals(lhResult) || "GOOD_DISCOUNT_PRICE_LESS_THAN_DEAL_FEE" == lhResult){
							payDeal.setUpdatePriceResult(lhResult);
							payDeal.setUpdatetime(new Date());
							memberCallService.updatePayDealPrice(payDeal);
							lhResult = "error";
						}else{
							payDeal.setUpdatePriceResult(lhResult);
							payDeal.setUpdatetime(new Date());
							memberCallService.updatePayDealPrice(payDeal);
							lhResult = "no";
						}
						
						result = lhResult;
					}else{
						orderService.updateItemByOrderItemId(orderItem);
						orderService.updateOrderByOrderId(order);
						result = "ok";
					}
				}
				
				
			}
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			result = "no";
		
		}
		super.writeJson(result);
	}
	
	/***
	 * 修改物流单号
	 */
	public void updateLogisticsNum(){
		String result = "";
		Order order = orderService.gainOrderById(id);
		String logisticsNum = request.getParameter("logisticsNum");
		order.setLogisticsNum(logisticsNum);
		try {
			orderService.updateOrderByOrderId(order);
			result = "ok";
		} catch (Exception e) {
			result = "no";
		}
		super.writeJson(result);
	}
	
	/***
	 * 修改物流公司
	 */
	public void updateLogisticsName(){
		String result = "";
		Order order = orderService.gainOrderById(id);
		String logisticsName = request.getParameter("logisticsName");
		order.setLogisticsName(logisticsName);
		try {
			orderService.updateOrderByOrderId(order);
			result = "ok";
		} catch (Exception e) {
			result = "no";
		}
		super.writeJson(result);
	}
	
	/**
	 * 确认收货<br>
	* @Title: receiveGoods
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public String receiveGoods(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
//		String userPayPwd = loginService.gainUserPayPasswordById(sessionInfo.getUserId(), sessionInfo.getUserType());
//		if (userPayPwd != null && payPassword != null && userPayPwd.equals(MD5.encrypt(payPassword))) {
//			
//		}
		String orderId = request.getParameter("orderId");
		order = orderService.gainOrderById(orderId);
		orderService.receiveAndFenxiao(order,sessionInfo.getUserId());
		return "receiveGoods";
	}
	
	/**
	 * 用户申请退款退货
	* @Title: returnGoods
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public void returnGoods(){
		orderId = request.getParameter("orderId");
		String cause = request.getParameter("textarea");
		order = orderService.gainOrderById(orderId);
		orderReturn = new OrderReturn();
		orderReturn.setReturnMoney(order.getTotalCost());
		orderReturn.setOrderId(orderId);
		orderReturn.setId(ToolsUtil.getUUID());
		orderReturn.setCause(cause);
		orderReturn.setCreateBy(order.getMemberId());
		orderReturn.setCreateTime(new Date());
		orderReturn.setIsdelivery(order.getShipStatus());
		orderService.returnGoods(orderReturn);
	}
	
	/**
	 * 卖家同意、拒绝退款
	* @Title: returnPay
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public void returnPay(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Json json = new Json();
		Company company = companyService.selectcCompanyById(sessionInfo.getUserId());
		if (company != null && null != company.getPayPassword() && MD5.encrypt(password).equals(company.getPayPassword())) {
			/**
			 * 商家支付密码验证成功
			 */
			orderService.returnPay(order.getId(),type);
			json.setSuccess(true);
			json.setMsg("退款成功");	
		}else if (company != null && null !=company.getPayPassword()) {
			json.setSuccess(false);
			json.setMsg("支付密码错误");
		} else {
			json.setSuccess(false);
			json.setMsg("请先设置支付密码！");
		}
		super.writeJson(json);
	}
	
	public void chakanwuliu(){
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "http://api.jisuapi.com/express/query";
		map.put("appkey", "d68ec81a2817d74e");
		map.put("type", "auto");
		map.put("number", wuliu);
		messagew = UtilsHttp.doGet(url, map, "UTF-8");
		writeJson(messagew);
	}
	
	public String logisticsDetail(){
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "http://api.jisuapi.com/express/query";
		map.put("appkey", "d68ec81a2817d74e");
		map.put("type", "auto");
		map.put("number", wuliu);
		messagew = UtilsHttp.doGet(url, map, "UTF-8");
			
		request.setAttribute("messagew", messagew);
		return "logistics";
	}
	
	/**
	 * 卖家确认收到退货
	* @Title: rejectReturnPay
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public void returnShip(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Json json = new Json();
		Company company = companyService.selectcCompanyById(sessionInfo.getUserId());
		if (company != null && null != company.getPayPassword() && MD5.encrypt(password).equals(company.getPayPassword())) {
			/**
			 * 商家支付密码验证成功
			 */
			orderService.returnShip(order.getId());
			json.setSuccess(true);
			json.setMsg("退货成功");	
		}else if (company != null && null !=company.getPayPassword()) {
			json.setSuccess(false);
			json.setMsg("支付密码错误");
		} else {
			json.setSuccess(false);
			json.setMsg("请先设置支付密码！");
		}
		super.writeJson(json);
	}
	
	/**
	 * 卖家发货
	* @Title: deliverShip
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author 周张豹
	 */
	public String deliverShip(){
		if (StringUtils.isNotEmpty(orderItemId)) {
			orderService.compayDeliverShip(order, orderItemId);
		}
		id=order.getId();
		return "toCompanySellOrderItem";
	}
	
	/**
	 * 我的订单详情页
	 * @param
	 * @return
	 */
	public String gainOrderDetail(){
		try {
//			order = orderService.gainOrderById(orderId);
//			orderItems = orderService.gainOrderItemsByOrderId(orderId);
			id = request.getParameter("id");
			order = orderService.gainOrderById(id);
			orderItems = orderService.gainOrderItemsByOrderId(id);
			request.setAttribute("order",order);
			request.setAttribute("orderItems",orderItems);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PcOrWap.isPc(request,"orderDetail");
	}

	/**
	 * 显示订单评价状态页面
	 * @return
	 */
	public String pingJiaStatus(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(null == sessionInfo){
			return "login_hf";
		}
		// 会员信息
		Member member = memberService.selectKey(sessionInfo.getUserId());
		String appraise = request.getParameter("appraise");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", member.getId());
		Pagination pagination = definationPagination(request);
		// 设置每页显示几条数据
		pagination.setRows(8L);
		map.put("page", (pagination.getPage()-1)* pagination.getRows());
		map.put("rows", pagination.getRows());
		orderList = orderService.gainOrdersByUserIdGetList(map);
		orderItems = new ArrayList<OrderItem>();
		for(Order o : orderList){
			List<OrderItem> items = orderService.gainOrderItemsByOrderId(o.getId());
			for(OrderItem oi : items){
				if((oi.getAppraise()).equals(appraise)){
					orderItems.add(oi);
				}
			}
 		}
		request.setAttribute("pagination", pagination);
		request.setAttribute("appraise",appraise);
 		request.setAttribute("orderItems",orderItems);
		return  PcOrWap.isPc(request,"pingJiaStatus");
	}

	/**
	 * 订单评论
	 * @return
	 */
	public String gainComment(){
		Appraise appraise = new Appraise();
		try {
			String orderItemId = request.getParameter("orderItemId");
			orderItem = orderService.selectByOrderItemId(orderItemId);
			order = orderService.gainOrderById(orderItem.getOrderId());
			orderItems = orderService.gainOrderItemsByOrderId(order.getId());
			for(OrderItem item : orderItems){
				String goodsId = item.getGoodsId();
				appraise.setGoodsId(goodsId);
				appraise.setOrderId(order.getId());
				Appraise appraiseNew = appraiseService.gainByOrderIdAndGoodsId(appraise);
				if(appraiseNew != null && !("").equals(appraiseNew)) {
					item.setAppraiseContent(appraiseNew.getContent());
					item.setAppraiseSincerity(appraiseNew.getSincerity());
				}
			}
			request.setAttribute("order",order);
			request.setAttribute("orderItems",orderItems);
			orderItem = new OrderItem();
			orderItem.setId(orderItemId);
			List<OrderItem> orItems = orderService.gainByOrderId(orderItem);
			OrderItem orItem = orItems.get(0);
			request.setAttribute("orItem", orItem);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return  PcOrWap.isPc(request,"toComment");
	}

	/**
	 * 添加评论
	 */
	public void changeAppraise(){
		String result="";
		String itemId = request.getParameter("id");
		String content = request.getParameter("content");
		String sincerity = request.getParameter("num");
		orderItem = orderService.selectByOrderItemId(itemId);
		orderItem.setAppraise("1");
		orderService.updateAppraiseById(orderItem);
		order = orderService.gainOrderById(orderItem.getOrderId());
		if("0".equals(order.getSaleType())){
			order.setSaleType("1");
			orderService.updateOrderByOrderId(order);
		}
		Appraise appraise = new Appraise();
		appraise.setId(ToolsUtil.getUUID());
		appraise.setGoodsId(orderItem.getGoodsId());
		appraise.setCompanyId(orderItem.getCompanyId());
		appraise.setMemberId(order.getMemberId());
		appraise.setOrderId(order.getId());
		appraise.setSincerity(Integer.parseInt(sincerity));
		appraise.setContent(content);
		appraise.setCreatetime(new Date());
		int n = appraiseService.insertAppraise(appraise);
		if(n>0){
			result = "ok";
		}
		writeJson(result);
	}
	
	/**
	 * @return the orderList
	 */
	public List<Order> getOrderList() {
		return orderList;
	}

	/**
	 * @param orderList the orderList to set
	 */
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the payPassword
	 */
	public String getPayPassword() {
		return payPassword;
	}

	/**
	 * @param payPassword the payPassword to set
	 */
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
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

	/**
	 * @return the orderStatisticsInfo
	 */
	public StatisticsInfo getOrderStatisticsInfo() {
		return orderStatisticsInfo;
	}

	/**
	 * @param orderStatisticsInfo the orderStatisticsInfo to set
	 */
	public void setOrderStatisticsInfo(StatisticsInfo orderStatisticsInfo) {
		this.orderStatisticsInfo = orderStatisticsInfo;
	}

	/**
	 * @return the payStatus
	 */
	public String getPayStatus() {
		return payStatus;
	}

	/**
	 * @param payStatus the payStatus to set
	 */
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	/**
	 * @return the shipStatus
	 */
	public String getShipStatus() {
		return shipStatus;
	}

	/**
	 * @param shipStatus the shipStatus to set
	 */
	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the orderItem
	 */
	public OrderItem getOrderItem() {
		return orderItem;
	}

	/**
	 * @param orderItem the orderItem to set
	 */
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * @return the orderReturn
	 */
	public OrderReturn getOrderReturn() {
		return orderReturn;
	}

	/**
	 * @param orderReturn the orderReturn to set
	 */
	public void setOrderReturn(OrderReturn orderReturn) {
		this.orderReturn = orderReturn;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	public String getBcvalue() {
		return bcvalue;
	}
	public void setBcvalue(String bcvalue) {
		this.bcvalue = bcvalue;
	}
	public PayDeal getPaydeal() {
		return paydeal;
	}
	public void setPaydeal(PayDeal paydeal) {
		this.paydeal = paydeal;
	}
	public String getJylx() {
		return jylx;
	}
	public void setJylx(String jylx) {
		this.jylx = jylx;
	}
	public String getSjId() {
		return sjId;
	}
	public void setSjId(String sjId) {
		this.sjId = sjId;
	}
	public String getKhId() {
		return khId;
	}
	public void setKhId(String khId) {
		this.khId = khId;
	}

	public List<Order> getOrderList2() {
		return orderList2;
	}

	public void setOrderList2(List<Order> orderList2) {
		this.orderList2 = orderList2;
	}

	public String getWuliu() {
		return wuliu;
	}

	public void setWuliu(String wuliu) {
		this.wuliu = wuliu;
	}

	public String getMessagew() {
		return messagew;
	}

	public void setMessagew(String messagew) {
		this.messagew = messagew;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}



	
	
	
}
