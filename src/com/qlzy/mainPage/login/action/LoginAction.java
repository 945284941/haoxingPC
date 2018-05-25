package com.qlzy.mainPage.login.action;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


import com.aliyuncs.exceptions.ClientException;
import com.qlzy.common.tools.*;
import com.qlzy.common.util.PcOrWap;
import com.qlzy.mainPage.indexGoods.dao.QlDictMapper;
import com.qlzy.mainPage.indexGoods.service.DictionaryService;
import com.qlzy.mainPage.login.service.MemberService;
import com.qlzy.memberCenter.shop.action.UploadAction;
import com.qlzy.model.*;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import com.qlzy.email.util.EmailUtils;
import com.qlzy.email.util.GenerateLinkUtils;
import com.qlzy.mainPage.login.service.LoginService;
import com.qlzy.mainPage.regions.service.RegionsService;
import com.qlzy.memberCenter.call.service.MemberCallService;
import com.qlzy.memberCenter.company.cominfo.service.CompanyInfoService;
import com.qlzy.memberCenter.person.perinfo.service.PersonalInfoService;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;

/**
 * @ClassName: LoginAction
 * @Description:
 * @author Huifeng Wang
 * @date 2013-5-23 上午11:22:47
 * 
 */
@Namespace("/")
@Action(value = "login", results = {
		@Result(name = "toLogin", location = "/admin/login/login.jsp"),
		@Result(name = "toRegister", location = "/admin/login/register.jsp"),
		@Result(name = "toRegisterWap" , location = "/wap/register.jsp"),
		@Result(name = "index", type = "redirect", location = "/"),
		@Result(name = "loginPage", location = "/admin/login/mallLogin.jsp"),
		@Result(name = "shLoginPage", location = "/shanghui/login/login.jsp"),
		@Result(name = "loginError", type = "redirect", location = "/mallLogin.html?errmsg=${errmsg}&ln=${loginName}"),
		@Result(name = "toMemberNotice", location = "/admin/register/MemberNotice.jsp"),
		@Result(name = "toPage", type = "redirect", location = "${vs_url}"),
		@Result(name = "toCompanyRegister", location = "/admin/register/CompanyRegister.jsp"),
		@Result(name = "toCompanyRegisteMsg", location = "/admin/register/CompanyRegisterMsg.jsp"),
		@Result(name = "toMemberRegister", location = "/admin/register/MemberRegister.jsp"),
		@Result(name = "toMemberRegisterMsg", location = "/admin/register/MemberRegisterMsg.jsp"),
		@Result(name = "toMemberCheckMsg", location = "/admin/login/MemberCheckMsgNew.jsp"),
		@Result(name = "toMemberCheckMsgWap" , location = "/wap/EditMemberPwd.jsp"),
		@Result(name = "toMemberModifyPwd", location = "/admin/login/MemberModifyPwd.jsp"),
		@Result(name = "toLoginWap" , location = "/wap/login.jsp")
})

