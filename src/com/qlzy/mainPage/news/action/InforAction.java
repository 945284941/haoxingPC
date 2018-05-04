package com.qlzy.mainPage.news.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.qlzy.common.tools.FtpUtil;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.util.BaseAction;

/**
 * @ClassName: InforAction
 * @Description: 
 * @author Huifeng Wang
 * @date 2013-8-23 上午11:03:37
 */
@Action(value = "infor", results = {
		@Result(name = "toNews", location = "/admin/news/main_news.jsp")})
public class InforAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	private File filedata;
	private File file;
	public void upload(){
		Map<String,Object> map=new HashMap<String,Object>();
		FtpUtil ftp= new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
		ftp.connectServer();
		String savePath=ResourceUtil.getUploadDirectory()+"/ceshi/";
		String saveUrl=ResourceUtil.getWebPath()+savePath;
		if(!ftp.isDirExist(savePath)){
			ftp.createDir(savePath);
		}
		ftp.cd(savePath);
		MultiPartRequestWrapper multiPartRequest = (MultiPartRequestWrapper) ServletActionContext
				.getRequest();// 由于struts2上传文件时自动使用了request封装
		File[] files = multiPartRequest.getFiles("filedata");// 上传的文件集合
		String[] fileNames = multiPartRequest.getFileNames("filedata");// 上传文件名称集合
		
		if (files == null || files.length < 1) {
			map.put("status", 0);
			map.put("error", "没有上传任何文件!");
			super.writeJson(map);
			return;
		}
		for (int i = 0; i < files.length; i++) {// 循环所有文件
			File file = files[i];// 上传的文件(临时文件)
			String fileName = fileNames[i];// 上传文件名
			if (file.length() > ResourceUtil.getUploadFileMaxSize()) {
				map.put("status", 1);
				map.put("error", "文件大小超出限制");
				super.writeJson(map);
				return;
			}
			// 检查文件扩展名
			String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1)
					.toLowerCase();
			String newFileName = UUID.randomUUID().toString()
					.replaceAll("-", "")
					+ "." + fileExt;// 新的文件名称
			try {
				ftp.upload(file.getPath(),newFileName);
			} catch (Exception e) {
				map.put("error", 1);
				map.put("message", "上传文件失败");
				super.writeJson(map);
				return;
			}
			ftp.closeServer();
			map.put("status", 1);
			map.put("url", saveUrl + newFileName);
			super.writeJson(map);
		}
	}


	/**
	 * @return the filedata
	 */
	public File getFiledata() {
		return filedata;
	}


	/**
	 * @param filedata the filedata to set
	 */
	public void setFiledata(File filedata) {
		this.filedata = filedata;
	}
	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}
}
