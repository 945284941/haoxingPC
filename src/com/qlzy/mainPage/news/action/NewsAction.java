package com.qlzy.mainPage.news.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;

import com.qlzy.active.service.CollectService;
import com.qlzy.common.tools.ImageUtils;
import com.qlzy.common.tools.PwdCrypt;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.common.tools.URLDecoderTwice;
import com.qlzy.mainPage.common.service.CommonService;
import com.qlzy.mainPage.news.service.NewsService;
import com.qlzy.mainPage.regions.service.RegionsService;
import com.qlzy.memberCenter.goods.service.GoodsService;
import com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService;
import com.qlzy.model.CarBrand;
import com.qlzy.model.CarBrandType;
import com.qlzy.model.News;
import com.qlzy.model.Regions;
import com.qlzy.model.Supply;
import com.qlzy.model.SupplyType;
import com.qlzy.model.Views;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;

/**
 * @ClassName: NewsAction
 * @Description: 新闻类
 * @author Huifeng Wang
 * @date 2013-5-7 下午1:15:50
 * 
 */
@Namespace("/news")
@Action(value = "news", results = {
		@Result(name = "ssdp", location = "/admin/ssdp/ssdpIndex.jsp"),
		@Result(name = "jkzx", location = "/admin/jkzx/jkzxIndex.jsp"),
		@Result(name = "toMoreForMain", location = "/admin/news/newslist.jsp"),
		@Result(name = "toDetailZpcNews", location = "/admin/news/detailZpcNews.jsp"),
		
		@Result(name = "toNews", location = "/admin/news/main_news.jsp"),
		@Result(name = "uploadPage", location = "/uploader.jsp"),
		@Result(name = "toDetailNews", location = "/admin/news/detailNews.jsp"),
		
		
		@Result(name = "toMoreForOther", location = "/admin/news/newslist.jsp"),
		@Result(name = "toMoreForGQXX", location = "/admin/news/infor/infor_lb.jsp"),
		@Result(name = "toQpzx", location = "/admin/news/qpzx_news.jsp"),
		@Result(name = "toGqxx", location = "/admin/news/infor/information.jsp"),
		@Result(name = "toSchq", location = "/admin/news/schq_news.jsp"),
		@Result(name = "toCppc", location = "/admin/news/cppc_news.jsp"),
		@Result(name = "zc", location = "/admin/news/infor/infor_content_zc.jsp"),
		@Result(name = "pj", location = "/admin/news/infor/infor_content_pj.jsp"),
		@Result(name = "wl", location = "/admin/news/infor/infor_content_wl.jsp"),
		@Result(name = "xlc",location = "/admin/news/infor/infor_content_xlc.jsp"),
		@Result(name = "sb", location = "/admin/news/infor/infor_content_sb.jsp"),
		@Result(name = "zp", location = "/admin/news/infor/infor_content_zp.jsp"),
		@Result(name = "qz", location = "/admin/news/infor/infor_content_qz.jsp"),
		@Result(name = "zl", location = "/admin/news/infor/infor_content_zl.jsp"),
		@Result(name = "qt", location = "/admin/news/infor/infor_content_qt.jsp"),
		@Result(name = "xxsh", location = "/admin/news/infor/infor_fb_xxsh.jsp"),
		@Result(name = "xxfb", location = "/admin/news/infor/infor_fb_fl.jsp"),
		@Result(name = "ZCpage", location = "/admin/news/infor/infor_fb_zc.jsp"),
		@Result(name = "PJpage", location = "/admin/news/infor/infor_fb_pj.jsp"),
		@Result(name = "SBpage", location = "/admin/news/infor/infor_fb_sb.jsp"),
		@Result(name = "XLCpage", location = "/admin/news/infor/infor_fb_xlc.jsp"),
		@Result(name = "WLpage", location = "/admin/news/infor/infor_fb_wl.jsp"),
		@Result(name = "ZLpage", location = "/admin/news/infor/infor_fb_zl.jsp"),
		@Result(name = "ZPpage", location = "/admin/news/infor/infor_fb_zp.jsp"),
		@Result(name = "QTpage", location = "/admin/news/infor/infor_fb_qt.jsp"),
		@Result(name = "add", type = "redirect", location = "/s_supplyxxsh.html"),
		@Result(name = "searchAllNews",  location = "/admin/news/allNewList.jsp"),
		@Result(name = "toQlqpc",  location = "/admin/qlqpc/qlqpclb.jsp")
})
public class NewsAction extends BaseAction {
	private static final long serialVersionUID = 1231118973089103507L;
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private NewsService newsService;
	private News news;
	private Map<String, Object> map = new HashMap<String, Object>();
	private String newsCatName;
	private List<?> list;
	
