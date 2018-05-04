package com.qlzy.common.tools;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;

	/**
	 * 操作配置文件工具类
	 * @author Wang Huifeng
	 *
	 */
	public class PropertiesUtil {

		//记录日志
	    private static Logger logger = Logger.getLogger(PropertiesUtil.class);
		
		public static String getInfo(String path, String key){
		    try { 
		    	Properties prop = new Properties(); 
			    prop.load(new ClassPathResource("/" + path).getInputStream());
		        String info = prop.getProperty(key);
		        if(info != null && info.trim() != ""){
		        	return info;
		        }
		    } catch (IOException e) { 
		    	logger.error("读取配置文件出错出错！",e);
		    	e.printStackTrace(); 
		    } 
		    return "";
		}
}
