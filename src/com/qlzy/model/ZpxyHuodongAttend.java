package com.qlzy.model;

import java.util.Date;

import java.io.Serializable;

public class ZpxyHuodongAttend implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private Long attendNum;

    private String linkman;

    private String linkmobile;

    private String address;

    private String detailAddress;

    private Date createtime;

    private String kz1;

    private String kz2;

    private String kz3;

    private String kz4;

    private String kz5;

    private String kz6;

    private String kz7;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getAttendNum() {
        return attendNum;
    }

    public void setAttendNum(Long attendNum) {
        this.attendNum = attendNum;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinkmobile() {
        return linkmobile;
    }

    public void setLinkmobile(String linkmobile) {
        this.linkmobile = linkmobile == null ? null : linkmobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
}