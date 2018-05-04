package com.qlzy.memberCenter.call.dao;

import com.qlzy.model.TradePayDeail;


public interface TradePayDeailMapper{

	void updateBySelective(TradePayDeail payDeail);

	TradePayDeail gainPObyOrderNum(String orderNum);

	void insertSelective(TradePayDeail payDeail);

	TradePayDeail gainPayDeailPoByOrderId(String orderId);
	
	void updateByOrderId(TradePayDeail payDeail);

	void upadteOrderPayType(TradePayDeail tradePayDeail);

}