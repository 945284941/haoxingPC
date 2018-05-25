package com.qlzy.model;

import java.io.Serializable;
import java.util.List;

import com.qlzy.pojo.Base;

public class GoodsCat extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
    private String id;

    private String pid;

    private String pTree;

    private String name;

    private String disabled;

    private Integer pOrder;

    private String keyWord;

    private Integer floor;
   
    private Integer grade;

    private String remark;
    
    private String pname;//扩展字段

    private String enName;//英文名字

    private String shoppingSort;
    private String marketSort;
    
    private List<GoodsCat> subCatList;

    private List<GoodsCat> threeCatList;

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

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }

    

    public Integer getpOrder() {
		return pOrder;
	}

	public void setpOrder(Integer pOrder) {
		this.pOrder = pOrder;
	}

	public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<GoodsCat> getSubCatList() {
		return subCatList;
	}

	public void setSubCatList(List<GoodsCat> subCatList) {
		this.subCatList = subCatList;
	}

    public List<GoodsCat> getThreeCatList() {
        return threeCatList;
    }

    public void setThreeCatList(List<GoodsCat> threeCatList) {
        this.threeCatList = threeCatList;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getShoppingSort() {
        return shoppingSort;
    }

    public void setShoppingSort(String shoppingSort) {
        this.shoppingSort = shoppingSort;
    }

    public String getMarketSort() {
        return marketSort;
    }

    public void setMarketSort(String marketSort) {
        this.marketSort = marketSort;
    }

}