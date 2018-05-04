package com.qlzy.model;


import java.util.Date;

import java.io.Serializable;

public class SignInModel implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String companyId;

    private String companyName;

    private Date firstTime;

    private Date lastTime;

    private Integer loginNum;

    private String disable;

    private Long guangbi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(Integer loginNum) {
        this.loginNum = loginNum;
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable == null ? null : disable.trim();
    }

    public Long getGuangbi() {
        return guangbi;
    }

    public void setGuangbi(Long guangbi) {
        this.guangbi = guangbi;
    }
}