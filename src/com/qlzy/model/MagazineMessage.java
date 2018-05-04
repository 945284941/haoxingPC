package com.qlzy.model;
import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class MagazineMessage extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String magazineNum;

    private String messageMain;

    private String imageSrc;

    private Date sendTime;

    private String messageSrc;

    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMagazineNum() {
        return magazineNum;
    }

    public void setMagazineNum(String magazineNum) {
        this.magazineNum = magazineNum == null ? null : magazineNum.trim();
    }

    public String getMessageMain() {
        return messageMain;
    }

    public void setMessageMain(String messageMain) {
        this.messageMain = messageMain == null ? null : messageMain.trim();
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc == null ? null : imageSrc.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessageSrc() {
        return messageSrc;
    }

    public void setMessageSrc(String messageSrc) {
        this.messageSrc = messageSrc == null ? null : messageSrc.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}