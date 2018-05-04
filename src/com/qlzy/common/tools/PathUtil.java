package com.qlzy.common.tools;

import javax.servlet.http.HttpServletRequest;

/**
 *  jsp相对路径设置
 */
public class PathUtil {
  public static String getPath(HttpServletRequest request){	 
	  String path = request.getContextPath();
	  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	 return basePath; 
  }
}