	private String searchType;//搜索类型
	private String topSearchLike;//搜索条件
	
	@Autowired
	private CollectService collectService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private RegionsService regionsService;
	@Autowired
	private MemberCollectService memberCollectService;
	@Autowired
	private CommonService commonService;
	
	private Supply supply; 
	
	public Supply getSupply() {
		return supply;
	}

	public void setSupply(Supply supply) {
		this.supply = supply;
	}
	
	
	public String toSsdpIndex(){
		News temp=new News();
		temp.setId("");
		Map<String, Object> newsCatMap = new HashMap<String, Object>();
		Map<String, Object> param;
		newsCatMap.put("0", "老年膳食");
		newsCatMap.put("1", "青少年膳食");
		newsCatMap.put("2", "白领丽人膳食");
		newsCatMap.put("3", "孕产妇膳食");
		newsCatMap.put("4", "菜肴视频");
		newsCatMap.put("5", "老人餐");
		newsCatMap.put("6", "儿童餐");
		newsCatMap.put("7", "丽人餐");
		newsCatMap.put("8", "孕妇餐");
		newsCatMap.put("9", "其他餐");
		
		for (int i = 0; i <= 9; i++) {
			param = new HashMap<String, Object>();
			param.put("newsCatName", String.valueOf(newsCatMap.get(i + "")));
			List<News> temp1 = newsService.gainNewsForQPZX(param);
				if(i>=5){
					list = temp1.subList(0, temp1.size() > 4 ? 4 : temp1.size());
				}else{
					list = temp1.subList(0, temp1.size() > 6 ? 6 : temp1.size());
				}
			map.put("news_" + i, list);
		}
			return "ssdp";
		}
	public String toJkzxIndex(){
		News temp=new News();
		temp.setId("");
		Map<String, Object> newsCatMap = new HashMap<String, Object>();
		Map<String, Object> param;
		newsCatMap.put("0", "猜你喜欢");
		newsCatMap.put("1", "热门推荐");
		for (int i = 0; i <= 1; i++) {
			param = new HashMap<String, Object>();
			param.put("newsCatName", String.valueOf(newsCatMap.get(i + "")));
			List<News> temp1 = newsService.gainNewsForQPZX(param);
					list = temp1.subList(0, temp1.size() > 9 ? 9 : temp1.size());
			map.put("news_" + i, list);
		}
		
		
		newsCatName="健康资讯列表";
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<Integer, Object> news = new HashMap<Integer, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(4L);// 设置每页显示几条数据
		map1.put("newsCatName", newsCatName);
		map1.put("page", (pagination.getPage()-1)*pagination.getRows());
		map1.put("rows", pagination.getRows());
		list = newsService.gainNewsListByNewsCatNameForQpzx(map1);
		pagination.setTotalCount(newsService
				.gainNewsListCountByNewsCatNameForQpzx(map1));
		request.setAttribute("pagination", pagination);
		request.setAttribute("ncn", temp);
		request.setAttribute("news",news);
		return "jkzx";
	}

	
	
	

