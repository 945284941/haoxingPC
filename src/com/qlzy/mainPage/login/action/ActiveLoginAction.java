package com.qlzy.mainPage.login.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import com.qlzy.active.service.MemberCenterService;
import com.qlzy.common.tools.MD5;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.common.tools.UtilCommon;
import com.qlzy.email.util.EmailUtils;
import com.qlzy.email.util.GenerateLinkUtils;
import com.qlzy.mainPage.login.service.LoginService;
import com.qlzy.mainPage.regions.service.RegionsService;
import com.qlzy.memberCenter.call.service.MemberCallService;
import com.qlzy.model.CarBrand;
import com.qlzy.model.Company;
import com.qlzy.model.CompanysCarbrand;
import com.qlzy.model.Member;
import com.qlzy.model.MemberJob;
import com.qlzy.model.Regions;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.LoadpropertiesUtil;

/**
 * @ClassName: LoginAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Huifeng Wang
 * @date 2013-5-23 上午11:22:47
 * 
 */
@Namespace("/")
@Action(value = "activeLogin", results = {
		@Result(name = "toActiveLogin", location = "/active/loginRegister/ActiveMemberLogin.jsp"),
		@Result(name = "toMemberNotice", location = "/active/loginRegister/ActiveMemberNotice.jsp"),
		@Result(name = "toMemberRegister", location = "/active/loginRegister/ActiveMemberRegister.jsp"),
		@Result(name = "toActiveMemberCheckMsg", location = "/active/loginRegister/ActiveMemberCheckMsg.jsp"),
		@Result(name = "toActiveMemberModifyPwd", location = "/active/loginRegister/ActiveMemberModifyPwd.jsp"),
		@Result(name = "toMemberRegisterMsg", location = "/active/loginRegister/ActiveMemberRegisterMsg.jsp"),
		@Result(name = "toMemberShareFriend", location = "/active/loginRegister/ActiveMemberShareFriend.jsp")
		})

