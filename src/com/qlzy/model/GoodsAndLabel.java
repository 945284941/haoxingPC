package com.qlzy.model;

import java.io.Serializable;

import com.qlzy.pojo.Base;

public class GoodsAndLabel extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
    private String id;

    private String goodsId;

    private String goodsLabelId;
    
    private String disabled;

    /**
	 * @return the disabled
	 */
	public String getDisabled() {
		return disabled;
	}

	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

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

	public String getGoodsLabelId() {
		return goodsLabelId;
	}

	public void setGoodsLabelId(String goodsLabelId) {
		this.goodsLabelId = goodsLabelId;
	}

	
   
}