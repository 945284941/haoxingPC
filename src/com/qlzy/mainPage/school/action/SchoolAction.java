package com.qlzy.mainPage.school.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.common.tools.URLDecoderTwice;
import com.qlzy.common.tools.URLEncoderTwice;
import com.qlzy.mainPage.news.service.NewsService;
import com.qlzy.mainPage.regions.service.RegionsService;
import com.qlzy.mainPage.school.service.SchoolService;
import com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService;
import com.qlzy.model.News;
import com.qlzy.model.TechnologyAnswer;
import com.qlzy.model.TechnologyQuestion;
import com.qlzy.model.Views;
import com.qlzy.model.ZpxyHuodongAttend;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;
@Namespace("/news")
@Action(value = "school", results = {
		@Result(name = "zpxy", location = "/admin/school/school.jsp"),
		@Result(name = "onLineMore", location = "/admin/school/school_online.jsp"),
		@Result(name = "jsdyMore", location = "/admin/school/school_jsdy.jsp"),
		@Result(name = "hybgMore", location = "/admin/school/school_hybg.jsp"),
		@Result(name = "toJsdyTw", location = "/admin/school/school_jsdytw.jsp"),
		@Result(name = "saveJsdy",type="redirect", location = "/school/jsdy_Succ?id=${id}"),
		@Result(name = "saveJsdySucc", location = "/admin/school/school_jsdytw2.jsp"),
		@Result(name = "gainJsdyListByCatName", location = "/admin/school/school_jsdylb.jsp"),
		@Result(name = "newsListByCatName", location = "/admin/school/school_onlinelb.jsp"),
		@Result(name = "hybgNewsListByCatName", location = "/admin/school/school_hybglb.jsp"),
		@Result(name = "viewHybg", location = "/admin/school/school_hybgcontent.jsp"),
		@Result(name = "viewJsdy", location = "/admin/school/school_jsdycontent.jsp"),
		@Result(name = "viewZxxt", location = "/admin/school/school_onlinecontent.jsp"),
		@Result(name = "viewZphd", location = "/admin/school/school_hdnr.jsp"),
		@Result(name = "saveZphd", type="redirect",location = "/school/hdview/${id}.html"),
		@Result(name = "saveTechnologyAnswer",type="redirect", location = "/school/jdview/${id}.html")
})
public class SchoolAction extends BaseAction{
	private static final long serialVersionUID = 2396579599299359207L;
	@Autowired
	private NewsService newsService;
	private TechnologyQuestion technologyQuestion;
	private File myfile;
	private String myfileName;
	private String id;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private MemberCollectService memberCollectService;
	@Autowired
	private RegionsService regionsService;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public File getMyfile() {
		return myfile;
	}
	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}
	public String getMyfileName() {
		return myfileName;
	}
	public void setMyfileName(String myfileName) {
		this.myfileName = myfileName;
	}
	public TechnologyQuestion getTechnologyQuestion() {
		return technologyQuestion;
	}
	public void setTechnologyQuestion(TechnologyQuestion technologyQuestion) {
		this.technologyQuestion = technologyQuestion;
	}
	public String toZpxy(){
		String tg=request.getParameter("tg");
		if(tg!=null){
			request.setAttribute("tg", true);
		}
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("newsCatName", "重配学院新闻");
		map.put("page", 1);
		map.put("rows", 9);
		request.setAttribute("zpxylist", newsService.gainNewsListByNewsCatNameWithPage(map));
		map.put("newsCatName", "重配活动新闻");
		map.put("page", 1);
		map.put("rows", 7);
		map.put("newsattr","推荐");
		request.setAttribute("zphdlist", newsService.gainNewsListByNewsCatNameWithPage(map));
		map.put("newsCatName", "行业报告");
		map.put("newsattr","推荐");
		map.put("rows", 16);
		request.setAttribute("hybglist", newsService.gainNewsListByParentCatNameWithPage(map));
		map.put("newsCatName", "在线学堂");
		map.put("newsattr","推荐");
		map.put("rows", 14);
		request.setAttribute("zxxtlist", newsService.gainNewsListByParentCatNameWithPage(map));
		map.put("rows", 14);
		request.setAttribute("jsdylist", newsService.gainJsdyListByCatNameWithPage(map));
		
		map.put("rows", 11);
		request.setAttribute("datibang", schoolService.gainJsdyAnswerPaihangbangList(map));//排行榜
		request.setAttribute("xiazaibang", schoolService.gainXiazaiBangList(map));
		
		return "zpxy";
	}
	/**
	 * @Title: toMore
	 * @Description: 点击在线学堂其他页面更多
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public String gainNewsListByCatName() {
		String newsCatName=request.getParameter("ncn");
		newsCatName=URLDecoderTwice.decoder(newsCatName);
		String firstTitle=request.getParameter("title");
		Map<String, Object> map = new HashMap<String, Object>();
		if(firstTitle!=null && !"".equals(firstTitle.trim())){
			try {
				firstTitle =new String(firstTitle.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("firstTitle", firstTitle);
		}
		Pagination pagination = definationPagination(request);
		pagination.setRows(36L);// 设置每页显示几条数据
		map.put("newsCatName", newsCatName);
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		List<News> list = newsService.gainNewsListByNewsCatNameWithPage(map);
		pagination.setTotalCount(newsService.gainNewsListCountByNewsCatNameWithPage(map));
		request.setAttribute("pagination", pagination);
		request.setAttribute("ncn",URLEncoderTwice.decoder(newsCatName));
		request.setAttribute("newsCatName",newsCatName);
		request.setAttribute("list", list);
		return "newsListByCatName";
	}
	/**
	 * @Title: toMore
	 * @Description: 点击行业报告其他页面更多
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public String gainHybgNewsListByCatName() {
		String newsCatName=request.getParameter("ncn");
		Map<String, Object> map1 = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(36L);// 设置每页显示几条数据
		map1.put("newsCatName", newsCatName);
		map1.put("page", pagination.getPage());
		map1.put("rows", pagination.getRows());
		List<News> list = newsService.gainNewsListByNewsCatNameWithPage(map1);
		pagination.setTotalCount(newsService.gainNewsListCountByNewsCatNameWithPage(map1));
		request.setAttribute("pagination", pagination);
		request.setAttribute("ncn",URLEncoderTwice.decoder(newsCatName));
		request.setAttribute("newsCatName",newsCatName);
		request.setAttribute("list", list);
		return "hybgNewsListByCatName";
	}
	

	/**
	 * 查看技术答疑列表
	 * @author HuifengWang
	 * @return
	 */
	public String gainJsdyListByCatName(){
		String type=request.getParameter("ncn");
		type=URLDecoderTwice.decoder(type);
		String answer=request.getParameter("answer");
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(36L);// 设置每页显示几条数据
		map.put("type", type);
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		if(answer!=null && !"".equals(answer.trim())&& !"-1".equals(answer.trim()) ){
			map.put("kz3", answer.trim());
			request.setAttribute("answer", answer.trim());
		}else{
			request.setAttribute("answer", "-1");
		}
		List<TechnologyQuestion> list =newsService.gainJsdyListByCatNameWithPage(map);
		pagination.setTotalCount(newsService.gainJsdyListCountByCatNameWithPage(map));
		request.setAttribute("pagination", pagination);
		request.setAttribute("ncn",URLEncoderTwice.decoder(type));
		request.setAttribute("type",type);
		request.setAttribute("list", list);
		return "gainJsdyListByCatName";
	}
	
	/**
	 * @author HuifengWang
	 * 在线学堂更多页
	 * @return
	 */
	public String onLineMore(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("page", 1);
		map.put("rows", 6);
		map.put("newsCatName", "品牌知识");
		request.setAttribute("pp", newsService.gainNewsListByNewsCatNameWithPage(map));
		map.put("newsCatName", "整车知识");
		request.setAttribute("zc", newsService.gainNewsListByNewsCatNameWithPage(map));
		map.put("newsCatName", "配件知识");
		request.setAttribute("pj", newsService.gainNewsListByNewsCatNameWithPage(map));
		map.put("newsCatName", "维修知识");
		request.setAttribute("wx", newsService.gainNewsListByNewsCatNameWithPage(map));
		map.put("newsCatName", "保养知识");
		request.setAttribute("by", newsService.gainNewsListByNewsCatNameWithPage(map));
		map.put("newsCatName", "其他知识");
		request.setAttribute("qt", newsService.gainNewsListByNewsCatNameWithPage(map));
		return "onLineMore";
	}
	/**
	 * @author HuifengWang
	 * 行业报告更多页面
	 * @return
	 */
	public String hybgMore(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("page", 1);
		map.put("rows", 6);
		map.put("newsCatName", "整车需求行情");
		request.setAttribute("zcxq", newsService.gainNewsListByNewsCatNameWithPage(map));
		map.put("newsCatName", "整车市场行情");
		request.setAttribute("zcsc", newsService.gainNewsListByNewsCatNameWithPage(map));
		map.put("newsCatName", "重配市场行情");
		request.setAttribute("zp", newsService.gainNewsListByNewsCatNameWithPage(map));
		map.put("newsCatName", "维修厂需求及销售行情");
		request.setAttribute("wx", newsService.gainNewsListByNewsCatNameWithPage(map));
		map.put("newsCatName", "其他市场行情");
		map.put("rows", 12);
		request.setAttribute("qt", newsService.gainNewsListByNewsCatNameWithPage(map));
		return "hybgMore";
	}
	
	/**
	 * @author HuifengWang
	 * 技术答疑更多页面
	 * @return
	 */
	public String jsdyMore(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("page", 1);
		map.put("rows", 6);
		map.put("type", "整车选购");
		request.setAttribute("zc", newsService.gainJsdyListByCatNameWithPage(map));
		map.put("type", "配件答疑");
		request.setAttribute("pj", newsService.gainJsdyListByCatNameWithPage(map));
		map.put("type", "维护保养");
		request.setAttribute("wh", newsService.gainJsdyListByCatNameWithPage(map));
		map.put("type", "故障检测");
		request.setAttribute("gz", newsService.gainJsdyListByCatNameWithPage(map));
		map.put("type", "其他答疑");
		map.put("rows", 12);
		request.setAttribute("qt", newsService.gainJsdyListByCatNameWithPage(map));
		return "jsdyMore";
	}
	
	/**
	 * @author HuifengWang
	 * 跳转问题提问页面
	 * @return
	 */
	public String toJsdyTw(){
		return "toJsdyTw";
	}
	
	/**
	 * @author HuifengWang
	 * 保存技术答疑
	 * @return
	 */
	public String saveQuestion(){
		SessionInfo info = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(info==null){
			return "login_hf";
		}
		if(myfile!=null){
			// 检查文件扩展名
			String fileExt = myfileName.substring(myfileName.lastIndexOf(".") + 1)
					.toLowerCase();
			String savePath=ResourceUtil.getWebAppPath() + ".."
					+ ResourceUtil.get("jsdyimg") + "/";// 文件保存目录路径
			String saveUrl = ResourceUtil.get("jsdyimg")+"/";
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
			try {
				FileCopyUtils.copy(myfile, uploadedFile);
				technologyQuestion.setPicSrc(ResourceUtil.getWebPath() + saveUrl
						+ newFileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 利用spring的文件工具上传
		}
		
		technologyQuestion.setId(ToolsUtil.getUUID());
		technologyQuestion.setCreatetime(new Date());
		technologyQuestion.setModifytime(new Date());
		technologyQuestion.setUserId(info.getUserId());
		technologyQuestion.setKz1(info.getUserType());
		id=technologyQuestion.getId();
		schoolService.insertJsdy(technologyQuestion);
		return "saveJsdy";
	}
	
	/**
	 * @author HuifengWang
	 * 保存技术答疑之后跳转
	 * @return
	 */
	public String saveJsdySucc(){
		technologyQuestion=schoolService.gainTechnologyQuestionById(id);
		return "saveJsdySucc";
	}
	
	/**
	 * @author HuifengWang
	 * @return
	 * 查看行业列表
	 */
	public String viewHybg(){
		News news=new News();
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
		request.setAttribute("news", news);
		return "viewHybg";
	}
	
	/**
	 * @author HuifengWang
	 * 查看技术答疑页面
	 * @return
	 * 查看技术答疑
	 */
	public String viewJsdy(){
		TechnologyQuestion tec=new TechnologyQuestion();
		String tecId=request.getParameter("id");
		tec = schoolService.gainTechnologyQuestionById(tecId);
		Integer temp=(int)(Math.random()*10)+1;
		tec.setKz4(Integer.valueOf(tec.getKz4())+temp+"");
		schoolService.updateTechnologyQuestion(tec);
		request.setAttribute("tec", tec);
		Map<String,Object> map =new HashMap<String,Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(5L);// 设置每页显示几条数据
		map.put("questionId", tecId);
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		List<TechnologyAnswer> teca=schoolService.gainTechnologyAnswerListWithPage(map);
		pagination.setTotalCount(schoolService.gainTechnologyAnswerListCountWithPage(map));
		request.setAttribute("teca", teca);
		request.setAttribute("pagination", pagination);
		return "viewJsdy";
	}
	
	/**
	 * @author HuifengWang
	 * @return
	 * 查看在线学堂
	 */
	public String viewZxxt(){
		News news=new News();
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
		request.setAttribute("news", news);
		return "viewZxxt";
	}
	
	/**
	 * @author HuifengWang
	 * 查看重配活动新闻
	 * @return
	 */
	public String viewZphd(){
		String id = request.getParameter("id");
		News news = newsService.gainNewsById(id);
		Integer temp=(int)(Math.random()*10)+1;
		news.setViewnum(news.getViewnum()+temp);
		newsService.updateNewsViewNumById(news);
		request.setAttribute("news", news);
		request.setAttribute("regions",regionsService.gainProvinceList());
		return "viewZphd";
	}
	
	/**
	 * @author HuifengWang
	 * 保存重配活动
	 * @return
	 */
	public String saveZphd(){
		ZpxyHuodongAttend za=new ZpxyHuodongAttend();
		id=request.getParameter("news_id");
		za.setId(ToolsUtil.getUUID());
		za.setAddress(request.getParameter("address"));
		za.setDetailAddress(request.getParameter("detalAddress"));
		za.setCreatetime(new Date());
		za.setAttendNum(Long.valueOf(request.getParameter("attendNum")));
		za.setLinkman(request.getParameter("linkman"));
		za.setLinkmobile(request.getParameter("linkmobile"));
		return "saveZphd";
	}
	
	/**
	 * @author HuifengWang
	 * 技术答疑问题保存
	 * @return
	 */
	public String saveTechnologyAnswer(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(sessionInfo==null){
			return "login_hf";
		}
		id=request.getParameter("tecId");
		TechnologyAnswer ta=new TechnologyAnswer();
		ta.setId(ToolsUtil.getUUID());
		ta.setQuestionId(id);
		ta.setCreatetime(new Date());
		ta.setUserId(sessionInfo.getUserId());
		ta.setUserName(sessionInfo.getLoginName());
		ta.setUserType(sessionInfo.getUserType());
		ta.setContent(request.getParameter("content"));
		ta.setModifytime(new Date());
		schoolService.addTechnologyAnswer(ta);
		return "saveTechnologyAnswer";
	}
}
