/**  
* @Title: IPSMessage.java
* @Package com.qlzy.pojo
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-11-5 上午9:53:43
* @version V1.0  
*/
package com.qlzy.pojo;

/**
 * @ClassName: IPSMessage
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-11-5 上午9:53:43
 */
import java.io.Serializable;

public class IPSMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String Mer_code;//商户编号
	private String Billno;//商户订单编号
	private String Amount;//订单金额
	private String date;//订单日期
	private String Currency_Type;//币种
	private String Gateway_Type;//支付卡种
	private String DoCredit;//直连支付方式
	private String PayStyle;//页面选择
	private String Lang;//语言
	private String Merchanturl;//支付结果成功返回的商户URL
	private String FailUrl;//支付结果失败返回的商户URL
	private String ErrorUrl;//支付结果错误返回的商户	URL
	private String Attach;//商户数据包
	private String OrderEncodeType;//订单支付接口加密方式
	private String RetEncodeType;//交易返回接口加密	方式
	private String Rettype;//返回方式
	private String ServerUrl;//Server to Server 返回页面
	private String SignMD5;//订单支付	接口的Md5摘要
	
	/**
	 * 获取 商户编号， 长度为:6位 ，是否为空:Not Null<br>
	 * 说明：IPS支付平台分配给商户的唯一标识  例如：000015
	 * @return the mer_code
	 */
	public String getMer_code() {
		return Mer_code;
	}
	/**
	 * 设置 商户编号  长度为:6位 ，是否为空:Not Null<br>
	 * 说明：IPS支付平台分配给商户的唯一标识  例如：000015
	 * @param mer_code the mer_code to set
	 */
	public void setMer_code(String mer_code) {
		Mer_code = mer_code;
	}
	
	
	/**
	 * 获取 商户订单编号  长度为：30位  是否为空：Not Null <br>
	 * 说明：规则：30位以下的订单号
	 * @return the billno
	 */
	public String getBillno() {
		return Billno;
	}
	/**
	 * 设置   商户订单编号  长度为：30位  是否为空：Not Null <br>
	 * 说明：规则：30位以下的订单号
	 * @param billno the billno to set
	 */
	public void setBillno(String billno) {
		Billno = billno;
	}
	
	
	/**
	 * 获取 订单金额  长度为：Max(10 位) 是否为空 Not Null<br>
	 * 说明：单位：人民币
	 * 规则：小数点后保留2位,若超过2位则在IPS平台上自动四舍五入
	 * @return the amount
	 */
	public String getAmount() {
		return Amount;
	}
	/**
	 * 设置订单金额  长度为：Max(10 位) 是否为空 Not Null<br>
	 * 说明：单位：人民币
	 * 规则：小数点后保留2位,若超过2位则在IPS平台上自动四舍五入
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		Amount = amount;
	}
	
	
	/**
	 * 获取 订单日期  长度为：8位 是否为空 Not Null<br>
	 * 说明：规则：YYYYMMDD 例如 20031205
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * 设置   订单日期  长度为：8位 是否为空 Not Null<br>
	 * 说明：规则：YYYYMMDD 例如 20031205
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	
	/**
	 * 获取  币种 长度为：3位 是否为空 Not Null<br>
	 * 说明：规则：当前只有RMB
	 * @return the currency_Type
	 */
	public String getCurrency_Type() {
		return Currency_Type;
	}
	/**
	 * 设置   币种 长度为：3位 是否为空 Not Null<br>
	 * 说明：规则：当前只有RMB
	 * @param currency_Type the currency_Type to set
	 */
	public void setCurrency_Type(String currency_Type) {
		Currency_Type = currency_Type;
	}
	
	
	/**
	 * 获取 支付卡种  长度为：2位 是否为空 Not Null<br>
	 * 说明：规则：
	 * 01—人民币借记卡（默认值）
	 * 04—IPS帐户支付
	 * @return the gateway_Type
	 */
	public String getGateway_Type() {
		return Gateway_Type;
	}
	/**
	 * 设置  支付卡种  长度为：2位 是否为空 Not Null<br>
	 * 说明：规则：
	 * 01—人民币借记卡（默认值）
	 * 04—IPS帐户支付
	 * @param gateway_Type the gateway_Type to set
	 */
	public void setGateway_Type(String gateway_Type) {
		Gateway_Type = gateway_Type;
	}
	
	
	/**
	 * 获取 直连支付方式   长度为：是否为空 Null<br>
	 * 说明：规则：值必须为空  
	 * @return the doCredit
	 */
	public String getDoCredit() {
		return DoCredit;
	}
	/**
	 * 设置 直连支付方式   长度为：是否为空 Null<br>
	 * 说明：规则：值必须为空 
	 * @param doCredit the doCredit to set
	 */
	public void setDoCredit(String doCredit) {
		DoCredit = doCredit;
	}
	
	
	/**
	 * 获取 页面选择  长度为：1位 是否为空 Not Null<br>
	 * 说明：规则：
	 * 3----兴业银行模式
	 * @return the payStyle
	 */
	public String getPayStyle() {
		return PayStyle;
	}
	/**
	 * 设置  页面选择  长度为：1位 是否为空 Not Null<br>
	 * 说明：规则：
	 * 3----兴业银行模式
	 * @param payStyle the payStyle to set
	 */
	public void setPayStyle(String payStyle) {
		PayStyle = payStyle;
	}
	
	
	/**
	 * 获取 语言    长度为：1位 是否为空 Null<br>
	 * 说明：规则：GB——GB中文（缺省）  GB
	 * @return the lang
	 */
	public String getLang() {
		return Lang;
	}
	/**
	 * 设置   语言    长度为：1位 是否为空 Null<br>
	 * 说明：规则：GB——GB中文（缺省）  GB
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		Lang = lang;
	}
	
	
	/**
	 * 获取 支付结果成功返回的商户URL   长度为：255位 是否为空 Not Null<br>
	 * 说明：规则：动态的网页，在该页对IPS返回信息进行签名验证后处理商户端的数据库。
	 * 缺省：https://www.ips.com.cn/ipay/Default.aspx
	 * @return the merchanturl
	 */
	public String getMerchanturl() {
		return Merchanturl;
	}
	/**
	 * 设置   支付结果成功返回的商户URL   长度为：255位 是否为空 Not Null<br>
	 * 说明：规则：动态的网页，在该页对IPS返回信息进行签名验证后处理商户端的数据库。
	 * 缺省：https://www.ips.com.cn/ipay/Default.aspx
	 * @param merchanturl the merchanturl to set
	 */
	public void setMerchanturl(String merchanturl) {
		Merchanturl = merchanturl;
	}
	
	
	/**
	 * 获取   支付结果失败返回的商户URL   长度为：255位 是否为空 Null<br>
	 * 说明：规则：动态的网页，在该页对IPS返回信息进行签名验证后处理商户端的数据库。
	 * 缺省：https://www.ips.com.cn/ipay/Default.aspx
	 * @return the failUrl
	 */
	public String getFailUrl() {
		return FailUrl;
	}
	/**
	 * 设置 支付结果失败返回的商户URL   长度为：255位 是否为空  Null<br>
	 * 说明：规则：动态的网页，在该页对IPS返回信息进行签名验证后处理商户端的数据库。
	 * 缺省：https://www.ips.com.cn/ipay/Default.aspx
	 * @param failUrl the failUrl to set
	 */
	public void setFailUrl(String failUrl) {
		FailUrl = failUrl;
	}
	
	
	/**
	 * 获取 支付结果错误返回的商户URL  长度为：255位 是否为空 Null<br>
	 * 说明：当提交网关发生错误时,IPS 将错误码重定向到这个地址
	 * @return the errorUrl
	 */
	public String getErrorUrl() {
		return ErrorUrl;
	}
	/**
	 * 设置   支付结果错误返回的商户URL  长度为：255位 是否为空 Null<br>
	 * 说明：当提交网关发生错误时,IPS 将错误码重定向到这个地址
	 * @param errorUrl the errorUrl to set
	 */
	public void setErrorUrl(String errorUrl) {
		ErrorUrl = errorUrl;
	}
	
	
	/**
	 * 获取商户数据包   长度为：1024位 是否为空 Null<br>
	 * 说明：存放商户自己的信息，随订单传送到IPS平台，当订单返回的时候原封不动的返回给商户
	 * @return the attach
	 */
	public String getAttach() {
		return Attach;
	}
	/**
	 * 设置 商户数据包   长度为：1024位 是否为空 Null<br>
	 * 说明：存放商户自己的信息，随订单传送到IPS平台，当订单返回的时候原封不动的返回给商户
	 * @param attach the attach to set
	 */
	public void setAttach(String attach) {
		Attach = attach;
	}
	
	
	/**
	 * 获取 订单支付接口加密方式   长度为：1位 是否为空Not Null<br>
	 * 说明：存放商户所选择订单支付接口加密方式。5：订单支付采用Md5的摘要认证方式
	 * @return the orderEncodeType
	 */
	public String getOrderEncodeType() {
		return OrderEncodeType;
	}
	/**
	 * 设置  订单支付接口加密方式   长度为：1位 是否为空Not Null<br>
	 * 说明：存放商户所选择订单支付接口加密方式。5：订单支付采用Md5的摘要认证方式
	 * @param orderEncodeType the orderEncodeType to set
	 */
	public void setOrderEncodeType(String orderEncodeType) {
		OrderEncodeType = orderEncodeType;
	}
	
	
	/**
	 * 获取交易返回接口加密方式   长度为：2位 是否为空Not Null<br>
	 * 说明：存放商户所选择的交易返回接口加密方式。16：交易返回采用Md5WithRsa的签名认证方式
	 * 17：交易返回采用Md5的摘要认证方式
	 * @return the retEncodeType
	 */
	public String getRetEncodeType() {
		return RetEncodeType;
	}
	/**
	 * 设置交易返回接口加密方式   长度为：2位 是否为空Not Null<br>
	 * 说明：存放商户所选择的交易返回接口加密方式。16：交易返回采用Md5WithRsa的签名认证方式
	 * 17：交易返回采用Md5的摘要认证方式
	 * @param retEncodeType the retEncodeType to set
	 */
	public void setRetEncodeType(String retEncodeType) {
		RetEncodeType = retEncodeType;
	}
	
	
	/**
	 * 获取 返回方式  长度为：1位 是否为空 Not Null<br>
	 * 说明：IPS为商户提供了2种返回方式，<br>
	 * 分别为：Server to Server返回（可选）Browser返回（必选）<br>
	 * 该字段存放商户是否选择Server to Server返回方式 0：不选 1：选择
	 * @return the rettype
	 */
	public String getRettype() {
		return Rettype;
	}
	/**
	 * 设置返回方式  长度为：1位 是否为空 Not Null<br>
	 * 说明：IPS为商户提供了2种返回方式，<br>
	 * 分别为：Server to Server返回（可选）Browser返回（必选）<br>
	 * 该字段存放商户是否选择Server to Server返回方式 0：不选 1：选择
	 * @param rettype the rettype to set
	 */
	public void setRettype(String rettype) {
		Rettype = rettype;
	}
	
	
	/**
	 * 获取 Server to Server 返回页面   长度为：255位 是否为空 Not Null<br>
	 * 说明：商户使用Server  to  Server返回时可将返回地址存于此字段 当  RetType=1  时,本字段有效
	 * @return the serverUrl
	 */
	public String getServerUrl() {
		return ServerUrl;
	}
	/**
	 * 设置 Server to Server 返回页面   长度为：255位 是否为空 Not Null<br>
	 * 说明：商户使用Server  to  Server返回时可将返回地址存于此字段 当  RetType=1  时,本字段有效
	 * @param serverUrl the serverUrl to set
	 */
	public void setServerUrl(String serverUrl) {
		ServerUrl = serverUrl;
	}
	
	
	/**
	 * 获取 订单支付接口的Md5摘要   长度为：255位 是否为空Not Null<br>
	 * 说明： 若OrderEncodeType字段的值设置为5时， 需同时在此字段中传入Md5摘要.<br>
	 * Sigmd5=billno+订单编号+currencytype +支付币种+amount +金额(保留2位小数)+date +日期+orderencodetype +订单支付接口加密方式+IPS证书
	 * @return the signMD5
	 */
	public String getSignMD5() {
		return SignMD5;
	}
	/**
	 * 设置 订单支付接口的Md5摘要   长度为：255位 是否为空Not Null<br>
	 * 说明： 若OrderEncodeType字段的值设置为5时， 需同时在此字段中传入Md5摘要.<br>
	 * Sigmd5=billno+订单编号+currencytype +支付币种+amount +金额(保留2位小数)+date +日期+orderencodetype +订单支付接口加密方式+IPS证书
	 * @param signMD5 the signMD5 to set
	 */
	public void setSignMD5(String signMD5) {
		SignMD5 = signMD5;
	}
	
	

}
