package com.qlzy.memberCenter.person.xianjiantixian.action;





import com.qlzy.common.tools.ResourceUtil;

import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.common.util.PcOrWap;
import com.qlzy.mainPage.indexGoods.service.DictionaryService;
import com.qlzy.mainPage.login.service.MemberService;
import com.qlzy.memberCenter.call.service.MemberCallService;
import com.qlzy.memberCenter.person.xianjiantixian.service.XianJinService;

import com.qlzy.model.Bankcard;
import com.qlzy.model.Member;
import com.qlzy.model.QlDict;
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
        @Result(name = "toList",location = "/memberCenter/person/personalInfo/shenqingtixian.jsp"),
        @Result(name = "toListWap",location = "/wap/person/shenqingtixian.jsp")
})
public class XianjianAction extends BaseAction {
    @Resource
    private MemberCallService memberCallService;
    @Resource
    private MemberService memberService;
    private static final long serialVersionUID = 1L;
    private  Member me=new Member();
    private XianjinbiCashApply xianjinbiCashApply;
    @Resource
    private XianJinService xianJinService;
    @Resource
    private DictionaryService dictionaryService;
    public String toList(){
        //申请提现的显示和id
        SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
                .getSessionInfoName());// 获取登录人信息
        if(sessionInfo != null && sessionInfo.getUserId() != null && !"".equals(sessionInfo.getUserId())){
            me=memberService.selectKey(sessionInfo.getUserId());
            request.setAttribute("me", me);
            QlDict qlDict = dictionaryService.gainByType("tixian_fee");
            String fee = qlDict.getValue();
            request.setAttribute("fee",fee);

            sessionInfo = (SessionInfo) session.get(ResourceUtil
                    .getSessionInfoName());// 获取登录人信息
            List<Bankcard>  bankcards= memberCallService.gainBanckcard(sessionInfo.getUserId());
            request.setAttribute("ban", bankcards);
        }else{
            return "";
        }
        return  PcOrWap.isPc(request,"toList");
    }


    public void insertSelective(){
        String result = "";
        try {
            String id = request.getParameter("id");
            String barndCard = request.getParameter("barndCard");
            String amount=request.getParameter("amount");//提现金额
            String realAmount=request.getParameter("realAmount");//实际到账金额
            String liucunAmount=request.getParameter("liucunAmount");//留存金额
            xianjinbiCashApply = new XianjinbiCashApply();
            xianjinbiCashApply.setMemberId(id);
            xianjinbiCashApply.setBankAccount(barndCard);
            xianjinbiCashApply.setAmount(Double.parseDouble(amount));
            xianjinbiCashApply.setRealAmount(Double.parseDouble(realAmount));
            xianjinbiCashApply.setId(ToolsUtil.getUUID());
            xianjinbiCashApply.setCreateTime(new Date());
            xianjinbiCashApply.setStatus("0");
            xianjinbiCashApply.setLiucunAmount(Double.parseDouble(liucunAmount));
            Member m =memberService.selectKey(id);
            xianjinbiCashApply.setBankAccount(m.getBankcar());
            xianjinbiCashApply.setBankAddress(m.getAddress());
            xianjinbiCashApply.setBankAccount(barndCard);
            BigDecimal money = new BigDecimal(m.getAdvance());
            BigDecimal oldMoney = new BigDecimal(xianjinbiCashApply.getAmount());
            m.setAdvance(money.subtract(oldMoney).doubleValue());
            xianJinService.insertSelective(xianjinbiCashApply);
            m.setId(member().getId());
            memberService.updateomember(m);
            result = "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        super.writeJson(result);
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