public class ActiveLoginAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private LoginService loginService;
	@Autowired
	private MemberCallService memberCallService;
	@Autowired
	private RegionsService regionsService;
	@Autowired
	private MemberCenterService memberCenterService;
	private List<Regions> citylist;
	private List<Regions> regionlist;
	private List<Regions> arealist;
	private List<CarBrand> carBrandList;
	private List<CarBrand> carBrandByPidList;
	private List<MemberJob> memberJobList;
	private Company company;
	private Member member;
	private CompanysCarbrand companysCarBrand;
	private CarBrand carBrand;
	private String cityId;
	private String proId;
	private String pid;
	private File[] fileupload; // 和JSP中input标记name同名
	private String[] fileuploadFileName; // 上传来的文件的名字
	// private String[] imageContentType; // 文件类型
	private String veryCode;// 验证码
	private String carBrandId;
	private String nickName;// 昵称
	private String loginName;// 登录名称
	private String loginPwd;// 登录密码
	private String loginCode;// 登录验证码
	private String firstName;
	private List<Member> loginMemberList;
	private List<Member> regMemberList;
	private List<Member> goodsCheckList;
	private List<Member> goodsActiveList;
	Logger log = Logger.getLogger(this.getClass());

	/***
	 * 进入登录界面
	 * 
	 * @return
	 */
	public String toLogin() {
		return "toLogin";
	}

	public String toActiveLogin() {
		return "toActiveLogin";
	}
	public String toMemberNotice() {
		return "toMemberNotice";
	}
	public String toActiveMemberCheckMsg(){
		return "toActiveMemberCheckMsg";
	}
	public String toActiveforgotPwdSuccess(){
		
		return "toforgotPwdSuccess";
	}
	//好友分享生成新链接
	public String toActiveShareFriend(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		String Uid = sessionInfo.getUserId();
		String friendUrl = GenerateLinkUtils.generateResetNewUrl(Uid);
		request.setAttribute("friendUrl", friendUrl);
		return "toMemberShareFriend";
	}
	/***
	 * 点击链接进入修改密码界面
	 * @return
	 */
	public String toActiveforgotClickUrl(){
		String userName = request.getParameter("userName");
		String userId = request.getParameter("mdid");
		String userType = request.getParameter("userType");
		GenerateLinkUtils pwdCrypt = new GenerateLinkUtils();
		String uname = pwdCrypt.decrypt(userName);
		String uId = pwdCrypt.decrypt(userId);
		
		request.setAttribute("userId", uId);
		request.setAttribute("userName", uname);
		request.setAttribute("userType", userType);
		return "toActiveMemberModifyPwd";
	}
	/***
	 * 检查用户申请的用户名是否存在
	 */
	public void toActiveMemberCheckPwdMsg(){
		Member user = null;
		Company cuser = null;
		String userEmail = "";
		String userName = "";
		String userId = "";
		String eMsg = "";
		String userType = "";
		List<Member> mb = loginService.getMemberListByName(member.getUsername());
		List<Company> companyList = loginService.getCompanyListByName(member.getUsername());
		if(null != mb && mb.size() > 0){
			user = mb.get(0);
			userEmail = user.getEmail();
			userName = user.getUsername();
			userId = user.getId();
			userType = "m";
		}
		if(null != companyList && companyList.size() > 0){
			cuser = companyList.get(0);
			userEmail = cuser.getEmail();
			userName = cuser.getUsername();
			userId = cuser.getId();
			userType = "c";
		}
		if (null == user && null == cuser) {
			eMsg = "error";			
		}else{
			EmailUtils.sendResetPasswordEmail(userEmail,userName,userId,userType);
			eMsg = userEmail;
		}
		super.writeJson(eMsg);
	}
	/***
	 * 修改密码
	 */
	public void toActiveModifyPwd(){
		String rsg = "";
		String paw = MD5.encrypt(member.getPassword());
		String userType = request.getParameter("userType");	
		try {
			if("c".equals(userType)){
				company = loginService.getCompanyListByName(member.getUsername()).get(0);
				company.setPassword(paw);
				loginService.updateCompany(company);
			}
			if("m".equals(userType)){
				member.setPassword(paw);
				loginService.updateMember(member);
			}
			
			rsg = "su";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rsg = "er";
			e.printStackTrace();
			
		}
		super.writeJson(rsg);
	}

	/***
	 * 最新动态刷新
	 */
	public void toReflash() {
//		loginMemberList = loginService.memberLoginListByTime();
//		regMemberList = loginService.memberRegListByTime();
//		goodsCheckList = loginService.memberCollectGoodsCheckListByTime();
//		goodsActiveList = loginService.membergainCollectGoodsListByTime();
		loginMemberList = loginService.memberLoginListAll();
		regMemberList = loginService.memberRegListAll();
		goodsCheckList = loginService.memberCollectGoodsCheckListAll();
		goodsActiveList = loginService.membergainCollectGoodsListAll();
		log.info("ActiveLoginAction++++toReflash+++++loginMemberList========"
				+ loginMemberList + "++++++++regMemberList======"
				+ regMemberList + "++++++++goodsActiveList======"+goodsActiveList);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("loginMemberList", loginMemberList);
		map.put("regMemberList", regMemberList);
		map.put("goodsCheckList", goodsCheckList);
		map.put("goodsActiveList", goodsActiveList);
		super.writeJson(map);

	}

	/***
	 * 登录检查
	 */
	public void login() {
		// 检查验证码是否正确
		log.info(" login  request session======：" + session);
		String validateC = (String) request.getSession().getAttribute(
				"validateCode");
		String result = "";
		log.info(" login  request validateC======：" + validateC
				+ "+++++loginCode=====" + loginCode);
		if (null == loginCode || "".equals(loginCode)) {
			result = "no";
		} else {
			if (null == validateC || "".equals(validateC)) {
				result = "sessionold";
			} else {
				if (!validateC.equalsIgnoreCase(loginCode)) {
					result = "fail";
				} else {
					// 查询是否有该用户名
					List<Company> companyList = loginService
							.getCompanyListByName(loginName);
					if (companyList.size() > 0) {
						for (Company companydto : companyList) {
							String pwd = companydto.getPassword();
							String newpwd = MD5.encrypt(loginPwd);
							// 检查密码是否正确
							if (pwd.equals(newpwd)) {
								result = "success";
								SessionInfo sessionInfo = new SessionInfo();
								sessionInfo.setUserId(companydto.getId());
								sessionInfo.setLoginName(companydto
										.getUsername());
								sessionInfo.setIp(getIpAddr());
								sessionInfo.setUserType("company");
								loginService.updateSeCartLog(session,response, request,
										sessionInfo, companydto);
							} else {
								result = "pwdError";
							}
						}

					}
					List<Member> memberList = loginService
							.getMemberListByName(loginName);
					if (memberList.size() > 0) {
						for (Member memberdto : memberList) {
							String pwd = memberdto.getPassword();
							String newpwd = MD5.encrypt(loginPwd);
							// 检查密码是否正确
							if (pwd.equals(newpwd)) {
								result = "success";
								SessionInfo sessionInfo = new SessionInfo();
								sessionInfo.setUserId(memberdto.getId());
								sessionInfo.setLoginName(memberdto
										.getUsername());
								if (null != memberdto.getFirstname()
										&& "".equals(memberdto.getFirstname())) {
									sessionInfo.setLoginNickName(memberdto
											.getFirstname());
								}
								sessionInfo.setIp(getIpAddr());
								sessionInfo.setUserType("member");
								// 保存session值，更新购物车，添加日志
								loginService.updateSeCartLog(session,response, request,
										sessionInfo, memberdto);
							} else {
								result = "pwdError";
							}
						}

					}
					if (companyList.size() == 0 && memberList.size() == 0) {
						result = "nameError";
					}

				}
			}
		}

		super.writeJson(result);
	}

	public String regist() {
		return "regist";
	}

	/***
	 * 注册信息
	 * 
	 * @return
	 */
	/***
	 * 进入企业注册
	 */
	public String toCompanyRegisteMsg() {

		return "toCompanyRegisteMsg";
	}

	/***
	 * 企业注册
	 */
	public void companyRegister() {
		String result = "";
		String[] carBrand = carBrandId.split(",");
		company.setId(ToolsUtil.getUUID());
		String paw = MD5.encrypt(company.getPassword());
		company.setPassword(paw);
		try {
			loginService.CompanyAndcompanysCarbrandInsert(company, carBrand,
					request, session);
			result = "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = "fail";
			log.error("companyRegister", e);
			e.printStackTrace();
		}

		super.writeJson(result);
	}

	/***
	 * 进入会员注册
	 * 
	 * @return
	 */
	public String toMemberRegister() {
		String mdid = request.getParameter("mdid");
		request.setAttribute("mdid", mdid);
		return "toMemberRegister";
	}

	/***
	 * 进入会员详细信息注册
	 */
