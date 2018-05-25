package com.qlzy.model;

import java.util.Date;

public class WantDiscuss {
    private String id;

    private String wantId;

    private String memberId;

    private Date createTime;

    private String content;
    private Long minRow;
    private Long maxRow;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getMinRow() {
        return minRow;
    }

    public void setMinRow(Long minRow) {
        this.minRow = minRow;
    }

    public Long getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(Long maxRow) {
        this.maxRow = maxRow;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWantId() {
        return wantId;
    }

    public void setWantId(String wantId) {
        this.wantId = wantId == null ? null : wantId.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}