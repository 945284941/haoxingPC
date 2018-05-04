package com.qlzy.model;

import com.qlzy.pojo.Base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CompanysGoodsCat extends Base implements Serializable {
    private String id;

    private String pid;

    private String pTree;

    private String name;

    private String enName;

    private String companyId;

    private String disabled;

    private BigDecimal pOrder;

    private String keyWord;

    private BigDecimal floor;

    private BigDecimal grade;

    private String remark;

    private List<CompanysGoodsCat> subCompanyCatList;

    private List<CompanysGoodsCat> threeCompanyCatList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getpTree() {
        return pTree;
    }

    public void setpTree(String pTree) {
        this.pTree = pTree == null ? null : pTree.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }

    public BigDecimal getpOrder() {
        return pOrder;
    }

    public void setpOrder(BigDecimal pOrder) {
        this.pOrder = pOrder;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    public BigDecimal getFloor() {
        return floor;
    }

    public void setFloor(BigDecimal floor) {
        this.floor = floor;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public List<CompanysGoodsCat> getThreeCompanyCatList() {
        return threeCompanyCatList;
    }

    public void setThreeCompanyCatList(List<CompanysGoodsCat> threeCompanyCatList) {
        this.threeCompanyCatList = threeCompanyCatList;
    }

    public List<CompanysGoodsCat> getSubCompanyCatList() {
        return subCompanyCatList;
    }

    public void setSubCompanyCatList(List<CompanysGoodsCat> subCompanyCatList) {
        this.subCompanyCatList = subCompanyCatList;
    }
}