	public void ftpUpload() {
		Map<String, Object> map = new HashMap<String, Object>();
		String savePath = ResourceUtil.getWebAppPath() + ".."
				+ ResourceUtil.get("supply_img_directory") + "/";// 文件保存目录路径
		String saveUrl = ResourceUtil.get("supply_img_directory")+"/";
		MultiPartRequestWrapper multiPartRequest = (MultiPartRequestWrapper) ServletActionContext
				.getRequest();// 由于struts2上传文件时自动使用了request封装
		File[] files = multiPartRequest.getFiles("file");// 上传的文件集合
		String[] fileNames = multiPartRequest.getFileNames("file");// 上传文件名称集合

		if (files == null || files.length < 1) {
			this.uploadError("您没有上传任何文件！");
			return;
		}
		for (int i = 0; i < files.length; i++) {// 循环所有文件
			File file = files[i];// 上传的文件(临时文件)
			String fileName = fileNames[i];// 上传文件名
			if (file.length() > ResourceUtil.getUploadFileMaxSize()) {
				this.uploadError("上传文件超出限制大小！", fileName);
				return;
			}
			// 检查文件扩展名
			String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1)
					.toLowerCase();
			if (!Arrays.<String> asList(
					ResourceUtil.getUploadFileExts().split(",")).contains(
					fileExt)) {
				this.uploadError("上传文件扩展名是不允许的扩展名。\n只允许"
						+ ResourceUtil.getUploadFileExts() + "格式！");
				return;
			}

			savePath += fileExt + "/";
			saveUrl += fileExt + "/";
			SimpleDateFormat yearDf = new SimpleDateFormat("yyyy");
			SimpleDateFormat monthDf = new SimpleDateFormat("MM");
			SimpleDateFormat dateDf = new SimpleDateFormat("dd");
			Date date = new Date();
			String ymd = yearDf.format(date) + "/" + monthDf.format(date) + "/"
					+ dateDf.format(date) + "/";
			savePath += ymd;
			saveUrl += ymd;
			String newFileName = UUID.randomUUID().toString()
					.replaceAll("-", "")
					+ "." + fileExt;// 新的文件名称
			File uploadDir = new File(savePath);// 创建要上传文件到指定的目录
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			File uploadedFile = new File(savePath, newFileName);
			String waterPath=ResourceUtil.getWebAppPath()+"water.png";
			waterPath = waterPath.replaceAll("/", "\\\\");
			ImageUtils.water(file.getPath(),waterPath);//加水印
			try {
				FileCopyUtils.copy(file, uploadedFile);// 利用spring的文件工具上传
				map.put("status", true);
				map.put("newName", newFileName);
				map.put("thumbPath", ResourceUtil.getWebPath() + saveUrl
						+ newFileName);
			} catch (Exception e) {
				this.uploadError("上传文件失败！", fileName);
				return;
			}
		}
		super.writeJson(map);
	}

	/**
	 * @Title: toMore
	 * @Description: 点击查看其他页面更多
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public String toMoreForOther() {
		String temp=request.getParameter("ncn");
		newsCatName=URLDecoderTwice.decoder(temp);
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<Integer, Object> news = new HashMap<Integer, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(12L);// 设置每页显示几条数据
		map1.put("newsCatName", newsCatName);
		map1.put("page", (pagination.getPage()-1)*pagination.getRows() );
		map1.put("rows", pagination.getRows());
		list = newsService.gainNewsListByNewsCatNameForQpzx(map1);
		pagination.setTotalCount(newsService
				.gainNewsListCountByNewsCatNameForQpzx(map1));
		request.setAttribute("pagination", pagination);
		request.setAttribute("ncn", temp);
		request.setAttribute("news",news);
		return "toMoreForOther";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void gainFirstCarBrand(){
		super.writeJson(collectService.gainBrandList(1));
	}
	
	/**
	 * 获取下一级车型车系列表
	 */
	public void gainNextCarBrand() {
		String pid = request.getParameter("pid");
		List<CarBrand> brandList = new ArrayList<CarBrand>();
		if (!"".equals(pid.trim())) {
			brandList = collectService.gainNextCarBrandListByPid(pid);
		}
		super.writeJson(brandList);
	}
	
	/**
	 * 获取下一级省市区
	 */
	public void gainNextCityOrAreaByPid(){
		String pid =request.getParameter("pid");
		List<Regions> regions = new ArrayList<Regions>();
		if(!"".equals(pid.trim())){
			regions=regionsService.gainNextCityOrAreaListByPid(pid);
		}
		super.writeJson(regions);
	}
	
	/**
	 * 获取下一级配件分类
	 */
	public void gainNextGoodsCatByPid(){
		String pid=request.getParameter("pid");
		super.writeJson(newsService.gainNextGoodsCatByPid(pid));
	}

	/**
	 * 信息发布列表
	 * @return
	 */
	public String xxfb() {
		SessionInfo sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo==null){
			return "login_hf";
		}
		request.setAttribute("st", newsService.gainAllSupplyType());
		return "xxfb";
	}

	/**
	 * 跳转整车发布页面
	 * 
	 * @return
	 */
	public String toZCpage() {
		SessionInfo sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo==null){
			return "login_hf";
		}
		request.setAttribute("firstBrand", collectService.gainBrandList(1));
		request.setAttribute("carBrandTypeList", newsService.gainAllList(new CarBrandType()));
		request.setAttribute("typeId", request.getParameter("tyi"));
		request.setAttribute("typeName", newsService.gainSupplyTypeNameById(request.getParameter("tyi")));
		return "ZCpage";
	}

	/**
	 * 跳转配件发布
	 * 
	 * @return
	 */
	public String toPJpage() {
		SessionInfo sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo==null){
			return "login_hf";
		}
		request.setAttribute("firstBrand", collectService.gainBrandList(1));
		request.setAttribute("carPartsProducers", goodsService.gainCarPartsProducer());
		request.setAttribute("regions",regionsService.gainProvinceList());
		request.setAttribute("goodsCats", newsService.gainFirstGoodsCatList(1));
		request.setAttribute("typeId", request.getParameter("tyi"));
		request.setAttribute("typeName", newsService.gainSupplyTypeNameById(request.getParameter("tyi")));
		return "PJpage";
	}
	

	/**
	 * 跳转设备信息
	 * 
	 * @return
	 */
	public String toSBpage() {
		SessionInfo sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo==null){
			return "login_hf";
		}
		List<Regions> regions=regionsService.gainProvinceList();
		request.setAttribute("regions",regions);
		request.setAttribute("typeId", request.getParameter("tyi"));
		request.setAttribute("typeName", newsService.gainSupplyTypeNameById(request.getParameter("tyi")));
		return "SBpage";
	}

	/**
	 * 跳转修理厂设备信息
	 * 
	 * @return
	 */
	public String toXLCpage() {
		SessionInfo sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo==null){
			return "login_hf";
		}
		request.setAttribute("regions",regionsService.gainProvinceList());
		request.setAttribute("typeId", request.getParameter("tyi"));
		request.setAttribute("typeName", newsService.gainSupplyTypeNameById(request.getParameter("tyi")));
		return "XLCpage";
	}

	/**
	 * 跳转物流信息
	 * 
	 * @return
	 */
	public String toWLpage() {
		SessionInfo sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo==null){
			return "login_hf";
		}
		request.setAttribute("typeId", request.getParameter("tyi"));
		request.setAttribute("typeName", newsService.gainSupplyTypeNameById(request.getParameter("tyi")));
		return "WLpage";
	}

	/**
	 * 跳转租赁信息
	 * 
	 * @return
	 */
	public String toZLpage() {
		SessionInfo sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo==null){
			return "login_hf";
		}
		request.setAttribute("regions",regionsService.gainProvinceList());
		request.setAttribute("typeId", request.getParameter("tyi"));
		request.setAttribute("typeName", newsService.gainSupplyTypeNameById(request.getParameter("tyi")));
		return "ZLpage";
	}

	/**
	 * 跳转招聘信息
	 * 
	 * @return
	 */
	public String toZPpage() {
		SessionInfo sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo==null){
			return "login_hf";
		}
		request.setAttribute("regions",regionsService.gainProvinceList());
		request.setAttribute("typeId", request.getParameter("tyi"));
		request.setAttribute("typeName", newsService.gainSupplyTypeNameById(request.getParameter("tyi")));
		return "ZPpage";
	}

	/**
	 * 跳转其他信息
	 * 
	 * @return
	 */
	public String toQTpage() {
		SessionInfo sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo==null){
			return "login_hf";
		}
		request.setAttribute("typeId", request.getParameter("tyi"));
		request.setAttribute("typeName", newsService.gainSupplyTypeNameById(request.getParameter("tyi")));
		return "QTpage";
	}
	
	/**
	 * 跳转信息审核界面
	 * @return
	 */
	public String toXXSHpage(){
		SessionInfo sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo==null){
			return "login_hf";
		}
		return "xxsh";
	}
	
	/**
	 * 供求信息添加页面
	 * @return
	 */
	public String add(){
		SessionInfo sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo==null){
			return "login_hf";
		}
		newsService.save(supply, sessionInfo);
		return "add";
	}
	/**
	 * @Title: toNews
	 * @Description: 跳转首页新闻列表
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public String toNews() {
		Map<String, Object> newsCatMap = new HashMap<String, Object>();
		Map<String, Object> param;
		newsCatMap.put("0", "汽配资讯");
		newsCatMap.put("1", "市场行情");
		//newsCatMap.put("2", "供求信息");
		newsCatMap.put("2", "产品评测");
		newsCatMap.put("3", "技术咨询");
		for (int i = 0; i < 4; i++) {
			List<News> list = new ArrayList<News>();
			param = new HashMap<String, Object>();
			param.put("kz1", "true");//获取允许前台显示的新闻
			param.put("newsCatName", String.valueOf(newsCatMap.get(i + "")));
/*			param.put("newsAttr", "焦点");
			list.addAll(newsService.gainNewsForMainPage(param));
			param.put("newsAttr", "顶置");
			list.addAll(newsService.gainNewsForMainPage(param));
			param.put("newsAttr", "重点");
			list.addAll(newsService.gainNewsForMainPage(param));
			param.put("newsAttr", "推荐");
			list.addAll(newsService.gainNewsForMainPage(param));
			param.put("newsAttr", "普通");
*/			list.addAll(newsService.gainNewsForMainPage(param));
			list = list.subList(0, list.size() > 16 ? 16 : list.size());
			map.put("news_" + i, list);
		}
		
		List<Supply> supplys=newsService.gainSupplyNew(null);
		request.setAttribute("supplys", supplys);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("newsCatName", "在线学堂");
		map1.put("newsAttr", "焦点");
		map1.put("page", 1);
		map1.put("rows", 6);
		map1.put("kz1", "true");
		request.setAttribute("zxxt",newsService.gainNewsForMainPage(map1));
		return "toNews";
	}


	/**
	 * @Title: toQpzx
	 * @Description: 点击首页导航栏--'汽配资讯'--跳转汽配资讯页面
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public String toQpzx() {
		News temp=new News();
		temp.setId("");
		Map<String, Object> newsCatMap = new HashMap<String, Object>();
		Map<String, Object> param;
		newsCatMap.put("0", "重配新闻");
		newsCatMap.put("1", "方针政策");
		newsCatMap.put("2", "技术前沿");
		newsCatMap.put("3", "产业资讯");
		newsCatMap.put("4", "展会论坛");
		newsCatMap.put("5", "人物访谈");
		for (int i = 0; i <= 5; i++) {
			List<News> list = new ArrayList<News>();
			param = new HashMap<String, Object>();
			param.put("newsCatName", String.valueOf(newsCatMap.get(i + "")));
			List<News> temp1 = newsService.gainNewsForQPZX(param);
			map.put("top_"+i, temp1.size()>0?temp1.get(0):temp1);
			if(temp1.size()>=2){
				list = temp1.subList(1, temp1.size() >= 10 ? 10 : temp1.size());
			}
			map.put("news_" + i, list);
		}
		return "toQpzx";
	}
	
	
	/**
	 * 跳转供求信息页面
	 * @return
	 */
	public String toGqxx(){
		List<Supply> newgy=newsService.gainSupplyNew("1");
		List<Supply> newqg=newsService.gainSupplyNew("0");
		List<SupplyType> supplyTypes=newsService.gainAllSupplyType();
		Map<String,Object> map=new HashMap<String, Object>();
		List<Supply> supplys=newsService.gainSupplyAll();
		for (int i = 0; i < supplyTypes.size(); i++) {
			SupplyType st=supplyTypes.get(i);
			String typeId=st.getId();
			Map<String,Object> tempM=new HashMap<String, Object>();
			List<Supply> g=new ArrayList<Supply>();
			List<Supply> q=new ArrayList<Supply>();
			for (Supply e : supplys) {
				if(typeId.equals(e.getTypeId())){
					if(e.getStatus().equals("1")){
						g.add(e);
					}else{
						q.add(e);
					}
				}
			}
			supplys.removeAll(g);
			supplys.removeAll(q);
			tempM.put("g",g.subList(0, g.size() >= 9 ? 9 : g.size()));
			tempM.put("q",q.subList(0, q.size() >= 9 ? 9 : q.size()));
			map.put(i+1+"", st);
			map.put(i+1+"_list", tempM);
		}
		request.setAttribute("map", map);
		request.setAttribute("newgy", newgy);
		request.setAttribute("newqg", newqg);
//		try {
//			commonService.toHtml(request,response,"/index.jsp", "index");
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "toGqxx";
	}
	
	/**
	 * 查看供求信息
	 * @return
	 */
	public String viewGqPage(){
		Supply s=newsService.gainSupplyById(request.getParameter("id"));
		Long temp=(long)(Math.random()*10)+1;
		s.setViewnum(s.getViewnum()+temp);
		newsService.updateSupplyViewNum(s);
		request.setAttribute("obj",s);
		String typeId=request.getParameter("typeId");
		if("29e18a83239d4becb68ed0b8625d1f42".equals(typeId)){
			return "zc";
		}else if("dd81f7e54d1c4ab39a64e0fda8ab22e4".equals(typeId)){
			return "pj";
		}else if("09cb43ac66e747ebb992a41ee6a8f490".equals(typeId)){
			return "sb";
		}else if("77b4c9309f12407eae304a950c415f5c".equals(typeId)){
			return "xlc";
		}else if("662835f0b9954d2fb24fdf1a7cb3259a".equals(typeId)){
			return "wl";
		}else if("8b61a34bd9c043ba9d051c96d0e8ddf2".equals(typeId)){
			if(s.getStatus().equals("1")){
				return "qz";
			}else{
				return "zp";
			}
		}else if("97824f8bf1274631994945b984e72c8e".equals(typeId)){
			return "zl";
		}else if("fcdc727df48342a58a4cdaa36c2d3186".equals(typeId)){
			return "qt";
		}
		return null;
	}
	
	public String toMoreForGQXX(){
		List<SupplyType> supplyTypes=newsService.gainAllSupplyType();
		Map<String,Object> map =new HashMap<String,Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(10L);// 设置每页显示几条数据
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		String typeId=request.getParameter("ti");
		map.put("typeId",typeId );
		String status=request.getParameter("asm");
		if(status!=null && !"-1".equals(status)){
			map.put("status", status);
		}
		List<Supply> sy=newsService.gainAllByType(map);
		pagination.setTotalCount(newsService.gainAllCountByType(map));
		request.setAttribute("pagination", pagination);
		request.setAttribute("sy", sy);
		request.setAttribute("st", supplyTypes);
		request.setAttribute("ti", typeId);
		request.setAttribute("tn", newsService.gainSupplyTypeNameById(typeId));
		request.setAttribute("asm", status);
		return "toMoreForGQXX";
	}
	
	/**
	* @Title: toCppc
	* @Description: 点击首页导航栏--'产品评测'--跳转汽配资讯页面
	* @param @return    设定文件
	* @return String    返回类型
	*/
	public String toCppc(){
		News temp=new News();
		temp.setId("");
		Map<String, Object> newsCatMap = new HashMap<String, Object>();
		Map<String, Object> param;
		newsCatMap.put("0", "整车评测");
		newsCatMap.put("1", "配件评测");
//		newsCatMap.put("2", "发动机附件评测");
//		newsCatMap.put("3", "驾驶室评测");
//		newsCatMap.put("4", "变速器总成评测");
//		newsCatMap.put("5", "离合器评测");
//		newsCatMap.put("6", "转向系统评测");
//		newsCatMap.put("7", "挂车评测");
//		newsCatMap.put("8", "电气系统评测");
//		newsCatMap.put("9", "传动评测");
//		newsCatMap.put("10", "悬挂评测");
//		newsCatMap.put("11", "车架评测");
//		newsCatMap.put("12", "自卸上装评测");
//		newsCatMap.put("13", "前中后桥评测");
//		newsCatMap.put("14", "制动系统评测");
//		newsCatMap.put("15", "油品评测");
//		newsCatMap.put("16", "螺母及螺栓评测");
//		newsCatMap.put("17", "轴承评测");
		for (int i = 0; i <= 1; i++) {
			List<News> list = new ArrayList<News>();
			param = new HashMap<String, Object>();
			param.put("newsCatName", String.valueOf(newsCatMap.get(i + "")));
			List<News> temp1 = newsService.gainNewsForQPZX(param);
			map.put("top_"+i, temp1.size()>0?temp1.get(0):temp1);
			if(temp1.size()>=2){
				list = temp1.subList(1, temp1.size() >= 15 ? 15 : temp1.size());
			}
			map.put("news_" + i, list);
		}
		return "toCppc";
	}
	
	
	public String toSchq() {
		News temp=new News();
		temp.setId("");
		Map<String, Object> newsCatMap = new HashMap<String, Object>();
		Map<String, Object> param;
		newsCatMap.put("0", "国际重配");
		newsCatMap.put("1", "中国重配");
		newsCatMap.put("2", "品牌重配");
		for (int i = 0; i <= 2; i++) {
			List<News> list = new ArrayList<News>();
			param = new HashMap<String, Object>();
			param.put("newsCatName", String.valueOf(newsCatMap.get(i + "")));
			List<News> temp1 = newsService.gainNewsForQPZX(param);
			map.put("top_"+i, temp1.size()>0?temp1.get(0):temp1);
			if(temp1.size()>=2){
				list = temp1.subList(1, temp1.size() >= 15 ? 15 : temp1.size());
			}
			map.put("news_" + i, list);
		}
		return "toSchq";
	}
	/**
	 * @Title: toDetailNews
	 * @Description: 点击新闻详情
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public String toDetailNews() {
		news = newsService.gainNewsById(request.getParameter("id"));
		Integer temp=(int)(Math.random()*10)+1;
		news.setViewnum(news.getViewnum()+temp);
		newsService.updateNewsViewNumById(news);
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if (sessionInfo != null && sessionInfo.getUserId() != null && !"".equals(sessionInfo.getUserId())) {
			//插入浏览记录
			Views views = new Views();
			views.setId(ToolsUtil.getUUID());
			views.setUserId(sessionInfo.getUserId());
			views.setViewId(news.getId());
			views.setCreatetime(new Date());
			views.setType("news");
			memberCollectService.insetMemberViews(views);
		}

		return "toDetailNews";
	}
	public String toDetailZpcNews() {
		String tempncn=request.getParameter("ncn");
		newsCatName=URLDecoderTwice.decoder(tempncn);
		news = newsService.gainNewsById(request.getParameter("id"));
		Integer temp=(int)(Math.random()*10)+1;
		news.setViewnum(news.getViewnum()+temp);
		newsService.updateNewsViewNumById(news);
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if (sessionInfo != null && sessionInfo.getUserId() != null && !"".equals(sessionInfo.getUserId())) {
			//插入浏览记录
			Views views = new Views();
			views.setId(ToolsUtil.getUUID());
			views.setUserId(sessionInfo.getUserId());
			views.setViewId(news.getId());
			views.setCreatetime(new Date());
			views.setType("news");
			memberCollectService.insetMemberViews(views);
		}
		request.setAttribute("ncn", newsCatName);
		return "toDetailZpcNews";
	}
	
	
	
	
	public String toUploadPage(){
		return "uploadPage";
	}

	
	
	/**
	 * @Title: toMore
	 * @Description: 表头搜索
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public String searchAllNews() {
		Map<String, Object> map1 = new HashMap<String, Object>();
		if(null!=topSearchLike){
			map1.put( "topSearchLike",URLDecoderTwice.decoder(topSearchLike));
		}
		Pagination pagination = definationPagination(request);
		pagination.setRows(26L);// 设置每页显示几条数据
		map1.put("page", pagination.getPage());
		map1.put("rows", pagination.getRows());
		
		list = newsService.searchAllNews(map1);
		request.setAttribute("topSearchLike",URLDecoderTwice.decoder(topSearchLike));
		request.setAttribute("searchType",searchType);
		pagination.setTotalCount(newsService
				.searchAllNewsCount(map1));
		request.setAttribute("pagination", pagination);
		return "searchAllNews";
	}
	/**
	 * @Title: 古道金典页面
	 * @Description: 
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public String toQlqpc() {
		News temp=new News();
		temp.setId("");
		Map<String, Object> newsCatMap = new HashMap<String, Object>();
		Map<String, Object> param;
		newsCatMap.put("0", "古道热点");
		newsCatMap.put("1", "聚焦业主");
		newsCatMap.put("2", "项目最新信息");
		newsCatMap.put("3", "省汽配商会简讯");
		for (int i = 0; i <= 3; i++) {
			List<News> list = new ArrayList<News>();
			param = new HashMap<String, Object>();
			param.put("newsCatName", String.valueOf(newsCatMap.get(i + "")));
			List<News> temp1 = newsService.gainNewsForQPZX(param);
			map.put("top_"+i, temp1.size()>0?temp1.get(0):temp1);
			if(temp1.size()>=2){
				list = temp1.subList(1, temp1.size() >= 7 ? 7 : temp1.size());
			}
			map.put("news_" + i, list);
		}
		return "toQlqpc";
	}
	// ------------------------------------------------------------------------------------
	/**
	 * @return the news
	 */
	public News getNews() {
		return news;
	}

	/**
	 * @param news
	 *            the news to set
	 */
	public void setNews(News news) {
		this.news = news;
	}

	/**
	 * @return the map
	 */
	public Map<String, Object> getMap() {
		return map;
	}

	/**
	 * @param map
	 *            the map to set
	 */
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	/**
	 * @return the list
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<?> list) {
		this.list = list;
	}

	/**
	 * @return the newsCatName
	 */
	public String getNewsCatName() {
		return newsCatName;
	}

	/**
	 * @param newsCatName
	 *            the newsCatName to set
	 */
	public void setNewsCatName(String newsCatName) {
		this.newsCatName = newsCatName;
	}
	
	public static void main(String[] args) {
		//4I6+rrJavKU=
		System.out.println(PwdCrypt.encrypt("配件知识"));
		System.out.println(PwdCrypt.decrypt("6YSu5LqV556G6K6l"));
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getTopSearchLike() {
		return topSearchLike;
	}

	public void setTopSearchLike(String topSearchLike) {
		this.topSearchLike = topSearchLike;
	}

}
