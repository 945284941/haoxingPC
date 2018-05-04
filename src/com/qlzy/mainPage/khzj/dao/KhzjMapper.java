package com.qlzy.mainPage.khzj.dao;
import java.util.List;

import com.qlzy.model.Khzj;

public interface KhzjMapper {
    int insert(Khzj record);
    int insertSelective(Khzj record);
    /**
     * 
    
    * @Title: gainKhzjAll 
    
    * @Description: TODO(查看所有的口号信息) 
    
    * @param @return    设定文件 
    
    * @return List<Khzj>    返回类型 
    
    * @throws
     */
    List<Khzj> gainKhzjAll();
    /**
     * 
    
    * @Title: gainKhzjListByTel 
    
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    
    * @param @param tpTelphone
    * @param @return    设定文件 
    
    * @return List<Khzj>    返回类型 
    
    * @throws
     */
	List<Khzj> gainKhzjListByTel(String tpTelphone);
}