package com.qlzy.mainPage.khzj.action;

import java.util.List;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.khzj.service.KhzjService;
import com.qlzy.model.Khcontent;
import com.qlzy.model.Khzj;
import com.qlzy.util.BaseAction;

/***
 * 
*    
* 项目名称：pro_shop   
* 类名称：KhZjAction   
* 类描述：   
* 创建人：Haili Yang  
* 创建时间：2015-1-30 下午2:37:57   
* 修改人：Haili Yang
* 修改时间：2015-1-30 下午2:37:57   
* 修改备注：   
* @version    
*
 */
@Namespace("/")
@Action(value = "khzj", results = {
		@Result(name = "toList", location = "/hdbm/khtp.jsp"),
		@Result(name="tokhlp",location="/hdbm/khlp.jsp")
})
public class KhzjAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private KhzjService khzjService;
	public List<Khzj> khzjList;
	public List<Khcontent> khcontentList;
	public List<Khcontent> khcontentListtop;
	private Khzj khzj;
	private Khcontent khcontent;
	private String khContentid;
	private String tpTelphone;
	private String tpUsername;

	/***
	 * 
	
	* @Title: toKhZj 
	
	* @Description: TODO(口号征集更新数据库得分信息\插入投票记录) 
	
	* @param     设定文件 
	
	* @return void    返回类型 
	
	* @throws
	 */
	public void upkhzj(){
		//查询这条记录的得分
		String result = "success";
		if(null != khContentid && !"".equals(khContentid)){
			khcontent =  khzjService.gainKhcontentById(khContentid);
			Khzj khzj1 = new Khzj();
			khzj1.setId(ToolsUtil.getUUID());
			khzj1.setKhContent(khcontent.getKhContent());
			khzj1.setKhContentid(khContentid);
			khzj1.setTpTelphone(tpTelphone);
			khzj1.setTpUsername(tpUsername);
			
			khcontent.setKhPonit(khcontent.getKhPonit() + 1) ;
			try {
				khzjService.updatekhzj(khcontent,khzj1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				log.info("upkhzj--",e);
				result = "fail";
			}
		}else{
			result = "fail";
		}
		super.writeJson(result);
	}
	public String tokhlp(){
		String id = request.getParameter("zc");
			if(null != id && !"".equals(id)){
				khcontent =  khzjService.gainKhcontentById(id);
			}
			
		if(null != khcontent){
			request.setAttribute("id", khcontent.getId());
			request.setAttribute("content", khcontent.getKhContent());
			request.setAttribute("point", khcontent.getKhPonit());
		}
		return "tokhlp";
	}
	/***
	 *  
	
	* @Title: toList 
	
	* @Description: TODO(查询所有口号内容) 
	
	* @param @return    设定文件 
	
	* @return String    返回类型 
	
	* @throws
	 */
	public String toList(){
		try {
			khcontentList = khzjService.gainKhzjContentAll();
			khcontentListtop = khzjService.gainKhzjContentTop4();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.info("toList--",e);
		}
		return "toList";
	} 
	/**
	 * 
	
	* @Title: checkPhone 
	
	* @Description: TODO(检查手机号吗是否重复) 
	
	* @param     设定文件 
	
	* @return void    返回类型 
	
	* @throws
	 */
	public void checkPhone(){
		String result = "ok";
		List<Khzj> khzjListCount = khzjService.gainKhzjListByTel(tpTelphone);
		if(null != khzjListCount && khzjListCount.size() > 0){
			result = "no";
		}
		super.writeJson(result);
	}
	
	public List<Khzj> getKhzjList() {
		return khzjList;
	}
	public void setKhzjList(List<Khzj> khzjList) {
		this.khzjList = khzjList;
	}
	public String getTpTelphone() {
		return tpTelphone;
	}
	public void setTpTelphone(String tpTelphone) {
		this.tpTelphone = tpTelphone;
	}
	public Khzj getKhzj() {
		return khzj;
	}
	public void setKhzj(Khzj khzj) {
		this.khzj = khzj;
	}
	public List<Khcontent> getKhcontentList() {
		return khcontentList;
	}
	public void setKhcontentList(List<Khcontent> khcontentList) {
		this.khcontentList = khcontentList;
	}
	public Khcontent getKhcontent() {
		return khcontent;
	}
	public void setKhcontent(Khcontent khcontent) {
		this.khcontent = khcontent;
	}
	public String getTpUsername() {
		return tpUsername;
	}
	public void setTpUsername(String tpUsername) {
		this.tpUsername = tpUsername;
	}
	public String getKhContentid() {
		return khContentid;
	}
	public void setKhContentid(String khContentid) {
		this.khContentid = khContentid;
	}
	public List<Khcontent> getKhcontentListtop() {
		return khcontentListtop;
	}
	public void setKhcontentListtop(List<Khcontent> khcontentListtop) {
		this.khcontentListtop = khcontentListtop;
	}
	
	
}
