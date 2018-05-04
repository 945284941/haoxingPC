package com.qlzy.model;

import com.qlzy.pojo.Base;

import java.io.Serializable;

public class CompanysCarbrand extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String companyId;

    private String carBrandId;
    
    private String carBrandName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(String carBrandId) {
        this.carBrandId = carBrandId == null ? null : carBrandId.trim();
    }

	public String getCarBrandName() {
		return carBrandName;
	}

	public void setCarBrandName(String carBrandName) {
		this.carBrandName = carBrandName;
	}
    
}