//	public String toMemberRegisterMsg() {
//		// 获取地址信息
//		citylist = regionsService.gainProvinceList();
//		log.info("地市数组列表的size为：" + citylist == null ? 0 : citylist.size());
//		// 获取从事领域
//		System.out.println( request.getAttribute("username"));
//		request.setAttribute("username", request.getAttribute("username"));
//		request.setAttribute("password", request.getAttribute("password"));
//		memberJobList = loginService.gainMemberJobList();
//		return "toMemberRegisterMsg";
//	}

	/***
	 * 查询所在市
	 */
	public void toRegions() {
		regionlist = regionsService.gainCityListByPid(proId);
		super.writeJson(regionlist);
	}

	/***
	 * 查询所在区
	 */
	public void toArea() {
		arealist = regionsService.gainAreaListByCityId(cityId);
		super.writeJson(arealist);
	}

	/***
	 * 根据主销车型一级ID查二级信息
	 */
	public void toCarBrandByPid() {
		carBrandByPidList = loginService.gainCarBrandListByPid(pid);
		super.writeJson(carBrandByPidList);
	}

	/***
	 * 会员注册
	 */
	public String memberRegister() {
		// 获取地址信息
		citylist = regionsService.gainProvinceList();
		log.info("地市数组列表的size为：" + citylist == null ? 0 : citylist.size());
		// 获取从事领域
		request.setAttribute("member",member);
		memberJobList = loginService.gainMemberJobList();
		return "toMemberRegisterMsg";

	}

	/***
	 * 会员更新详细信息
	 */
	public void memberMsgRegister() {
		String result = "";
			try {
				loginService.memberInsert(member, request, session);
			
				result = "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				result = "fail";
				log.error("memberMsgRegister", e);
				e.printStackTrace();
			}
		super.writeJson(result);

	}

	/***
	 * 校对资格验证
	 */
	public void jdsjCheckByMemberId() {
		String result = "";
		long numC = 0;
		LoadpropertiesUtil pr = new LoadpropertiesUtil();
		Properties propertie = pr.loadproperties("shopSet.properties");
		int numCheck = Integer.parseInt(propertie.getProperty("numC"));
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if (null == sessionInfo) {
			// 跳转到登录界面
			result = "oldsession";
		} else {
			long memberCount = memberCenterService.gainUploadCountByMemberId(sessionInfo
					.getUserId(), 1);
			numC = numCheck - memberCount;
			if (numC <= 0) {
				result = "success";
			} else {
				result = Long.toString(numC);
			}
		}
		super.writeJson(result);
	}
	
	/***
	 * 检查是否有重名用户名\验证码是否正确
	 */
	public void toveryCode() {
		String result = "";
		String validateC = (String) request.getSession().getAttribute(
				"validateCode");
		
		log.info("request validateC======：" + validateC + "+++++veryCode====="
				+ veryCode);
		if (null == veryCode || "".equals(veryCode)) {
			result = "no";
		} else {
			if (null == validateC || "".equals(validateC)) {
				result = "oldsession";
			} else {
				if (!validateC.equalsIgnoreCase(veryCode)) {
					result = "fail";
				}
			}
		}
		int size = 0;
		List<Company> companyList = loginService.getCompanyListByName(nickName);
		List<Member> memberList = loginService.getMemberListByName(nickName);

		size = companyList.size() + memberList.size();

		if (size > 0) {
			result = "exist";
		}
		super.writeJson(result);

	}

	/***
	 * 检查是否有重名昵称\验证码是否正确
	 */
	public void toCheckMemberName() {

		String result = "";
		int size = 0;
		// List<Company> companyList =
		// loginService.getCompanyListByName(nickName);
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());
//		if (null == sessionInfo) {
//			// 跳转到登录界面
//			result = "oldsession";
//		} else {
			List<Member> memberList = loginService
					.getMemberListByFirstName(firstName);

			size = memberList.size();

			if (size > 0) {
				result = "exist";
			}
