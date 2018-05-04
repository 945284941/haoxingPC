package com.qlzy.model;

import java.util.Date;

import java.io.Serializable;

public class TechnologyQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String questionTitle;

    private String content;

    private String picSrc;

    private String linkman;

    private String questionType;

    private String questionTypeId;

    private String linkmobile;

    private Date createtime;

    private String userId;

    private Date modifytime;

    private String kz1;

    private String kz2;

    private String kz3;

    private String kz4;

    private String kz5;

    private String kz6;

    private String kz7;

    private String kz8;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle == null ? null : questionTitle.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPicSrc() {
        return picSrc;
    }

    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc == null ? null : picSrc.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    public String getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(String questionTypeId) {
        this.questionTypeId = questionTypeId == null ? null : questionTypeId.trim();
    }

    public String getLinkmobile() {
        return linkmobile;
    }

    public void setLinkmobile(String linkmobile) {
        this.linkmobile = linkmobile == null ? null : linkmobile.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getKz1() {
        return kz1;
    }

    public void setKz1(String kz1) {
        this.kz1 = kz1 == null ? null : kz1.trim();
    }

    public String getKz2() {
        return kz2;
    }

    public void setKz2(String kz2) {
        this.kz2 = kz2 == null ? null : kz2.trim();
    }

    public String getKz3() {
        return kz3;
    }

    public void setKz3(String kz3) {
        this.kz3 = kz3 == null ? null : kz3.trim();
    }

    public String getKz4() {
        return kz4;
    }

    public void setKz4(String kz4) {
        this.kz4 = kz4 == null ? null : kz4.trim();
    }

    public String getKz5() {
        return kz5;
    }

    public void setKz5(String kz5) {
        this.kz5 = kz5 == null ? null : kz5.trim();
    }

    public String getKz6() {
        return kz6;
    }

    public void setKz6(String kz6) {
        this.kz6 = kz6 == null ? null : kz6.trim();
    }

    public String getKz7() {
        return kz7;
    }

    public void setKz7(String kz7) {
        this.kz7 = kz7 == null ? null : kz7.trim();
    }

    public String getKz8() {
        return kz8;
    }

    public void setKz8(String kz8) {
        this.kz8 = kz8 == null ? null : kz8.trim();
    }
}