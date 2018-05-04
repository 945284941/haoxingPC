package com.qlzy.common.tools;

import java.util.ResourceBundle;

import org.apache.poi.ss.formula.functions.Intercept;
import org.apache.struts2.ServletActionContext;

/**
 * 项目参数工具类
 * 
 * @author Huifeng Wang
 * 
 */
public class ResourceUtil {

	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("config");

	/**
	 * 获得sessionInfo名字
	 * 
	 * @return
	 */
	public static final String getSessionInfoName() {
		return bundle.getString("sessionInfoName");
	}
	
	public static final String getRegisterMobileCode(){
		return bundle.getString("registerMobileCode");
	}
	
	/**
	 * 获取Cookie中购物车的名字
	* @Title: getSessuinCart
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public static final String getCookieCart(){
		return bundle.getString("cookieCart");
	}
	
	/**
	 * 获得上传表单域的名称
	 * 
	 * @return
	 */
	public static final String getUploadFieldName() {
		return bundle.getString("uploadFieldName");
	}

	/**
	 * 获得上传文件的最大大小限制
	 * 
	 * @return
	 */
	public static final long getUploadFileMaxSize() {
		return Long.valueOf(bundle.getString("uploadFileMaxSize"));
	}

	/**
	 * 获得允许上传文件的扩展名
	 * 
	 * @return
	 */
	public static final String getUploadFileExts() {
		return bundle.getString("uploadFileExts");
	}

	/**
	 * 获得上传文件要放到那个目录
	 * 
	 * @return
	 */
	public static final String getUploadDirectory() {
		return bundle.getString("uploadDirectory");
	}

	/**
	 * 获的商品批量上传的文件要放到的目录
	 */
	public static final String getGoods_Ex_Import_Directory(){
		return bundle.getString("goods_Ex_Import_Directory");
	}
	
	/**
	 * 商品批量导入检测后缀名
	 */
	public static final String getGoods_Ex_Import_Ext(){
		return bundle.getString("goods_Ex_Import_Ext");
	}
	/**
	 * 图片缀名
	 */
	public static final String getImage_Ext(){
		return bundle.getString("images_Ext");
	}
	/**
	 * 所有关于汽车有关的图片存放目录
	 */
	public static final String getCarAboutPic_Directory(){
		return bundle.getString("carAboutPic_Directory");
	}
	/**
	 * 所有关于友情链接有关的图片存放目录
	 */
	public static final String getFriendlyLinkAboutPic_Directory(){
		return bundle.getString("friendlyLinkAboutPic_Directory");
	}
	/**
	 * 所有关于汽车有关的图片存放目录
	 */
	public static final String getProjectName(){
		return bundle.getString("project_name");
	}
	/**
	 * 商品上传原图片路径(大图,big)
	 */
	public static final String getGoods_Img_Directory(){
		return bundle.getString("goods_Img_Directory");
	}
	
	/**
	* @Title: getGoods_Img_thumb_Directory
	* @Description: TODO获取商品上传缩略图路径
	* @param @return    设定文件
	* @return String    返回类型
	 */
	public static final String getGoods_Img_thumb_Directory(){
		return bundle.getString("goods_Img_thumb_Directory");
	}
	/**
	* @Title: getGoods_Img_standard_Directory
	* @Description: TODO获取商品图片标准图
	* @param @return    设定文件
	* @return String    返回类型
	 */
	public static final String getGoods_Img_standard_Directory(){
		return bundle.getString("goods_Img_standard_Directory");
	}
	/***
	 * 企业logo 营业执照存放地址
	 * @return
	 */
	public static final String getCompany_Img_Directory(){
		return bundle.getString("companyLogoAndlicense");
	}
	/***
	 * 企业表头广告存放地址
	 * @return
	 */
	public static final String getCompany_Head_Img_Directory(){
		return bundle.getString("companyHeandImg");
	}
	/**
	 * 获取tomcat目录下 webapp的路径
	 */
	public static final String getWebAppPath(){
		 String path=ServletActionContext.getServletContext().getRealPath(
					"")+"/";
		 return path;
	}

	/**
	* @Title: getActive_collect_goods_Directory
	* @Description: 获取采集活动上传图片的路径
	* @param @return    设定文件
	* @return String    返回类型
	*/
	public static String getActive_collect_goods_Directory(){
		return bundle.getString("active_collect_goods_Directory");
	}
	
	/**
	* @Title: getWaterPath
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	*/
	public static String getWaterPath() {
		// TODO Auto-generated method stub
		return bundle.getString("waterPath");
	}
	
	public static String getWebPath(){
		return bundle.getString("webpath");
	}
	
