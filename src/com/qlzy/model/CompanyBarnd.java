package com.qlzy.model;

import java.util.Date;
import java.util.List;

public class CompanyBarnd {
    private String id;

    private String companyId;

    private String auditStatus;

    private Date auditTime;

    private String auditBy;

    private String brandName;

    private String barndLogo;

    private String applyRemarks;

    private String delFlag;

    private List<String>  imgList;

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

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

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditBy() {
        return auditBy;
    }

    public void setAuditBy(String auditBy) {
        this.auditBy = auditBy == null ? null : auditBy.trim();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBarndLogo() {
        return barndLogo;
    }

    public void setBarndLogo(String barndLogo) {
        this.barndLogo = barndLogo == null ? null : barndLogo.trim();
    }

    public String getApplyRemarks() {
        return applyRemarks;
    }

    public void setApplyRemarks(String applyRemarks) {
        this.applyRemarks = applyRemarks == null ? null : applyRemarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}