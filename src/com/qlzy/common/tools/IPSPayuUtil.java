/**  
* @Title: IPSPayuUtil.java
* @Package com.qlzy.common.tools
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-11-5 上午9:44:40
* @version V1.0  
*/
package com.qlzy.common.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 兴业银行支付接口
 * @ClassName: IPSPayuUtil
 * @Description: TODO(兴业银行支付接口)
 * @author 周张豹
 * @date 2013-11-5 上午9:44:40
 */
public class IPSPayuUtil {
	
	private static String IPSTestUrl="https://pay.ips.net.cn/CustomUI/TileCustomPage/ipayment_style.aspx";
	private static String IPSUrl="https://pay.ips.com.cn/CustomUI/TileCustomPage/ipayment_style.aspx";
	private static String Mer_codeTest="000015";
	
	
	
	public void submitOrderToIPSByPost(IPSPayuUtil ipsPayuUtil){
		 try {
	            //发送POST请求
	            URL url = new URL(IPSTestUrl);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("POST");
	            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            conn.setRequestProperty("Connection", "Keep-Alive");
	            conn.setUseCaches(false);
	            conn.setDoOutput(true);

//	            conn.setRequestProperty("Content-Length", "" + postData.length());
	            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
//	            out.write(postData);
	            out.flush();
	            out.close();

	            //获取响应状态
	            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	                System.out.println("connect failed!");
//	                return "";
	            }
	            //获取响应内容体
	            String line, result = "";
	            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	            while ((line = in.readLine()) != null) {
	                result += line + "\n";
	            }
	            in.close();
//	            return result;
	        } catch (IOException e) {
	            e.printStackTrace(System.out);
	        }
	};

}
