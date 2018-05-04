package com.qlzy.model;

import java.io.File;
import java.io.Serializable;

import com.qlzy.pojo.Base;

public class CompanysHeadImg extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String companyId;

    private String imgSrc;

    private Integer porder;
    
    private File myFile;
    
    private String myFileFileName; 
	
    private String myFileContentType;

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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc == null ? null : imgSrc.trim();
    }

	public Integer getPorder() {
		return porder;
	}

	public void setPorder(Integer porder) {
		this.porder = porder;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	

}