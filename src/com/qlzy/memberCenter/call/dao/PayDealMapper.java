package com.qlzy.memberCenter.call.dao;

import com.qlzy.model.PayDeal;

public interface PayDealMapper {
	
    public int insert(PayDeal record);

    public int insertSelective(PayDeal record);

    public PayDeal selectByPrimaryKey(String id);

    public int updateByPrimaryKeySelective(PayDeal record);

	/**
	 * 根据银行支付的序列号查询数据库已经存在的信息
	* @Title: selectByDealId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param dealId
	* @param @param type
	* @param @return    设定文件
	* @return payDeal    返回类型
	* @author 周张豹
	*/
	public PayDeal selectByDealId(PayDeal payDeal);

    public PayDeal selectByOrderNum(String dealOrder);
}