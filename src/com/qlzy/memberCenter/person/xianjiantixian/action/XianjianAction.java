package com.qlzy.memberCenter.person.xianjiantixian.action;





import com.qlzy.common.tools.ResourceUtil;

import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.login.service.MemberService;
import com.qlzy.memberCenter.call.service.MemberCallService;
import com.qlzy.memberCenter.person.xianjiantixian.service.XianJinService;

import com.qlzy.model.Bankcard;
import com.qlzy.model.Member;
import com.qlzy.model.XianjinbiCashApply;
import com.qlzy.pojo.Json;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Namespace("/")
@Action(value = "shenqing", results = {

        @Result(name = "toList",location = "/memberCenter/person/personalInfo/shenqingtixian.jsp")

})
public class XianjianAction extends BaseAction {
    @Resource
    private MemberCallService memberCallService;
    @Resource
    private MemberService memberService;
    private static final long serialVersionUID = 1L;
    private  Member me=new Member();
    private XianjinbiCashApply xianjinbiCashApply;
    private XianJinService xianJinService;

    public String toList(){
        //申请提现的显示和id
        SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
                .getSessionInfoName());// 获取登录人信息
        if(sessionInfo != null && sessionInfo.getUserId() != null && !"".equals(sessionInfo.getUserId())){
            me=memberService.selectKey(sessionInfo.getUserId());
            request.setAttribute("me", me);


            sessionInfo = (SessionInfo) session.get(ResourceUtil
                    .getSessionInfoName());// 获取登录人信息
            List<Bankcard>  bankcards= memberCallService.gainBanckcard(sessionInfo.getUserId());
            request.setAttribute("ban", bankcards);
        }else{
            return "";
        }
            return "toList";
    }


    public void insertSelective(){
        Json j=new Json();
        try {
            String barndCard = request.getParameter("barndCard");
            String amount=request.getParameter("amount");//提现金额
            String realAmount=request.getParameter("realAmount");//实际到账金额
            String liucunAmount=request.getParameter("liucunAmount");//留存金额
            xianjinbiCashApply.setBankAccount(barndCard);
            xianjinbiCashApply.setAmount(Double.parseDouble(amount));
            xianjinbiCashApply.setRealAmount(Double.parseDouble(realAmount));
            xianjinbiCashApply.setId(ToolsUtil.getUUID());
            xianjinbiCashApply.setCreateTime(new Date());
            xianjinbiCashApply.setStatus("0");
            xianjinbiCashApply.setLiucunAmount(Double.parseDouble(liucunAmount));
            Member m =new Member();
            xianjinbiCashApply.setBankUser(m.getVocation());
            xianjinbiCashApply.setBankAccount(m.getBankcar());
            xianjinbiCashApply.setBankAddress(m.getAddress());
            xianjinbiCashApply.setBankAccount(barndCard);
            BigDecimal money = new BigDecimal(m.getAdvance());
            BigDecimal oldMoney = new BigDecimal(xianjinbiCashApply.getAmount());
            m.setAdvance(money.subtract(oldMoney).doubleValue());
            xianJinService.insertSelective(xianjinbiCashApply);
            m.setId(member().getId());
            memberService.updateomember(m);
            j.setMsg("申请成功");
            j.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            j.setSuccess(false);
            j.setMsg("申请失败");
        }
        super.writeJson(j);
    }
    public Member member(){
        SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
                .getSessionInfoName());// 获取登录人信息

          return  me=memberService.selectKey(sessionInfo.getUserId());

    }

//    public  void  selectban(){
//
//        List<Bankcard> bankcards=null;
//
//            SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//                    .getSessionInfoName());// 获取登录人信息
//         bankcards= memberCallService.gainBanckcard(sessionInfo.getUserId());
//
//        super.writeJson(bankcards);
//    }

    }





