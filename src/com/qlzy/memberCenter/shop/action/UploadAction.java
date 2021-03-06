package com.qlzy.memberCenter.shop.action;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.qlzy.common.tools.TwoDimensionCode;
import com.qlzy.common.util.AliyunOSSClientUtil;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.qlzy.common.tools.FtpUtil;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.util.BaseAction;

import javax.servlet.http.HttpServletResponse;


/**
 * @ClassName: UploadAction
 * @Description: 在线文本编辑器专用
 * @author 赵阳彬
 * @date 2013-7-19 下午1:44:40
 */

@Namespace("/")
//命名空间
@Action(value = "up", results = {})
public class UploadAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File file;
	/***
	 * 阿里云上传图片
     */
	public void uploadImg(){
		Map<String,String> rtnMap = new HashMap<String, String>();
		String picPath = AliyunOSSClientUtil.getFileUrl(file);
		rtnMap.put("src",picPath);
		super.writeJson(rtnMap);
	}

	public static String qrCode(){
		String mmm = "";
		try{
			//先获取本项目的路径
			String savePath = ServletActionContext.getServletContext().getRealPath(
					""); // 获取项目根路径
			savePath = savePath + ResourceUtil.getQrCode_Img_Directory() + "rqCode.png";
			File up = new File(savePath);
			if (!up.exists()) {
				up.mkdirs();
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8"); // 务必，防止返回文件名是乱码
            String remark = ResourceUtil.getQrCode_remark();
			mmm = TwoDimensionCode.encoderQRCode(remark, savePath,"jpg",7);
		}catch (Exception e){
			e.printStackTrace();
		}
		return mmm;
	}

	public static String uploadImg(File file){
		Map<String,String> rtnMap = new HashMap<String, String>();
		String picPath = AliyunOSSClientUtil.getFileUrl(file);
		rtnMap.put("src",picPath);
		return picPath;
	}
	/**
	* @Title: upload
	* @Description: TODO文件上传功能
	* @param     设定文件
	* @return void    返回类型
	*/
	public void upload() {
		Map<String,Object> map=new HashMap<String,Object>();
		FtpUtil ftp= new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
		ftp.connectServer();
		String savePath=ResourceUtil.getUploadDirectory()+"/";
		String saveUrl=ResourceUtil.getWebPath()+savePath;
		if(!ftp.isDirExist(savePath)){
			ftp.createDir(savePath);
		}
		ftp.cd(savePath);
		
		MultiPartRequestWrapper multiPartRequest = (MultiPartRequestWrapper) ServletActionContext
				.getRequest();// 由于struts2上传文件时自动使用了request封装
		File[] files = multiPartRequest.getFiles(ResourceUtil
				.getKindeditorFieldName());// 上传的文件集合
		String[] fileNames = multiPartRequest.getFileNames(ResourceUtil
				.getKindeditorFieldName());// 上传文件名称集合

		if (files == null || files.length < 1) {
			map.put("error", 1);
			map.put("message", "没有上传任何文件!");
			super.writeJson(map);
			return;
		}
		for (int i = 0; i < files.length; i++) {// 循环所有文件
			File file = files[i];// 上传的文件(临时文件)
			String fileName = fileNames[i];// 上传文件名
			if (file.length() > ResourceUtil.getUploadFileMaxSize()) {
				map.put("error", 1);
				map.put("message", "文件大小超出限制");
				super.writeJson(map);
				return;
			}
			// 检查文件扩展名
			String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1)
					.toLowerCase();
			if (!Arrays.<String> asList(
					ResourceUtil.getKindeditorUploadFileExts().split(",")).contains(
					fileExt)) {
				map.put("error", 1);
				map.put("message", "上传文件扩展名是不允许的扩展名。\n只允许"
						+ ResourceUtil.getKindeditorUploadFileExts() + "格式！");
				super.writeJson(map);
				return;
			}
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
			map.put("error", 0);
			map.put("url", saveUrl + newFileName);
			super.writeJson(map);
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}


}
