package com.qlzy.model;

import java.util.Date;

import javax.persistence.Transient;

import java.io.Serializable;

public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String goodsId;
    
    private String itemId;

    public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	private String userId;

    private Date createTime;

    private String createIp;

    private String userType;
    
    private String collectId;
    
    private Integer goodsNum;//商品在购物车中的数量
    
    private String type;
    
    @Transient
    private Goods goods;
    
    public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public GoodsItem getGoodsItem() {
		return goodsItem;
	}

	public void setGoodsItem(GoodsItem goodsItem) {
		this.goodsItem = goodsItem;
	}

	@Transient
    private GoodsItem goodsItem;
    
    
    /*
     * ------- 一下为扩展字段-----------
     */
    private double point;
	

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp == null ? null : createIp.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

	/**
	 * @return the goodsNum
	 */
	public Integer getGoodsNum() {
		return goodsNum;
	}

	/**
	 * @param goodsNum the goodsNum to set
	 */
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getCollectId() {
		return collectId;
	}

	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}
    
	
    
    
}