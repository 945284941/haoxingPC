package com.qlzy.mainPage.country.service;

import com.qlzy.model.NCountry;
import com.qlzy.pojo.SessionInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/13.
 */
public interface NCountryService {
    NCountry gainNCountryByPrimaryKey(String id);

    List<NCountry> gainNCountry();

    List<NCountry> gainNCountryByLikeName(String address);

    void changeAddressByIp(String addressId, HttpServletRequest request, Map<String, Object> session);

    void checkAddressId(HttpServletRequest request,Map<String, Object> parmMap, Map<String, Object> session, SessionInfo sessionInfo,String nType);
}