	public static String getFtpIp(){
		return bundle.getString("ftpIp");
	}
	public static String getFtpUserName(){
		return bundle.getString("ftpUserName");
	}
	public static String getFtpPassword(){
		return bundle.getString("ftpPassword");
	}
	
	/**
	 * 通过键获取值
	 * 
	 * @param key
	 * @return
	 */
	public static final String get(String key) {
		return bundle.getString(key);
	}
	/**
	 * 编辑器所需
	 * 
	 * @param key
	 * @return
	 */
	public static final String getKindeditorFieldName(){
		return bundle.getString("kindeditorFieldName");
	}
	
	public static final String getKindeditorUploadFileExts(){
		return bundle.getString("kindeditorUploadFileExts");
	}
	
	public static final String getDomain(){
		return bundle.getString("domain");
	}
	
	/**
	 * @Title: getRandNum
	 * @Description: TODO(获取有效时间) 
	 * @param @return    设定文件 
	 * @return String 返回类型 
	 * @author wangmei
	 */
	public static final String getValidTime (String type){
		if("1".equals(type)){
			return bundle.getString("validTimeForMobile");
		}else{
			return bundle.getString("validTimeForEmail");
		}
	}
	
	/**
	 * 获取联行支付的MerId
	* @Title: getLhMerId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public static final String getLhMerId(){
		return bundle.getString("LhMerId");
	}
	
	/**
	 *  获取联行支付的授权码key
	* @Title: getLhKey
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public static final String getLhKey(){
		return bundle.getString("LhKey");
	}
	
	/**
	 * 支付完成后支付结果返回到该url，主要用于结果展示
	* @Title: getLhDealReturn
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public static final String getLhDealReturn(){
		return bundle.getString("LhDealReturn");
	}
	
	/**
	 * 支付完成后支付结果通知到该url，主要用于通知接受
	* @Title: getLhDealNotify
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public static final String getLhDealNotify(){
		return bundle.getString("LhDealNotify");
	}
	
	public static final String LhDealNotifyljhk(){
		return bundle.getString("LhDealNotifyljhk");
	}
	
	/**
	 * @Title: getForeverValidatecode
	 * @Description: TODO(获取永久验证码) 
	 * @param @return    设定文件 
	 * @return String 返回类型 
	 * @author wangmei
	 */
	public static final String getForeverValidatecode (){
		return bundle.getString("foreverValidatecode");
	}
	/**
	 * @Title: getForeverValidatecode
	 * @Description: TODO(获取平台qq) 
	 * @param @return    设定文件 
	 * @return String 返回类型 
	 * @author wangmei
	 */
	public static final String getQqNumber(){
		return bundle.getString("qqPingtai");
	}

	public static String getnotify_url() {
		// TODO Auto-generated method stub
		return bundle.getString("notify_url");
	}

	public static String getreturn_url() {
		// TODO Auto-generated method stub
		return bundle.getString("return_url");
	}
	public static String getReceiveDateNum(){
		return bundle.getString("receive_date_num");
	}
	public static int getPayTimeout(){
		return Integer.parseInt(bundle.getString("pay_timeout_hour"));
	}
	public static String getGiveMeNum(){
		return bundle.getString("give_me_num");
	}
	
	public static String getHcpayGateway() {
		return bundle.getString("hc_pay_url");
	}

	public static int getFtpPort() {
		return Integer.parseInt(bundle.getString("ftpPort"));
	}

	public static String getFtpRootPath() {
		return bundle.getString("ftp_root_path");
	}
	public static String getExcelPath() {
		return bundle.getString("excel_path");
	}
	public static int getExcelRow() {
		return Integer.parseInt(bundle.getString("excel_row"));
	}
	public static int getExcelColumn() {
		return Integer.parseInt(bundle.getString("excel_column"));
	}
	//获取限时抢购分类id
	public static String getFlashSaleId(){
		return  bundle.getString("flashSaleId");
	}
	//获取限时抢购首页推荐个数
	public static Integer getFlashSaleIndexNum(){
		return Integer.parseInt(bundle.getString("flashSaleIndexNum"));
	}
	//获取购物商城分类id
	public static String getShoppingId(){
		return  bundle.getString("shoppingId");
	}
	//获取购物商城首页推荐个数
	public static Integer getShoppingIndexNum(){
		return Integer.parseInt(bundle.getString("shoppingIndexNum"));
	}

	//获取购物超市分类id
	public static String getSupermarketId(){
		return  bundle.getString("supermarketId");
	}
	//获取购物建材分类id
	public static String getBuildingId(){
		return  bundle.getString("buildingId");
	}


	public static Integer getMarketIndexNum() {
		return Integer.parseInt(bundle.getString("marketIndexNum"));
	}
}