//		}
		super.writeJson(result);

	}

	/****
	 * 更新企业详细信息
	 */
	public void uploadFile() {
		String comId = "";
		String extName = ""; // 保存文件拓展名
		String result = "";
		String[] filePathArray = new String[0];
		String companyImgPath = "";
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if (null == sessionInfo) {
			// 跳转到登录界面
			result = "oldsession";
		} else {

			comId = sessionInfo.getUserId();
			String savePath = ServletActionContext.getServletContext()
					.getRealPath("")
					+ "/"; // 获取项目根路径
			savePath = savePath + ResourceUtil.getCompany_Img_Directory();
			companyImgPath = ResourceUtil.getCompany_Img_Directory();
			File up = new File(savePath);
			if (!up.exists()) {
				up.mkdirs();
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8"); // 务必，防止返回文件名是乱码
			// 取得需要上传的文件数组
			File[] files = getFileupload();
			if (files != null && files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					// 获取拓展名
					if (fileuploadFileName[i].lastIndexOf(".") >= 0) {
						extName = fileuploadFileName[i]
								.substring(fileuploadFileName[i]
										.lastIndexOf("."));
					}
					try {
						String newFileName = UUID.randomUUID().toString()
								.replaceAll("-", "")
								+ extName;
						String filePath = savePath + newFileName;
						String saveCompanyImgPath = companyImgPath
								+ newFileName;
						saveCompanyImgPath = saveCompanyImgPath.replace("//",
								"/");
						filePath = filePath.replace("//", "/");

						// 检查上传的是否是图片
						if (UtilCommon.checkIsImage(extName)) {

							log.info("copy=== " + files[i] + " ===to=== "
									+ filePath);
							FileUtils.copyFile(files[i], new File(filePath));
							filePathArray = insertArray(filePathArray,
									saveCompanyImgPath);
						} else {
							result = "typeerror";
						}
					} catch (IOException e) {
						e.printStackTrace();
						log.error("uploadFile", e);
						result = "fail";
					}

				}
				if (filePathArray.length == 1) {
					company.setLicenceSrc(filePathArray[0]);
				}
				if (filePathArray.length == 2) {
					company.setLicenceSrc(filePathArray[0]);
					company.setCompanyLogo(filePathArray[1]);
				}

			}
			company.setId(comId);
			try {
				loginService.updateCompany(company);
				result = "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("loginService.updateCompany", e);
				result = "failcompany";
				e.printStackTrace();
			}
		}
		super.writeJson(result);

	}

	/***
	 * 获得访问ip
	 * 
	 * @return
	 */
	public String getIpAddr() {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/***
	 * 添加字符串
	 */
	private static String[] insertArray(String[] arr, String str) {
		int size = arr.length;
		String[] tmp = new String[size + 1];
		System.arraycopy(arr, 0, tmp, 0, size);
		tmp[size] = str;
		return tmp;
	}

	public List<Regions> getCitylist() {
		return citylist;
	}

	public void setCitylist(List<Regions> citylist) {
		this.citylist = citylist;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public RegionsService getRegionsService() {
		return regionsService;
	}

	public void setRegionsService(RegionsService regionsService) {
		this.regionsService = regionsService;
	}

	public List<Regions> getRegionlist() {
		return regionlist;
	}

	public void setRegionlist(List<Regions> regionlist) {
		this.regionlist = regionlist;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<CarBrand> getCarBrandList() {
		return carBrandList;
	}

	public void setCarBrandList(List<CarBrand> carBrandList) {
		this.carBrandList = carBrandList;
	}

	public List<CarBrand> getCarBrandByPidList() {
		return carBrandByPidList;
	}

	public void setCarBrandByPidList(List<CarBrand> carBrandByPidList) {
		this.carBrandByPidList = carBrandByPidList;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public CompanysCarbrand getCompanysCarBrand() {
		return companysCarBrand;
	}

	public void setCompanysCarBrand(CompanysCarbrand companysCarBrand) {
		this.companysCarBrand = companysCarBrand;
	}

	public CarBrand getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

	public File[] getFileupload() {
		return fileupload;
	}

	public void setFileupload(File[] fileupload) {
		this.fileupload = fileupload;
	}

	public String[] getFileuploadFileName() {
		return fileuploadFileName;
	}

	public void setFileuploadFileName(String[] fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}

	public String getVeryCode() {
		return veryCode;
	}

	public void setVeryCode(String veryCode) {
		this.veryCode = veryCode;
	}

	public String getCarBrandId() {
		return carBrandId;
	}

	public void setCarBrandId(String carBrandId) {
		this.carBrandId = carBrandId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public List<Regions> getArealist() {
		return arealist;
	}

	public void setArealist(List<Regions> arealist) {
		this.arealist = arealist;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}

	public List<MemberJob> getMemberJobList() {
		return memberJobList;
	}

	public void setMemberJobList(List<MemberJob> memberJobList) {
		this.memberJobList = memberJobList;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


}