public class LoginAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private MemberCallService memberCallService;
	@Autowired
	private RegionsService regionsService;
	@Autowired
	private PersonalInfoService personalInfoService;
	@Autowired
	private CompanyInfoService companyInfoService;
	private List<Regions> citylist;
	private List<Regions> regionlist;
	private List<Regions> arealist;
	private List<CarBrand> carBrandList;
	private List<CarBrand> carBrandByPidList;
	private List<MemberJob> memberJobList;
	private Company company;
	private Member member;
	private CompanysCarbrand companysCarBrand;
	@Resource
	private MemberService memberService;
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
	private String mobileStatus;// 是否手机验证
	private String vs_url = "/";
	private String errmsg;
	Logger log = Logger.getLogger(this.getClass());

	public void doNotNeedSession_login() {

		super.writeJson("ok");
	}
	/***
	 * 进入登录界面
	 *
	 * @return
	 */
	public String toLogin() {
		return PcOrWap.isPc(request,"toLogin");
	}
	/***
	 * 进入注册页面
	 * @return
     */
	public String toRegister() {
		return PcOrWap.isPc(request,"toRegister");
	}

	/***
	 * 登录验证
	 */
	public void login() {
		String result = "";
		// 查询是否有该用户名
			List<Member> memberList = loginService
					.gainMemberByLoginName(loginName);
			if (null != memberList && memberList.size() > 0) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("username", loginName);
				map.put("password", MD5.encrypt(loginPwd));
				memberList = loginService.validateLogin(map);
				if (memberList.size() == 1) {
					for (Member memberdto : memberList) {
						result = "success";
						SessionInfo sessionInfo = new SessionInfo();
						sessionInfo.setUserId(memberdto.getId());
						sessionInfo.setLoginName(memberdto.getUsername());
						sessionInfo.setIp(getIpAddr());
						sessionInfo.setUserType("member");
						session.put(ResourceUtil.getSessionInfoName(),
								sessionInfo);
						memberCallService.updateCartByCookie(response,
								request, sessionInfo);

					}
				} else {
					result = "pwdError";
				}
			}else{
				result = "nameError";
			}

		super.writeJson(result);
	}

	/***
	 * 发送验证码 注册
	 */
	public void sendCode(){
		String result = "000";
		if(null != loginName && !"".equals(loginName)){
			String randNum = CodeUtils.createRandom(true, 6);
			System.out.println(randNum);
			try {
				boolean ss = Sms.Send(loginName, randNum,"1");
				if (ss) {
					result = "000";
			// 发送校验码记录日志
					personalInfoService.sendMobileCode(loginName,
					randNum,  request.getParameter("type"));
				}
			} catch (ClientException e) {
				log.info(e.getMessage());
				e.printStackTrace();
				result = "001";
			}
		}else{
			result = "001";
		}

		super.writeJson(result);
	}

	/***
	 * 会员注册
	 */
	public void register(){
		String result = "000";
		//查询验证码是否正确
		int a = 0;
		List<MobileMessage> mobileMessages = personalInfoService
				.gainMobileMessagesByMap(loginName, loginCode);
		if (mobileMessages != null && mobileMessages.size() > 0) {
			for (MobileMessage ms : mobileMessages) {
				boolean flag = ToolsUtil.isCheckExpires(ms.getCreatetime(),
						Long.parseLong(ResourceUtil.getValidTime("1")));
				if (!flag) {
					a++;
				}
			}
			Map<String,String> parmMap = new HashMap<>();
			if (a == mobileMessages.size()) {
				result = "randNumError";
			}else{//判断该手机号是否已经注册 上级验证码是否准确
				if(null != member.getShangjiId() && !"".equals(member.getShangjiId())){
					//查询用户的上级随机码是否存在
					Member m = memberCallService.getMemberListByOnlyId(member.getShangjiId());
					if(null == m){
						result = "pIdisno";//推荐码不存在
					}
				}
				parmMap.put("username",loginName);
				Member cuMember = memberCallService.gainMemberListByMap(parmMap);
				//判断该手机号是否已经注册过了
				if(null != cuMember){
					result = "isexist";
				}
				if("000".equals(result)){
					member.setUsername(loginName);
					try {
						//添加二维码
						String qrCode = UploadAction.qrCode();
						member.setQrCode(qrCode);
						String memberId = memberCallService.addMember(member);
						//注册成功，放入session
						SessionInfo sessionInfo = new SessionInfo();
						sessionInfo.setUserId(memberId);
						sessionInfo.setLoginName(member.getUsername());
						sessionInfo.setIp(getIpAddr());
						sessionInfo.setUserType("member");
						session.put(ResourceUtil.getSessionInfoName(),
								sessionInfo);
						memberCallService.updateCartByCookie(response,
								request, sessionInfo);
					} catch (Exception e) {
						log.info(e.getMessage());
						e.printStackTrace();
						result = "sysError";
					}
				}
			}
		}
		super.writeJson(result);
	}








	public String loginPage() {

		return "loginPage";
	}

	public String loginShPage() {
		return "shLoginPage";
	}

	public String toMemberCheckMsg() {
		List<QlDict> dictList = dictionaryService.selectByType("kefu");
		for(QlDict q : dictList){
			if("电话".equals(q.getDescription())){
				String phone = q.getValue();
				request.setAttribute("phone",phone);
			}
			if("qq".equals(q.getDescription())){
				String qq = q.getValue();
				request.setAttribute("qq",qq);
			}
			if("skype".equals(q.getDescription())){
				String skype = q.getValue();
				request.setAttribute("skype",skype);
			}
		}

		return PcOrWap.isPc(request,"toMemberCheckMsg");
	}

	/**
	 * 登录密码修改
	 */
	public void updatePassword() {
		String result = "";
		int a = 0;
		String username = request.getParameter("username"); // 用户名
		String code = request.getParameter("randNum");
		List<MobileMessage> mobileMessages = personalInfoService
				.gainMobileMessagesByMap(username, code);
		String userId = "";
		String pwd = "";
		member = new Member();
		Member user = null;
		if (mobileMessages != null && mobileMessages.size() > 0) {
			for (MobileMessage ms : mobileMessages) {
				boolean flag = ToolsUtil.isCheckExpires(ms.getCreatetime(),
						Long.parseLong(ResourceUtil.getValidTime("1")));
				if (!flag) {
					a++;
				}
			}
			if (a != mobileMessages.size()) {
				String newPassword = request.getParameter("newPassword");
				List<Member> mb = loginService.getMemberListByUsername(username);
				try {
					if (null != mb && mb.size() > 0) {
						user = mb.get(0);
						userId = user.getId();
						if (null != newPassword && !"".equals(newPassword)) {
							pwd = MD5.encrypt(newPassword);
							member.setId(userId);
							member.setPassword(pwd);
						}
						personalInfoService.updatePersonInfo(member);
					}

					result = "success";
				} catch (Exception e) {
					logger.error("person-updateLoginPassword", e);
					e.printStackTrace();
				}
			}
		}

		writeJson(result);
	}





	/***
	 * 检查用户申请的用户名是否存在 根据邮箱找回密码
	 */
	public void toMemberCheckPwdMsg() {
		Member user = null;
		Company cuser = null;
		String userEmail = "";
		String userName = "";
		String userId = "";
		String eMsg = "";
		String userType = "";
		List<Member> mb = loginService
				.getMemberListByName(member.getUsername());
		List<Company> companyList = loginService.getCompanyListByName(member
				.getUsername());
		if (null != mb && mb.size() > 0) {
			user = mb.get(0);
			userEmail = user.getEmail();
			userName = user.getUsername();
			userId = user.getId();
			userType = "m";
		}
		if (null != companyList && companyList.size() > 0) {
			cuser = companyList.get(0);
			userEmail = cuser.getEmail();
			userName = cuser.getUsername();
			userId = cuser.getId();
			userType = "c";
		}
		if (null == user && null == cuser) {
			eMsg = "error";
		} else {
			EmailUtils.sendResetPasswordEmail(userEmail, userName, userId,
					userType);
			eMsg = userEmail;
		}
		super.writeJson(eMsg);
	}

	/***
	 * 
	 * 根据手机号找回密码 检查用户申请的用户名是否存在
	 * 
	 */
	public void toMemberCheckPwdMsgByPhone() {
		Map<String, Object> map = new HashMap<String, Object>();
		Member user = member;
		Company cuser = null;
		String userName = ""; // 用户名
		String mobile = ""; // 手机号
		String msg = "";
		//验证码判断
		try {
			int a = 0;
			List<MobileMessage> mobileMessages = personalInfoService
					.gainMobileMessagesByMap(loginName, loginCode);
			if (mobileMessages != null && mobileMessages.size() > 0) {
				for (MobileMessage ms : mobileMessages) {
					boolean flag = ToolsUtil.isCheckExpires(ms.getCreatetime(),
							Long.parseLong(ResourceUtil.getValidTime("1")));
					if (!flag) {
						a++;
					}
				}
				Map<String, String> parmMap = new HashMap<>();
				if (a == mobileMessages.size()) {
					msg = "randNumError";
				}else {
					member = new Member();
					member.setUsername(loginName);
					member.setPassword(MD5.encrypt(loginPwd));
					memberService.updatePasswordByUsername(member);
                    msg = "success";
					List<Member> mb = loginService
							.getMemberListByName(member.getUsername());
		/*	List<Company> companyList = loginService.getCompanyListByName(member
					.getUsername());*/

					if (null != mb && mb.size() > 0) {
						user = mb.get(0);
						userName = user.getUsername();
						if (null != user.getMobile() && !"".equals(user.getMobile())) {
							mobile = user.getMobile().substring(0, 3) + "****"
									+ user.getMobile().substring(7);

						} else {
							// 若手机号为空，则通过用户名，并判断用户名是否是手机号
							String regExp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";
							Pattern p = Pattern.compile(regExp);
							Matcher m = p.matcher(user.getUsername());
							boolean isMobile = m.find();
							if (isMobile) {
								mobile = user.getUsername().substring(0, 3) + "****"
										+ user.getUsername().substring(7);
							}
						}
					}
				}


			} else {
				msg = "randNumError";
			}
		}catch (Exception e){
			e.printStackTrace();

		}
		map.put("userName", userName);
		map.put("mobile", mobile);
		map.put("msg", msg);
		super.writeJson(map);
	}


	/**
	 * @Title: toPasswordUpdate
	 * @Description: 个人登录密码修改
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public void toPasswordUpdate() {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = request.getParameter("memberName"); // 用户名
		String newPassword_ = request.getParameter("newPassword");// 获取新密码
		String userId = "";
		String pwd = "";
		member = new Member();
		company = new Company();

		Member user = null;
		Company cuser = null;
		List<Member> mb = loginService.getMemberListByName(userName);
		List<Company> companyList = loginService.getCompanyListByName(userName);
		try {
			if (null != mb && mb.size() > 0) {
				user = mb.get(0);
				userId = user.getId();
				if (null != newPassword_ && !"".equals(newPassword_)) {
					pwd = MD5.encrypt(newPassword_);
					member.setId(userId);
					member.setPassword(pwd);
				}
				personalInfoService.updatePersonInfo(member);
			}
			if (null != companyList && companyList.size() > 0) {
				cuser = companyList.get(0);
				userId = cuser.getId();
				if (null != newPassword_ && !"".equals(newPassword_)) {// 企业
					pwd = MD5.encrypt(newPassword_);
					company.setId(userId);
					company.setPassword(pwd);
				}
				companyInfoService.updateComInfo(company);
			}
			map.put("res", "succ");
			map.put("msg", "密码修改成功！");
		} catch (Exception e) {
			map.put("res", "fail");
			map.put("msg", "密码修改失败！");
			logger.error("person-updateLoginPassword", e);
			e.printStackTrace();
		}
		writeJson(map);
	}

	/***
	 * 点击链接进入修改密码界面
	 * 
	 * @return
	 */
	public String toforgotClickUrl() {
		String userName = request.getParameter("userName");
		String userId = request.getParameter("mdid");
		String userType = request.getParameter("userType");
		GenerateLinkUtils pwdCrypt = new GenerateLinkUtils();
		String uname = pwdCrypt.decrypt(userName);
		String uId = pwdCrypt.decrypt(userId);

		request.setAttribute("userId", uId);
		request.setAttribute("userName", uname);
		request.setAttribute("userType", userType);
		return "toMemberModifyPwd";
	}

	/***
	 * 修改密码
	 */
	public void toModifyPwd() {
		String rsg = "";
		String paw = MD5.encrypt(member.getPassword());
		String userType = request.getParameter("userType");
		try {
			if ("c".equals(userType)) {
				company = loginService.getCompanyListByName(
						member.getUsername()).get(0);
				company.setPassword(paw);
				loginService.updateCompany(company);
			}
			if ("m".equals(userType)) {
				member.setPassword(paw);
				loginService.updateMember(member);
			}

			rsg = "su";
		} catch (Exception e) {
			rsg = "er";
			e.printStackTrace();

		}
		super.writeJson(rsg);
	}

	public String loginSuccess() {
		String result = "";
		System.out.println(request.getParameter("shLogin"));
		// 查询是否有该用户名
		List<Company> companyList = loginService
				.getCompanyListByName(loginName);
		if (companyList.size() > 0) {
			for (Company companydto : companyList) {

				String pwd = companydto.getPassword();
				String newpwd = MD5.encrypt(loginPwd);
				// 检查密码是否正确
				if (pwd.equals(newpwd)) {
					String isCheck = companydto.getIsCheck();
					if ("0".equals(isCheck)) {
						errmsg = "notStartCheck";
						result = "loginError";
					} else if ("2".equals(isCheck)) {
						errmsg = "isCheckFail";
						result = "loginError";
					} else {
						result = "toPage";
						SessionInfo sessionInfo = new SessionInfo();
						sessionInfo.setUserId(companydto.getId());
						sessionInfo.setLoginName(companydto.getUsername());
						sessionInfo.setIp(getIpAddr());
						sessionInfo.setUserType("company");
						sessionInfo.setShCheck(companydto.getShCheck());
						session.put(ResourceUtil.getSessionInfoName(),
								sessionInfo);
						memberCallService.updateCartByCookie(response, request,
								sessionInfo);
					}

				} else {
					errmsg = "error";
					result = "loginError";
				}

			}

		}
		List<Member> memberList = loginService.getMemberListByName(loginName);
		if (memberList.size() > 0) {
			for (Member memberdto : memberList) {
				String pwd = memberdto.getPassword();
				String newpwd = MD5.encrypt(loginPwd);
				// 检查密码是否正确
				if (pwd.equals(newpwd)) {
					result = "toPage";
					SessionInfo sessionInfo = new SessionInfo();
					sessionInfo.setUserId(memberdto.getId());
					sessionInfo.setLoginName(memberdto.getUsername());
					sessionInfo.setIp(getIpAddr());
					sessionInfo.setUserType("member");
					sessionInfo.setZhekou(memberdto.getZhekou());
					session.put(ResourceUtil.getSessionInfoName(), sessionInfo);
					memberCallService.updateCartByCookie(response, request,
							sessionInfo);
				} else {
					errmsg = "error";
					result = "loginError";
				}
			}

		}
		if (companyList.size() == 0 && memberList.size() == 0) {
			errmsg = "error";
			result = "loginError";
		}
		loginName = PwdCrypt.encrypt(loginName);
		System.out.println(result);
		return result;
	}




	public String toMemberNotice() {
		return "toMemberNotice";
	}

	/**
	 * 验证验证码是否正确
	 * 
	 * @author
	 */
	public void checkCode() {
		boolean flag = false;
		String code = request.getParameter("code");
		String codesession = (String) request.getSession().getAttribute(
				"validateCode");
		if (code != null && !"".equals(code)) {
			if (code.equalsIgnoreCase(codesession)) {
				flag = true;
			} else {
				flag = false;
			}
		}
		super.writeJson(flag);
	}



	public String regist() {
		return "regist";
	}

	public String logout() {
		session.remove(ResourceUtil.getSessionInfoName());
		session.clear();
		return "index";
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
		request.setAttribute("member", member);
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
			result = "fail";
			log.error("memberMsgRegister", e);
			e.printStackTrace();
		}
		super.writeJson(result);

	}

	/***
	 * 检查是否有重名昵称\验证码是否正确
	 */
	public void toveryCode() {
		String result = "";
		String validateC = (String) request.getSession().getAttribute(
				"validateCode");
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
		String shangjiId = request.getParameter("shangjiId");
		if (!(null == shangjiId || "".equals(shangjiId))) {
			List<Member> memberShangji = loginService
					.getMemberListByShangjiId(shangjiId);
			if (memberShangji.size() == 0) {
				result = "noShangji";
			}
		}
		super.writeJson(result);

	}

	/***
	 * 检查shangjiId是否存在
	 */
	public void toshangjiId() {
		String result = "no";
		String shangjiId = (String) request.getSession().getAttribute(
				"shangjiId");
		List<Member> memberList = loginService
				.getMemberListByShangjiId(shangjiId);
		if (memberList.size() > 0) {
			result = "yes";
		}
		super.writeJson(result);

	}

	/****
	 * 更新企业详细信息
	 */
	public void uploadFile() {
		String extName = ""; // 保存文件拓展名
		String result = "";
		String[] filePathArray = new String[0];
		String companyImgPath = "";
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"")
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
							.substring(fileuploadFileName[i].lastIndexOf("."));
				}
				try {
					String newFileName = UUID.randomUUID().toString()
							.replaceAll("-", "")
							+ extName;
					String filePath = savePath + newFileName;
					String saveCompanyImgPath = companyImgPath + newFileName;
					saveCompanyImgPath = saveCompanyImgPath.replace("//", "/");
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
		try {
			loginService.CompanyAndcompanysInsert(company, request, session);
			result = "success";
		} catch (Exception e) {
			log.error("loginService.updateCompany", e);
			result = "failcompany";
			e.printStackTrace();
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

	public PersonalInfoService getPersonalInfoService() {
		return personalInfoService;
	}

	public void setPersonalInfoService(PersonalInfoService personalInfoService) {
		this.personalInfoService = personalInfoService;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
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

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
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

	public String getMobileStatus() {
		return mobileStatus;
	}

	public void setMobileStatus(String mobileStatus) {
		this.mobileStatus = mobileStatus;
	}
	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getVs_url() {
		return vs_url;
	}

	public void setVs_url(String vs_url) {
		this.vs_url = vs_url;
	}


}
