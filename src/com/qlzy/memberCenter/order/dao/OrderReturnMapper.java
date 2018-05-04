package com.qlzy.memberCenter.order.dao;

import com.qlzy.model.OrderReturn;

public interface OrderReturnMapper {
    public int deleteByPrimaryKey(String id);

    public int insertSelective(OrderReturn record);

    public OrderReturn selectByPrimaryKey(String id);

    public int updateByPrimaryKeySelective(OrderReturn record);

	/**
	 * 更新退单申请中的状态，此时可能存在多个申请，这里更新为待退款的
	* @Title: updatePayStatus
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param orderReturn    设定文件
	* @return void    返回类型
	* @author 周张豹
	*/
	public void updatePayStatus(OrderReturn orderReturn);

	public OrderReturn gainByOrderId(String id);

    
}