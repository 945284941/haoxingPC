package com.qlzy.mainPage.want.action;



import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.mainPage.want.service.WantBuyService;
import com.qlzy.model.WantBuy;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Namespace("/")
@Action(value = "Release", results = {

        @Result(name="Qiugoulist",location="/admin/want/wodefabulist.jsp")
})
public class ReleaseAction extends BaseAction {
    @Resource
    private WantBuyService wantBuyService;
    private WantBuy wantBuy=new WantBuy();
    private List<WantBuy> wantBuyList;
    public String Qiugoulist(){

        String wantBuyType = request.getParameter("buyType");
        Map<String,Object> parmMap = new HashMap<>();
        SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
                .getSessionInfoName());
        if(sessionInfo != null && sessionInfo.getUserId() != null && !"".equals(sessionInfo.getUserId())){

            parmMap.put("id",sessionInfo.getUserId());
            parmMap.put("buyType",wantBuyType);
            wantBuyList=wantBuyService.gainWantBuyPage(parmMap);
            request.setAttribute("wan", wantBuyList);
            if ("2".equals(wantBuyType)){
                return "Qiugoulist";
            }else if ("3".equals(wantBuyType)){
                return "Qiugoulist";
            }else if ("4".equals(wantBuyType)){
                return "Qiugoulist";
            }
        }else{
            return "";
        }

        return "Qiugoulist";

    }

    public  void  DelectWant(){
        String result = "success";
        String id=request.getParameter("id");
        if (id==null){
            result="";
        }
        wantBuyService.delectwan(id);
        super.writeJson(result);
    }


}
