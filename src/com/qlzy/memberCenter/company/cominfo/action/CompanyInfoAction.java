/**   
 * @Title: CompanyInfoAction.java 
 * @Package com.qlzy.memberCenter.company.cominfo.action 
 * @Description: TODO(企业信息管理) 
 * @author wangmei   
 * @date 2013-10-23 下午4:12:49 
 * @version V1.0   
 */
package com.qlzy.memberCenter.company.cominfo.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.memberCenter.common.service.QuestionService;
import com.qlzy.memberCenter.company.cominfo.service.CompanyInfoService;
import com.qlzy.model.Company;
import com.qlzy.model.Question;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;

@Namespace("/company")
@Action(value = "companyInfo", results = { @Result(name = "toShowAccountSecurity", location = "/memberCenter/company/commpanyInfo/accountSecurity.jsp") })
public class CompanyInfoAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	private CompanyInfoService companyInfoService;
	@Resource
	private QuestionService questionService;

	private List<Question> questions;// 安全保护问题列表

	private Company company;// 企业会员实体类

	/**
	 * @Title: toShowAccountSecurity
	 * @Description: TODO(跳转账号安全页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @author wangmei
	 */
	public String toShowAccountSecurity() {
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(null == sessionInfo){
			return "login_hf";
		}
		try {
			// 企业信息
			company = companyInfoService.gainCompanyById(sessionInfo
					.getUserId());

			// 获取安全保护问题
			String question = companyInfoService.gainQuestionByComId(company
					.getId());
//			company.setQuestion(question);

			Integer accountSecurityScore = 20;// 密码初始化20分
			if (null != company) {
				if (null != company.getQuestionId()
						&& !"".equals(company.getQuestionId())) {
					accountSecurityScore += 20;
				}
//				if (null != company.getEmailStatus()
//						&& 0 != company.getEmailStatus()) {
//					accountSecurityScore += 20;
//				}
//				if (null != company.getMobileStatus()
//						&& 0 != company.getMobileStatus()) {
//					accountSecurityScore += 20;
//				}
				if (null != company.getPayPassword()
						&& !"".equals(company.getPayPassword())) {
					accountSecurityScore += 20;
				}
			}
//			company.setAccountSecurityScore(accountSecurityScore);

			// 安全保护问题列表
			questions = questionService.gainAll();
		} catch (Exception e) {
			logger.error("company---toShowAccountSecurity", e);
			e.printStackTrace();
		}
		return "toShowAccountSecurity";
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
