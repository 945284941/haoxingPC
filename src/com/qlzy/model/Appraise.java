package com.qlzy.model;


import com.qlzy.util.Pagination;

import java.util.Date;

import java.io.Serializable;
import java.util.List;

public class Appraise  extends Pagination implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String goodsId;

    private String companyId;

    private String memberId;

    private String orderId;

    private Integer quality;

    private Integer credit;

    private Integer serve;

    private Integer logistics;

    private Integer sincerity;

    private String content;

    private Date createtime;
    private String isPic;
    
    private String goodsName;//附加字段
    private String companyName;
    private String memberName;

    private List<AppraisePic> appraisePics;//评论的图片信息
    private String replyContent;
    private Date replyDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getServe() {
        return serve;
    }

    public void setServe(Integer serve) {
        this.serve = serve;
    }

    public Integer getLogistics() {
        return logistics;
    }

    public void setLogistics(Integer logistics) {
        this.logistics = logistics;
    }

    public Integer getSincerity() {
        return sincerity;
    }

    public void setSincerity(Integer sincerity) {
        this.sincerity = sincerity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

    public String getIsPic() {
        return isPic;
    }

    public void setIsPic(String isPic) {
        this.isPic = isPic;
    }

    public List<AppraisePic> getAppraisePics() {
        return appraisePics;
    }

    public void setAppraisePics(List<AppraisePic> appraisePics) {
        this.appraisePics = appraisePics;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }
}