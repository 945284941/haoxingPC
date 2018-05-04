/**  
 * @Title: MessageUtil.java
 * @Package com.qlzy.common.tools
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 周张豹  
 * @date 2013-10-19 下午3:46:44
 * @version V1.0  
 */
package com.qlzy.common.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jdom.JDOMException;
/**
 * 短信接口
 * 
 * @ClassName: MessageUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-10-19 下午3:46:44
 */
public class MessageUtil {
	private static final String USERNAME = "dljncfgg";
	private static final String PWD = "3bQ7rgwz";
	private static final String REQ_URL = "http://cf.lmobile.cn/submitdata/Service.asmx/g_Submit";
	private static final Map<String, Object> map = new HashMap<String, Object>();
	private static final String ENCODING = "UTF-8";
	private static final String POSTFIX=" 【古道金典】";
	static {
		map.put("sname", USERNAME);//用户名
		map.put("spwd", PWD);//密码
		map.put("sprdid", "1012888");//产品编号
		map.put("scorpid", "");
	}
	
	/**
	 * @author HuifengWang
	 * @param content 短信内容
	 * @param mobile 单个发送短信,手机号码
	 * @return 返回类型Map
	 * Map参数:	success--发送是否成功
	 * 		  	msgId---发送成功会有返回的msgId
	 * 			result--返回的状态汉字解释
	 * 			state---返回的状态码
	 * 			mobile---手机号
	 * 			content--短信内容
	 */
	public static Map<String, Object> sendMsg(String content, String mobile) {
		Map<String, Object> j = new HashMap<String, Object>();
		j.putAll(map);
		j.put("sdst", mobile);
		j.put("smsg", content+POSTFIX);
		StringBuffer params = new StringBuffer();//拼接参数字符串
		for (Iterator<?> iter = j.entrySet().iterator(); iter.hasNext();) {
			Entry<?, ?> element = (Entry<?, ?>) iter.next();
			params.append(element.getKey().toString());
			params.append("=");
			try {
				params.append(URLEncoder.encode(element.getValue().toString(), ENCODING));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			params.append("&");
		}
		if (params.length() > 0) {
			params = params.deleteCharAt(params.length() - 1);
		}
		String ret =SMS(params.toString(), REQ_URL);
		Map<String,String> temp=new HashMap<String, String>();
		try {
			temp=XmlUtil.xml2Map(ret);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Object> r = new HashMap<String, Object>();
		r.put("success", Integer.valueOf(temp.get("CSubmitState.State"))==0);
		r.put("msgId", temp.get("CSubmitState.MsgID"));
		r.put("result",temp.get("CSubmitState.MsgState"));
		r.put("state", temp.get("CSubmitState.State"));
		r.put("mobile", mobile);
		r.put("content", content+POSTFIX);
		return r;
	}
	
	
	/**
	 * @author HuifengWang
	 * @param content 短信内容
	 * @param mobile 批量发送短信,手机号码
	 * @return 返回类型Map
	 * Map参数:	success--发送是否成功
	 * 		  	msgId---发送成功会有返回的msgId
	 * 			result--返回的状态汉字解释
	 * 			state---返回的状态码
	 * 			mobile---手机号
	 * 			content--短信内容
	 */
	public static Map<String, Object> sendMsg(String content, String[] mobile) {
		StringBuffer sb = new StringBuffer();
		if (mobile != null && mobile.length > 0) {
			for (int i = 0; i < mobile.length; i++) {
				if (i == mobile.length - 1) {
					sb = sb.append(mobile[i]);
				} else {
					sb = sb.append(mobile[i] + ",");
				}
			}
		}
		Map<String, Object> j = new HashMap<String, Object>();
		j.putAll(map);
		j.put("sdst", mobile);
		j.put("smsg", content+POSTFIX);
		StringBuffer params = new StringBuffer();//拼接参数字符串
		for (Iterator<?> iter = j.entrySet().iterator(); iter.hasNext();) {
			Entry<?, ?> element = (Entry<?, ?>) iter.next();
			params.append(element.getKey().toString());
			params.append("=");
			try {
				params.append(URLEncoder.encode(element.getValue().toString(), ENCODING));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			params.append("&");
		}
		if (params.length() > 0) {
			params = params.deleteCharAt(params.length() - 1);
		}
		String ret =SMS(params.toString(), REQ_URL);
		Map<String,String> temp=new HashMap<String, String>();
		try {
			temp=XmlUtil.xml2Map(ret);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Object> r = new HashMap<String, Object>();
		r.put("success", Integer.valueOf(temp.get("CSubmitState.State"))==0);
		r.put("msgId", temp.get("CSubmitState.MsgID"));
		r.put("result",temp.get("CSubmitState.MsgState"));
		r.put("state", temp.get("CSubmitState.State"));
		r.put("mobile", mobile);
		r.put("content", content+POSTFIX);
		return r;
	}
	/**
	 * @author HuifengWang
	 * @param content 短信内容
	 * @param mobile 批量发送短信,手机号码
	 * @return 返回类型Map
	 * Map参数:	success--发送是否成功
	 * 		  	msgId---发送成功会有返回的msgId
	 * 			result--返回的状态汉字解释
	 * 			state---返回的状态码
	 * 			mobile---手机号
	 * 			content--短信内容
	 */
	public static Map<String,Object> sendMsg(String content,List<String> mobile){
		StringBuffer sb=new StringBuffer();
		if(mobile!=null && mobile.size()>0){
			for (int i = 0; i < mobile.size(); i++) {
				if(i==mobile.size()-1){
					sb=sb.append(mobile.get(i));
				}else{
					sb=sb.append(mobile.get(i)+",");
				}
			}
		}
		Map<String, Object> j = new HashMap<String, Object>();
		j.putAll(map);
		j.put("sdst", mobile);
		j.put("smsg", content+POSTFIX);
		StringBuffer params = new StringBuffer();//拼接参数字符串
		for (Iterator<?> iter = j.entrySet().iterator(); iter.hasNext();) {
			Entry<?, ?> element = (Entry<?, ?>) iter.next();
			params.append(element.getKey().toString());
			params.append("=");
			try {
				params.append(URLEncoder.encode(element.getValue().toString(), ENCODING));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			params.append("&");
		}
		if (params.length() > 0) {
			params = params.deleteCharAt(params.length() - 1);
		}
		String ret =SMS(params.toString(), REQ_URL);
		Map<String,String> temp=new HashMap<String, String>();
		try {
			temp=XmlUtil.xml2Map(ret);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Object> r = new HashMap<String, Object>();
		r.put("success", Integer.valueOf(temp.get("CSubmitState.State"))==0);
		r.put("msgId", temp.get("CSubmitState.MsgID"));
		r.put("result",temp.get("CSubmitState.MsgState"));
		r.put("state", temp.get("CSubmitState.State"));
		r.put("mobile", mobile);
		r.put("content", content+POSTFIX);
		return r;
	}
	
	private static String SMS(String postData, String postUrl) {
        try {
            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return "";
            }
            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "";
    }
	public static void main(String[] args) {
		System.out.println(sendMsg("您在古道金典绑定手机所获得的动态验证码是：782415", "13011717997"));
	}
}
