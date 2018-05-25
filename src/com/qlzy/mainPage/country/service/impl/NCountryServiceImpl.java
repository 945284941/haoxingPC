package com.qlzy.mainPage.country.service.impl;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.util.AddressUtils;
import com.qlzy.mainPage.country.dao.NCountryMapper;
import com.qlzy.mainPage.country.service.NCountryService;
import com.qlzy.memberCenter.order.action.OrderAction;
import com.qlzy.model.NCountry;
import com.qlzy.pojo.SessionInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/13.
 */
@Service("nCountryService")
public class NCountryServiceImpl implements NCountryService {
    private static final Logger logger = Logger.getLogger(NCountryServiceImpl.class);
    @Autowired
    NCountryMapper nCountryMapper;
    @Override
    public NCountry gainNCountryByPrimaryKey(String id){
        return nCountryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<NCountry> gainNCountry() {
        return nCountryMapper.gainAll();
    }

    @Override
    public List<NCountry> gainNCountryByLikeName(String address) {
        return null;
    }

    @Override
    public void changeAddressByIp(String addressId, HttpServletRequest request, Map<String, Object> session) {
        //关于地区的切换
        SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
                .getSessionInfoName());// 获取登录人信息
        if(null != sessionInfo){
            if(null != sessionInfo.getAddressMap() && !"".equals(sessionInfo.getAddressMap().get("addressId"))){
                //直接替换
                if(null != addressId && !"".equals(addressId) && !addressId.equals(sessionInfo.getAddressMap().get("addressId"))){
                    //查询该国家信息赋值给session
                    NCountry nCountry = nCountryMapper.selectByPrimaryKey(addressId);
                    if(null != nCountry){
                        Map<String,String> adMap = new HashMap<>();
                        adMap.put("addressId",nCountry.getId());
                        adMap.put("addressName",nCountry.getName());
                        adMap.put("addressEnName",nCountry.getNameEng());
                        sessionInfo.setAddressMap(adMap);
                        session.put(ResourceUtil.getSessionInfoName(),
                                sessionInfo);
                    }else {
                        logger.info("用户切换的地址id不存在------------"+addressId);
                    }
                }
            }else{
                handleIpAddress(request,session,sessionInfo);
            }

        }else{
            sessionInfo = new SessionInfo();
            handleIpAddress(request,session,sessionInfo);
        }
    }

    @Override
    public void checkAddressId(HttpServletRequest request,Map<String, Object> parmMap, Map<String, Object> session, SessionInfo sessionInfo,String nType) {
        if(null != sessionInfo){
            if(null != sessionInfo.getAddressMap() && !"".equals(sessionInfo.getAddressMap().get("addressId"))){
                if("1".equals(nType)){
                    parmMap.put("addressId",sessionInfo.getAddressMap().get("addressId"));
                }else{
                    parmMap.put("fromCountryId",sessionInfo.getAddressMap().get("addressId"));

                }

            }else{
                handleIpAddress(request,session,sessionInfo);
                if("1".equals(nType)){
                    parmMap.put("addressId",sessionInfo.getAddressMap().get("addressId"));
                }else{
                    parmMap.put("fromCountryId",sessionInfo.getAddressMap().get("addressId"));
                }
            }
        }else{
            handleIpAddress(request,session,sessionInfo);
            if("1".equals(nType)){
                parmMap.put("addressId",sessionInfo.getAddressMap().get("addressId"));
            }else{
                parmMap.put("fromCountryId",sessionInfo.getAddressMap().get("addressId"));

            }
        }
    }

    public void handleIpAddress(HttpServletRequest request, Map<String, Object> session,SessionInfo sessionInfo){
        String url = "ip="+ AddressUtils.getIpAdrress(request);
        try {
            String name = AddressUtils.getAddress(url,"utf-8");
            Map<String,String> parmMap = new HashMap<>();
            parmMap.put("name",name);
            List<NCountry> nCountrys = nCountryMapper.gainNCountryByLikeName(parmMap);
            if(null != nCountrys){
                if(nCountrys.size() >= 0){
                    Map<String,String> adMap = new HashMap<>();
                    adMap.put("addressId",nCountrys.get(0).getId());
                    adMap.put("addressName",nCountrys.get(0).getName());
                    adMap.put("addressEnName",nCountrys.get(0).getNameEng());
                    sessionInfo.setAddressMap(adMap);
                    session.put(ResourceUtil.getSessionInfoName(),
                            sessionInfo);
                }
            }
        } catch (UnsupportedEncodingException e) {
            logger.info("IP地址获取国家出错-----"+e.getMessage());
            e.printStackTrace();
        }
    }

}
