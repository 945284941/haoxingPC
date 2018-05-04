/**??
* @Title: CompanyMemberAction.java
* @Package com.qlzy.memberCenter.company.action
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-10-15 下午1:23:39
* @version V1.0??
*/
package com.qlzy.memberCenter.company.companyMember.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.UtilCommon;
import com.qlzy.mainPage.regions.service.RegionsService;
import com.qlzy.memberCenter.company.companyMember.service.CompanyMemberService;
import com.qlzy.model.Company;
import com.qlzy.model.Regions;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;

/**
 * @ClassName: CompanyMemberAction
 * @Description: TODO(会员中心企业)
 * @author zhao yang bin
 * @date 2013-10-15 下午1:23:39
 *
 */
@Namespace("/")
@Action(value = "companyMemberAction", results = {
		@Result(name = "toBasicMessage", location = "/memberCenter/company/commpanyInfo/basicInfoCompany.jsp"),
		@Result(name = "toBasic", type="redirect" ,location = "company/companyMember/gainCompanyMessageById.html")
		
})
public class CompanyMemberAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private Company company;
	
	@Autowired
	private CompanyMemberService companyMemberService;
	@Resource
	private RegionsService regionsService;//区域接口类
	//省份列表
	private List<Regions> provinceList;
	private List<Regions> cityList;
	private List<Regions> areaList;
	private File fileupload; // 和JSP中input标记name同名
	private File logo;
	private File licence;
	private File storefrontSrc;
	private String logoFileName; // 上传来的文件的名字
	private String licenceFileName; // 上传来的文件的名字
	private String storefrontSrcFileName; // 上传来的文件的名字
	private SessionInfo sessionInfo;
	
	public String gainCompanyMessageById(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		company=companyMemberService.gainCompanyMessageById(sessionInfo.getUserId());
//		company.setNowTime(new Date());
//		company.setNowIp(getIpAddr());
		//获取省份列表
		provinceList = regionsService.gainProvinceList();
		cityList = regionsService.gainCityListByPid(company.getProvince());
		areaList = regionsService.gainAreaListByCityId(company.getCity());
		return "toBasicMessage";
	}
	
	public  String saveCompany(){
		File logo = getLogo();
			if(logo!=null){
				String	filePathArray = uploadFile(logo,logoFileName);
				company.setCompanyLogo(filePathArray);
			}
		File licence = getLicence();
			if(licence!=null){
				String	filePathArray = uploadFile(licence,licenceFileName);
				company.setLicenceSrc(filePathArray);
			}
		File storefrontSrc = getStorefrontSrc();
		if(storefrontSrc!=null){
			String	filePathArray = uploadFile(storefrontSrc,storefrontSrcFileName);
			company.setStorefrontSrc(filePathArray);
		}	
		company.setModifytime(new Date());
			companyMemberService.modifyCompany(company);
			return "toBasic";	
		
		
	}
	public String getLogoFileName() {
		return logoFileName;
	}

	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}

	public String uploadFile( File files,String fileName){
		String companyImgPath = "";
		String saveCompanyImgPath="";
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
		String extName = ""; // 保存文件拓展名
		// 获取拓展名
		if (fileName.lastIndexOf(".") >= 0) {
			extName = fileName
					.substring(fileName.lastIndexOf("."));
		}
		try {
			String newFileName = UUID.randomUUID().toString()
					.replaceAll("-", "")
					+ extName;
			String filePath = savePath + newFileName;
		    saveCompanyImgPath = companyImgPath + newFileName;
			saveCompanyImgPath = saveCompanyImgPath.replace("//", "/");
			filePath = filePath.replace("//", "/");

			// 检查上传的是否是图片
			if (UtilCommon.checkIsImage(extName)) {
				FileUtils.copyFile(files, new File(filePath));
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saveCompanyImgPath;
		
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
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public List<Regions> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<Regions> provinceList) {
		this.provinceList = provinceList;
	}
	public List<Regions> getCityList() {
		return cityList;
	}
	public void setCityList(List<Regions> cityList) {
		this.cityList = cityList;
	}
	public List<Regions> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<Regions> areaList) {
		this.areaList = areaList;
	}

	public File getFileupload() {
		return fileupload;
	}

	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}

	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		this.logo = logo;
	}

	public File getLicence() {
		return licence;
	}

	public void setLicence(File licence) {
		this.licence = licence;
	}

	public String getLicenceFileName() {
		return licenceFileName;
	}

	public void setLicenceFileName(String licenceFileName) {
		this.licenceFileName = licenceFileName;
	}

	public File getStorefrontSrc() {
		return storefrontSrc;
	}

	public void setStorefrontSrc(File storefrontSrc) {
		this.storefrontSrc = storefrontSrc;
	}

	public String getStorefrontSrcFileName() {
		return storefrontSrcFileName;
	}

	public void setStorefrontSrcFileName(String storefrontSrcFileName) {
		this.storefrontSrcFileName = storefrontSrcFileName;
	}
	
}
