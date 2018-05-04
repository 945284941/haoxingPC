/**  
 * @Title: OrderUtil.java
 * @Package com.qlzy.common.tools
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 周张豹  
 * @date 2013-11-11 上午11:21:39
 * @version V1.0  
 */
package com.qlzy.common.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecc.tool.Common;
import com.qlzy.pojo.DeliverPojo;
import com.qlzy.pojo.LhPayPojo;


/**
 * 有关订单的工具类
* @ClassName: OrderUtil
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 周张豹
* @date 2013-11-11 上午11:31:08
 */
public class OrderUtil {
	private static String lhPayUrL = "http://i.chinaecpay.com/gateway.html";
	private static String lhDeliverUrL = "http://i.chinaecpay.com/delivery.html";
	
	public static void main(String[] args) throws InterruptedException {
//		System.out.println(com.ecc.tool.Signature.dealSignure("111111", "699066936", "100.83", "http://mer.ecpay.cn/receive1.jsp", ResourceUtil.getLhKey()));
		System.out.println(OrderUtil.getOrderId());
	}

	/**
	 * 自动生成有规则的订单号(或编号)<br>
	 * 生成的格式是: 200908010001 前面几位为当前的日期,后面五位为系统自增长类型的编号<br>
	 * 原理: <br>
	 * 1.获取当前日期格式化值;<br>
	 * 2.读取文件,上次编号的值+1最为当前此次编号的值<br>
	 * (新的一天会重新从1开始编号)<br>
	 * 
	 * @Title: getOrderId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 周张豹
	 */
	public static String getOrderId() {
		SerialNumber serial = new FileEveryDaySerialNumber(5,
				"EveryDaySerialNumber.dat");

		String orderId = serial.getSerialNumber();
		return orderId;
	}
	
	/**
	 * 提交订单去支付联行支付的数字签名
	* @Title: getSignature
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param lhPayPojo
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public static String getSignature(LhPayPojo lhPayPojo){
		String signature = com.ecc.tool.Signature.dealSignure(lhPayPojo.getMerId(), lhPayPojo.getDealOrder(), lhPayPojo.getDealFee(), lhPayPojo.getDealReturn(), ResourceUtil.getLhKey());
		return signature;
	}
	
	/**
	 * 发货数字签名
	* @Title: getDeliverSignature
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param deliverPojo
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public static String getDeliverSignature(DeliverPojo deliverPojo){
		
		return "";
	}
	
	
	/**
	 * 联行支付<br>post提交
	* @Title: payOrderToLh
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param lhPayPojo    设定文件
	* @return void    返回类型
	* @author 周张豹
	 */
	public static void payOrderToLh(LhPayPojo lhPayPojo){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("merId", lhPayPojo.getMerId());
		map.put("dealName", lhPayPojo.getDealName());
		map.put("dealOrder", lhPayPojo.getDealOrder());
		map.put("dealFee", lhPayPojo.getDealFee());
		map.put("dealReturn", lhPayPojo.getDealReturn());
		map.put("dealNotify", lhPayPojo.getDealNotify());
		map.put("dealSignure", lhPayPojo.getDealSignure());
		if (null != lhPayPojo.getDealLogLinker() && !"".equals(lhPayPojo.getDealLogLinker())) {
			map.put("dealLogLinker", lhPayPojo.getDealLogLinker());
		}
		if (null != lhPayPojo.getDealLogTel() && !"".equals(lhPayPojo.getDealLogTel())) {
			map.put("dealLogTel", lhPayPojo.getDealLogTel());
		}
		if (null != lhPayPojo.getDealLogPhone() && !"".equals(lhPayPojo.getDealLogPhone())) {
			map.put("dealLogPhone", lhPayPojo.getDealLogPhone());
		}
		if (null != lhPayPojo.getDealLogAddr() && !"".equals(lhPayPojo.getDealLogAddr())) {
			map.put("dealLogAddr", lhPayPojo.getDealLogAddr());
		}
		
		HttpRequestProxy.doPost(lhPayUrL, map, "UTF-8");
	}
	
	/**
	 * 发货告知联行支付<br>post提交
	* @Title: sendOrderToLh
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param lhPayPojo    设定文件
	* @return void    返回类型
	* @author 周张豹
	 */
	public static void deliverOrderToLh(DeliverPojo deliverPojo){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("merId", deliverPojo.getMerId());
		map.put("dealId", deliverPojo.getDealId());
		map.put("dealSignure", OrderUtil.commonSignure(deliverPojo.getMerId(), ResourceUtil.getLhKey()));		
		HttpRequestProxy.doPost(lhDeliverUrL, map, "UTF-8");
	}
	
	/**
	 * @Description: 对外接口的签名方法
	 * @param userId
	 * @param userKey
	 * @return
	 */
	public static String commonSignure(String userId,String userKey) {
		try {
			MessageDigest alga = MessageDigest.getInstance("SHA-1");
			String date=new SimpleDateFormat("yyyyMMdd").format(new Date());
			alga.update((userId+userKey+date).getBytes());
			String sign = Common.bintoascii(alga.digest());
			return sign;
		} catch (Exception e) {
			return null;
		}
	}

	
}

abstract class SerialNumber {

	public synchronized String getSerialNumber() {
		return process();
	}

	protected abstract String process();
}

abstract class EveryDaySerialNumber extends SerialNumber {

	protected final static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyyMMdd");
	protected DecimalFormat df = null;

	public EveryDaySerialNumber(int width) {
		if (width < 1) {
			throw new IllegalArgumentException(
					"Parameter length must be great than 1!");
		}
		char[] chs = new char[width];
		for (int i = 0; i < width; i++) {
			chs[i] = '0';
		}
		df = new DecimalFormat(new String(chs));
	}

	protected String process() {
		Date date = new Date();
		int n = getOrUpdateNumber(date, 1);
		return format(date) + format(n);
	}

	protected String format(Date date) {
		return sdf.format(date);
	}

	protected String format(int num) {
		return df.format(num);
	}

	/**
	 * 获得序列号，同时更新持久化存储中的序列
	 * 
	 * @param current
	 *            当前的日期
	 * @param start
	 *            初始化的序号
	 * @return 所获得新的序列号
	 */
	protected abstract int getOrUpdateNumber(Date current, int start);
}

class FileEveryDaySerialNumber extends EveryDaySerialNumber {

	/**
	 * 持久化存储的文件
	 */
	private File file = null;

	/**
	 * 存储的分隔符
	 */
	private final static String FIELD_SEPARATOR = ",";

	public FileEveryDaySerialNumber(int width, String filename) {
		super(width);
		file = new File(filename);
	}

	@Override
	protected int getOrUpdateNumber(Date current, int start) {
		String date = format(current);
		int num = start;
		if (file.exists()) {
			List<String> list = FileInteriorUtil.readList(file);
			String[] data = list.get(0).split(FIELD_SEPARATOR);
			if (date.equals(data[0])) {
				num = Integer.parseInt(data[1]);
			}
		}
		FileInteriorUtil.rewrite(file, date + FIELD_SEPARATOR + (num + 1));
		return num;
	}
}

class FileInteriorUtil {

	public static void rewrite(File file, String data) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static List<String> readList(File file) {
		BufferedReader br = null;
		List<String> data = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(file));
			for (String str = null; (str = br.readLine()) != null;) {
				data.add(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
}
