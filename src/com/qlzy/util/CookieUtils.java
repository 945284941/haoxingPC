package com.qlzy.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.model.Cart;
import com.qlzy.pojo.SessionInfo;

/**
 *
 * @Title: CookieUtil.java
 * @Description: Cookie处理类,包含设置cookie，得到cookie的方法，去除字符串当中的html标签的方法
 * @author awfhome@163.com
 * @date 2010-7-3
 * @version V1.0
 */
public class CookieUtils {
	private static final int maxAge = 60*60*24*30;
   
     /**
      *
      * @param response
      * @param name cookie名称
      * @param path cookie存放路径
      * @param value cookie值
      * @param maxAge cookie最长时间
      */
    public static void addCookie(HttpServletResponse response, String name,String path, String value, int maxAge) {       
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);
        if (maxAge>0) cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }
   

   
    /**
     *
     * 获取cookie的值
     * @param request
     * @param name cookie的名称
     * @return
     */
    public static String getCookieByName(HttpServletRequest request, String name) {
     Map<String, Cookie> cookieMap = CookieUtils.readCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            return cookie.getValue();
        }else{
            return null;
        }
    }
   
    protected static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (int i = 0; i < cookies.length; i++) {
                cookieMap.put(cookies[i].getName(), cookies[i]);
            }
        }
        return cookieMap;
    }
   
   
    /**
     * 去除html代码
     * @param inputString
     * @return
     */
    public static String HtmltoText(String inputString) {
        String htmlStr = inputString; //含html标签的字符串
        String textStr ="";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;         
        java.util.regex.Pattern p_ba;
        java.util.regex.Matcher m_ba;
       
        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }
            String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式
            String patternStr = "\\s+";
           
            p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); //过滤script标签

            p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); //过滤style标签
        
            p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); //过滤html标签
           
            p_ba = Pattern.compile(patternStr,Pattern.CASE_INSENSITIVE);
            m_ba = p_ba.matcher(htmlStr);
            htmlStr = m_ba.replaceAll(""); //过滤空格
        
         textStr = htmlStr;
        
        }catch(Exception e) {
                    System.err.println("Html2Text: " + e.getMessage());
        }         
        return textStr;//返回文本字符串
     }
    /**
     * 将商品的ID放入Cookie 中
    * @Title: addCartInCookie
    * @Description: TODO(将商品的ID放入Cookie 中)
    * @param @param response
    * @param @param request
    * @param @param goodsId    设定文件
    * @return void    返回类型
    * @author 周张豹
     */
    public static void addCartInCookie(HttpServletResponse response, HttpServletRequest request,String goodsId,Integer goodsNum){
    	/*
		 * 首先要判断该商品在cookie是否已经存在 <br>
		 * 如果商品在cookie存在则数量加1<br>
		 * 如果不存在则直接放入cookie中
		 */
    	String cookie = getCookieByName(request, ResourceUtil.getCookieCart());  	
    	if (cookie != null && !"".equals(cookie)) {
        	int j = 0;
        	String goodsIds[] = cookie==null?null:cookie.split("!");
        	for (int i = 0; i < goodsIds.length; i++) {
    			String[] cartPOJO = goodsIds[i].split("-");
    			String id = cartPOJO[0];
    			String num = cartPOJO[1];
    			if (goodsId.equals(id)) {
    				//商品已经存在
    				Integer goodsNum1 = Integer.valueOf(num);
    				cookie = cookie.replace(id+"-"+num, id+"-"+(goodsNum1+goodsNum));
    				addCookie(response, ResourceUtil.getCookieCart(), "/", cookie, maxAge);
    				j++;
    			}
    		}
        	if (j == 0) {
        		cookie = cookie +"!"+goodsId+"-"+goodsNum;
				addCookie(response, ResourceUtil.getCookieCart(), "/", cookie, maxAge);
				
			}
		}else {	
			addCookie(response, ResourceUtil.getCookieCart(), "/", goodsId+"-"+goodsNum, maxAge);
			//addCookie(response, ResourceUtil.getCookieCart(), "/", goodsId+"-1", maxAge);
		}
    	
    }
    
    /**
     *  根据商品ID删除cookie中的商品信息
    * @Title: deleteCookieCartByGoodsId
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param goodsId    设定文件
    * @return void    返回类型
    * @author 周张豹
     */
    public static void deleteCookieCartByGoodsId(HttpServletResponse response, HttpServletRequest request,String goodsId){
    	String cookie = getCookieByName(request, ResourceUtil.getCookieCart());
    	if (cookie != null) {
        	String goodsIds[] = cookie==null?null:cookie.split("!");
        	for (int i = 0; i < goodsIds.length; i++) {
    			String[] cartPOJO = goodsIds[i].split("-");
    			String id = cartPOJO[0];
    			String num = cartPOJO[1];
    			if (goodsId.equals(id)) {
    				System.out.println(goodsIds.length+">>>>"+i);
    				if (goodsIds.length >1 && i != goodsIds.length-1) {
    					cookie = cookie.replace(id+"-"+num+"!", "");
					}else if(goodsIds.length == 1){
						cookie = cookie.replace(id+"-"+num, "");
					}else {
						cookie = cookie.replace("!"+id+"-"+num, "");
					}
    				
    				addCookie(response, ResourceUtil.getCookieCart(), "/", cookie, maxAge);
    			}
    		}
		}
    }
    
    /**
     * 将cookie 中购物车信息 置空
    * @Title: deleteCookieCart
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param response    设定文件
    * @return void    返回类型
    * @author 周张豹
     */
    public static void deleteCookieCartAll(HttpServletResponse response, HttpServletRequest request, String path){
    	
    	try {
    		Cookie cookie = new Cookie(ResourceUtil.getCookieCart(), null); 
    		cookie.setMaxAge(0);
    		cookie.setPath(path);//根据你创建cookie的路径进行填写 
    		response.addCookie(cookie); 
		} catch (Exception e) {
			System.out.println("删除错误");
			e.printStackTrace();
		}
    	System.out.println("删除本地浏览器的Cookie");
    }
    
    public static void clearCookie(HttpServletRequest request,HttpServletResponse response, String path) {
    	 
    	Cookie[] cookies = request.getCookies();
    	 
    	try{
    		for(int i=0;i<cookies.length;i++) {
    			System.out.println(cookies[i].getName() + ":" + cookies[i].getValue());
    			Cookie cookie = new Cookie(cookies[i].getName(), null);
    			cookie.setMaxAge(0);
    			cookie.setPath(path);//根据你创建cookie的路径进行填写
    			response.addCookie(cookie);
    		}
    	}catch(Exception ex) {
    		System.out.println("删除Cookies发生异常！");
    		}
    	 
    }

    
    /**
    *
    * 获取cookie的值放入到购物车实体
    * @param request
    * @return
    */
    public static List<Cart> getCookieCart(HttpServletRequest request,SessionInfo sessionInfo){
    	String cookie = getCookieByName(request, ResourceUtil.getCookieCart());
    	List<Cart> list = new ArrayList<Cart>();
    	Cart cart ;
    	String[] carts = cookie==null?null:cookie.split("!");
    	if (carts != null) {
    		for (int i = 0; i < carts.length; i++) {
        		String[] str = carts[i].split("-");
    			cart = new Cart();
				cart.setItemId(str[0]);
//    			cart.setGoodsId(str[0]);
    			cart.setGoodsNum(Integer.valueOf(str[1]));
    			cart.setCreateIp(sessionInfo==null?null:sessionInfo.getIp());
    			cart.setCreateTime(new Date());
    			cart.setUserId(sessionInfo==null?null:sessionInfo.getUserId());
    			cart.setUserType(sessionInfo==null?null:sessionInfo.getUserType());
    			list.add(cart);
    		}
		}
    	
    	return list;
    }
    
    /**
    *
    * 获取cookie中购物车中商品的数量总和
    * @param request
    * @param name cookie的名称
    * @return
    */
    public static Integer getCookieCartNum(HttpServletRequest request){
    	String cookie = getCookieByName(request, ResourceUtil.getCookieCart());
    	
    	String[] carts = cookie==null?null:cookie.split("!");
    	Integer num = 0;
    	if (carts != null) {
    		for (int i = 0; i < carts.length; i++) {
        		String[] str = carts[i].split("-");
        		num = num +Integer.valueOf(str[1]);
    		}
		}
    	
    	return num;
    }
}
