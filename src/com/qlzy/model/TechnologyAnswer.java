package com.qlzy.model;

import java.util.Date;

import com.qlzy.util.Pagination;

import java.io.Serializable;

public class TechnologyAnswer extends Pagination implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String content;

    private String questionId;

    private Date createtime;

    private String userId;

    private String userName;

    private String userType;

    private String disabled;

    private Date modifytime;

    private String kz1;

    private String kz2;

    private String kz3;

    private String kz4;

    private String kz5;

    private String kz6;

    private String kz7;

    private String kz9;

    private String kz10;

    private String kz11;

    private String kz12;

    private String kz13;

    private String kz14;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
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

    public String getKz9() {
        return kz9;
    }

    public void setKz9(String kz9) {
        this.kz9 = kz9 == null ? null : kz9.trim();
    }

    public String getKz10() {
        return kz10;
    }

    public void setKz10(String kz10) {
        this.kz10 = kz10 == null ? null : kz10.trim();
    }

    public String getKz11() {
        return kz11;
    }

    public void setKz11(String kz11) {
        this.kz11 = kz11 == null ? null : kz11.trim();
    }

    public String getKz12() {
        return kz12;
    }

    public void setKz12(String kz12) {
        this.kz12 = kz12 == null ? null : kz12.trim();
    }

    public String getKz13() {
        return kz13;
    }

    public void setKz13(String kz13) {
        this.kz13 = kz13 == null ? null : kz13.trim();
    }

    public String getKz14() {
        return kz14;
    }

    public void setKz14(String kz14) {
        this.kz14 = kz14 == null ? null : kz14.trim();
    }
}