package com.qlzy.mainPage.wantDiscuss.action;

import com.opensymphony.xwork2.ModelDriven;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.wantDiscuss.service.WantDiscussService;
import com.qlzy.model.WantDiscuss;
import com.qlzy.pojo.Json;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Action(value = "wantDiscussAction",results = {
        @Result(name = "toList", location = "/admin/want/lifeViewReply.jsp"),
})
public class WantDiscussAction extends BaseAction implements ModelDriven<WantDiscuss> {

    public WantDiscuss wantDiscuss = new WantDiscuss();

    private static final Logger logger = Logger.getLogger(WantDiscussAction.class);

    @Resource
    private WantDiscussService wantDiscussService;
    @Override
    public WantDiscuss getModel() {
        return wantDiscuss;
    }

    public String findList(){
        Pagination pagination = definationPagination(request);
        pagination.setRows(7L);
        List<WantDiscuss> wantDiscussList=new ArrayList<WantDiscuss>();
        try{
           String id = request.getParameter("id");
           wantDiscuss.setWantId(id);
           if(pagination.getPage()==0){
               wantDiscuss.setMinRow(pagination.getPage()*7);
               wantDiscuss.setMaxRow((pagination.getPage()+1)*7);
           }else{
               wantDiscuss.setMinRow((pagination.getPage()-1)*7);
               wantDiscuss.setMaxRow((pagination.getPage()+1)*7);
           }
            wantDiscussList=wantDiscussService.list(wantDiscuss);
            pagination.setTotalCount(wantDiscussService.count(wantDiscuss));

        }catch (Exception e){
          e.printStackTrace();
          logger.error("toList error");
        }
        request.setAttribute("pagination",pagination);
        request.setAttribute("wantDiscussList",wantDiscussList);
        return "toList";
    }
    public void add(){
        Json j= new Json();
        try{
            wantDiscuss.setId(ToolsUtil.getUUID());
            wantDiscuss.setCreateTime(new Date());
            wantDiscuss.setContent(request.getParameter("content"));
            SessionInfo sessionInfo= (SessionInfo) session.get(ResourceUtil
                    .getSessionInfoName());
            wantDiscuss.setMemberId(sessionInfo.getUserId());
            wantDiscussService.add(wantDiscuss);
            j.setMsg("添加成功");
            j.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("add error");
            j.setMsg("添加失败");
            j.setSuccess(false);
        }
      writeJson(j);
    }
}
